package Manager;

import Models.Product;
import Validate.Validate;
import io.ReaderAndWriter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductManage {
    List<Product> products = new ArrayList<>();
    Validate valiDate = new Validate();

    ReaderAndWriter readAndWriteFile = new ReaderAndWriter();

    {
        readAndWriteFile.readFile(products);
    }

    public void productManageMenu() {
        System.out.println("Menu :");
        System.out.println("1. Show danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm mới");
        System.out.println("3. Chỉnh sửa sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Viết từ file");
        System.out.println("9. Thoát");

        int choice = valiDate.choice("option");

        switch (choice) {
            case 1:
                showProductList();
                break;
            case 2:
                addNewProduct();
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                sortFllowPrice();
                break;
            case 6:
                findFllowMaxPrice();
                break;
            case 7:
                readFromFile();
                break;
            case 8:
                writetoFile();
                break;
            case 9:
                System.exit(0);
        }
    }

    public void showProductList() {
        System.out.println("Danh sách sản phẩm:");
        for (Product pt : products) {
            System.out.println(pt);
        }
    }

    public void addNewProduct() {
        products.add(creatNewProduct());
    }

    public void editProduct() {
        String id = valiDate.importString("id muốn chỉnh sửa trong danh sách.");
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                products.set(i, creatNewProduct());
                break;
            } else {
                System.out.println("Không tồn tại id trong danh sách");
                productManageMenu();
            }
        }
    }

    public void deleteProduct() {
        String id = valiDate.importString("id muốn xóa trong danh sách.");
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                products.remove(i);
                break;
            } else {
                System.out.println("Không tồn tại id.");
                productManageMenu();
            }
        }
    }

    public void sortFllowPrice() {
        Collections.sort(products);
    }

    public void findFllowMaxPrice() {
        Collections.sort(products);
        System.out.println("Sản phẩm đắt nhất là " + products.get(products.size() - 1).toString());
    }

    public void readFromFile() {
        readAndWriteFile.readFile(products);
    }

    //   case 8
    public void writetoFile() {
        readAndWriteFile.writeFile(products);
    }


    public Product creatNewProduct() {
        System.out.println("Nhập thông tin sản phẩm mới: ");
        String id = valiDate.importString("id");
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                System.out.println("id bị trùng , vui lòng chọn lại id .");
                creatNewProduct();
            }
        }
        String name = valiDate.importString("tên sản phẩm");
        double price = valiDate.importDouble("giá sản phẩm");
        double amount = valiDate.importDouble("nhập số lượng");
        String describe = valiDate.importString("mô tả sản phẩm");

        Product product = new Product(id, name, price, amount, describe);
        return product;
    }
}
