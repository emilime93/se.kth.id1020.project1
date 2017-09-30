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
        int i = indexOf(wat.getWord().word);
        index.add(i, wat);
    }

    private int indexOf(String word) {
        int lo = 0;
        int hi = index.size() - 1;
        if (index.size() == 0)
            return 0;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (index.get(mid).getWord().word.compareTo(word) > 0) {    // The target word is in the left half
                hi = mid - 1;
            } else if (index.get(mid).getWord().word.compareTo(word) < 0) {     // The target word is in the left half
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

//    private void addToIndexBinary(WordAttrTuple wat) {
//        int lo = 0, hi = index.size()-1;
//        String word = wat.getWord().word;
//
//
//        int mid;
//        while (lo <= hi) {
//            System.out.printf("Size: %d\n", index.size());
//            mid = lo + (hi - lo) / 2;
//            if (index.get(mid).getWord().word.compareTo( word ) > 0) // The word is in the left half
//                hi = mid - 1;
//            else if (index.get(mid).getWord().word.compareTo( word ) < 0) // The word is in the right half
//                lo = hi + 1;
//            else if (index.get(mid).getWord().word.compareTo( word ) == 0) // The word is found, occurance added
//            {
//                System.out.printf("Adding word occurance %s @ %d\n", index.get(mid).getWord().word, mid);
//                index.get(mid).addOccurrence(wat.getAttributes().get(0));
//                return;
//            }
//            else {
//                System.out.printf("Adding %s\n", index.get(mid).getWord().word);
//                index.add(mid, wat);
//                return;
//            }
//        }
//    }

    private void addToIndex(WordAttrTuple wat) {
        for (int i = 0; i < index.size()-1; i++) {
            if (index.get(i).getWord().word.compareTo(wat.getWord().word) > 0 ) { // the comparee comes first
                index.add(i, wat);
                return;
            }
        }
        index.add(wat);
    }

    /*public List<Document> search(String word) {
        int lo = 0;
        int hi = index.size() - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (index.get(mid).getWord().word.compareTo(word) > 0) {
                hi = mid - 1;
            } else if (index.get(mid).getWord().word.compareTo(word) < 0) {
                lo = mid + 1;
            } else {
                break;
            }
        }

        String targetString = index.get(mid).getWord().word;
        String s = targetString;
        while (s.equalsIgnoreCase(index.get(mid-1).getWord().word) && mid >= 0) {
            s = index.get(mid).getWord().word;
            mid--;
        }

        List<Document> list  = new ArrayList<Document>();
        while (targetString.equalsIgnoreCase(index.get(mid).getWord().word)) {
            list.add(index.get(mid++).getAttributes().get(0).document);
        }

        return list;
    }*/

    public List<Document> search(String s) {
        System.out.println("Searching for " + s);
        List<Document> list = new ArrayList<Document>();
        for (WordAttrTuple wat : index) {
            if (wat.getWord().word.equalsIgnoreCase(s)) {
                list.add(wat.getAttributes().get(0).document);
            }
        }
        return list;
    }
}
