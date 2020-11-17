package com.springboot.study.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.study.config.ServerSetting;
import com.springboot.study.utils.JsonData;

/**
 * @Description: 文件页面相关类
 * @author: chenjun
 * @date: 2020年6月28日 下午2:35:29
 */
@RestController
@PropertySource({ "classpath:resources.properties" })
public class FileController {

	// 注解读取配置文件存储位置
	@Value("${web.file.path}")
	private String filePath;
	private Map<String, Object> params = new HashMap<String, Object>();

	@RequestMapping(path = "/api/upload")
	public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {
		String name = request.getParameter("name");
		params.clear();
		Map<String, Object> map = new HashMap<String, Object>();
		String fileName = file.getOriginalFilename();
		// 文件后缀名
		assert fileName != null;
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(new Date().getTime());
		// 文件上传后的路径
		fileName = time + suffixName;
		File dest = new File(filePath + fileName);
		try {
			file.transferTo(dest);
			map.put("filePath", filePath);
			map.put("fileName", fileName);
			map.put("name", name);
			return new JsonData(0, map, "上传成功");
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return new JsonData(-1, null, "上传失败");
	}

	// 实体类读取配置文件
	@Autowired
	private ServerSetting ServerSetting;

	@GetMapping("/api/testServerSetting")
	public Object testServerSetting() {
		// System.out.println(ServerSetting.getDomain());
		return ServerSetting;
	}
}
