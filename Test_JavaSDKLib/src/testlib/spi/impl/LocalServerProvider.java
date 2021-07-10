package testlib.spi.impl;

import testlib.spi.ServerProvider;

public class LocalServerProvider implements ServerProvider {

	@Override
	public String getServerHost() {
		return "localhost";
	}

	@Override
	public Integer getServerPort() {
		return 80;
	}

}
