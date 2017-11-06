package by.makedon.generator.creator;

import by.makedon.generator.randomizer.Randomizer;

public class QueryCreator {
    public String create() {
        Randomizer randomizer = new Randomizer();
        return "INSERT INTO person_information VALUES (null,\"" + randomizer.createFirstname() + "\",\"" +
                randomizer.createLastname() + "\"," + randomizer.createPhone() + ",\"" + randomizer.createEmail() + "\",\"" +
                randomizer.createSkype() + "\");";
    }
}
