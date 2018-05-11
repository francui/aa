package com.bdqn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.Standard;

public interface StandardService {
	public List<Standard> selectAll(@Param("zhname") String zhname, @Param("from") int from);

	public int getCount(@Param("zhname") String zhname);

	public boolean check_std(@Param("std_um") String std_um);

	public int add(Standard standard);

	public void delete(Integer check_value[]);

	public Standard selectById(@Param("id") int id);

	public void update(Standard standard);
}
