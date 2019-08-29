package thrift.generated;

import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("getPersonByUsername, Get Client param#" + username);
        Person person = new Person();
        person.setAge(20);
        person.setName(username);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("savePerson, Get Client Param#");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
