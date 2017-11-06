package by.makedon.generator.main;

import by.makedon.generator.generator.Generator;

public class Main {
    public static void main(String[] args) {
        String arg;
        if (args.length != 0) {
            arg = args[0];
        } else {
            arg = "10";
        }
        Generator generator = new Generator();
        generator.generate(arg);
    }
}
