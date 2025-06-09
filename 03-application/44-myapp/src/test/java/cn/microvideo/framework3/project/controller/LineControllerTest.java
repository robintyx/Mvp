package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Line;
import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.LineMapper;
import cn.microvideo.framework3.project.service.LineService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class LineControllerTest {

    @Mock
    private LineMapper lineMapper;

    @Mock
    private LineService lineService;

    @InjectMocks
    private LineController lineController;

    private MockMvc mockMvc;

    List<List<Double>> testData = Arrays.asList(
            Arrays.asList(121.490317, 31.241701),
            Arrays.asList(121.491000, 31.242000)
    );

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(lineController).build();
    }

    @Test
    void findAll_ShouldReturnNotFoundWhenNoData() {
        // Arrange
        when(lineMapper.selectAll()).thenReturn(Collections.emptyList());

        // Act
        Result<PageInfo<Line>> result = lineController.findAll(1, 10);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(lineMapper).selectAll();
    }

    @Test
    void findAll_ShouldReturnPaginatedData() {
        // Arrange
        List<Line> mockLines = Arrays.asList(new Line(), new Line());
        List<Line> mockParsedLines = Arrays.asList(new Line(), new Line());
        when(lineMapper.selectAll()).thenReturn(mockLines);
        when(lineService.StrToList(mockLines)).thenReturn(mockParsedLines);

        // Act
        Result<PageInfo<Line>> result = lineController.findAll(1, 10);

        // Assert
        assertTrue(result.isSuccess());
        assertEquals(2, result.getData().getList().size());
        verify(lineMapper).selectAll();
        verify(lineService).StrToList(mockLines);
    }

    @Test
    void getLineById_ShouldReturnNotFoundWhenIdNotExist() {
        // Arrange
        when(lineMapper.selectById(anyInt())).thenReturn(Collections.emptyList());

        // Act
        Result<Line> result = lineController.getLineById(1);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(lineMapper).selectById(1);
    }

    @Test
    void getLineById_ShouldReturnLineWhenIdExist() {
        // Arrange
        Line mockLine = new Line();
        mockLine.setLine_id(1);
        List<Line> mockLines = Collections.singletonList(mockLine);
        when(lineMapper.selectById(1)).thenReturn(mockLines);
        when(lineService.StrToList(mockLines)).thenReturn(mockLines);

        // Act
        Result<Line> result = lineController.getLineById(1);

        // Assert
        assertTrue(result.isSuccess());
        assertEquals(1, result.getData().getLine_id());
        verify(lineMapper).selectById(1);
        verify(lineService).StrToList(mockLines);
    }

    @Test
    void delLineById_ShouldReturnNotFoundWhenIdNotExist() {
        // Arrange
        when(lineMapper.deleteById(anyInt())).thenReturn(0);

        // Act
        Result<String> result = lineController.delLineById(1);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(lineMapper).deleteById(1);
    }

    @Test
    void delLineById_ShouldReturnSuccessWhenDeleted() {
        // Arrange
        when(lineMapper.deleteById(anyInt())).thenReturn(1);

        // Act
        Result<String> result = lineController.delLineById(1);

        // Assert
        assertEquals("删除成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(lineMapper).deleteById(1);
    }

    @Test
    void addLine_ShouldReturnFailWhenInsertFailed() {
        // Arrange
        Line line = new Line();
        line.setLine_spatial_data(testData);
        when(lineMapper.insertLine(any())).thenReturn(0);
        when(lineService.swapLatLng(any())).thenReturn(new ArrayList<>());
        when(lineService.toWktLineString(any())).thenReturn("LINESTRING()");

        // Act
        Result<String> result = lineController.addLine(line);

        // Assert
        assertEquals("添加失败", result.getMessage());
        assertFalse(result.isSuccess());
        verify(lineMapper).insertLine(any());
    }

    @Test
    void addLine_ShouldReturnSuccessWhenInsertSucceed() {
        // Arrange
        Line line = new Line();
        line.setLine_spatial_data(testData);
        when(lineMapper.insertLine(any())).thenReturn(1);
        when(lineService.swapLatLng(any())).thenReturn(new ArrayList<>());
        when(lineService.toWktLineString(any())).thenReturn("LINESTRING()");

        // Act
        Result<String> result = lineController.addLine(line);

        // Assert
        assertEquals("添加成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(lineMapper).insertLine(any());
    }

    @Test
    void updateLine_ShouldReturnFailWhenUpdateFailed() {
        // Arrange
        Line line = new Line();
        line.setLine_spatial_data(testData);
        when(lineMapper.updateLine(any())).thenReturn(0);
        when(lineService.swapLatLng(any())).thenReturn(new ArrayList<>());
        when(lineService.toWktLineString(any())).thenReturn("LINESTRING()");

        // Act
        Result<String> result = lineController.updateLine(line);

        // Assert
        assertEquals("更新失败", result.getMessage());
        assertFalse(result.isSuccess());
        verify(lineMapper).updateLine(any());
    }

    @Test
    void updateLine_ShouldReturnSuccessWhenUpdateSucceed() {
        // Arrange
        Line line = new Line();
        line.setLine_id(1);
        line.setLine_spatial_data(testData);
        when(lineMapper.updateLine(any())).thenReturn(1);
        when(lineService.swapLatLng(any())).thenReturn(new ArrayList<>());
        when(lineService.toWktLineString(any())).thenReturn("LINESTRING()");

        // Act
        Result<String> result = lineController.updateLine(line);

        // Assert
        assertEquals("更新成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(lineMapper).updateLine(any());
    }

    @Test
    void selectAll_ShouldReturnAllLines() {
        // Arrange
        List<Line> mockLines = Arrays.asList(new Line(), new Line());
        when(lineMapper.selectAll()).thenReturn(mockLines);
        when(lineService.StrToList(mockLines)).thenReturn(mockLines);

        // Act
        Result<List<Line>> result = lineController.selectAll();

        // Assert
        assertTrue(result.isSuccess());
        assertEquals(2, result.getData().size());
        verify(lineMapper).selectAll();
        verify(lineService).StrToList(mockLines);
    }

    /**
     * 测试selectAll方法 - 查询结果为空的情况
     */
    @Test
    void selectAll_ShouldReturnSuccessWhenNoData() {
        // 准备mock数据
        when(lineMapper.selectAll()).thenReturn(Collections.emptyList());
        when(lineService.StrToList(Collections.emptyList())).thenReturn(Collections.emptyList());

        // 调用被测方法
        Result<List<Line>> result = lineController.selectAll();

        // 验证结果
        assertTrue(result.isSuccess());
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.getData().isEmpty());

        // 验证mock调用
        verify(lineMapper).selectAll();
        verify(lineService).StrToList(Collections.emptyList());
    }

    /**
     * 测试selectAll方法 - 查询结果不为空的情况
     */
    @Test
    void selectAll_ShouldReturnSuccessWithData() {
        // 准备测试数据
        Line line1 = new Line();
        line1.setLine_id(1);
        Line line2 = new Line();
        line2.setLine_id(2);
        List<Line> mockLines = Arrays.asList(line1, line2);
        List<Line> mockParsedLines = Arrays.asList(line1, line2);

        // 准备mock行为
        when(lineMapper.selectAll()).thenReturn(mockLines);
        when(lineService.StrToList(mockLines)).thenReturn(mockParsedLines);

        // 调用被测方法
        Result<List<Line>> result = lineController.selectAll();

        // 验证结果
        assertTrue(result.isSuccess());
        assertEquals("查询成功", result.getMessage());
        assertEquals(2, result.getData().size());
        assertEquals(1, result.getData().get(0).getLine_id());
        assertEquals(2, result.getData().get(1).getLine_id());

        // 验证mock调用
        verify(lineMapper).selectAll();
        verify(lineService).StrToList(mockLines);
    }

    /**
     * 测试selectBySectionId方法 - 查询结果为空的情况
     */
    @Test
    void selectBySectionId_ShouldReturnSuccessWhenNoData() {
        // 准备mock数据
        when(lineMapper.selectBySectionId(anyInt())).thenReturn(Collections.emptyList());
        when(lineService.StrToList(Collections.emptyList())).thenReturn(Collections.emptyList());

        // 调用被测方法
        Result<List<Line>> result = lineController.selectBySectionId(1);

        // 验证结果
        assertTrue(result.isSuccess());
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.getData().isEmpty());

        // 验证mock调用
        verify(lineMapper).selectBySectionId(1);
        verify(lineService).StrToList(Collections.emptyList());
    }

    /**
     * 测试selectBySectionId方法 - 查询结果不为空的情况
     */
    @Test
    void selectBySectionId_ShouldReturnSuccessWithData() {
        // 准备测试数据
        Line line1 = new Line();
        line1.setLine_id(1);
        line1.setSection_id(100);
        Line line2 = new Line();
        line2.setLine_id(2);
        line2.setSection_id(100);
        List<Line> mockLines = Arrays.asList(line1, line2);
        List<Line> mockParsedLines = Arrays.asList(line1, line2);

        // 准备mock行为
        when(lineMapper.selectBySectionId(100)).thenReturn(mockLines);
        when(lineService.StrToList(mockLines)).thenReturn(mockParsedLines);

        // 调用被测方法
        Result<List<Line>> result = lineController.selectBySectionId(100);

        // 验证结果
        assertTrue(result.isSuccess());
        assertEquals("查询成功", result.getMessage());
        assertEquals(2, result.getData().size());
        assertEquals(100, result.getData().get(0).getSection_id());
        assertEquals(100, result.getData().get(1).getSection_id());

        // 验证mock调用
        verify(lineMapper).selectBySectionId(100);
        verify(lineService).StrToList(mockLines);
    }
}
