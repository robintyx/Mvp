package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.entity.Stake;
import cn.microvideo.framework3.project.mapper.StakeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

class StakeControllerTest {

    @Mock
    private StakeMapper stakeMapper;

    @InjectMocks
    private StakeController stakeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_shouldReturnNotFound_whenNoRecordsExist() {
        // Arrange
        int page = 1;
        int limit = 10;
        when(stakeMapper.findAll()).thenReturn(Collections.emptyList());

        // Act
        Result<PageInfo<Stake>> result = stakeController.findAll(page, limit);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(stakeMapper).findAll();
    }

    @Test
    void findAll_shouldReturnSuccessWithPageInfo_whenRecordsExist() {
        // Arrange
        int page = 1;
        int limit = 10;
        List<Stake> stakes = Arrays.asList(new Stake(), new Stake());
        when(stakeMapper.findAll()).thenReturn(stakes);

        // Act
        Result<PageInfo<Stake>> result = stakeController.findAll(page, limit);

        // Assert
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.isSuccess());
        assertEquals(2, result.getData().getList().size());
        verify(stakeMapper).findAll();
    }

    @Test
    void getStakeById_shouldReturnNotFound_whenStakeNotExist() {
        // Arrange
        Integer stakeId = 1;
        when(stakeMapper.getStakeById(stakeId)).thenReturn(null);

        // Act
        Result<Stake> result = stakeController.getStakeById(stakeId);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(stakeMapper).getStakeById(stakeId);
    }

    @Test
    void getStakeById_shouldReturnSuccessWithStake_whenStakeExist() {
        // Arrange
        Integer stakeId = 1;
        Stake expectedStake = new Stake();
        expectedStake.setStake_id(stakeId);
        when(stakeMapper.getStakeById(stakeId)).thenReturn(expectedStake);

        // Act
        Result<Stake> result = stakeController.getStakeById(stakeId);

        // Assert
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.isSuccess());
        assertEquals(stakeId, result.getData().getStake_id());
        verify(stakeMapper).getStakeById(stakeId);
    }

    @Test
    void addStake_shouldReturnSuccess_whenInsertSucceed() {
        // Arrange
        Stake stake = new Stake();
        when(stakeMapper.insertStake(stake)).thenReturn(1);

        // Act
        Result<String> result = stakeController.addStake(stake);

        // Assert
        assertEquals("添加成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(stakeMapper).insertStake(stake);
    }

    @Test
    void addStake_shouldReturnFail_whenInsertFailed() {
        // Arrange
        Stake stake = new Stake();
        when(stakeMapper.insertStake(stake)).thenReturn(0);

        // Act
        Result<String> result = stakeController.addStake(stake);

        // Assert
        assertEquals("添加失败", result.getMessage());
        assertFalse(result.isSuccess());
        verify(stakeMapper).insertStake(stake);
    }

    @Test
    void updateStake_shouldReturnSuccess_whenUpdateSucceed() {
        // Arrange
        Stake stake = new Stake();
        when(stakeMapper.updateStake(stake)).thenReturn(1);

        // Act
        Result<String> result = stakeController.updateStake(stake);

        // Assert
        assertEquals("修改成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(stakeMapper).updateStake(stake);
    }

    @Test
    void updateStake_shouldReturnFail_whenUpdateFailed() {
        // Arrange
        Stake stake = new Stake();
        when(stakeMapper.updateStake(stake)).thenReturn(0);

        // Act
        Result<String> result = stakeController.updateStake(stake);

        // Assert
        assertEquals("修改失败", result.getMessage());
        assertFalse(result.isSuccess());
        verify(stakeMapper).updateStake(stake);
    }

    @Test
    void delStakeById_shouldReturnSuccess_whenDeleteSucceed() {
        // Arrange
        Integer stakeId = 1;
        when(stakeMapper.deleteStakeById(stakeId)).thenReturn(1);

        // Act
        Result<String> result = stakeController.delStakeById(stakeId);

        // Assert
        assertEquals("删除成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(stakeMapper).deleteStakeById(stakeId);
    }

    @Test
    void delStakeById_shouldReturnNotFound_whenDeleteFailed() {
        // Arrange
        Integer stakeId = 1;
        when(stakeMapper.deleteStakeById(stakeId)).thenReturn(0);

        // Act
        Result<String> result = stakeController.delStakeById(stakeId);

        // Assert
        assertEquals("删除失败", result.getMessage());
        assertFalse(result.isSuccess());
        verify(stakeMapper).deleteStakeById(stakeId);
    }
}
