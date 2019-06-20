# enjoysw

이 프로젝트는 **해외 인턴십 지원**을 효율적으로 관리하기 위해 개발되었습니다.

## 필요 환경 설정

any version of eclipse


## 설치하기 

```$ git clone https://github.com/yoon-hyoung/enjoysw.git```

각각의 java project (internship_client, internship_server) 를 가져온다.
>>>>최종제출물 파일을 git으로 부터 다운받아 workspace로 지정한다.

lib 파일에 있는 jar파일을 프로젝트 - properties - build path - add lib 한다.

internship_server의 EchoServer를 실행한다.

internship_client의 ClinetConsole을 실행한다.

yes 에서 정보를 받아온다고 가정했으므로 개인정보 수정이나 회원가입은 구현하지 않았다.

ID와 PW를 입력해 login한다.

<<CLI 기반 프로그램에서 메뉴 설명에 따라 번호를 선택한다.>>

Ex)
1 을 입력하여 Student type으로 로그인한다.
현재 파일시스테에 등록되어있는 ID, Password 인 (jino1996 과 a1234) 를 사용하여 login 한다

1. Student Information
2. Internship
3. Document
4. Review of Internship
이라는 Interface가 나올 것인데

1 을 입력하면 Student의 개인정보를 읽을 수 있는 메뉴를 제공하며

2 를 입력하면 internship 신청과 취소 그리고 internship List를 print하는 메뉴를 제공한다 (신청, 취소 미구현)

3 을 입력하면 Document 등록,삭제 그리고 현재 로그인한 student의 DocumentList를 print 하는 메뉴를 제공한다.(신청, 취소 미구현)

4 를 입력하면 review List 출력, 리뷰작성, 리뷰 세부내용 구현 메뉴를 제공한다. ( 미구현 )


해당 메뉴가 제공하는 기능 별 입력 값은 UI에서 제공한다.

