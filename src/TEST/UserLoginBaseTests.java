package TEST;

import User.ResetPassword;
import User.UserLoginBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginBaseTests {
    @BeforeEach
    void setup() {
        UserLoginBase.register("test1", "old", "123456789", "user@example.com", "");
        ResetPassword.newPassword("test1", "new");
    }

   @Test
    void passwordChanged() {
       assertEquals("new", UserLoginBase.getUserHashMap().get("test1"));
   }

    @Test
    void newPasswordValid() {
        assertTrue(UserLoginBase.login("test1", "new"));
    }

    @Test
    void oldPasswordInvalid() {
        assertFalse(UserLoginBase.login("test1", "old"));
    }

    @Test
    void incorrectPasswordInvalid() {
        assertFalse(UserLoginBase.login("test1", "1234"));
    }

    @Test
    void incorrectParameter1Given() {
        assertFalse(UserLoginBase.login("test1", null));
    }

    @Test
    void incorrectParameter2Given() {
        assertFalse(UserLoginBase.login(null, "old"));
    }

    @Test
    void incorrectPasswordSet() {
        ResetPassword.newPassword("test1", null);
        assertTrue(UserLoginBase.login("test1", "new"));
    }








}
