package com.bruno13palhano;

import java.util.List;

public class Item {
    public Long id;
    public int index;
    public List<Integer> successorsIndices;
    public String name;
    public String description;

    public Item() {}

    public Item(Long id, int index, List<Integer> successorsId, String name, String description) {
        this.id = id;
        this.index = index;
        this.successorsIndices = successorsId;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "id: "+id+"\n" +
                "index: "+index+"\n" +
                "successorsIndices: "+successorsIndices+"\n" +
                "name: "+name+"\n" +
                "description: "+description;
    }
}
