package DorB_FS;

import java.util.Scanner;

public class Avoid_Surveillance {
    public static int N;
    public static char[][] school = new char[7][7];
    public static boolean possible=false;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Avoid_Surveillance result = new Avoid_Surveillance();

        N = input.nextInt();
        input.nextLine();
        for (int i = 0; i < N; i++) {
            String S = input.nextLine();
            String[] s = S.split(" ");
            for(int j=0;j<N;j++)
                school[i][j] =s[j].charAt(0);
        }
        result.makeWall(0);

        if(possible)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    private void makeWall(int wall){
            if(wall ==3){
                if(see())
                    possible = true;
                return;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(school[i][j]=='X'){
                        school[i][j] = 'O';
                        makeWall(wall+1);
                        school[i][j] = 'X';
                    }
                }
            }
    }
    private boolean see(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(school[i][j]=='T'){
                    for(int r=0;r<4;r++){
                        int x = i;
                        int y = j;
                        int nx,ny;
                        while(true){
                            nx = x+dx[r];
                            ny = y+dy[r];
                            if(nx == -1 || nx == N||ny == -1 || ny == N)
                                break;
                            if(school[nx][ny]=='O')
                                break;
                            else if(school[nx][ny]=='S')
                                return false;

                            x = nx;
                            y = ny;
                        }
                    }
                }
            }
        }

        return true;
    }
}
