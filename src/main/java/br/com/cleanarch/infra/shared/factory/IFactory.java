package br.com.cleanarch.infra.shared.factory;

import br.com.cleanarch.infra.shared.entity.IEntity;

public interface IFactory<Model, Entity extends IEntity> {

    Model toModel(Entity entity);

    Entity toEntity(Model model);

}
