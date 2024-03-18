
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonServiceImpl {

    public List<String> stringToList(
            String inputString,
            String delimiter) {

        List<String> outList = new ArrayList<>();
        try {
            outList = new ArrayList<String>(Arrays.asList(inputString.split(delimiter)));
        } catch (Exception e) {

        }
        return outList;
    }


    public List<Integer> stringToListInteger(String inputString, String delimiter) {

        List<Integer> outList = new ArrayList<>();
        try {
            outList = Arrays.asList(inputString.split(delimiter)).stream()
                    .map((item) -> Integer.parseInt(item)).collect(Collectors.toList());

        } catch (Exception e) {

        }
        return outList;
    }

    public Boolean contains(List<Integer> listInteger, Integer num) {
        boolean isContain = false;
        try {
            isContain = listInteger.contains(num);
        } catch (Exception e) {

        }

        return isContain;
    }
}
