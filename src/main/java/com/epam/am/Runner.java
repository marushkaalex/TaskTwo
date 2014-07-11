package com.epam.am;

import com.epam.am.entity.Text;
import com.epam.am.entity.Word;
import com.epam.am.helper.PropertyManager;
import com.epam.am.helper.TextLogic;
import com.epam.am.parser.SimpleTextParser;

import java.io.IOException;


//TODO 1
//TODO 2 X
//TODO 3 X
//TODO 4 X
//TODO 5 X
//TODO 6 X
//TODO 7 X
//TODO 8 X
//TODO 9 X
//TODO 10 X
//TODO 11
//TODO 12
//TODO 13
//TODO 14
//TODO 15
//TODO 16

public class Runner {
    public static void main(String[] args) throws IOException {
//        logic.sortWordsByVowelsCount(logic.getWords(text));
        TextLogic logic = new TextLogic();
        Text text = SimpleTextParser.parseText("Жестокий, никогда не знавший любви, сирота Жан-Батист Гренуй настоящих успехов достиг лишь на одном поприще - среди парфюмеров ему никогда не было равных. По его духам сходит с ума весь высший свет, не подозревая о том, какой страшной ценой будет получен последний, идеальный аромат.");
        Word a = new Word("Word");
        System.out.println(a);
        PropertyManager manager = PropertyManager.getManager(PropertyManager.REGEX);
        System.out.println(manager.getProperty("group.par"));
    }
}
