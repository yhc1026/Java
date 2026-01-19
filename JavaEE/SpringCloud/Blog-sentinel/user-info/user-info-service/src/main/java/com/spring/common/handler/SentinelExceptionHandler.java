//package com.spring.common.handler;
//
//import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//
//import java.io.PrintWriter;
//
//@Component
//public class SentinelExceptionHandler implements BlockExceptionHandler {
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
//        httpServletResponse.setContentType("text/html; charset=utf-8");
//        String msg = "Blocked by Sentinel (flow limiting)";
//        int status = 429;
//        PrintWriter out = httpServletResponse.getWriter();
////限流异常
//        if (e instanceof FlowException) {
//            msg = "触发限流";
//        } else if (e instanceof DegradeException) { //降级异常
//            msg = "触发降级";
//        } else{
//            msg = "未知异常";
//            status=666;
//        }
//        httpServletResponse.setStatus(status);
//        out.print(msg);
//        out.flush();
//        out.close();
//    }
//}
