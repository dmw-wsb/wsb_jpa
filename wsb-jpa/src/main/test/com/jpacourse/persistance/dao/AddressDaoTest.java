package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.entity.AddressEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    @Test
    public void testShouldFindAddressById() {
        // Given
        Long addressId = 2L; // ID adresu: Oak Avenue

        // When
        AddressEntity address = addressDao.findById(addressId);

        // Then
        assertThat(address).isNotNull();
        assertThat(address.getAddressLine1()).isEqualTo("Oak Avenue");
        assertThat(address.getAddressLine2()).isEqualTo("Suite 202");
        assertThat(address.getCity()).isEqualTo("Cracow");
        assertThat(address.getPostalCode()).isEqualTo("31-002");
    }





    @Test
    public void testShouldSaveAddress() {
        // Given a new address entity
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("Park Avenue");
        addressEntity.setAddressLine2("Suite 101");
        addressEntity.setCity("New York");
        addressEntity.setPostalCode("10022");
        long entitiesNumBefore = addressDao.count();

        // When saving the address
        final AddressEntity saved = addressDao.save(addressEntity);

        // Then verify the saved entity
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore + 1);
    }

    @Test
    public void testShouldCheckVersion() {
        // Given a new address entity
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("Broadway");
        addressEntity.setAddressLine2("Apt 5A");
        addressEntity.setCity("Chicago");
        addressEntity.setPostalCode("60614");

        final AddressEntity saved = addressDao.save(addressEntity);

        // Assert initial version
        assertThat(saved.version).isEqualTo(0L);

        // When updating the entity
        saved.setCity("Los Angeles");
        final AddressEntity updated = addressDao.update(saved);

        // Then version should increment
        assertThat(updated.version).isEqualTo(1L);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // Given a new address entity
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("Main Street");
        addressEntity.setAddressLine2("Building 12");
        addressEntity.setCity("Seattle");
        addressEntity.setPostalCode("98101");

        // When saving and removing the address
        final AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();

        addressDao.delete(saved.getId());

        // Then verify the address is removed
        final AddressEntity removed = addressDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }
}
