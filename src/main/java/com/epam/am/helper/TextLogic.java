package com.epam.am.helper;

import com.epam.am.entity.*;

import java.util.*;
import java.util.regex.Pattern;

public class TextLogic {

    //2
    public Paragraph sortSentencesByWordsCount(Text text) {
        Paragraph result = new Paragraph();
        for (Paragraph paragraph : text.getParagraphs()) {
            for (Sentence sentence : paragraph.getSentences()) {
                result.add(sentence);
            }
        }
        Collections.sort(result.getSentences(), (a, b) -> a.getSentenceParts().size() == b.getSentenceParts().size()
                ? 0 : a.getSentenceParts().size() > b.getSentenceParts().size() ? 1 : -1);
        return result;
    }

    //3
    /**
     * Finds only first sentence non-recurring words
     *
     * @return non-recurring words
     */
    public List<Word> findNonRecurringWords(Text text) {
        List<Sentence> sentences = text.getAsParagraph().getSentences();
        List<Word> result = new ArrayList<>();
        if (sentences.size() == 0) return result;
        List<Word> firstSentence = sentences.get(0).getWords();
        for (Word word : firstSentence) {
            if (!matchWord(word, sentences)) result.add(word);
        }
        return result;
    }

    private boolean matchWord(Word w, List<Sentence> sentences) {
        for (int i = 1; i < sentences.size(); i++) {
            for (Word word : sentences.get(i).getWords()) {
                if (w.equals(word)) return true;
            }
        }
        return false;
    }

    /**
     * @param text         source text
     * @param sentenceType use constants from TextLogic.SentenceType class
     * @param length       length of words
     * @return set of found words
     */
    public Set<Word> findWordsByLength(Text text, int sentenceType, int length) {
        List<Sentence> source = findSentencesOfType(text, sentenceType);
        Set<Word> result = new HashSet<>();
        for (Sentence sentence : source) {
            for (Word word : sentence.getWords()) {
                if (word.length() == length) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    //4

    /**
     * @param text         source text
     * @param sentenceType use constants from TextLogic.SentenceType class
     * @return list of sentences of the required type
     */
    public List<Sentence> findSentencesOfType(Text text, int sentenceType) {
        List<Sentence> source = text.getAsParagraph().getSentences();
        List<Sentence> result = new ArrayList<>();
        StringBuilder regex = new StringBuilder();

        switch (sentenceType) {
            case 0:
                return source;
            case 1:
                regex.append("\\.+");
                break;
            case 2:
                regex.append("\\?+");
                break;
            case 3:
                regex.append("\\!+");
                break;
            default:
                return result;
        }

        for (Sentence sentence : source) {
            if (matchLastSentencePart(regex.toString(), sentence)) {
                result.add(sentence);
            }
        }
        return result;
    }

    private boolean matchLastSentencePart(String check, Sentence sentence) {
        String lastPart = sentence.getSentenceParts().get(sentence.getSentenceParts().size() - 1).toOriginal();
        return Pattern.compile(check).matcher(lastPart).matches();
    }

    //5
    public Text swapSentencesFirstAndLastWord(Text text) {
        Text result = text.deepClone();
        for (Paragraph paragraph : result.getParagraphs()) {
            for (Sentence sentence : paragraph.getSentences()) {
                swapFirtsAndLastWord(sentence);
            }
        }
        return result;
    }

    public void swapFirtsAndLastWord(Sentence sentence) {
        List<SentencePart> list = sentence.getSentenceParts();
        int firstWord = 0;
        int lastWord = list.size() - 1;
        while (list.get(firstWord).getClass() != Word.class) {
            firstWord++;
        }
        while (list.get(lastWord).getClass() != Word.class) {
            lastWord--;
        }
        Collections.swap(list, firstWord, lastWord);
    }

    public static class SentenceType {
        public static final int ALL = 0;
        public static final int DECLARATIVE = 1;
        public static final int INTERROGATIVE = 2;
        public static final int IMPERATIVE_EXCLAMATORY = 3;

        private SentenceType() {
        }
    }
}
