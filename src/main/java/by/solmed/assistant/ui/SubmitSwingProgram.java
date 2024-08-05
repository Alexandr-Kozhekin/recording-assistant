package by.solmed.assistant.ui;

import by.solmed.assistant.ui.window.SwingConsole;

public class SubmitSwingProgram {

    static SubmitSwingProgram ssp;

    public static void main(String[] args) throws Exception {

//        JFrame frame = new JFrame("Hello Swing!");
//        JLabel label = new JLabel("A Label");

        SwingConsole.run(new TextArea(), 475, 425);


    }

}
