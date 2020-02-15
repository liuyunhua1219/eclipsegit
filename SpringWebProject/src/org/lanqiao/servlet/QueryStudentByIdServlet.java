package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.IStudentService;
import org.lanqiao.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class QueryStudentByIdServlet
 */
public class QueryStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//IStudentService studentService = new StudentServiceImpl();
	IStudentService studentService ;//通过Springioc容器将studentService注入给
	private Object bean;
	//Servlet初始化方法：在初始化时，获取SpringIoc容器中的bean对象
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		studentService = (IStudentService)context.getBean("studentService");
	}
    public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	/**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = studentService.queryStudentById();
		request.setAttribute("name", name);
		System.out.println(name);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
