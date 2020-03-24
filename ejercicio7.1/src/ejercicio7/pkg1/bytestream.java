/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.StringWriter;
import java.io.PrintWriter;
/**
 *
 * @author Alberto Real
 */
public class bytestream {

    public bytestream() {
    }
    public void readAndWtrite(String origen, String destino) throws FileNotFoundException {
        int i;
        int k = -1;
        char inicial = '#';
        char linea = '{';
        int prueba[][] = {{97, 110, 111, 58},//año:
        {68, 105, 114, 101, 99, 116, 111, 114, 58},//director
        {100, 117, 114, 97, 99, 105, 111, 110, 58},//duracion
        {115, 105, 110, 111, 112, 115, 105, 115, 58},//sinopsis
        {114, 101, 97, 112, 114, 116, 111, 58},//reparto
        {115, 101, 115, 115, 105, 111, 110, 58}};//sesion
        try (FileInputStream entrada = new FileInputStream(origen);
                FileOutputStream salida = new FileOutputStream(destino)) {
            do {
                i = entrada.read();
                if (i != -1) {
                    if ((char) i == inicial) {
                        salida.write(13);
                        salida.write(10);
                        if (k < prueba.length - 1) {
                            k++;
                        } else {
                            k = 0;
                        }
                        salida.write(13);
                        salida.write(10);
                        for (int j = 0; j < prueba[k].length; j++) {
                            salida.write(prueba[k][j]);
                        }
                    } else if ((char) i == linea) {
                        salida.write(13);
                        salida.write(10);
                        salida.write(13);
                        salida.write(10);
                        salida.write(45);
                        salida.write(45);
                        salida.write(45);
                        salida.write(45);
                    } else {
                        salida.write(i);
                    }
                }
            } while (i != -1);
        } catch (IOException exc) {
            System.out.println("error de fichero ");
            errorlog(exc);
        }
    }
    public void errorlog(IOException exc) throws FileNotFoundException {
        Date fecha = new Date(); 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exc.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy  ");
        try (FileOutputStream errorlog = new FileOutputStream("D:\\log.txt",true)) {
            byte[] strToBytes = sStackTrace.getBytes();
            byte[] fechatobyte =fechaHora.format(fecha).getBytes();
            errorlog.write(13);
            errorlog.write(10);
            errorlog.write(fechatobyte);
            errorlog.write(strToBytes);
        } catch (IOException es) {
            System.out.println("error");
        }
    }
}
