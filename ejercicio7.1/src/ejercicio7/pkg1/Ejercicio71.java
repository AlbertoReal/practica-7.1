/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.FileNotFoundException;

/**
 *
 * @author Alberto Real
 */
public class Ejercicio71 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
       bytestream p1 = new bytestream();
       p1.readAndWtrite("c:\\entrada.txt","d:\\salida.txt"); //entrada archivo de origen salida destino
    }
}
