package huongtran.controller;

import huongtran.model.type;
import huongtran.model.Client;
import huongtran.service.ITypeService;
import huongtran.service.IClientService;
import huongtran.validate.Validate_Trung_Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    IClientService clientService;

    @Autowired
    ITypeService typeService;

    @Autowired
    Validate_Trung_Name validate_trung_name;

    @GetMapping("/clients")
    public ModelAndView showAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "name") String option) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("clients", clientService.findAll(PageRequest.of(page, 3, Sort.by(option))));
        modelAndView.addObject("option", option);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @ModelAttribute("client")
    public Client client(){
        return new Client();
    }

    @ModelAttribute("types")
    public List<type> types(){
        return typeService.findAll();
    }


    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(value = "student") Client student, BindingResult bindingResult, @RequestParam MultipartFile upImg) {
        validate_trung_name.validate(client(), bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("C:\\Users\\Tran Thi Thu Hang\\Desktop\\modul_hate\\bai712\\src\\main\\webapp\\WEB-INF\\img" + nameFile));
            client().setImg("/img/" + nameFile);
            clientService.save(client());

        } catch (IOException e) {
            client().setImg("/img/abc.jpeg");
            clientService.save(client());
            e.printStackTrace();
        }
        return "redirect:/clients";
    }
}
