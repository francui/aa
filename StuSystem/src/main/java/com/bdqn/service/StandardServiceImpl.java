package com.bdqn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.dao.StandardMapper;
import com.bdqn.entity.Standard;
@Service
public class StandardServiceImpl implements StandardService {

	@Resource
	private StandardMapper mapper;
	
	public StandardMapper getMapper() {
		return mapper;
	}

	public void setMapper(StandardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Standard> selectAll(String zhname, int from) {
		// TODO Auto-generated method stub
		return mapper.selectAll(zhname, from);
	}

	@Override
	public int getCount(String zhname) {
		// TODO Auto-generated method stub
		return mapper.getCount(zhname);
	}

	@Override
	public boolean check_std(String std_um) {
		Standard sta = mapper.check_std(std_um);
		if(sta!=null) {
			return true;
		}
		return false;
	}

	@Override
	public int add(Standard standard) {
		// TODO Auto-generated method stub
		return mapper.add(standard);
	}

	@Override
	public void delete(Integer[] check_value) {
		// TODO Auto-generated method stub
		mapper.delete(check_value);
	}

	@Override
	public Standard selectById(int id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public void update(Standard standard) {
		// TODO Auto-generated method stub
		mapper.update(standard);
	}

}
