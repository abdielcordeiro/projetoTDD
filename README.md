# projetoTDD
Projeto de TDD para avaliação

Projeto desenvolvido em cima do site http://www.advantageonlineshopping.com/#/ para realização de alguns cenarios de testes.

Cenários:
A.	Cadastrar cliente.
B.	Consultar(Massa de Dados) produto tela principal.
C.	Consultar produto pelo campo de pesquisa.

3-	Critérios de aceite :
A.	Demostrar um relatório (a sua escolha “Report”) mostrando as informações dos testes (falhou, passou, etc);
B.	Utilizar em pelo menos um dos cenários consumo da massa de dados via Excel;
C.	Demonstrar as automações funcionando;
D.	Print para todos os cenários(Sucesso/Falha).

 -> Report escolhido para demonstrar os casos de falha e sucesso foi o reportExtend.
 -> nome dos pacotes foi definidos como: br.com.rsinet.HUB_TDD.*
 
 Descrição dos pacotes:
  -> extendReport: Pacote no qual esta minha classe que configura o report e sabe como utlizar, onde deve ser salvo os reportes e quais configurações como abrir e fechar um reporte.
  
  -> pageFactory: Pacote no qual estão todas as minhas pagesFactory's arquivos que são responsaveis por mapear e saber como executar as funções(escrita,leitura ou clique) nos elementos da páginas, o criterio para criação de uma factory foi quando era alterado a URL ou os métodos são muito distintos.
  
  -> testData: Pacote onde esta guardando meu arquivo excel, onde estão minha massa de dados.
  
  -> teste: Pacote onde estão os arquivos de teste, com todos meus cenários de falha e sucesso separados por arquivos.
  
  ->utility: Pacote onde estão todos os meus métodos que são reutilizados varias vezes:
     1-> DriveFactory: Arquivo que controla a criação e destruição das páginas WEB como também recebe a URL que sera executada no navegador
     2-> Constant: Arquivo no qual foi colocado todas as variaveis que seram constantes na programação, como URL, local do arquivo da massa de dados, celula na qual estão cada variavel.
     3-> ExcelUtils: Arquivo no qual sabe manipular e extrair as informações do excel( Massa de Dados ).
     4-> print: Arquivo no qual sabe manipular os print como tirar um print e onde deve salvar o mesmo.
     5-> MassaDados: arquivo que sabem como obter os dados dos excel com os métodos get.
     
     Dentro da pasta target contém os meus relatorios dos textes como também os print's obtidos nos textes.
