package TEST;

import User.ResetPassword;
import User.UserLoginBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginBaseTests {
    @BeforeEach
    void setup() throws Exception {
        UserLoginBase.register("test1", "old", "123456789", "user@example.com", "");
        ResetPassword.newPassword("test1", "new");
    }

   @Test
    void test1() {
       assertEquals("new", UserLoginBase.getUserHashMap().get("test1"));
   }

    @Test
    void test2() {
        assertTrue(UserLoginBase.login("test1", "new"));
    }

    @Test
    void test3() {
        assertFalse(UserLoginBase.login("test1", "old"));
    }

    @Test
    void test4() {
        assertFalse(UserLoginBase.login("test1", "1234"));
    }

    @Test
    void test5() {
        assertFalse(UserLoginBase.login("test1", null));
    }

    @Test
    void test6() {
        assertFalse(UserLoginBase.login(null, "old"));
    }

    @Test
    void test7() {
        ResetPassword.newPassword("test1", null);
        assertFalse(UserLoginBase.login("test1", null));
    }








}
