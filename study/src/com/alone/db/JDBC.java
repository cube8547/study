/*
DB 연결 framework 을 사용해서 주로 개발을 하지만 본격적으로 작업전에
테스트를 해 본다던지 Junit 이나 main 어플리케이션을 사용해 간단한
작업을 해 볼수 있다.


=================================================================

1. MySQL 연결 테스트

먼저 MySQL 과 연결을 위해서는 JDBC API 가 필요하다.
아래 사이트 주소로 가서 Connector/J 를 다운받는다.
http://dev.mysql.com/downloads/connector/j/

다운받은 zip 파일의 압축을 푼후 jar 파일을 이클립스와 연계하기 위해 폴더로 옮긴다.

이클립스에서 MySQL Connector 를 연결하기 위해 Build Path 정보로 들어간다.
그리고 오른쪽에 Add JARs.. 버튼을 클릭해서 복사한 mysql-connector-java-xxx.jar
추가한다.


이제 연결 테스트를 위해 Junit 클래스와 테스트를 위한 함수를 하나 만든다.
이전에 연결할 MySQL DB 는 준비해야 하며 그속에 테이블들도 만들어져 있는
상태이다. 그 준비과정은 기술하지 않는다. 
아래 소스는 MySQL DB 에 접속해서 만들어져 있는 DB 명을 조회해서
가져오는 소스이다. DriverManager.getConnection() 으로 Connection 을
가져온후 Connection 의 CreateStatement() 함수로 Statement 객체를
생성한다. 이 Statemnet 객체로 쿼리 조회하고 결과값을 받아와
RecordSet 에 담는다. 받아온 RecordSet 으로 데이터를 처리 하면 된다.


----------------------------------------------------------------------------------------------------------------
소스

private Connection conn;
private Statement stat;
private ResultSet rs;
 
@Test
public final void testMySql() {
    String dbUrl = "jdbc:mysql://xxx.xxx.co.kr";
    String id = "sss";
    String pwd = "ddd";
     
    try {
        Connection con = null;
        con = DriverManager.getConnection(dbUrl, id, pwd);
        stat = con.createStatement();
         
        // 현재 존재하는 DB 종류를 알아오는 쿼리
        rs = stat.executeQuery("SHOW DATABASES");
        if (stat.execute("SHOW DATABASES")) {
            rs = stat.getResultSet();
        }
         
        // RecordSet 에 담은 데이타를 출력한다.
        while (rs.next()) {
            String str = rs.getNString(1);
            System.out.println(str);
        }
 
    } catch (SQLException sqex) {
        System.out.println("SQLException: " + sqex.getMessage());
        System.out.println("SQLState: " + sqex.getSQLState());
    }
 
}

------------------------------------------------------------------------------------------------------------

2. Oracle 연결 테스트

위와 같이 Oracle 을 접속하기 위해서는 ojdbc 가 필요하다.
http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html?ssSourceSiteId=otnjp

다운받은 jar 파일을 프로젝트 폴더에 넣은후 Build Path 에서 ojdbc 를 추가한다.

연결하는 법은 mysql 소스와 거의 똑같으며 다른 것은 getConnection() 할때
첫번째 url 값으로 들어가는 주소의 형태만 틀릴 뿐이다.
아래는 소스이므로 참고 하기 바란다.

소스 

@Test
public final void testOracle() {
    String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String id = "xxx";
    String pwd = "xxx3261";
     
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(dbUrl, id, pwd);
        stat = conn.createStatement();
         
        stat.close();
        conn.close();
         
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
















































































*/