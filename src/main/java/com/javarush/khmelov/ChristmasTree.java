package com.javarush.khmelov;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.*;


public class ChristmasTree {
    static class Point {
        Point(int a, int b) {
            x = a;
            y = b;
        }

        int x, y;

        double distance(Point o) {
            int dx = x - o.x;
            int dy = y - o.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    static int siz;
    static BufferedImage b;
    static Random r = new Random();

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.print("Size: ");
            siz = (new Scanner(System.in)).nextInt();
        } else {
            siz = Integer.parseInt(args[0]);
        }
        b = new BufferedImage(20 * siz, 30 * siz, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) b.getGraphics();
        g.setColor(new Color(140, 70, 20));
        int h = b.getHeight();
        h *= 0.4;
        for (int i = (int) (0.4 * b.getWidth()); i < (int) (0.6 * b.getWidth()); i++) {
            if (r.nextDouble() < 0.3) {
                g.drawLine(i, b.getHeight(), i + r.nextInt(2) - 1, h);
            }
        }
        for (int i = h; i < b.getHeight(); i++) {
            if (r.nextDouble() < 0.3) {
                g.drawLine((int) (0.4 * b.getWidth()), i, (int) (0.6 * b.getWidth()), i);
            }
        }
        for (int i = 0; i < siz; i++) {
            g.setColor(new Color(r.nextInt(4), 150 + r.nextInt(15), 20 + r.nextInt(7)));
            g.drawLine(b.getWidth() / 2 - (int) (b.getWidth() * 0.42 * i / siz), (int) (b.getHeight() * 0.9) + r.nextInt(5) - 2, b.getWidth() / 2 + (int) (b.getWidth() * 0.42 * i / siz), (int) (b.getHeight() * 0.9) + r.nextInt(5) - 2);
            g.setColor(new Color(r.nextInt(4), 150 + r.nextInt(15), 20 + r.nextInt(7)));
            g.drawLine(b.getWidth() / 2 - (int) (b.getWidth() * 0.42 * i / siz), (int) (b.getHeight() * 0.9), b.getWidth() / 2, (int) (b.getHeight() * (0.1 + (.06 * i) / siz)));
            g.setColor(new Color(r.nextInt(4), 150 + r.nextInt(15), 20 + r.nextInt(7)));
            g.drawLine(b.getWidth() / 2 + (int) (b.getWidth() * 0.42 * i / siz), (int) (b.getHeight() * 0.9), b.getWidth() / 2, (int) (b.getHeight() * (0.1 + (.06 * i) / siz)));
        }
        g.setColor(new Color(150, 120, 40));
        g.fillOval((b.getWidth() - siz - 2) / 2, b.getHeight() / 10, siz + 2, siz + 2);
        g.setColor(new Color(250, 240, 80));
        g.fillOval((b.getWidth() - siz) / 2, b.getHeight() / 10, siz, siz);
        List<Color> c = Arrays.asList(new Color(0, 255, 0), new Color(255, 0, 0), new Color(130, 0, 100), new Color(0, 0, 200), new Color(110, 0, 200), new Color(200, 205, 210), new Color(0, 240, 255), new Color(255, 100, 0));
        List<Point> pts = new ArrayList<>();
        pts.add(new Point((b.getWidth() - siz) / 2, b.getHeight() / 10));
        loop:
        for (int i = 0; i < 8 + siz / 4; i++) {
            int y = r.nextInt((8 * b.getHeight()) / 11);
            int x = 1 + (int) (b.getWidth() * 0.35 * y / ((8 * b.getHeight()) / 11));
            x = r.nextInt(2 * x) - x + b.getWidth() / 2;
            y += b.getHeight() / 8;
            g.setColor(c.get(r.nextInt(c.size())));
            x -= siz / 2;
            Point p = new Point(x, y);
            for (Point q : pts) {
                if (q.distance(p) < 1 + 2 * siz) continue loop;
            }
            pts.add(p);
            g.fillOval(x, y, siz, siz);
        }
        String destination = "src" + File.separator + "main" + File.separator + "java" + File.separator +
                             ChristmasTree.class.getPackageName().replace(".", File.separator) +
                             File.separator;
        ImageIO.write(b, "png", new File(destination + "tree.png"));
    }
}