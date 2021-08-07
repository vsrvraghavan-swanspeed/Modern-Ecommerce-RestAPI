package com.orders;

import com.nitsoft.ecommerce.database.model.Orders;
import com.nitsoft.ecommerce.repository.OrdersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

class SimulatedOrdersRepositoryImpl implements OrdersRepository  {
    @Override
    public Page<Orders> findAllByCompanyId(long companyId, Pageable pageable) {
        return null;
    }

    @Override
    public Orders findOneByIdAndCompanyId(Long orderId, Long companyId) {
        return null;
    }

    @Override
    public Orders findOne(Specification<Orders> specification) {
        return null;
    }

    @Override
    public List<Orders> findAll(Specification<Orders> specification) {
        return null;
    }

    @Override
    public Page<Orders> findAll(Specification<Orders> specification, Pageable pageable) {
        return null;
    }

    @Override
    public List<Orders> findAll(Specification<Orders> specification, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<Orders> specification) {
        return 0;
    }

    @Override
    public Iterable<Orders> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Orders> S save(S s) {
        return null;
    }

    @Override
    public <S extends Orders> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Orders findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Orders> findAll() {
        return null;
    }

    @Override
    public Iterable<Orders> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Orders orders) {

    }

    @Override
    public void delete(Iterable<? extends Orders> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
