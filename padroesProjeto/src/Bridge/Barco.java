package Bridge;

////Implementação de Barco usando a classe de Abstração 
class Barco extends Veiculo {
    public Barco(IMotor motor) {
        super(motor);
    }

    @Override
    public void acelerar() {
        motor.iniciar();
        System.out.println("Barco acelerando");
    }

    @Override
    public void frear() {
        System.out.println("Barco freando");
        motor.parar();
    }
}
