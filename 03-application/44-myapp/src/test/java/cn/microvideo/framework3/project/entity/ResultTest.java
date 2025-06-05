package cn.microvideo.framework3.project.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void testSuccessResult() {
        String testData = "Test Data";
        Result<String> result = Result.success(testData, "Success message");

        assertEquals(200, result.getCode());
        assertEquals("Success message", result.getMessage());
        assertEquals("Test Data", result.getData());
        assertTrue(result.isSuccess());
    }

    @Test
    void testFailResult() {
        Result<Void> result = Result.fail("Something went wrong");

        assertEquals(500, result.getCode());
        assertEquals("Something went wrong", result.getMessage());
        assertNull(result.getData());
        assertFalse(result.isSuccess());
    }

    @Test
    void testNotFoundResult() {
        Result<Object> result = Result.notFound("Data not found");

        assertEquals(404, result.getCode());
        assertEquals("Data not found", result.getMessage());
        assertNull(result.getData());
        assertFalse(result.isSuccess());
    }

    @Test
    void testIsSuccessTrueAndFalse() {
        Result<String> result = new Result<>();
        result.setCode(200);
        assertTrue(result.isSuccess());

        result.setCode(500);
        assertFalse(result.isSuccess());
    }

    @Test
    void testGenericSupport() {
        Result<Integer> intResult = Result.success(123, "OK");
        assertEquals(123, intResult.getData());

        Result<Boolean> boolResult = Result.success(true, "All good");
        assertTrue(boolResult.getData());
    }
}
