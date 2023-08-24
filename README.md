# Compiladores

Trabalho para a disciplina de compiladores.

Academico: [José A. Q. C. Gomes `@JoseComparotto`](https://github.com/JoseComparotto)

Professor: [Sidney Maldonado `@SidneyMaldonado`](https://github.com/SidneyMaldonado)

Universidade: Uniderp Matriz - Campo Grande, MS

Curso: Engenharia da Computação - Noturno

Perído: 2023.1 - 3º Semestre

## Àrvore do Projeto

```
📦 compiladores
├─ docs
│  ├─ jcup
|  |  └─ gramatica.cup  <-- Definição da gramática  
│  └─ txt
│     ├─ exemplo.txt    <-- Código-fonte de teste 
│     └─ ...
├─ src
│  ├─ main
│  │  └─ java
│  │     └─ me
│  │        └─ josecomparotto
│  │           └─ compilador
│  │              ├─ App.java               <-- Classe principal
│  │              ├─ ...
│  │              ├─ lexical
│  │              │  ├─ Dictionary.java     <-- Definição dos tokens
│  │              │  └─ ...
│  │              ├─ syntax         <-- Analisador sintático gerado pelo JCup
│  │              └─ semantic       <-- Classes de objetos semânticos
|  | 
│  └─ test
│     └─ java
│        └─ me
│           └─ josecomparotto
│              └─ compilador
│                 ├─ CompileJCupGrammar.java    <-- Compila o arquivo gramaica.cup
│                 └─ RunExempleTest.java        <-- Roda o arquivo de teste exemplo.txt
```

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

Caracteres: `ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_=:+-*/><!.(){};"?`

### Dicionário: Lista de palavras reservadas

| Valor         | Descrição                 | Função                        |
|---------------|---------------------------|-------------------------------|
| `kaku`        | Escreva                   | Comando de saída              |
| `tameni`      | Para                      | Estrutura de repetição        |
| `kara`        | De                        | Valor inicial da repetição    |
| `made`        | Ate                       | Valor final da repeição       |
| `ho`          | Passo                     | Salto da repetição            |
| `moshi`       | Se                        | Estrutura condicional         |
| `soreigai`    | Senao                     | Estrutura de negação          |
| `shin`        | Verdadeiro                | Valor literal lógico          |
| `nise`        | Falso                     | Valor literal lógico          |
| `mo`          | E                         | Operador lógico               |
| `mata`        | Ou                        | Operador lógico               |
| `shinai`      | Nao                       | Operador lógico               |
| `:=`          | Atribuição                | Comando                       |
| `+`           | Adição                    | Operador aritmético           |
| `-`           | Subtração                 | Operador aritmético           |
| `*`           | Multiplicação             | Operador aritmético           |
| `/`           | Divisão                   | Operador aritmético           |
| `>`           | Maior que                 | Operador relacional           |
| `<`           | Menor que                 | Operador relacional           |
|`>=`           | Maior ou igual a          | Operador relacional           |
|`<=`           | Menor ou igual a          | Operador relacional           |
|`==`           | Igual                     | Operador relacional           |
|`!=`           | Diferente                 | Operador relacional           |
|`(`            | Abertura de parenteses    | Estrutura de precedência      |
|`)`            | Fechamento de parenteses  | Estrutura de precedência      |
|`{`            | Abertura de bloco         | Estrutura de contexto         |
|`}`            | Fechamento de bloco       | Estrutura de contexto         |
|`;`            | Ponto e vírgula           | Marcador de final de comando  |
|`.`            | Ponto                     | Operador de concatenação      |
|`?`            | Interrogação              | Entrada de valor              |
|`??`           | Interrogação dupla        | Entrada de linha              |
