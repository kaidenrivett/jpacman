package jpacman.board;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WithinBordersTest {

    private Board board;

    @BeforeEach
    void setUp() {
        Square[][] grid = new Square[8][8];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                grid[i][j] = new BasicSquare();
            }
        }
        board = new Board(grid);
    }

    @ParameterizedTest
    @CsvSource({
            // give a set of realistic values
            "1,2",
            "1,1",
            "5,5",
            "0,0",
            // give slightly larger values
            "20,20",
            // get some negative values in there
            "-1,1",
            // get the boundary cases
            "7,7",
            "8,8",
            "99999,99999",
    })

//    public boolean withinBorders(int x, int y) {
//        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
//    }
//}
    void EqualCheck(int x, int y){
        // setting up a board
        List<String> map = Lists.newArrayList(
                "##########",
                "#P      C#",
                "##########"
        );
        // assert that the x and y values passed exist in the created map
        assertTrue(board.withinBorders(x,y));
    }
}
