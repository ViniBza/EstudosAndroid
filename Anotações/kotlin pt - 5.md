## 5º Anotações Kotlin

### Estrutura de repetições

Temos as estrururas similares as demais linguagens, While, do..while, for e forEach. Porem em kotlin podemos também utilizar os comandos in, range, until, downTo e step.

 **Estrutura**: for (index **in/until/downTo** faixa de valores/ condicional **step** intervalo).

- **in**: conta do valor inicial até o valor final estabelecido:

~~~kotlin
  for (i in 0..5){
        println("$i")
    } // 0, 1, 2, 3, 4, 5
~~~

- **Until**: conta do valor atual até o valor estabelecido -1:

~~~kotlin
  for (i in 0 until 5){
        println(i)
    } // 0, 1, 2, 3, 4
~~~

- **DonwTo**: conta de maneira decrescente:

~~~kotlin
    for (i in 5 downTo 0){
        println(i)
    } // 5, 4, 3, 2, 1, 0 
~~~

- **Step**: determina o intervalo da contagem:

~~~kotlin 
for (i in 0..5 step 2){
        println(i) // 0, 2, 4
    } 
~~~

- **letters**: podemos percorrer uma string/array e imprimir cada letra com base no tamanho por exemplo:

~~~kotlin 
 val nomeCompleto = "vinicio barbosa"
    for (l in nomeCompleto){
        println(l.toUpperCase()) }
    } // VINICIO BARBOSA    
~~~
