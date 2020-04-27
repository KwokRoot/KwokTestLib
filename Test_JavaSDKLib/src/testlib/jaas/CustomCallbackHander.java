package testlib.jaas;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

public class CustomCallbackHander implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException {

		NameCallback nameCallback = (NameCallback) callbacks[0];
		PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];

		// 设置用户名与密码
		nameCallback.setName("admin");
		passwordCallback.setPassword("password".toCharArray());

	}

}
