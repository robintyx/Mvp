package cn.microvideo.framework3.project.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void testLineEntityProperties() {
        Line line = new Line();
        line.setLine_id(1);
        line.setLine_name("Line A");
        line.setCoordinates("coord");
        line.setWkt("LINESTRING(...)");

        List<List<Double>> spatial = Arrays.asList(
                Arrays.asList(120.0, 30.0),
                Arrays.asList(121.0, 31.0)
        );
        line.setLine_spatial_data(spatial);
        line.setCompany_id(10);
        line.setSection_id(20);
        line.setStatus(1);
        line.setCreate_time("2024-01-01");
        line.setUpdate_time("2024-01-02");
        line.setDel_flag(0);
        line.setVersion(1);
        line.setCompany_name("Microvideo");
        line.setSection_name("East Section");

        assertEquals(1, line.getLine_id());
        assertEquals("Line A", line.getLine_name());
        assertEquals("coord", line.getCoordinates());
        assertEquals("LINESTRING(...)", line.getWkt());
        assertEquals(spatial, line.getLine_spatial_data());
        assertEquals(10, line.getCompany_id());
        assertEquals(20, line.getSection_id());
        assertEquals(1, line.getStatus());
        assertEquals("2024-01-01", line.getCreate_time());
        assertEquals("2024-01-02", line.getUpdate_time());
        assertEquals(0, line.getDel_flag());
        assertEquals(1, line.getVersion());
        assertEquals("Microvideo", line.getCompany_name());
        assertEquals("East Section", line.getSection_name());
    }

    @Test
    void testJsonIgnoreFields() throws JsonProcessingException {
        Line line = new Line();
        line.setCreate_time("2024-01-01");
        line.setUpdate_time("2024-01-02");
        line.setDel_flag(1);
        line.setVersion(99);
        line.setCoordinates("internal");
        line.setWkt("WKT");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(line);

        assertFalse(json.contains("create_time"));
        assertFalse(json.contains("update_time"));
        assertFalse(json.contains("del_flag"));
        assertFalse(json.contains("version"));
        assertFalse(json.contains("coordinates"));
        assertFalse(json.contains("wkt"));
    }

    @Test
    void testEntityAnnotations() throws NoSuchFieldException {
        Class<Line> clazz = Line.class;

        assertNotNull(clazz.getAnnotation(Entity.class));

        Table table = clazz.getAnnotation(Table.class);
        assertNotNull(table);
        assertEquals("t_hw_line", table.name());

        Field idField = clazz.getDeclaredField("line_id");
        assertNotNull(idField.getAnnotation(Id.class));
        assertNotNull(idField.getAnnotation(GeneratedValue.class));
        assertNotNull(idField.getAnnotation(Column.class));
    }

    @Test
    void testEqualsHashCodeToStringCoverage() {
        Line line1 = new Line();
        line1.setLine_id(1);
        line1.setLine_name("Test Line");

        Line line2 = new Line();
        line2.setLine_id(1);
        line2.setLine_name("Test Line");

        Line line3 = new Line();
        line3.setLine_id(2);

        assertEquals(line1, line2);               // equals true
        assertEquals(line1.hashCode(), line2.hashCode());
        assertNotEquals(line1, line3);            // equals false
        assertNotEquals(line1, null);             // null compare
        assertNotEquals(line1, "not a Line");     // type mismatch
        assertTrue(line1.toString().contains("Test Line"));
    }
}
