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

    private Optional<CoreError> validFirstName(SaveClientRequest request) {
        if(request.getFirstName() == null || request.getFirstName().isEmpty()) {
            return Optional.of(new CoreError("Имя", "Не должно быть пустым!"));
        } else if(request.getFirstName().matches("\\d+")) {
            return Optional.of(new CoreError("Имя", "Не должно содержать только цифры!"));
        } else if(request.getFirstName().matches("^[а-яa-z]*$")) {
            return Optional.of(new CoreError("Имя", "Должно начинаться с заглавной!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validLastName(SaveClientRequest request) {
        if(request.getLastName() == null || request.getLastName().isEmpty()) {
            return Optional.of(new CoreError("Фамилия", "Не должно быть пустой!"));
        } else if(request.getLastName().matches("\\d+")) {
            return Optional.of(new CoreError("Фамилия", "Не должно содержать только цифры!"));
        } else if(request.getLastName().matches("^[а-яa-z]*$")) {
            return Optional.of(new CoreError("Фамилия", "Должно начинаться с заглавной!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validGender(SaveClientRequest request) {
        if(request.getGender() == null || request.getGender().isEmpty()) {
            return Optional.of(new CoreError("Пол", "Не должно быть пустым!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validAge(SaveClientRequest request) {
        if(request.getAge() == 0 || request.getAge() < 0) {
            return Optional.of(new CoreError("Возраст", "Не должно быть пустым!"));
        } else if(!String.valueOf(request.getAge()).matches("\\d+")) {
            return Optional.of(new CoreError("Возраст", "Должно содержать целое число!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validPhoneNumber(SaveClientRequest request) {
        if(request.getPhoneNumber() == null || request.getPhoneNumber().isEmpty()) {
            return Optional.of(new CoreError("Номер телефона", "Не должно быть пустым!"));
        } else if(!request.getPhoneNumber().matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$")) {
            return Optional.of(new CoreError("Номер телефона", "Неверный формат!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validState(SaveClientRequest request) {
        if(request.getState() == null || request.getState().isEmpty()) {
            return Optional.of(new CoreError("Страна", "Не должно быть пустым!"));
        } else if(request.getState().matches("^[а-яa-z]*$")) {
            return Optional.of(new CoreError("Страна", "Должно начинаться с заглавной!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validEmail(SaveClientRequest request) {
        if(request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("Электронная почта", "Не должно быть пустым!"));
        } else if(request.getEmail().matches("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")) {
            return Optional.of(new CoreError("Электронная почта", "Неверный формат!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validCity(SaveClientRequest request) {
        if(request.getCity() == null || request.getCity().isEmpty()) {
            return Optional.of(new CoreError("Город", "Не должно быть пустым!"));
        } else if(request.getCity().matches("^[а-яa-z]*$")) {
            return Optional.of(new CoreError("Город", "Должно начинаться с заглавной!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validStreet(SaveClientRequest request) {
        if(request.getStreet() == null || request.getStreet().isEmpty()) {
            return Optional.of(new CoreError("Улица", "Не должно быть пустым!"));
        } else if(request.getStreet().matches("^[а-яa-z]*$")) {
            return Optional.of(new CoreError("Улица", "Должно начинаться с заглавной!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validZip(SaveClientRequest request) {
        if(request.getZip() == null || request.getZip().isEmpty()) {
            return Optional.of(new CoreError("Индекс", "Не должно быть пустым!"));
        } else if(!String.valueOf(request.getZip()).matches("\\d+")) {
            return Optional.of(new CoreError("Индекс", "Должно состоять из цифр!"));
        } else {
            return Optional.empty();
        }
    }
}
