package by.solmed.assistant.ui.listeners;

import by.solmed.assistant.core.db.CompoundDatabase;
import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.domain.Compound;
import by.solmed.assistant.core.service.compoundService.DeleteCompoundByIdService;
import by.solmed.assistant.core.service.compoundService.FindAllCompoundService;
import by.solmed.assistant.core.service.compoundService.FindCompoundByIdService;
import by.solmed.assistant.core.service.compoundService.SaveCompoundService;
import by.solmed.assistant.core.service.compoundService.requests.DeleteCompoundByIdRequest;
import by.solmed.assistant.core.service.compoundService.requests.FindCompoundByIdRequest;
import by.solmed.assistant.core.service.compoundService.requests.SaveCompoundRequest;
import by.solmed.assistant.core.service.compoundService.responses.DeleteCompoundByIdResponse;
import by.solmed.assistant.core.service.compoundService.responses.FindCompoundByIdResponse;
import by.solmed.assistant.core.service.compoundService.responses.SaveCompoundResponse;
import by.solmed.assistant.core.service.validators.CoreError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

public class CompoundListeners extends JFrame {

    private SaveCompoundService saveCompoundService;
    private FindCompoundByIdService findCompoundByIdService;
    private DeleteCompoundByIdService deleteCompoundByIdService;
    private FindAllCompoundService findAllCompoundService;

    private JTextField
            name = new JTextField(10),
            price = new JTextField(10);

    private JTextField foundCompound = new JTextField(30);

    private JTextField
            findCompound = new JTextField(10),
            deleteCompound = new JTextField(10);

    private JButton saveCompound = new JButton("Добавить");

    private JTextArea result = new JTextArea(20, 15);
    private JTextArea errorsList = new JTextArea(5, 20);

    private DecimalFormat decimalFormat = new DecimalFormat("####.###");

    class SaveCompoundL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            SaveCompoundRequest request = new SaveCompoundRequest(name.getText(), price.getText());

            SaveCompoundResponse response = saveCompoundService.execute(request);

            result.append(response.getCompound().getId() + "| " + response.getCompound().getName() + " "
                    + decimalFormat.format(response.getCompound().getPrice()) + "$" + "\n");
        }
    }

    class FindCompoundL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FindCompoundByIdRequest request = new FindCompoundByIdRequest(findCompound.getText());
            FindCompoundByIdResponse response = findCompoundByIdService.execute(request);

//            if(response.getErrorList() != null) {
//                errorsList.setText("");
//                for (CoreError error : response.getErrorList()) {
//                    errorsList.append(error.getMessage() + "\n");
//                }
//                return;
//            }
//            errorsList.setText("");

            foundCompound.setText(response.getCompound().getId() + " " + response.getCompound().getName() + " "
                    + decimalFormat.format(response.getCompound().getPrice()));
        }
    }

    class DeleteCompoundL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCompoundByIdRequest request = new DeleteCompoundByIdRequest(deleteCompound.getText());
            DeleteCompoundByIdResponse response = deleteCompoundByIdService.execute(request);

//            if (response.getErrorList() != null) {
//                errorsList.setText("");
//                for (CoreError error : response.getErrorList()) {
//                    errorsList.append(error.getMessage() + "\n");
//                }
//                return;
//            }
//            result.setText("");

            printAll(findAllCompoundService.execute().getCompounds(), result);
        }
    }

    public CompoundListeners(CompoundDatabase compoundDatabase) {

        saveCompoundService = new SaveCompoundService(compoundDatabase);
        findCompoundByIdService = new FindCompoundByIdService(compoundDatabase);
        deleteCompoundByIdService = new DeleteCompoundByIdService(compoundDatabase);
        findAllCompoundService = new FindAllCompoundService(compoundDatabase);

        SaveCompoundL saveCompoundL = new SaveCompoundL();
        FindCompoundL findCompoundL = new FindCompoundL();
        DeleteCompoundL deleteCompoundL = new DeleteCompoundL();

        saveCompound.addActionListener(saveCompoundL);
        findCompound.addActionListener(findCompoundL);
        deleteCompound.addActionListener(deleteCompoundL);

        setLayout(new FlowLayout());

        add(new Label("Название материала"));
        add(name);
        add(new Label("Стоимость материала"));
        add(price);

        add(saveCompound);
        add(new JLabel("Удалить"));
        add(deleteCompound);
        add(new JLabel("Найти"));
        add(findCompound);

        add(foundCompound);

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

    private static void printAll(List<Compound> procedures, JTextArea result) {
        DecimalFormat decimalFormat = new DecimalFormat("####.###");
        result.append("");
        if(!procedures.isEmpty())
            for(Compound compound : procedures)
                result.append(compound.getId() + " " + compound.getName() + " " + decimalFormat.format(compound.getPrice()) + "$" + "\n");
    }

}
