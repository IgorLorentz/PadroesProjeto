package Bridge;

//Implementação concreta de Motor 
class MotorEletrico implements IMotor {
    @Override
    public void iniciar() {
        System.out.println("Motor elétrico ligado");
    }

    @Override
    public void parar() {
        System.out.println("Motor elétrico desligado");
    }
}
