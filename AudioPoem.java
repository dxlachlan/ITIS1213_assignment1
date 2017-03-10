/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampbellDaniel_Assignment1_ITIS1213;

import BookClasses.*;

/**
 * This class contains methods for mixing up the words in an audio file and
 * creating sound poetry out of them. It contains many stub methods which need
 * to be completed as part of Assignment 1.
 *
 * @author Daniel L. Campbell
 *
 *
 */
//Method Added for Assignment 1 - Part 3 is named "myNewMethod"
public class AudioPoem {

    static final int MAX_NUM_WORDS = 100;
    static private Sound[] myWordArray = new Sound[MAX_NUM_WORDS];

    static private int numWords = 0;

    public AudioPoem(Sound originalSource, int[] spliceArray, int numSplicePoints) {

        // break the sound into separate words, copying each into the word array
        for (int i = 0, j = 0; i < numSplicePoints; i = i + 2, j++) {
            myWordArray[j] = new Sound(spliceArray[i + 1] - spliceArray[i]);
            for (int x = spliceArray[i], y = 0; x < spliceArray[i + 1]; x++, y++) {
                myWordArray[j].setSampleValueAt(y, originalSource.getSampleValueAt(x));
            }
            numWords++;
        }

    }

    /**
     * Plays the words, in order with a 200 millisecond pause between each
     *
     * @throws InterruptedException
     */
    public void play() throws InterruptedException {
        // play the words in order
        for (int i = 0; i < numWords; i++) {
            myWordArray[i].blockingPlay();
            Thread.sleep(200);
        }
    }

    /**
     * Plays the words, in order with a parameter-specified pause between each
     *
     * @param pause the number of milliseconds to pause between words
     * @throws InterruptedException
     */
    public void play(int pause) throws InterruptedException {
        // TODO
        // play the words in order
        for (int i = 0; i < numWords; i++) {
            myWordArray[i].blockingPlay();
            Thread.sleep(pause);
        }
    }

    /**
     * Plays the words in random order, each word can be played multiple times
     *
     * @param totalWords the total number of words that will be played
     * @param pause the number of milliseconds to pause between words
     * @throws InterruptedException
     */
    public void playRandomOrder(int totalWords, int pause) throws InterruptedException {
        //TODO
        for (int x = 0; x < totalWords; x++) {
            // repeat number of times desired...

            //generate a random number within the num of Words
            int randomNum = 0 + (int) (Math.random() * numWords);

            System.out.println(randomNum);

            myWordArray[randomNum].blockingPlay();
            Thread.sleep(pause);
        }
    }

    /**
     * Plays the words in random order, playing each word only once
     *
     * @param pause the number of milliseconds to pause between words
     * @throws InterruptedException
     */
    public void playRandomUnique(int pause) throws InterruptedException {
        //TODO

        //create int array to hold random numbers
        int randNumArray[] = new int[numWords];

        //generate random unique int list
        for (int i = 0; i < numWords; i++) {
            randNumArray[i] = 0 + (int) (Math.random() * numWords);

            for (int a = 0; a < i; a++) {
                if (randNumArray[i] == randNumArray[a]) {
                    i--;
                    break;
                }
            }
        }

        // play the words in constructed order
        for (int i = 0; i < numWords; i++) {
            int num = randNumArray[i];
            System.out.println(num);
            myWordArray[num].blockingPlay();
            Thread.sleep(pause);
        }
    }

    /**
     * Plays the sound words in reverse order (e.g. 'this is a test' will be
     * played 'test a is this')
     *
     * @param pause the number of milliseconds to pause between words
     * @throws InterruptedException
     */
    public void playReverseOrder(int pause) throws InterruptedException {
        //TODO
        //create int array to hold num order
        int numArray[] = new int[numWords];

        int left = 0;
        int right = numArray.length - 1;

        //fill the int array with numbers
        for (int i = 0; i < numWords; i++) {
            System.out.println(i);
            numArray[i] = i;
        }

        //resort the numbers in descending order
        while (left < right) {
            //swap the values at the left and right positions
            int temp = numArray[left];
            numArray[left] = numArray[right];
            numArray[right] = temp;

            left++;
            right--;
        }

        // play the words in constructed order
        for (int i = 0; i < numWords; i++) {
            int num = numArray[i];
            //System.out.println(num);
            myWordArray[num].blockingPlay();
            Thread.sleep(pause);
        }

    }

