package Suites;

import TestCase.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectPackages("TestCase")
//@SelectClasses({LoginTestCase.class, CreateTaskTestCase.class, ListTaskTestCase.class, LogoutTestCase.class})
@SelectClasses({LoginTestCase.class, EditTaskTestCase.class, ListTaskTestCase.class, LogoutTestCase.class})
//@SelectClasses({LoginTestCase.class, ListTaskTestCase.class, LogoutTestCase.class})
public class SuiteTestCase {

}
