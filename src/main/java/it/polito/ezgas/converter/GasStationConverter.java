package it.polito.ezgas.converter;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;

public class GasStationConverter {
	
	public static GasStationDto toGasStationDto( GasStation gasStation) {
		GasStationDto gasStationConverted = new GasStationDto();
		gasStationConverted.setGasStationId(gasStation.getGasStationId());
		gasStationConverted.setGasStationName(gasStation.getGasStationName());
		gasStationConverted.setGasStationAddress(gasStation.getGasStationAddress());
		gasStationConverted.setHasDiesel(gasStation.getHasDiesel());
		gasStationConverted.setHasSuper(gasStation.getHasSuper());
		gasStationConverted.setHasSuperPlus(gasStation.getHasSuperPlus());
		gasStationConverted.setHasMethane(gasStation.getHasMethane());
		gasStationConverted.setCarSharing(gasStation.getCarSharing());
		gasStationConverted.setLat(gasStation.getLat());
		gasStationConverted.setLon(gasStation.getLon());
		gasStationConverted.setDieselPrice(gasStation.getDieselPrice());
		gasStationConverted.setSuperPrice(gasStation.getSuperPrice());
		gasStationConverted.setSuperPlusPrice(gasStation.getSuperPlusPrice());
		gasStationConverted.setGasPrice(gasStation.getGasPrice());
		gasStationConverted.setMethanePrice(gasStation.getMethanePrice());
		gasStationConverted.setReportUser(gasStation.getReportUser());
		gasStationConverted.setUserDto(UserConverter.toUserDto(gasStation.getUser()));
		gasStationConverted.setReportTimestamp(gasStation.getReportTimestamp());
		gasStationConverted.setReportDependability(gasStation.getReportDependability());
		// TODO priceReportDtos check if it is really needed
		return gasStationConverted;
		
	}
}
