package hellojpa;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();

            member.setUsername("member1");
            member.getFavoriteFoods().add("닭가슴살");
            member.getFavoriteFoods().add("고구마");
            member.getFavoriteFoods().add("샐러드");

            member.getAddressHistory().add(new AddressEntity("oldCity1", "street", "10001"));
            member.getAddressHistory().add(new AddressEntity("oldCity2", "street", "10002"));
            member.getAddressHistory().add(new AddressEntity("oldCity3", "street", "10003"));

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            Set<String> favoriteFoods = findMember.getFavoriteFoods();

            favoriteFoods.add("아아");
            for (String favoriteFood : favoriteFoods) {
                System.out.println(favoriteFood);
            }

            favoriteFoods.remove("닭가슴살");
            favoriteFoods.add("치킨");

            List<AddressEntity> addressHistory = findMember.getAddressHistory();

//            addressHistory.remove(new Address("oldCity2", "street", "10002"));
//            addressHistory.add(new Address("newCity2", "street", "10002"));

//            addressHistory.remove(0);
//            addressHistory.remove(new AddressEntity("oldCity2", "street", "10002"));// 이건 안되네.
            

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
