package fansir.me.springweb.common.security.xss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Name: XssHttpRequestWrapper
 * Description: wrap http request for sanitizing XSS attack parameters
 * 
 *
 */
public class XssHttpRequestWrapper extends HttpServletRequestWrapper {
    private static final Logger logger = LoggerFactory.getLogger(XssHttpRequestWrapper.class);

    private Map<String, String[]> sanitized;
    private Map<String, String[]> orig;

    @SuppressWarnings("unchecked")
    public XssHttpRequestWrapper(HttpServletRequest request) {
        super(request);
        orig = request.getParameterMap();
        sanitized = getParameterMap(); // NOSONAR
        if (logger.isDebugEnabled())
            snzLog();
    }

    @Override
    public String getParameter(String name) {
        String[] vals = getParameterMap().get(name);
        if (vals != null && vals.length > 0)
            return vals[0];
        else
            return null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        if (sanitized == null)
            sanitized = sanitizeParamMap(orig);
        return sanitized;

    }

    @Override
    public String[] getParameterValues(String name) {
        return getParameterMap().get(name);
    }

    private Map<String, String[]> sanitizeParamMap(Map<String, String[]> raw) {
        Map<String, String[]> res = new HashMap<String, String[]>();
        if (raw == null)
            return res;

        for (Iterator<Entry<String, String[]>> itor = raw.entrySet().iterator(); itor.hasNext();) {
            Entry<String, String[]> entry = itor.next();
            String[] rawVals = entry.getValue();
            String[] snzVals = new String[rawVals.length];
            for (int i = 0; i < rawVals.length; i++) {
                PolicyFactory policy = Sanitizers.FORMATTING;
                snzVals[i] = policy.sanitize(rawVals[i]);
            }
            res.put(entry.getKey(), snzVals);
        }
        return res;
    }

    private void snzLog() {
        for (String key : (Set<String>) orig.keySet()) {
            String[] rawVals = orig.get(key);
            String[] snzVals = sanitized.get(key);
            if (rawVals != null && rawVals.length > 0) {
                for (int i = 0; i < rawVals.length; i++) {
                    if (rawVals[i].equals(snzVals[i]))
                        logger.trace("Sanitization. Param seems safe: " + key + "[" + i + "]=" + snzVals[i]);
                    else
                        logger.debug("Sanitization. Param modified: " + key + "[" + i + "]=" + snzVals[i]);
                }
            }
        }
    }

}
