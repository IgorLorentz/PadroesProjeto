package Bridge;

//Classe de abstração
abstract class Veiculo {
    protected IMotor motor;

    public Veiculo(IMotor motor) {
        this.motor = motor;
    }

    public abstract void acelerar();
    public abstract void frear();
}
