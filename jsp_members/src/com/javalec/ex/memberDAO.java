package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class memberDAO {
	//�� ��Ȳ�� �������� ����
	public static final int MEMBER_NONEXISTENT=0;
	public static final int MEMBER_EXISTENT=1;
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_JOIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_IS_NOT=-1;
	
	/*�̱��� ���� : �����ڸ� private���� ���������ڸ� �ξ� �ܺο��� ��ü������ �Ұ���������
	 * �ڽ��� Ŭ���� ������ �ڽ��� ������ ��ü�� ����(private static)�Ͽ�,
	 * �ٸ� public�޼��忡�� �ش� ������ ��ü�� ������ �� �ִ� ��θ� �����
	 * =>�̸� ���� ��ü ������ ����, �ش� public�޼��带 ���� ���� ��ü�� ���������� ������ �� �ֵ��� �Ѵ�(�ַ� DBCP���� ��Ȳ���� ���)
	 * static(����) : Ŭ���� �ٷ� �ϴܿ� ���� �����, �ش� �������� �����Ǵ� ��ü���� ��� �����ϰ� ����� ��� �޸� ������ ���� �����տ�  static���δ�
	 * 	�׷��� �ڹٴ� �ش� ������ �޸𸮸� �� �ѹ��� �Ҵ��Ѵ�
	 * 	����, static������ ����  �޸� �ּҸ��� �ٶ󺸱⶧����, ������ ���� ��ü���� ���� static�������� ������ �� �ִ�
	 * 	(counter 1++ �޼��� ����:static������  ��ü �����Ҷ����� ������ ��ü�� count�� 1�ΰ�����, static count�� ��� ��ü�����Ҷ����� 1 �ö�)
	 * 
	*/
	private memberDAO() {
	}
	private static memberDAO instance=new memberDAO();
	//static������ static�޼��常 ������ �����ϹǷ�,,getInstance�� static�޼���� ����
	public static memberDAO getInstance() {
		return instance; 
	}
	
	//sql���� ���� �޼���
	private Connection getConnection() {
		Context context= null;
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public int confirmId(String id) {
		int ri=0;
		Connection connection=null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;//���������� �޾ƿ� �����͸� ������� Ŭ����
		String query = "select id from members where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet=pstmt.executeQuery();//�����Է��Ͽ� ������ �޾ƿö��� executeQuery
			
			if(resultSet.next()) {//�޾ƿ� ���� ������ true, ������ false
				ri = memberDAO.MEMBER_EXISTENT;
			}else {
				ri = memberDAO.MEMBER_NONEXISTENT;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return ri;
	}
	public int insertMember(memberDTO dto) {
		int ri=0;
		Connection connection = null;
		PreparedStatement pstmt = null;// PSTMT(prepared)Ŭ������, prepareStatement(ConnectionŬ������ �޼���) ȥ�� ����
		String query="insert into members values(?,?,?,?,?,?)";
		
		try {
			connection=getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
			ri = memberDAO.MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				//executeUpdate�� ���, �޾ƿ� ���� ����(���⸸�ϴϱ�)
				//���ڱ� ������ ����ȴٸ� pstmt�� connection��ü���� null�ϼ��� �ִ�
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return ri;
	}
	public int userCheck(String id, String pw) {
		int ri=0;
		String dbPw;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String query = "select pw from members where id=?";
		
		try {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet=pstmt.executeQuery();
			
			if(resultSet.next()) {
				dbPw=resultSet.getString("pw");
				if(dbPw.equals(pw)) {
					ri=MEMBER_LOGIN_SUCCESS;
				}else {
					ri=MEMBER_LOGIN_PW_NO_GOOD;
				}
			}else {
				ri=MEMBER_LOGIN_IS_NOT;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}return ri;
	}
	public memberDTO getMember(String id) {
		memberDTO dto = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String query="select * from members where id=?";
		
		try {
			connection=getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet=pstmt.executeQuery();
			
			if(resultSet.next()) {
				dto.setId(resultSet.getString("id"));
				dto.setPw(resultSet.getString("pw"));
				dto.setName(resultSet.getString("pw"));
				dto.seteMail(resultSet.getString("eMail"));
				dto.setrDate(resultSet.getTimestamp("rDate"));
				dto.setAddress(resultSet.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return dto;
	}
	public int updateMember(memberDTO dto) {
		int ri=0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query="update member set pw=?, email=?, address=? where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,dto.getPw());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.geteMail());
			pstmt.setString(4, dto.getAddress());
			ri=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return ri;
	}
}
