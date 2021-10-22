package edu.northeastern.ashish;

public interface iBoardable {
    void setBoardStart(int day);
    void setBoardEnd(int day);
    boolean boarding(int day);
}
