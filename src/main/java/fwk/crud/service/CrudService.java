package fwk.crud.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Krunal Lukhi
 * @since 5/08/2023
 */

public interface CrudService<T> {

    T create(@NotNull T object);

    T update(@NotNull T object);

    T find(@NotBlank String id);

    T delete(@NotBlank String id);
}
