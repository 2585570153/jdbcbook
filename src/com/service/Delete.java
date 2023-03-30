package com.service;

import com.dao.ListBook;
import com.dao.Listlog;

public class Delete {

    public Delete(int id ) {
        ListBook.delete(id);

    }
}
