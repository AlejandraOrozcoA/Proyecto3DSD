import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String archivo = "registros.txt";
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Ejecutando...");
                //Crea n registros aleatorios
                ArrayList<Registro> registros = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    registros.add(new Registro(getCelular(), getCURP(), getEstudios()));
                }

                //Escribe los registros en el archivo
                try {
                    FileOutputStream fos = new FileOutputStream(archivo, true);
                    PrintStream ps = new PrintStream(fos);
                    Iterator<Registro> it = registros.iterator();
                    while (it.hasNext()) {
                        ps.println(it.next());
                    }
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

                registros.clear();
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    static String getCURP()
    {
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numero = "0123456789";
        String Sexo = "HM";
        String Entidad[] = {"AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS"};
        int indice;
        
        StringBuilder sb = new StringBuilder(18);
        
        for (int i = 1; i < 5; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }
        
        for (int i = 5; i < 11; i++) {
            indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }
 
        indice = (int) (Sexo.length()* Math.random());
        sb.append(Sexo.charAt(indice));        
        
        sb.append(Entidad[(int)(Math.random()*32)]);
 
        for (int i = 14; i < 17; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }
 
        for (int i = 17; i < 19; i++) {
            indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }
        
        return sb.toString();
    } 

    static String getEstudios()
    {
        String[] estudios = {"Preescolar","Primaria", "Secundaria", "Preparatoria", "Universidad", "Maestria", "Doctorado"};
        int indice = (int) (estudios.length * Math.random());
        return estudios[indice];
    }

    static int getCelular()
    {
        int celular = (int) (1000000000 * Math.random());
        return celular;
    }
}