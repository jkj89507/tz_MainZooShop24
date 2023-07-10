package helpers;

import org.openqa.selenium.WebElement;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utils {
    /**
     * Генерирует строку на английском языке заданной длины
     *
     * @param length длина генерируемой строки
     * @return сгенерированный англ.текст
     */
    public static String generateEnglishText(int length) {
        String text = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            text += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return text;
    }

    /**
     * Генерирует строку на русском языке заданной длины
     *
     * @param length длина генерируемой строки
     * @return сгенерированный рус.текст
     */
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

    /**
     * Генерирует строку чисел заданной длины
     *
     * @param length длина генерируемой строки
     * @return сгенерировання строка чисел
     */
    public static String generateNumberText(int length) {
        String text = "";
        String alphabet = "0123456789";
        for (int i = 0; i < length; i++) {
            text += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return text;
    }

    /**
     * Генерирует строку спец.символов заданной длины
     *
     * @param length длина генерируемой строки
     * @return сгенерировання строка спец.символов
     */
    public static String generateSymbolText(int length) {
        String text = "";
        String alphabet = ".,;-_@'+*\\/[]{}()";
        for (int i = 0; i < length; i++) {
            text += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return text;
    }

    /**
     * Симулирует ручной ввод с клавиатуры
     *
     * @param element Web-элемент для ввода значения
     * @param text вводимое значение
     */
    public static void sendKeysWithDelay(WebElement element, String text) {
        Random rand = new Random();
        for (char c : text.toCharArray()) {
            int ms = rand.nextInt(100) + 1;
            element.sendKeys(Character.toString(c));
            delay(ms);
        }
    }

    /**
     * Временная задержка исполнения тестов
     *
     * @param ms время задержки в мс.
     */
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     *  Перемешивание позиций символов в строке
     *
     * @param value входное значеним
     * @return перемешенная строрка
     */
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
