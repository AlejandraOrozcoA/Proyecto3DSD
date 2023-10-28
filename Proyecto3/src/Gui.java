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

            // Titulo al centro
            g.setColor(Color.BLACK);
            g.drawString("Estadisticas Registros", 200, 50);
            
            
            int barWidth = 50; // Ancho de las barras
            int x = 50; // Coordenada X inicial

            g.setColor(Color.BLUE);
            g.fillRect(x, 400 - numPreescolar * 10, barWidth, numPreescolar * 10); // Representa Preescolar
            g.drawString("Preescolar", x, 420);
            g.drawString(String.valueOf(numPreescolar), x + 10, 400 - numPreescolar * 10 - 10);
            x += barWidth + 20;

            g.setColor(Color.RED);
            g.fillRect(x, 400 - numPrimaria * 10, barWidth, numPrimaria * 10); // Representa Primaria
            g.drawString("Primaria", x, 420);
            g.drawString(String.valueOf(numPrimaria), x + 10, 400 - numPrimaria * 10 - 10);
            x += barWidth + 20;

            g.setColor(Color.GREEN);
            g.fillRect(x, 400 - numSecundaria * 10 , barWidth, numSecundaria * 10); // Representa Secundaria
            g.drawString("Secundaria", x, 420);
            g.drawString(String.valueOf(numSecundaria), x + 10, 400 - numSecundaria * 10 - 10);
            x += barWidth + 20;

            g.setColor(Color.ORANGE);
            g.fillRect(x, 400 - numPreparatoria * 10, barWidth, numPreparatoria * 10); // Representa Preparatoria
            g.drawString("Preparatoria", x, 420);
            g.drawString(String.valueOf(numPreparatoria), x + 10, 400 - numPreparatoria * 10 - 10);
            x += barWidth + 20;

            g.setColor(Color.darkGray);
            g.fillRect(x, 400 - numUniversidad * 10, barWidth, numUniversidad * 10); // Representa Universidad
            g.drawString("Universidad", x, 420);
            g.drawString(String.valueOf(numUniversidad), x + 10, 400 - numUniversidad * 10 - 10);
            x += barWidth + 20;

            g.setColor(Color.MAGENTA);
            g.fillRect(x, 400 - numMaestria * 10, barWidth, numMaestria * 10); // Representa Maestria
            g.drawString("Maestria", x, 420);
            g.drawString(String.valueOf(numMaestria), x + 10, 400 - numMaestria * 10 - 10);
            x += barWidth + 20;

            g.setColor(Color.PINK);
            g.fillRect(x, 400 - numDoctorado* 10, barWidth, numDoctorado * 10); // Representa Doctorado
            g.drawString("Doctorado", x, 420);
            g.drawString(String.valueOf(numDoctorado), x + 10, 400 - numDoctorado * 10 - 10);

            g.setColor(Color.BLACK);
            g.drawString("Registros: " + String.valueOf(numRegistros), 50, 450);
            
        }
    }
}
