# Padrões de Projeto
Neste projeto em grupo, vocês terão a oportunidade de explorar e aplicar padrões
de projeto em Java. Cada grupo deverá implementar um padrão de cada uma das
três categorias: criacionais, estruturais e comportamentais. Além disso, cada
grupo deve criar um repositório no GitHub para o projeto e fornecer o link do
projeto.

## Singleton

## Bridge
O padrão Bridge é um padrão de projeto estrutural que possibilita a separação de uma classe grande ou de um conjunto de classes fortemente relacionadas em duas hierarquias distintas: abstração e implementação, permitindo o desenvolvimento independente de ambas.

### Explicação do código:
A ideia geral do código é demonstrar o padrão de projeto Bridge em um cenário onde veículos interagem com motores e podem ser renderizados em diferentes contextos.
A Interface IMotor define a representação do comportamento do motor, com os métodos de iniciar e parar. No modelo de brigde ele é a interface de implementação.
As classes MotosGasolina e MotorEletrico são implemetações concretas da interface IMotor. Ou seja, elas contém códigos plataforma-específicos e definem como os métodos iniciar e parar devem ser executados conforme cada tipo de motor.



## Mediator
Mediador é um padrão de projeto comportamental que permite a comunicação indireta entre componentes do programa por meio de objetos mediadores especiais, reduzindo assim o acoplamento entre os componentes do programa.

### Explicação do código:
A ideia foi criar um sistema de chat onde usuários trocam mensagens entre si, com a implementação do método mediator, que fica responsável por intermediar as interações entre os usuários.

O mediator foi definido como a classe ChatMediator, nela existem dois métodos um para adicionar usuários e outro para enviar mensagens.
A classe User possui dois métodos o sendMessage, responsável por enviar as mensagens, e o reciveMessage, responsável por informar que uma mensagem chegou e mostrá-la.

A classe ChatUser é uma implementação concreta de User e nela são criados usuários que podem interagir com o sistema de chat, ou seja, mandar ou receber mensagens .

A classe Chat implementa a interface ChatMediator. O mediador possui uma lista de usuários registrados e encaminha as mensagens para todos da lista, menos para o remetente.

Na classe Main são criados três usuários, estes usuários são adicionados ao mediador e trocam mensagens entre si.
