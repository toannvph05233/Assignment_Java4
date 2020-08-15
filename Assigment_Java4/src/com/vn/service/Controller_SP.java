package com.vn.service;

import java.util.ArrayList;

import com.vn.model.Product;

public class Controller_SP {
	ProductService productService = new ProductService();

    public void createSP(ArrayList<Product> arrayList, Product sanPham) {
    	productService.saveProduct(sanPham);
        arrayList.add(sanPham);
    }

    public void editSP(ArrayList<Product> arrayList, Product sanPham, int index) {
    	productService.updateProduct(sanPham);
        arrayList.set(index, sanPham);
    }

    public void deleteSP(ArrayList<Product> arrayList, int index) {
    	productService.deleteProduct(arrayList.get(index));
        arrayList.remove(index);
    }

//    public NguoiDung findByIdND(ArrayList<NguoiDung> arrayList, String user) {
//        for (NguoiDung x : arrayList) {
//            if (x.getUser().equals(user)) {
//                return x;
//            }
//        }
//        return null;
//    }

    public Product findByIdSP(ArrayList<Product> arrayList, String user) {
        for (Product x : arrayList) {
            if (x.getIdSanPham().equals(user)) {
                return x;
            }
        }
        return null;
    }

    public int findIdSP(ArrayList<Product> arrayList, String idSP) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getIdSanPham().equals(idSP)) {
                return i;
            }
        }
        return -1;
    }
}
