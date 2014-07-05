package com.epam.am.helper;

import com.epam.am.entity.Paragraph;
import com.epam.am.entity.Sentence;
import com.epam.am.entity.Text;
import com.epam.am.entity.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextLogic {

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
}
