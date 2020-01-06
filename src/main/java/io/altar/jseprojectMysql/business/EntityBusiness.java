package io.altar.jseprojectMysql.business;

import java.util.Collection;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.jseprojectMysql.model.Entity_;
import io.altar.jseprojectMysql.repositories.EntityRepository;

@Transactional
public abstract class EntityBusiness<R extends EntityRepository<E>, E extends Entity_> implements BusinessServiceInterface<E> {
	
	@Inject
	protected R repository;

	
	@Override
	public void create(E entity) {
		repository.create(entity);

	}

	@Override
	public void remove(E entity) {
		repository.remove(entity);

	}

	@Override
	public void edit(E entity) {
		repository.edit(entity);

	}

	@Override
	public Collection<E> getAll() {
		return repository.getAll();

	}

	@Override
	public E getbyId(long id) {
		E entity = repository.getbyId(id);
		if (entity == null) {
			//throw new IllegalArgumentException("id does not exist");
			throw new IllegalArgumentException(
					String.format("No %s with Id [%d].",getEntityClassName() ,id));
	
		}
		return entity;
	}

	@Override
	public long[] getAllIds() {
		return repository.getAllIds();
	}

	
	protected abstract String getEntityClassName();
//	@Override
//	public boolean isEmpty() {
//		return repository.isEmpty();
//	}
//
//	@Override
//	public void size() {
//		repository.size();
//
//	}

}
