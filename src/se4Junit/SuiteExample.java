package se4Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ColorTest.class, FirstJunitTest.class })
public class SuiteExample {

}
