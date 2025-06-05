package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Event;
import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.EventMapper;
import cn.microvideo.framework3.project.service.EventService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class EventControllerTest {

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    @Mock
    private EventMapper eventMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test getEvent with data found
     */
    @Test
    void getEvent_withData_shouldReturnSuccess() {
        // Arrange
        PageInfo<Event> mockPageInfo = new PageInfo<>();
        mockPageInfo.setSize(10); // Set size to indicate data exists
        when(eventService.getEvents(any(), any(), any(), any(), anyInt(), anyInt()))
                .thenReturn(mockPageInfo);

        // Act
        Result<PageInfo<Event>> result = eventController.getEvent(null, null, null, null, 1, 10);

        // Assert
        assertTrue(result.isSuccess());
        assertEquals("查询成功", result.getMessage());
        assertEquals(mockPageInfo, result.getData());
    }

    /**
     * Test getEvent with no data found
     */
    @Test
    void getEvent_withNoData_shouldReturnNotFound() {
        // Arrange
        PageInfo<Event> mockPageInfo = new PageInfo<>();
        mockPageInfo.setSize(0); // Set size to 0 to indicate no data
        when(eventService.getEvents(any(), any(), any(), any(), anyInt(), anyInt()))
                .thenReturn(mockPageInfo);

        // Act
        Result<PageInfo<Event>> result = eventController.getEvent(null, null, null, null, 1, 10);

        // Assert
        assertFalse(result.isSuccess());
        assertEquals("没有数据", result.getMessage());
    }

    /**
     * Test getEvent with different query parameters
     */
    @Test
    void getEvent_withDifferentParameters_shouldCallServiceCorrectly() {
        // Arrange
        Integer testEventId = 1;
        String testCarClient = "testClient";
        Integer testLineId = 2;
        Integer testCameraId = 3;
        PageInfo<Event> mockPageInfo = new PageInfo<>();
        mockPageInfo.setSize(1);
        when(eventService.getEvents(any(), any(), any(), any(), anyInt(), anyInt()))
                .thenReturn(mockPageInfo);

        // Act
        Result<PageInfo<Event>> result = eventController.getEvent(testEventId, testCarClient, testLineId, testCameraId, 1, 10);

        // Assert
        verify(eventService).getEvents(testEventId, testCarClient, testLineId, testCameraId, 1, 10);
        assertTrue(result.isSuccess());
    }

    /**
     * Test addEvent successfully
     */
    @Test
    void addEvent_successful_shouldReturnSuccess() {
        // Arrange
        Event testEvent = new Event();
        when(eventMapper.addEvent(any(Event.class))).thenReturn(1);

        // Act
        Result<String> result = eventController.addEvent(testEvent);

        // Assert
        assertTrue(result.isSuccess());
        assertEquals("添加成功", result.getMessage());
        verify(eventMapper).addEvent(testEvent);
    }

    /**
     * Test addEvent failed
     */
    @Test
    void addEvent_failed_shouldReturnFail() {
        // Arrange
        Event testEvent = new Event();
        when(eventMapper.addEvent(any(Event.class))).thenReturn(0);

        // Act
        Result<String> result = eventController.addEvent(testEvent);

        // Assert
        assertFalse(result.isSuccess());
        assertEquals("添加失败", result.getMessage());
    }
}
