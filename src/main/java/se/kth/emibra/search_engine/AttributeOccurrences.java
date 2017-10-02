package se.kth.emibra.search_engine;

import se.kth.id1020.util.Attributes;

import java.util.ArrayList;
import java.util.List;

public class AttributeOccurrences {

    List<Attributes> list = new ArrayList<Attributes>();

    public AttributeOccurrences(Attributes attributeOccurences) {
        list.add(attributeOccurences);
    }

    public void addOccurrence(Attributes attributes) {
        list.add(attributes);
    }

    public List<Attributes> getOccurrences() {
        return list;
    }

    public int getNumberOfOccurrences() {
        return list.size();
    }
}
