/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentago;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
class PentagoGame {

        PentagoTable thisTable;
	ArrayList<PentagoGame> leaf;

    public PentagoGame(PentagoTable thisTable, ArrayList<PentagoGame> children) {
        this.thisTable = thisTable;
        this.leaf = children;
    }
        
    public PentagoTable getThisTable() {
        return thisTable;
    }

    public void setThisTable(PentagoTable thisTable) {
        this.thisTable = thisTable;
    }

    public ArrayList<PentagoGame> getChildren() {
        return leaf;
    }

    public void setChildren(ArrayList<PentagoGame> children) {
        this.leaf = children;
    }
    
	
	public PentagoGame(PentagoTable board)
	{
		thisTable = board;
	}
	public int childNumber()
	{
		return leaf.size();
	}
	
	public ArrayList<PentagoGame> getChildTrees()
	{
		return leaf;
	}
	public PentagoTable getTable()
	{
		return thisTable;
	}
	public void buildNodeChildren()
	{
		ArrayList<PentagoTable> tableChildren = thisTable.getChildren();
		leaf = new ArrayList<PentagoGame>();
		for(int i = 0; i < tableChildren.size(); i++)
		{
			leaf.add(new PentagoGame(tableChildren.get(i)));
			
		}
	}
	   
}

 class PentagoTable {
    
    private int[][] table;
    private String lastMove = "";	

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }
	
        
	public PentagoTable()
	{
		table = new int[6][6];
		emptyTable();
	}
	
	public PentagoTable(int[][] moves)
	{
		table = new int[6][6];
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
				table[i][j] = moves[i][j];
		}
	}
        private void emptyTable()
	{
		for(int i = 0; i < table.length; i++)
		{
			for(int j = 0; j < table[i].length; j++)
				table[i][j] = 0;
		}
	}
        	public String getLastMove()
	{
		return lastMove;
	}
	public void setLastMove(String move)
	{
		lastMove = move;
	}
        
        public ArrayList<PentagoTable> getChildrenHelper(int a, int b, int c, int d,int i, int j,ArrayList<PentagoTable> childrenList)
        {
            PentagoTable tempBoard = new PentagoTable(table);
	    tempBoard.makeMove(2, i, j);
	    tempBoard.rotateABCD(a,b,c,d);
	    tempBoard.setLastMove(i + " " + j + " " + "D");
	    childrenList.add(tempBoard);
            return childrenList;
        }
        public void printTable()
	{
		for(int i = 0; i < table.length; i++)
		{
			String lineString = "";
			for(int j = 0; j < table[i].length; j++)
			{
				if(table[i][j] == 1)
                                {
					lineString += "W ";
                                }
				else if(table[i][j] == 2)
                                {
					lineString += "B ";
                                }
				else
                                {
					lineString += "0 ";
                                }
				if(j == 2)
                                {
                                    lineString += "  ";
                                }	
			}
			System.out.println(lineString);
			if(i == 2){	
				System.out.println("             ");
                        }
		}
	}

	public void makeMove(int player, int row, int col)
	{
		table[row - 1][col - 1] = player;
	}
	
	static int[][] rotateClock(int[][] mat) {
	    final int m = mat.length;
	    final int n = mat[0].length;
	    int[][] ret = new int[n][m];
	    for (int r = 0; r < m; r++) {
	        for (int c = 0; c < n; c++) {
	            ret[c][m-1-r] = mat[r][c];
	        }
	    }
	    return ret;
	}
	public static int[][] rotateCounter(int[][] mat) {
	    return rotateClock(rotateClock(rotateClock(mat)));
	}
        	public void rotate(String key)
	{
		if(Character.isUpperCase(key.charAt(0)))
		{
			if(key.equals("A"))
			{
				rotateABCD(0,0,0,0);
			}
			else if (key.equals("B"))
			{
				rotateABCD(0,3,0,3);
			}
			else if (key.equals("C"))
			{
				rotateABCD(3,0,3,0);
			}
			else if (key.equals("D"))
			{
				rotateABCD(3,3,3,3);
			}
		}
		
	}
	
        public void rotateABCD(int x, int y, int z, int w)
        {
            int[][] quarter = new int[3][3];
            for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				quarter[i][j] = table[i+x][j+y];
			}
		}
            quarter = rotateCounter(quarter);
	
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				table[i+z][j+w] = quarter[i][j];
			}
		}
            
        }
	public ArrayList<PentagoTable> getChildren()
	{
		ArrayList<PentagoTable> childrenList = new ArrayList<PentagoTable>();
				
		for(int i = 1; i < 7; i++)
		{
			for(int j = 1; j < 7; j++)
			{
                             childrenList=getChildrenHelper(0,0,0,0,i,j,childrenList);
			}
		}
		for(int i = 1; i < 7; i++)
		{
			for(int j = 1; j < 7; j++)
			{
                             childrenList=getChildrenHelper(0,3,0,3,i,j,childrenList);
			}
		}
		for(int i = 1; i < 7; i++)
		{
			for(int j = 1; j < 7; j++)
			{
                             childrenList=getChildrenHelper(3,0,3,0,i,j,childrenList);
			}
		}
		for(int i = 1; i < 7; i++)
		{
			for(int j = 1; j < 7; j++)
			{
                            childrenList=getChildrenHelper(3,3,3,3,i,j,childrenList);
			}
		}
		
		return childrenList;
	}
        public int getCost()
	{
		int cost = 0;
		int line = 0;			
		
		for(int i = 0; i < 6; i++)	
		{
			for(int j = 0; j < 5; j++)	
			{
				if(table[i][j] == 2 && table[i][j+1] == 2)
				{
					cost += line + 1;
					line++;
				}
				else
                                {
					line = 0;
                                }
			}
		}
		for(int i = 0; i < 6; i++)	
		{
			for(int j = 0; j < 5; j++)	
			{
				if(table[j][i] == 2 && table[j+1][i] == 2)
				{
					cost += line + 1;
					line++;
				}
				else
                                {
					line = 0;
                                }
			}
		}
		
		for(int i = 0; i < 5; i++)
		{
			if(table[i][i] == 2 && table[i+1][i+1] == 2)
			{
				cost += line + 1;
				line++;
			}
			else
                        {
				line = 0;
                        }
		}
		
		for(int i = 0; i < 5; i++)
		{
			if(table[i][5-i] == 2 && table[i+1][4-i] == 2)
			{
				cost += line + 1;
				line++;
			}
			else
                        {
				line = 0;
                        }
		}
		
		return cost;
	}
	public int isWinner()
	{
		for(int i = 0; i < 6; i++)
		{
			if((table[i][0] == 1 && table[i][1] == 1 && table[i][2] == 1 && table[i][3] == 1 && table[i][4] == 1)||
                           (table[i][1] == 1 && table[i][2] == 1 && table[i][3] == 1 && table[i][4] == 1 && table[i][5] == 1)||
                            (table[0][i] == 1 && table[1][i] == 1 && table[2][i] == 1 && table[3][i] == 1 && table[4][i] == 1)||
                             (table[1][i] == 1 && table[2][i] == 1 && table[3][i] == 1 && table[4][i] == 1 && table[5][i] == 1))
                        {
				return 1;
                        }
			if((table[i][0] == 2 && table[i][1] == 2 && table[i][2] == 2 && table[i][3] == 2 && table[i][4] == 2)||
                            (table[i][1] == 2 && table[i][2] == 2 && table[i][3] == 2 && table[i][4] == 2 && table[i][5] == 2)||
                             (table[0][i] == 2 && table[1][i] == 2 && table[2][i] == 2 && table[3][i] == 2 && table[4][i] == 2)||
                              (table[1][i] == 2 && table[2][i] == 2 && table[3][i] == 2 && table[4][i] == 2 && table[5][i] == 2))
                        {
				return 2;
                        }
		}
                if((table[0][1] == 1 && table[1][2] == 1 && table[2][3] == 1 && table[3][4] == 1 && table[4][5] == 1) ||
                (table[1][0] == 1 && table[2][1] == 1 && table[3][2] == 1 && table[4][3] == 1 && table[5][4] == 1)||
                (table[1][0] == 1 && table[2][1] == 1 && table[3][2] == 1 && table[4][3] == 1 && table[5][4] == 1)||
                (table[0][4] == 1 && table[1][3] == 1 && table[2][2] == 1 && table[3][1] == 1 && table[4][0] == 1)||
                (table[1][5] == 1 && table[2][4] == 1 && table[3][3] == 1 && table[4][2] == 1 && table[5][1] == 1)||
                (table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1 && table[3][3] == 1 && table[4][4] == 1)||
                (table[1][1] == 1 && table[2][2] == 1 && table[3][3] == 1 && table[4][4] == 1 && table[5][5] == 1)||
                (table[0][5] == 2 && table[1][4] == 2 && table[2][3] == 2 && table[3][2] == 2 && table[4][1] == 2)||
                (table[1][4] == 1 && table[2][3] == 1 && table[3][2] == 1 && table[4][1] == 1 && table[5][0] == 1))
                {
                    return 1;
                }
		if((table[0][1] == 2 && table[1][2] == 2 && table[2][3] == 2 && table[3][4] == 2 && table[4][5] == 2)||
                        (table[1][0] == 2 && table[2][1] == 2 && table[3][2] == 2 && table[4][3] == 2 && table[5][4] == 2)||
                        (table[0][4] == 2 && table[1][3] == 2 && table[2][2] == 2 && table[3][1] == 2 && table[4][0] == 2)||
                        (table[1][5] == 2 && table[2][4] == 2 && table[3][3] == 2 && table[4][2] == 2 && table[5][1] == 2)||
                        (table[0][0] == 2 && table[1][1] == 2 && table[2][2] == 2 && table[3][3] == 2 && table[4][4] == 2)||
                        (table[1][1] == 2 && table[2][2] == 2 && table[3][3] == 2 && table[4][4] == 2 && table[5][5] == 2)||
                        (table[0][5] == 2 && table[1][4] == 2 && table[2][3] == 2 && table[3][2] == 2 && table[4][1] == 2)||
                        (table[1][4] == 1 && table[2][3] == 1 && table[3][2] == 1 && table[4][1] == 1 && table[5][0] == 1)||
                        (table[1][4] == 2 && table[2][3] == 2 && table[3][2] == 2 && table[4][1] == 2 && table[5][0] == 2))
                {
                    return 2;
                }
                    	
		return 0;
	}
}
