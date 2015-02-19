package org.bo.persistence.hibernate;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public interface HibernateSessionFactory {

    Session createSession() throws HibernateException;

    void endSession(Session session) throws SQLException, HibernateException;

    void closeSession(Session session) throws SQLException, HibernateException;
}
