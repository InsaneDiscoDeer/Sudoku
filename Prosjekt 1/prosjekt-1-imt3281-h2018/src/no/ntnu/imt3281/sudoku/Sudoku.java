package no.ntnu.imt3281.sudoku;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ResourceBundle;


/**
 * @author   Hugo Nørholm, Vegard Elgesem Kostveit
 * @version   1.0
 * @since 1.0
 *
 * This is the main class in a sudoku game application
 */
public class Sudoku {
	ResourceBundle messages = ResourceBundle.getBundle("I18N.messages");

    Integer[] brett = new Integer[81];

	/**
	 * Inserts an int on the board
	 *
	 * @param i value
     * @param pos where it is being placed
	 */
    public void insertInt(int i, int pos){
        brett[pos] = i;
    }

    /**
     * Gives board pos from x and y coordinate
     *
     * @param x column
     * @param y row
     * @return board position
     */
    public static int getCoord(int x, int y) {
    	int i = ((x - x % 3) * 3 + x % 3) + (((y - y % 3) * 3 + y % 3) * 3);
    	return i;
    }

    /**
     * Inserts an int on the board based on coordinates
     *
     * @param x column
     * @param y row
     * @param value value
     */
    public void insertCoord(int x , int y, int value) {
        int i = ((x - x % 3) * 3 + x % 3) + (((y - y % 3) * 3 + y % 3) * 3);
        brett[i]= value;
    }


    /**
     * Loads a hard coded string to the board
     *
     */
    public void temp(){
        String test = "["
	                +"[5, 3, -1, -1, 7, -1, -1, -1, -1],"
	                +"[6, -1, -1, 1, 9, 5, -1, -1, -1],"
                    +"[-1, 9, 8, -1, -1, -1, -1, 6, -1],"
	                +"[8, -1, -1, -1, 6, -1, -1, -1, 3],"
	                +"[4, -1, -1, 8, -1, 3, -1, -1, 1],"
	                +"[7, -1, -1, -1, 2, -1, -1, -1, 6],"
	                +"[-1, 6, -1, -1, -1, -1, 2, 8, -1],"
	                +"[-1, -1, -1, 4, 1, 9, -1, -1, 5],"
                    +"[-1, -1, -1, -1, 8, -1, -1, 7, 9]"
                    +"]";
        test=test.replace("[","");
        test=test.substring(0,test.length()-2);
        String t1[]=test.split("],");
        
        
        for(int i=0;i<t1.length;i++){
            t1[i]=t1[i].trim();
            String singleRow[]=t1[i].split(", ");

            for(int j=0;j<singleRow.length;j++){
                insertCoord(j,i,Integer.parseInt(singleRow[j]));
            }
        }
    }
    
    
    public void finalsudoku(){
        String test = "["
	                +"[2, 4, 1, 5, 9, 3, 8, 6, 7],"
	                +"[8, 3, 9, 6, 7, 2, 1, 5, 4],"
                    +"[6, 7, 5, 4, 8, 1, 2, 3, 9],"
	                +"[9, 2, 4, 1, 3, 8, 5, 7, 6],"
	                +"[1, 5, 7, 9, 2, 6, 3, 4, 8],"
	                +"[3, 6, 8, 7, 5, 4, 9, 1, 2],"
	                +"[7, 8, 6, 3, 1, 9, 4, 2, 5],"
	                +"[5, 9, 3, 2, 4, 7, 6, 8, 1],"
                    +"[4, 1, 2, 8, 6, 5, 7, 9, 3]"
                    +"]";
        test=test.replace("[","");
        test=test.substring(0,test.length()-2);
        String t1[]=test.split("],");
        
        
        for(int i=0;i<t1.length;i++){
            t1[i]=t1[i].trim();
            String singleRow[]=t1[i].split(", ");

            for(int j=0;j<singleRow.length;j++){
                insertCoord(j,i,Integer.parseInt(singleRow[j]));
            }
        }
    }

    /**
     * Makes an iterator of one of the boards rows
     *
     * @param row row being turned to iterator
     * @return iterator containing values of a row
     */
    public Iterator<Integer> iteratorRow(int row){
    	int[] array = new int[9];
    	for(int i = 0;i<9;i++) {
    		array[i]=brett[Sudoku.getCoord(i, row)];
    	}
    	Iterator<Integer> iterator = Arrays.stream(array).iterator();
    	return iterator;
    }

    /**
     * Makes an iterator of one of the boards columns
     *
     * @param column column being turned to iterator
     * @return iterator containing values of a column
     */
    public Iterator<Integer> iteratorColumn(int column){
        int[] array = new int[9];
        for(int i = 0;i<9;i++) {
            array[i]=brett[Sudoku.getCoord(column, i )];
        }
        Iterator<Integer> iterator = Arrays.stream(array).iterator();
        return iterator;
    }

