package com.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.board.BoardDTO;
import com.spring.users.UserDAO;
import com.spring.users.UserDTO;
import com.spring.users.UserService;
import com.spring.users.UserServiceImpl;

/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DispatcherServlet() {
        super();
     
    }

    //doGet���� �Ѿ���� ��û�� process () �޼ҵ忡�� ó�� �ϵ��� �ѱ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		process(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Post ������� ������ ���� �ѱ涧 �ѱ� ������ ���� ó�� 
		request.setCharacterEncoding("UTF-8");
		process(request, response); 

	}
	
	// doGet, doPost �� ��� ��û�� ó�� �ϴ� �޼ҵ� 
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do 
		// URI : /boardweb/getBoardList.do
		
		
		//1. Ŭ���̾�Ʈ�� ��û path ������ ���� �Ѵ�. 
		String uri = request.getRequestURI(); 		///boardweb/getBoardList.do
			System.out.println("uri : " + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));  //getBoardList.do
			System.out.println("path : "+ path);
		
		
		//2. Ŭ���̾�Ʈ�� ��û ������ ���� �����ϰ� �б� ó����. 
		
		if (path.equals("/login.do")) {
			
			// Ŭ���̾�Ʈ ��û�� ���ؼ� : /loin.do ��û 
			//1. Model : Service (����Ͻ� ������ ó��)  , (DTO, DAO) 
			//2. View �������� ���� : *.jsp ����
						
			System.out.println("����� ���� ó��");
			System.out.println("/login.do ��û�� ���½��ϴ�. ");
			
			// 1. Ŭ���̾�Ʈ���� ������ ���� ���� �޾Ƽ� ������ ���� 
			String id = request.getParameter("id"); 
			String password = request.getParameter("password"); 
			
			System.out.println("������ �ѱ� ���� id �� ��� : " + id);
			System.out.println("������ �ѱ� ���� id �� ��� : " + password);
			
			//2. Ŭ���̾�Ʈ���� �ѱ� �������� �޾Ƽ� ����� ������ DTO�� Setter ���� 
			UserDTO dto = new UserDTO(); 
			dto.setId(id); 
			dto.setPassword(password); 
			
			//3. ����Ͻ� ������ ó���ϴ� �������̽��� dto�� ���� �ؼ� ����Ͻ� ������ ó��
			
			//UserService user = new UserServiceImpl(); 
			UserDAO user = new UserDAO(); 
			
			UserDTO userD = user.getUser(dto); 
			
			//DB�� Ŭ���̾�Ʈ���� �ѱ� ID �� Password �� select �ؼ� �ׁ��� DTO�� ��Ƽ� ���� 
			System.out.println(userD);
			
			
			//4. �鿣���� ������ ��� ó���� View �������� �̵� 
			if (userD.getId() != null) {  //Ŭ���̾�Ʈ���� ������ ID �� Pass�� DB�� ���� ��ġ �Ҷ�
				response.sendRedirect("getBoardList.jsp"); 
				System.out.println("���̵�� �н����� ��ġ");
			}else {  //Client���� ������ ID�� Pass�� ��ġ���� ���� ��  
				response.sendRedirect("login.jsp"); 
				System.out.println("���̵�� �н����� ����ġ ");
			}
					
			
		}else if (path.equals("/getBoardList.do")) {
			
			System.out.println("�Խ��� ���� ��� ");
			
			
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("����� �α� �ƿ� ó��");
		}
		
		
	}
	
	

}
