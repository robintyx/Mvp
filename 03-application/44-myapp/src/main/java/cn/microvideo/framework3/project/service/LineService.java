package cn.microvideo.framework3.project.service;

import cn.microvideo.framework3.project.entity.Line;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LineService {
    List<Line> StrToList(List<Line> lines);

    String toWktLineString(List<List<Double>> coords);

    List<List<Double>> swapLatLng(List<List<Double>> original);
}