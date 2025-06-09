package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.LineMapper;
import cn.microvideo.framework3.project.service.LineService;
import cn.microvideo.framework3.project.entity.Line;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line")
public class LineController {
    @Resource
    private LineMapper lineMapper;
    @Resource
    private LineService lineService;

    @GetMapping("/list/{page}/{limit}")
    public Result<PageInfo<Line>> findAll(@PathVariable int page, @PathVariable int limit) {
        PageHelper.startPage(page, limit);
        List<Line> lines = lineMapper.selectAll();

        if (lines.isEmpty()) {
            return Result.notFound("记录不存在");
        }

        List<Line> parsedLines = lineService.StrToList(lines);
        PageInfo<Line> pageInfo = new PageInfo<>(parsedLines);
        return Result.success(pageInfo,  "查询成功");
    }

    @GetMapping("/{id}")
    public Result<Line> getLineById(@PathVariable Integer id) {
        List<Line> lines = lineMapper.selectById(id);
        if (lines.isEmpty()) {
            return Result.notFound("记录不存在");
        }
        Line parsedLines = lineService.StrToList(lines).get(0);
        return Result.success(parsedLines,  "查询成功");
    }

    @GetMapping("/del/{id}")
    public Result<String> delLineById(@PathVariable Integer id) {
        int result = lineMapper.deleteById(id);
        if (result == 0) {
            return Result.notFound("记录不存在");
        }
        return Result.success(null,"删除成功");
    }

    @PostMapping("/add")
    public Result<String> addLine(@RequestBody Line line) {
        List<List<Double>> arr = lineService.swapLatLng(line.getLine_spatial_data());
        String wkt = lineService.toWktLineString(arr);
        line.setWkt(wkt);
        int result = lineMapper.insertLine(line);
        if (result == 0) {
            return Result.fail("添加失败");
        }
        return Result.success(null, "添加成功");
    }

    @PostMapping("/update")
    public Result<String> updateLine(@RequestBody Line line) {
        System.out.println(line);
        System.out.println(line.getLine_spatial_data());
        List<List<Double>> arr = lineService.swapLatLng(line.getLine_spatial_data());
        String wkt = lineService.toWktLineString(arr);
        line.setWkt(wkt);
        System.out.println(line);
        int result = lineMapper.updateLine(line);
        if (result == 0) {
            return Result.fail("更新失败");
        }
        return Result.success(null, "更新成功");
    }

    @GetMapping("/all")
    public Result<List<Line>> selectAll() {
        List<Line> lines = lineMapper.selectAll();
        List<Line> parsedLines = lineService.StrToList(lines);
        return Result.success(parsedLines, "查询成功");
    }

    @GetMapping("/section/{section_id}")
    public Result<List<Line>> selectBySectionId(@PathVariable Integer section_id) {
        List<Line> lines = lineMapper.selectBySectionId(section_id);
        List<Line> parsedLines = lineService.StrToList(lines);
        return Result.success(parsedLines, "查询成功");
    }
}