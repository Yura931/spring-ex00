package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TImeMapper {
	
	@Select("SELECT sysdate FROM dual") // 쿼리 실행 할 메소드 이다 라고 명시해둔 것
	public String getTime(); // 이 몸통을 mybatis가 대신 실행해줌
	
	public String getTime2();
}

// 클래스 로딩
// 커넥션 열고
// statement 얻고
// query 실행

// SELECT sysdate FROM dual

// resultSet 처리
// 커넥션 닫고
// sql 제외 모든 일을 mybatis가 일을 대신해줌