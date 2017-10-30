package ru.matmex.welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.matmex.welcome.dao.H2dbService;
import ru.matmex.welcome.model.Message;

import java.util.Date;
import java.util.Map;

@Controller
public class HelloContoller {

    @Autowired
    private H2dbService h2dbService;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("messages", h2dbService.list());
        return "index";
    }

    /**
     * Интерфейс создания сообщения
     * @param model модель для передачи параметров в шаблон
     * @return
     */
    @GetMapping("/addMessage")
    public String addMessageForm(Model model) {
        return "create";
    }

    /**
     * Сохраниение сообщения в БД
     * @param title наименование сообщения
     * @param msg текст сообщения
     * @return редирект на главную страницу
     */
    @PostMapping(value = "/addMessage")
    public ModelAndView createMessage(@RequestParam("title") String title,
                                      @RequestParam("message") String msg){
        Message message = new Message();
        message.setMessage(msg);
        message.setTitle(title);
        message.setCreate(new Date());
        h2dbService.create(message);
        return new ModelAndView("redirect:/");
    }
    /**
     * Страница ввода логина
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * получение сообщения по id
     * @param id
     * @return
     */
    @GetMapping("/mem/{id}")
    public @ResponseBody Message memgetid(@PathVariable(value="id") Integer id) {
        return h2dbService.get(id);
    }

    /**
     * Пример выбрасывания ошибки
     * @param model
     * @return
     */
    @RequestMapping("/admin")
    public String errorExample(Map<String, Object> model) {
        throw new RuntimeException("Welcome to Error!");
    }
}
