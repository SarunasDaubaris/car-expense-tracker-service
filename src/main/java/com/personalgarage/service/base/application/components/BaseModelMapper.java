package com.personalgarage.service.base.application.components;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseModelMapper {

    protected final ModelMapper modelMapper;

    protected BaseModelMapper() {
        this.modelMapper = new ModelMapper();
    }

    protected abstract void configureMappings();

    public <S, D> D mapByClass(S source, Class<D> dest) {
        return modelMapper.map(source, dest);
    }

    public <S, D> List<D> mapToListByClass(List<S> source, Class<D> dest) {
        if (source == null) {
            return null;
        }
        return source.stream().map(s -> modelMapper.map(s, dest)).collect(Collectors.toList());
    }

    public <S, D> void mapByObject(S source, D dest) {
        modelMapper.map(source, dest);
    }
}