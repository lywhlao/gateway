package com.example.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext rc=RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        boolean token = request.getParameterMap().containsKey("token");
        if(!token){
            rc.setResponseStatusCode(401);
            rc.setSendZuulResponse(false);
            rc.setResponseBody("no token");
            return null;
        }
        return null;
    }
}