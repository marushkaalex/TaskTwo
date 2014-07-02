package com.epam.am.helper;

import com.epam.am.entity.Paragraph;
import com.epam.am.entity.PunctuationMark;
import com.epam.am.entity.Sentence;
import com.epam.am.entity.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    public static final String TEXT = "text.txt";
    private static final Pattern PATTERN_WORD = Pattern.compile("([-'0-9A-z]+)([-.,:;])?");

    public static String getAsString(String resource) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        TextParser.class.getClassLoader().getResourceAsStream(resource)));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static boolean readParagraph(String source, Paragraph paragraph) {
        Matcher matcher = PATTERN_WORD.matcher(source);
        while (matcher.find()) {
            paragraph.add(readSentence(matcher));
        }
        return true;
    }

    private static Sentence readSentence(Matcher matcher) {
        Sentence result = new Sentence();
        while (fillSentence(matcher, result)) {
            if (!matcher.find()) break;
        }
        return result;
    }

    private static boolean fillSentence(Matcher matcher, Sentence sentence) {
        System.out.println(matcher.group());
        if (matcher.group(2) != null) {
            sentence.add(new Word(matcher.group(1)));
            sentence.add(new PunctuationMark(matcher.group(2)));
            return !matcher.group(2).equals(".");
        } else {
            sentence.add(new Word(matcher.group(1)));
            return true;
        }
    }
}
