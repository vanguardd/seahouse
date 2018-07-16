package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.enums.WebSiteFileBelongEnum;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.upload.UploadManager;
import com.team.seahouse.commons.support.upload.UploadResult;
import com.team.seahouse.commons.utils.ServletUtils;
import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

/**
 * @title 文件上传表示层控制器
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
@Controller
@RequestMapping(value="/uploads")
@Api(value = "文件上传", description = "文件上传")
public class UploadController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	/**
	 * POST 广告图片上传
	 * @return
	 */
	@PostMapping(value = "/advert", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object uploadAdvert(MultipartFile advert_file) {
		if (!advert_file.isEmpty()) {
			try {
				// 判断文件的MIMEType
				String type = advert_file.getContentType();
				if (type == null || !type.toLowerCase().startsWith("image/")) {
					return new Response(CommonReturnCode.BAD_REQUEST.getStatus(), "不支持的文件类型，仅支持图片!");
				}

				UploadResult uploadResult = UploadManager.upload(ServletUtils.getRequest(), advert_file,
						WebSiteFileBelongEnum.IMAGES.getBelong(), WebSiteFileBelongEnum.ADVERT.getBelong());

				if (uploadResult.getResult()) {
					return new Response(CommonReturnCode.SUCCESS, uploadResult.getSavaPath());
				}
			} catch (Exception e) {
				logger.error("ImageUploadController.uploadHeadPortrait={}", e);
				return new Response(CommonReturnCode.UNKNOWN_ERROR);
			}
		}
		return new Response(CommonReturnCode.BAD_REQUEST.getStatus(), "图片不存在,请确认图片地址重新上传!");
	}	
	
	
	/**
	 * POST 用户头像上传
	 * @return
	 */
	@PostMapping(value = "/avatar", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object uploadAvatar(MultipartFile multipartFile, String avatar_src, String avatar_data) {
		if (!multipartFile.isEmpty()) {
			try {

				// 判断文件的MIMEtype
				String type = multipartFile.getContentType();
				if (type == null || !type.toLowerCase().startsWith("image/")) {
					return new Response(CommonReturnCode.BAD_REQUEST.getStatus(), "不支持的文件类型，仅支持图片!");
				}

				UploadResult uploadResult = UploadManager.upload(ServletUtils.getRequest(), multipartFile,
						HtmlUtils.htmlUnescape(avatar_data), WebSiteFileBelongEnum.IMAGES.getBelong(),
						WebSiteFileBelongEnum.AVATAR.getBelong());

				if (uploadResult.getResult()) {
					return new Response(CommonReturnCode.SUCCESS, uploadResult.getSavaPath());
				}
			} catch (Exception e) {
				logger.error("ImageUploadController.uploadHeadPortrait={}", e);
				return new Response(CommonReturnCode.UNKNOWN_ERROR);
			}
		}
		return new Response(CommonReturnCode.BAD_REQUEST.getStatus(), "图片不存在,请确认图片地址重新上传!");
	}
}