    /**
     * Plays random consecutive pairs of words with only a 100 millisecond pause
     * between them, with a four hundred millisecond pause between pairs Ex: for
     * 'this is a test' a pair would be 'this is' or 'is a' or 'a test'
     *
     * @param numDoublets the number of doublets to play
     * @throws InterruptedException
     */
    public void playDoublets(int numDoublets) throws InterruptedException {

        //for the number of doublets requested
        for (int i = 0; i < numDoublets; i++) {
            //generate a random number within the num of Words
            int randomNum = 0 + (int) (Math.random() * (numWords - 1));

            myWordArray[randomNum].blockingPlay();
            //System.out.println(randomNum);

            Thread.sleep(100);

            myWordArray[randomNum + 1].blockingPlay();
            //System.out.println(randomNum+1);

            Thread.sleep(400);
            //System.out.println(" ");

        }
        //generate a random number of ints (within range of the number of words)
        //subtract one from the max number of words to allow for proper

    }

    /**
     * Plays random consecutive triplets of words with only a 100 millisecond
     * pause between the three words, with a four hundred millisecond pause
     * between triplets Ex: for 'this is a test' a triplet would be 'this is a'
     * or 'is a test'
     *
     * @param numTriplets the number of triplets to play
     * @throws InterruptedException
     */
    public void playTriplets(int numTriplets) throws InterruptedException {
        //for the number of doublets requested
        for (int i = 0; i < numTriplets; i++) {
            //generate a random number within the num of Words
            int randomNum = 0 + (int) (Math.random() * (numWords - 2));

            myWordArray[randomNum].blockingPlay();
            //System.out.println(randomNum);

            Thread.sleep(100);

            myWordArray[randomNum + 1].blockingPlay();
            //System.out.println(randomNum+1);

            Thread.sleep(100);

            myWordArray[randomNum + 2].blockingPlay();
            //System.out.println(randomNum+2);

            Thread.sleep(400);
            //System.out.println(" ");

        }
    }

    /**
     *
     * PART II - Overloaded Methods & New Sound Method -[ Accepts a String
     * Filename] -[ Saves to a Filepath
     *
     */
    //Two Prep Methods for Part II
    //Calculate Number of Silent Samples
    private static int calculateNumberOfSilentSamples(Sound sound, int pause) {

        int numSilentSamples = (int) (pause / 1000 * (sound.getSamplingRate()));

        //return calculation
        return numSilentSamples;

    }

    //Write Sound to File Method
    private static void writeSoundToFile(String path, String filename, Sound newSound) {
        //set up path to where sound files are
        FileChooser.setMediaPath(path);

        //open the sound
        Sound sound1 = new Sound(filename);

        //explore the sound 
        //sound1.explore();
        System.out.println(sound1.getFileName());
        sound1.write(path + filename);

    }

    //New Method - Slowly Increases Each Word Played By A Factor
    public void myNewMethod(int pause) throws InterruptedException {

        //Factor to Change the Volume By
        double factor = 0.25;
        //Number to  Increment the Factor By
        double factorInc = 1.00;

        // manipulate the words in order
        for (int i = 0; i < numWords; i++) {
            //change word by factor
            myWordArray[i].changeVolume(factor);
            //play each word
            myWordArray[i].blockingPlay();
            //pause
            Thread.sleep(pause);

            //increment factor
            factor = (factorInc + factor);
        }
    }

