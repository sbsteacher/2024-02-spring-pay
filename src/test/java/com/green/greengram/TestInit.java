package com.green.greengram;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

/*
    테스트 원상태 복귀용 or 테스트 기초 데이터 늘릴 때
    entity 새로 생성 후 기초 데이터 insert
 */
@ActiveProfiles("test-init")
@Rollback(false)
//@SpringBootTest //엔터티 수정이 있을 때만 활성화
@Sql(scripts = {"classpath:test-import.sql"})
public class TestInit {
    @Test
    void init() {}
}
