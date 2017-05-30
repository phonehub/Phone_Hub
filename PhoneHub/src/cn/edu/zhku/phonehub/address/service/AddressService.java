package cn.edu.zhku.phonehub.address.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.zhku.phonehub.address.dao.AddressDao;
import cn.edu.zhku.phonehub.address.model.Address;

public class AddressService {

	AddressDao addressDao = new AddressDao();

	public void add(Address address) throws ClassNotFoundException,
			SQLException {
		addressDao.insert(address);

	}

	public void delete(int userId, int addressId)
			throws ClassNotFoundException, SQLException {
		addressDao.delete(userId, addressId);

	}

	public List<Address> get(int userId) throws ClassNotFoundException,
			SQLException {
		return addressDao.getAddressByUserId(userId);

	}

	public void setDegfault(int userId, int addressId)
			throws ClassNotFoundException, SQLException {
		List<Address> list = addressDao.getAddressByUserId(userId);
		if (list != null) {

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getAddressId() != addressId)
					list.get(i).setIfdefault(0);
				else {
					list.get(i).setIfdefault(1);
				}
				addressDao.update(list.get(i));

			}

		}

	}

	public void Update(int addressId, int userId, Address address)
			throws ClassNotFoundException, SQLException {

		List<Address> list = addressDao.getAddressByUserId(userId);
		if (list != null) {

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getAddressId() == addressId) {
					address.setIfdefault(list.get(i).getIfdefault());

					addressDao.update(address);
				}

			}
		}
	}

}
