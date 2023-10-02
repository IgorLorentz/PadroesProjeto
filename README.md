# Padrões de Projeto
Neste projeto em grupo, vocês terão a oportunidade de explorar e aplicar padrões
de projeto em Java. Cada grupo deverá implementar um padrão de cada uma das
três categorias: criacionais, estruturais e comportamentais. Além disso, cada
grupo deve criar um repositório no GitHub para o projeto e fornecer o link do
projeto.

## Singleton
Singleton é um padrão de projeto criacional que garante a uma classe uma única instância, enquanto provê um ponto de acesso global para essa instância. De modo geral, desabilita todas as formas de criação de uma classe a não ser pelo método escolhido.

*Um Singleton deve possuir características como:*
- Uma única instância durante a vida útil da aplicação;
- Não deve ser possível instanciá-lo através do seu construtor, que precisa ter visibilidade preferencialmente privada;
- Além de possuir uma instância que esteja disponível de forma global, no seu projeto.

### Explicação do código:
Partindo da ideia de um jogo simples, cujo o objetivo é derrotar uma série de inimigos, até chegar a um chefe final, sendo a única ação do jogador atacar (através de um botão). 

Foi criada uma classe GameManager, utilizando o padrão Singleton, ou seja, ela só pode possuir apenas uma única instância durante toda execução, sendo a responsável por controlar o fluxo do game. Seu construtor é privado e tem um atributo privado estático chamado instance, que armazena a instância da mesma, e a acessa através do método getInstance() implementado com a “inicialização preguiçosa”. Além da parte referente ao padrão Singleton, essa classe armazena alguns atributos importantes como: o estado da aplicação, level, atributos do player e inimigos (nome, vida, força). Também possui o método NextLevel(), além de alguns getters e setters.

Partindo para a classe Main, dentro do método main(), é perguntado o nome do player, caso o mesmo não seja vazio ou nulo, e o player não tenha desistido de jogar, o método Game() é chamado. Em Game é criado a instância de GameManager e alguns atributos são inicializados, utilizando como base os dados contidos em GameManager, como por exemplo: level, a quantidade de inimigos, atributos do player e inimigos. Após a inicialização, começa a primeira batalha, o que nos leva ao método Battle().

Já em Battle(), é utilizado o método BattlePanel(), responsável por criar uma caixa de diálogo, contendo os dados do inimigo, além do seu respectivo ícone. É onde fica toda lógica da batalha, que na verdade é bem simples. É gerado um número aleatório entre 0 e 1, armazenado na variável “critChance”, caso esse número seja menor ou igual a 0.4 (40%), o player causará o dobro do seu dano no inimigo, caso contrário, causará apenas seu dano padrão. Se o player causar dano o suficiente para matar o inimigo, ele não sofrerá dano nesta rodada, senão receberá o dano padrão do inimigo (não há chance de crítico). A batalha acontece até que o player ou inimigo esteja morto, ou o player decidir parar a aplicação. Caso o player seja derrotado ou deseje sair da aplicação, Battle retorna 2 e em Game o estado da aplicação é alterado de “RUNNING” para “FINISH”, encerrando a mesma. Caso o player derrote o inimigo, Battle retorna 1 e em Game o estado da aplicação é alterado de “RUNNING” para “NEXTLEVEL”, então Game carrega o próximo level (basicamente troca o inimigo e aumenta os atributos do player e inimigo) e inicia novamente o Game (recursividade) com os novos parâmetros. Esse processo ocorre até que todos os inimigos sejam derrotados.

Note que mesmo que o método Game seja chamado novamente, existe apenas uma instância do GameManager, mantendo-se a mesma durante toda execução e sendo o único ponto de acesso para os dados utilizados da aplicação.

## Bridge
O Bridge é um padrão de projeto estrutural que possibilita a separação de uma classe grande ou de um conjunto de classes fortemente relacionadas em duas hierarquias distintas: abstração e implementação, permitindo o desenvolvimento independente de ambas.

### Explicação do código:
A ideia geral do código é demonstrar o padrão de projeto Bridge em um cenário onde veículos interagem com motores e podem ser renderizados em  contextos diferentes.

A Interface IMotor define a representação do comportamento do motor, com os métodos de iniciar e parar. No modelo de bridge ele é a interface de implementação.
Nesse sentido, as classes MotorGasolina e MotorEletrico são implementações concretas da interface IMotor, ou seja, elas contém códigos plataforma-específicos e definem como os métodos iniciar e parar devem ser executados conforme cada tipo de motor.

A classe de abstração Veiculo serve como base e contém uma referência a interface de implementação IMotor. Essa classe implementa os métodos abstratos de acelerar e frear que dependem da implementação do motor.
As classes Carro e Barco são implementações da classe Veiculo e utilizam os métodos de acelerar e frear de acordo com as suas necessidades, usando a implementação do motor associado para executar as funções de iniciar e parar.

Na Classe Bridge, a qual contém a Main, é possível ver um exemplo da criação da instância dos motores e a utilização deles para criação das instâncias de diferentes tipos de veículos e a diferença na execução dos métodos.

### O código no contexto bridge:
A interface IMotor é usada para definir os contratos que as implementações concretas (MotorEletrico e MotorGasolina) devem seguir. Ela permite que vários tipos de motores possam ser criados sem alterar os códigos da classe Veiculo.

A abstração veículo serve como base para implementação de Motor e define métodos que dependem do comportamento do motor, mas deixa a implementação específica para as suas subclasses (Carro e Barco). Isso faz com que as classes de Veiculo sejam isoladas das classes de motor. 


## Mediator
Mediador é um padrão de projeto comportamental que permite a comunicação indireta entre componentes do programa por meio de objetos mediadores especiais, reduzindo assim o acoplamento entre os componentes do programa.

### Explicação do código:
A ideia foi criar um sistema de chat onde usuários trocam mensagens entre si, com a implementação do método mediator, que fica responsável por intermediar as interações entre os usuários.

O mediator foi definido como a classe ChatMediator, nela existem dois métodos: um para adicionar usuários e outro para enviar mensagens.
A classe User possui dois métodos: o sendMessage, responsável por enviar as mensagens, e o reciveMessage, responsável por informar que uma mensagem chegou e mostrá-la.

A classe ChatUser é uma implementação concreta de User e nela são criados usuários que podem interagir com o sistema de chat, ou seja, mandar ou receber mensagens .

A classe Chat implementa a interface ChatMediator. O mediador possui uma lista de usuários registrados e encaminha as mensagens para todos da lista, menos para o remetente.

Na classe Main são criados três usuários, estes usuários são adicionados ao mediador e trocam mensagens entre si.
