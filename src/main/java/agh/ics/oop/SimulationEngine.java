package agh.ics.oop;

public class SimulationEngine implements IEngine {
    MoveDirection[] directions;
    RectangularMap map;
    Vector2d[] positions;
    public SimulationEngine(MoveDirection[] directions, RectangularMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
    }
    @Override
    public void run() {
        int n = positions.length;
        int m = directions.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!(map.place(new AnimalLab4(map, positions[i])))){
                positions[i] = null;
            }
            else {
                map.place(new AnimalLab4(map, positions[i]));
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
