/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampbellDaniel_Assignment1_ITIS1213;

import BookClasses.*;
import java.io.*;
import java.nio.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * This is the test harness for Assignment 1, and it is used to call and test
 * the audio poetry methods.
 *
 * @author Daniel L. Campbell
 */
public class Assignment1_ITIS1213 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //TODO: change the path below to reflect the path to your mediasources file
        String path = "/Users/danielcampbell/Desktop/ITIS1213/mediasources/";

        //*********************************************************************
        // DO NOT CHANGE THE CODE BELOW
        int spliceIndex[] = new int[200];
        int numSplicePoints = 0;
        String soundFilename;
        String spliceFilename;

        // next two lines create a custom file chooser, with a specific frame heading
        JFileChooser myChooser = new JFileChooser(path);
        myChooser.setDialogTitle("Please select a sound file...");
        // now set media path to point to media sources
        FileChooser.setMediaPath(path);
        // open file chooser and get name of sound file
        soundFilename = FileChooser.pickPath(myChooser);
        // create a sound object from this filename
        Sound mySound = new Sound(soundFilename);

        // try to open the second file, which contains the list of splice points
        myChooser.setDialogTitle("Now select the file that contains the splice points...");
        spliceFilename = FileChooser.pickPath(myChooser);
        // open the file
        File file = new File(spliceFilename);
        // create a scanner object variable so we can read in the file, token by token
        Scanner s = null;
        // some of the code below could generate exceptions, so enclose in try-catch
        try {
            s = new Scanner(new BufferedReader(new FileReader(file)));
            // check if there is another token in the file
            while (s.hasNext()) {
                // check if it's a number
                if (s.hasNextInt()) {
                    // add it to the array, increment number of items in array
                    spliceIndex[numSplicePoints] = s.nextInt();
                    numSplicePoints++;
                } else {
                    // if it's not a number, skip it
                    s.next();
                }
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("main method: splicefile not found");
        } catch (InputMismatchException ime) {
            System.out.println("main method: splice input not integer");
        } catch (NoSuchElementException nsee) {
            System.out.println("main method: no such element after " + numSplicePoints);
        } finally {
            // this gets called no matter what, to close the scanner
            if (s != null) {
                s.close();
            }
        }

        // create an audiopoem object out of the sound and the splicearary
        AudioPoem myPoem = new AudioPoem(mySound, spliceIndex, numSplicePoints);

        // DO NOT CHANGE THE CODE ABOVE
        //**********************************************************
        //**********************************************************
        // TODO: Put your assignment 1 main method code here
        //Assignment 1 - Part 1 Testing Below
        myPoem.play();
        myPoem.play(600);
        myPoem.playRandomOrder(10, 1200);
        //tested = good
        myPoem.playRandomUnique(1200);
        //tested = good
        myPoem.playReverseOrder(400);
        //tested = good
        myPoem.playDoublets(10);
        //tested = good
        myPoem.playTriplets(10);
        //tested = good

        //Assignment 1 - Part II Testing Below
        myPoem.play(600, "normalPlay", "/Users/danielcampbell/Desktop/ITIS1213/mediasources");
        myPoem.playRandomOrder(10, 1200, "playRandomOrder", "/Users/danielcampbell/Desktop/ITIS1213/mediasources");
        //tested = good
        myPoem.playRandomUnique(1200, "randomUnique", "/Users/danielcampbell/Desktop/ITIS1213/mediasources");
        //tested = good
        myPoem.playReverseOrder(400, "reverseOrder", "/Users/danielcampbell/Desktop/ITIS1213/mediasources");
        //tested = good
        myPoem.playDoublets(10, "doublets", "/Users/danielcampbell/Desktop/ITIS1213/mediasources");
        //tested = good
        myPoem.playTriplets(10, "triplets", "/Users/danielcampbell/Desktop/ITIS1213/mediasources");
        //tested = good

        //Assignment 1 - Part III - New Method
        myPoem.myNewMethod(100);

        //Assignment 1 - PART 4 - Song
        MySong chainSong = new MySong();
        chainSong.play();
        chainSong.changeInstrument(24);
        chainSong.play();
        chainSong.changeInstrument(78);
        chainSong.play();
        chainSong.changeInstrument(58);
        chainSong.play();

    }

}
