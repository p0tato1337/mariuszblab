public class Zad1
{
    private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private Character player_symbol = 'X';
    Character last_player =  'X';
    public String play(int x, int y){
        if (x<1 || x>3) throw new RuntimeException("Wartosc X poza zakresem");
        if (y<1 || y>3) throw new RuntimeException("Wartosc Y poza zakresem");
        if (board[x-1][y-1] !='\0'){
            throw new RuntimeException("Pole nie dostępne");
        }
        else{
            setBox(x,y,last_player);
        }
        String wynik = "Zwyciezca: "+last_player;
        return wynik;
         }
    public void setBox(int x, int y, Character last_player_char){
        if (last_player_char=='X'){
            last_player = 'X';
            board[x - 1][y - 1] = 'X';
        }
        else if (last_player_char=='O'){
            last_player = 'O';
            board[x - 1][y - 1] = 'O';
        }}
    public Character nextPlayer(){
        if (player_symbol=='X'){
            last_player=player_symbol;
            player_symbol = 'O';
        }
        else if (player_symbol=='O'){
            last_player=player_symbol;
            player_symbol = 'X';
        }
        return player_symbol;
    }
    public Character getLast_player(){
        return last_player;
    }
    public Character checkWinInColumns(Character[][] board, char activePlayer){
        Character winner = 'W';
        int sqr = board.length;
        for (int oy = 0; oy < sqr; oy++){
            boolean win = true;
            for (int ox = 0; ox < sqr; ox++){
                if (board[ox][oy] != activePlayer){
                    win = false;
                    break;
                }}
            if (win){
                winner = activePlayer;
            }}
        return winner;
        }
    public Character checkWinInRows(Character[][] board, char activePlayer){
        Character winner = 'W';
        int sqr = board.length;
        for (int ox = 0; ox < sqr; ox++){
            boolean win = true;
            for (int oy = 0; oy < sqr; oy++){
                if (board[ox][oy] != activePlayer){
                    win = false;
                    break;
                }}
            if (win){
                winner = activePlayer;
            }}
        return winner;
    }
    public Character checkFirstDiagonal(Character[][] board, char activePlayer){
        Character winner = activePlayer;
        int sqr = board.length;
        for (int i = 0; i < sqr; i++){
            if (board[i][i] != activePlayer){
                winner = 'W';
            }}
        return winner;
    }
    public Character checkSecondDiagonal(Character[][] board, char activePlayer){
        Character winner = activePlayer;
        int sqr = board.length;
        for (int i = 0; i < sqr; i++){
            if (board[i][sqr - i - 1] != activePlayer){
                winner = 'W';
            }}
        return winner;
    }
    public boolean Draw(Character[][] board){
        boolean draw=false;
        int sqr = board.length;
        for (int ox = 0; ox < sqr; ox++) {
            draw = true;
            for (int oy = 0; oy < sqr; oy++){
                if (board[ox][oy] == '\0'){
                    draw = false;
                    break;}
            }}
        return draw;
    }
    public Character[][] getBoard(){
        return board;
    }}