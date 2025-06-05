package cn.microvideo.framework3.project.service.impl;

import cn.microvideo.framework3.project.entity.Line;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LineServiceImplTest {

    @InjectMocks
    private LineServiceImpl lineService;

    @Test
    void testStrToListWithValidJson() {
        // Arrange
        List<Line> lines = new ArrayList<>();
        Line line = new Line();
        line.setCoordinates("[[1.0, 2.0], [3.0, 4.0]]");
        lines.add(line);

        // Act
        List<Line> result = lineService.StrToList(lines);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertNotNull(result.get(0).getLine_spatial_data());
        assertEquals(2, result.get(0).getLine_spatial_data().size());
        assertEquals(1.0, result.get(0).getLine_spatial_data().get(0).get(0));
        assertEquals(2.0, result.get(0).getLine_spatial_data().get(0).get(1));
    }

    @Test
    void testStrToListWithInvalidJson() {
        // Arrange
        List<Line> lines = new ArrayList<>();
        Line line = new Line();
        line.setCoordinates("invalid json");
        lines.add(line);

        // Act
        List<Line> result = lineService.StrToList(lines);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertNull(result.get(0).getLine_spatial_data());
    }

    @Test
    void testStrToListWithEmptyJson() {
        // Arrange
        List<Line> lines = new ArrayList<>();
        Line line = new Line();
        line.setCoordinates("");
        lines.add(line);

        // Act
        List<Line> result = lineService.StrToList(lines);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertNull(result.get(0).getLine_spatial_data());
    }

    @Test
    void testToWktLineStringWithMultiplePoints() {
        // Arrange
        List<List<Double>> coords = List.of(
                List.of(1.0, 2.0),
                List.of(3.0, 4.0),
                List.of(5.0, 6.0)
        );

        // Act
        String result = lineService.toWktLineString(coords);

        // Assert
        assertEquals("LINESTRING(1.0 2.0, 3.0 4.0, 5.0 6.0)", result);
    }

    @Test
    void testToWktLineStringWithSinglePoint() {
        // Arrange
        List<List<Double>> coords = List.of(
                List.of(1.0, 2.0)
        );

        // Act
        String result = lineService.toWktLineString(coords);

        // Assert
        assertEquals("LINESTRING(1.0 2.0)", result);
    }

    @Test
    void testToWktLineStringWithEmptyList() {
        // Arrange
        List<List<Double>> coords = new ArrayList<>();

        // Act
        String result = lineService.toWktLineString(coords);

        // Assert
        assertEquals("LINESTRING()", result);
    }

    @Test
    void testSwapLatLngWithMultiplePoints() {
        // Arrange
        List<List<Double>> original = List.of(
                List.of(1.0, 2.0),
                List.of(3.0, 4.0)
        );

        // Act
        List<List<Double>> result = lineService.swapLatLng(original);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(2.0, result.get(0).get(0));
        assertEquals(1.0, result.get(0).get(1));
        assertEquals(4.0, result.get(1).get(0));
        assertEquals(3.0, result.get(1).get(1));
    }

    @Test
    void testSwapLatLngWithSinglePoint() {
        // Arrange
        List<List<Double>> original = List.of(
                List.of(1.0, 2.0)
        );

        // Act
        List<List<Double>> result = lineService.swapLatLng(original);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2.0, result.get(0).get(0));
        assertEquals(1.0, result.get(0).get(1));
    }

    @Test
    void testSwapLatLngWithEmptyList() {
        // Arrange
        List<List<Double>> original = new ArrayList<>();

        // Act
        List<List<Double>> result = lineService.swapLatLng(original);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
