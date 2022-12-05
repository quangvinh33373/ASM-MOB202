package com.vinhnqph29776.asm.object;
// Loai Chi object
public class ObjLC {
 private String name;
private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ObjLC() {
    }

    public ObjLC(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public String toString() {
        return name;
    }
}