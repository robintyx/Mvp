package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {

    @Test
    void testSectionEntityProperties() {
        Section section = new Section();
        section.setSection_id(1);
        section.setSection_name("Test Section");

        assertEquals(1, section.getSection_id());
        assertEquals("Test Section", section.getSection_name());
    }

    @Test
    void testEntityAnnotations() throws NoSuchFieldException {
        Class<Section> clazz = Section.class;

        // @Entity 注解
        assertNotNull(clazz.getAnnotation(Entity.class));

        // @Table(name = "section")
        Table table = clazz.getAnnotation(Table.class);
        assertNotNull(table);
        assertEquals("section", table.name());

        // @Id 注解在 section_id 上
        assertNotNull(clazz.getDeclaredField("section_id").getAnnotation(Id.class));

        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        GeneratedValue generatedValue = clazz.getDeclaredField("section_id").getAnnotation(GeneratedValue.class);
        assertNotNull(generatedValue);
        assertEquals(GenerationType.IDENTITY, generatedValue.strategy());

        // @Column(name = "f_vc_section_name")
        Column sectionNameCol = clazz.getDeclaredField("section_name").getAnnotation(Column.class);
        assertNotNull(sectionNameCol);
        assertEquals("f_vc_section_name", sectionNameCol.name());
    }

    @Test
    void testEqualsAndHashCode() {
        Section s1 = new Section();
        s1.setSection_id(1);
        s1.setSection_name("S1");

        Section s2 = new Section();
        s2.setSection_id(1);
        s2.setSection_name("S1");

        Section s3 = new Section();
        s3.setSection_id(2);

        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
        assertNotEquals(s1, s3);
    }

    @Test
    void testToStringIncludesFields() {
        Section section = new Section();
        section.setSection_id(1);
        section.setSection_name("Highway A");

        String result = section.toString();

        assertTrue(result.contains("section_id=1"));
        assertTrue(result.contains("section_name=Highway A"));
    }
}
