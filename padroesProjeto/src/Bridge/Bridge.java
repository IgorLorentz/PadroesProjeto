package Bridge;

public class Bridge {
    public static void main(String[] args) {
        //Instânciando os tipos de motores
        IMotor motorGasolina = new MotorGasolina();
        IMotor motorEletrico = new MotorEletrico();

        //Instânciando os tipos de veículos
        Veiculo carroGasolina = new Carro(motorGasolina);
        Veiculo carroEletrico = new Carro(motorEletrico);
        Veiculo barcoGasolina = new Barco(motorGasolina);

        //Exemplos para demonstrar a diferença na execução dos métodos
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