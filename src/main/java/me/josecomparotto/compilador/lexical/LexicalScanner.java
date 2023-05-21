package me.josecomparotto.compilador.lexical;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import java_cup.runtime.Symbol;
import me.josecomparotto.compilador.Helpers;

public class LexicalScanner implements java_cup.runtime.Scanner, Iterable<Token> {

    private final List<Token> tokens;

    public LexicalScanner(String source) {
        this.tokens = extractTokens(source);
    }

    public LexicalScanner(InputStream in) {
        this(Helpers.getString(in));
    }

    public Token[] getTokens(){
        return tokens.toArray(new Token[0]);
    }

    @Override
    public Symbol next_token() throws Exception {
        if(tokens.size() > 0) 
            return tokens.remove(0).getSymbol();    
        else
            return new Symbol(0);
        
    }

    @Override
    public Iterator<Token> iterator() {
        return tokens.iterator();
    }

    private static List<Token> extractTokens(String inputString) {

        // Guarda para cada posição, uma referencia para o token atribuído
        Token[] mask = new Token[inputString.length()];

        // Se a string de entrada for vazia...
        if (inputString.length() == 0)
            // Fim da recursão
            return new ArrayList<Token>();

        // Lista que será retornada:
        List<Token> finalTokens = new ArrayList<>();

        // Para cada símbolo da tabela de símbolos...
        for (Dictionary symbol : Dictionary.values()) {

            // Testando o símbolo atual
            Matcher m = symbol.matcher(inputString);

            // Para cada ocorrencia...
            while (m.find()) {
                String value = m.group();
                int tokenStart = m.start();
                int tokenEnd = m.end();

                Token token = new Token(symbol, value, tokenStart, tokenEnd);

                boolean reject = false;

                List<Token> replacables = new ArrayList<>();

                // Verifica se algum token conflitante já foi registrado
                // Obs.: Um conflito é caracterizado pela atribuição de uma mesma posição da
                // máscara para tokens diferentes
                for (int i = token.start; i < token.end; i++) {
                    Token registred = mask[i];
                    if (registred != null) {
                        // Se o token atual for maior que o já registrado...
                        if (token.length > registred.length) {
                            // Remove o token conflitante que é de menor tamanho
                            replacables.add(registred);
                            i = registred.end - 1;
                        } else {
                            // Caso contrato, o token atual será rejeitado
                            reject = true;
                            break;
                        }
                    }
                }

                if (!reject) {

                    // Remove os tokens conflitantes
                    for (Token replacable : replacables) {

                        finalTokens.remove(replacable);
                        for (int i = replacable.start; i < replacable.end; i++)
                            mask[i] = null;
                    }

                    // Registra o token atual na máscara
                    for (int i = token.start; i < token.end; i++)
                        mask[i] = token;

                    // Registra o token atual na lista de retorno
                    finalTokens.add(token);

                }
            }

        }

        int lastUnknownIndex = -1;

        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == null) {
                lastUnknownIndex = i;

            } else if (lastUnknownIndex != -1) {
                throw new RuntimeException(
                        "Token não identificado: '" + Helpers.escape(inputString.substring(lastUnknownIndex, i))
                                + "', em " + Helpers.toLineColumnAddress(lastUnknownIndex, inputString));
            }
        }

        return finalTokens.stream()
                .filter(t -> !t.symbol.equals(Dictionary.COMMENT) && !t.symbol.equals(Dictionary.BLANK))
                .sorted((a, b) -> a.start - b.start)
                .collect(Collectors.toList());
    }

}
