package DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(String Id) {
        return new Customer(Id, "Raj Mohan");
    }

}
