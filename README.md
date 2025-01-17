Interface gráfica para gerenciamento de produtos do Sebo Lunar

Nosso projeto é um sistema de gerenciamento de produtos de um sebo fictício chamado Lunar, implementado usando JavaFX. Nesse sistema, o usuário é um funcionário do sebo ou até mesmo o proprietário. Seus clientes não possuem acesso a ele.
O sistema consiste em 13 telas, que são respectivamente:
• Tela de boas vindas;
• Tela do menu principal;
• Tela para o cadastro de livros;
• Tela para o cadastro de disco;
• Tela para a exibição de todos os livros cadastrados;
• Tela para a exibição de todos os discos cadastrados;
• Tela para a exibição de livros buscados pelo nome do autor;
• Tela para a exibição de discos buscados pelo nome do cantor;
• Tela para a exibição de produtos buscados pelo título da obra;
• Tela para remover um livro do banco de dados;
• Tela para remover um disco do banco de dados;
• Tela para calcular o frete de livros com alguns critérios definidos;
• Tela para calcular o frete de discos com alguns critérios definidos.

Além disso, o projeto foi organizado seguindo o padrão MVC.

Temos os controllers, as view associadas aos controllers e a pasta model, onde estão inclusas as entidades e enumerações.
Adicionamos também a pasta responsável pelo banco de dados (DAO) e a pasta utils, com uma classe contendo métodos auxiliares usados pelos controllers.

Na aplicação principal, temos a abertura e fechamento do arquivo do banco de dados e um método que permite a alternância entre telas.

O controller mais importante é a do menu principal, que faz uso do método da aplicação para alternar as outras telas. Além disso, todos os outros controllers herdam dele.

Para a execução, executar a aplicação MainApplication.