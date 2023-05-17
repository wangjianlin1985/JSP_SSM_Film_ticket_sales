// 
// 
// 

package com.util;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PageHelper
{
    public static void getPage(final List<?> list, final String name, final List<String> nameList, final List<String> valueList, final int pageSize, String number, final HttpServletRequest request, final String method) {
        final StringBuffer buffer = new StringBuffer();
        final String name2 = String.valueOf(name.substring(0, 1).toUpperCase()) + name.substring(1);
        String path = "";
        String action = "getAll" + name2 + ".action";
        if (method != null) {
            action = "query" + name2 + "ByCond.action";
        }
        final List<Object> objList = new ArrayList<Object>();
        if (nameList != null && valueList != null) {
            for (int i = 0; i < nameList.size(); ++i) {
                path = String.valueOf(path) + "&" + nameList.get(i) + "=" + valueList.get(i);
            }
        }
        int maxPage;
        final int pageNumber = maxPage = list.size();
        if (maxPage % 10 == 0) {
            maxPage /= 10;
        }
        else {
            maxPage = maxPage / 10 + 1;
        }
        if (number == null) {
            number = "0";
        }
        final int start = Integer.parseInt(number) * 10;
        int over = (Integer.parseInt(number) + 1) * 10;
        final int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int j = start; j < over; ++j) {
            final Object obj = list.get(j);
            objList.add(obj);
        }
        buffer.append("&nbsp;&nbsp;\u5171\u4e3a");
        buffer.append(maxPage);
        buffer.append("\u9875&nbsp; \u5171\u6709");
        buffer.append(pageNumber);
        buffer.append("\u6761&nbsp; \u5f53\u524d\u4e3a\u7b2c");
        buffer.append(Integer.parseInt(number) + 1);
        buffer.append("\u9875 &nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u9996\u9875");
        }
        else {
            buffer.append("<a href=\"" + name + "/" + action + "?number=0" + path + "\">\u9996\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (Integer.parseInt(number) + 1 == 1) {
            buffer.append("\u4e0a\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"" + name + "/" + action + "?number=" + (Integer.parseInt(number) - 1) + path + "\">\u4e0a\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u4e0b\u4e00\u9875");
        }
        else {
            buffer.append("<a href=\"" + name + "/" + action + "?number=" + (Integer.parseInt(number) + 1) + path + "\">\u4e0b\u4e00\u9875</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= Integer.parseInt(number) + 1) {
            buffer.append("\u5c3e\u9875");
        }
        else {
            buffer.append("<a href=\"" + name + "/" + action + "?number=" + (maxPage - 1) + path + "\">\u5c3e\u9875</a>");
        }
        final String html = buffer.toString();
        request.setAttribute("html", (Object)html);
        request.setAttribute(String.valueOf(name) + "List", (Object)objList);
    }
}
