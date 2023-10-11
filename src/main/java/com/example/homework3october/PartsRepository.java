package com.example.homework3october;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Iterator;


@Component
public class PartsRepository {
    private final ArrayList<Part> parts = new ArrayList<>();

    public PartsRepository() {
        parts.add(new Part("Henrik"));
        parts.add(new Part("Stefan"));
    }

    public ArrayList<Part> getPart() {
        return parts;
    }

    public void addPart(Part part){
        parts.add(part);
    }

    public void deletePart(Part part) {
        System.out.println("Before deletion: " + parts);

        parts.removeIf(p -> p.equals(part));

        System.out.println("After deletion: " + parts);
    }

    public void editPart(Part oldName, Part newName){
        parts.set(parts.indexOf(oldName), (newName));
    }
}
