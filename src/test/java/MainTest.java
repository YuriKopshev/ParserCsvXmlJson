import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static String json;

    @BeforeEach
    public void read() {
        json = Main.readString("data1.json");
    }

    @Test
    public void readString() {
        String expected = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25},{\"id\":2," +
                "\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        String actual = Main.readString("data1.json");
        assertThat(expected, is(actual));
    }

    @Test
    public void jsonToList() {
        List<Employee> actualList;
        actualList = Main.jsonToList(json);
        assertThat(actualList.get(0).id, is(1L));
        assertThat(actualList.get(0).firstName, is("John"));
    }

    @Test
    public void jsonToListSize() {
        List<Employee> actualList;
        actualList = Main.jsonToList(json);
        assertThat(actualList, hasSize(2));
    }

    @Test
    public void parseXmlToList() {
        List<Employee> actualList;
        actualList = Main.parseXML("data.xml");
        assertThat(actualList.get(1).id,is(2L));
        assertThat(actualList.get(1).country,is("RU"));
    }


}