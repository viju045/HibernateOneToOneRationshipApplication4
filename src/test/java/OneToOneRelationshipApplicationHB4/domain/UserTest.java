package OneToOneRelationshipApplicationHB4.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link User}
     *   <li>{@link User#setAdress(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setId(long)}
     *   <li>{@link User#setName(String)}
     *   <li>{@link User#setVehical(Vehical)}
     *   <li>{@link User#getAdress()}
     *   <li>{@link User#getVehical()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setAdress("Adress");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setId(1L);
        actualUser.setName("Name");
        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setName("Name");
        Vehical vehical = new Vehical();
        user.setVehical(vehical);
        Vehical vehical2 = new Vehical();
        vehical2.setId(1L);
        vehical2.setPrice(1L);
        vehical2.setType("Type");
        vehical2.setUser(user);
        vehical2.setVehical_name("Vehical name");
        User user2 = new User();
        user2.setAdress("Adress");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1L);
        user2.setName("Name");
        user2.setVehical(vehical2);
        Vehical vehical3 = new Vehical();
        vehical3.setId(1L);
        vehical3.setPrice(1L);
        vehical3.setType("Type");
        vehical3.setUser(user2);
        vehical3.setVehical_name("Vehical name");
        actualUser.setVehical(vehical3);
        assertEquals("Adress", actualUser.getAdress());
        Vehical vehical4 = actualUser.getVehical();
        User user3 = vehical4.getUser();
        assertEquals("Adress", user3.getAdress());
        Vehical vehical5 = user3.getVehical();
        User user4 = vehical5.getUser();
        assertEquals("Adress", user4.getAdress());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("jane.doe@example.org", user3.getEmail());
        assertEquals("jane.doe@example.org", user4.getEmail());
        assertEquals(1L, actualUser.getId());
        assertEquals(1L, user3.getId());
        assertEquals(1L, user4.getId());
        assertEquals("Name", actualUser.getName());
        assertEquals("Name", user3.getName());
        assertEquals("Name", user4.getName());
        assertSame(vehical3, vehical4);
        assertSame(vehical2, vehical5);
        assertSame(vehical, user4.getVehical());
    }
}

