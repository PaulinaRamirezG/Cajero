import java.text.DecimalFormat;
import java.util.Scanner;

public class Cajero {
    static long saldo;
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        System.out.println("Ingrese el usuario: ");
        String name = scan.nextLine();
        System.out.println("Ingrese el pass (numérico)");
        int pass = scan.nextInt();
        System.out.println("El usuario es " + name + " y el pass: " + pass);
        definirAccion();
    }

    private static void definirAccion() {
        System.out.println("Qué desea hacer? ");
        System.out.println("1. consultar el saldo");
        System.out.println("2. retirar dinero");
        System.out.println("3. depositar dinero");
        System.out.println("0. Salir");
        
        int opcion = scan.nextInt();
        switch (opcion) {
            case 1:
                consultarSaldo();
                break;
            case 2:
                retirarDinero();
                break;
            case 3:
                depositarDinero();
                break;
            default:
                salir();
                break;
        }
    }

    
    private static void consultarSaldo() {
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        System.out.println("Su saldo actual es: $" + formatea.format(getSaldo()) );
        definirAccion();
    }

    private static void depositarDinero() {
        System.out.println("Ingrese el monto a depositar: ");
        long monto = scan.nextLong();

        // se valida que el monto sea positivo
        if (monto < 0){
            System.out.println("El valor a depositar debe ser positivo");
            definirAccion(); 
        }else {
            setSaldo(getSaldo() + monto);
            consultarSaldo();
        }

    }

    private static void retirarDinero() {
        System.out.println("Ingrese el monto a retirar: ");
        long monto = scan.nextLong();

        // se valida que el monto sea positivo
        if (monto < 0){
            System.out.println("El valor a retirar debe ser positivo");
            definirAccion(); 
        }else {

            // Se valida si tiene saldo suficiente para realizar el retiro
            if(getSaldo() - monto < 0){
                System.out.println("No tiene suficiente saldo para realizar la operación ");
                definirAccion();
            }else{
                setSaldo(getSaldo() - monto);
                consultarSaldo();
            }
        }
    }

    private static void salir() {
        System.out.println("Vuelva pronto ");
    }

    public static long getSaldo() {
        return saldo;
    }

    public static void setSaldo(long monto) {
        Cajero.saldo = monto;
    }
}
