package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.entity.Section;
import cn.microvideo.framework3.project.mapper.SectionMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Resource
    SectionMapper SectionMapper;

    @GetMapping("/all")
    public Result<List<Section>> getAllSections() {
        List<Section> sections = SectionMapper.selectAll();
        return Result.success(sections, "查询成功");
    }
}
