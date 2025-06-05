package cn.microvideo.framework3.project.mapper;

import cn.microvideo.framework3.project.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventMapper {
    List<Event> selectEvents(@Param("event_id") Integer event_id,
                             @Param("car_client") String car_client,
                             @Param("line_id") Integer line_id,
                             @Param("camera_id") Integer camera_id);

    int addEvent(Event event);
}
