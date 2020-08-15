package com.vn.service;

import java.util.ArrayList;

import com.vn.model.NguoiDungEntity;

public class Controller_ND {
	NguoiDungService nguoiDungService = new NguoiDungService();

    public void createND(ArrayList<NguoiDungEntity> arrayList, NguoiDungEntity nguoiDung) {
    	nguoiDungService.saveNguoiDung(nguoiDung);
        arrayList.add(nguoiDung);
    }

    public void editND(ArrayList<NguoiDungEntity> arrayList, NguoiDungEntity nguoiDung, int index) {
    	nguoiDungService.updateNguoiDung(nguoiDung);
        arrayList.set(index, nguoiDung);
    }

    public void deleteND(ArrayList<NguoiDungEntity> arrayList, int index) {
    	nguoiDungService.deleteNguoiDung(arrayList.get(index));
        arrayList.remove(index);
    }

    public NguoiDungEntity findByIdND(ArrayList<NguoiDungEntity> arrayList, String user) {
        for (NguoiDungEntity x : arrayList) {
            if (x.getIdUser().equals(user)) {
                return x;
            }
        }
        return null;
    }

    public int findIndexND(ArrayList<NguoiDungEntity> arrayList, String user) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getIdUser().equals(user)) {
                return i;
            }
        }
        return -1;
    }
}
