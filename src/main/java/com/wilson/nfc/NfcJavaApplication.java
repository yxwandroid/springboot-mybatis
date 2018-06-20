package com.wilson.nfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.wilson.nfc.mapper"})
public class NfcJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfcJavaApplication.class, args);
	}
}
