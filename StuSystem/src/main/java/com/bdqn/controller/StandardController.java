package com.bdqn.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bdqn.entity.Pages;
import com.bdqn.entity.Standard;
import com.bdqn.service.StandardService;

@Controller
public class StandardController {

	@Resource
	private StandardService service;

	public StandardService getService() {
		return service;
	}

	public void setService(StandardService service) {
		this.service = service;
	}

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public String selectAll(@RequestParam(value = "pageIndex", required = false) String pageIndex,
			@RequestParam(value = "zhname", required = false) String zhname, Model model) {
		Pages pages = new Pages();
		int current_page = 0;
		if (pageIndex == null) {
			current_page = 1;
		} else {
			current_page = Integer.parseInt(pageIndex);
		}
		pages.setPage_size(3);
		int count = service.getCount(zhname);
		pages.setCount(count);
		pages.setCurrent_page(current_page);
		int from = (current_page - 1) * 3;
		List<Standard> list = service.selectAll(zhname, from);
		pages.setList(list);
		model.addAttribute("pages", pages);
		model.addAttribute("zhname", zhname);
		/* model.addAttribute("list", list); */
		return "show";
	}

	@RequestMapping(value = "/selectById")
	public String selectById(@Param("id") int id, Model model) {
		Standard standard = service.selectById(id);
		model.addAttribute("standard", standard);
		return "update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Standard standard) {
		service.update(standard);
		return "redirect:/selectAll";
	}
	@RequestMapping(value="/delete")
	public String delete(@RequestParam("id") Integer check_value[]) {
		if (check_value == null || check_value.length <= 0) {
			return "redirect:/selectAll";
		}
		service.delete(check_value);
		return "redirect:/selectAll";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Standard standard, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "attach", required = false) MultipartFile attach) {
		String packagePath=null;
		if(!attach.isEmpty()) {
			String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
			String originFileName = attach.getOriginalFilename();
			String suffix = FilenameUtils.getExtension(originFileName);
			int fileSize = 100000;
			if(attach.getSize()>fileSize) {
				request.setAttribute("upLoadFileError", "上传文件大小超过限制！");
			}else if(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png") || suffix.equalsIgnoreCase("gif") || suffix.equalsIgnoreCase("jpeg")){
				String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+".png";
				File targetFolder = new File(path, fileName);
				if(!targetFolder.exists()) {
					targetFolder.mkdir();
				}
				try {
					attach.transferTo(targetFolder);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("upLoadFileError", "上传失败！");
					return "add";
				}
				packagePath = "statics"+File.separator+"uploadFiles"+File.separator+fileName;
			}else {
				request.setAttribute("upLoadFileError", "上传文件格式错误！");
				return "add";
			}
		}
		standard.setPackage_path(packagePath);
		int result = service.add(standard);
		if(result >0) {
			return "redirect:/selectAll";
		}else {
			return "add";
		}
	}
}
