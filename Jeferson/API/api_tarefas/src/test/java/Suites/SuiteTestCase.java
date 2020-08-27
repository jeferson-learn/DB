package Suites;

import TestCase.LoginTestCase;
import TestCase.LogoutTestCase;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectPackages("TestCase")
@SelectClasses({LoginTestCase.class, LogoutTestCase.class})
public class SuiteTestCase {

}
