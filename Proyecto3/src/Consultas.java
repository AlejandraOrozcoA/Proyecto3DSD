// Alejandra Orozco Aguilar
// Proyecto 3
// 4CM12

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Consultas {
    public static void main(String[] args) {
        boolean condition = true;
        do {
        //Menu  
        System.out.println("1. ¿Cuántos mensajes SMS totales se han realizado por cada sexo hasta el momento?");
        System.out.println("2. ¿Cuántos mensajes SMS se han realizado por cada entidad federativa?");
        System.out.println("3. ¿Cuántos ciudadanos tienen un cierto nivel de estudios concluidos, así como su sexo?");
        System.out.println("4. ¿Cuál es la edad promedio de los ciudadanos que han concluido un cierto nivel de estudios?");

        String nombreArchivo = "registros.txt";
        //Lectura de archivo
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

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                //Contar hombres y mujeres
                int numHombres = 0;
                int numMujeres = 0;
                for (int i = 0; i < curps.size(); i++) {
                    if (curps.get(i).charAt(10) == 'H') {
                        numHombres++;
                    } else {
                        numMujeres++;
                    }
                }
                System.out.println("Numero de mensajes por sexo:");
                System.out.println("Hombres: " + numHombres);
                System.out.println("Mujeres: " + numMujeres);
                break;
            case 2:
                //Contar por entidad federativa
                int numAS = 0;
                int numBC = 0;
                int numBS = 0;
                int numCC = 0;
                int numCS = 0;
                int numCH = 0;
                int numCL = 0;
                int numCM = 0;
                int numDF = 0;
                int numDG = 0;
                int numGT = 0;
                int numGR = 0;
                int numHG = 0;
                int numJC = 0;
                int numMC = 0;
                int numMN = 0;
                int numMS = 0;
                int numNT = 0;
                int numNL = 0;
                int numOC = 0;
                int numPL = 0;
                int numQT = 0;
                int numQR = 0;
                int numSP = 0;
                int numSL = 0;
                int numSR = 0;
                int numTC = 0;
                int numTL = 0;
                int numTS = 0;
                int numVZ = 0;
                int numYN = 0;
                int numZS = 0;

                //Contar por entidad federativa
                for (int i = 0; i < curps.size(); i++) {
                    if (curps.get(i).substring(11, 13).equals("AS")) {
                        numAS++;
                    } else if (curps.get(i).substring(11, 13).equals("BC")) {
                        numBC++;
                    } else if (curps.get(i).substring(11, 13).equals("BS")) {
                        numBS++;
                    } else if (curps.get(i).substring(11, 13).equals("CC")) {
                        numCC++;
                    } else if (curps.get(i).substring(11, 13).equals("CS")) {
                        numCS++;
                    } else if (curps.get(i).substring(11, 13).equals("CH")) {
                        numCH++;
                    } else if (curps.get(i).substring(11, 13).equals("CL")) {
                        numCL++;
                    } else if (curps.get(i).substring(11, 13).equals("CM")) {
                        numCM++;
                    } else if (curps.get(i).substring(11, 13).equals("DF")) {
                        numDF++;
                    } else if (curps.get(i).substring(11, 13).equals("DG")) {
                        numDG++;
                    } else if (curps.get(i).substring(11, 13).equals("GT")) {
                        numGT++;
                    } else if (curps.get(i).substring(11, 13).equals("GR")) {
                        numGR++;
                    } else if (curps.get(i).substring(11, 13).equals("HG")) {
                        numHG++;
                    } else if (curps.get(i).substring(11, 13).equals("JC")) {
                        numJC++;
                    } else if (curps.get(i).substring(11, 13).equals("MC")) {
                        numMC++;
                    } else if (curps.get(i).substring(11, 13).equals("MN")) {
                        numMN++;
                    } else if (curps.get(i).substring(11, 13).equals("MS")) {
                        numMS++;
                    } else if (curps.get(i).substring(11, 13).equals("NT")) {
                        numNT++;
                    } else if (curps.get(i).substring(11, 13).equals("NL")) {
                        numNL++;
                    } else if (curps.get(i).substring(11, 13).equals("OC")) {
                        numOC++;
                    } else if (curps.get(i).substring(11, 13).equals("PL")) {
                        numPL++;
                    } else if (curps.get(i).substring(11, 13).equals("QT")) {
                        numQT++;
                    } else if (curps.get(i).substring(11, 13).equals("QR")) {
                        numQR++;
                    } else if (curps.get(i).substring(11, 13).equals("SP")) {
                        numSP++;
                    } else if (curps.get(i).substring(11, 13).equals("SL")) {
                        numSL++;
                    } else if (curps.get(i).substring(11, 13).equals("SR")) {
                        numSR++;
                    } else if (curps.get(i).substring(11, 13).equals("TC")) {
                        numTC++;
                    } else if (curps.get(i).substring(11, 13).equals("TL")) {
                        numTL++;
                    } else if (curps.get(i).substring(11, 13).equals("TS")) {
                        numTS++;
                    } else if (curps.get(i).substring(11, 13).equals("VZ")) {
                        numVZ++;
                    } else if (curps.get(i).substring(11, 13).equals("YN")) {
                        numYN++;
                    } else if (curps.get(i).substring(11, 13).equals("ZS")) {
                        numZS++;
                    }
                }
                    //Imprimir
                    System.out.println("Numero de mensajes por entidad federativa:");
                    System.out.println("AS: " + numAS);
                    System.out.println("BC: " + numBC);
                    System.out.println("BS: " + numBS);
                    System.out.println("CC: " + numCC);
                    System.out.println("CS: " + numCS);
                    System.out.println("CH: " + numCH);
                    System.out.println("CL: " + numCL);
                    System.out.println("CM: " + numCM);
                    System.out.println("DF: " + numDF);
                    System.out.println("DG: " + numDG);
                    System.out.println("GT: " + numGT);
                    System.out.println("GR: " + numGR);
                    System.out.println("HG: " + numHG);
                    System.out.println("JC: " + numJC);
                    System.out.println("MC: " + numMC);
                    System.out.println("MN: " + numMN);
                    System.out.println("MS: " + numMS);
                    System.out.println("NT: " + numNT);
                    System.out.println("NL: " + numNL);
                    System.out.println("OC: " + numOC);
                    System.out.println("PL: " + numPL);
                    System.out.println("QT: " + numQT);
                    System.out.println("QR: " + numQR);
                    System.out.println("SP: " + numSP);
                    System.out.println("SL: " + numSL);
                    System.out.println("SR: " + numSR);
                    System.out.println("TC: " + numTC);
                    System.out.println("TL: " + numTL);
                    System.out.println("TS: " + numTS);
                    System.out.println("VZ: " + numVZ);
                    System.out.println("YN: " + numYN);
                    System.out.println("ZS: " + numZS);

                break;
            case 3:
                //Contar cuantos hombres y mujeres tienen cierto nivel de estudios
                int numHombresPreescolar = 0;
                int numMujeresPreescolar = 0;
                int numHombresPrimaria = 0;
                int numMujeresPrimaria = 0;
                int numHombresSecundaria = 0;
                int numMujeresSecundaria = 0;
                int numHombresPreparatoria = 0;
                int numMujeresPreparatoria = 0;
                int numHombresUniversidad = 0;
                int numMujeresUniversidad = 0;
                int numHombresMaestria = 0;
                int numMujeresMaestria = 0;
                int numHombresDoctorado = 0;
                int numMujeresDoctorado = 0;

                //Contar por nivel de estudios
                for (int i = 0; i < curps.size(); i++) {
                    if (curps.get(i).charAt(10) == 'H') {
                        if (estudios.get(i).equals("Preescolar")) {
                            numHombresPreescolar++;
                        } else if (estudios.get(i).equals("Primaria")) {
                            numHombresPrimaria++;
                        } else if (estudios.get(i).equals("Secundaria")) {
                            numHombresSecundaria++;
                        } else if (estudios.get(i).equals("Preparatoria")) {
                            numHombresPreparatoria++;
                        } else if (estudios.get(i).equals("Universidad")) {
                            numHombresUniversidad++;
                        } else if (estudios.get(i).equals("Maestria")) {
                            numHombresMaestria++;
                        } else if (estudios.get(i).equals("Doctorado")) {
                            numHombresDoctorado++;
                        }
                    } else {
                        if (estudios.get(i).equals("Preescolar")) {
                            numMujeresPreescolar++;
                        } else if (estudios.get(i).equals("Primaria")) {
                            numMujeresPrimaria++;
                        } else if (estudios.get(i).equals("Secundaria")) {
                            numMujeresSecundaria++;
                        } else if (estudios.get(i).equals("Preparatoria")) {
                            numMujeresPreparatoria++;
                        } else if (estudios.get(i).equals("Universidad")) {
                            numMujeresUniversidad++;
                        } else if (estudios.get(i).equals("Maestria")) {
                            numMujeresMaestria++;
                        } else if (estudios.get(i).equals("Doctorado")) {
                            numMujeresDoctorado++;
                        }
                    }
                }
                
                System.out.println("Numero de hombres y mujeres por nivel de estudios:");
                System.out.println("Preescolar: Hombres: "+numHombresPreescolar+" Mujeres: "+numMujeresPreescolar);
                System.out.println("Primaria: Hombres: "+numHombresPrimaria+" Mujeres: "+numMujeresPrimaria);
                System.out.println("Secundaria: Hombres: "+numHombresSecundaria+" Mujeres: "+numMujeresSecundaria);
                System.out.println("Preparatoria: Hombres: "+numHombresPreparatoria+" Mujeres: "+numMujeresPreparatoria);
                System.out.println("Universidad: Hombres: "+numHombresUniversidad+" Mujeres: "+numMujeresUniversidad);
                System.out.println("Maestria: Hombres: "+numHombresMaestria+" Mujeres: "+numMujeresMaestria);
                System.out.println("Doctorado: Hombres: "+numHombresDoctorado+" Mujeres: "+numMujeresDoctorado);

                break;
            case 4:
                //Edad promedio por nivel de estudios
                int promedioEdadesPreescolar = 0;
                int promedioEdadesPrimaria = 0;
                int promedioEdadesSecundaria = 0;
                int promedioEdadesPreparatoria = 0;
                int promedioEdadesUniversidad = 0;
                int promedioEdadesMaestria = 0;
                int promedioEdadesDoctorado = 0;

                //Suma de edades por nivel de estudios
                int sumaEdadesPreescolar = 0;
                int sumaEdadesPrimaria = 0;
                int sumaEdadesSecundaria = 0;
                int sumaEdadesPreparatoria = 0;
                int sumaEdadesUniversidad = 0;
                int sumaEdadesMaestria = 0;
                int sumaEdadesDoctorado = 0;

                //Contar por nivel de estudios
                for (int i = 0; i < curps.size(); i++) {
                    if (estudios.get(i).equals("Preescolar")) {
                        sumaEdadesPreescolar += calcularEdad(curps.get(i));
                    } else if (estudios.get(i).equals("Primaria")) {
                        sumaEdadesPrimaria += calcularEdad(curps.get(i));
                    } else if (estudios.get(i).equals("Secundaria")) {
                        sumaEdadesSecundaria += calcularEdad(curps.get(i));
                    } else if (estudios.get(i).equals("Preparatoria")) {
                        sumaEdadesPreparatoria += calcularEdad(curps.get(i));
                    } else if (estudios.get(i).equals("Universidad")) {
                        sumaEdadesUniversidad += calcularEdad(curps.get(i));
                    } else if (estudios.get(i).equals("Maestria")) {
                        sumaEdadesMaestria += calcularEdad(curps.get(i));
                    } else if (estudios.get(i).equals("Doctorado")) {
                        sumaEdadesDoctorado += calcularEdad(curps.get(i));
                    }
                }

                //Contar por nivel de estudios
                int numPreescolar = Collections.frequency(estudios, "Preescolar");
                int numPrimaria = Collections.frequency(estudios, "Primaria");
                int numSecundaria = Collections.frequency(estudios, "Secundaria");
                int numPreparatoria = Collections.frequency(estudios, "Preparatoria");
                int numUniversidad = Collections.frequency(estudios, "Universidad");
                int numMaestria = Collections.frequency(estudios, "Maestria");
                int numDoctorado = Collections.frequency(estudios, "Doctorado");

                //Promedio de edades por nivel de estudios
                promedioEdadesPreescolar = sumaEdadesPreescolar / numPreescolar;
                promedioEdadesPrimaria = sumaEdadesPrimaria / numPrimaria;
                promedioEdadesSecundaria = sumaEdadesSecundaria / numSecundaria;
                promedioEdadesPreparatoria = sumaEdadesPreparatoria / numPreparatoria;
                promedioEdadesUniversidad = sumaEdadesUniversidad / numUniversidad;
                promedioEdadesMaestria = sumaEdadesMaestria / numMaestria;
                promedioEdadesDoctorado = sumaEdadesDoctorado / numDoctorado;

                //Imprimir
                System.out.println("Edad promedio por nivel de estudios");
                System.out.println("Preescolar: " + promedioEdadesPreescolar);
                System.out.println("Primaria: " + promedioEdadesPrimaria);
                System.out.println("Secundaria: " + promedioEdadesSecundaria);
                System.out.println("Preparatoria: " + promedioEdadesPreparatoria);
                System.out.println("Universidad: " + promedioEdadesUniversidad);
                System.out.println("Maestria: " + promedioEdadesMaestria);
                System.out.println("Doctorado: " + promedioEdadesDoctorado);

                break;
        
            default:
                System.out.println("Opcion no valida");
                break;
        }

        System.out.println("¿Desea realizar otra consulta? (s/n)");
        String respuesta = sc.next().toLowerCase();
        switch (respuesta) {
            case "n":
                condition = false;
                break;
            case "s":
                condition = true;
                break;
            default:
                System.out.println("Opcion no valida, se terminara el programa");
                condition = false;
                break;
        }
        
        } while (condition);

    }

    public static int calcularEdad(String curp) {
        int edad = 0;
        //Calcula la edad dado un CURP
        int anio = Integer.parseInt(curp.substring(4, 6));
        int mes = Integer.parseInt(curp.substring(6, 8));
        int dia = Integer.parseInt(curp.substring(8, 10));

        SimpleDateFormat formato = new SimpleDateFormat("yy");
        int anioActual = Integer.parseInt(formato.format(new Date()));

        if (anio > anioActual) {
            edad = 100 - anio + anioActual;
        } else {
            edad = anioActual - anio;
        }

        //Si el mes de nacimiento es mayor al actual, se resta un año
        if (mes > Integer.parseInt(new SimpleDateFormat("MM").format(new Date()))) {
            edad--;
        } else if (mes == Integer.parseInt(new SimpleDateFormat("MM").format(new Date()))) {
            //Si el mes es el mismo, se compara el dia
            if (dia > Integer.parseInt(new SimpleDateFormat("dd").format(new Date()))) {
                edad--;
            }
        }
        return edad;
    }
}
