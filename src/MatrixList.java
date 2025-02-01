/**
 * This Class represtes a linked list if IntNodeMat Nodes
 *
 * @author Yehuda Rothstein
 * @version 1/23/2025
 */
public class MatrixList
{
    IntNodeMat _m00;

    public MatrixList() {
        _m00 = null;
    }

    /**
     * Matrix List constructer
     * @param mat is the 2D array for the Linked List
     */
    public MatrixList(int[][]mat) {
        //start filling in the Linked list only if the matrix has a value
        if (mat.length != 0 && mat[0].length != 0) {
            // set the head node to the top left cell
            _m00 = new IntNodeMat(mat[0][0]);
            // initialize the Linked List with the basic values,
            // for the first cell the previous Row and previous column is pointing to null
            arrayToLinkedList(mat, 0, 0, _m00, _m00, null, null);
        }
    }

    /**
     * a recursive function to create a linked list form a 2D array
     * @param mat the 2d array
     * @param i the current row in the matrix
     * @param j the current column in the matrix
     * @param current current node
     * @param firstInRow first node in the linked list for reset
     * @param prevRow the previous row of the current node
     * @param prevCol the previous column of the current node
     * @return the next node to connect
     */
    private IntNodeMat arrayToLinkedList(int[][] mat, int i, int j,
                                         IntNodeMat current, IntNodeMat firstInRow,
                                         IntNodeMat prevRow, IntNodeMat prevCol
    ){
        // check if the current i & j pointers are in bound
        if ((!(i < mat.length)) || (!(j < mat[0].length))){
            return null;
        }


        if (current != null){
            // set the data of the current node to the corresponding cell in the matrix
            current.setData(mat[i][j]);
            // set the previous row and column to the given parameter if it should
            current.setPrevCol(j > 0? prevCol: null);
            current.setPrevRow(i > 0? prevRow: null);
            // create new nodes if you are in the first row
            if (current.getPrevRow() == null)
                current.setNextCol(j < mat[i].length-1? new IntNodeMat(mat[i][j+1]): null);
            // set the next node onlt if you should, else point to null
            else
                current.setNextCol(prevRow.getNextCol() == null? null : prevRow.getNextCol().getNextRow());

            current.setNextRow(i < mat.length-1? new IntNodeMat(mat[i+1][j]): null);
        }

        // check if you need to go to the next row
        if ((j >= mat[i].length-1 ))
            return arrayToLinkedList(mat,i+1, 0, firstInRow.getNextRow(), firstInRow.getNextRow(),firstInRow, prevCol);

        // chekc if you are in the first row
        if (prevRow == null)
            return arrayToLinkedList(mat, i, j+1, current.getNextCol(), firstInRow, prevRow, current);

        return arrayToLinkedList(mat, i, j+1, current.getNextCol(), firstInRow, prevRow.getNextCol(), current);

    }

    /**
     * get the data of given pointers in 2d field
     * @param i the row of the data
     * @param j the column of the data
     * @return the data for those pointers
     */
    public int getData_i_j (int i, int j) {
        //check if the pointer or head node are in bound
        if (i < 0 || j < 0 || _m00 == null){
            return Integer.MIN_VALUE;
        }
        IntNodeMat current = _m00;
        int counter = 0;
        // go to the correct column
        while (counter != j){
            // check if the current is pointing to null
            if (current.getNextCol() == null){
                // if the last column is the correct column, point to it
                if (counter+1 == j)
                    current = current.getNextCol();
                return Integer.MIN_VALUE;
            }
            current = current.getNextCol();
            counter++;
        }

        counter = 0;
        // go to the correct row
        while (counter != i){
            // check if the current is pointing to null
            if (current.getNextRow() == null){
                // if the last row is the correct row, point to it
                if (counter+1 == j)
                    current = current.getNextRow();
                return Integer.MIN_VALUE;
            }
            current = current.getNextRow();
            counter++;
        }

        return current.getData();
    }

