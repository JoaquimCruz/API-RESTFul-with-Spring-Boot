package br.com.joaquim.mapper;

import java.util.ArrayList;
import java.util.List;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;


/* O uso do Dozer mapper é para fazer a transição entre usuário e usuário DTO. O usuario DTO ele restringe
algumas informações de pessoa, como a questão da identificação dela. O dozer é um mapper open source mantido
pela comunidade. As funcões abaixo fazer a transição entre pessoa DTO e pessoa e vice versa.
A primeira função é para mapeamento simples de uma entidade, enquanto a segunda é para mapeamento de uma lista
de entidades. As funções são distintas porque existe a necessidade de iterar e mudar cada elemento da lista de
uma vez.*/
public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T, U> U map(T source, Class<U> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    public static <T, U> List<U> mapList(List<T> source, Class<U> destinationClass) {
        List<U> destination = new ArrayList<>();
        for (Object t : source) {
            destination.add(mapper.map(t, destinationClass));
        }

        return destination;
    }
}