    /**
     * Makes an iterator of one of the boards subblock
     *
     * @param block block being turned to iterator
     * @return iterator containing values of a block
     */
    public Iterator<Integer> iteratorBlock(int block){
        int[] array = new int[9];
        int temp = block*9;
        for(int i = 0;i<9;i++) {
            array[i]=brett[temp];
            temp++;
        }
        Iterator<Integer> iterator = Arrays.stream(array).iterator();
        return iterator;
    }


    /**
     * Swaps two values on the board around
     *
     * @param x first value
     * @param y  value that x is swapping with
     */
    public void replaceNumber(int x , int y) {
       for(int i = 0; i<81; i++){
           if(brett[i]==x) {
               brett[i] = y;
           } else if(brett[i]==y) {
               brett[i] = x;
           }
       }
    }

    /**
     * Flips the table vertically making the rows appear in opposite order
     * 
     * Saves the left array | puts the right in to the original left | puts the saved left into the right
     */
    public void flipVertical() {
    	int xl = 0, xr = 8, valueLeft = 0;
    	
    	for (int i=0; i<4; i++) {
    		for (int y=0; y<9; y++) {
    			valueLeft = brett[getCoord(xl, y)];
    			
    			insertInt(brett[getCoord(xr, y)], getCoord(xl, y));
    			insertInt(valueLeft, getCoord(xr, y)); 
    		}
    		xl++;
    		xr--;
    	}
	}

    /**
     * Flips the table horizontally making the columns appear in opposite order
     * 
     * Saves the top array | puts the bottom array in the original top | puts the saved top onto the bottom
     */
    public void flipHorizontal() {
    	int yt = 0, yb = 8, valueTop = 0;
    	
    	for (int i=0; i<4; i++) {
    		for (int x=0; x<9; x++) {
    			valueTop = brett[getCoord(x, yt)];
    			
    			insertInt(brett[getCoord(x, yb)], getCoord(x, yt));
    			insertInt(valueTop, getCoord(x, yb));
    		}
    		yt++;
    		yb--;
    	}
    }

    /**
     * Flips the table diagonally making the reversing their order int the array
     * 
     * Flips the table diagonally with top left/bottom right as "anchors"
     * StartNumber indicates the first pos to flip in the arrays | xx,xy are the coordinates | nl is NumbersLeft in the array
     * First for = going along the diagonal with x-coordinates
     * Second for = Doing it for the numbers left in the array
     * Then we save the values from below the diagonal | Inserts values from over into under | Inserts from the temp into over
     * Then we move the starting points for the copying in the x-arrays and the y-arrays (for eksample brett[1] and brett [5]
     */
    public void flipDiagonalLeft() {
    	int sn = 1, xx = 1, xy = 0;
    	int temp = 0, nl = 8;
   
    	
    	for (int x=0; x<8; x++) {
    		for (int y=sn; y<=nl; y++) {
    			temp = brett[getCoord(x, y)];
    			
    			insertInt(brett[getCoord(xx, xy)], getCoord(x, y));
    			insertInt(temp, getCoord(xx, xy));
    			xx++;
    		}
    		sn++;
    		xx = sn;
    		xy++;
    	}
    }

    /**
     * Flips the table diagonally along the other axis
     * 
     * Flips the table diagonally with top right/bottom left as "anchors"
     * StartNumber indicates the first pos to flip in the arrays (in y-direction)
     * xx,xy are the coordinates | nl is NumbersLeft in the array
     * First for = going along the diagonal with y-coordinates
     * Second for = doing it for the numbers left in the array
     * Then we save the values from above the diagonal | Inserts values from under into above | Inserts from the temp into under
     * Then we move the starting points for the copying in the y-arrays (for eksample brett[0] and brett [3]
     */
    public void flipDiagonalRight() {
    	int sn = 1, xx = 8, xy = 1;
    	int temp = 0, nl = 7;
    	
    	for (int y=0; y<8; y++) {
    		for (int x=nl; x>=0; x--) {
    			temp = brett[getCoord(x, y)];
    			
    			insertInt(brett[getCoord(xx, xy)], getCoord(x, y));
    			insertInt(temp, getCoord(xx, xy));
    			xy++;
    		}
    		nl--;
    		sn++;
    		xy = sn;
    		xx--;
    	}
    }
    

