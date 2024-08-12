package by.solmed.assistant.core.service.ticketService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.db.TicketDatabase;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.domain.Staff;
import by.solmed.assistant.core.domain.Ticket;

import java.util.*;

import by.solmed.assistant.core.service.ticketService.requests.SaveTicketRequest;
import by.solmed.assistant.core.service.ticketService.responses.SaveTicketResponse;
import org.springframework.stereotype.Service;

@Service
public class SaveTicketService {

    private ClientDatabase clientDatabase;
    private ProcedureDatabase procedureDatabase;
    private StaffDatabase staffDatabase;
    private TicketDatabase ticketDatabase;

    public SaveTicketService(ClientDatabase clientDatabase, ProcedureDatabase procedureDatabase,
                             StaffDatabase staffDatabase, TicketDatabase ticketDatabase) {
        this.clientDatabase = clientDatabase;
        this.procedureDatabase = procedureDatabase;
        this.staffDatabase = staffDatabase;
        this.ticketDatabase = ticketDatabase;
    }

    public SaveTicketResponse execute(SaveTicketRequest request) {

        String[] time = request.getDateAppointment().split("/");

        Optional<Client> client = clientDatabase.findClientByFirstName(request.getClientFirstName());
        List<Procedure> procedures = new ArrayList<>();
        Optional<Staff> staff = staffDatabase.findStaffByFirstName(request.getStaffFirstName());
        Calendar calendar = new GregorianCalendar(Integer.parseInt(time[0]),Integer.parseInt(time[1]),
                Integer.parseInt(time[2]), Integer.parseInt(time[3]), Integer.parseInt(time[4]));

        for(Long id : request.getIdList()) {
            Optional<Procedure> procedure = procedureDatabase.findProcedureById(id);
            procedure.ifPresent(procedures::add);
        }

        if(client.isPresent() && staff.isPresent()) {
            Ticket ticket = new Ticket(client.get(), procedures, staff.get(), calendar.getTime());
            ticketDatabase.saveTicket(ticket);
            return new SaveTicketResponse(ticket);
        } else {
            return null;
        }
    }

}
