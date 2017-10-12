package ru.matmex.welcome.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.matmex.welcome.model.Message;

import java.util.List;

@Component("H2dbService")
@Transactional
public class H2dbService {
    @Autowired
    private H2dbDAO h2dbDAO;

    public void create(Message message) {
        h2dbDAO.create(message);
    }

    public Message get(Integer id){
        return h2dbDAO.getById(id);
    }

    public List<Message> list(){
        return h2dbDAO.list();
    }
}
