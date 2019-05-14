package dev.test.dao;

import dev.test.models.WebNote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class NoteDaoImpl implements NoteDao {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, WebNote> notes = new HashMap<>();

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    @SuppressWarnings("unchecked")
    public List<WebNote> allNotes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from WebNote").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<WebNote> filteredNotes(String filter_string) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM WebNote  WHERE text like concat('%',:filter_str, '%')");
        query.setParameter("filter_str", filter_string);
        List<WebNote> _tmp_list = query.list();
        if(_tmp_list.size()==0)
            return null;
        return _tmp_list;
    }

    @Override
    public void add(WebNote note) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(note);
    }

    @Override
    public void delete(WebNote note) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(note);
    }

    @Override
    public WebNote getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(WebNote.class, id);
    }
}
