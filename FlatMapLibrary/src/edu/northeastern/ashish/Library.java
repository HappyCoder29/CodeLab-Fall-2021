package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Library {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    ArrayList<Section> sections;

    public Library(String name ){
        this.name = name;
        this.sections = new ArrayList<>();
    }
    public Section getSection(String sectionName){
       ArrayList<Section> filter = (ArrayList<Section>) sections.stream()
                .filter(section -> section.getName().equalsIgnoreCase(sectionName))
                .collect(Collectors.toList());
       if(filter.size() == 0){
           return null;
       }
       return filter.get(0);
    }
}
