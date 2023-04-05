public class Main {

    public static void main (int[][] main(String[] args) {


        int[][] rotarMatriz90Antihorario;
        int[][] matriz = new int[0][];

            int tamanio = matriz.length;
            int[][] nuevamatriz = new int[tamanio][tamanio];

            for (int x = 0; x < tamanio; x++) {
                for (int y = 0; y < tamanio; y++) {
                    nuevamatriz[tamanio - 1 - y][x] = matriz[x][y];
                }
            }return nuevamatriz;



    }
}


/*
        System.out.println("Ingrese numero de filas:");
        int fila = sc.nextInt();
        sc.close();

        System.out.println();
        System.out.println();
        for(int altura = 1; altura<=fila; altura++){
            //Espacios en blanco
            for(int blancos = 1; blancos<=fila-altura; blancos++){
                System.out.print("   ");
            }
            for(int aste = 1; aste <= (altura*2)-1; aste++){
                System.out.print(" * ");
            }


            System.out.println();
        }

    }
    */
