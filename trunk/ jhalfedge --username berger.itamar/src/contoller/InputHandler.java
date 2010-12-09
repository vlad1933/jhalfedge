package contoller;

import utils.GLDisplay;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Keyboard input handler with keystoke help registration
 * User: itamar
 * Date: Oct 30, 2010
 * Time: 10:14:56 AM
 */
public class InputHandler extends KeyAdapter {
    private Controller controller;

    public InputHandler(Controller Controller, GLDisplay glDisplay) {
        this.controller = Controller;
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Decrease X-axis rotation");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Increase X-axis rotation");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Decrease Y-axis rotation");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Increase Y-axis rotation");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, 0), "zoom-in");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, 0), "zoom-out");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_G, 0), "toggle Grid");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0), "Toggle lighting");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "Toggle shade model");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), "Toggle transparent");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "Show point cloud");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "No Attributes");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "Attribute: Centricity");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "Attribute: Distance to centroid");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), "Attribute: Gaussian Curvature");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "Load file");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), "Next mesh");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), "Prev mesh");
        glDisplay.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "Switch colormap");
    }

    public void keyPressed(KeyEvent e) {
        processKeyEvent(e, true);
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_G:
                controller.toggleGrid();
                break;
            case KeyEvent.VK_L:
                controller.toggleLighting();
                break;
            case KeyEvent.VK_S:
                controller.toggleShadeModel();
                break;
            case KeyEvent.VK_T:
                controller.toggleTransparent();
                break;
            case KeyEvent.VK_P:
                controller.toggleCloud();
                break;
            case KeyEvent.VK_1:
                controller.setNoAttribute();
                break;
            case KeyEvent.VK_2:
                controller.setCentricityAttribute();
                break;
            case KeyEvent.VK_3:
                controller.setDistanceToCentroidAttribute();
                break;
            case KeyEvent.VK_4:
                controller.setGaussianCurvature();
                break;
            case KeyEvent.VK_INSERT:
                controller.loadNewFile();
                break;
            case KeyEvent.VK_M:
                controller.nextFile();
                break;
            case KeyEvent.VK_N:
                controller.prevFile();
                break;
            case KeyEvent.VK_C:
                controller.switchColorMap();
                break;
            case KeyEvent.VK_9:
                controller.toggleFaceNeighbourTest();
                break;
            case KeyEvent.VK_0:
                controller.toggleVertexNeighbourTest();
                break;
            default:
                processKeyEvent(e, false);
        }
    }


    private void processKeyEvent(KeyEvent e, boolean pressed) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                controller.decreaseXrot(pressed);
                break;
            case KeyEvent.VK_DOWN:
                controller.increaseXrot(pressed);
                break;
            case KeyEvent.VK_LEFT:
                controller.decreaseYrot(pressed);
                break;
            case KeyEvent.VK_RIGHT:
                controller.increaseYrot(pressed);
                break;
            case KeyEvent.VK_PAGE_UP:
                controller.zoomIn(pressed);
                break;
            case KeyEvent.VK_PAGE_DOWN:
                controller.zoomOut(pressed);
                break;
        }
    }
}
