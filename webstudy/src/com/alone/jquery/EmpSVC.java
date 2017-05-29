package com.alone.jquery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class EmpSVC implements IntefaceSVC{

	@Override
	public List<EmpVO> process(HttpServletRequest request) {
		EmpDAO dao = new EmpDAO();
		EmpVO vo = new EmpVO();
		
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		vo.setDeptNo(deptNo);
		
		return dao.checkEmp(deptNo);
	}

	
}
