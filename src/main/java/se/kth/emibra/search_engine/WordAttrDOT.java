package se.kth.emibra.search_engine;

import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Word;

public class WordAttrDOT {

    private final Word word;
    private final Attributes attributes;

    public WordAttrDOT(Word word, Attributes attributes) {
        this.word = word;
        this.attributes = attributes;
    }

    public Word getWord() {
        return word;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
