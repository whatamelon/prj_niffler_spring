package poly.service;

import poly.dto.FeelDTO;

public interface IFeelService {

	public int insertFeel(FeelDTO fDTO) throws Exception;
	
	public FeelDTO getDate() throws Exception;
}