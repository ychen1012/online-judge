package cn.oj.onlinejudge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultCase {
	private Integer result;
	private Long timeused;
	private Long memoryused;
	private String errormessage;
}
