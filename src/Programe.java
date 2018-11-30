import java.util.Random;
import java.util.Scanner;

public class Programe {
    public static void main(String [] args){
         int X=4;
         int Y=4;
         int hit=3;
         int miss=4;
         int rockets=5;
         int Enemys=2;
         int [][] map=new int[X][Y];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                map[i][j] = 0;
            }
        }
        int eX1= new Random().nextInt(3);
        int eY1=new Random().nextInt(3);
        int enemy1= map[eX1][eY1]=2;
        int eX2;
        int eY2;

        do {
            eX2= new Random().nextInt(3);
            eY2=new Random().nextInt(3);
        }
        while (eX2==eX1&&eY2==eY1);

        boolean isPlaying = true;
        while (isPlaying) {
            int enemiesAround = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (map[i][j] == 0 || map[i][j] == 2) {
                        System.out.print("_ ");
                    } else if (map[i][j] == miss) {
                        System.out.print("X ");
                    } else if (map[i][j] == hit) {
                        System.out.print("O ");
                    }
                }
                System.out.println();
            }
            System.out.println("your target?");
            String move = new Scanner(System.in).nextLine();
            String str[] = move.split("");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int a=x;
            int b=y;

            rockets--;
            if (map[x][y] == 2) {
                Enemys--;
                map[x][y] = hit;
                for (int l = a - 1; l <= x + 1; l++) {
                    int t = l;
                    if (t > 3 || t < 0) continue;
                    for (int m = b - 1; m <= y + 1; m++) {
                        int o = m;
                        if (o > 3 || o < 0) continue;
                        if (map[t][o] == 2) enemiesAround++;
                    }
                }
                System.out.println("You hit");
                System.out.println(enemiesAround + " enemy(s) around");
                System.out.println(Enemys + " enemy(s) left");
                System.out.println(rockets + " rockets left");
                 }
            else {
                map[x][y] = miss;
                for (int l = a - 1; l <= x + 1; l++) {
                    int t = l;
                    if (t >=0 && t <= 3) {
                        for (int m = b - 1; m <= y + 1; m++) {
                            int o = m;
                            if (o >= 0 && o <= 3) {
                                if (map[t][o] == 2) enemiesAround++;
                            }
                        }
                    }
                }
                System.out.println("You Miss");
                System.out.println(enemiesAround + " enemy(s) around");
                System.out.println(Enemys + " enemy(s) left");
                System.out.println(rockets + " rockets left");

            }
            if (Enemys == 0 ) {
                System.out.println("YOU WON!");
                break;
            }
            if (rockets == 0) {
                System.out.println("YOU LOSE!!!");
                break;
            }
        }
    }




}
