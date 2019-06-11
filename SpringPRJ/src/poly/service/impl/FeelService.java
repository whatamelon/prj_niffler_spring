package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.FeelDTO;
import poly.persistance.mapper.FeelMapper;
import poly.service.IFeelService;

@Service("FeelService")
public class FeelService implements IFeelService {
	
	@Resource(name="FeelMapper")
	private FeelMapper feelMapper;


	@Override
	public int insertFeel(FeelDTO fDTO) throws Exception {
		return feelMapper.insertFeel(fDTO);
	}

	@Override																									
	public FeelDTO getDate() throws Exception {		
		return feelMapper.getDate();									
	}			
	
}
