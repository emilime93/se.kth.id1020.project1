package se.kth.emibra.main;

import se.kth.emibra.search_engine.TinySearchEngine;
import se.kth.id1020.Driver;
import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.DataSource;
import se.kth.id1020.util.Word;

public class Main {

    public static void main(String[] args) {
//        String str1 = "aaa";
//        String str2 = "ac";
//
//        System.out.println(str1.compareTo(str2));
//        /* This returns -1 */
        TinySearchEngineBase searchEngine = new TinySearchEngine();
        try {
            Driver.run(searchEngine);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
