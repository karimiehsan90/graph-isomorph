package ir.ac.sbu.project.entity;

import java.io.Serializable;

public class Edge implements Serializable {
    private String src;
    private String dst;

    public Edge(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    public Edge() {
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }
}