    /**
     * Checks if a number already exists in a row
     *
     * @param num value being checked
     * @param x columm
     * @param y row
     * @throws BadNumberException containing string with useful info
     */
    public void checkRow(int x, int y, int num) throws BadNumberException {
        Iterator<Integer> row = iteratorRow(y);
        int i;
        int j = 0;
        while(row.hasNext()) {
        	i = row.next();
        	
        	if(i==num && x != j) {
        		String err = num + (messages.getString("existField")) + j +","+ y + (messages.getString("sameRow"));
        		throw new  BadNumberException(err); 
        }
        	j++;
    }	
    }

    /**
     * Checks if a number already exists in a column
     *
     * @param num value being checked
     * @param x columm
     * @param y row
     * @throws BadNumberException containing string with useful info
     */
    public void checkColumn(int x, int y, int num) throws BadNumberException {
        Iterator<Integer> column = iteratorColumn(x);
        int i;
        int j = 0;
        while(column.hasNext()) {
        	i = column.next();
        	
        	if(i==num && y != j) {
        		String err = num + (messages.getString("existField")) + x +","+ j + (messages.getString("sameColumn"));
        		throw new  BadNumberException(err); 
        }
        	j++;
    }	  
        
    }

    /**
     * Checks if a number already exists in a block
     *
     * @param num value being checked
     * @param x column
     * @param y row
     * @throws BadNumberException containing string with useful info
     */
    public void checkBlock(int x, int y, int num) throws BadNumberException {
        int i;
        int pos = getCoord(x,y);
        int blocknum = pos/9;
        int j = blocknum * 9;
        Iterator<Integer> block = iteratorBlock(blocknum);
        while(block.hasNext()) {
        	i = block.next();
        	
        	if(i==num && j != pos) {
        		String err = num + (messages.getString("exist")) + (messages.getString("sameBlock"));
        		throw new  BadNumberException(err); 
        	}
        	j++;
        }
    }
    
    /**
     * Resets the board
     */
    public void resetBoard() {
    	for (int i=0; i<81; i++) {
    		brett[i] = -1;
    	}
    }
    
	/**
	 * Checks if all blocks contain 9 unique ints
	 *
	 * @throws BadNumberException containing string with useful info
	 */
    public void blocksDone() throws BadNumberException {
    	for (int i = 0;i < 9; i++) {
            for (int j=1; j<10;j++) {
                Iterator<Integer> block = iteratorBlock(i);
            	Boolean exist = false;
                while(block.hasNext()) {
                	int x = block.next();
                	if(x==j) {
                		if (exist != true) {
                			exist = true;
                		} else {
                    		String err = (messages.getString("block")) + i + (messages.getString("notUnique"));
                    		throw new  BadNumberException(err);        			
                		} 
                	}
                }
            }
    	}
    }
    
	/**
	 * Checks if all rows contain 9 unique ints
	 *
	 * @throws BadNumberException containing string with useful info
	 */
    public void rowsDone() throws BadNumberException {
    	for (int i = 0;i < 9; i++) {
            for (int j=1; j<10;j++) {
                Iterator<Integer> row = iteratorRow(i);
            	Boolean exist = false;
                while(row.hasNext()) {
                	int x = row.next();
                	if(x==j) {
                		if (exist != true) {
                			exist = true;
                		} else {
                    		String err = (messages.getString("row")) + i + (messages.getString("notUnique"));
                    		throw new  BadNumberException(err);        			
                		} 
                	}
                }
            }
    	}
    }
    
	/**
	 * Checks if all columns contain 9 unique ints
	 *
	 * @throws BadNumberException containing string with useful info
	 */
    public void columnsDone() throws BadNumberException {
    	for (int i = 0;i < 9; i++) {

            for (int j=1; j<10;j++) {
                Iterator<Integer> column = iteratorColumn(i);
            	Boolean exist = false;
                while(column.hasNext()) {
                	int x = column.next();
                	if(x==j) {
                		if (exist != true) {
                			exist = true;
                		} else {
                    		String err = (messages.getString("column")) + i + (messages.getString("notUnique"));
                    		throw new  BadNumberException(err);        			
                		} 
                	}
                }

            }
    	}
    }
    
	/**
	 * Checks if board is filled and game is solved.
	 */
    public boolean isdone () {
    	Boolean done = true;
    	
    	for(int  i=0;i<81;i++) {
    		if  (brett[i] == null || brett[i]>9 || brett[i]<1) {
    			done = false;
    		}
    	}
    	if(done) {
    		try {
    			columnsDone();
    			rowsDone();
    			blocksDone();
    			
    		}
    		catch(BadNumberException e) {
    			done = false;
    		}
    	}    	    	
    	return done; 
    }
	
}





