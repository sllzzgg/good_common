package com.dshl.commons.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.dshl.commons.pojo.ResponseHeader;
import com.dshl.commons.pojo.ResponseModel;
import com.dshl.commons.utlis.CommonUtils;
import com.dshl.commons.utlis.JSONUtils;


/**
 * 异常统一处理
 */
public class CustomSimpleMappingException extends SimpleMappingExceptionResolver {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomSimpleMappingException.class);

	@Resource
	ResponseModel responseModel;

	@Override
	public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		// json防止乱码
		response = initResponseHeader(response, "application/json");

		if (ex instanceof BaseException) {
			BaseException exception = (BaseException) ex;
			LOGGER.warn("Error: {}", exception.getMessage());
			responseModel.responseHeader.setCode(exception.getErrorCode());
			responseModel.responseHeader.setMessage(exception.getMessage());
			String respJson = JSONUtils.toJson(responseModel);

			response.setStatus(exception.getErrorCode());
			write2Response(response, respJson);
			return null;
		} else {
			LOGGER.error("Exception: ", ex);
			responseModel.responseHeader.setCode(ResponseHeader.Status.INTERNAL_ERROR);
			responseModel.responseHeader.setMessage("Server Internal Error");
			String respJson = JSONUtils.toJson(responseModel);

			response.setStatus(ResponseHeader.Status.INTERNAL_ERROR);
			write2Response(response, respJson);
			return null;
		}
	}

	private void write2Response(HttpServletResponse response, String respJson) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(respJson);
			writer.flush();
		} catch (IOException e) {
			LOGGER.error("异常拦截输出内容出错了: {}", e.getMessage());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	private HttpServletResponse initResponseHeader(final HttpServletResponse response, final String contentType,
			final String... headers) {
		String encoding = "UTF-8";
		boolean noCache = true;
		if (CommonUtils.isNotNullObject(headers)) {
			for (String header : headers) {
				String headerName = StringUtils.substringBefore(header, ":");
				String headerValue = StringUtils.substringAfter(header, ":");
				if (StringUtils.equalsIgnoreCase(headerName, encoding)) {
					encoding = headerValue;
				} else if (StringUtils.equalsIgnoreCase(headerName, "no-cache")) {
					noCache = Boolean.parseBoolean(headerValue);
				} else {
					throw new IllegalArgumentException(headerName + "Invalid Header");
				}
			}
		}

		String fullContentType = contentType + ";charset=" + encoding;
		response.setContentType(fullContentType);
		if (noCache) {
			// Http 1.0 header
			response.setDateHeader("Expires", 1L);
			response.addHeader("Pragma", "no-cache");
			// Http 1.1 header
			response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
		}
		return response;
	}
}