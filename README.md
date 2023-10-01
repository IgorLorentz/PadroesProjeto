# Padrões de Projeto
Neste projeto em grupo, vocês terão a oportunidade de explorar e aplicar padrões
de projeto em Java. Cada grupo deverá implementar um padrão de cada uma das
três categorias: criacionais, estruturais e comportamentais. Além disso, cada
grupo deve criar um repositório no GitHub para o projeto e fornecer o link do
projeto.

## Singleton
Singleton é é um padrão de projeto criacional que garante a uma classe uma única instância, enquanto provê um ponto de acesso global para essa instância. De modo geral desabilita todas as formas de criação de uma classe a não ser pelo método escolhido.

*Um Singleton deve possuir características como:*
- Uma única instância durante a vida útil da aplicação;
- Não deve ser possível instanciá-lo através do seu construtor, que precisa ter visibilidade preferencialmente privada;
- Almém de possuir uma instância que esteja disponível de forma global, no seu projeto.



### Explicação do código:

## Bridge
O padrão Bridge é um padrão de projeto estrutural que possibilita a separação de uma classe grande ou de um conjunto de classes fortemente relacionadas em duas hierarquias distintas: abstração e implementação, permitindo o desenvolvimento independente de ambas.

### Explicação do código:
A ideia geral do código é demonstrar o padrão de projeto Bridge em um cenário onde veículos interagem com motores e podem ser renderizados em  contextos diferentes.

A Interface IMotor define a representação do comportamento do motor, com os métodos de iniciar e parar. No modelo de brigde ele é a interface de implementação.
As classes MotorGasolina e MotorEletrico são implemetações concretas da interface IMotor. Ou seja, elas contém códigos plataforma-específicos e definem como os métodos iniciar e parar devem ser executados conforme cada tipo de motor.

A classe de abstração Veiculo serve como base e contém uma referência a interface de implementação IMotor. Essa classe implementa os métodos abstratos de acelerar e frear que dependem da implementação do motor.
As classes Carro e Barco são implementações da classe Veiculo. Elas herdam Veiculo e implementam os métodos de acelerar e frear de acordo com as suas necessidades, usando a implementação do motor associado para executar as funções de iniciar e parar.

Na Classe Bridge, a qual contém a Main, é possível ver um exemplo da criação da instância dos motores e a utilização deles para criação das instâncias de diferentes tipos de veículos e a diferença na execução dos métodos.

### O código no contexto bridge:
A interface IMotor é usada para definir os contratos que as implementações concretas devem seguir. Ela permite que vários tipos de motores possam ser criados sem alterar os códigos da classe de veículo.

A abstração Veiculo serve como base para iplementação de Motor e define métodos que dependem do comportamento do motor, mas deixa a implementação específica para as suas subclasses (Carro e Barco). Isso faz com que as classes de Veiculo sejam isoladas das classes de motor. 


## Mediator
Mediador é um padrão de projeto comportamental que permite a comunicação indireta entre componentes do programa por meio de objetos mediadores especiais, reduzindo assim o acoplamento entre os componentes do programa.

### Explicação do código:
A ideia foi criar um sistema de chat onde usuários trocam mensagens entre si, com a implementação do método mediator, que fica responsável por intermediar as interações entre os usuários.

O mediator foi definido como a classe ChatMediator, nela existem dois métodos um para adicionar usuários e outro para enviar mensagens.
A classe User possui dois métodos o sendMessage, responsável por enviar as mensagens, e o reciveMessage, responsável por informar que uma mensagem chegou e mostrá-la.

A classe ChatUser é uma implementação concreta de User e nela são criados usuários que podem interagir com o sistema de chat, ou seja, mandar ou receber mensagens .

A classe Chat implementa a interface ChatMediator. O mediador possui uma lista de usuários registrados e encaminha as mensagens para todos da lista, menos para o remetente.

Na classe Main são criados três usuários, estes usuários são adicionados ao mediador e trocam mensagens entre si.
