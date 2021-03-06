package com.team.seahouse.controller;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.enums.WebSiteFileBelongEnum;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.upload.UploadManager;
import com.team.seahouse.commons.support.upload.UploadResult;
import com.team.seahouse.commons.utils.ServletUtils;
import io.swagger.annotations.Api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

/**
 * @title 文件上传接口
 * @describe 文件上传接口
 * @author vanguard
 * @version 1.0
 * @date 18/7/16
 */
@Slf4j
@RestController
@RequestMapping(value="/uploads")
@Api(value = "文件上传", description = "文件上传")
public class UploadController extends BaseController {

	@Value("${ACCESS_KEY}")
	private String ACCESS_KEY;

	@Value("${SECRET_KEY}")
	private String SECRET_KEY;

	@Value("${BUCKET}")
	private String BUCKET;

	@GetMapping("/getUploadToken")
	public Response getUploadToken() {
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		StringMap putPolicy = new StringMap();
		putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
		long expireSeconds = 3600;
		String uploadToken = auth.uploadToken(BUCKET, null, expireSeconds, putPolicy);
		log.info("uploadToken:" + uploadToken);
		return new Response(CommonReturnCode.OK, uploadToken);
	}


	/**
	 * POST 广告图片上传
	 * @return
	 */
	@PostMapping(value = "/advert", produces = "application/json;charset=utf-8")
	public Object uploadAdvert(MultipartFile advertFile) {
		if (!advertFile.isEmpty()) {
			try {
				// 判断文件的MIMEType
				String type = advertFile.getContentType();
				if (type == null || !type.toLowerCase().startsWith("image/")) {
					return new Response(CommonReturnCode.BAD_REQUEST.getStatus(), "不支持的文件类型，仅支持图片!");
				}

				UploadResult uploadResult = UploadManager.upload(ServletUtils.getRequest(), advertFile,
						WebSiteFileBelongEnum.IMAGES.getBelong(), WebSiteFileBelongEnum.ADVERT.getBelong());

				if (uploadResult.getResult()) {
					return new Response(CommonReturnCode.SUCCESS, uploadResult.getSavaPath());
				}
			} catch (Exception e) {
				log.error(e.getMessage());
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
	public Object uploadAvatar(MultipartFile multipartFile, String avatarSrc, String avatarData) {
		if (!multipartFile.isEmpty()) {
			try {

				// 判断文件的MIMEtype
				String type = multipartFile.getContentType();
				if (type == null || !type.toLowerCase().startsWith("image/")) {
					return new Response(CommonReturnCode.BAD_REQUEST.getStatus(), "不支持的文件类型，仅支持图片!");
				}

				UploadResult uploadResult = UploadManager.upload(ServletUtils.getRequest(), multipartFile,
						HtmlUtils.htmlUnescape(avatarData), WebSiteFileBelongEnum.IMAGES.getBelong(),
						WebSiteFileBelongEnum.AVATAR.getBelong());

				if (uploadResult.getResult()) {
					return new Response(CommonReturnCode.SUCCESS, uploadResult.getSavaPath());
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				return new Response(CommonReturnCode.UNKNOWN_ERROR);
			}
		}
		return new Response(CommonReturnCode.BAD_REQUEST.getStatus(), "图片不存在,请确认图片地址重新上传!");
	}
}
