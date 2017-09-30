package se.kth.emibra.search_engine;

import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

import java.util.ArrayList;
import java.util.List;

public class WordOccurrences {

    private Word word;
    private AttributeOccurrences attributeOccurrences;
    private int wordCount;

    public WordOccurrences(Word word, Attributes attributeOccurences) {
        this.word = word;
        this.attributeOccurrences = new AttributeOccurrences(attributeOccurences);
        wordCount++;
    }

    public void addWord(WordAttrDOT wordToAdd) {
        if (this.word == null) {
            this.word = wordToAdd.getWord();
        }
        wordCount++;
    }

    public Word getWord() {
        return word;
    }

    public void addOccurrence(Attributes attributes) {
        attributeOccurrences.addOccurrence(attributes);
    }

    public ArrayList<Attributes> getOccurrences() {
        return this.attributeOccurrences.getOccurrences();
    }

    public List<Document> getDocuments() {
        List<Document> list = new ArrayList<Document>();
        List <Attributes> attrList = attributeOccurrences.getOccurrences();
        for (int i = 0; i < attrList.size(); i++) {
            Document document = attrList.get(i).document;
            if (!attrList.contains(document)) {
                list.add(document);
            }
        }
        return list;
    }
}
