/*
 */

package t09_Recursion_DynamicProgramming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * find all possible path
 */
public class E2_GridWalking {
    //suppose (x2, y2) > (x1, y1)
    //let's suppose q is at upper-right corner of p
    private static final Points points = new Points();

    public static class Points{
        public final LinkedList<Point> list = new LinkedList<>();
        public void addOffLimit(Point t){
            list.add(t);
        }

        private boolean between(int x, int min, int max){
            if(min <= x && x <= max) return true;
            return min >= x && x >= max;
        }

        private boolean between(Point x, Point p1, Point p2){
            if(p1.x == x.x && x.x == p2.x) return between(x.y, p1.y, p2.y);
            else if(p1.y == x.y && x.y == p2.y) return between(x.x, p1.x, p2.x);
            return false;
        }

        public boolean isOffLimit(Point p, Point q){
            for(Point t: list){
                if(between(t, p, q)) return true;
            }
            return  false;
        }
    }

    static int run_my(Point p, Point q){
        int step1 = run_my(p, q, true, "");
        int step2 = run_my(p, q, false, "");
        return step1 + step2;
    }

    static boolean isNoRoad_my(Point p, Point q, boolean dirX){
        if(dirX && p.x == q.x) return false;
        else if(!dirX && p.y == q.y) return false;
        return true;
    }


    //next step must walk in dirX if true, dir Y if false
    static int run_my(Point p, Point q, boolean dirX, String path){
        //recusive termination condition
        int paths = -1;
        if(p.equals(q)) paths = 0;
        if(dirX){//walk to X dir
            if(p.x == q.x) paths = 0;
            else if(p.y == q.y) paths = 1;
        }else{//walk to Y dir
            if(p.y == q.y) return 0;
            else if(p.x == q.x) paths = 1;
        }//if dirX

        path += String.format(" -> %s.%s", p.x, p.y);
        if(paths >= 0){
            if(paths == 1) path += String.format(" -> %s.%s", q.x, q.y);
            System.out.println(path);
            return paths;
        }

        //resursive operation
        paths = 0;
        if(dirX){
            int distX = q.x - p.x;
            for(int i  = 1; i <= distX; i++){
                Point nextStep = new Point(p.x + i, p.y);
                if(!points.isOffLimit(p, nextStep))
                    paths += run_my( nextStep, q, !dirX, path);
            }
        }else{//go to y way
            int distY = q.y - p.y;
            for(int i  = 1; i <= distY; i++){
                Point nextStep = new Point(p.x, p.y + i);
                if(!points.isOffLimit(p, nextStep))
                    paths += run_my( new Point(p.x, p.y + i), q, !dirX, path);
            }
        }
        return paths;
    }//run

    //Code from the book P9.2
    public boolean getPath_bk(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache){
        Point p = new Point(x, y);
        
        if(cache.containsKey(p)){
            return cache.get(p);
        }

        if(x == 0 && y == 0){
            path.add(p);
            return true;
        } 

        boolean isSuccess = false;
        if(x >= 1 && isFree_bk(x - 1, y))
            isSuccess = getPath_bk(x-1, y, path, cache);
        if(!isSuccess & isFree_bk(x, y-1))
            isSuccess = getPath_bk(x, y-1, path, cache);

        if(isSuccess) path.add(p);
        cache.put(p, isSuccess);
        return isSuccess;
    }

    private boolean isFree_bk(int x, int y) {
        if(x == 0 && y == 2) return false;
        if(x == 1 && y == 1) return false;
        return true;
    }

    @Test
    public void test(){
        //LinkedList<String> list = new LinkedList<>();
        Point[] p = {new Point(0, 0), new Point(1, 1), new Point(2, 2)};
        int[] expected = {0, 2, 6};
        for (int i = 0; i < p.length; i++) {
            int paths = run_my(p[0], p[i]);
            String message = p[0].toString() + "->" + p[i].toString() + " = " + Integer.toString(expected[i]) + "  " + paths;
            System.out.println(message);
            assertTrue(message, paths == expected[i]);
        }

        points.addOffLimit(p[1]);
        for (int i = 2; i < p.length; i++) {
            int paths = run_my(p[0], p[i]);
            int expected2 = 2;
            String message = p[0].toString() + "->" + p[i].toString() + " = " + Integer.toString(expected2) + "  " + paths;
            System.out.println(message);
            assertTrue(message, paths == expected2);
        }

        //Book's code, much easier
        ArrayList<Point> path = new ArrayList<>();
        HashMap<Point, Boolean> cache = new HashMap<>();
        getPath_bk(2, 2, path, cache);
		for (Point t : path) {
			System.out.printf("-> %d.%d", t.x, t.y);
		}
    }

}
