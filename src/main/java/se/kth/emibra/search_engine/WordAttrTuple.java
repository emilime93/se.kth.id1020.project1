package se.kth.emibra.search_engine;

import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Word;

import java.util.ArrayList;

public class WordAttrTuple {

    private Word word;
    private ArrayList<Attributes> attributesList = new ArrayList<Attributes>();

    public WordAttrTuple(Word word, Attributes attributes) {
        this.word = word;
        this.attributesList.add(attributes);
    }

    public Word getWord() {
        return word;
    }

    public void addOccurrence(Attributes attributes) {
        attributesList.add(attributes);
    }

    public ArrayList<Attributes> getAttributes() {
        return this.attributesList;
    }
}
