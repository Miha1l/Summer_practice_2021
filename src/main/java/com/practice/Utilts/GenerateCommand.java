package com.practice.Utilts;

import com.practice.Graph.Edge;
import com.practice.Graph.Graph;
import com.practice.Gui.Rib;

import java.util.ArrayList;

public class GenerateCommand implements Command{
    //Класс отвечает за генерацию случайного графа
    private int countVertices;
    private int countEdges;
    private int min;
    private int max;
    private final String[] alphabet = new String[]
            {
                    "A", "B", "C", "D", "E", "F", "G",
                    "H", "I", "J", "K", "L", "M", "N",
                    "O", "P", "Q", "R", "S", "T", "U",
                    "V", "W", "X", "Y", "Z"
            };

    public GenerateCommand(int countVertices, int countEdges, int min, int max){
        this.countVertices = countVertices;
        this.countEdges = countEdges;
        this.min = min;
        this.max = max;
    }

    @Override
    public Graph execute(){
        Graph graph = new Graph();
        for (int i = 0; i < countEdges; i++){
            while (graph.getCountEdges() < (i + 1)){
                int startInd = rnd(0, countVertices-1);
                int endInd = rnd(0, countVertices-1);
                int weight = rnd(min, max);
                graph.addEdge(alphabet[startInd], alphabet[endInd], weight);
            }
        }
        return graph;
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }


   /* @Override
    public Graph execute(ArrayList<Rib> ribs){
        return new Graph();
    }

    @Override
    public Graph execute(String filename) {
        return new Graph();
    }*/
}
