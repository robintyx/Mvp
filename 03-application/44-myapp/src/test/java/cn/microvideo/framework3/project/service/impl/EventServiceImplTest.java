package cn.microvideo.framework3.project.service.impl;

import cn.microvideo.framework3.project.entity.Event;
import cn.microvideo.framework3.project.mapper.EventMapper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock
    private EventMapper eventMapper;

    @InjectMocks
    private EventServiceImpl eventService;

    private List<Event> mockEvents;

    @BeforeEach
    void setUp() {
        // Prepare mock data
        Event event1 = new Event();
        event1.setEvent_id(1);
        Event event2 = new Event();
        event2.setEvent_id(2);
        mockEvents = Arrays.asList(event1, event2);
    }

    @Test
    void getEvents_shouldThrowException_whenPageIsInvalid() {
        // Test null page
        assertThrows(IllegalArgumentException.class, () ->
                eventService.getEvents(null, null, null, null, null, 10));

        // Test page <= 0
        assertThrows(IllegalArgumentException.class, () ->
                eventService.getEvents(null, null, null, null, 0, 10));
    }

    @Test
    void getEvents_shouldThrowException_whenLimitIsInvalid() {
        // Test null limit
        assertThrows(IllegalArgumentException.class, () ->
                eventService.getEvents(null, null, null, null, 1, null));

        // Test limit <= 0
        assertThrows(IllegalArgumentException.class, () ->
                eventService.getEvents(null, null, null, null, 1, 0));
    }

    @Test
    void getEvents_shouldReturnPageInfo_whenAllParamsAreNull() {
        // Mock mapper behavior
        when(eventMapper.selectEvents(any(), any(), any(), any()))
                .thenReturn(mockEvents);

        // Call method
        PageInfo<Event> result = eventService.getEvents(null, null, null, null, 1, 10);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.getList().size());
        verify(eventMapper).selectEvents(null, null, null, null);
    }

    @Test
    void getEvents_shouldReturnFilteredResults_whenParamsAreProvided() {
        // Mock mapper behavior with specific parameters
        when(eventMapper.selectEvents(eq(1), eq("client1"), eq(2), eq(3)))
                .thenReturn(Collections.singletonList(mockEvents.get(0)));

        // Call method with specific parameters
        PageInfo<Event> result = eventService.getEvents(1, "client1", 2, 3, 1, 10);

        // Verify
        assertNotNull(result);
        assertEquals(1, result.getList().size());
        assertEquals(1, result.getList().get(0).getEvent_id());
        verify(eventMapper).selectEvents(1, "client1", 2, 3);
    }

    @Test
    void getEvents_shouldReturnEmptyPage_whenNoResultsFound() {
        // Mock empty result
        when(eventMapper.selectEvents(any(), any(), any(), any()))
                .thenReturn(Collections.emptyList());

        // Call method
        PageInfo<Event> result = eventService.getEvents(999, null, null, null, 1, 10);

        // Verify
        assertNotNull(result);
        assertTrue(result.getList().isEmpty());
    }
}
