package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.util.Config;

@Component
public class ChineseText {
	
	@Autowired
	private Config config;

	public String getText() {
		int length = config.getTextProducerCharLength();
		char[] chars = config.getTextProducerCharString();
		String finalWord = "", firstWord = "";
		String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f" };

		Random rand = new Random();

		for (int i = 0; i < length; i++) {
			switch (rand.nextInt(3)) {
			case 1:
				firstWord = String.valueOf(chars[rand.nextInt(chars.length)]);
				break;
			case 2:
				int r1,
				r2,
				r3,
				r4;
				String strH,
				strL;// high&low
				r1 = rand.nextInt(3) + 11; // 前闭后开[11,14)
				if (r1 == 13) {
					r2 = rand.nextInt(7);
				} else {
					r2 = rand.nextInt(16);
				}

				r3 = rand.nextInt(6) + 10;
				if (r3 == 10) {
					r4 = rand.nextInt(15) + 1;
				} else if (r3 == 15) {
					r4 = rand.nextInt(15);
				} else {
					r4 = rand.nextInt(16);
				}

				strH = array[r1] + array[r2];
				strL = array[r3] + array[r4];

				byte[] bytes = new byte[2];
				bytes[0] = (byte) (Integer.parseInt(strH, 16));
				bytes[1] = (byte) (Integer.parseInt(strL, 16));

				try {
					firstWord = new String(bytes, "GB2312");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				break;
			default:
				firstWord = String.valueOf(chars[rand.nextInt(chars.length)]);
				break;
			}
			finalWord += firstWord;
		}
		return finalWord;
	}
}


