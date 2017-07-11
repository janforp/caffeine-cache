package com.janita.caffeinecache.service;

import com.janita.caffeinecache.bean.Person;
import com.janita.caffeinecache.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/7/11- 16:37
 * 该类是:
 */
@Service
public class PersonService {

    @Autowired(required = false)
    private PersonDAO personDAO;

    /**
     * 根据id获取Person对象，使用缓存
     * @param id
     * @return Person对象
     * 缓存使用20秒
     * 20秒之内即使是修改了数据库,接口的结果也不会变
     * 因为缓存了20秒
     */
    @Cacheable(value="getPersonById", sync=true)
    public Person getPersonById(int id){
        return personDAO.selectByPrimaryKey(id);
    }

    public Person add(Person person) {
        personDAO.insert(person);
        return person;
    }
}
