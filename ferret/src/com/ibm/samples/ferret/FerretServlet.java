/*******************************************************************************
 * Copyright (c) 2014 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ibm.samples.ferret;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.samples.ferret.html.Element;
import com.ibm.samples.ferret.html.Page;
import com.ibm.samples.ferret.html.Element.ElementType;

@WebServlet("/*")
public final class FerretServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        writeResponse(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        writeResponse(request, response);
    }

    @Override
    protected void doPut(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        writeResponse(request, response);
    }

    @Override
    protected void doDelete(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        writeResponse(request, response);
    }

    private FerretData getFerretData(final HttpServletRequest httpServletRequest) {
        return new FerretData(getServletConfig(), getServletContext(), httpServletRequest);
    }

    private void writeResponse(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final String data = getFerretData(request).toString();
        final PrintWriter writer = response.getWriter();
        writer.println(new Page().withBodyElement(new Element(ElementType.DIV).withInnerHtml(data)).toHtml());
    }

}
