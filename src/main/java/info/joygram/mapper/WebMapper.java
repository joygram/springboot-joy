package info.joygram.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebMapper {
	String selectFromDb();
}
