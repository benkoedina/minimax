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
public class Computer {

    private PentagoTable maxTable;
    private int max = 0;
    private int depth = 0;

    public PentagoTable getMaxTable() {
        return maxTable;
    }

    public void setMaxTable(PentagoTable maxTable) {
        this.maxTable = maxTable;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Computer(int d) {
        depth = d;
        max = 0;
    }

       public int maximizing(PentagoGame current,int depth) {
        int ok = 0;
        int temp;
        ok = Integer.MIN_VALUE;
        current.buildNodeChildren();
        ArrayList<PentagoGame> childTrees = current.getChildTrees();
        for (int i = 0; i < childTrees.size(); i++) {
            temp = step(depth - 1, childTrees.get(i), false);
            if (ok < temp) {
                ok = temp;
            }
        }
        if (ok > max && depth == this.depth - 1) {
            max = ok;
            maxTable = current.getTable();
        }
        return ok;
    }
    
    public int minimizing(PentagoGame current, int depth)
    {
        int ok = 0;
        int temp;
         ok = Integer.MAX_VALUE;
            current.buildNodeChildren();
            ArrayList<PentagoGame> childTrees = current.getChildTrees();
            for (int i = 0; i < childTrees.size(); i++) {
                int thisVal = step(depth - 1, childTrees.get(i), true);
                if (ok > thisVal) {
                    ok = thisVal;
                }
            }
            return ok;
        
    }
    public PentagoTable getTable() {
        return maxTable;
    }

    public int step(int depth, PentagoGame current, boolean maximizing) {
        int ok = 0;
        if (depth == 0) {
            return current.getTable().getCost();
        }
        if (maximizing) {
           ok = maximizing(current,depth);
            return ok;
        } else {
            ok = minimizing(current,depth);
            return ok;
        }
    }


}
