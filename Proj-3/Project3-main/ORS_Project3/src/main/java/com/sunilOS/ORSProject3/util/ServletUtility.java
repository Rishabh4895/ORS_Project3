package com.sunilOS.ORSProject3.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunilOS.ORSProject3.ctl.BaseCtl;
import com.sunilOS.ORSProject3.ctl.ORSView;
import com.sunilOS.ORSProject3.dto.BaseDTO;

/**
 * ServletUtility provides the servlet util services 
 * @author Rishabh Gurjar
 *
 */


public class ServletUtility {
	 
    public static void forward(String page, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

   
    public static void redirect(String page, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect(page);
    }

    
    public static void handleException(Exception e, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("exception", e);
        response.sendRedirect(ORSView.ERROR_CTL);

    }

   
    public static String getErrorMessage(String property,
            HttpServletRequest request) {
        String val = (String) request.getAttribute(property);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    
    public static String getMessage(String property, HttpServletRequest request) {
        String val = (String) request.getAttribute(property);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

    
    public static void setErrorMessage(String msg, HttpServletRequest request) {
        request.setAttribute(BaseCtl.MSG_ERROR, msg);
    }

    
    public static String getErrorMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute(BaseCtl.MSG_ERROR);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

        public static void setSuccessMessage(String msg, HttpServletRequest request) {
        request.setAttribute(BaseCtl.MSG_SUCCESS, msg);
    }

   
    public static String getSuccessMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute(BaseCtl.MSG_SUCCESS);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

        public static void setDTO(BaseDTO dto, HttpServletRequest request) {
        request.setAttribute("dto", dto);
    }

    

    public static BaseDTO getDto(HttpServletRequest request) {
        return (BaseDTO) request.getAttribute("dto");
    }

   

    public static String getParameter(String property,
            HttpServletRequest request) {
        String val = (String) request.getParameter(property);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

       public static void setList(List list, HttpServletRequest request) {
        request.setAttribute("list", list);
    }

    
    public static List getList(HttpServletRequest request) {
        return (List) request.getAttribute("list");
    }

   
    public static void setPageNo(int pageNo, HttpServletRequest request) {
        request.setAttribute("pageNo", pageNo);
    }

    
    public static int getPageNo(HttpServletRequest request) {
    	 int a=  (Integer) request.getAttribute("pageNo");
         return a;
    }

        public static void setPageSize(int pageSize, HttpServletRequest request) {
        request.setAttribute("pageSize", pageSize);
    }

    
    public static int getPageSize(HttpServletRequest request) {
        int pageSize= (Integer) request.getAttribute("pageSize");
        return pageSize;
     }
   
}
