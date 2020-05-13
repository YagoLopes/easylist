# EasyListRest
----
Partirei do principio que você já tenha o versionador git em sua maquina,  se você ainda não o instalou, segue o link para fazer a instalação e configuração.

https://woliveiras.com.br/posts/instalando-o-git-windows/

# Como utilizar o git

1. Crie um diretorio em sua maquina em um local de sua preferencia. "Windows. Botão direito nova pasta, escolha um nome para a pasta "
2. Abra o bash do git dentro do diretorio criado. "Windows. Abra a pasta que você criou, click com o botão direito dentro da pasta e selecione a opção open git-bash here."
3. Digite o comando git clone https://github.com/YagoLopes/EasyListRest "Será criado um diretorio em sua pasta com o nome de EasyListRest"

# Como abrir o projeto no NetBeans

1. Abra o IDE NetBeans navegue até o canto superior esquerdo no menu Arquivo -> Abrir Projeto. "Sera aberto explorador de arquivo do seu sistema operacional."
2. Dentro do explorador navegue ate a pasta que você criou, execute um clique duplo sobre o projeto de nome EasyListRest. "O NetBeans fará a importação do modulos do seu projeto, Atenção isso pode demorara um pouco fique de olho no canto inferior esquerdo do IDE, pois ele avisará quando terminar de importar."


# Importando o banco de dados

1. Abra o browser de sua preferencia e acesse o endereço http://localhost/phpmyadmin/  ou  http://127.0.0.1/phpmyadmin/
2. Efetue o login com seu usuario e senha do MYSQL
3. Com o loguin já efetuado navegue até o menu lateral esquerdo e selecione a opção Novo BD,  no campo Criar banco de dados digite o nome easylist e selecione a opção criar.
4. Com o banco já criado, observe que no menu lateral esquerdo aparecerá um bando com o nome de easylist, click sobre ele.
5. No menu superior central selecione a opção Importar,click sobre o botão escolher arquivo. "Sera aberto explorador de arquivo do seu sistema operacional."
6. click sobre este link https://drive.google.com/file/d/16YY4_HwsNlNuJGvaVY9WFsKUwagRZK5a/view?usp=sharing "Sera baixado um arquivo .sql na sua pasta de download.
7. Com o explorador de arquivos aberto, navegue até a pasta de downloads e selecione o arquivo .sql que voce baixou.
8. Tecle enter ou navegue até o fim da pagina e clique em executar para execuatr o arquivo.

# Alterando o user e senha no arquivo DAO

1. Se você fechou o projeto, abra o novamente utilizando IDE NetBeans
2. Navegue nos caminhos EasyListRest -> Pacotes de Códigos-fonte -> br.com.easylist.daos abra o arquivo ListaDAO 
3. Apartir da 22° linha temos as strings de conexão com o banco, altere o user para seu usuario do mysql, e o password para sua senha do mysql e salve as alterações.


# Executando a api

1. Aperte a tecla F6 ou click no botão Executar Projeto para executar seu projeto
2. O IDE iniciará o servidor, e conectará ao seu banco de dados. "observe no console do IDE se tudo foi executado com exito"

# Vale resaltar que o projeto não possui interface, por isso o IDE retornara um erro ao buscar a rota no browser.

 Se você seguiu  todos os passos com atenção seu servidor já está em execução, basta fazer uma chamada com o metodo POST para o endereço http://localhost:"porta"/EasyListRest/produto passando no Body da requisição os dados atravez de um JSON. 


# Rotas API:

# PRODUTO
----
# Get (Buscar algum produto)
1. Deve inserir o metodo GET,
2. Utilize a rota fornecida plea api:
http://hostdaapi:porta/EasyListRest/produto/NomeDoProduto

# Delete (Deletar produto)
1. Deve inserir o metodo DELETE,
2. Em seguida inserir o ID do produto que deseja deletar do banco:
http://hostdaapi:porta/EasyListRest/produto/IdDoProduto

