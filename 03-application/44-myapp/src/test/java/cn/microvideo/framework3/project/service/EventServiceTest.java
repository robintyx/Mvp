package cn.microvideo.framework3.project.service;

import cn.microvideo.framework3.project.entity.Event;
import cn.microvideo.framework3.project.mapper.EventMapper;
import cn.microvideo.framework3.project.service.impl.EventServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Mock
    private EventMapper eventMapper;

    @InjectMocks
    private EventServiceImpl eventServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case: all parameters provided
     */
    @Test
    void testGetEvents_AllParameters() {
        Integer eventId = 1;
        String carClient = "testClient";
        Integer lineId = 2;
        Integer cameraId = 3;
        Integer page = 1;
        Integer limit = 10;

        Event dummyEvent = new Event(); // 你可以设置字段
        when(eventMapper.selectEvents(eventId, carClient, lineId, cameraId))
                .thenReturn(Collections.singletonList(dummyEvent));

        PageInfo<Event> result = eventServiceImpl.getEvents(eventId, carClient, lineId, cameraId, page, limit);

        assertNotNull(result);
        assertEquals(page, result.getPageNum());
        assertEquals(1, result.getList().size());

        verify(eventMapper, times(1)).selectEvents(eventId, carClient, lineId, cameraId);
    }

    /**
     * Test case: optional parameters are null
     */
    @Test
    void testGetEvents_OptionalParametersNull() {
        Integer page = 1;
        Integer limit = 10;

        when(eventMapper.selectEvents(null, null, null, null))
                .thenReturn(Collections.emptyList());

        PageInfo<Event> result = eventServiceImpl.getEvents(null, null, null, null, page, limit);

        assertNotNull(result);
        assertTrue(result.getList().isEmpty());

        verify(eventMapper).selectEvents(null, null, null, null);
    }

    /**
     * Test case: negative page number
     */
    @Test
    void testGetEvents_NegativePageNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            eventServiceImpl.getEvents(null, null, null, null, -1, 10);
        });
    }

    /**
     * Test case: null limit
     */
    @Test
    void testGetEvents_NullLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            eventServiceImpl.getEvents(null, null, null, null, 1, null);
        });
    }

    /**
     * Test case: minimum allowed limit
     */
    @Test
    void testGetEvents_MinimumLimit() {
        Integer page = 1;
        Integer limit = 1;

        Event dummyEvent = new Event();
        when(eventMapper.selectEvents(null, null, null, null))
                .thenReturn(Collections.singletonList(dummyEvent));

        PageInfo<Event> result = eventServiceImpl.getEvents(null, null, null, null, page, limit);

        assertNotNull(result);
        assertEquals(1, result.getPageSize());
        assertEquals(1, result.getList().size());
    }
}
