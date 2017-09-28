package se.kth.emibra.search_engine;

import org.junit.jupiter.api.BeforeEach;
import se.kth.id1020.TinySearchEngineBase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

class TinySearchEngineTest {

    TinySearchEngineBase searchEngine;

    @BeforeEach
    void setUp() {
        searchEngine = new TinySearchEngine();
    }

    @AfterEach
    void tearDown() {
        searchEngine = null;
    }

    @Test
    void insert() {
    }

    @Test
    void search() {
    }

}