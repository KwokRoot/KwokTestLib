package testlib.spi.impl;

import testlib.spi.ServerProvider;

public class RedisServerProvider implements ServerProvider {

	@Override
	public String getServerHost() {
		return "127.0.0.1";
	}

	@Override
	public Integer getServerPort() {
		return 6379;
	}

}
