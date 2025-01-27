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
        IntNodeMat first =  new IntNodeMat(mat[0][0]);
        arrayToLinkedList(mat, 0, 0, first, first);
    }

    private IntNodeMat arrayToLinkedList(int[][] mat, int i, int j, IntNodeMat current, IntNodeMat first){
        if ((!(i < mat.length)) || (!(j < mat[0].length))){
            return null;
        }

        if (current != null){
            current.setData(mat[i][j]);
            current.setNextCol(j < mat[i].length-1? new IntNodeMat(mat[i][j+1]): null);
            current.setNextRow(i < mat.length-1? new IntNodeMat(mat[i+1][j]): null);
            current.setPrevCol(j >= 1? current.getPrevCol(): null);
            current.setPrevRow(i >= 1? current.getPrevRow(): null);
            System.out.println(current);
            System.out.println(current.getNextCol());
            System.out.println(current.getPrevCol());
            System.out.println(current.getPrevRow());
            System.out.println(current.getNextRow());
        }
        if ((j >= mat[i].length-1 )){
            return arrayToLinkedList(mat,i+1, 0, first.getNextRow(), first.getNextRow());
        }
        return arrayToLinkedList(mat, i, j+1, current.getNextCol(), first);
    }


    public int getData_i_j (int i, int j)
    {
        IntNodeMat current = _m00;
        int counter = 0;
        int Secondcounter = 0;
        while (current != null){
            if (counter == i){
                while (current != null){
                    if (Secondcounter == j){
                        return current.getData();
                    }
                    current = current.getNextRow();
                    Secondcounter++;
                }
            }
            current = current.getNextCol();
            i++;
        }
        return Integer.MIN_VALUE;
    }

    public void setData_i_j(int num, int i, int j)
    {
        IntNodeMat current = _m00;
        int counter = 0;
        int Secondcounter = 0;
        while (current != null){
            if (counter == i){
                while (current != null){
                    if (Secondcounter == j){
                        current.setData(num);
                    }
                    current = current.getNextRow();
                    Secondcounter++;
                }
            }
            current = current.getNextCol();
            i++;
        }
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
        return findMax(_m00, _m00.getData(), 0 , 0);
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
    public int howManyX(int x){
        IntNodeMat current = _m00;
        int counter = 0;
        while (current.getData() <= x){
            while (current.getData() <= x){
                if (current.getData() == x){
                    counter++;
                    break;
                }
                current = current.getNextCol();
            }
            current = current.getNextRow();
        }
        return counter;
    }

}
