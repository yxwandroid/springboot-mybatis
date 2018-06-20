package com.wilson.nfc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.wilson.nfc.mapper"})
public class NfcJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfcJavaApplication.class, args);
	}
}
