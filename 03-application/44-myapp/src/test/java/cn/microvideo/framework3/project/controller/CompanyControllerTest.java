package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Company;
import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.CompanyMapper;
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

class CompanyControllerTest {

    @Mock
    private CompanyMapper companyMapper;

    @InjectMocks
    private CompanyController companyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * 测试正常情况 - 返回非空公司列表
     */
    @Test
    void getAllCompanys_shouldReturnCompanyList_whenDataExists() {
        Company company1 = new Company();
        company1.setCompany_id(1);
        company1.setCompany_name("Company A");
        Company company2 = new Company();
        company2.setCompany_id(2);
        company2.setCompany_name("Company B");
        // Arrange
        List<Company> mockCompanies = Arrays.asList(company1, company2);
        
        when(companyMapper.selectAll()).thenReturn(mockCompanies);

        // Act
        Result<List<Company>> result = companyController.getAllCompanys();

        // Assert
        assertNotNull(result);
        assertEquals("查询成功", result.getMessage());
        assertEquals(2, result.getData().size());
        assertEquals(mockCompanies, result.getData());
        
        verify(companyMapper, times(1)).selectAll();
    }

    /**
     * 测试空列表情况 - 返回空列表
     */
    @Test
    void getAllCompanys_shouldReturnEmptyList_whenNoData() {
        // Arrange
        when(companyMapper.selectAll()).thenReturn(Collections.emptyList());

        // Act
        Result<List<Company>> result = companyController.getAllCompanys();

        // Assert
        assertNotNull(result);
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.getData().isEmpty());
        
        verify(companyMapper, times(1)).selectAll();
    }

    /**
     * 测试异常情况 - 数据库访问异常
     */
    @Test
    void getAllCompanys_shouldThrowException_whenDatabaseError() {
        // Arrange
        when(companyMapper.selectAll()).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> companyController.getAllCompanys());
        
        verify(companyMapper, times(1)).selectAll();
    }
}
