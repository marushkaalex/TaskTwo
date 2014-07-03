package com.epam.am.helper;

import com.epam.am.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    //TODO fix "dfgdsfgsdfg.dsfgsdfgdsfsd .dsfg"
    //TODO fix sentences don't end with dots

    public static final String TEXT = "text.txt";
    private static final String GROUP_WORD = "word";
    private static final String GROUP_PUNCTUATION = "punctuation";
    private static final String GROUP_PARAGRAPH = "paragraph";
    private static final String GROUP_WHITESPACE = "space";
    private static final Pattern PATTERN =
            Pattern.compile("(?<word>\\b[-'\\w]+\\b)|(?<space> )|(?<punctuation>[- \":;?!@#$%^&*()+/\\\\,\\.])|(?<paragraph>\\r\\n)",
                    Pattern.UNICODE_CHARACTER_CLASS);

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
        Matcher matcher = PATTERN.matcher(source);
        while (matcher.find()) {
            if (matcher.group(GROUP_PARAGRAPH) == null)
                paragraph.add(readSentence(matcher));
        }
        return true;
    }

    private static Sentence readSentence(Matcher matcher) {
        Sentence result = new Sentence();
        while (fillSentence(matcher, result)) {
            if (!matcher.find() || matcher.group(GROUP_PARAGRAPH) != null) break;
        }
        return result;
    }

    private static boolean fillSentence(Matcher matcher, Sentence sentence) {
        if (matcher.group() == null || matcher.group(GROUP_PARAGRAPH) != null) return false;
        if (matcher.group(GROUP_WORD) != null) {
            sentence.add(new Word(matcher.group(GROUP_WORD)));
            return true;
        }
        if (matcher.group(GROUP_WHITESPACE) != null) {
            sentence.add(WhiteSpace.getInstance());
            return true;
        }
        if (matcher.group(GROUP_PUNCTUATION) != null) {
            sentence.add(new PunctuationMark(matcher.group(GROUP_PUNCTUATION)));
            return true;
        }
        return false;
    }
}
