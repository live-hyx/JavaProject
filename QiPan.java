package algorithm;

public class QiPan {
	 
    /**
     * @param tr表示棋盘左上角行号
     * @param tc表示棋盘左上角列号
     * @param dr表示特殊棋盘的行号
     * @param dc表示特殊棋盘的列号
     * @param SIZE
     *            =2^k。棋盘的规格为2^k*2^k
     * */
    public static void ChessBoard(int tr, int tc, int dr, int dc, int size) {
        if (size == 1) {
            return;
        }
        int t = title++; // t表示L型骨牌的编号
        int s = size / 2; // 分割棋盘
 
        // 覆盖左上角棋盘
        if (dr < tr + s && dc < tc + s) {
            // 说明特殊方格在此小棋盘中
            ChessBoard(tr, tc, dr, dc, s);
        } else {
            // 说明特殊方格不在此小棋盘中
            // 用t号L型棋盘覆盖这个小棋盘的右下角
            board[tr + s - 1][tc + s - 1] = t;
            // 覆盖其余棋盘
            ChessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
 
        // 覆盖右上角棋盘
        if (dr < tr + s && dc >= tc + s) {
            ChessBoard(tr, tc + s, dr, dc, s);
        } else {
            board[tr + s - 1][tc + s] = t;
            ChessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        // 覆盖左下角棋盘
        if (dr >= tr + s && dc < tc + s) {
            ChessBoard(tr + s, tc, dr, dc, s);
        } else {
            board[tr + s][tc + s - 1] = t;
            ChessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        // 覆盖右下角棋盘
        if (dr >= tr + s && dc >= tc + s) {
            ChessBoard(tr + s, tc + s, dr, dc, s);
        } else {
            board[tr + s][tc + s] = t;
            ChessBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
 
    }
 
    public static void main(String[] args) {
        // 假设特殊方格的位置为第三行第三列
        board[2][2] = 0;
        ChessBoard(0, 0, 2, 2, SIZE);
 
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
 
    static final int SIZE = 4;
    static int[][] board = new int[SIZE][SIZE];
    static int title = 1; // title表示L型骨牌的编号
}