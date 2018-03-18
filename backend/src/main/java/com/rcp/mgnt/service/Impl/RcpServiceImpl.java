package com.rcp.mgnt.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcp.mgnt.dao.RcpDAO;
import com.rcp.mgnt.model.RcpInfoTO;
import com.rcp.mgnt.service.RcpService;

@Service("RcpService")
public class RcpServiceImpl implements RcpService {

	@Autowired
	private RcpDAO rcpDAO;

	public String save(RcpInfoTO rcpInfoTO) {
		String str = null;
		rcpInfoTO.setId(UUID.randomUUID().toString());

		if (rcpDAO.saveRcpInfo(rcpInfoTO) == 1) {
			str = "Successfully recipe Info Inserted";
		}
		return str;
	}

	public List<RcpInfoTO> get() {

		return rcpDAO.getRcpInfo();
	}

	public RcpInfoTO get(String id) {
		return rcpDAO.getRcpInfo(id);
	}

}
