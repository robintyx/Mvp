package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Company;
import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.CompanyMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Resource
    private CompanyMapper companyMapper;

    @RequestMapping("/all")
    public Result<List<Company>> getAllCompanys() {
        List<Company> companyList = companyMapper.selectAll();
        return Result.success(companyList, "查询成功");
    }
}
