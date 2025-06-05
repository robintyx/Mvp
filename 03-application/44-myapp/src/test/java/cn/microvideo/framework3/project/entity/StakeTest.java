package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StakeTest {

    @Test
    void testStakeEntityProperties() {
        Stake stake = new Stake();
        stake.setStake_id(1);
        stake.setStake_name("Stake A");
        stake.setLine_id(100);
        stake.setLine_name("Line 100");

        assertEquals(1, stake.getStake_id());
        assertEquals("Stake A", stake.getStake_name());
        assertEquals(100, stake.getLine_id());
        assertEquals("Line 100", stake.getLine_name());
    }

    @Test
    void testEntityAnnotations() throws NoSuchFieldException {
        Class<Stake> clazz = Stake.class;

        // @Entity 注解
        assertNotNull(clazz.getAnnotation(Entity.class));

        // @Table(name = "t_hw_stake")
        Table table = clazz.getAnnotation(Table.class);
        assertNotNull(table);
        assertEquals("t_hw_stake", table.name());

        // @Id 注解
        assertNotNull(clazz.getDeclaredField("stake_id").getAnnotation(Id.class));

        // @GeneratedValue 注解
        GeneratedValue generatedValue = clazz.getDeclaredField("stake_id").getAnnotation(GeneratedValue.class);
        assertNotNull(generatedValue);
        assertEquals(GenerationType.IDENTITY, generatedValue.strategy());

        // @Column 注解
        Column stakeNameCol = clazz.getDeclaredField("stake_name").getAnnotation(Column.class);
        assertNotNull(stakeNameCol);
        assertEquals("f_vc_stake_name", stakeNameCol.name());

        Column lineIdCol = clazz.getDeclaredField("line_id").getAnnotation(Column.class);
        assertNotNull(lineIdCol);
        assertEquals("f_int_line_id", lineIdCol.name());
    }

    @Test
    void testEqualsAndHashCode() {
        Stake s1 = new Stake();
        s1.setStake_id(1);
        s1.setStake_name("S1");
        s1.setLine_id(100);

        Stake s2 = new Stake();
        s2.setStake_id(1);
        s2.setStake_name("S1");
        s2.setLine_id(100);

        Stake s3 = new Stake();
        s3.setStake_id(2);

        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
        assertNotEquals(s1, s3);
    }

    @Test
    void testToStringIncludesFields() {
        Stake stake = new Stake();
        stake.setStake_id(1);
        stake.setStake_name("KM123");
        stake.setLine_id(456);
        stake.setLine_name("Line X");

        String result = stake.toString();

        assertTrue(result.contains("stake_id=1"));
        assertTrue(result.contains("stake_name=KM123"));
        assertTrue(result.contains("line_id=456"));
        assertTrue(result.contains("line_name=Line X"));
    }
}
