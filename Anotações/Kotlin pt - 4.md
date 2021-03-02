### 4º Anotações Kotlin

### Empty x Blank Métodos de comparação


 Como saber se uma String está vazia, em branco ou nula? Podemos utilizar os seguintes métodos: 

 - **isBlank** : podemos utilizá-lo para verificar se uma string está em branco. Se o tamanho da string _(texto.length)_ for _0_, estará **Empty e Blank.**

 ~~~Kotlin
var texto = ""
println(texto.isBlank()) // true
 ~~~ 

 - **isEmpty()** : podemos utilizar para saber se a string está vazia. Se o tamanho for _> 0_ mas os todos os caracteres estiver em _branco_, significa que a mesma estara **Blank mas não Empty.**  

 ~~~kotlin
var texto = "   "
println(texto.isEmpty()) // false
~~~

Nesse exemplo temos uma string em branca pois não temos nenhum texto na variável, porém temos vários espaços isso significa que a string não está vazia.

 
 ### Introdução a Funções
 
 Em Kotlin criamos as funções com a seguinte strutura: **Fun nomeDaFuncao(nome:tipo):TipoRetorno{}**. Alguns exemplos de funções:

 - Criando uma função padrão:

 ~~~Kotlin 
private fun getFullname(name:String, lastName:String):String{
    val fullName = "$name $lastName"
    return fullName
}
 ~~~

 - Simplificando o retorno: 

 ~~~Kotlin 
private fun getFullname(name:String, lastName:String):String{
    return "$name $lastName"
}
 ~~~

 - Exemplo de função **single-line**

 ~~~Kotlin 
private fun getFullname(name:String, lastName:String) = "$name $lastName"
}
 ~~~


### Estrutura de controle

Em Kotlin temos vários tipos de estrutura, podemos utilizá-las para controle ou até mesmo para atribuição. Por fim pode ser encadeada com múltiplas estrturas: 

- **if/else** : estrutura padrão iguais das outras linguagens. Por recomendação se precisar-mos encadear mais de 3 expressões no if, o ideal é converter para o when.

~~~kotlin
val A = 10
val B = 20
if ( A > B ){
println("A é maior que B") }
 else {
println("B é maior que A") }

// B é maior que A
~~~

- **when** : essa estrutura lembra bastante o swtich case das demais linguagens, no kotlin utilizamos ela da seguinte forma : 

~~~kotlin
var A = 10
var B = 10
    
    when {
        A > B -> {
            println("A é maior") }
        B > A -> {
            println("B é maior") }       
        else -> {
            println("Os números são iguais") }      
    	}

 //Os números são iguais       
~~~

- **elvis operator**: podemos validar valores nulos e fornecer alguma alternativa para o uso desse valor, por exemplo:

~~~kotlin
val A:Int? = 10 
var B = a ?: 5    
println(B) // valor de B é 10
~~~

Basicamente estamos validando o valor de A antes de atribuir para B, primeiro o operador verifica se existe valor em A se não houvesse nenhum valor ou seja null, B iria receber o valor 5.


### Atribuição

Para realizarmos atribuições o valor atribuído tem que estar na útilma linha do bloco: 

~~~kotlin
val a = 20
val b = 50
    
    val minValue = if(a > b){
        println("b ($b) é o menor valor.")
        b
    }else if (b > a){
        println("a ($a) é o menor valor.")
        a
    }else{
        println("Os valores são iguais.")
        b
    }
~~~

A condicional pode não usar chaves caso ela faça apenas atribuições: 

~~~kotlin 
val a = 20
val b = 20
    
val minValue if(a < b) a else if(a > b) b else b

// O minValue recebera a última expressão pois os valores são iguais
~~~



