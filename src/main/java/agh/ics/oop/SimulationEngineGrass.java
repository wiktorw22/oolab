package agh.ics.oop;

import java.util.Random;

public class SimulationEngineGrass implements IEngine {
    MoveDirection[] directions;
    GrassFieldAbstractLab6 map;
    Vector2d[] positions;
    public SimulationEngineGrass(MoveDirection[] directions, GrassFieldAbstractLab6 map, Vector2d[] positions){
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
        boolean[] logic = new boolean[n];
        for(int i = 0; i < n; i++){
            AnimalLab6Abstract tmp = new AnimalLab6Abstract(map, positions[i]);
            if(map.place(tmp)) {
                map.place(tmp);
                tmp.addObserver(map);
                logic[i] = true;
                cnt++;
            }
            else{
                logic[i] = false;
            }
        }
        Vector2d[] pom = new Vector2d[cnt];
        int j = 0;
        for(int i = 0; i < n; i++){
            if(logic[i]) {
                //AnimalLab6Abstract tmp = new AnimalLab6Abstract(map, positions[i]);
                //map.place(tmp);
                //tmp.addObserver(map);
                //cnt++;
                pom[j] = positions[i]; //tmp.getAnimalPosition();
                j++;
            }
        }
        //stworzyc slownik, do ktorego wstawimy zwierzaki wraz z tablica ich kolejnych ruchow
        //Map<AnimalLab6Abstract, > movesAnimal = new HashMap<>();
        /*
        for(int i = 0; i < m; i++){
            int idx = i;
            if(idx >= cnt){
                idx = idx % cnt;
            }
            map.animals.get(idx).move(directions[i]);
        }
         */
        for(int i = 0; i < m; i++){
            int idx = i;
            if(idx >= cnt){
                idx = idx % cnt;
            }
            Vector2d prevPosition = pom[idx];
            AnimalLab6Abstract animalPom = map.animals.get(prevPosition);
            animalPom.move(directions[i]);
            Vector2d nextPosition = animalPom.getAnimalPosition();
            pom[idx] = nextPosition;
            animalPom.positionChanged(prevPosition, nextPosition);
        }

    }
}
