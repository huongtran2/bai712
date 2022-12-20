package huongtran.validate;

import huongtran.model.Client;
import huongtran.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class Validate_Trung_Name implements Validator {
    @Autowired
    IClientService clientService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        List<Client> clients = clientService.findAll();
        for (Client c:clients) {
            if (client.getName().equals(c.getName())){
                errors.rejectValue("name", "", "Trung name");
                return;
            }
        }
    }
}
