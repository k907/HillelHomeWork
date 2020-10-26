package Repositories;

import Models.Student;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<Student> findById(int id) {
        return Optional.ofNullable((Student) HibernateUtil.getSessionFactory().openSession().get(Student.class, id));
    }

    @Override
    public List<Student> findAll() {
        return HibernateUtil.getSessionFactory().openSession().createQuery("From Student").list();
    }

    @Override
    public List<Student> findByFullName(String fullName) {
        return (List<Student>) HibernateUtil.getSessionFactory().openSession().createQuery("From Student as s  WHERE s.fullName = '" + fullName + "'  ").list();
    }

    @Override
    public void add(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }
}
