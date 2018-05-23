/*
 *  Copyright (c) 2014-2018 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.kumuluz.ee.samples.jaxws.cxf.interceptors;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.xml.ws.WebServiceContext;
import java.util.logging.Logger;

/**
 * @author gpor89
 * @since 3.0.0
 */
public class WsInterceptor {

    private static final Logger LOG = Logger.getLogger(WsInterceptor.class.getName());

    @Resource(name = "wsContext")
    private WebServiceContext webServiceContext;

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        Object soapAction = webServiceContext.getMessageContext().get("SOAPAction");

        LOG.fine("Soap action: " + soapAction);

        return context.proceed();
    }
}
