package com.example.demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@SpringBootApplication
public class SpringBootKaptchaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKaptchaApplication.class, args);
	}

	/**
	 * <prop key="kaptcha.border">yes</prop>
	 * <prop key="kaptcha.border.color">105,179,90</prop>
	 * <prop key="kaptcha.textproducer.font.color">blue</prop>
	 * <prop key="kaptcha.image.width">125</prop>
	 * <prop key="kaptcha.image.height">45</prop>
	 * <prop key="kaptcha.textproducer.font.size">45</prop>
	 * <prop key="kaptcha.session.key">code</prop>
	 * <prop key="kaptcha.textproducer.char.length">4</prop>
	 * <prop key="kaptcha.textproducer.font.names">宋体,楷体,微软雅黑</prop>
	 */
	@Bean
	public Producer producer() {
		DefaultKaptcha p = new DefaultKaptcha();
		Properties properties = new Properties();
		properties.setProperty(Constants.KAPTCHA_BORDER, "yes");
		properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
		properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "50");
		properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "150");
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "40");
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "5");
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
		Config config = new Config(properties);
		p.setConfig(config);
		return p;
	}
}
