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
public class CupSong {

    private MidiPlayer myPlayer;

    /**
     * Creates a MIDIPlayer to use to play the song
     */
    public CupSong() {
        myPlayer = new MidiPlayer();
    }

    /**
     * Plays simplified version of the Cup Song (When I'm Gone)
     */
    public void play() {

        // measure 1
        myPlayer.playNote(72, 250); //c quarter note
        myPlayer.playNote(76, 250); // e quarter note
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250); // d quarter note
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);

        // second measure
        myPlayer.playNote(76, 500);
        myPlayer.playNote(79, 500);
        myPlayer.playNote(79, 1000);

        // third measure
        myPlayer.rest(250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(79, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(79, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(79, 250);

        // fourth measure
        myPlayer.playNote(79, 1500);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(79, 250);

        // fifth measure
        myPlayer.playNote(81, 500);
        myPlayer.playNote(81, 500);
        myPlayer.playNote(79, 500);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(76, 250);

        // sixth measure
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 500);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(69, 500);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(76, 500); // bridge into next measure

        // seventh measure
        //myPlayer.playNote(76,250); // bridged from last
        myPlayer.playNote(76, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);

        // eight measure
        myPlayer.playNote(72, 1500);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(72, 250);

        // ninth measure
        myPlayer.playNote(69, 1500);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(72, 250);

        // tenth measure
        myPlayer.playNote(72, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(76, 1500); // bridge into next measure
        //myPlayer.playNote(76,1000);

        // eleventh measure
        //myPlayer.playNote(76,250); // brided from last
        myPlayer.playNote(81, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(79, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(79, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(79, 250);

        // twelfth measure
        myPlayer.playNote(79, 1500);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(79, 250);

        // thirteenth measure
        myPlayer.playNote(81, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(81, 250);
        myPlayer.playNote(79, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(72, 250);

        // fourteenth measure
        myPlayer.playNote(74, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(69, 500); // bridge into next measure

        // fifteenth measure
        // myPlayer.playNote(81,250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(74, 250);
        myPlayer.playNote(76, 250);
        myPlayer.playNote(74, 250);

        // sixteenth measure
        myPlayer.playNote(72, 1500);
        myPlayer.playNote(72, 250);
        myPlayer.playNote(72, 250);
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
