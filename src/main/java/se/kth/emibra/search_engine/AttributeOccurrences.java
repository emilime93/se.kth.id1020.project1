package se.kth.emibra.search_engine;

import se.kth.id1020.util.Attributes;

import java.util.ArrayList;
import java.util.List;

public class AttributeOccurrences {

    List<Attributes> list = new ArrayList<Attributes>();

    public AttributeOccurrences(Attributes attributeOccurrences) {
        list.add(attributeOccurrences);
    }

    public void addOccurrence(Attributes attributes) {
        for (Attributes attr : list) {
            if (attr.document.name.equalsIgnoreCase(attributes.document.name))
                return;
        }
        list.add(attributes);
    }

    public List<Attributes> getOccurrences() {
        return list;
    }
}
