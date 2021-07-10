package testlib.spi.impl;

import testlib.spi.ServerProvider;

public class MySQLServerProvider implements ServerProvider {

	@Override
	public String getServerHost() {
		return "8.8.8.8";
	}

	@Override
	public Integer getServerPort() {
		return 3306;
	}

}
