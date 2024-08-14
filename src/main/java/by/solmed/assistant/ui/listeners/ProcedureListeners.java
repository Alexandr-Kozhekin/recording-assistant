package by.solmed.assistant.ui.listeners;

import by.solmed.assistant.core.db.*;
import by.solmed.assistant.core.domain.Compound;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.service.procedureService.DeleteProcedureByIdService;
import by.solmed.assistant.core.service.procedureService.FindAllProcedureService;
import by.solmed.assistant.core.service.procedureService.FindProcedureByIdService;
import by.solmed.assistant.core.service.procedureService.SaveProcedureService;
import by.solmed.assistant.core.service.procedureService.requests.DeleteProcedureByIdRequest;
import by.solmed.assistant.core.service.procedureService.requests.FindProcedureByIdRequest;
import by.solmed.assistant.core.service.procedureService.requests.SaveProcedureRequest;
import by.solmed.assistant.core.service.procedureService.responses.DeleteProcedureByIdResponse;
import by.solmed.assistant.core.service.procedureService.responses.FindProcedureByIdResponse;
import by.solmed.assistant.core.service.procedureService.responses.SaveProcedureResponse;

import by.solmed.assistant.core.service.validators.CoreError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

public class ProcedureListeners extends JFrame {

    private SaveProcedureService saveProcedureService;
    private FindProcedureByIdService findProcedureByIdService;
    private DeleteProcedureByIdService deleteProcedureByIdService;
    private FindAllProcedureService findAllProcedureService;

    private JTextField
            name = new JTextField(10),
            description = new JTextField(10),
            materialsId = new JTextField(10),
            price = new JTextField(10);

    private JTextField foundProcedure = new JTextField(30);

    private JTextField
            findProcedure = new JTextField(10),
            deleteProcedure = new JTextField(10);

    private JButton
            saveProcedure = new JButton("Добавить");

    private JTextArea result = new JTextArea(20, 15);
    private JTextArea errorsList = new JTextArea(5, 20);

    private DecimalFormat decimalFormat = new DecimalFormat("####.###");

    class SaveProcedureL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            SaveProcedureRequest request = new SaveProcedureRequest(name.getText(), description.getText(),
                    materialsId.getText(), price.getText());

            SaveProcedureResponse response = saveProcedureService.execute(request);

            result.append(response.getProcedure().getId() + "| " + response.getProcedure().getName()
                    + " " + response.getProcedure().getDescription() + "\n");

            List<Compound> compounds = response.getProcedure().getMaterials();

            if(!compounds.isEmpty()) {
                result.append("Материалы: " + "\n");
                for (Compound compound : compounds)
                    result.append(compound.getId() + " " + compound.getName() + " " + decimalFormat.format(compound.getPrice()) + "\n");
            }

            result.append("Стоимость процедуры: " + decimalFormat.format(response.getProcedure().getTotalPrice()) + "$" + "\n\n");
        }
    }

    class FindProcedureL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FindProcedureByIdRequest request = new FindProcedureByIdRequest(findProcedure.getText());
            FindProcedureByIdResponse response = findProcedureByIdService.execute(request);

//            if(response.getErrorList() != null) {
//                errorsList.setText("");
//                for (CoreError error : response.getErrorList()) {
//                    errorsList.append(error.getMessage() + "\n");
//                }
//                return;
//            }
//            errorsList.setText("");

            foundProcedure.setText(response.getProcedure().getId() + " " + response.getProcedure().getName() + " "
                    + response.getProcedure().getDescription() + " " + response.getProcedure().getTotalPrice());
        }
    }

    class DeleteProcedureL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteProcedureByIdRequest request = new DeleteProcedureByIdRequest(deleteProcedure.getText());
            DeleteProcedureByIdResponse response = deleteProcedureByIdService.execute(request);

//            if (response.getErrorList() != null) {
//                errorsList.setText("");
//                for (CoreError error : response.getErrorList()) {
//                    errorsList.append(error.getMessage() + "\n");
//                }
//                return;
//            }
//            result.setText("");

            printAll(findAllProcedureService.execute().getProcedures(), result);
        }
    }

    public ProcedureListeners(ProcedureDatabase procedureDatabase, CompoundDatabase compoundDatabase) {

        saveProcedureService = new SaveProcedureService(procedureDatabase, compoundDatabase);
        findProcedureByIdService = new FindProcedureByIdService(procedureDatabase);
        deleteProcedureByIdService = new DeleteProcedureByIdService(procedureDatabase);
        findAllProcedureService = new FindAllProcedureService(procedureDatabase);

        SaveProcedureL saveProcedureL = new SaveProcedureL();
        FindProcedureL findProcedureL = new FindProcedureL();
        DeleteProcedureL deleteProcedureL = new DeleteProcedureL();

        saveProcedure.addActionListener(saveProcedureL);
        findProcedure.addActionListener(findProcedureL);
        deleteProcedure.addActionListener(deleteProcedureL);

        setLayout(new FlowLayout());

        add(new Label("Название процедуры"));
        add(name);
        add(new Label("Описание процедуры"));
        add(description);
        add(new Label("Id материалов"));
        add(materialsId);
        add(new Label("Стоимость процедуры"));
        add(price);

        add(saveProcedure);
        add(new JLabel("Удалить"));
        add(deleteProcedure);
        add(new JLabel("Найти"));
        add(findProcedure);

        add(foundProcedure);

        add(errorsList);

        add(result);
    }

    private static void printErrors(List<CoreError> errors, JTextArea result) {
        if(errors != null) {
            result.setText("");
            for (CoreError error : errors) {
                result.append(error.getMessage() + "\n");
            }
        }
    }

    private static void printAll(List<Procedure> procedures, JTextArea result) {
        DecimalFormat decimalFormat = new DecimalFormat("####.###");
        result.append("");
        if(!procedures.isEmpty()) {
            for(Procedure procedure : procedures){
                result.append(procedure.getId() + " " + procedure.getName() + " " + procedure.getDescription() + "\n");
                if(procedure.getMaterials() != null && !procedure.getMaterials().isEmpty()) {
                    result.append("Материалы: " + "\n");
                    for(Compound compound : procedure.getMaterials()) {
                        result.append(compound.getId() + " " + compound.getName() + " " + decimalFormat.format(compound.getPrice()) + "$" + "\n\n");
                    }
                }
                result.append("Стоимость процедуры: " + decimalFormat.format(procedure.getTotalPrice()) + "$" + "\n\n");
            }
        }
    }

}
