package Utilitats;

public class UtilitatsConsola {
    public static int llegirSencer(String prompt) {
        String placeHolder = IO.readln(prompt);
        int valor = Integer.parseInt(placeHolder);
        return valor;
    }

    public static double llegirDouble(String prompt) {
        String placeHolder = IO.readln(prompt);
        double valor = Double.parseDouble(placeHolder);
        return valor;
    }

    public static String llegirCadena(String prompt) {
        String cadena = IO.readln(prompt);
        return cadena;
    }    

    public static void llegirArraySencers(int... array) {
        IO.print("[");
        for(int i = 0; i<array.length-1; i++) {
            IO.print(array[i]+", ");
        }
        IO.println(array[array.length-1]+"]");
    }

    public static int gestioMenu(String titol, String pregunta, String... opcio) {
        IO.println("Aquest menu és "+titol);
        for(int i = 0; i<opcio.length; i++) {
            IO.println("Opció "+i+": "+opcio[i]);
        }
        int resposta = -1;
        while (resposta<0 || resposta > opcio.length) {
            try {
                resposta = UtilitatsConsola.llegirSencer(pregunta);
            } catch (Exception e) {
                continue;
            }           
        }
        return resposta;
    }
}