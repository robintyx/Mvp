package cn.microvideo.framework3.project.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void testEventEntityProperties() {
        Event event = new Event();

        event.setEvent_id(1001);
        event.setCar_client("Car001");
        event.setIssue("Overheat");
        event.setLine_id(10);
        event.setCamera_id(20);
        event.setLine_name("Line A");
        event.setCamera_name("Camera X");

        assertEquals(1001, event.getEvent_id());
        assertEquals("Car001", event.getCar_client());
        assertEquals("Overheat", event.getIssue());
        assertEquals(10, event.getLine_id());
        assertEquals(20, event.getCamera_id());
        assertEquals("Line A", event.getLine_name());
        assertEquals("Camera X", event.getCamera_name());
    }

    @Test
    void testEventToJson() throws JsonProcessingException {
        Event event = new Event();
        event.setEvent_id(1);
        event.setCar_client("TestClient");
        event.setIssue("Speeding");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(event);

        assertTrue(json.contains("\"event_id\":1"));
        assertTrue(json.contains("\"car_client\":\"TestClient\""));
        assertTrue(json.contains("\"issue\":\"Speeding\""));
    }

    @Test
    void testEntityAnnotations() throws NoSuchFieldException {
        Class<Event> clazz = Event.class;

        assertNotNull(clazz.getAnnotation(Entity.class));

        Table table = clazz.getAnnotation(Table.class);
        assertNotNull(table);
        assertEquals("t_hw_event", table.name());

        // 检查 @Id 和 @GeneratedValue
        assertNotNull(clazz.getDeclaredField("event_id").getAnnotation(Id.class));
        GeneratedValue gen = clazz.getDeclaredField("event_id").getAnnotation(GeneratedValue.class);
        assertNotNull(gen);
        assertEquals(GenerationType.IDENTITY, gen.strategy());

        // 检查 @Column 注解字段
        Column carClientColumn = clazz.getDeclaredField("car_client").getAnnotation(Column.class);
        assertNotNull(carClientColumn);
        assertEquals("f_vc_car_client", carClientColumn.name());
    }

    @Test
    void testEqualsAndHashCode() {
        Event event1 = new Event();
        event1.setEvent_id(1);
        event1.setCar_client("clientA");
        event1.setIssue("IssueA");
        event1.setLine_id(10);
        event1.setCamera_id(20);
        event1.setLine_name("LineA");
        event1.setCamera_name("CameraA");

        Event event2 = new Event();
        event2.setEvent_id(1);
        event2.setCar_client("clientA");
        event2.setIssue("IssueA");
        event2.setLine_id(10);
        event2.setCamera_id(20);
        event2.setLine_name("LineA");
        event2.setCamera_name("CameraA");

        Event event3 = new Event();
        event3.setEvent_id(2); // 不同ID

        // equals
        assertEquals(event1, event2);
        assertNotEquals(event1, event3);

        // hashCode
        assertEquals(event1.hashCode(), event2.hashCode());
        assertNotEquals(event1.hashCode(), event3.hashCode());
    }

    @Test
    void testToStringContainsFields() {
        Event event = new Event();
        event.setEvent_id(1);
        event.setCar_client("clientB");
        event.setIssue("IssueB");

        String result = event.toString();

        assertTrue(result.contains("event_id=1"));
        assertTrue(result.contains("car_client=clientB"));
        assertTrue(result.contains("issue=IssueB"));
    }

}
