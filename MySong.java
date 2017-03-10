/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampbellDaniel_Assignment1_ITIS1213;

import BookClasses.MidiPlayer;

/**
 *
 * @author Daniel L. Campbell
 */
public class MySong {

    private MidiPlayer myPlayer;

    /**
     * Creates a MIDIPlayer to use to play the song
     */
    public MySong() {
        myPlayer = new MidiPlayer();
    }

    /**
     * Plays simplified version of the Cup Song (When I'm Gone)
     */
    public void play() {
        //rest code
        //myPlayer.rest(250);

        // measure 1
        myPlayer.playNote(71, 500); //c quarter note
        myPlayer.playNote(69, 500); // e quarter note

        // second measure
        myPlayer.playNote(67, 500);
        myPlayer.playNote(67, 500);
        myPlayer.playNote(67, 500);
        myPlayer.playNote(59, 250);
        myPlayer.playNote(60, 250);

        // third measure
        myPlayer.playNote(62, 250);
        myPlayer.playNote(64, 250);
        myPlayer.playNote(62, 250);
        myPlayer.playNote(59, 250);
        myPlayer.playNote(62, 500);
        myPlayer.playNote(67, 250);
        myPlayer.playNote(69, 250);

        // fourth measure
        myPlayer.playNote(71, 250);
        myPlayer.playNote(71, 250);
        myPlayer.playNote(71, 250);
        myPlayer.playNote(71, 250);
        myPlayer.playNote(71, 500);
        myPlayer.playNote(67, 250);
        myPlayer.playNote(69, 250);

        // fifth measure
        myPlayer.playNote(71, 250);
        myPlayer.playNote(69, 250);
        myPlayer.playNote(69, 250);
        myPlayer.playNote(68, 250);
        myPlayer.playNote(69, 500);
        myPlayer.playNote(71, 250);
        myPlayer.playNote(69, 250);

        // sixth measure
        myPlayer.playNote(67, 250);
        myPlayer.playNote(69, 250);
        myPlayer.playNote(67, 250);
        myPlayer.playNote(69, 250);
        myPlayer.playNote(67, 250);
        myPlayer.playNote(62, 250);
        myPlayer.playNote(59, 250);
        myPlayer.playNote(60, 250);

        // seventh measure
        myPlayer.playNote(62, 250);
        myPlayer.playNote(64, 250);
        myPlayer.playNote(62, 250);
        myPlayer.playNote(59, 250);
        myPlayer.playNote(62, 250);
        myPlayer.playNote(62, 250);
        myPlayer.playNote(67, 250);
        myPlayer.playNote(69, 250);

        // eight measure
        myPlayer.playNote(71, 500);
        myPlayer.rest(500);
        myPlayer.playNote(69, 250);
        myPlayer.rest(500);
        myPlayer.playNote(67, 1000);
        myPlayer.rest(500);
        myPlayer.playNote(62, 250);

        myPlayer.playNote(60, 250);

        myPlayer.playNote(67, 1000);
        myPlayer.rest(1000);

        // eleventh measure
    }

    /**
     * Changes the MIDI instrument
     *
     * @param num must be between 0 and 127
     */
    public void changeInstrument(int num) {
        if ((num >= 0) && (num < 128)) {
            myPlayer.setInstrument(num);
        } else {
            System.out.println("That's not a valid instrument number");
        }
    }
}
