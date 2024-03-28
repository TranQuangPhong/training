package phong.kafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.TestInputTopic;
import org.apache.kafka.streams.TestOutputTopic;
import org.apache.kafka.streams.TopologyTestDriver;
import org.apache.kafka.streams.test.TestRecord;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StreamStarterAppTest {

    TopologyTestDriver testDriver;
    TestInputTopic<String, String> inputTopic;
    TestOutputTopic<String, Long> outputTopic;

    @Before
    public void setup() {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "test");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamStarterApp streamStarterApp = new StreamStarterApp();
        testDriver = new TopologyTestDriver(streamStarterApp.initTopology(), config);

        inputTopic = testDriver.createInputTopic("word-count-input",
                Serdes.String().serializer(),
                Serdes.String().serializer());
        outputTopic = testDriver.createOutputTopic("word-count-output",
                Serdes.String().deserializer(),
                Serdes.Long().deserializer());

    }

    @After
    public void closeTopologyTestDriver() {
        testDriver.close();
    }

    @Test
    public void dummyTest() {
        String dummy = "dum" + "my";
        Assert.assertEquals("dummy", dummy);
    }

    @Test
    public void testStreamCounts() {

        inputTopic.pipeInput(new TestRecord<>(null, "testing Kafka Streams"));

        List<TestRecord<String, Long>> testRecordList = outputTopic.readRecordsToList(); //Read keys vs values instead to ignore record time field.
        ArrayList<TestRecord<String, Long>> expectArrayList = new ArrayList<>();
        expectArrayList.add(new TestRecord<>("testing", 1L, testRecordList.get(0).getRecordTime()));
        expectArrayList.add(new TestRecord<>("kafka", 1L, testRecordList.get(1).getRecordTime()));
        expectArrayList.add(new TestRecord<>("streams", 1L, testRecordList.get(2).getRecordTime()));

        //1st message count
        MatcherAssert.assertThat("Message 1 - Correct number of elements", testRecordList.size(), new IsEqual<>(3));
        MatcherAssert.assertThat("Message 1 - Same keys & values", testRecordList, new IsEqual<>(expectArrayList));

        //2nd message count
        inputTopic.pipeInput(new TestRecord<>(null, "testing KAFKA Streams second message"));
        //Read again - previous messages have been processed & will not be read
        testRecordList = outputTopic.readRecordsToList();
        expectArrayList.set(0, new TestRecord<>("testing", 2L, testRecordList.get(0).getRecordTime()));
        expectArrayList.set(1, new TestRecord<>("kafka", 2L, testRecordList.get(1).getRecordTime()));
        expectArrayList.set(2, new TestRecord<>("streams", 2L, testRecordList.get(2).getRecordTime()));
        expectArrayList.add(new TestRecord<>("second", 1L, testRecordList.get(3).getRecordTime()));
        expectArrayList.add(new TestRecord<>("message", 1L, testRecordList.get(4).getRecordTime()));

        MatcherAssert.assertThat("Message 2 - Correct number of elements", testRecordList.size(), new IsEqual<>(5));
        MatcherAssert.assertThat("Message 2 - Same keys & values", testRecordList, new IsEqual<>(expectArrayList));

    }

    @Test
    public void testStreamsLowerCase(){
        inputTopic.pipeInput(new TestRecord<>(null, "kaFKa KAFKA KaFK@"));
        List<TestRecord<String, Long>> testRecordList = outputTopic.readRecordsToList(); //Read keys vs values instead to ignore record time field.
        ArrayList<TestRecord<String, Long>> expectArrayList = new ArrayList<>();
        expectArrayList.add(new TestRecord<>("kafka", 1L, testRecordList.get(0).getRecordTime()));
        expectArrayList.add(new TestRecord<>("kafka", 2L, testRecordList.get(1).getRecordTime()));
        expectArrayList.add(new TestRecord<>("kafk@", 1L, testRecordList.get(2).getRecordTime()));

        MatcherAssert.assertThat("Correct number of elements", testRecordList.size(), new IsEqual<>(3));
        MatcherAssert.assertThat("Same keys & values", testRecordList, new IsEqual<>(expectArrayList));
    }
}
