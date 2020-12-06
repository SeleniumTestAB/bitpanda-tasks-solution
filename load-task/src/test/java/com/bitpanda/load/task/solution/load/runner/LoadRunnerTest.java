package com.bitpanda.load.task.solution.load.runner;

import com.bitpanda.load.task.solution.LoadTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.domain.TestMappings;
import org.jsmart.zerocode.jupiter.extension.ParallelLoadExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@LoadWith("load_generation.properties")
@ExtendWith({ParallelLoadExtension.class})

public class LoadRunnerTest {

    @Test
    @TestMappings({
            @TestMapping(testClass = LoadTest.class, testMethod = "getToHomePageTest1")
    })
    public void testTheLoad() {

    }


}
