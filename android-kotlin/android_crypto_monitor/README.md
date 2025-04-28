# Crypto Monitor

O projeto **Crypto Monitor** realiza requisições no **MercadoBitcoin** para trazer o valor atualizado de moedas e exibi-los em tela.

## Estrutura do Projeto

### Service

O service neste projeto representa o contrato firmado com uma API externa, definindo a URL, método HTTP, retorno e envio.

Em `MercadoBitcoinService`, definimos uma chamada assíncrona para o endpoint `api/BTC/ticker/`, utilizando uma **coroutine** para evitar o travamento do aplicativo enquanto a busca não é finalizada. O retorno esperado é um objeto do tipo `TickerResponse`.

### Service Factory

O `ServiceFactory` implementa o contrato de service, definindo como a chamada será construída, convertida e com qual biblioteca.

Em `MercadoBitcoinServiceFactory`, é criada uma instância do **Retrofit** (biblioteca para requisições HTTP), configurando:
- O domínio da API externa: `https://www.mercadobitcoin.net/`
- A classe de conversão: `GsonConverterFactory` (responsável por converter o retorno JSON para objetos Kotlin e vice-versa)

Depois de criado o objeto Retrofit com essas configurações, é informado o contrato `MercadoBitcoinService`, que definirá:
- O restante da URL (concatenado com o domínio configurado)
- O objeto que será transformado no retorno
- O método HTTP a ser utilizado

### MainActivity

O `MainActivity` define a activity/tela principal do aplicativo.

Nele, definimos que será uma `AppCompatActivity`, o que nos fornece:
- Suporte para temas
- Suporte a barras e dark mode
- Retrocompatibilidade com versões Android mais antigas

Configuramos o conteúdo da página a partir dos resources, puxamos o estilo de elementos como a toolbar e botões, e também configuramos eventos, como o **onClick**.

No aplicativo:
- Ao clicar no botão, uma coroutine é iniciada para fazer a requisição à API do MercadoBitcoin.
- Em caso de sucesso: a data e o valor na tela são atualizados com o retorno da API.
- Em caso de falha: uma mensagem temporária é exibida informando o erro da requisição.

### Model

O model define os campos e seus respectivos tipos de dados.

Em `TickerResponse` e `Ticker`, definimos os campos que queremos mapear do retorno da API do **MercadoBitcoin**.

---

## Evidências de teste

![KOTLIN_CK-02_Crypto_Monitor_01](https://github.com/user-attachments/assets/fe21611c-2752-4788-8f15-6eaf85b6b4ed)
![KOTLIN_CK-02_Crypto_Monitor_02](https://github.com/user-attachments/assets/84607a22-ea7c-4eff-aca9-f8ac9f77ac2f)

---

> Projeto desenvolvido para consultas de valores de criptomoedas em tempo real usando Kotlin, Retrofit e Coroutines.
