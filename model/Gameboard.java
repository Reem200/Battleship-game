package model;

public class Gameboard implements IGameboard{

        private int[][] gameboard = new int[10][10];
        private int row;
        private int col;
        private GameboardType gameBoardType;

        public Gameboard(){}

        public Gameboard(int row, int col, GameboardType gameBoardTypes){
            this.row = row;
            this.col = col;
            this.gameBoardType = gameBoardTypes;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public GameboardType getGameBoardType(){
            return gameBoardType;
        }

        public void setGameBoardTypes(GameboardType gameBoardTypes){
            this.gameBoardType = gameBoardTypes;
        }

        @Override
        public void placeShips(){
            GameboardType gameboardType = getGameBoardType();
            if(gameboardType == GameboardType.Gameboard_1){
                placeGmb1();
            }else{
                placeGmb2();
            }
        }

        @Override
        public boolean attack(){ //gameBoard
            boolean hit = true;
            int row = getRow();
            int column = getCol();

            for(int i=0; i< gameboard.length; i++){
                for(int j =0; j<gameboard[i].length; j++){
                    if(row==i && column==j){
                        if(gameboard[i][j]== 1){ //valid skepp
                            hit = true;
                        }
                        else if(gameboard[i][j]==0){
                            hit = false;
                        }
                    }
                }
            }
            return hit; //hit eller miss
        }


    /*u-båt, en ruta stort = A
• torpedbåt, 2 rutor stort = B
• jagare, 3 rutor stort = C
• kryssare, 4 rutor stort = D
• slagskepp, 5 rutor stort = E
    0 1 2 3 4 5 6 7 8 9 10
0   * * * * * E E E E E *
1   * * C C C * * * * * *
2   * * * * * * * * * * *
3   * * * * * * * * * * *
4   * * * D * * * * * * *
5   * * * D * * * * * * *
6   * * * D * * B * * * *
7   * * * D * * B * * * *
9   A * * * * * * * * * *
    0 1 2 3 4 5 6 7 8 9 10
*/

    public void placeGmb1(){

        for (int row = 0; row < gameboard.length; row++) {
            for (int col = 0; col < gameboard[row].length; col++) {
                {
                    gameboard[1][2] = 1; //A

                    gameboard[3][4] = 1; //B
                    gameboard[3][5] = 1;

                    gameboard[4][7] = 1; //C
                    gameboard[5][7] = 1;
                    gameboard[6][7] = 1;

                    gameboard[8][2] = 1; //D
                    gameboard[8][3] = 1;
                    gameboard[8][4] = 1;
                    gameboard[8][5] = 1;

                    gameboard[2][1] = 1; //E
                    gameboard[3][1] = 1;
                    gameboard[4][1] = 1;
                    gameboard[5][1] = 1;
                    gameboard[6][1] = 1;

                }
                if ((String.valueOf(gameboard[row][col]) == null) || (String.valueOf(gameboard[row][col]) == "") || (String.valueOf(gameboard[row][col]).isEmpty())) {
                    gameboard[row][col] = 0;
                }
            }
        }
    }

    public void placeGmb2(){

        for (int row = 0; row < gameboard.length; row++) {
            for (int col = 0; col < gameboard[row].length; col++) {
                {
                    gameboard[9][0] = 1; //A

                    gameboard[6][6] = 1; //B
                    gameboard[7][6] = 1;

                    gameboard[1][2] = 1; //C
                    gameboard[1][3] = 1;
                    gameboard[1][4] = 1;

                    gameboard[4][3] = 1; //D
                    gameboard[5][3] = 1;
                    gameboard[6][3] = 1;
                    gameboard[7][3] = 1;

                    gameboard[0][5] = 1; //E
                    gameboard[0][6] = 1;
                    gameboard[0][7] = 1;
                    gameboard[0][8] = 1;
                    gameboard[0][9] = 1;
                }
                if ((String.valueOf(gameboard[row][col]) == null) || (String.valueOf(gameboard[row][col]) == "") || (String.valueOf(gameboard[row][col]).isEmpty())) {
                    gameboard[row][col] = 0;
                }
            }
        }
    }

}
