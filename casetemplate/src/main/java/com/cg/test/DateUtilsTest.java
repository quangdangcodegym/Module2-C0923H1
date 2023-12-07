package com.cg.test;

import com.cg.exception.ParseDateException;
import com.cg.utils.DateUtils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateUtilsTest {

    @Test
    @DisplayName("Test ham parse 2023-10-20")
    public void parseStringToLocalDate(){
        String str = "aaa2023-10-20";

        assertThrows(ParseDateException.class, ()->{
            DateUtils.parse(str);
        });

    }
    @Test
    public void testMethod() {
        // Đoạn mã bạn muốn kiểm tra ngoại lệ
        // Ví dụ: Một phương thức ném ra ArithmeticException khi chia cho 0
        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        });
    }
}
