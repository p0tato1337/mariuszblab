public class Zad1Spec
{
    Character expectedX ='X';
    Character expectedO ='O';
    @Rule
    public ExpectedException exception= ExpectedException.none();
    private Zad1 zad1;
    @Before
    public final void before() {
        zad1 = new Zad1();
    }
    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        zad1.play(5,2);
    }
    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        zad1.play(2,4);
    }
    @Test
    public void whenOccupiedThenRuntimeException(){
        exception.expect(RuntimeException.class);
        zad1.play('\0', '\0');
    }
    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        assertEquals(expectedX, zad1.getLast_player());
    }
    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO(){
        zad1.play(1,1);
        assertEquals(expectedO,zad1.nextPlayer());
    }
    @Test
    public void whenPlayThenNoWinner(){
        String actual=zad1.play(1,1);
        assertEquals("Brak zwyciezcy",actual);
    }
    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner(){
        zad1.play(1, 1);
        zad1.play(1, 2);
        zad1.play(2, 1);
        zad1.play(2, 2);
        String actual = zad1.play(3, 1);
        assertEquals("Zwyciezca X", actual);
    }
    @Test
    public void whenPlayAndWholeVerticalLineThenWinner(){
        zad1.play(1, 1);
        zad1.play(2, 2);
        zad1.play(2, 1);
        zad1.play(2, 3);
        zad1.play(3, 1);
        assertEquals(expectedX,zad1.checkWinInColumns(zad1.getBoard(),zad1.getLast_player()));
    }
    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner(){
        zad1.play(1, 1);
        zad1.play(2, 1);
        zad1.play(2, 2);
        zad1.play(2, 3);
        zad1.play(3, 3);
        assertEquals(expectedX,zad1.checkFirstDiagonal(zad1.getBoard(),zad1.getLast_player()));
    }
    @Test
    public void whenPlayAndTopBottomDiagonalLine2ThenWinner(){
        zad1.play(1, 3);
        zad1.play(2, 1);
        zad1.play(2, 2);
        zad1.play(2, 3);
        zad1.play(3, 1);
        assertEquals(expectedX,zad1.checkSecondDiagonal(zad1.getBoard(),zad1.getLast_player()));
    }
    @Test
    public void whenAllBoxesAreFilledThenDraw(){
        setAllBoxesToX();
        assertEquals(true,zad1.Draw(zad1.getBoard()));
    }
    public void setAllBoxesToX(){
        int sqr = zad1.getBoard().length;
        for (int ox = 0; ox < sqr; ox++){
            for (int oy = 0; oy < sqr; oy++){
                if (zad1.getBoard()[ox][oy] == '\0'){
                    zad1.getBoard()[ox][oy] = 'X';
                }}}}}