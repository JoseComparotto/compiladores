# Compiladores

Trabalho para a disciplina de compiladores.

Academico: [José A. Q. C. Gomes `<jose.augusto.comparotto@gmail.com>`](mailto:jose.augusto.comparotto@gmail.com)

Professor: [Sidney Maldonado `<sidneymaldonado@gmail.com>`](mailto:sidneymaldonado@gmail.com)

Universidade: Uniderp Matriz - Campo Grande, MS

Curso: Engenharia da Computação

Perído: 2023.1 - 3º Semestre

## Linguagem J++ (Japan Plus Plus)

O objetivo deste trabalho é desenvolver um compilador, em Java, para a linguagem "J++", que é inspirada na linguagem "C", porém em Japonês.

### Exemplos

Exempo 1: Código-fonte de um programa escrito na linguagem **C**.

```c
#include <stdio.h>

int main(){
    int x, resultado;

    printf("Informe um numero natural: ");

    scanf("%d", &x);

    if ( x < 0 ) {
        printf ("Numero invalido");
    } else {

        resultado = 1;
        
        for(int i = 1; i < x; i++) {

            resultado = resultado * i;

        }

        printf("%d! = %d", x, resultado);
    }

    return 0;
}
```

Exemplo 2: Código-fonte do mesmo programa escrito na linguagem **J++**.

```jpp
kaku("Informe um numero natural: ");

x := ?;

moshi ( x < 0 ) {
    kaku ("Numero invalido");
} soreigai {

    resultado := 1;
    
    tameni i kara 1 made x ho 1 {

        resultado := resultado * i;

    }

    kaku (x . "! = " . resultado);

}
```

### Alfabeto: Lista de caracteres aceitos

Caracteres: `ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_=:+-*/><!.,(){};"?`

Expressão Regular: `/[A-Za-z0-9\_\=\:\+\-\*\/\>\<\!\.\(\)\{\}\;\"\?]/g`

### Dicionário: Lista de palavras reservadas

* `kaku`
* `tameni`
* `kara`
* `made`
* `ho`
* `moshi`
* `soreigai`
* `shin`
* `nise`
* `mo`
* `mata`
* `shinai`
* `:=`
* `+`
* `-`
* `*`
* `/`
* `>`
* `<`
* `>=`
* `<=`
* `==`
* `!=`
* `(`
* `)`
* `{`
* `}`
* `;`
* `.`
* `?`
* `??`

### Gramática

#### Identificador de variaveis: `<identifier>`

`<identifier> = <letter>, { <alpha> };`

#### Constantes `<const>`

`<const> = <text-literal> | <number-literal> | <bool-literal>;`

#### Literais Numéricos `<number-literal>`

`<number-literal> = { <digit> } | { <digit> }, '.', { <digit> };`

#### Literais Lógicos `<bool-literal>`

`<bool-literal> = 'shin' | 'nise';`

#### Literais de Texto `<text-literal>`

`<text-literal> = '"', { <any> - '"' }, '"';`

#### Operadores Aritiméticos Aditivos `<aritm-add-operator>`

`<aritm-add-operator> = '+' | '-';`

#### Operadores Aritiméticos Multiplicativos `<aritm-mult-operator>`

`<aritm-mult-operator> = '*' | '/';`

#### Operadores Relacionais `<rel-operator>`

`<rel-operator> = '==' | '!=' | '<=' | '>=' | '<' | '>';`

#### Operador Lógico de Disjunção (OU) `<logic-or-operator>`

`<logic-or-operator> = 'mata';`

#### Operador Lógico de Conjunção (E) `<logic-and-operator>`

`<logic-and-operator> = 'mo';`

#### Operador Lógico de Negação (NÃO) `<logic-not-operator>`

`<logic-not-operator> = 'shinai';`

#### Qualquer caractere `<any>`

`<any> = <alpha> | <special> | <blank>;`

#### Caracteres Alfanumérico `<alpha>`

`<alpha> = <letter> | <digit>;`

#### Caracteres Numérico `<digit>`

`<digit> = '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';`

#### Caracteres de letras `<letter>`

`<letter> = '_' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z';`

#### Caracteres Especiais `<special>`

`<special> = '=' | ':' | '+' | '-' | '*' | '/' | '>' | '<' | '!' | '.' | ',' | '(' | ')' | '{' | '}' | ';' | '"';`

#### Caracteres Invisíveis `<blank>`

`<blank> = ' ' | '\n' | '\t';`
