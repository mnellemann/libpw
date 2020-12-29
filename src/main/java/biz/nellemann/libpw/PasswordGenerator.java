package biz.nellemann.libpw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

public class PasswordGenerator {

    private final static Logger log = LoggerFactory.getLogger(PasswordGenerator.class);

    protected static final String alphaChars = "abcdefghijklmnopqrstuvwxyz";
    protected static final String alphaCapsChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected static final String numeralChars = "0123456789";
    protected static final String symbolChars = "!'#%&/()=?_-+*,.<>";

    private static final SecureRandom rnd = new SecureRandom();

    public static String random(int passwordLength, Boolean useCapitalizedChars, Boolean useNumeralChars,
            Boolean useSymbolChars) {

        int numberOfChars = passwordLength;
        int numberOfCharsCapitalized;
        int numberOfCharsNumerals;
        int numberOfCharsSymbols;

        int charArrayPointer = 0;
        char[] charArray = new char[passwordLength];

        if (useCapitalizedChars) {
            numberOfCharsCapitalized = (int) Math.floor(passwordLength * 0.30);
            numberOfChars = numberOfChars - numberOfCharsCapitalized;
            charArrayPointer = addCharsToArray(charArray, charArrayPointer, numberOfCharsCapitalized, 'A');
        }

        if (useNumeralChars) {
            numberOfCharsNumerals = (int) Math.floor(passwordLength * 0.25);
            numberOfChars = numberOfChars - numberOfCharsNumerals;
            charArrayPointer = addCharsToArray(charArray, charArrayPointer, numberOfCharsNumerals, 'N');
        }

        if (useSymbolChars) {
            numberOfCharsSymbols = (int) Math.floor(passwordLength * 0.20);
            numberOfChars = numberOfChars - numberOfCharsSymbols;
            charArrayPointer = addCharsToArray(charArray, charArrayPointer, numberOfCharsSymbols, 'S');
        }

        addCharsToArray(charArray, charArrayPointer, numberOfChars, 'a');
        shuffleArray(charArray);

        StringBuilder sb = new StringBuilder(passwordLength);
        for (char c : charArray) {

            log.debug(" > " + c);
            switch (c) {
                case 'a':
                    sb.append(getRandom(alphaChars));
                    break;
                case 'A':
                    sb.append(getRandom(alphaCapsChars));
                    break;
                case 'N':
                    sb.append(getRandom(numeralChars));
                    break;
                case 'S':
                    sb.append(getRandom(symbolChars));
                    break;
            }
        }
        return sb.toString();
    }

    static private char getRandom(String str) {
        return str.charAt(rnd.nextInt(str.length()));
    }

    static private int addCharsToArray(char[] a, int p, int n, char charToAdd) {

        log.debug("Adding char " + charToAdd + " to charArray from pointer " + p);

        for (int i = 0; i < n; i++) {
            a[p] = charToAdd;
            p++;
        }

        return p;
    }

    // Implementing Fisher–Yates shuffle
    static private void shuffleArray(char[] charArray) {
        for (int i = charArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            char a = charArray[index];
            charArray[index] = charArray[i];
            charArray[i] = a;
        }
    }
}
