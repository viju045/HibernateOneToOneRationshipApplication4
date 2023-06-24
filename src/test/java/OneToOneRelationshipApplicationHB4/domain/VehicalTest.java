package OneToOneRelationshipApplicationHB4.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class VehicalTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Vehical}
     *   <li>{@link Vehical#setId(long)}
     *   <li>{@link Vehical#setPrice(long)}
     *   <li>{@link Vehical#setType(String)}
     *   <li>{@link Vehical#setUser(User)}
     *   <li>{@link Vehical#setVehical_name(String)}
     *   <li>{@link Vehical#getId()}
     *   <li>{@link Vehical#getUser()}
     *   <li>{@link Vehical#getPrice()}
     *   <li>{@link Vehical#getType()}
     *   <li>{@link Vehical#getVehical_name()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Vehical actualVehical = new Vehical();
        actualVehical.setId(1L);
        actualVehical.setPrice(1L);
        actualVehical.setType("Type");
        Vehical vehical = new Vehical();
        vehical.setId(1L);
        vehical.setPrice(1L);
        vehical.setType("Type");
        User user = new User();
        vehical.setUser(user);
        vehical.setVehical_name("Vehical name");
        User user2 = new User();
        user2.setAdress("Adress");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1L);
        user2.setName("Name");
        user2.setVehical(vehical);
        Vehical vehical2 = new Vehical();
        vehical2.setId(1L);
        vehical2.setPrice(1L);
        vehical2.setType("Type");
        vehical2.setUser(user2);
        vehical2.setVehical_name("Vehical name");
        User user3 = new User();
        user3.setAdress("Adress");
        user3.setEmail("jane.doe@example.org");
        user3.setId(1L);
        user3.setName("Name");
        user3.setVehical(vehical2);
        actualVehical.setUser(user3);
        actualVehical.setVehical_name("Vehical name");
        assertEquals(1L, actualVehical.getId());
        User user4 = actualVehical.getUser();
        Vehical vehical3 = user4.getVehical();
        assertEquals(1L, vehical3.getId());
        User user5 = vehical3.getUser();
        Vehical vehical4 = user5.getVehical();
        assertEquals(1L, vehical4.getId());
        assertEquals(1L, actualVehical.getPrice());
        assertEquals(1L, vehical3.getPrice());
        assertEquals(1L, vehical4.getPrice());
        assertEquals("Type", actualVehical.getType());
        assertEquals("Type", vehical3.getType());
        assertEquals("Type", vehical4.getType());
        assertSame(user3, user4);
        assertSame(user2, user5);
        assertSame(user, vehical4.getUser());
        assertEquals("Vehical name", actualVehical.getVehical_name());
        assertEquals("Vehical name", vehical3.getVehical_name());
        assertEquals("Vehical name", vehical4.getVehical_name());
    }
}

