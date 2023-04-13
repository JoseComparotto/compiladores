# Compiladores

Trabalho para a disciplina de compiladores.

Academico: [José A. Q. C. Gomes `<jose.augusto.comparotto@gmail.com>`](mailto:jose.augusto.comparotto@gmail.com)

Professor: [Sidney Maldonado `<sidneymaldonado@gmail.com>`](mailto:sidneymaldonado@gmail.com)

Universidade: Uniderp Matriz - Campo Grande, MS

Curso: Engenharia da Computação

Perído: 2023.1 - 3º Semestre

## Linguagem CBR

O objetivo deste trabalho é desenvolver um compilador, em Java, para a linguagem "CBR", que é inspirada na linguagem "C", porém em português.

### Exemplos

Exempo 1: Código-fonte de um programa escrito na linguagem **C**.

```c
int x;
int y;
int i;

scanf("%d", &x);

y = x * 2;

for (i=0;i<y;i++){

    if (i>10){
        printf("%d passou de 10", i);
    }

}
```

Exemplo 2: Código-fonte do mesmo programa escrito na linguagem **CBR**.

```
inteiro x;
inteiro y;
inteiro i;

leia(x);

y = x * 2;

para i de 0 ate y passo 1 {

    se ( i > 10 ){
        escreva("%d passou de 10", i);
    }

}
```

### Alfabeto: Lista de caracteres aceitos

Caracteres: `abcdefghijklmnopqrstuvwxyz0123456789_=+-*/><!.(){};"`

Expressão Regular: `/[a-z0-9\_\=\+\-\*\/\>\<\!\.\(\)\{\}\;\"\n ]/g`

### Dicionário: Lista de palavras reservadas

* `leia`
* `escreva`
* `para`
* `de`
* `passo`
* `se`
* `senao`
* `inteiro`
* `texto`
* `real`
* `logico`
* `verdadeiro`
* `falso`
* `e`
* `ou`
* `nao`
* `=`
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

### Gramática Léxica

#### Identificadores `<identifier>`

EBNF: `<identifier> ::= <nondigit> | <identifier> <alpha>`

RegExp: `/[_a-z][_a-z0-9]*/`

##### Caracteres numéricos `<digit>`

EBNF: `<digit> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9`

RegExp: `/[0-9]/`

##### Caracteres não-numericos `<nondigit>`

EBNF: `<nondigit> ::= _ | a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z`

RegExp: `/[_a-z]/`

##### Caracteres Alfanuméricos `<alpha>`

EBNF: `<alpha> ::= <nondigit> | <digit>`

RegExp: `/[_a-z0-9]/`

#### Literais `<literal>`

EBNF: `<const> ::= <text-literal> | <integer-literal> | <float-literal> | <bool-literal> `

##### Inteiros `<integer-literal>`

EBNF: `<integer-literal> ::= <digit> | <integer-literal> <digit>`

RegExp: `/[0-9]+/`

##### Reais `<float-literal>`

EBNF: `<float-literal> ::= <integer-literal> | <integer-literal> . <integer-literal>  `

RegExp: `/[0-9]+/`

##### Lógicos `<bool-literal>`

EBNF: `<bool-literal> ::= verdadeiro | falso`

RegExp: `/[_a-z]/`

##### Texto `<text-literal>`

RegExp: `/"((?:\\(u[0-9a-f]{4}|[0-7]{3}|x[0-9a-f]{2}|[btnfr'"\\]))|[^\"\n\\])*"/i`

#### Operadores `<ope>`

EBNF: `<ope> ::= <assign-operator> | <aritm-operator> | <rel-operator> | <logic-operator>`

##### Atribuição `<assign-operator>`

EBNF: `<assign-operator> ::= =`

RegExp: `/=/`

##### Aritiméticos `<aritm-operator>`

EBNF: `<aritm-operator> ::= + | - | * | /`

RegExp: `/[\+\-\*\/]/`

##### Relacionais `<rel-operator>`

EBNF: `<rel-operator> ::= == | != | <= | >= | < | >`

RegExp: `/==|!=|<=|>=|<|>/`

##### Lógicos `<logic-operator>`

EBNF: `<logic-operator> ::= nao | e | ou`

RegExp: `/nao|e|ou/`

#### Tipos primitivos `<type>`

EBNF: `<type> ::= inteiro | real | texto | logico`
RegEx: `/inteiro|real|texto|logico/`
