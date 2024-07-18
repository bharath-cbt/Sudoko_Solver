import java.util.*;
import java.lang.*;

class Sudoko {

    public static final int DIM = 9;
    public static final int SAFE = 1;
    public static final int UNSAFE = 0;

    static void Printboard(int WB[][]) {
        int r;
        int c;
        for (r = 0; r < DIM; r++) {
            for (c = 0; c < DIM; c++) {
                System.out.print(WB[r][c] + " ");
            }
            System.out.println();
        }
    }

    static int Is_Safe(int WB[][], int row, int col, int trail_value) {
        int r;
        int c;
        r = row;
        c = col;

        // row
        for (r = 0; r < DIM; r++) {
            if (WB[r][col] == trail_value) {
                return UNSAFE;
            }
        }

        // col
        for (c = 0; c < DIM; c++) {
            if (WB[row][c] == trail_value) {
                return UNSAFE;
            }
        }

        // subcol & subrow
        int subrow;
        int subcol;
        subrow = (row / 3) * 3;
        subcol = (col / 3) * 3;
        for (r = 0; r < 3; r++) {
            for (c = 0; c < 3; c++) {
                if (WB[r + subrow][c + subcol] == trail_value)
                    return UNSAFE;
            }
        }

        return SAFE;

    }

    static void Sudoko_helper(int GB[][], int WB[][], int row, int col) {
        int r;
        int c;
        r = row;
        c = col;

        int solutionFound = 0;
        if (c == DIM) {
            c = 0;
            r += 1;
            if (r == DIM) {
                // problem is solved;
                System.out.println("Solution Found");
                Printboard(WB);
                solutionFound = 1;
                return;
            }
        }
        if (GB[r][c] != 0) {
            Sudoko_helper(GB, WB, r, c + 1);
            return;
        }

        else {
            int trail_value;
            for (trail_value = 1; trail_value <= DIM; trail_value++) {
                if (Is_Safe(WB, r, c, trail_value) == SAFE) {
                    WB[r][c] = trail_value;
                    Sudoko_helper(GB, WB, r, c + 1);
                    WB[r][c] = 0;
                }
            }
        }
    }

    static void Solve_sudoko(int GB[][]) {
        int r;
        int c;
        int WB[][] = new int[DIM][DIM];
        for (r = 0; r < DIM; r++) {
            for (c = 0; c < DIM; c++) {
                WB[r][c] = GB[r][c];
            }
        }

        Sudoko_helper(GB, WB, 0, 0);
    }

    public static void main(String args[]) {
        // int GB[DIM][DIM];
        int[][] GB = {
                // { 0, 0, 0, 8, 0, 1, 0, 0, 0 },
                // { 0, 0, 0, 0, 0, 0, 0, 4, 3 },
                // { 5, 0, 0, 0, 0, 0, 0, 0, 0 },
                // { 0, 0, 0, 0, 7, 0, 8, 0, 0 },
                // { 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                // { 0, 2, 0, 0, 3, 0, 0, 0, 0 },
                // { 6, 0, 0, 0, 0, 0, 0, 7, 5 },
                // { 0, 0, 3, 4, 0, 0, 0, 0, 0 },
                // { 0, 0, 0, 2, 0, 0, 6, 0, 0 }
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        Solve_sudoko(GB);
    }
}