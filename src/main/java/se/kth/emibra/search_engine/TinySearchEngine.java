package se.kth.emibra.search_engine;

import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

import java.util.ArrayList;
import java.util.List;

public class TinySearchEngine implements TinySearchEngineBase {

    private ArrayList<WordAttrTuple> index = new ArrayList<WordAttrTuple>();

    public void insert(Word word, Attributes attributes) {
        WordAttrTuple wat = new WordAttrTuple(word, attributes);
//        index.add(wat);
//        addToIndex(wat);
        addToIndexBinary(wat, 0, index.size()/2, index.size()-1);
    }

    private void addToIndexBinary(WordAttrTuple wat, int lo, int mid, int hi) {
        if (index.size() == 0) {
            index.add(wat);
            return;
        }
        if (lo == (hi+1)) {
            //We haven't found the word and it is to be inserted between the indices
            index.add(lo, wat);
        } else if (true) {

        } else if (index.get(mid).getWord().word.compareTo(wat.getWord().word) == 0) {
            //New word occurande
            Attributes atr = wat.getAttributes().get(0);
            index.get(mid).addOccurrence(atr);
            return;
        } else if(index.get(mid).getWord().word.compareTo(wat.getWord().word) < 0) {
            // GO RIGHT
            addToIndexBinary(wat, mid, (hi-mid)/2, hi);
        } else if (index.get(mid).getWord().word.compareTo(wat.getWord().word) > 0) {
            // GO LEFT
            addToIndexBinary(wat, lo, (mid-lo)/2, mid);
        }
    }

    private void addToIndex(WordAttrTuple wat) {
        for (int i = 0; i < index.size()-1; i++) {
            if (index.get(i).getWord().word.compareTo(wat.getWord().word) > 0 ) { // the comparee comes first
                index.add(i, wat);
                return;
            }
        }
        index.add(wat);
    }

    public List<Document> search(String s) {
        List<Document> list = new ArrayList<Document>();
        for (WordAttrTuple wat :
                index) {
//            list.add(wat.getAttributes().);
        }
        return null;
    }
}
