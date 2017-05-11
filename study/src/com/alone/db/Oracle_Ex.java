/*


JOIN이란 ? 

- 둘 이상의 테이블을 연결하여 데이터를 검색하는 방법 이다.
- 보통 둘 이상의 행들의 공통된 값 Primary Key 및 Foreign Key 값을 사용하여 조인 한다. (Primary Key 및 Foreign Key 값을 지정 하지 않으면 데이터가 복사됨)
- 두 개의 테이블을 SELECT문장 안에서 조인 하려면 적어도 하나의 컬럼이 그 두 테이블 사이에서 공유 되어야 한다.

Join 방법과 방식

- 조인의 방법 : Equi Join (등가 조인, 내부조인) , Non-Equi Join , Self Join , Outer Join
- 조인의 방식 : Nested Loop Join, Sort Merge Join, Hash Join

Equi Join

- 가장 일반적으로 사용하는 Equality Condition(=)에 의한 조인이다
- Equi join의 성능을 높이기 위해서는 Index 기능을 사용하는 것이 좋다.


-- dept 테이블과 emp 테이블을 조인하는 예제
SELECT e.empno, e.ename, d.dname
  FROM dept d, emp e
 WHERE d.deptno = e.deptno;
 
 --------------------------------------------------------------------------------------
 
 
콤마(,) 대신 INNER JOIN을 사용 할 수 있으며, INNER는 생략 가능하다. Join 조건은 ON 절에 온다.
5
-- INNER JOIN절을 이용하여 조인하는 예제
SELECT e.empno, e.ename, d.dname
  FROM dept d 
 INNER JOIN emp e
    ON d.deptno = e.deptno;
    
    --------------------------------------------------------------------------------------
    
    
NATURAL JOIN을 사용 하면 동일한 컬럼을 내부적으로 모두조인 하므로, ON절이 생략 가능하다.
-- NATURAL JOIN절을 이용하여 조인하는 예제
SELECT  e.empno, e.ename, d.dname
  FROM  dept d 
NATURAL JOIN emp e;





NATURAL JOIN의 단점은 동일한 이름을 가지는 칼럼은 모두 조인이 되는데, USING 문을 사용하면 컬럼을 선택해서 조인을 할 수가 있다.
-- JOIN~USING절을 이용하여 조인하는 예제
SELECT e.empno, e.ename, deptno 
  FROM emp e 
  JOIN dept d 
 USING (deptno);
Non-Equi Join



--------------------------------------------------------------------------------------



- 테이블의 어떤 column도 Join할 테이블의 column에 일치하지 않을 때 사용하고, 조인조건은 동등( = )이외의 연산자를 갖는다.
- BETWEEN AND, IS NULL, IS NOT NULL, IN, NOT IN
- 거의 사용하지 않는다

-- emp 테이블과 salgrade 테이블의 Non-Equi Join 예제
SELECT e.ename,e.sal,s.grade
  FROM emp e, salgrade s
  WHERE e.sal 
BETWEEN s.losal 
    AND s.hisal;
 
ENAME             SAL      GRADE
---------- ---------- ----------
SMITH             800          1
JAMES             950          1
ADAMS            1100          1
...
--------------------------------------------------------------------------------------




Self Join

- Equi Join과 같으나 하나의 테이블에서 조인이 일어나는 것이 다르다.
- 같은 테이블에 대해 두 개의 alias를 사용하여 FROM절에 두 개의 테이블을 사용하는 것 처럼 조인한다.

-- 사원의 매니저명을 조회하는 Self Join 예제
SELECT e.ename, a.ename "Manager"
  FROM emp e, emp a
 WHERE e.empno = a.mgr;
 
ENAME     Manager
------- ----------
FORD      SMITH
BLAKE     ALLEN
BLAKE     WARD
KING      JONES
...



--------------------------------------------------------------------------------------




Cartesian Product

- 검색하고자 했던 데이터뿐 아니라 조인에 사용된 테이블들의 모든 데이터가 반환 되는 현상
- Cartesian Product는 조인 조건을 정의하지 않은 경우 발생한다.
- 테이블의 개수가 N이라면 Cartesian Product를 피하기 위해서는 적어도 N-1개의 등가 조건을 SELECT 문안에 포함시켜야 하며 각 테이블의 컬럼이 적어도 한번은 조건절에 참조되도록 해야 한다.
- CROSS JOIN을 이용하면 Cartesian Product 값을 얻을 수 있다.



-- CROSS JOIN절을 이용하여 Cartesian Product 값을 얻는 예제
SELECT  e.empno, e.ename, d.dname
  FROM  dept d CROSS JOIN emp e;
 
56 개의 행이 선택되었습니다.



--------------------------------------------------------------------------------------

Hash Join 


 해시 조인(Hash-Join)은 두 테이블 중 하나를 기준으로 비트맵 해시 테이블을 메모리에 올린 후 나머지 테이블을 스캔 하면서 해싱 테이블을 적용하여 메모리에 로딩된 테이블과 비교하여 매칭되는 데이터를 추출하는 방식의 조인이다. 

RDBMS에 서 비용이 가장 많이 들어가는 Join 방법으로 주로 작은 Table과 큰 Table 의 Join 시 사용되어 지며 , Driving 조건과 상관없이 좋은 성능을 발휘할 수 있다. 

해시 조인 사용기준 

- 기준 
1. 한쪽 테이블이 Hash Area에 담길 정도로 충분히 작아야함. 
2. Build Input 해시 키 컬럼에 중복 값이 거의 없어야 함. 
  
- 조건 
1. 조인 컬럼에 적당한 인덱스가 없어 NL조인이 비효율적일때 
2. 조인 컬럼에 인덱스가 있더라고 NL 조인 드라이빙 집합에서 Inner 쪽 집합으로서의 조인 액세스량이 많아 Random 액세스 부하가 심할 때 
3. 소트 머지 조인하기에는 두 테이블이 너무 커 소트 부하가 심할때 
4. 수행빈도가 낮고 쿼리 수행 시간이 오래 걸리는 대용량 테이블을 조인할때 
  
- 결과 
1. 해시테이블은 단 하나의 쿼리를 위해 생성하고 조인이 끝나면 곧바로 소멸하는 자료구조이다. 
2. 수행빈도가 낮고, 쿼리수행 시간이 오래 걸리는, 대용량테이블을 조인할 때 


-------------------------------------------------------------------------------------

AND와 OR

OR: 많이 사용할수록 집합의 범위를 크게 만들어 일량이 증가한다.
AND: 많이 사용할수록 집합의 범위를 줄여주어 수행속도가 향상된다.
하지만 이것은 연산자가 처리주관 조건에 사용되었을 때에 한해 적용된다.
처리 주관 조건은 인덱스 구조에 따라 언제든지 달라질 수 있으므로 가능한 OR 조건은 사용하지 않도록 한다.










-------------------------------------------------------------------------------------















-------------------------------------------------------------------------------------
JOIN은  Primary Key, Foreign Key 값을 설정 해야한다 

설정 하지 않았음 때

TABLE1 COLUNM1 -> TABLE2 COLUNM1
TABLE1 COLUNM1 -> TABLE2 COLUNM2
TABLE1 COLUNM1 -> TABLE2 COLUNM3
TABLE1 COLUNM1 -> TABLE2 COLUNM4
TABLE1 COLUNM1 -> TABLE2 COLUNM5

TABLE1 COLUNM2 -> TABLE2 COLUNM1
TABLE1 COLUNM2 -> TABLE2 COLUNM2
TABLE1 COLUNM2 -> TABLE2 COLUNM3
TABLE1 COLUNM2 -> TABLE2 COLUNM4
TABLE1 COLUNM2 -> TABLE2 COLUNM5

TABLE1 COLUNM3 -> TABLE2 COLUNM1
TABLE1 COLUNM3 -> TABLE2 COLUNM2
TABLE1 COLUNM3 -> TABLE2 COLUNM3
TABLE1 COLUNM3 -> TABLE2 COLUNM4
TABLE1 COLUNM3 -> TABLE2 COLUNM5

이런식으로 결과 값이 나오기 때문에 꼭 PRIMARY, FOREIGN KEY를 설정해야한다

설정했을때
TABLE1 COLUNM1 -> TABLE2 COLUNM1
TABLE1 COLUNM1 -> TABLE2 COLUNM2
TABLE1 COLUNM1 -> TABLE2 COLUNM3
TABLE1 COLUNM1 -> TABLE2 COLUNM4
TABLE1 COLUNM1 -> TABLE2 COLUNM5

*/