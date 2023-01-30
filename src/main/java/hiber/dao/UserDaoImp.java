package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findUserByAuto(Long id, String model) {
      String HQL="FROM User WHERE userCar.id = :carsId AND userCar.model = :model";
      return (User) sessionFactory.getCurrentSession().
              createQuery(HQL).
              setParameter("carsId", id).setParameter("model", model).
              uniqueResult();
   }

}
