package Bridge;

//Implementação concreta de Motor
class MotorGasolina implements IMotor {
    @Override
    public void iniciar() {
        System.out.println("Motor a gasolina ligado");
    }

    @Override
    public void parar() {
        System.out.println("Motor a gasolina desligado");
    }
}
