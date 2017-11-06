package by.makedon.generator.randomizer;

import static by.makedon.generator.criteria.Criteria.*;

public class Randomizer {
    public String createFirstname() {
        int index = (int) (Math.random() * 15);
        return Firstname.values()[index].toString();
    }

    public String createLastname() {
        int index = (int) (Math.random() * 15);
        return Lastname.values()[index].toString();
    }

    public String createPhone() {
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        int num3 = (int) (Math.random() * 10);
        int num4 = (int) (Math.random() * 10);
        int num5 = (int) (Math.random() * 10);
        int num6 = (int) (Math.random() * 10);
        int num7 = (int) (Math.random() * 10);
        return "29" + num1 + num2 + num3 + num4 + num5 + num6 + num7;
    }

    public String createEmail() {
        int index = (int) (Math.random() * 15);
        return Email.values()[index].toString() + "@gmail.com";
    }

    public String createSkype() {
        int index = (int) (Math.random() * 15);
        return Skype.values()[index].toString();
    }
}