package com.vinhnqph29776.asm.object;
//Loai thu object
public class ObjLT {
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjLT() {
    }

    public ObjLT(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
return name;
    }
}