import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java. awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Gui extends JFrame {
    public static void main(String[] args) {
        Gui gui = new Gui(); 
        gui.setVisible(true);

    }

    public Gui(){
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        add(p);
    }

    class Panel extends JPanel {
        int numRegistros = 0;
        int numPreescolar = 0;
        int numPrimaria = 0;
        int numSecundaria = 0;
        int numPreparatoria = 0;
        int numUniversidad = 0;
        int numMaestria = 0;
        int numDoctorado = 0;

        public Panel() {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Ejecutando...");
                    String nombreArchivo = "registros.txt";
                    List<String> estudios = new ArrayList<String>();
                    List<String> curps = new ArrayList<String>();
                    List<Integer> celulares = new ArrayList<Integer>();
                    try {
                        File archivo = new File(nombreArchivo);
                        FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);

                        String linea;
                        while ((linea = br.readLine()) != null) {
                            String[] datos = linea.split(",");
                            estudios.add(datos[2]);
                            curps.add(datos[1]);
                            celulares.add(Integer.parseInt(datos[0]));
                        }
                        br.close();
                    } catch (Exception e) {
                        System.err.println("Error al leer el archivo: " + e.getMessage());
                    }

                    numRegistros = celulares.size();
                    numPreescolar = Collections.frequency(estudios, "Preescolar");
                    numPrimaria = Collections.frequency(estudios, "Primaria");
                    numSecundaria = Collections.frequency(estudios, "Secundaria");
                    numPreparatoria = Collections.frequency(estudios, "Preparatoria");
                    numUniversidad = Collections.frequency(estudios, "Universidad");
                    numMaestria = Collections.frequency(estudios, "Maestria");
                    numDoctorado = Collections.frequency(estudios, "Doctorado");
                    repaint();
                }
            };

            timer.scheduleAtFixedRate(task, 0, 3000);
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Numero de registros: " + numRegistros, 10, 10);
            g.drawString("Preescolar: " + numPreescolar, 10, 30);
            g.drawString("Primaria: " + numPrimaria, 10, 50);
            g.drawString("Secundaria: " + numSecundaria, 10, 70);
        }
    }
}
