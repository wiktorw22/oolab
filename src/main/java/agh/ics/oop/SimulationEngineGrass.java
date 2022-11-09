package agh.ics.oop;

import java.util.Random;

public class SimulationEngineGrass implements IEngine {
    MoveDirection[] directions;
    GrassField map;
    Vector2d[] positions;
    public SimulationEngineGrass(MoveDirection[] directions, GrassField map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
    }
    @Override
    public void run() {
        int grassCnt = 0;
        Random number = new Random();
        while (grassCnt < this.map.getGrassNumber()) {
            int positionX =  number.nextInt((int) Math.sqrt(((map.getGrassNumber())*10 + 1)));
            int positionY =  number.nextInt((int) Math.sqrt(((map.getGrassNumber())*10 + 1)));
            Vector2d position = new Vector2d(positionX, positionY);
            if(map.placeGrass(new Grass(position))) {
                map.placeGrass(new Grass(position));
                System.out.println(position);
                //System.out.println(position.y);
                grassCnt++;
            }
        }
        int n = positions.length;
        int m = directions.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(map.place(new AnimalLab5(map, positions[i]))) {
                map.place(new AnimalLab5(map, positions[i]));
                cnt++;
            }
        }
        for(int i = 0; i < m; i++){
            int idx = i;
            if(idx >= cnt){
                idx = idx % cnt;
            }
            map.animals.get(idx).move(directions[i]);
        }
    }
}
