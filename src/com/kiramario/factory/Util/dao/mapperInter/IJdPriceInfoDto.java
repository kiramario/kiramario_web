package com.kiramario.factory.Util.dao.mapperInter;

import com.kiramario.factory.Interf.DtoInterf;
import com.kiramario.factory.Util.dto.JdPriceInfoDto;

public interface IJdPriceInfoDto {
	public JdPriceInfoDto selectLatestOne(String item_id);
}
