import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main00 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Town> selectTFromTownT = em.createQuery("select t from Town t", Town.class).getResultList();

        for (Town town : selectTFromTownT) {
            String name = town.getName();
            if (name.length() <= 5){
                String toUpper = name.toUpperCase();
                town.setName(toUpper);
                em.persist(town);
            }
        }
        em.getTransaction().commit();
    }
}
