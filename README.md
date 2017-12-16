# Agenda
Aplicativo agenda de contatos para a disciplina de Tópicos em Informática 12 - Desenvolvimento Mobile, da UFSCar.

## Requisitos do sistema:
O App de agenda deve conter:


* Splash Screen e Login Activity:
    * Atividade de abertura do App (Splash Screen) exibindo sua logomarca;
    * Após a atividade de abertura deve ser exibido uma atividade de login com campo para usuário e senha e um botão para acessar o sistema
    * Ao clicar no botão deve-se verificar se os campos de usuário e senha não estão vazios e se possuem o mesmo valor. Caso essas duas condições forem verdadeiras o acesso ao sistema é liberado
    
* A próxima atividade após o login é a atividade de exibição de contatos. Com:
    * RecyclerView personalizado exibindo foto, nome e telefone dos usuários já adicionados
    * Ao clicar em algum item deve ser aberta a tela de cadastro com suas informações
    * Botão na barra do aplicativo (Action Bar) para acessar a atividade de cadastro de contatos
    * Ao clicar neste botão deve ser aberta a tela de cadastro para inserir um novo contato
    
* A atividade de cadastro de contatos deve conter os seguintes campos/funcionalidades:
    * Campos para nome, endereço, telefone e e-mail
    * Botão para tirar foto do contato
    * Ao clicar neste botão o app deve capturar uma imagem que será salva para aquele contato
    * Botão para exibir mapa com endereço digitado
    * Ao clicar neste botão um mapa deve ser executado marcando o local do endereço digitado
    * Botão de salvar na barra do aplicativo
    * Ao clicar neste botão as informações digitadas devem ser salvas em uma entidade de contato e adicionadas à lista de contatos. Não é necessário persistir os dados, basta somente adicioná-los na memória RAM do dispositivo. Toda vez que o app for reiniciado as informações são perdidas

## Créditos de bibliotecas externas:
* [ButterKnife](https://github.com/JakeWharton/butterknife)

* [CircleImageView](https://github.com/hdodenhof/CircleImageView)

## Alunos
* André Levi Zanon
* Rodrigo Ferrari de Souza

## Professores 
* Bruno De Azevedo Mendonça
* César Teixeira
