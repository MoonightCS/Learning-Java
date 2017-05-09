package ru.popov.bodya.database.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.popov.bodya.database.datasets.UserProfile;

public class UserDAO {

    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public UserProfile getUserByID(long id) throws HibernateException {
        return (UserProfile) session.get(UserProfile.class, id);
    }

    public UserProfile getUserByLogin(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UserProfile.class);
        return (UserProfile) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }

    public long insertUser(UserProfile userProfile) throws HibernateException {
        UserProfile user = getUserByLogin(userProfile.getLogin());
        if (user == null) {
            return (Long) session.save(userProfile);
        } else return -1;
    }
}
