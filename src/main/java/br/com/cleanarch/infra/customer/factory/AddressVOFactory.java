package br.com.cleanarch.infra.customer.factory;

import br.com.cleanarch.domain.customer.valueobject.AddressVO;
import br.com.cleanarch.infra.customer.entity.AddressVOEntity;
import br.com.cleanarch.infra.shared.factory.IFactory;
import org.springframework.stereotype.Component;

@Component
public class AddressVOFactory implements IFactory<AddressVO, AddressVOEntity> {

    @Override
    public AddressVO toModel(AddressVOEntity entity) {
        return new AddressVO(entity.getStreet(), entity.getCity(), entity.getState(), entity.getZipCode());
    }

    @Override
    public AddressVOEntity toEntity(AddressVO address) {
        return new AddressVOEntity(address.getStreet(), address.getCity(), address.getState(), address.getZipCode());
    }
}
