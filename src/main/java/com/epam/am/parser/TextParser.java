package com.epam.am.parser;

import com.epam.am.entity.Paragraph;
import com.epam.am.entity.Sentence;
import com.epam.am.entity.Text;

public interface TextParser {

    public Text parseText(String source);

    public Paragraph parseParagraph(String source);

    public Sentence parseSentence(String str);
}
