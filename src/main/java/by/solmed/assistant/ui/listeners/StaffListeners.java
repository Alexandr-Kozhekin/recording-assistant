package by.solmed.assistant.ui.listeners;

import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.domain.Staff;
import by.solmed.assistant.core.service.staffService.DeleteStaffByNameService;
import by.solmed.assistant.core.service.staffService.FindStaffByFirstNameService;
import by.solmed.assistant.core.service.staffService.SaveStaffService;
import by.solmed.assistant.core.service.staffService.requests.DeleteStaffByNameRequest;
import by.solmed.assistant.core.service.staffService.requests.FindStaffByFirstNameRequest;
import by.solmed.assistant.core.service.staffService.requests.SaveStaffRequest;
import by.solmed.assistant.core.service.staffService.responses.DeleteStaffByNameResponse;
import by.solmed.assistant.core.service.staffService.responses.FindStaffByFirstNameResponse;
import by.solmed.assistant.core.service.staffService.responses.SaveStaffResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StaffListeners extends JFrame {

    private SaveStaffService saveStaffService;
    private FindStaffByFirstNameService findStaffByFirstNameService;
    private DeleteStaffByNameService deleteStaffByNameService;

    private List<Staff> list = new ArrayList<>();

    private JTextField
            firstName = new JTextField(10),
            lastName = new JTextField(10),
            gender = new JTextField(10),
            age = new JTextField(10),
            major = new JTextField(10),
            subdivision = new JTextField(10),
            experience = new JTextField(10),
            category = new JTextField(10),
            type = new JTextField(10);

    private JTextField
            findStaff = new JTextField(10),
            deleteStaff = new JTextField(10);

    private JTextField resultStaff = new JTextField(80);

    private JButton saveStaff = new JButton("Добавить");
    private JTextArea errorsList = new JTextArea(5, 20);
    private JTextArea result = new JTextArea(20, 15);

    class SaveStaffL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            SaveStaffRequest request = new SaveStaffRequest(firstName.getText(), lastName.getText(), gender.getText(),
                    Integer.parseInt(age.getText()), major.getText(), subdivision.getText(),
                    experience.getText(), category.getText(), type.getText());
            SaveStaffResponse response = saveStaffService.execute(request);

//            if(response.getErrorList() != null) {
//                errorsList.setText("");
//                for (CoreError error : response.getErrorList()) {
//                    errorsList.append(error.getMessage() + "\n");
//                }
//                return;
//            }
//            errorsList.setText("");

            list.add(response.getStaff());

            result.append(response.getStaff().getId() + "| " + response.getStaff().getFirstName()
                    + " " + response.getStaff().getLastName() + " " + response.getStaff().getGender()
                    + " " + response.getStaff().getAge() + "\n");
        }

    }

    class FindStaffL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FindStaffByFirstNameRequest request = new FindStaffByFirstNameRequest(findStaff.getText());
            FindStaffByFirstNameResponse response = findStaffByFirstNameService.execute(request);

//            if(response.getErrorList() != null) {
//                errorsList.setText("");
//                for (CoreError error : response.getErrorList()) {
//                    errorsList.append(error.getMessage() + "\n");
//                }
//                return;
//            }
//            errorsList.setText("");

            resultStaff.setText(response.getStaff().getId() + " " + response.getStaff().getFirstName()
                    + " " + response.getStaff().getLastName() + " " + response.getStaff().getGender()
                    + " " + response.getStaff().getAge() + " " + response.getStaff().getMajor()
                    + " " + response.getStaff().getSubdivision() + " " + response.getStaff().getExperience()
                    + " " + response.getStaff().getCategory() + " " + response.getStaff().getType() + " ");
        }
    }

    class DeleteStaffL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteStaffByNameRequest request = new DeleteStaffByNameRequest(deleteStaff.getText());
            DeleteStaffByNameResponse response = deleteStaffByNameService.execute(request);

//            if (response.getErrorList() != null) {
//                errorsList.setText("");
//                for (CoreError error : response.getErrorList()) {
//                    errorsList.append(error.getMessage() + "\n");
//                }
//                return;
//            }
            result.setText("");

            list.removeIf(c -> c.getFirstName().equals(request.getFirstName()));

            for(Staff staff : list)
                result.append(staff.getId() + "| " + staff.getFirstName() + " " + staff.getLastName()
                        + " " + staff.getGender() + " " + staff.getAge() + "\n");

        }
    }

    public StaffListeners(StaffDatabase database) {

        saveStaffService = new SaveStaffService(database);
        findStaffByFirstNameService = new FindStaffByFirstNameService(database);
        deleteStaffByNameService = new DeleteStaffByNameService(database);

        SaveStaffL saveStaffL = new SaveStaffL();
        FindStaffL findStaffL = new FindStaffL();
        DeleteStaffL deleteStaffL = new DeleteStaffL();

        saveStaff.addActionListener(saveStaffL);
        deleteStaff.addActionListener(deleteStaffL);
        findStaff.addActionListener(findStaffL);

        list = database.findAllStaff();
        if(!list.isEmpty())
            for(Staff staff : list)
                result.append(staff.getId() + "| " + staff.getFirstName() + " " + staff.getLastName()
                        + " " + staff.getGender() + " " + staff.getAge() + "\n");

        setLayout(new FlowLayout());
        add(new Label("Имя"));
        add(firstName);
        add(new Label("Фамилия"));
        add(lastName);
        add(new Label("Пол"));
        add(gender);
        add(new Label("Возраст"));
        add(age);
        add(new Label("Специальность"));
        add(major);
        add(new Label("Подразделение"));
        add(subdivision);
        add(new Label("Опыт работы"));
        add(experience);
        add(new Label("Категория"));
        add(category);
        add(new Label("Тип"));
        add(type);

        add(errorsList);

        add(BorderLayout.CENTER, saveStaff);
        add(new Label("Найти"));
        add(BorderLayout.CENTER, findStaff);
        add(new Label("Удалить"));
        add(BorderLayout.CENTER, deleteStaff);

        add(BorderLayout.CENTER, resultStaff);

        add(BorderLayout.SOUTH, result);

    }

}
