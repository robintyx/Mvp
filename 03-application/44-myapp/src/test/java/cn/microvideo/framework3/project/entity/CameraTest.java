package cn.microvideo.framework3.project.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CameraTest {

    @Test
    void testGetterAndSetter() {
        Camera camera = new Camera();
        camera.setCamera_id(1);
        camera.setCamera_name("Test Camera");
        camera.setLongitude(120.12);
        camera.setLatitude(31.23);
        camera.setDirection(90);
        camera.setVideo_url("rtsp://test.url");
        camera.setStatus(1);
        camera.setLine_id(2);
        camera.setType_id(3);
        camera.setStake_id(4);
        camera.setCreate_time("2023-01-01");
        camera.setUpdate_time("2023-01-02");
        camera.setDel_flag(0);
        camera.setVersion(1);
        camera.setType_name("IPC");
        camera.setLine_name("Line 1");
        camera.setStake_name("Stake A");

        assertEquals(1, camera.getCamera_id());
        assertEquals("Test Camera", camera.getCamera_name());
        assertEquals(120.12, camera.getLongitude());
        assertEquals(31.23, camera.getLatitude());
        assertEquals(90, camera.getDirection());
        assertEquals("rtsp://test.url", camera.getVideo_url());
        assertEquals(1, camera.getStatus());
        assertEquals(2, camera.getLine_id());
        assertEquals(3, camera.getType_id());
        assertEquals(4, camera.getStake_id());
        assertEquals("2023-01-01", camera.getCreate_time());
        assertEquals("2023-01-02", camera.getUpdate_time());
        assertEquals(0, camera.getDel_flag());
        assertEquals(1, camera.getVersion());
        assertEquals("IPC", camera.getType_name());
        assertEquals("Line 1", camera.getLine_name());
        assertEquals("Stake A", camera.getStake_name());
    }

    @Test
    void testEqualsAndHashCode() {
        Camera c1 = new Camera();
        c1.setCamera_id(1);
        c1.setCamera_name("Cam");

        Camera c2 = new Camera();
        c2.setCamera_id(1);
        c2.setCamera_name("Cam");

        Camera c3 = new Camera();
        c3.setCamera_id(2);
        c3.setCamera_name("Diff");

        assertEquals(c1, c2); // equals true 分支
        assertEquals(c1.hashCode(), c2.hashCode());
        assertNotEquals(c1, c3); // equals false 分支
        assertNotEquals(c1, null); // null 分支
        assertNotEquals(c1, new Object()); // 类型不同分支
    }

    @Test
    void testToString() {
        Camera camera = new Camera();
        camera.setCamera_id(10);
        camera.setCamera_name("CamX");
        String result = camera.toString();
        assertTrue(result.contains("CamX"));
        assertTrue(result.contains("camera_id=10"));
    }

    @Test
    void testJsonIgnoreFields() throws JsonProcessingException {
        Camera camera = new Camera();
        camera.setCamera_id(1);
        camera.setCreate_time("2023-01-01");
        camera.setUpdate_time("2023-01-02");
        camera.setDel_flag(1);
        camera.setVersion(2);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(camera);

        assertFalse(json.contains("create_time"));
        assertFalse(json.contains("update_time"));
        assertFalse(json.contains("del_flag"));
        assertFalse(json.contains("version"));
        assertTrue(json.contains("camera_id"));
    }
}