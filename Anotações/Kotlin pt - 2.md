## 2º Anotações Kotlin

### Operadores Aritméticos

Em Kotlin temos as expressões normalmente utilizadas nas outras linguagem mas também podemos utilizar alguns comandos. Os operadores podem ser chamados como expressão ou comando e o resultado será o mesmo. A função de soma também funciona para strings.

| Função   | Expressão | Comando   | Atribuição|
| ---------| --------- | --------- | --------- |
| Soma     |   a + b   | a.plus(b) | a += b    |
| Subtração|   a - b   | a.minus(b)| a -= b    |
| Divisão  |   a / b   | a.div(b)  | a /= b    |
| Resto    |   a % b   | a.rem(b)  | a %= b    |
|Multiplicação | a * b  | a.times(b)| a *= b    |


Exemplos de utilizações: 

~~~kotlin 

 var A = 10
 var B = 20
    
 println(A.plus(B))   // 30
 println(A.minus(B))  // -10
 println(A.times(B))  // 200
 println(A.div(B))    // 0
 println(A.rem(B))    // 10
~~~

### Operadores comparativos

 Em Kotlin podemos utilizar os operadores padrões mas também alguns comandos da linguagem

 | Função    | Expressão  | Comando           |
 | ------    | ---------- | ------------------|
 | maior     | a > b      | a.compareTo(b) > 0| 
 | menor     | a < b      | a.compareTo(b) < 0| 
 | igual     | a == b     | a.equals(b)       |
 | diferente |a != b      | !(a.equals(b))    |

 Os comandos _compareTo_ retornam os seguintes valores

 - **-1** : Quando o resultado for menor que.
 - **0**  : Quando o resultado for igual.
 - **1**  : Quando o resultado for maior que

 Caso utilizamos os operadores o resultado será booleanos e o comando equals também nos retornará boleanos, exemplos:

 ~~~kotlin 
  var A = 10
  var B = 20

println(A.compareTo(B))  // -1
println(A > B)           // false
println(A.equals(B))     // false
println(!A.equals(B))    // true
 ~~~


### Operadores lógicos

Temos também os comparativos lógicos utilizando expressões e comandos:  

- Expressão: E **&&**  comando: (expressão1) **and** (espressão2)

- Expressão: **OU** || comando: expressão1) **or** (espressão2)


### Operadores IN e Range

Podemos verificar os valores em uma lista ou até mesmo criar um range de valores.

| Contém | Não Contém | Range/faixa de valores |
|--------| -----------| -----------------------|
| In     |      !In   |       (Int...Int)      |


Exemplo de utilizações: 

~~~Kotlin 
 var numeros = listOf(4,5,8,7)
  
  println(numeros)	   // [4, 5, 8, 7]
  println(12 in numeros)   // false
  println(12 !in numeros)  // true
  println(12 in 0..11)     // false
~~~
