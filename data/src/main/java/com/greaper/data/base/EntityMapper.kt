package com.greaper.data.base

import com.greaper.domain.model.Model

abstract class EntityMapper<M : Model, ME : ModelEntity> {
    abstract fun mapToDomain(entity: ME): M

    abstract fun mapToEntity(model: M): ME
}