package se.kth.emibra.search_engine;

import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

import java.util.ArrayList;
import java.util.List;

public class TinySearchEngine implements TinySearchEngineBase {

    private ArrayList<WordOccurrences> index = new ArrayList<WordOccurrences>();

    public void insert(Word word, Attributes attributes) {
        WordAttrDOT wordAttrDOT = new WordAttrDOT(word, attributes);
        binaryAdd(wordAttrDOT);
    }

    private void binaryAdd(WordAttrDOT wat) {
        if (index.size() == 0)
            addToIndexing(wat, 0);

        String word = wat.getWord().word;
        int lo = 0;
        int hi = index.size() - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            String existingWord = index.get(mid).getWord().word;
            if (existingWord.compareTo(word) > 0) {    // The target word is in the left half
                hi = mid - 1;
            } else if (existingWord.compareTo(word) < 0) {     // The target word is in the left half
                lo = mid + 1;
            } else { // The index for the word is found
                addToIndexing(wat, mid);
                return;
            }
        }
        addToIndexing(wat, mid);
    }

    private void addToIndexing(WordAttrDOT wat, int i) {
        if (this.index.size() == 0) {
            index.add(new WordOccurrences(wat.getWord(), wat.getAttributes()));
        }

        if (this.index.get(i).getWord().word.equalsIgnoreCase(wat.getWord().word)) {
            System.out.println("Occurance updated");
            this.index.get(i).addOccurrence(wat.getAttributes());
        } else {
            System.out.println("Simply added");
            this.index.add(i, new WordOccurrences(wat.getWord(), wat.getAttributes()));
        }
    }

    public List<Document> search(String s) {
        System.out.println("Searching for " + s);
        List<Document> list = new ArrayList<Document>();

        int lo = 0, hi = index.size() - 1, mid = 0;
        if (index.size() == 0)
            return null;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (index.get(mid).getWord().word.compareTo(s) > 0) {    // The target word is in the left half
                hi = mid - 1;
            } else if (index.get(mid).getWord().word.compareTo(s) < 0) {     // The target word is in the left half
                lo = mid + 1;
            } else { // The word is found
                return index.get(mid).getDocuments();
            }
        }
        return null;
    }
}
