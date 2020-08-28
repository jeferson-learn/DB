package Suites;

import TestCase.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({LoginTestCase.class, CreateTaskTestCase.class, ListTaskTestCase.class, LogoutTestCase.class})
public class CreateTaskSuiteTestCase {

}
