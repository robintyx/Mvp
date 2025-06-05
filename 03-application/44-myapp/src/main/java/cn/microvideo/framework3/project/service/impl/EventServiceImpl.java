package cn.microvideo.framework3.project.service.impl;

import cn.microvideo.framework3.project.entity.Event;
import cn.microvideo.framework3.project.mapper.EventMapper;
import cn.microvideo.framework3.project.service.EventService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Resource
    private EventMapper eventMapper;

    @Override
    public PageInfo<Event> getEvents(Integer event_id,
                                     String car_client,
                                     Integer line_id,
                                     Integer camera_id,
                                     Integer page,
                                     Integer limit) {
        // 添加参数合法性校验
        if (page == null || page <= 0) {
            throw new IllegalArgumentException("页码必须为正整数");
        }
        if (limit == null || limit <= 0) {
            throw new IllegalArgumentException("每页数量必须为正整数");
        }
        PageHelper.startPage(page, limit);
        List<Event> eventList = eventMapper.selectEvents(event_id, car_client, line_id, camera_id);
        return new PageInfo<>(eventList);
    }
}