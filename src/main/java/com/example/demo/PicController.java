package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Controller
public class PicController {

	@Autowired
	private Producer producer;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	
	@RequestMapping("/jpg")
	public void pic(HttpServletResponse response, HttpSession session) throws IOException {

		/**
		 * 无缓存
		 */
		response.setDateHeader("Expires", 0);  
        
        // Set standard HTTP/1.1 no-cache headers.  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
          
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
          
        // Set standard HTTP/1.0 no-cache header.  
        response.setHeader("Pragma", "no-cache");  
        
		response.setContentType("image/jpeg");

		String text = producer.createText();

		BufferedImage image = producer.createImage(text);
		
		session.setAttribute(Constants.KAPTCHA_SESSION_CONFIG_KEY, text);
		
		System.out.println(text);

		ServletOutputStream outputStream = response.getOutputStream();

		ImageIO.write(image, "jpg", outputStream);

	}

}
