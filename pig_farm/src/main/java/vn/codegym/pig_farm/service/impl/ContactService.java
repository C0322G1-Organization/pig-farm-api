package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Contact;
import vn.codegym.pig_farm.repository.IContactRepository;
import vn.codegym.pig_farm.service.IContactService;

@Service
public class ContactService implements IContactService {
    @Autowired
    private IContactRepository contactRepository;

    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: Delete Contact
     */
    @Override
    public void deleteContact(Integer[] ids) {
        for (Integer id : ids) {
            contactRepository.deleteContact(id);
        }
    }

    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: getAll Contact
     */
    @Override
    public Page<Contact> getAll(Pageable pageable, String name) {
        return contactRepository.findAll(pageable, "%" + name + "%");
    }
    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: find by id Contact
     */
    @Override
    public Contact findByIdContact(int id) {
        return contactRepository.findByIdContact(id);
    }


}
