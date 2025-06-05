package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void testCompanyProperties() {
        Company company = new Company();
        company.setCompany_id(1);
        company.setCompany_name("MicroVideo");

        assertEquals(1, company.getCompany_id());
        assertEquals("MicroVideo", company.getCompany_name());
    }

    @Test
    void testEntityAnnotations() throws NoSuchFieldException {
        Class<Company> clazz = Company.class;

        // 类级注解：@Entity
        assertNotNull(clazz.getAnnotation(Entity.class));

        // 类级注解：@Table
        Table table = clazz.getAnnotation(Table.class);
        assertNotNull(table);
        assertEquals("t_hw_company", table.name());

        // 字段注解：@Id
        assertNotNull(clazz.getDeclaredField("company_id").getAnnotation(Id.class));

        // 字段注解：@GeneratedValue
        GeneratedValue generatedValue = clazz.getDeclaredField("company_id").getAnnotation(GeneratedValue.class);
        assertNotNull(generatedValue);
        assertEquals(GenerationType.IDENTITY, generatedValue.strategy());

        // 字段注解：@Column
        Column companyNameCol = clazz.getDeclaredField("company_name").getAnnotation(Column.class);
        assertNotNull(companyNameCol);
        assertEquals("f_vc_company_name", companyNameCol.name());
    }

    @Test
    void testEqualsAndHashCode() {
        Company c1 = new Company();
        c1.setCompany_id(1);
        c1.setCompany_name("A");

        Company c2 = new Company();
        c2.setCompany_id(1);
        c2.setCompany_name("A");

        Company c3 = new Company();
        c3.setCompany_id(2);
        c3.setCompany_name("B");

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
        assertNotEquals(c1, c3);
    }

    @Test
    void testToStringIncludesFields() {
        Company company = new Company();
        company.setCompany_id(99);
        company.setCompany_name("Test Inc.");

        String output = company.toString();
        assertTrue(output.contains("company_id=99"));
        assertTrue(output.contains("company_name=Test Inc."));
    }
}
