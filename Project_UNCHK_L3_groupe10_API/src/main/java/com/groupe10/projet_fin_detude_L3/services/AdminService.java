package com.groupe10.projet_fin_detude_L3.services;

import com.groupe10.projet_fin_detude_L3.models.Admin;

public interface AdminService {

    public Admin addAdmin(Admin admin);
    public Admin getOneAdmin(int idAdmin);
    public Admin updateAdmin(int idAdmin, Admin admin);

}
