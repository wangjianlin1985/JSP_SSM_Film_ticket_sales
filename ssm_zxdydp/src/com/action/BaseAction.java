// 
// 
// 

package com.action;

import org.json.JSONException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.Map;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;

@Controller
public class BaseAction
{
    protected final Log log;
    
    public BaseAction() {
        this.log = LogFactory.getLog((Class)this.getClass());
    }
    
    public Map<String, String[]> getParameters() {
        final ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return (Map<String, String[]>)attrs.getRequest().getParameterMap();
    }
    
    public HttpServletRequest getRequest() {
        final ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
    
    public HttpSession getSession() {
        HttpSession session = null;
        try {
            session = this.getRequest().getSession();
        }
        catch (Exception ex) {}
        return session;
    }
    
    public void writeJsonResponse(final String success) throws IOException, JSONException {
        final ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        final HttpServletResponse response = attrs.getResponse();
        response.setContentType("text/json;charset=UTF-8");
        final PrintWriter out = response.getWriter();
        final JSONObject json = new JSONObject();
        json.accumulate("result", (Object)success);
        System.out.println(json.toString());
        out.println(json.toString());
        out.flush();
        out.close();
    }
}
