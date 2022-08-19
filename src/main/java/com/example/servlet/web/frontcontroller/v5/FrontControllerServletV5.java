package com.example.servlet.web.frontcontroller.v5;

import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private Map<String, Object> handlerMappingMap;
    private List<MyHandlerAdapter> handlerAdapters;

    public FrontControllerServletV5() {
        HandlerInitUtils handlerInitUtils = new HandlerInitUtils();
        this.handlerMappingMap = handlerInitUtils.getHandlerMappingMap();
        this.handlerAdapters = handlerInitUtils.getHandlerAdapters();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);   // handler == controller

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);   // 404
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);  // 어댑터 호출, new ControllerV3HandlerAdapter()

        ModelView modelView = adapter.handle(request, response, handler);

        String viewName = modelView.getViewName();
        System.out.println("viewName = " + viewName);

        MyView myView = viewResolver(viewName);
        System.out.println("myView = " + myView);

        myView.render(modelView.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        return handlerMappingMap.get(requestURI);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)) {
                return adapter;
            }
        }

        throw new IllegalArgumentException("Handler Adapter를 찾을수 없습니다. handler = " +handler);
    }

    // viewResolver
    // 컨트롤러가 반환한 논리 뷰 이름을 실제 물리 뷰 경로로 변경한다. 그리고 실제 물리 경로가 있는 MyView 객체를 반환한다.
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
