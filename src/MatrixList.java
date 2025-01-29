/**
 * This Class represtes a linked list if IntNodeMat Nodes
 *
 * @author Yehuda Rothstein
 * @version 1/23/2025
 */
public class MatrixList
{
    IntNodeMat _m00;

    public MatrixList()
    {
        _m00 = null;
    }

    public MatrixList(int[][]mat)
    {
        _m00 =  new IntNodeMat(mat[0][0]);
        arrayToLinkedList(mat, 0, 0, _m00, _m00, null, null);
    }

    private IntNodeMat arrayToLinkedList(int[][] mat, int i, int j,
                                         IntNodeMat current, IntNodeMat firstInRow,
                                         IntNodeMat prevRow, IntNodeMat prevCol
    ){
        if ((!(i < mat.length)) || (!(j < mat[0].length))){
            return null;
        }


        if (current != null){
            current.setData(mat[i][j]);
            current.setPrevCol(j > 0? prevCol: null);
            current.setPrevRow(i > 0? prevRow: null);
            if (current.getPrevRow() == null){
                current.setNextCol(j < mat[i].length-1? new IntNodeMat(mat[i][j+1]): null);

            } else  {
                current.setNextCol(prevRow.getNextCol() == null? null : prevRow.getNextCol().getNextRow());
            }
            current.setNextRow(i < mat.length-1? new IntNodeMat(mat[i+1][j]): null);
//            System.out.println("\t"+current.getPrevRow());
//            System.out.println(current.getPrevCol() + "\t" + current + "\t" + current.getNextCol());
//            System.out.println("\t"+current.getNextRow());
//            System.out.println("------------------------------------------");

        }
        if ((j >= mat[i].length-1 )){
            return arrayToLinkedList(mat,i+1, 0, firstInRow.getNextRow(), firstInRow.getNextRow(),firstInRow, prevCol);
        }
        if (prevRow == null)
            return arrayToLinkedList(mat, i, j+1, current.getNextCol(), firstInRow, prevRow, current);

        return arrayToLinkedList(mat, i, j+1, current.getNextCol(), firstInRow, prevRow.getNextCol(), current);

    }


    public int getData_i_j (int i, int j)
    {
        IntNodeMat current = _m00;
        int counter = 0;
        while (counter != j){
            current = current.getNextCol();
            counter++;
        }
        if (current == null)
            return Integer.MIN_VALUE;

        counter = 0;
        while (counter != i){
            current = current.getNextRow();
            counter++;
        }
        if (current == null)
            return Integer.MIN_VALUE;
        return current.getData();
    }

    public void setData_i_j(int num, int i, int j)
    {
        getData(i , j).setData(num);
    }


    public String toString()
    {
        return printRow(_m00);
    }

    private String printRow(IntNodeMat node){
        if (node == null){
            return "";
        }
        return  printRow(node.getNextCol()) + "/t" + node.getData();
    }

    public int findMax()
    {
        return findMax(_m00, _m00.getData());
    }

    private int findMax(IntNodeMat current, int max){
        if (current == null){
            return max;
        }
        if (current.getData() > max){
            return Math.max(
                    findMax(current.getNextRow(), current.getData()),
                    findMax(current.getNextCol(), current.getData())
            );
        }

        return  Math.max(
                findMax(current.getNextRow(), max),
                findMax(current.getNextCol(), max)
        );
    }

    // O(n+m) time Compelxity O(1) space Compelxity
    public int howManyX(int x) {
        IntNodeMat current = _m00;
        int counter = 0;

        while (current != null) {
            if (current.getData() == x) {
                counter++;
                current = current.getNextCol();
            } else if (current.getData() < x) {
                current = current.getNextCol();
            } else {
                current = current.getNextRow();
            }
        }
        return counter;
    }


    public IntNodeMat getData (int i, int j)
    {
        IntNodeMat current = _m00;
        int counterRow = 0;
        int couterCol = 0;
        while (current != null){
            if (counterRow == i){
                while (current != null){
                    if (couterCol == j){
                        return current;
                    }
                    current = current.getNextCol();
                    couterCol++;
                }
            }
            current = current.getNextRow();
            counterRow++;
        }
        return null;
    }
}
