/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraktaltrae;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Fraktaltrae extends JPanel implements MouseListener, MouseMotionListener {

    double a, b, c;
    int d, e, f;

    public Fraktaltrae() {
        tilf();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void tegnGren(Graphics g, int x, int y, int vinkel, int str) {
        if (str < 1) {
            return; // vi vil ikke tegne forsvindende små grene
        }
        int dx = (int) (str * Math.cos(2 * Math.PI * vinkel / 360));
        int dy = (int) (str * Math.sin(2 * Math.PI * vinkel / 360));
        g.drawLine(x, y, x + dx, y + dy);                 // tegn stammen
//    tegnGren(g, x+dx, y+dy,vinkel - 30, (int)(str*a));//0.65)); // tegn gren til venstre
//    tegnGren(g, x+dx, y+dy, vinkel + 10, (int)(str*b));//0.35)); // lille gren lidt til højre
//    tegnGren(g, x+dx, y+dy, vinkel + 55, (int)(str*c));//0.65)); // tegn gren til højre
        tegnGren(g, x + dx, y + dy, vinkel - d, (int) (str * a));
        tegnGren(g, x + dx, y + dy, vinkel + e, (int) (str * b));
        tegnGren(g, x + dx, y + dy, vinkel + f, (int) (str * c));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        tegnGren(g, 100, 40, 40, 300);
        g.setColor(Color.gray);
        g.drawString(String.format("a = %.3f", a), 10, 20);
        g.drawString(String.format("b = %.3f", b), 10, 40);
        g.drawString(String.format("c = %.3f", c), 10, 60);
        g.drawString(String.format("d = %d", d), 10, 80);
        g.drawString(String.format("e = %d", e), 10, 100);
        g.drawString(String.format("f = %d", f), 10, 120);
        if (pos != null) {
            g.drawString(String.format("(%d ; %d)", pos.x, pos.y), pos.x+5, pos.y-5);
        }
    }

    private void tilf() {
        a = Math.random() * 0.4 + 0.2;
        b = Math.random() * 0.4 + 0.2;
        c = Math.random() * 0.4 + 0.2;
        d = (int) (Math.random() * 20) + 20;
        e = (int) (Math.random() * 20) - 10;
        f = (int) (Math.random() * 20) + 20;
    }

    public static void main(String[] arg) {
        JFrame vindue = new JFrame("Fraktaltrae");
        vindue.add(new Fraktaltrae());
        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vindue.setSize(900, 800);
        vindue.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        tilf();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    Point pos = null;

    @Override
    public void mouseMoved(MouseEvent e) {
        pos = e.getPoint();
        repaint();
    }
}
