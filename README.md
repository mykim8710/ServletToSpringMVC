# Servlet, jsp, MVC 패턴 - Study Project


## 예제 : 회원등록 및 조회 애플리케이션
- 회원 정보 
  - 이름: username 
  - 나이: age
- 기능 요구사항 
  - 회원 저장 
  - 회원 목록 조회
- Package Design
```
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── servlet
    │   │               └── domain
    │   │                      ├── member
    │   │                      │     ├── MemberRepository(C)   |  회원 저장소
    │   │                      │     └── Member(C)             |  회원 도메인 
	│   │                      └── web
    │   │                            ├── servlet
    │   │                            │       ├── MemberFormServlet(C)      |  서블릿, 회원등록
    │   │                            │       ├── MemberSaveServlet(C)      |  서블릿, 회원가입
    │   │                            │       └── MemberListServlet(C)      |  서블릿, 회원목록
    │   │                            ├── servletmvc
    │   │                            │       ├── MvcMemberFormServlet(C)   |  서블릿 + jsp + MVC, 회원등록
    │   │                            │       ├── MvcMemberSaveServlet(C)   |  서블릿 + jsp + MVC, 회원가입
    │   │                            │       └── MvcMemberListServlet(C)   |  서블릿 + jsp + MVC, 회원목록
    │   │                            ├── frontcontroller
    │   │                            │       ├── ModelView(C)   |  FrontController - Model을 직접 만들고, 추가로 View 이름까지 전달하는 객체
    │   │                            │       ├── MyView(C)      |  FrontController - 별도로 뷰를 처리하는 객체
    │   │                            │       ├── v1
    │   │                            │       │    ├── controller
    │   │                            │       │    │       ├── MemberFormControllerV1(C)  |  회원등록 컨트롤러 V1 구현체
    │   │                            │       │    │       ├── MemberSaveControllerV1(C)  |  회원저장 컨트롤러 V1 구현체
    │   │                            │       │    │       └── MemberListControllerV1(C)  |  회원목록 컨트롤러 V1 구현체           
    │   │                            │       │    ├── ControllerV1(I)                    |  컨트롤러 구현을 위한 인터페이스 V1
    │   │                            │       │    └── FrontControllerServletV1(C)        |  프론트 컨트롤러 서블릿 V1
    │   │                            │       ├── v2
    │   │                            │       │    ├── controller
    │   │                            │       │    │       ├── MemberFormControllerV2(C)  |  회원등록 컨트롤러 V2 구현체
    │   │                            │       │    │       ├── MemberSaveControllerV2(C)  |  회원저장 컨트롤러 V2 구현체
    │   │                            │       │    │       └── MemberListControllerV2(C)  |  회원목록 컨트롤러 V2 구현체            
    │   │                            │       │    ├── ControllerV2(I)                    |  컨트롤러 구현을 위한 인터페이스 V2
    │   │                            │       │    └── FrontControllerServletV2(C)        |  프론트 컨트롤러 서블릿 V2
    │   │                            │       ├── v3
    │   │                            │       │    ├── controller
    │   │                            │       │    │       ├── MemberFormControllerV3(C)  |  회원등록 컨트롤러 V3 구현체
    │   │                            │       │    │       ├── MemberSaveControllerV3(C)  |  회원저장 컨트롤러 V3 구현체
    │   │                            │       │    │       └── MemberListControllerV3(C)  |  회원목록 컨트롤러 V3 구현체            
    │   │                            │       │    ├── ControllerV3(I)                    |  컨트롤러 구현을 위한 인터페이스 V3
    │   │                            │       │    └── FrontControllerServletV3(C)        |  프론트 컨트롤러 서블릿 V3
    │   │                            │       ├── v4
    │   │                            │       │    ├── controller
    │   │                            │       │    │       ├── MemberFormControllerV4(C)  |  회원등록 컨트롤러 V4 구현체
    │   │                            │       │    │       ├── MemberSaveControllerV4(C)  |  회원저장 컨트롤러 V4 구현체
    │   │                            │       │    │       └── MemberListControllerV4(C)  |  회원목록 컨트롤러 V4 구현체            
    │   │                            │       │    ├── ControllerV4(I)                    |  컨트롤러 구현을 위한 인터페이스 V4
    │   │                            │       │    └── FrontControllerServletV4(C)        |  프론트 컨트롤러 서블릿 V4
    │   │                            │       ├── v5
    │   │                            │       │    ├── handler
    │   │                            │       │    │       ├── ControllerV3HandlerAdapter(C)  |  컨트롤러 V3용 핸들러 구현체
    │   │                            │       │    │       └── ControllerV4HandlerAdapter(C)  |  컨트롤러 V4용 핸들러 구현체
    │   │                            │       │    ├── MyHandlerAdapter(I)                    |  핸들러(컨트롤러보다 넓은 범위) 구현을 위한 인터페이스
    │   │                            │       │    ├── FrontControllerServletV5(C)            |  프론트 컨트롤러 서블릿 V5
    │   │                            │       │    └── HandlerInitUtils(C)                    |  외부에서 handlerMappingMap, handlerAdapters 설정하는 객체     
    │   │                            ├── springmvc
    │   │                            │       ├── old
    │   │                            │       │    ├── OldController(C)
    │   │                            │       │    └── MyHttpRequestHandler(C)
    │   │                            │       ├── v1
    │   │                            │       │    ├── SpringMemberFormControllerV1(C)  |  회원등록 컨트롤러    
    │   │                            │       │    ├── SpringMemberListControllerV1(C)  |  회원목록 컨트롤러
    │   │                            │       │    └── SpringMemberSaveControllerV1(C)  |  회원저장 컨트롤러
    │   │                            │       ├── v2
    │   │                            │       │    └── SpringMemberControllerV2(C)      |  회원 통합 컨트롤러 V2     
    │   │                            │       └── v3
    │   │                            │            └── SpringMemberControllerV3(C)      |  회원 통합 컨트롤러 V3     
    │   ├── webapp
    │   │   ├── jsp
    │   │   │   └── members
    │   │   │       ├── new-form.jsp   |  jsp로만 구현, 회원등록
    │   │   │       ├── save.jsp       |  jsp로만 구현, 회원가입
    │   │   │       └── members.jsp    |  jsp로만 구현, 회원목록
    │   │   └── WEB-INF
    │   │       └── views
    │   │           ├── new-form.jsp   |  mvc + 서블릿, 회원등록
    │   │           ├── save.jsp       |  mvc + 서블릿, 회원가입
    │   │           └── members.jsp    |  mvc + 서블릿, 회원목록
```
## 순수 서블릿으로 구현
## JSP로 구현
## 서블릿 + JSP 구현
## FrontController(서블릿 + JSP + MVC) 구현
## Sprint MVC 적용하여 구현
