package secret.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanUtilsTest {

    @Test
    void repeat() {
        StringBuilder stringBuilder=new StringBuilder();
        assertEquals("*****",BeanUtils.repeat(stringBuilder, sb->sb.append("*"), 5).toString());

    }
}