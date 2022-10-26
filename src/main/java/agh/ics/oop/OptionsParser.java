package agh.ics.oop;

public class OptionsParser {
    public OptionsParser(){} //konstruktor obiektow tej klasy
    public MoveDirection[] parse(String[] args){
        int n = args.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(args[i].equals("f") || args[i].equals("forward") || args[i].equals("b") || args[i].equals("backward") || args[i].equals("r") || args[i].equals("right") || args[i].equals("l") || args[i].equals("left")){
                cnt = cnt+ 1;
            }
        }
        MoveDirection[] moves = new MoveDirection[cnt];
        int j = 0;
        for(int i = 0; i < n; i++){
            if(args[i].equals("f") || args[i].equals("forward")){
                moves[j] = MoveDirection.valueOf("FORWARD");
                j = j + 1;
            }
            else if(args[i].equals("b") || args[i].equals("backward")){
                moves[j] = MoveDirection.valueOf("BACKWARD");
                j = j + 1;
            }
            else if(args[i].equals("r") || args[i].equals("right")){
                moves[j] = MoveDirection.valueOf("RIGHT");
                j = j + 1;
            }
            else if(args[i].equals("l") || args[i].equals("left")){
                moves[j] = MoveDirection.valueOf("LEFT");
                j = j + 1;
            }
        }

        return moves;
    }
}