    /**
     * Plays the words, in order with a parameter-specified pause between each
     *
     * @param pause the number of milliseconds to pause between words
     * @param path the file path to save the file at
     * @param filename the name to save the file as
     * @throws InterruptedException
     */
    public void play(int pause, String filename, String path) throws InterruptedException {

        //Initialize counter for Total Number of Sound Samples
        int total_soundSamples = 0;
        //Initialize counter for number of Pause Samples && Convert

        //This takes the pause variable and calculates to determine
        // how many seconds to pause in measurement of "samples"
        int pauseNumSamples = (int) (pause / 1000.0 * (myWordArray[0].getSamplingRate()));
        System.out.println("Calculate the number of samples to pause for");
        System.out.println(pauseNumSamples);

        System.out.println("total number of samples");

        //get the number of samples for each phrase
        for (int x = 0; x < numWords; x++) {
            //This gets the sample count for each phrase
            total_soundSamples
                    = (total_soundSamples + myWordArray[x].getNumSamples());
            //check number
            System.out.println(total_soundSamples);
            //get the number of silent samples based on the pause
            total_soundSamples
                    = (total_soundSamples + pauseNumSamples);
            //check number
            System.out.println(total_soundSamples);

        }

        //create new sound
        Sound newSound = new Sound(total_soundSamples);

        //create temp array to hold the samples generated from new order
        SoundSample[] sampleArray = newSound.getSamples();
        SoundSample[] tempArray;
        int tempIndex = 0;

        SoundSample sample = null;

        for (int w = 0; w < numWords; w++) {
            myWordArray[w].blockingPlay();
            
            tempArray = myWordArray[w].getSamples();

            for (int i = 0; i < tempArray.length - 1; i++);
            {
                //sampleArray[tempIndex[w]].setValue()
                

            }
        }

        // play the words in order
        for (int i = 0; i < numWords; i++) {
            myWordArray[i].blockingPlay();
            Thread.sleep(pause);
        }
    }

    /**
     * Plays the words in random order, each word can be played multiple times
     *
     * @param totalWords the total number of words that will be played
     * @param pause the number of milliseconds to pause between words
     * @param path the file path to save the file at
     * @param filename the name to save the file as
     * @throws InterruptedException
     */
    public void playRandomOrder(int totalWords, int pause, String filename, String path) throws InterruptedException {
        //TODO
        for (int x = 0; x < totalWords; x++) {
            // repeat number of times desired...

            //generate a random number within the num of Words
            int randomNum = 0 + (int) (Math.random() * numWords);

            System.out.println(randomNum);

            myWordArray[randomNum].blockingPlay();
            Thread.sleep(pause);
        }
    }

    /**
     * Plays the words in random order, playing each word only once
     *
     * @param pause the number of milliseconds to pause between words
     * @param path the file path to save the file at
     * @param filename the name to save the file as
     * @throws InterruptedException
     */
    public void playRandomUnique(int pause, String filename, String path
    ) throws InterruptedException {
        //TODO

        //create int array to hold random numbers
        int randNumArray[] = new int[numWords];

        //generate random unique int list
        for (int i = 0; i < numWords; i++) {
            randNumArray[i] = 0 + (int) (Math.random() * numWords);

            for (int a = 0; a < i; a++) {
                if (randNumArray[i] == randNumArray[a]) {
                    i--;
                    break;
                }
            }
        }

        // play the words in constructed order
        for (int i = 0; i < numWords; i++) {
            int num = randNumArray[i];
            System.out.println(num);
            myWordArray[num].blockingPlay();
            Thread.sleep(pause);
        }
    }

    /**
     * Plays the sound words in reverse order (e.g. 'this is a test' will be
     * played 'test a is this')
     *
     * @param pause the number of milliseconds to pause between words
     * @param path the file path to save the file at
     * @param filename the name to save the file as
     * @throws InterruptedException
     */
    public void playReverseOrder(int pause, String filename, String path) throws InterruptedException {
        //TODO
        //create int array to hold num order
        int numArray[] = new int[numWords];

        int left = 0;
        int right = numArray.length - 1;

        //fill the int array with numbers
        for (int i = 0; i < numWords; i++) {
            System.out.println(i);
            numArray[i] = i;
        }

        //resort the numbers in descending order
        while (left < right) {
            //swap the values at the left and right positions
            int temp = numArray[left];
            numArray[left] = numArray[right];
            numArray[right] = temp;

            left++;
            right--;
        }

        // play the words in constructed order
        for (int i = 0; i < numWords; i++) {
            int num = numArray[i];
            //System.out.println(num);
            myWordArray[num].blockingPlay();
            Thread.sleep(pause);
        }

    }

