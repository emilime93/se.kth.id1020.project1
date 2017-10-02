package se.kth.emibra.search_engine;

import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

import java.util.ArrayList;
import java.util.List;

public class TinySearchEngine implements TinySearchEngineBase {

    private ArrayList<WordOccurrences> searchIndexList = new ArrayList<WordOccurrences>();

    public void insert(Word word, Attributes attributes) {
        WordAttrDOT wordAttrDOT = new WordAttrDOT(word, attributes);    // Creates a word+attr wrapper
        binaryAdd(wordAttrDOT);     //Adds the word and it's occurrences to "searchIndexList"
//        linearAdd(wordAttrDOT);     //Adds the word and it's occurrences to "searchIndexList"
    }

    /**
     * This method uses a binary search method to add elements to the list.
     * That way the list is already sorted when it's done building.
     * @param wordAttr
     */
    private void binaryAdd(WordAttrDOT wordAttr) {
        if (searchIndexList.size() == 0) {
            addToIndexing(wordAttr, 0);
            return;
        }

        String word = wordAttr.getWord().word;
        int lo = 0;
        int hi = searchIndexList.size() - 1;
        int mid = lo + ((hi-lo)/2);

        while (lo <= hi) {
            mid = lo + (hi-lo) / 2;
            String wordInArray = searchIndexList.get(mid).getWord().word;
            if (wordInArray.compareToIgnoreCase(word) > 0) {
                // The target word is in the left half
                hi = mid - 1;
            } else if (wordInArray.compareToIgnoreCase(word) < 0) {
                // The target word is in the right half
                lo = mid + 1;
            } else {
                addToIndexing(wordAttr, mid);
                return;
            }
        }
        addToIndexing(wordAttr, lo);
    }

    private void addToIndexing(WordAttrDOT wat, int i) {
        if (this.searchIndexList.size() == 0 || this.searchIndexList.size() == i) {
            searchIndexList.add(new WordOccurrences(wat));
            return;
        }

        if (this.searchIndexList.get(i).getWord().word.equalsIgnoreCase(wat.getWord().word)) {
            this.searchIndexList.get(i).addOccurrence(wat.getAttributes());
        } else {
            this.searchIndexList.add(i, new WordOccurrences(wat));
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < this.searchIndexList.size() - 2; i++) {
            if (searchIndexList.get(i).getWord().word.compareToIgnoreCase(searchIndexList.get(i+1).getWord().word) > 0) {
                return false;
            }
        }
        return true;
    }

    public List<Document> search(String s) {
        System.out.println("Sorted: " + isSorted());

        int lo = 0, hi = searchIndexList.size() - 1, mid = 0;
        if (searchIndexList.size() == 0)
            return null;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            String wordInArray = searchIndexList.get(mid).getWord().word;
            if (wordInArray.compareToIgnoreCase(s) > 0) {
                // The target word is in the left half
                hi = mid - 1;
            } else if (wordInArray.compareToIgnoreCase(s) < 0) {
                // The target word is in the right half
                lo = mid + 1;
            } else {
                // The word is found
                return searchIndexList.get(mid).getDocuments();
            }
        }
        return searchIndexList.get(mid).getDocuments();
//        return null;
    }

}
