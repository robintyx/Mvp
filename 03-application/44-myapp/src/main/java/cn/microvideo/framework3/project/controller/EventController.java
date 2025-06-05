package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.Event;
import cn.microvideo.framework3.project.entity.Result;
import cn.microvideo.framework3.project.mapper.EventMapper;
import cn.microvideo.framework3.project.service.EventService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventService;
    @Resource
    private EventMapper eventMapper;

    @GetMapping("/{page}/{limit}")
    public Result<PageInfo<Event>> getEvent(
            @RequestParam(required = false) Integer event_id,
            @RequestParam(required = false) String car_client,
            @RequestParam(required = false) Integer line_id,
            @RequestParam(required = false) Integer camera_id,
            @PathVariable Integer page,
            @PathVariable Integer limit
    ) {
        PageInfo<Event> pageInfo = eventService.getEvents(event_id, car_client, line_id, camera_id, page, limit);
        if (pageInfo.getSize() == 0) {
            return Result.notFound("没有数据");
        }
        return Result.success(pageInfo, "查询成功");
    }


    @PostMapping
    public Result<String> addEvent(@RequestBody Event event) {
        int i = eventMapper.addEvent(event);
        if (i > 0) {
            return Result.success(null, "添加成功");
        }
        return Result.fail("添加失败");
    }
}