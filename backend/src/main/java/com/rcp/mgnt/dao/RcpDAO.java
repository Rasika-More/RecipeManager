package com.rcp.mgnt.dao;

import java.util.List;

import com.rcp.mgnt.model.RcpInfoTO;

public interface RcpDAO {
	Integer saveRcpInfo(RcpInfoTO rcpInfoTO);

	List<RcpInfoTO> getRcpInfo();
	
	RcpInfoTO getRcpInfo(String id);

}
