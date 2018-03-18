package com.rcp.mgnt.service;

import java.util.List;

import com.rcp.mgnt.model.RcpInfoTO;

public interface RcpService {
	String save(RcpInfoTO rcpInfoTO);

	List<RcpInfoTO> get();
	
	RcpInfoTO get(String id);
}
