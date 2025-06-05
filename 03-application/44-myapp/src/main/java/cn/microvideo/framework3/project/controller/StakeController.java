package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.entity.Stake;
import cn.microvideo.framework3.project.mapper.StakeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stake")
public class StakeController {
    @Resource
    private StakeMapper stakeMapper;

    @GetMapping("/list/{page}/{limit}")
    public Result<PageInfo<Stake>> findAll(@PathVariable int page, @PathVariable int limit) {
        PageHelper.startPage(page, limit);
        List<Stake> stakes = stakeMapper.findAll();
        if (stakes.isEmpty()) {
            return Result.notFound("记录不存在");
        }
        PageInfo<Stake> pageInfo = PageInfo.of(stakes);
        return Result.success(pageInfo, "查询成功");
    }

    @GetMapping("/{stake_id}")
    public Result<Stake> getStakeById(@PathVariable Integer stake_id) {
        Stake stake = stakeMapper.getStakeById(stake_id);
        if (stake == null) {
            return Result.notFound("记录不存在");
        }
        return Result.success(stake, "查询成功");
    }

    @PostMapping
    public Result<String> addStake(@RequestBody Stake stake) {
        int i = stakeMapper.insertStake(stake);
        if (i > 0) {
            return Result.success(null, "添加成功");
        }
        return Result.fail("添加失败");
    }

    @PostMapping("/update")
    public Result<String> updateStake(@RequestBody Stake stake) {
        int i = stakeMapper.updateStake(stake);
        if (i > 0) {
            return Result.success(null, "修改成功");
        }
        return Result.fail("修改失败");
    }

    @GetMapping("/del/{stake_id}")
    public Result<String> delStakeById(@PathVariable Integer stake_id) {
        int i = stakeMapper.deleteStakeById(stake_id);
        if (i > 0) {
            return Result.success(null, "删除成功");
        }
        return Result.notFound("删除失败");
    }
}
