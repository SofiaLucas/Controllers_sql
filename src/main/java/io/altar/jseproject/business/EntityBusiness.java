package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.model.Entity_;
import io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityBusiness<R extends EntityRepository<E>, E extends Entity_> implements BusinessServiceInterface<E> {

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
	public E getbyId(long id) throws IllegalArgumentException {
		E entity = repository.getbyId(id);
		if (entity == null) {
			throw new IllegalArgumentException("id does not exist");
		}
		return entity;
	}

	@Override
	public long[] getAllIds() {
		return repository.getAllIds();
	}

	@Override
	public boolean isEmpty() {
		return repository.isEmpty();
	}

	@Override
	public void size() {
		repository.size();

	}

}
