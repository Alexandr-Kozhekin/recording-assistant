package by.solmed.assistant;

import by.solmed.assistant.ui.button.SaveClientButton;
import by.solmed.assistant.ui.window.SaveClientWindow;

public class AssistantApplication {

	public static void main(String[] args) throws Exception {

		SaveClientWindow.run(new SaveClientButton(), 800, 600);

	}

}
