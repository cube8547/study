package com.alone.jquery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface IntefaceSVC {

	public abstract List<EmpVO> process(HttpServletRequest request);

	
}
