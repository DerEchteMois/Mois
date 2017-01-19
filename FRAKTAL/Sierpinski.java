import java.applet.*;
import java.awt.*;

public class Sierpinski extends Applet {

    Graphics g;
    Point a1,b1,c1, a2,b2,c2, a3,b3,c3;

    int level = 0;

    public void init() {
        setBackground(new Color(255,255,255));
    }

    public boolean mouseDown(Event ev, int x, int y) {
        if (!ev.metaDown()) level += 1;
        else if (level>0) level -= 1;
        repaint();
        return true;
    }


    public void paint(Graphics g) {

        // Start-Dreieck
        int xCoords[] = {10, 390, 200};
        int yCoords[] = {390, 390, 10};
        g.drawPolygon(xCoords, yCoords, 3);

        drawTriangle(g, new Point(10,390),new Point(390,390),new Point(200,10), level);
    }


    public void drawTriangle(Graphics g, Point a, Point b, Point c, int level) {

        if (level==0) return;

        level -= 1;

        // In das übergebene Dreieck, wird ein auf dem Kopf stehendes Dreieck eingefügt
        int xCoords[] = {c.x, (c.x+b.x)/2, (a.x+c.x)/2};
        int yCoords[] = {b.y, (c.y+a.y)/2, (c.y+a.y)/2};

        g.drawPolygon(xCoords, yCoords, 3);

        // 3 neue Dreiecke bestimmen
        a1 = a;
        b1 = new Point(c.x, b.y);
        c1 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
        drawTriangle(g, a1, b1, c1, level);

        a2 = new Point(c.x, b.y);
        b2 = b;
        c2 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
        drawTriangle(g, a2, b2, c2, level);

        a3 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
        b3 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
        c3 = c;
        drawTriangle(g, a3, b3, c3, level);
    }
}