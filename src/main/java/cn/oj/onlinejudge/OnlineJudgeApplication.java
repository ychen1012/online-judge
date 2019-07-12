package cn.oj.onlinejudge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@EnableEurekaClient
@SpringBootApplication
public class OnlineJudgeApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(OnlineJudgeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineJudgeApplication.class, args);
	}

}
