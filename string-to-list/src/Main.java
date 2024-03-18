import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommonServiceImpl service = new CommonServiceImpl();
        String inputString = null;

        List<Integer> output = service.stringToListInteger(inputString, ",");
        System.out.println(output);
        boolean isContain = false;
        isContain = service.contains(output, 2);
        System.out.println(isContain);
    }
}
