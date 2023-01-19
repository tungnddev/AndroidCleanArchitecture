package com.greaper.data.base

import com.greaper.data.remote.exception.NoImplementMapToEntityException
import com.greaper.domain.model.Model

abstract class DtoMapper<M : Model, MD : ModelDto> {
    abstract fun mapToDomain(dto: MD): M

    fun mapToDto(model: M): MD {
        throw NoImplementMapToEntityException()
    }
}