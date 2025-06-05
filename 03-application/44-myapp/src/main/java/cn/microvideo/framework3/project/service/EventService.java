package cn.microvideo.framework3.project.service;

import cn.microvideo.framework3.project.entity.Event;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    PageInfo<Event> getEvents(Integer event_id,
                              String car_client,
                              Integer line_id,
                              Integer camera_id,
                              Integer page,
                              Integer limit);
}
