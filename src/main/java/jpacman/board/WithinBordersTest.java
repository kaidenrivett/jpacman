//package jpacman.board;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//public class WithinBordersTest {
//
//    private Board board;
//
//    @BeforeEach
//    void setUp() {
//        Square[][] grid = new Square[8][8];
//
//        for(int i = 0; i < grid.length; i++){
//            for(int j = 0; j<grid[0].length; j++){
//                grid[i][j] = new BasicSquare();
//            }
//        }
//
//        board = new Board(grid);
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "1,2",
//            "0,1",
//            "1,1"
//    })
//    void EqualCheck(int x, int y){
//        // setting up a board
//        board.withinBorders()
//        assert(x==y);
//
//    }
//}
