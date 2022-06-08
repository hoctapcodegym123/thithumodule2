package Validate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validate {
    Scanner input = new Scanner(System.in);


    public int importInt(String name) {
        while (true) {
            try {
                System.out.println("Nhập " + name);
                int result = Integer.parseInt(input.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                importInt(name);

            }
        }
    }

    public double importDouble(String name) {
        while (true) {
            try {
                System.out.println("Nhập " + name);
                double result = Double.parseDouble(input.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                importDouble(name);

            }
        }
    }

    public Date importDate(String name) {
        while (true) {
            try {
                System.out.println("Nhập " + name);
                Date result = new SimpleDateFormat("dd/MM/yyyy").parse(input.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại. ví dụ: 08/06/2022");
                importDate(name);
            }
        }
    }


    public String importString(String name) {
        while (true) {
            try {
                System.out.println("Nhập " + name);
                String result = input.nextLine();
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                importString(name);
            }
        }
    }

    public int choice(String option) {
        while (true) {
            try {
                System.out.println("Nhập " + option);
                int button = Integer.parseInt(input.nextLine());
                if (button > 0 || button < 9) {
                    return button;
                } else {
                    return choice(option);
                }
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                importInt(option);
            }
        }
    }

}
