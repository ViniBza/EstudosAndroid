##2º Anotações Kotlin

### Manipulação de String

As String possuem diversos métodos associados, indexação, concatenação, comparação e formatação. Pode também ser concatenado com o plus e também pode ser tratada como um array de char.

#### Indexação
Podemos acessar determinadas posições do array através de algumas funções que temos no kotlin:

- **first()** : Acessar a 1º posição do array
- **last()**  : Acessar a última posição 
- **String.length** : acessar quantas posições temos no array
- **String.[index]**: acessar determinada posição do array

~~~kotlin 
val nome = "Vinicio B"
   println(nome.first())        // V
   println(nome.last())         // B
   println(nome.length)         // 9
   println(nome[2])             // n 
~~~

### Concatenação 

Para concatenar as Strings podemos utilizar **plus/+** e para acessar as variáveis podemos utilizar o **sifrão** por fim caso precisamos acessar uma variável e algum método podemos utilizar **${}**:

~~~kotlin
val nome = "Vinicio B"
   println(nome.plus("!"))               // Vinicio B!
   println("Bom dia: $nome")             // Olá Vinicio B
   println("Boa tarde: " + nome)         // Boa tarde: Vinicio B
   println("Boa noite ${nome}")          // Boa noite Vinicio B
   println("Olá ${nome.toLowerCase()}")  // Olá vinicio b
~~~

### Formatação 

Por fim temos alguns métodos de formatação, existe vários no Kotlin por exemplo de alterar formatação, remover espaços, substituir caracteres e etc. Um exemplo: 

~~~kotlin
val nome = "Vinicio "
val sobrenome = "Barbosa"  
   println(nome.plus(sobrenome))            // Vinicio Barbosa
   println("Ola ${nome.toUpperCase()}")     // Ola VINICIO
   println("ola $nome$sobrenome")           // ola Vinicio Barbosa
   println("ola ${nome.trim()}$sobrenome")  // ola VinicioBarbosa
~~~

