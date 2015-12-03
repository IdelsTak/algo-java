package com.epi;

public class E0512_IntersectRectangle {
    public static class Rectangle {
        int x, y, w, h;
        public Rectangle(int x, int y, int w, int h){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = y;
        }

        @Override
        public String toString() {
            return "Rectangle{" + "x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + '}';
        }
    }
    
    public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2){
        Rectangle rectangle = null;
        if(isIntersectRect(r1, r2)) {
            int x1 = Math.max(r1.x, r2.x),
                    y1 = Math.max(r1.y, r2.y), 
                    x2 = Math.min(r1.x + r1.w, r2.x + r2.w), 
                    y2 = Math.min(r1.y + r1.h, r2.y + r2.h);
            rectangle = new Rectangle(x1, y1, x2-x1, y1-y2);
        }
        return rectangle;
    }
    
    public static boolean isIntersectRect(Rectangle r1, Rectangle r2){
        return  isIntersectLine(r1.x, r1.w, r2.x, r2.w) && 
                isIntersectLine(r1.y, r1.h, r2.y, r2.h);
    }
    
    public static boolean isIntersectLine(int x1, int w1, int x2, int w2){
        return isBetween(x1, x2, w2) || isBetween(x1+w1, x2, w2) || 
               isBetween(x2, x1, w1) || isBetween(x2+w2, x1, w2) ;
    }
    
    public static boolean isBetween(int x1, int x2, int w2){
        return x2<=x1 && x1 <= x2+w2;
    }    
}
