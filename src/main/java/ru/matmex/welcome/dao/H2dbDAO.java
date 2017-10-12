package ru.matmex.welcome.dao;

import org.springframework.stereotype.Repository;
import ru.matmex.welcome.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class H2dbDAO {
    @PersistenceContext
    private EntityManager entityManager;


    public void create(Message message) {
        entityManager.persist(message);
    }


    public void update(Message message) {
        entityManager.merge(message);
    }

    public Message getById(Integer id){
        return entityManager.find(Message.class, id);
    }

    /**
     * Получение всех сообщений при помощи Criteria {@link javax.persistence.criteria.CriteriaQuery}
     * @return Все сообщения
     */
    public List<Message> list(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(Message.class);
        Root<Message> variableRoot = query.from(Message.class);
        query.select(variableRoot);

        return entityManager.createQuery(query).getResultList();
    }
}