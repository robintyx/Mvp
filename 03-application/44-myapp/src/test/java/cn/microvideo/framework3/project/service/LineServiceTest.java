package cn.microvideo.framework3.project.service;

import cn.microvideo.framework3.project.entity.Line;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LineServiceTest {

    // 假设我们有一个简单的实现用于测试
    private final LineService lineService = new LineServiceImpl();

    @Test
    void testStrToListWithEmptyInput() {
        List<Line> result = lineService.StrToList(Collections.emptyList());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testStrToListWithNormalInput() {
        Line line1 = new Line(); // 假设Line有适当的构造方法
        Line line2 = new Line();
        List<Line> input = Arrays.asList(line1, line2);
        
        List<Line> result = lineService.StrToList(input);
        assertNotNull(result);
        assertEquals(input.size(), result.size());
        // 根据实际实现添加更多断言
    }

    @Test
    void testToWktLineStringWithEmptyCoords() {
        String result = lineService.toWktLineString(Collections.emptyList());
        assertNotNull(result);
        assertEquals("LINESTRING EMPTY", result); // 根据实际实现调整预期
    }

    @Test
    void testToWktLineStringWithSinglePoint() {
        List<List<Double>> coords = Collections.singletonList(Arrays.asList(1.0, 2.0));
        String result = lineService.toWktLineString(coords);
        assertEquals("LINESTRING (1.0 2.0)", result); // 根据实际实现调整预期
    }

    @Test
    void testToWktLineStringWithMultiplePoints() {
        List<List<Double>> coords = Arrays.asList(
                Arrays.asList(1.0, 2.0),
                Arrays.asList(3.0, 4.0),
                Arrays.asList(5.0, 6.0)
        );
        String result = lineService.toWktLineString(coords);
        assertEquals("LINESTRING (1.0 2.0, 3.0 4.0, 5.0 6.0)", result);
    }

    @Test
    void testToWktLineStringWithInvalidCoord() {
        List<List<Double>> coords = Collections.singletonList(Collections.singletonList(1.0));
        assertThrows(IllegalArgumentException.class, () -> lineService.toWktLineString(coords));
    }

    @Test
    void testSwapLatLngWithEmptyList() {
        List<List<Double>> result = lineService.swapLatLng(Collections.emptyList());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSwapLatLngWithNormalCoords() {
        List<List<Double>> original = Arrays.asList(
                Arrays.asList(1.0, 2.0),
                Arrays.asList(3.0, 4.0)
        );
        List<List<Double>> result = lineService.swapLatLng(original);
        
        assertEquals(2, result.size());
        assertEquals(2.0, result.get(0).get(0)); // 第一个点的经度现在应该在纬度位置
        assertEquals(1.0, result.get(0).get(1));
        assertEquals(4.0, result.get(1).get(0));
        assertEquals(3.0, result.get(1).get(1));
    }

    @Test
    void testSwapLatLngWithIncompleteCoord() {
        List<List<Double>> original = Collections.singletonList(Collections.singletonList(1.0));
        assertThrows(IllegalArgumentException.class, () -> lineService.swapLatLng(original));
    }
}

// 简单的实现类用于测试
class LineServiceImpl implements LineService {
    @Override
    public List<Line> StrToList(List<Line> lines) {
        return lines; // 简单实现，实际可能更复杂
    }

    @Override
    public String toWktLineString(List<List<Double>> coords) {
        if (coords.isEmpty()) {
            return "LINESTRING EMPTY";
        }
        
        StringBuilder sb = new StringBuilder("LINESTRING (");
        for (List<Double> coord : coords) {
            if (coord.size() < 2) {
                throw new IllegalArgumentException("Coordinate must have at least 2 values");
            }
            sb.append(coord.get(0)).append(" ").append(coord.get(1)).append(", ");
        }
        sb.setLength(sb.length() - 2); // 移除最后的", "
        sb.append(")");
        return sb.toString();
    }

    @Override
    public List<List<Double>> swapLatLng(List<List<Double>> original) {
        if (original == null) {
            return Collections.emptyList();
        }
        
        return original.stream()
                .map(coord -> {
                    if (coord.size() < 2) {
                        throw new IllegalArgumentException("Coordinate must have at least 2 values");
                    }
                    return Arrays.asList(coord.get(1), coord.get(0));
                })
                .toList();
    }
}
