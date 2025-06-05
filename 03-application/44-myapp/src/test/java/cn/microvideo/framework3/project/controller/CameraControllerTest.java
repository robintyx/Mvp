package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Camera;
import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.CameraMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CameraControllerTest {

    @Mock
    private CameraMapper cameraMapper;

    @InjectMocks
    private CameraController cameraController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCameraByLineId_shouldReturnNotFoundWhenNoCameras() {
        // Arrange
        int lineId = 1;
        int page = 1;
        int limit = 10;
        when(cameraMapper.selectByLineId(lineId)).thenReturn(new ArrayList<>());

        // Act
        Result<PageInfo<Camera>> result = cameraController.getCameraByLineId(lineId, page, limit);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(cameraMapper).selectByLineId(lineId);
    }

    @Test
    void getCameraByLineId_shouldReturnPageInfoWhenCamerasExist() {
        // Arrange
        int lineId = 1;
        int page = 1;
        int limit = 10;
        List<Camera> cameras = List.of(new Camera(), new Camera());
        when(cameraMapper.selectByLineId(lineId)).thenReturn(cameras);

        // Act
        Result<PageInfo<Camera>> result = cameraController.getCameraByLineId(lineId, page, limit);

        // Assert
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.isSuccess());
        assertEquals(2, result.getData().getList().size());
        verify(cameraMapper).selectByLineId(lineId);
    }

    @Test
    void getCameraById_shouldReturnNotFoundWhenCameraNotExist() {
        // Arrange
        int cameraId = 1;
        when(cameraMapper.selectByCameraId(cameraId)).thenReturn(null);

        // Act
        Result<Camera> result = cameraController.getCameraById(cameraId);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(cameraMapper).selectByCameraId(cameraId);
    }

    @Test
    void getCameraById_shouldReturnCameraWhenExist() {
        // Arrange
        int cameraId = 1;
        Camera expectedCamera = new Camera();
        expectedCamera.setCamera_id(cameraId);
        when(cameraMapper.selectByCameraId(cameraId)).thenReturn(expectedCamera);

        // Act
        Result<Camera> result = cameraController.getCameraById(cameraId);

        // Assert
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.isSuccess());
        assertEquals(cameraId, result.getData().getCamera_id());
        verify(cameraMapper).selectByCameraId(cameraId);
    }

    @Test
    void getCameraList_shouldReturnNotFoundWhenNoCameras() {
        // Arrange
        int page = 1;
        int limit = 10;
        when(cameraMapper.selectAll()).thenReturn(new ArrayList<>());

        // Act
        Result<PageInfo<Camera>> result = cameraController.getCameraList(page, limit);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(cameraMapper).selectAll();
    }

    @Test
    void getCameraList_shouldReturnPageInfoWhenCamerasExist() {
        // Arrange
        int page = 1;
        int limit = 10;
        List<Camera> cameras = List.of(new Camera(), new Camera());
        when(cameraMapper.selectAll()).thenReturn(cameras);

        // Act
        Result<PageInfo<Camera>> result = cameraController.getCameraList(page, limit);

        // Assert
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.isSuccess());
        assertEquals(2, result.getData().getList().size());
        verify(cameraMapper).selectAll();
    }

    @Test
    void delCameraById_shouldReturnNotFoundWhenCameraNotExist() {
        // Arrange
        int cameraId = 1;
        when(cameraMapper.deleteByCameraId(cameraId)).thenReturn(0);

        // Act
        Result<String> result = cameraController.delCameraById(cameraId);

        // Assert
        assertEquals("记录不存在", result.getMessage());
        assertFalse(result.isSuccess());
        verify(cameraMapper).deleteByCameraId(cameraId);
    }

    @Test
    void delCameraById_shouldReturnSuccessWhenDeleted() {
        // Arrange
        int cameraId = 1;
        when(cameraMapper.deleteByCameraId(cameraId)).thenReturn(1);

        // Act
        Result<String> result = cameraController.delCameraById(cameraId);

        // Assert
        assertEquals("删除成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(cameraMapper).deleteByCameraId(cameraId);
    }

    @Test
    void addCamera_shouldReturnNotFoundWhenInsertFailed() {
        // Arrange
        Camera camera = new Camera();
        when(cameraMapper.insertCamera(camera)).thenReturn(0);

        // Act
        Result<String> result = cameraController.addCamera(camera);

        // Assert
        assertEquals("添加失败", result.getMessage());
        assertFalse(result.isSuccess());
        verify(cameraMapper).insertCamera(camera);
    }

    @Test
    void addCamera_shouldReturnSuccessWhenInserted() {
        // Arrange
        Camera camera = new Camera();
        when(cameraMapper.insertCamera(camera)).thenReturn(1);

        // Act
        Result<String> result = cameraController.addCamera(camera);

        // Assert
        assertEquals("添加成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(cameraMapper).insertCamera(camera);
    }

    @Test
    void updateCamera_shouldReturnNotFoundWhenUpdateFailed() {
        // Arrange
        Camera camera = new Camera();
        when(cameraMapper.updateCamera(camera)).thenReturn(0);

        // Act
        Result<String> result = cameraController.updateCamera(camera);

        // Assert
        assertEquals("更新失败", result.getMessage());
        assertFalse(result.isSuccess());
        verify(cameraMapper).updateCamera(camera);
    }

    @Test
    void updateCamera_shouldReturnSuccessWhenUpdated() {
        // Arrange
        Camera camera = new Camera();
        when(cameraMapper.updateCamera(camera)).thenReturn(1);

        // Act
        Result<String> result = cameraController.updateCamera(camera);

        // Assert
        assertEquals("更新成功", result.getMessage());
        assertTrue(result.isSuccess());
        verify(cameraMapper).updateCamera(camera);
    }

    @Test
    void selectAll_shouldReturnEmptyListWhenNoCameras() {
        // Arrange
        when(cameraMapper.selectAll()).thenReturn(new ArrayList<>());

        // Act
        Result<List<Camera>> result = cameraController.selectAll();

        // Assert
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.isSuccess());
        assertTrue(result.getData().isEmpty());
        verify(cameraMapper).selectAll();
    }

    @Test
    void selectAll_shouldReturnCameraListWhenCamerasExist() {
        // Arrange
        List<Camera> cameras = List.of(new Camera(), new Camera());
        when(cameraMapper.selectAll()).thenReturn(cameras);

        // Act
        Result<List<Camera>> result = cameraController.selectAll();

        // Assert
        assertEquals("查询成功", result.getMessage());
        assertTrue(result.isSuccess());
        assertEquals(2, result.getData().size());
        verify(cameraMapper).selectAll();
    }
}
