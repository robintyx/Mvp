package cn.microvideo.framework3.project.service.impl;

import cn.microvideo.framework3.project.entity.Line;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.microvideo.framework3.project.mapper.LineMapper;
import cn.microvideo.framework3.project.service.LineService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineServiceImpl implements LineService {
    @Resource
    private LineMapper lineMapper;

    @Override
    public List<Line> StrToList(List<Line> lines) {
        ObjectMapper objectMapper = new ObjectMapper();
        for (Line line : lines) {
            try {
                String coordJson = line.getCoordinates();
                line.setLine_spatial_data(objectMapper.readValue(coordJson, new TypeReference<List<List<Double>>>() {
                }));
            } catch (Exception e) {
                e.printStackTrace();
                // 也可以设置空数组或报错标记字段
            }
        }
        return lines;
    }

    @Override
    public String toWktLineString(List<List<Double>> coords) {
        StringBuilder sb = new StringBuilder("LINESTRING(");
        for (int i = 0; i < coords.size(); i++) {
            List<Double> point = coords.get(i);
            sb.append(point.get(0)).append(" ").append(point.get(1));
            if (i != coords.size() - 1) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public List<List<Double>> swapLatLng(List<List<Double>> original) {
        List<List<Double>> result = new ArrayList<>();
        for (List<Double> point : original) {
            // point.get(1): 纬度，point.get(0): 经度
            result.add(List.of(point.get(1), point.get(0)));
        }
        return result;
    }
}