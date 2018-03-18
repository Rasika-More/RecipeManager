package com.rcp.mgnt.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rcp.mgnt.dao.RcpDAO;
import com.rcp.mgnt.model.RcpInfoTO;

@Repository("RcpDAO")
public class RcpDAOImpl implements RcpDAO {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Integer saveRcpInfo(RcpInfoTO rcpInfoTO) {
		Integer count = 0;
		String sql = "insert into RECIPE_DATA values(?,?,?,?,?,?)";

		count = jdbcTemplate.update(
				sql,
				new Object[] { rcpInfoTO.getId(), rcpInfoTO.getName(), rcpInfoTO.getIngredient_1(),
						rcpInfoTO.getIngredient_2(), rcpInfoTO.getIngredient_3(), rcpInfoTO.getIngredient_4() });
		return count;
	}

	public List<RcpInfoTO> getRcpInfo() {

		String sql = "select * from RECIPE_DATA ";

		List<RcpInfoTO> rcpInfoTOs = jdbcTemplate.query(sql, new RcpMapper());
		return rcpInfoTOs;
	}

	public RcpInfoTO getRcpInfo(String id) {

		String sql = "select * from RECIPE_DATA where id = '" + id+"'";

		List<RcpInfoTO> rcpInfoTOs = jdbcTemplate.query(sql, new RcpMapper());
		return rcpInfoTOs.get(0);
	}
}

class RcpMapper implements RowMapper<RcpInfoTO> {
	public RcpInfoTO mapRow(ResultSet rs, int arg1) {
		RcpInfoTO rcpInfoTO = new RcpInfoTO();

		try {
			rcpInfoTO.setId(rs.getString("id"));
			rcpInfoTO.setName(rs.getString("name"));
			rcpInfoTO.setIngredient_1(rs.getString("ingredient_1"));
			rcpInfoTO.setIngredient_2(rs.getString("ingredient_2"));
			rcpInfoTO.setIngredient_3(rs.getString("ingredient_3"));
			rcpInfoTO.setIngredient_4(rs.getString("ingredient_4"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rcpInfoTO;
	}
}
