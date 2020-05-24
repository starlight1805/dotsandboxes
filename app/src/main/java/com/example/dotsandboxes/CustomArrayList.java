package com.example.dotsandboxes;

import java.util.ArrayList;

public class CustomArrayList {
    ArrayList<Data> list = new ArrayList<>();
    class Data {
        int x1;
        int y1;
        int x2;
        int y2;

        Data(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public void addValues(int x1, int y1, int x2, int y2) {
        list.add(new Data(x1, y1, x2, y2));
    }
    public int getx1(int j){
        CustomArrayList.Data data=list.get(j);
        return(data.x1);

    }
    public int gety1(int j){
        CustomArrayList.Data data=list.get(j);
        return(data.y1);
    }
    public int getx2(int j){
        CustomArrayList.Data data=list.get(j);
        return(data.x2);
    }
    public int gety2(int j){
        CustomArrayList.Data data=list.get(j);
        return(data.y2);
    }
}
