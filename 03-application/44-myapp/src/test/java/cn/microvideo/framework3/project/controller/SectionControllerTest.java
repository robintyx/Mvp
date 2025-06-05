package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.entity.Section;
import cn.microvideo.framework3.project.mapper.SectionMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SectionControllerTest {

    @Mock
    private SectionMapper sectionMapper;

    @InjectMocks
    private SectionController sectionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * 测试正常获取所有部门的情况
     */
    @Test
    void getAllSections_shouldReturnSections_whenDataExists() {
        Section section1 = new Section();
        section1.setSection_id(1);
        section1.setSection_name("研发部");
        Section section2 = new Section();
        section2.setSection_id(2);
        section2.setSection_name("市场部");

        // Arrange
        List<Section> expectedSections = Arrays.asList(
                section2, section2
        );
        when(sectionMapper.selectAll()).thenReturn(expectedSections);

        // Act
        Result<List<Section>> result = sectionController.getAllSections();

        // Assert
        assertNotNull(result);
        assertEquals("查询成功", result.getMessage());
        assertEquals(expectedSections, result.getData());
        verify(sectionMapper, times(1)).selectAll();
    }

    /**
     * 测试获取空部门列表的情况
     */
    @Test
    void getAllSections_shouldReturnEmptyList_whenNoData() {
        // Arrange
        when(sectionMapper.selectAll()).thenReturn(Collections.emptyList());

        // Act
        Result<List<Section>> result = sectionController.getAllSections();

        // Assert
        assertNotNull(result);
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.getData().isEmpty());
        verify(sectionMapper, times(1)).selectAll();
    }

    /**
     * 测试Mapper抛出异常的情况
     */
    @Test
    void getAllSections_shouldThrowException_whenMapperFails() {
        // Arrange
        when(sectionMapper.selectAll()).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> sectionController.getAllSections());
        verify(sectionMapper, times(1)).selectAll();
    }
}
