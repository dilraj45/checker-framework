package tests;

import java.io.File;
import java.util.List;
import org.checkerframework.framework.test.FrameworkPerDirectoryTest;
import org.junit.runners.Parameterized.Parameters;
import testlib.util.FlowTestChecker;

/** */
public class FlowTest extends FrameworkPerDirectoryTest {

    public FlowTest(List<File> testFiles) {
        super(testFiles, FlowTestChecker.class, "flow", "-Anomsgtext");
    }

    @Parameters
    public static String[] getTestDirs() {
        return new String[] {"flow", "all-systems"};
    }
}
