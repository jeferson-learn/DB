package Suites;

import TestCase.ListTaskTestCase;
import TestCase.LoginTestCase;
import TestCase.LogoutTestCase;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({LoginTestCase.class, ListTaskTestCase.class, LogoutTestCase.class})
public class ListTarefaSuiteTestCase {

}
