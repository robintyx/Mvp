package cn.microvideo.framework3.project.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserEntityProperties() {
        User user = new User();

        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123456");
        user.setCreateTime("2024-01-01");
        user.setUpdateTime("2024-01-02");
        user.setDelFlag(0);
        user.setVersion(1);

        assertEquals(1, user.getId());
        assertEquals("admin", user.getUsername());
        assertEquals("123456", user.getPassword());
        assertEquals("2024-01-01", user.getCreateTime());
        assertEquals("2024-01-02", user.getUpdateTime());
        assertEquals(0, user.getDelFlag());
        assertEquals(1, user.getVersion());
    }

    @Test
    void testJsonIgnoreAnnotations() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123456");
        user.setCreateTime("2024-01-01");
        user.setUpdateTime("2024-01-02");
        user.setDelFlag(0);
        user.setVersion(1);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        // assert only exposed fields are serialized
        assertTrue(json.contains("id"));
        assertTrue(json.contains("username"));
        assertTrue(json.contains("password"));
        assertFalse(json.contains("createTime"));
        assertFalse(json.contains("updateTime"));
        assertFalse(json.contains("delFlag"));
        assertFalse(json.contains("version"));
    }

    @Test
    void testEntityAnnotations() throws NoSuchFieldException {
        Class<User> clazz = User.class;

        // @Entity
        assertNotNull(clazz.getAnnotation(Entity.class));

        // @Table
        Table table = clazz.getAnnotation(Table.class);
        assertNotNull(table);
        assertEquals("t_hw_user", table.name());

        // @Id
        assertNotNull(clazz.getDeclaredField("id").getAnnotation(Id.class));

        // @Column
        assertEquals("f_vc_username", clazz.getDeclaredField("username").getAnnotation(Column.class).name());
        assertEquals("f_vc_password", clazz.getDeclaredField("password").getAnnotation(Column.class).name());
    }

    @Test
    void testEqualsAndHashCode() {
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("admin");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setId(1);
        user2.setUsername("admin");
        user2.setPassword("123456");

        User user3 = new User();
        user3.setId(2);

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
        assertNotEquals(user1, user3);
    }

    @Test
    void testToStringIncludesFields() {
        User user = new User();
        user.setId(1);
        user.setUsername("testUser");
        user.setPassword("testPass");

        String result = user.toString();

        assertTrue(result.contains("id=1"));
        assertTrue(result.contains("username=testUser"));
        assertTrue(result.contains("password=testPass"));
    }
}
