package com.company.androidlist;

public class Figure {
    private int image;
    private String nameFigure;

    public Figure(int image, String text) {
        this.image = image;
        this.nameFigure = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return nameFigure;
    }

    public void setText(String text) {
        this.nameFigure = text;
    }
}
