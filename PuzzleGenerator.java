package flood;

import java.util.Random;

import static flood.Utils.*;

/** A creator of random Flood puzzles.
 *  @author Haoqing Xuan
 */
class PuzzleGenerator implements PuzzleSource {

    /** A new PuzzleGenerator whose random-number source is seeded
     *  with SEED. */
    PuzzleGenerator(long seed) {
        _random = new Random(seed);
    }

    @Override
    public Model getPuzzle(int width, int height, int ncolors, int extra) {
        int[][] puzzleA = new int[height][width];
        for (int[] row : puzzleA) {
            for (int col = 0; col < width; col++) {
                row[col] = _random.nextInt(ncolors);
            }
        }
        Model model = new Model(puzzleA, ncolors);
        model.setLimit(Solver.movesNeeded(model) + extra);
        return model;
    }


    @Override
    public void setSeed(long seed) {
        _random.setSeed(seed);
    }

    /** My PNRG. */
    private Random _random;

}