    /**
     * set the data of given pointers in 2d field
     * @param num the value to change
     * @param i the row of the data
     * @param j the column of the data
     */
    public void setData_i_j(int num, int i, int j) {
        //check if the node to set the data is null
        if (getNode(i,j) != null)
            //set the data for the corresponding node
            getNode(i, j).setData(num);
    }

    /**
     * the toString method for the MatrixList
     * @return the string
     */
    public String toString() {
        return printLinkedList(_m00);
    }

    /**
     * print a single row of the givenhead node
     * @param node the head node
     * @return a string representing the row
     */
    private String printRow(IntNodeMat node){
        // check when to stop printing
        if (node == null)
            return "";

        // if is the last node don't print the tab
        if (node.getNextCol() == null)
            return node.getData()+"\n";

        // recursively print the ro
        return node.getData()  + "\t" + printRow(node.getNextCol());
    }

    /**
     * a function that prints a linked list
     * @param current the head node for a row
     * @return the string representing the printed linked list
     */
    private String printLinkedList(IntNodeMat current){
        String string = "";
        // go over all the rows
        while(current != null){
            // append to the current string each row
            string = string + printRow(current);
            // point to the next head row
            current = current.getNextRow();
        }
        return string;
    }

    /**
     * find the maximum number in a Linked List
     * @return the value of the highest valued node
     */
    public int findMax(){
        if (_m00 != null){
            return findMax(_m00, _m00.getData());
        }
        return Integer.MIN_VALUE;
        // initiaize the recursive function with the basic values
    }

    /**
     * find the maximum number in a Linked List
     * @param current the current node
     * @param max the current maximum
     * @return the value of the highest valued node
     */
    private int findMax(IntNodeMat current, int max){
        //check if the current node isi'nt out of bounds
        if (current == null)
            return max;
        //check if the current value is bigger than the maximumn
        if (current.getData() > max){
            return Math.max(
                    findMax(current.getNextRow(), current.getData()),
                    findMax(current.getNextCol(), current.getData())
            );
        }
        // if the current value isint bigger
        return  Math.max(
                findMax(current.getNextRow(), max),
                findMax(current.getNextCol(), max)
        );
    }

    // O(n+m) time Compelxity O(1) space Compelxity
    // The complexity is O(m+n) because the algorithm starts at the top-right of the matrix
    // and moves only left or down. Since the matrix is sorted, every move skips checking a whole row or column,
    // making it much faster than checking every element.
    public int howManyX(int x) {
        if (_m00 == null)
            return 0;

        IntNodeMat current = _m00;
        int counter = 0;

        // Move to the top-right corner
        while (current.getNextCol() != null) {
            current = current.getNextCol();
        }

        while (current != null) {
            // if in the correct position go to the next row
            if (current.getData() == x) {
                counter++;
                current = current.getNextRow();
                // if overshot the cell go back
            } else if (current.getData() > x) {
                current = current.getPrevCol();
            } else {
                current = current.getNextRow();
            }
        }

        return counter;
    }


    /**
     * get the node with given pointers of a 2d field
     * @param i the row of the node
     * @param j the column of the node
     * @return the correspunding node
     */
    private IntNodeMat getNode(int i, int j) {
        //check if the pointer or head node are in bound
        if (i < 0 || j < 0 || _m00 == null){
            return null;
        }
        IntNodeMat current = _m00;
        int counter = 0;
        // go to the correct column
        while (counter != j){
            // check if the current is pointing to null
            if (current.getNextCol() == null){
                // if the last column is the correct column, point to it
                if (counter+1 == j)
                    current = current.getNextCol();
                return null;
            }
            current = current.getNextCol();
            counter++;
        }

        counter = 0;
        // go to the correct row
        while (counter != i){
            // check if the current is pointing to null
            if (current.getNextRow() == null){
                // if the last row is the correct row, point to it
                if (counter+1 == j)
                    current = current.getNextRow();
                return null;
            }
            current = current.getNextRow();
            counter++;
        }

        return current;
    }

}
