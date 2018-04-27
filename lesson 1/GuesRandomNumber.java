import java.io.*;
import java.util.*;

public class GuesRandomNumber {
    public static void main(String args[]) throws Exception {
        System.setProperty("console.encoding","UTF-8");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        print("����� ���������� � ��������. ��� ������ ������� exit");

        Integer input;
        Boolean play = true;
        while (play) {
            Integer randomNumber = setRandomNumber();
            print("������! � ������� ����� �� 0 �� 100. ������ �����?");
            while (true) {
                String temp = reader.readLine();
                if (temp.equalsIgnoreCase("exit")) {
                    break;
                }
                try {
                    input = Integer.parseInt(temp);
                } catch (Exception ex) {
                    continue;
                }
                if (input > randomNumber) {
                    print("���, � ������� ����� ��������.");
                } else if (input < randomNumber) {
                    print("���, � ������� ����� ��������.");
                } else if (input == randomNumber) {
                    print("��-��! �� ������ �� �����!!!");
                    print("������ ������� ��� ���?");
                    print("����� \"yes\", ���� ������");
                    play = reader.readLine().equalsIgnoreCase("yes");
                    break;
                }
            }
        }

    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static Integer setRandomNumber() {
        Long seed = new Date().getTime();
        Random random = new Random(seed);
        return random.nextInt(100);
    }

}