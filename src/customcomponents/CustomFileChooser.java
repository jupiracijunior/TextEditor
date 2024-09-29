package customcomponents;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

public class CustomFileChooser extends JFileChooser {

    private JFrame frame = new JFrame("Custom JFileChooser");
    public JTextField fileNameInput = new JTextField();
    private JPanel customPanel = new JPanel();

    public JPanel getCustomPanel() {
        return customPanel;
    }

    public CustomFileChooser() {
        super();
        removeFileFolderField();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(getCustomPanel());
    }

    private void removeFileFolderField() {
        Component[] components = getComponents(this);
        for (Component component : components) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                Component[] panelComponents = panel.getComponents();
                for (Component panelComponent : panelComponents) {
                    if (panelComponent instanceof JTextField) {
                        panel.remove(panelComponent);

                        fileNameInput.setPreferredSize(new Dimension(200, 20));

                        panel.add(new JLabel("File Name: "));
                        panel.add(fileNameInput);

                        setCustomPanel(panel);
                    }
                }
            }
        }
    }

    public void setCustomPanel(JPanel customPanel) {
        this.customPanel = customPanel;
    }

    private Component[] getComponents(Component component) {
        if (component instanceof Container) {
            return ((Container) component).getComponents();
        }
        return new Component[]{component};
    }

    public int showOpenDialog() throws HeadlessException {
        setDialogType(OPEN_DIALOG);
        return showDialog(frame, null);
    }
    
    public int showSaveDialog() throws HeadlessException {
        setDialogType(SAVE_DIALOG);
        return showDialog(frame, null);
    }

    public static void main(String[] args) {

    }
}