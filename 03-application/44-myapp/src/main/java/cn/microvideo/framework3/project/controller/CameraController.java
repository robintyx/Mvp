package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Camera;
import cn.microvideo.framework3.project.entity.CameraType;
import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.CameraMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera")
public class CameraController {
    @Resource
    private CameraMapper cameraMapper;

    @GetMapping("/line/{line_id}/{page}/{limit}")
    public Result<PageInfo<Camera>> getCameraByLineId(@PathVariable Integer line_id, @PathVariable int page, @PathVariable int limit) {
        PageHelper.startPage(page, limit);
        List<Camera> cameras = cameraMapper.selectByLineId(line_id);

        if (cameras.isEmpty()) {
            return Result.notFound("记录不存在");
        }

        PageInfo<Camera> pageInfo = new PageInfo<>(cameras);
        return Result.success(pageInfo, "查询成功");
    }

    @GetMapping("/{camera_id}")
    public Result<Camera> getCameraById(@PathVariable Integer camera_id) {
        Camera camera = cameraMapper.selectByCameraId(camera_id);
        if (camera == null) {
            return Result.notFound("记录不存在");
        }
        return Result.success(camera, "查询成功");
    }

    @GetMapping("/list/{page}/{limit}")
    public Result<PageInfo<Camera>> getCameraList(@PathVariable int page, @PathVariable int limit) {
        PageHelper.startPage(page, limit);
        List<Camera> cameras = cameraMapper.selectAll();

        if (cameras.isEmpty()) {
            return Result.notFound("记录不存在");
        }

        PageInfo<Camera> pageInfo = new PageInfo<>(cameras);
        return Result.success(pageInfo, "查询成功");
    }

    @GetMapping("/del/{camera_id}")
    public Result<String> delCameraById(@PathVariable Integer camera_id) {
        int result = cameraMapper.deleteByCameraId(camera_id);
        if (result == 0) {
            return Result.notFound("记录不存在");
        }
        return Result.success(null, "删除成功");
    }

    @PostMapping
    public Result<String> addCamera(@RequestBody Camera camera) {
        int result = cameraMapper.insertCamera(camera);
        if (result == 0) {
            return Result.notFound("添加失败");
        }
        return Result.success(null, "添加成功");
    }

    @PostMapping("/update")
    public Result<String> updateCamera(@RequestBody Camera camera) {
        int result = cameraMapper.updateCamera(camera);
        if (result == 0) {
            return Result.notFound("更新失败");
        }
        return Result.success(null, "更新成功");
    }

    @GetMapping("/all")
    public Result<List<Camera>> selectAll() {
        return Result.success(cameraMapper.selectAll(), "查询成功");
    }

    @GetMapping("/type")
    public Result<List<CameraType>> selectAllCameraType() {
        return Result.success(cameraMapper.selectAllCameraType(), "查询成功");
    }
}