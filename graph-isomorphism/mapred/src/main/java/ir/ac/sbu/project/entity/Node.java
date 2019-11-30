package ir.ac.sbu.project.entity;

import java.io.Serializable;

public class Node implements Serializable {
    private String id;

    public Node(String id) {
        this.id = id;
    }

    public Node() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
