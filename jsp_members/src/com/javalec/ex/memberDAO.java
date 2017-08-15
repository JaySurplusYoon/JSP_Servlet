package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class memberDAO {
	//각 상황별 프로토콜 모음
	public static final int MEMBER_NONEXISTENT=0;
	public static final int MEMBER_EXISTENT=1;
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_JOIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_IS_NOT=-1;
	
	/*싱글턴 패턴 : 생성자를 private으로 접근제한자를 두어 외부에서 객체생성이 불가능하지만
	 * 자신의 클래스 내에서 자신의 단일한 객체를 생성(private static)하여,
	 * 다른 public메서드에서 해당 단일한 겍체에 접근할 수 있는 통로를 만든다
	 * =>이를 통해 객체 생성을 막고, 해당 public메서드를 통해 단일 객체를 여러곳에서 공유할 수 있도록 한다(주로 DBCP같은 상황에서 사용)
	 * static(정적) : 클래스 바로 하단에 변수 선언시, 해당 변수들이 생성되는 객체마다 모두 동일하게 적용될 경우 메모리 절약을 위해 변수앞에  static붙인다
	 * 	그러면 자바는 해당 변수의 메모리를 딱 한번만 할당한다
	 * 	또한, static설정시 같은  메모리 주소만을 바라보기때문에, 생성된 많은 객체들이 같은 static변수값을 공유할 수 있다
	 * 	(counter 1++ 메서드 예시:static없으면  객체 생성할때마다 각각의 객체가 count값 1로가지나, static count의 경우 객체생성할때마다 1 올라감)
	 * 
	*/
	private memberDAO() {
	}
	private static memberDAO instance=new memberDAO();
	//static변수는 static메서드만 접근이 가능하므로,,getInstance도 static메서드로 설정
	public static memberDAO getInstance() {
		return instance; 
	}
	
	//sql연결 위한 메서드
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
		ResultSet resultSet = null;//쿼리수행후 받아온 데이터를 담기위한 클래스
		String query = "select id from members where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet=pstmt.executeQuery();//쿼리입력하여 데이터 받아올때는 executeQuery
			
			if(resultSet.next()) {//받아온 값이 있으면 true, 없으면 false
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
		PreparedStatement pstmt = null;// PSTMT(prepared)클래스와, prepareStatement(Connection클래스의 메서드) 혼동 금지
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
				//executeUpdate의 경우, 받아온 값은 없고(쓰기만하니까)
				//갑자기 에러로 종료된다면 pstmt와 connection객체값이 null일수도 있다
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
