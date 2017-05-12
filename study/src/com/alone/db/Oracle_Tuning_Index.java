/*

--INDEX
-- 인덱스는 테이블이나 클러스트에서 쓰여지는 선택적인 객체로서, 오라클 데이터베이스 테이블내의 원하는 레코드를 빠르게 찾아갈 수 있도록 만들어진 데이터 구조이다.

-- 자동 인덱스 : 프라이머리 키 또는 UINQUE 제한 규칙에 의해 자동적으로 생성되는 인덱스.

-- 수동 인덱스 : CREATE INDEX 명령을 실행해서 만드는 인덱스

----
----인덱스를 생성하는 것이 좋은 컬럼
----
----① WHERE절이나 join조건 안에서 자주 사용되는 컬럼
----② null 값이 많이 포함되어 있는 컬럼
----③ WHERE절이나 join조건에서 자주 사용되는 두 개이상의 컬럼들
----다음과 같은 경우에는 인덱스 생성이 불필요 하다.
----
----① 테이블이 작을 때
----② 테이블이 자주 갱신될 때
--
--오라클 인덱스는 B-tree(binary search tree)에 대한 원리를 기반으로 하고 있다. B-tree 인덱스는 컬럼안에 독특한 데이터가 많을 때 가장 좋은 효과를 낸다.
--
--이 알고리즘 원리는 
--① 주어진 값을 리스트의 중간점에 있는 값과 비교한다.만약 그 값이 더 크면 리스트의 아래쪽 반을 버린다. 만약 그 값이 더 작다면 위쪽 반을 버린다.
--② 하나의 값이 발견될 때 까지 또는 리스트가 끝날 때까지 그와 같은 작업을 다른 반쪽에도 반복한다.
--
--
----설정방법
--
--비트맵 인덱스
--
--비트맵 인덱스는 각 컬럼에 대해 적은 개수의 독특한 값이 있을 경우에 사용하는 것이 좋다.(ex 남,여의 값을 가지는 성별 컬럼)
--
--비트맵 인덱스는 B-tree 인덱스가 사용되지 않을 경우에서 성능을 향상 시킨다.
--
--테이블이 매우 크거나 수정/변경이 잘 일어나지 않는 경우에 사용할수 있다.
--
--
--CREATE BITMAP INDEX emp_deptno_indx  
--     ON emp(deptno); 
--
--/
--
 많이 사용함 
--UNIQUE 인덱스
--
--UNIQUE 인덱스는 인덱스를 사용한 컬럼의 중복값들을 포함하지 않고 사용할 수 있는 장점이 있다.
--
--프라이머리키 와 UNIQUE 제약 조건시 생성되는 인덱스는 UNIQUE 인덱스이다.
--
--CREATE UNIQUE INDEX emp_ename_indx 
--     ON emp(ename); 
--    
--
--/
--
--NON-UNIQUE 인덱스
--
--NON-UNIQUE 인덱스는 인덱스를 사용한 컬럼에 중복 데이터 값을 가질수 있다.
--
--CREATE INDEX  dept_dname_indx 
--     ON dept(dname);
--     
--/
--
--결합 인덱스
--
--복수개의 컬럼에 생성할 수 있으며 복수키 인덱스가 가질수 있는 최대 컬럼값은 16개 이다
--
--CREATE UNIQUE INDEX emp_empno_ename_indx 
--     ON emp(empno, ename);
--
--/
--
--인덱스의 삭제
--
--인덱스의 구조는 테이블과 독립적이므로 인덱스의 삭제는 테이블의 데이터에는 아무런 영향도 미치지 않는다.
--
--인덱스를 삭제하려면 인덱스의 소유자 이거나 DROP ANY INDEX권한을 가지고 있어야 한다.
--
--인덱스는 ALTER를 할 수 없다.
--
--DROP INDEX emp_empno_ename_indx; 
--
--/
--
--
--인덱스 데이터사전
--
--인덱스에 대한 정보는 USER_INDEXES 뷰 또는 USER_IND_COLUMNS뷰를 통해 검색할 수 있다.
--
--SELECT index_name, index_type 
--     FROM USER_INDEXES 
--     WHERE table_name='EMP'; 
--
--INDEX_NAME              INDEX_TYPE
---------------------     -----------
--EMP_DEPTNO_INDX         BITMAP
--EMP_PK_EMPNO            NORMAL    
--
--
--
--- 강좌 URL : http://www.gurubee.net/lecture/1035
--
--
--
--
--
--





















*/