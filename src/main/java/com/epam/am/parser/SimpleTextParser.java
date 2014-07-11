package com.epam.am.parser;

import com.epam.am.entity.*;
import com.epam.am.helper.PropertyManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTextParser {

    private static final PropertyManager MANAGER = PropertyManager.getManager(PropertyManager.REGEX);

    public static final String TEXT = "text.txt";
    private static final String GROUP_WORD = MANAGER.getProperty("group.word");
    private static final String GROUP_PUNCTUATION = MANAGER.getProperty("group.punct");
    private static final String GROUP_PARAGRAPH = MANAGER.getProperty("group.par");
    private static final String GROUP_WHITESPACE = MANAGER.getProperty("group.space");
    private static final String GROUP_SENTENCE = MANAGER.getProperty("group.sentence");
    private static final String GROUP_END = MANAGER.getProperty("group.end");

    private static final Pattern PATTERN_SENTENCE_PARTS =
            Pattern.compile(MANAGER.getProperty("pattern.sentence.parts"),
                    Pattern.UNICODE_CHARACTER_CLASS);

    private static final Pattern PATTERN_SENTENCE =
            Pattern.compile(MANAGER.getProperty("pattern.sentence"),
                    Pattern.UNICODE_CHARACTER_CLASS);

    private static final Pattern PATTERN_PARAGRAPH =
            Pattern.compile(MANAGER.getProperty("pattern.paragraph"),
                    Pattern.UNICODE_CHARACTER_CLASS);

    public static String getAsString(String resource) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        SimpleTextParser.class.getClassLoader().getResourceAsStream(resource)));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static Text parseText(String source) {
        Text result = new Text();
        Matcher matcher = PATTERN_PARAGRAPH.matcher(source);
        while (matcher.find()) {
            if (matcher.group(GROUP_PARAGRAPH) != null) {
                Paragraph paragraph = parseParagraph(matcher.group(GROUP_PARAGRAPH));
                result.add(paragraph);
            }
        }
        return result;
    }

    public static Paragraph parseParagraph(String source) {
        Paragraph paragraph = new Paragraph();
        Matcher sentenceMatcher = PATTERN_SENTENCE.matcher(source);
        while (sentenceMatcher.find()) {
            Sentence sentence = null;
            if (sentenceMatcher.group(GROUP_SENTENCE) != null) {
                sentence = parseSentence(sentenceMatcher.group());
            }
            if (sentence == null) sentence = new Sentence();
            paragraph.add(sentence);
        }
        return paragraph;
    }

    public static Sentence parseSentence(String str) {
        Matcher matcher = PATTERN_SENTENCE_PARTS.matcher(str);
        Sentence result = new Sentence();
        while (matcher.find()) {
            if (matcher.group(GROUP_WORD) != null) {
                result.add(new Word(matcher.group()));
            }
            if (matcher.group(GROUP_WHITESPACE) != null) {
                result.add(WhiteSpace.getInstance());
            }
            if (matcher.group(GROUP_PUNCTUATION) != null) {
                result.add(new PunctuationMark(matcher.group()));
            }
        }
        return result;
    }
}
