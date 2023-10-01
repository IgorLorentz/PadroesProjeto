package Bridge;

//Implementação da classe de Barco 
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
