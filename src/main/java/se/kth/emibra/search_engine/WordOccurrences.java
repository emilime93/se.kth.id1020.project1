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

    public WordOccurrences(WordAttrDOT wordAttr) {
        this.word = wordAttr.getWord();
        this.attributeOccurrences = new AttributeOccurrences(wordAttr.getAttributes());
        wordCount++;
    }

    public Word getWord() {
        return word;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void addOccurrence(Attributes attributes) {
        attributeOccurrences.addOccurrence(attributes);
        wordCount++;

    }

    public List<Attributes> getOccurrences() {
        return this.attributeOccurrences.getOccurrences();
    }

    public List<Document> getDocuments() {
        List<Document> list = new ArrayList<Document>();
        List<Attributes> attrList = getOccurrences();

        for (int i = 0; i < attrList.size(); i++) {
            Document document = attrList.get(i).document;
            if (!attrList.contains(document)) {
                list.add(document);
            }
        }
        return list;
    }
}
