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
        List<Sentence> sentences = getAsParagraph(text).getSentences();
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

    //4

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

    /**
     * @param text         source text
     * @param sentenceType use constants from TextLogic.SentenceType class
     * @return list of sentences of the required type
     */
    public List<Sentence> findSentencesOfType(Text text, int sentenceType) {
        List<Sentence> source = getAsParagraph(text).getSentences();
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
                swapFirstAndLastWord(sentence);
            }
        }
        return result;
    }

    public void swapFirstAndLastWord(Sentence sentence) {
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

    //6
    public Paragraph getWordsSortedByLettersAsParagraph(Text text) {
        List<Word> words = getWords(text);
        sortWordsByLetters(words);
        Letter firstLetter = null;
        Word word;
        Sentence sentence = null;
        Paragraph result = new Paragraph();
        for (int i = 0; i < words.size(); i++) {
            word = words.get(i);
            if (!word.getLetters().get(0).toLowerCase().equals(firstLetter)) {
                firstLetter = words.get(i).getLetters().get(0).toLowerCase();
                sentence = new Sentence();
                result.add(sentence);
                sentence.add(word);
            } else {
                sentence.add(word);
            }
        }
        return result;
    }

    public List<Word> getWords(Text text) {
        List<Sentence> sentences = getAsParagraph(text).getSentences();
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : sentences) {
            words.addAll(sentence.getWords());
        }
        return words;
    }

    public void sortWordsByLetters(List<Word> list) {
        Collections.sort(list);
    }

    //7
    public void sortWordsByVowelsCount(List<Word> words) {
        Collections.sort(words, (w1, w2) -> w1.vowelPerLetter() == w2.vowelPerLetter()
                ? 0 : w1.vowelPerLetter() > w2.vowelPerLetter() ? -1 : 1);
    }

    public Paragraph getAsParagraph(Text text) {
        Paragraph result = new Paragraph();
        for (Paragraph paragraph : text.getParagraphs()) {
            for (Sentence sentence : paragraph.getSentences()) {
                result.add(sentence);
            }
        }
        return result;
    }

    public Sentence getWordsAsSentence(List<Word> words) {
        Sentence result = new Sentence();
        for (Word word : words) {
            result.add(word);
        }
        return result;
    }

    //8
    public void sortWordsAlphabeticallyBySecondLetter(boolean isFirstLetterVowel, List<Word> list) {
        Collections.sort(list, (w1, w2) -> {
            Letter c1 = w1.new WordIterator().nextLetter(!isFirstLetterVowel);
            Letter c2 = w2.new WordIterator().nextLetter(!isFirstLetterVowel);
            if (c1 == null && c2 == null) return 0;
            if (c1 == null) return -1;
            if (c2 == null) return 1;
            return c1.compareTo(c2);
        });
    }

    public List<Word> getWordsBeginningWith(boolean isFirstLetterVowel, List<Word> list) {
        List<Word> result = new ArrayList<>();
        for (Word word : list) {
            if (word.getLetters().get(0).isVowel() == isFirstLetterVowel) {
                result.add(word);
            }
        }
        return result;
    }

    //9
    public void sortByLetterPerWord(Letter letter, List<Word> words) {
        Collections.sort(words, (w1, w2) -> {
            float w1count = calculateLetterPerWord(letter, w1);
            float w2count = calculateLetterPerWord(letter, w2);
            return w1count == w2count ? w1.compareTo(w2) : w1count > w2count ? -1 : 1;
        });
    }

    public void sortByLetterPerWord(char c, List<Word> words) {
        sortByLetterPerWord(new Letter(c), words);
    }

    public float calculateLetterPerWord(Letter letter, Word word) {
        int letterCount = 0;
        for (Letter character : word) {
            if (letter.equals(character)) letterCount++;
        }
        return (float) letterCount / word.length();
    }

    //10
    public List<String> countWordsUsages(Text text, List<Word> words) {
        class WordCountEntry implements Comparable<WordCountEntry> {
            private final Word word;
            private int count;

            WordCountEntry(Word word, int count) {
                this.word = word;
                this.count = count;
            }

            @Override
            public int compareTo(WordCountEntry o) {
                return -Integer.compare(count, o.count);
            }

            @Override
            public String toString() {
                return "{" + word.toOriginal() + " : " + count + "}";
            }
        }

        List<Word> textWords = getWords(text);
        List<WordCountEntry> entries = new ArrayList<>();
        for (Word word : words) {
            WordCountEntry entry = new WordCountEntry(word, 0);
            for (Word textWord : textWords) {
                if (textWord.equals(word)) entry.count++;
            }
            entries.add(entry);
        }

        Collections.sort(entries);

        List<String> result = new ArrayList<>();
        for (WordCountEntry entry : entries) {
            result.add(entry.toString());
        }
        return result;
    }

    public List<String> countWordsUsages(Text text, String... words) {
        List<Word> list = new ArrayList<>();
        for (String word : words) {
            list.add(new Word(word));
        }
        return countWordsUsages(text, list);
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
