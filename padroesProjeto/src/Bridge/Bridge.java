package Bridge;

public class Bridge {
    public static void main(String[] args) {
        IMotor motorGasolina = new MotorGasolina();
        IMotor motorEletrico = new MotorEletrico();

        Veiculo carroGasolina = new Carro(motorGasolina);
        Veiculo carroEletrico = new Carro(motorEletrico);
        Veiculo barcoGasolina = new Barco(motorGasolina);

        System.out.println("--------- Exemplo 1 ---------");
        carroGasolina.acelerar();
        carroGasolina.frear();
        System.out.println("----------------------------- \n");

        System.out.println("--------- Exemplo 2 ---------");
        carroEletrico.acelerar();
        carroEletrico.frear();
        System.out.println("----------------------------- \n");

        System.out.println("--------- Exemplo 3 ---------");
        barcoGasolina.acelerar();
        barcoGasolina.frear();
        System.out.println("----------------------------- \n");
    }
}