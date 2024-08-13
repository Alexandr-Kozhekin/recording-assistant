package by.solmed.assistant.ui.listeners;

import by.solmed.assistant.core.db.*;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.service.ticketService.SaveTicketService;
import by.solmed.assistant.core.service.ticketService.requests.SaveTicketRequest;
import by.solmed.assistant.core.service.ticketService.responses.SaveTicketResponse;
import by.solmed.assistant.core.service.validators.CoreError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

public class TicketListeners extends JFrame {

    private SaveTicketService saveTicketService;

    private JTextField
            nameClient = new JTextField(10),
            idProcedure = new JTextField(10),
            nameStaff = new JTextField(10),
            dateAppointment = new JTextField(10);

    private JButton saveTicket = new JButton("Добавить");

    private JTextArea errorsList = new JTextArea(5, 20);
    private JTextArea appointmentsList = new JTextArea(30, 15);

    class SaveTicketL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            List<String> is = List.of(idProcedure.getText().split(" "));
            List<Long> ids = new ArrayList<>();

            DecimalFormat decimalFormat = new DecimalFormat("####.###");

            for(String s : is)
                ids.add(Long.parseLong(s));

            SaveTicketRequest request = new SaveTicketRequest(nameClient.getText(), ids,
                    nameStaff.getText(), dateAppointment.getText());

            SaveTicketResponse response = saveTicketService.execute(request);

            appointmentsList.append("Запись №" + response.getTicket().getId() + " от " + response.getTicket().getDateAt() + "\n");

            appointmentsList.append("Пациент: " + response.getTicket().getClient().getFirstName() + " " + response.getTicket().getClient().getLastName() + "\n");

            appointmentsList.append("Назначенные процедуры: \n");
            for(Procedure p : response.getTicket().getProcedures())
                appointmentsList.append(p.getId() + " " + p.getName() + " " + p.getDescription() + " " + decimalFormat.format(p.getTotalPrice()) + "$"  + "\n");

            appointmentsList.append("Стоимость процедур: " + decimalFormat.format(response.getTicket().getTotalPrice()) + "$" + "\n");

            appointmentsList.append("Лечащий врач: " + response.getTicket().getStaff().getFirstName() + " " + response.getTicket().getStaff().getLastName()
                    + " " + response.getTicket().getStaff().getMajor() + "\n");

            appointmentsList.append("Дата приема: " + response.getTicket().getDateAppointment() + "\n\n");
        }
    }

    public TicketListeners(TicketDatabase ticketDatabase, ClientDatabase clientDatabase,
                           ProcedureDatabase procedureDatabase, StaffDatabase staffDatabase) {

        saveTicketService = new SaveTicketService(clientDatabase, procedureDatabase, staffDatabase, ticketDatabase);

        SaveTicketL saveTicketL = new SaveTicketL();

        saveTicket.addActionListener(saveTicketL);

        setLayout(new FlowLayout());

        add(new Label("Имя врача"));
        add(nameStaff);
        add(new Label("Id процедуры"));
        add(idProcedure);
        add(new Label("Имя пациента"));
        add(nameClient);
        add(new Label("Дата приема"));
        add(dateAppointment);

        add(saveTicket);

        add(errorsList);

        add(appointmentsList);
    }

    private static void printErrors(List<CoreError> errors, JTextArea result) {
        if(errors != null) {
            result.setText("");
            for (CoreError error : errors) {
                result.append(error.getMessage() + "\n");
            }
        }
    }

}
