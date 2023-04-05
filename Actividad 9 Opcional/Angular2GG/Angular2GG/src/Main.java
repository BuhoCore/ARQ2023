import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner leer = new Scanner(System.in);
        int notas;
        int pro =0, suma= 0;

        try {

            System.out.println("Ingrese cantidad de notas:");
            notas = leer.nextInt();

            for (int i = 1; i <= notas; i++) {
                System.out.println("Ingrese nota:" + " " + " " + i + " de " + notas);

                int nota = leer.nextInt();
                suma = suma + nota;
            }

        pro = suma/notas;
        System.out.println("Resultado del promedio total es : " + pro);


        }catch (Exception e){
            System.out.println("Ingrese solo numeros enteros");

        }

   }

}

