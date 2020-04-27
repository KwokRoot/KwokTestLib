package testlib.jaas;

import java.security.Principal;
import java.util.Iterator;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class CustomLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler callbackHandler;
	private boolean success = false;
	private String user;
	private String password;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {

		this.subject = subject;
		this.callbackHandler = callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {

		NameCallback nameCallback = new NameCallback("请输入用户名");
		PasswordCallback passwordCallback = new PasswordCallback("请输入密码", true);

		Callback[] callbacks = new Callback[] { nameCallback, passwordCallback };
		try {
			// 执行回调，回调过程中获取用户名与密码
			callbackHandler.handle(callbacks);
			// 得到用户名与密码
			user = nameCallback.getName();
			password = new String(passwordCallback.getPassword());
		} catch (Exception e) {
			success = false;
			throw new FailedLoginException("用户名或密码获取失败");
		}
		// 为简单起见认证条件写死
		if ("admin".equals(user) && "password".equals(password)) {
			success = true;// 认证成功
		}
		return true;
	}

	@Override
	public boolean commit() throws LoginException {
		if (!success) {
			return false;
		} else {
			// 如果认证成功则得subject中添加一个Principal对象
			// 这样某身份用户就认证通过并登录了该应用，即表明了谁在执行该程序
			this.subject.getPrincipals().add(new CustomPrincipal(user));
			return true;
		}
	}

	@Override
	public boolean abort() throws LoginException {
		logout();
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		// 退出时将相应的Principal对象从subject中移除
		Iterator<Principal> iter = subject.getPrincipals().iterator();
		while (iter.hasNext()) {
			Principal principal = iter.next();
			if (principal instanceof CustomPrincipal) {
				if (principal.getName().equals(user)) {
					iter.remove();
					break;
				}
			}
		}
		return true;
	}

}
