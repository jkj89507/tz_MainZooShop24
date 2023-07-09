package helpers;

import org.openqa.selenium.WebElement;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utils {
    public static String generateEnglishText(int length) {
        String text = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            text += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return text;
    }

    public static String generateRussianText(int length) {
        String text = "";
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for (int i = 0; i < length; i++) {
            text += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        byte[] utf16Bytes  = text.getBytes(Charset.forName("UTF-16"));
        String cp1251String = new String(utf16Bytes, Charset.forName("CP1251"));
        return cp1251String;
    }

    public static String generateNumberText(int length) {
        String text = "";
        String alphabet = "0123456789";
        for (int i = 0; i < length; i++) {
            text += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return text;
    }

    public static String generateSymbolText(int length) {
        String text = "";
        String alphabet = ".,;-_@'+*\\/[]{}()";
        for (int i = 0; i < length; i++) {
            text += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return text;
    }

    public static void sendKeysWithDelay(WebElement element, String text) {
        Random rand = new Random();
        for (char c : text.toCharArray()) {
            int ms = rand.nextInt(100) + 1;
            element.sendKeys(Character.toString(c));
            delay(ms);
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String shuffleString(String value) {
        List<Character> characters = new ArrayList<>();
        for (char c : value.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder output = new StringBuilder();
        for (char c : characters) {
            output.append(c);
        }
        return output.toString();
    }
}
