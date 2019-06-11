package poly.persistance.mapper;

import config.Mapper;
import poly.dto.FeelDTO;

@Mapper("FeelMapper")
public interface FeelMapper {

	public int insertFeel(FeelDTO fDTO) throws Exception;

	public FeelDTO getDate()  throws Exception;
	
}
