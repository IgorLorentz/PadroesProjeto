package Bridge;

//Implementação de Carro usando a classe de Abstração 
class Carro extends Veiculo {
    public Carro(IMotor motor) {
        super(motor);
    }

    @Override
    public void acelerar() {
        motor.iniciar();
        System.out.println("Carro acelerando");
    }

    @Override
    public void frear() {
        System.out.println("Carro freando");
        motor.parar();
    }
}
