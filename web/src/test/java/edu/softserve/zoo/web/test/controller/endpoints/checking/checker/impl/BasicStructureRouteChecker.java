package edu.softserve.zoo.web.test.controller.endpoints.checking.checker.impl;

import edu.softserve.zoo.web.test.controller.endpoints.checking.CheckResult;
import edu.softserve.zoo.web.test.controller.endpoints.checking.checker.RouteChecker;
import edu.softserve.zoo.web.test.controller.endpoints.Route;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Checks the basic route structure.
 * The route should start with api/v[number, one digit] and then has optional blocks
 * that contains backslash delimiter and resource identifier that contains only lowercase
 * characters from a to z and hyphens.</p>
 *
 * @author Bohdan Cherniakh
 */
@Component
public class BasicStructureRouteChecker implements RouteChecker {

    /*
    * Regex that is used to check the URI pattern
    * The pattern is:
    * /api/v[number, one digit]/[basic resource id, required]/[parameter in {}, optional]/[resource id, optional]
    */
    private static final String BASIC_STRUCTURE_REGEX = "^/api/v\\d/(?:[a-z-]+)((?:/\\{[a-z-]+\\})(?:/[a-z-]+)?)?$";
    private static final String EXCLUDE_STRUCTURE_REGEX = "^/api/v\\d/[a-z-]+/[a-z-]+$";

    private static final String ERROR_MESSAGE_PATTERN = "%s breaks the basic route structure!";
    private static final Pattern BASIC_STRUCTURE_PATTERN = Pattern.compile(BASIC_STRUCTURE_REGEX);
    private static final Pattern EXCLUDE_STRUCTURE_PATTERN = Pattern.compile(EXCLUDE_STRUCTURE_REGEX);

    @Override
    public CheckResult check(Route route) {
        CheckResult checkResult = new CheckResult();
        Matcher matcher = BASIC_STRUCTURE_PATTERN.matcher(route.getUri());
        Matcher excludeMather = EXCLUDE_STRUCTURE_PATTERN.matcher(route.getUri());
        if (!matcher.matches() && !excludeMather.matches()) {
            checkResult.addError(String.format(ERROR_MESSAGE_PATTERN, route.toString()));
        }
        return checkResult;
    }
}
