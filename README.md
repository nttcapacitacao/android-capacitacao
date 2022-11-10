# NTT DATA Knowleged
<html>
<body>
<h1>Bem vindo! aqui vc encontra alguns passos par ajudar no seu conhecimento inicial.</h1>

## Primeiros passos

<h2>Explicação da arquitetura do projeto</h2>

- Clean architecture com
MVVM [referência](https://medium.com/swlh/clean-architecture-in-android-a-beginner-approach-be0ce00d806b)

## Conceitos SOLID aplicados no projeto

<h3>Camadas</h3>
<details>
<summary><b>API</b></summary>
<p>Objetos de request</p>
<code>
ObjectRequest(</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("id") val id: String?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("code") val code: String?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("action") val action: String?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("category") val category: String?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("category_option") val categoryOption: String?</br>
)</br>
</code>
<p>Objetos de response</p>
<code>
data class ObjectResponse(</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("id") val id: String?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("code") val code: String?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("title") val title: String?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("timer") val timer: Long?,</br>
&nbsp&nbsp&nbsp&nbsp @SerializedName("options") val options: FeedBackOptionsResponse?</br>
)</br>
</code>
<p>Objetos de negócios BO</p>
<code>
@Parcelize
data class ObjectBO(
val id: String,
val code: String,
val title: String,
val timer: Long,
val options: ObjectOptionsBO
) : Parcelable
</code>
<p>Objetos de view VO</p>
<code>
@Parcelize
data class ObjectVO(
val title: String,
val options: ObjectOptionsVO
) : Parcelable
</code>
<p>Mapper de response para BO</p>
<code>
fun toObjectBO(): ObjectBO {
return ObjectBO(
title = title,
options = options.toObjectBO()
)
}
</code>
<p>Mapper de BO para VO</p>
<code>
fun toObjectVO(): ObjectVO {
return ObjectVO(
title = title,
options = options.toObjectVO()
)
}
</code>
</details>

<details>
<summary><b>Repository</b></summary>
<p>Conceitos de chamadas para API</p>
<p>Responsabilidades do repository</p>
<p>Utilizando flows para chamadas</p>
<p>Obtendo response e fazendo rapper para BO</p>
</details>

<details>
<summary><b>Use Case</b></summary>
<p>Conceitos de UseCase</p>
<p>Responsabilidades do UseCase</p>
<p>Utilizando UseCase para solicitações ao Repository</p>
</details>

<details>
<summary><b>Criação de uma chamada para API</b></summary>
<p>Criação de objetos de requestada</p>
<p>Criação de objetos de response</p>
<p>Criação de objetos BO</p>
<p>Criação de objetos VO</p>
</details>

<details>
<summary><b>Criação do Repository</b></summary>
<p>Criando primeira chamada para API</p>
<p>Obtendo response da chamada</p>
<p>Mapper do response par objeto BO</p>
<p>Utilização de flow para chamada API</p>
</details>

<details>
<summary><b>Criação do UseCase</b></summary>
<p>Criando comunicação com Repository</p>
<p>Executando função de comunicação comRepository</p>
</details>

<details>
<summary><b>Activity</b></summary>
-  <h2>Criando Primeira Activity sem injeção de dependência</h2>
<p>Criando primeiro Layout</p>
<p>Conceitos de constraint Layout</p>
</details>

</body>
</html>