    /**
     * Plays random consecutive pairs of words with only a 100 millisecond pause
     * between them, with a four hundred millisecond pause between pairs Ex: for
     * 'this is a test' a pair would be 'this is' or 'is a' or 'a test'
     *
     * @param numDoublets the number of doublets to play
     * @param path the file path to save the file at
     * @param filename the name to save the file as
     * @throws InterruptedException
     */
    public void playDoublets(int numDoublets, String filename, String path
    ) throws InterruptedException {

        //for the number of doublets requested
        for (int i = 0; i < numDoublets; i++) {
            //generate a random number within the num of Words
            int randomNum = 0 + (int) (Math.random() * (numWords - 1));

            myWordArray[randomNum].blockingPlay();
            //System.out.println(randomNum);

            Thread.sleep(100);

            myWordArray[randomNum + 1].blockingPlay();
            //System.out.println(randomNum+1);

            Thread.sleep(400);
            //System.out.println(" ");

        }
        //generate a random number of ints (within range of the number of words)
        //subtract one from the max number of words to allow for proper

    }

    /**
     * Plays random consecutive triplets of words with only a 100 millisecond
     * pause between the three words, with a four hundred millisecond pause
     * between triplets Ex: for 'this is a test' a triplet would be 'this is a'
     * or 'is a test'
     *
     * @param numTriplets the number of triplets to play
     * @param path the file path to save the file at
     * @param filename the name to save the file as
     * @throws InterruptedException
     */
    public void playTriplets(int numTriplets, String filename, String path
    ) throws InterruptedException {
        //for the number of doublets requested
        for (int i = 0; i < numTriplets; i++) {
            //generate a random number within the num of Words
            int randomNum = 0 + (int) (Math.random() * (numWords - 2));

            myWordArray[randomNum].blockingPlay();
            //System.out.println(randomNum);

            Thread.sleep(100);

            myWordArray[randomNum + 1].blockingPlay();
            //System.out.println(randomNum+1);

            Thread.sleep(100);

            myWordArray[randomNum + 2].blockingPlay();
            //System.out.println(randomNum+2);

            Thread.sleep(400);
            //System.out.println(" ");

        }
    }

    public void playTest(int pause, String filename, String path) throws InterruptedException {
        // TODO

        //Determine The Number of Words
        System.out.println("Number of Words");
        System.out.println(numWords);

        //counter for total number of samples
        int total_soundSamples = 0;

        /*
         * DETERMINE WHICH WORD IS THE LONGEST
         */
        int largestSound = myWordArray[0].getNumSamples();
        for (int i = 0; i < myWordArray.length; i++) {
            if (myWordArray[i].getNumSamples() > largestSound) {
                largestSound = myWordArray[i].getNumSamples();
            }
        }

        //This takes the pause variable and calculates to determine
        // how many seconds to pause in measurement of "samples"
        int pauseNumSamples = (int) (pause / 1000.0 * (myWordArray[0].getSamplingRate()));
        System.out.println("Calculate the number of samples to pause for");
        System.out.println(pauseNumSamples);

        System.out.println("total number of samples");

        //get the number of samples for each phrase
        for (int x = 0; x < numWords; x++) {
            //This gets the sample count for each phrase
            total_soundSamples
                    = (total_soundSamples + myWordArray[x].getNumSamples());
            //check number
            System.out.println(total_soundSamples);
            //get the number of silent samples based on the pause
            total_soundSamples
                    = (total_soundSamples + pauseNumSamples);
            //check number
            System.out.println(total_soundSamples);

        }

        //create a new sound based on the total number of samples
        Sound newSound = new Sound(total_soundSamples);

        //SoundSample[] sampleArray = newSound.getSamples();
        //counter 
        int sample = 0;

        /**
         * For EACH WORD IN THE myWordArray get the Word
         *
         * From the word get sound samples and store in a temp array
         */
        for (int i = 0; i < numWords - 1; i++) {

            for (int x = 0; x < (myWordArray[i].getNumSamples() - 1); x++) {

                sample = myWordArray[i].getSampleValueAt(x);

                //sampleArray[x+x].setValue(sample);
                newSound.setSampleValueAt(x, sample);

            }

        }

        newSound.explore();

        //create a sound object
        // play the words in order
        //for (int i = 0; i < numWords; i++) {
        // myWordArray[i].blockingPlay();
        //Thread.sleep(pause);
    }

}
