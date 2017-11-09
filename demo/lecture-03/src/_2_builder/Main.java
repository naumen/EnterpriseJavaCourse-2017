package _2_builder;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        SubProgram someSubProgram1_1 = new SubProgram(
                true,
                9000,
                new KeyProcessor(Arrays.asList("w", "s"), Collections.emptyList()),
                null,
                null,
                null,
                null
        );

        SubProgram someSubProgram2_1 = new SubProgram(
                false,
                8000,
                new KeyProcessor(Collections.singletonList("e"), Collections.emptyList()),
                null,
                null,
                null,
                null
        );





        SubProgramBuilder builder = new SubProgramBuilder();

        SubProgram someSubProgram1_2 = builder
                .withGui(true)
                .port(9000)
                .responseToKey("w")
                .responseToKey("a")
                .build();


        SubProgram someSubProgram2_2 = new SubProgramBuilder()
                .port(8000)
                .responseToKey("e")
                .build();
    }
}
