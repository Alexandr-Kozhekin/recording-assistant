package by.solmed.assistant.core.service.validators;

import by.solmed.assistant.core.service.clientService.requests.SaveClientRequest;

import java.util.*;

public class SaveClientValidator {

    public List<CoreError> validate(SaveClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validFirstName(request).ifPresent(errors::add);
        validLastName(request).ifPresent(errors::add);
        validGender(request).ifPresent(errors::add);
        validAge(request).ifPresent(errors::add);
        validPhoneNumber(request).ifPresent(errors::add);
        validEmail(request).ifPresent(errors::add);
        validState(request).ifPresent(errors::add);
        validCity(request).ifPresent(errors::add);
        validStreet(request).ifPresent(errors::add);
        validZip(request).ifPresent(errors::add);

        return errors;
    }

//    ^[\\w-\\.] +@[\\w-]+(\\. [\\w-]+)*\\. [a-z]{2,}$ - для мыла
//    -?\d+(\.\d+)? - для чисел

    private Optional<CoreError> validFirstName(SaveClientRequest request) {
        if(request.getFirstName() == null || request.getFirstName().isEmpty()) {
            return Optional.of(new CoreError("Имя", "Имя не должно быть пустым!"));
        } else if(request.getFirstName().matches("[0-9]")) {
            return Optional.of(new CoreError("Имя", "Имя не должно содержать цифры!"));
        } else if(request.getFirstName().matches("[а-яa-z]^?")) {
            return Optional.of(new CoreError("Имя", "Имя должно начинаться с заглавной!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validLastName(SaveClientRequest request) {
        if(request.getLastName() == null || request.getLastName().isEmpty()) {
            return Optional.of(new CoreError("Фамилия", "Фамилия не должна быть пустой!"));
        } else if(request.getLastName().matches("[0-9]")) {
            return Optional.of(new CoreError("Фамилия", "Фамилия не должна содержать цифры!"));
        } else if(request.getLastName().matches("^?[а-яa-z]")) {
            return Optional.of(new CoreError("Фамилия", "Фамилия должна начинаться с заглавной!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validGender(SaveClientRequest request) {
        if(request.getGender() == null || request.getGender().isEmpty()) {
            return Optional.of(new CoreError("Пол", "Пол не должно быть пустым!"));
        }  else if(request.getGender().matches("[*0-9]")) {
            return Optional.of(new CoreError("Пол", "Пол не должна содержать цифры!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validAge(SaveClientRequest request) {
        if(request.getAge() == 0 || request.getAge() < 0) {
            return Optional.of(new CoreError("Возраст", "Возраст не должно быть пустым!"));
        } else if(String.valueOf(request.getAge()).matches("[*a-zA-Z],[*а-яА-Я]")) {
            return Optional.of(new CoreError("Возраст", "Введите целое число!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validPhoneNumber(SaveClientRequest request) {
        if(request.getPhoneNumber() == null || request.getPhoneNumber().isEmpty()) {
            return Optional.of(new CoreError("Номер телефона", "Номер телефона не должно быть пустым!"));
        } else if(String.valueOf(request.getPhoneNumber()).matches("[*a-zA-Z],[*а-яА-Я]")) {
            return Optional.of(new CoreError("Номер телефона", "Номер телефона должен состоять из цифр!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validState(SaveClientRequest request) {
        if(request.getState() == null || request.getState().isEmpty()) {
            return Optional.of(new CoreError("Страна", "Страна не должно быть пустым!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validEmail(SaveClientRequest request) {
        if(request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("Электронная почта", "Электронная почта не должно быть пустой!"));
        } else if(request.getEmail().matches("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")) {
            return Optional.of(new CoreError("Электронная почта", "Электронная почта имеет неверный формат!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validCity(SaveClientRequest request) {
        if(request.getCity() == null || request.getCity().isEmpty()) {
            return Optional.of(new CoreError("Город", "Город не должно быть пустым!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validStreet(SaveClientRequest request) {
        if(request.getStreet() == null || request.getStreet().isEmpty()) {
            return Optional.of(new CoreError("Улица", "Улица не должно быть пустым!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validZip(SaveClientRequest request) {
        if(request.getZip() == null || request.getZip().isEmpty()) {
            return Optional.of(new CoreError("Индекс", "Индекс не должно быть пустым!"));
        } else if(request.getZip().matches("[*a-zA-Z],[*а-яА-Я]")) {
            return Optional.of(new CoreError("Индекс", "Индекс должен состоять из цифр!"));
        } else {
            return Optional.empty();
        }
    }
}
