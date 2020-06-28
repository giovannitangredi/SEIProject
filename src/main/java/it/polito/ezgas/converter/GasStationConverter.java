package it.polito.ezgas.converter;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;

public class GasStationConverter {
	
	public static GasStationDto toGasStationDto(GasStation gasStation) {
		GasStationDto gasStationConverted = new GasStationDto();
		gasStationConverted.setGasStationId(gasStation.getGasStationId());
		gasStationConverted.setGasStationName(gasStation.getGasStationName());
		gasStationConverted.setGasStationAddress(gasStation.getGasStationAddress());
		gasStationConverted.setHasDiesel(gasStation.getHasDiesel());
		gasStationConverted.setHasSuper(gasStation.getHasSuper());
		gasStationConverted.setHasSuperPlus(gasStation.getHasSuperPlus());
		gasStationConverted.setHasGas(gasStation.getHasMethane());
		gasStationConverted.setHasMethane(gasStation.getHasMethane());
		// v2: issue 1 added premium diesel
		gasStationConverted.setHasPremiumDiesel(gasStation.getHasPremiumDiesel());
		gasStationConverted.setCarSharing(gasStation.getCarSharing());
		gasStationConverted.setLat(gasStation.getLat());
		gasStationConverted.setLon(gasStation.getLon());
		gasStationConverted.setDieselPrice(gasStation.getDieselPrice());
		gasStationConverted.setSuperPrice(gasStation.getSuperPrice());
		gasStationConverted.setSuperPlusPrice(gasStation.getSuperPlusPrice());
		gasStationConverted.setGasPrice(gasStation.getGasPrice());
		gasStationConverted.setMethanePrice(gasStation.getMethanePrice());
		gasStationConverted.setReportUser(gasStation.getReportUser());
		//handling first time saving gas station without price report
		if( gasStation.getUser() != null ) {
			gasStationConverted.setUserDto(UserConverter.toUserDto(gasStation.getUser()));
		}
		gasStationConverted.setReportTimestamp(gasStation.getReportTimestamp());
		gasStationConverted.setReportDependability(gasStation.getReportDependability());
		
		return gasStationConverted;
		
	}
	
	public static GasStation toGasStation(GasStationDto gasStationDto) {
		GasStation gasStationConverted = new GasStation();
		gasStationConverted.setGasStationId(gasStationDto.getGasStationId());
		gasStationConverted.setGasStationName(gasStationDto.getGasStationName());
		gasStationConverted.setGasStationAddress(gasStationDto.getGasStationAddress());
		gasStationConverted.setHasDiesel(gasStationDto.getHasDiesel());
		gasStationConverted.setHasSuper(gasStationDto.getHasSuper());
		gasStationConverted.setHasSuperPlus(gasStationDto.getHasSuperPlus());
		gasStationConverted.setHasGas(gasStationDto.getHasGas());
		gasStationConverted.setHasMethane(gasStationDto.getHasMethane());
		// v2: issue 1 added premium diesel
		gasStationConverted.setHasPremiumDiesel(gasStationDto.getHasPremiumDiesel());
		gasStationConverted.setCarSharing(gasStationDto.getCarSharing());
		gasStationConverted.setLat(gasStationDto.getLat());
		gasStationConverted.setLon(gasStationDto.getLon());
		gasStationConverted.setDieselPrice(gasStationDto.getDieselPrice());
		gasStationConverted.setSuperPrice(gasStationDto.getSuperPrice());
		gasStationConverted.setSuperPlusPrice(gasStationDto.getSuperPlusPrice());
		gasStationConverted.setGasPrice(gasStationDto.getGasPrice());
		gasStationConverted.setMethanePrice(gasStationDto.getMethanePrice());
		gasStationConverted.setReportUser(gasStationDto.getReportUser());
		//handling first time saving gas station without price report
		if( gasStationDto.getUserDto() != null ) {
			gasStationConverted.setUser(UserConverter.toUser(gasStationDto.getUserDto()));
		}
		gasStationConverted.setReportTimestamp(gasStationDto.getReportTimestamp());
		gasStationConverted.setReportDependability(gasStationDto.getReportDependability());
		return gasStationConverted;
		
	}
}