# Put (Alterar produto)
1. Deve inserir o metodo PUT,
2. Em seguida inserir o ID do produto que deseja alterar:
http://hostdaapi:porta/EasyListRest/produto/IdDoProduto
3. Em seguida deve inserir no corpoda requisição "body" os valor de TODOS os campos(mesmo os que nao deseja alterar)
```bash
	{
	"nome": "NomeDoProduto",
	"valor": "ValorDoProduto",
	"mercado": "MercadoQueComprouOProduto",
	"descricao": "DescricaoDoProduto",
	"comprovante": "ComprovanteDaCompraDoProduto",
	"listaID":"IdDaLista"
    	}
```

# Post (Criar produto)
1. Deve inserir o metodo Post,
2. Utilize a rota http://hostdaapi:porta/EasyListRest/produto
3. Preencha o corpo da requisição "body" com os dados que pretende cadastrar:
```bash
	{
	"nome": "NomeDoProduto",
	"valor": "ValorDoProduto",
	"mercado": "MercadoQueComprouOProduto",
	"descricao": "DescricaoDoProduto",
	"comprovante": "ComprovanteDaCompraDoProduto",
	"listaID":"IdDaLista"
	}
```

# USUÁRIO
----
# Get (rota de login)
1. Deve inserir o metodo GET,
2. Para efetuar login utilize a rota /usuario juntamente com os dados do login:
http://hostdaapi:porta/EasyListRest/usuario?email=yagolopeslazaro@gmail.com&password=123456

# Delete (Deletar usuario)
1. Deve inserir o metodo DELETE,
2. Em seguida inserir o endereço IP com o final especificando o ID do usuario que deseja deletar:
http://hostdaapi:porta/EasyListRest/usuario/4

# Put (Alterar usuario)
1. Deve inserir o metodo PUT,
2. Em seguida inserir o ID do usuario que deseja alterar:
http://localhost:10411/EasyListRest/usuario/3

3. Coloque no corpo da requisição "body" os valores que deja alterar (mesmo as que nao deseja alterar)
```bash
 	{
	"nome":"nomeDoUsuario",
	"email":"EmailUsuario@gmail.com",
	"senha":"SenhaUsuario"
	}
```

# Post (Criar usuario)
1. Deve inserir o metodo Post,
2. Para criar um usuario utilize a rota "/usuario" passando no corpo da requisição os dados do usuario que deseja criar:
http://localhost:10411/EasyListRest/usuario
3. body:
```bash
	{
	"nome":"nomeDoUsuario",
	"email":"EmailUsuario@gmail.com",
	"senha":"SenhaUsuario"
	}
```

# LISTA
----
# Get (Buscar usuario)
1. Deve inserir o metodo GET,
2. Em seguida inserir o Id da lista que deseja buscar:
http://localhost:10411/EasyListRest/lista/40

# Delete (Deletar lista)
1. Deve inserir o metodo DELETE,
2. Em seguida inserir o ID da lista que deseja deletar:
http://localhost:10411/EasyListRest/lista/41

# Put (Alterar lista)
1. Deve inserir o metodo PUT,
2. Em seguida inserir o ID do usuario que deseja alterar:
http://localhost:10411/EasyListRest/lista/40
3. Em seguida deve inserir no corpo da requsição "body" todos os dados do usuario(mesmo as que nao deseja alterar)

```bash
	{
	"nome":"NomeDaLista",
	"usuarioID":"IdDoUsuario",
	"inativo":"0 para false e 1 para true"	
	}
```

# Post (Criar lista)
1. Deve inserir o metodo Post,
2. Em seguida utilize a rota "/usuario":
http://localhost:10411/EasyListRest/usuario
3. body:
```bash
	{
	"nome":"nomeDoUsuario",
	"email":"EmailUsuario@gmail.com",
	"senha":"SenhaUsuario"
	}
```

# Get (Buscar produtos que estao na lista)
1. Deve inserir o metodo GET,
2. Utilize a rota "prodlists" e em seguida inserir o id da lista
http://localhost:10411/EasyListRest/prodlists/5

# Get (Buscar listas do usuario)
1. Deve inserir o metodo GET,
2. Utilize a rota "userlists" e em seguida inserir o id da lista
http://localhost:10411/EasyListRest/userlists/3

