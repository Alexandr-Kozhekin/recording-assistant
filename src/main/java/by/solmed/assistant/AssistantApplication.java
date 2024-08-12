package by.solmed.assistant;

import by.solmed.assistant.core.db.*;
import by.solmed.assistant.ui.listeners.ClientListeners;
import by.solmed.assistant.ui.listeners.StaffListeners;
import by.solmed.assistant.ui.listeners.TicketListeners;
import by.solmed.assistant.ui.window.ClientWindow;
import by.solmed.assistant.ui.window.StaffWindow;
import by.solmed.assistant.ui.window.TicketWindow;

public class AssistantApplication {

	private static final TicketDatabase ticketDatabase = new TicketDatabaseImpl();
	private static final ClientDatabase clientDatabase = new ClientDatabaseImpl();
	private static final ProcedureDatabase procedureDatabase = new ProcedureDatabaseImpl();
	private static final StaffDatabase staffDatabase = new StaffDatabaseImpl();

	public static void main(String[] args) throws Exception {

		ClientWindow.run(new ClientListeners(clientDatabase), 1024, 500);
		StaffWindow.run(new StaffListeners(staffDatabase), 1024, 500);
		TicketWindow.run(new TicketListeners(ticketDatabase, clientDatabase, procedureDatabase, staffDatabase), 800, 600);

	}
}
