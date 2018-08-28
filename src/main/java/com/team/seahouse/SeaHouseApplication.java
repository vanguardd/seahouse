package com.team.seahouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @title SpringBoot应用的入口
 * @describe 运行此类中的main方法即可运行项目
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@SpringBootApplication
@MapperScan(basePackages = "com.team.seahouse.mapper")
public class SeaHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaHouseApplication.class, args);
	}
}
