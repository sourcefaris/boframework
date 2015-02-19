package org.bo.persistence.hibernate;

public interface HibernateSessionFactoryAware {
    void setHibernateSessionFactory(HibernateSessionFactory hsf);
}
