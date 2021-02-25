## 1º Anotações Kotlin

#### Tipos de dados 
 
 <p> Em Kotlin temos os seguintes tipos de variáveis, listarei apenas alguns dos tipos: </p>

 - String : que recebe texto 
 - Bolean : receber true ou false
 - Array  : recebe uma matriz
 - Float  : recebe números de ponto flutuante
 - Int   :  recebe número inteiros
 - Null   : podemos atribuir nullo para alguns valores

 <p> Temos algumas funções que nos auxilia bastante que são: 

 *Max Value*: em que podemos capturar os valores máximo das variáveis. </p>


~~~kotlin 
    println(Int.MAX_VALUE)      // 2147483647
    println(Long.MAX_VALUE)     // 9223372036854775807
    println(Byte.MAX_VALUE)     // 127
    println(Short.MAX_VALUE)    // 32767
~~~ 


*Converção de dados*: converter os tipos de dados bem facilmente apenas chamando a função _.to_ em seguido do tipo que queremos: 


~~~kotlin
var A = Long.MAX_VALUE
var B = Short.MAX_VALUE

println(A) // 9223372036854775807
println(B) // 32767
    
println(A.toInt()) // -1
println(B.toInt()) // 32767
~~~


### Declaração de variáveis

 <p> Em Kotlin temos as seguintes variáveis que podemos utilizar junto com seu padrão de nomeclatura: </p>

 - *Var* (Valor mutável, CamelCase) : esse tipo de variável tem seu valor definido e alterado durante a execução.

 ~~~Kotlin
var currentAge = 22
var currentAge:Int?
currentAge = null ou 22
 ~~~

 - *Val* (Valor Imutável, camelCase) : esse tipo de variável funciona de maneira similar ao val do java, podemos criar a variável e atribuir seu valor posteriormente porém 1º vez atribuido não podemos mais modificalo. Seu valor é definido durante a execução.

 ~~~Kotlin
val currentAge = 22
val currentAge:Int?
currentAge = null ou 22
 ~~~

 - *Const Val* (Valor imutável, SNAKE_CASE) : como o próprio nome sugere é uma constante, assim que criarmos temos que definir seu valor e tipo. Seu valor é definido durante a compilação.

  ~~~Kotlin
const val MIN_AGE = 16
const val MAX_AGE = 68
 ~~~

> Observações: 1º Ao criarmos uma variável e inserimos seu valor o Kotlin está atribuindo uma Inferência de tipo, ou seja seu valor e seu tipo é definido com base na sua prieira atribuição.  2º o sinal de ? após o tipo significa que a variável aceita um valor nullo.


 

