package org.entur.protobuf.mapper.siri;

import uk.org.siri.siri20.StopMonitoringDeliveryStructure;
import uk.org.siri.www.siri.*;


import java.math.BigInteger;
import java.util.List;

public class StopMonitoringPbf2SiriMapper extends CommonMapper {

    public static StopMonitoringDeliveryStructure map(uk.org.siri.www.siri.StopMonitoringDeliveryStructure deliveryStructure) {
        final StopMonitoringDeliveryStructure mapped = new StopMonitoringDeliveryStructure();


        if (deliveryStructure.hasResponseTimestamp()) {
            mapped.setResponseTimestamp(map(deliveryStructure.getResponseTimestamp()));
        }
        mapped.setVersion(deliveryStructure.getVersion());

        List<MonitoredStopVisitStructure> monitoredStopVisits = deliveryStructure.getMonitoredStopVisitList();
        if (monitoredStopVisits != null && !monitoredStopVisits.isEmpty()){
            for (MonitoredStopVisitStructure monitoredStopVisit : monitoredStopVisits) {
                mapped.getMonitoredStopVisits().add(map(monitoredStopVisit));
            }
        }
        return mapped;
    }

    private static uk.org.siri.siri20.MonitoredStopVisit map(uk.org.siri.www.siri.MonitoredStopVisitStructure monitoredStopVisitStructure) {

        uk.org.siri.siri20.MonitoredStopVisit monitoredStopVisit = new uk.org.siri.siri20.MonitoredStopVisit();
        monitoredStopVisit.setRecordedAtTime(map(monitoredStopVisitStructure.getRecordedAtTime()));
        monitoredStopVisit.setItemIdentifier(monitoredStopVisitStructure.getItemIdentifier());
        monitoredStopVisit.setMonitoringRef(map(monitoredStopVisitStructure.getMonitoringRef()));
        monitoredStopVisit.setMonitoredVehicleJourney(map(monitoredStopVisitStructure.getMonitoredVehicleJourney()));
        return monitoredStopVisit;
    }


    private static uk.org.siri.siri20.MonitoredVehicleJourneyStructure map(uk.org.siri.www.siri.MonitoredVehicleJourneyStructure monitoredVehicleJourney) {

        uk.org.siri.siri20.MonitoredVehicleJourneyStructure struct = new uk.org.siri.siri20.MonitoredVehicleJourneyStructure();
        struct.setLineRef(map(monitoredVehicleJourney.getLineRef()));
        struct.setFramedVehicleJourneyRef(map(monitoredVehicleJourney.getFramedVehicleJourneyRef()));
        struct.setJourneyPatternRef(map(monitoredVehicleJourney.getJourneyPatternRef()));
        struct.setJourneyPatternName(map(monitoredVehicleJourney.getJourneyPatternName()));

        for (VehicleModesEnumeration vehicleModesEnumeration : monitoredVehicleJourney.getVehicleModeList()) {
            struct.getVehicleModes().add(map(vehicleModesEnumeration));
        }

        struct.setRouteRef(map(monitoredVehicleJourney.getRouteRef()));

        for (NaturalLanguageStringStructure publishedName : monitoredVehicleJourney.getPublishedLineNameList()) {
            struct.getPublishedLineNames().add(map(publishedName));
        }

        for (NaturalLanguageStringStructure directionName : monitoredVehicleJourney.getDirectionNameList()) {
            struct.getDirectionNames().add(map(directionName));
        }

        struct.setOperatorRef(map(monitoredVehicleJourney.getOperatorRef()));
        struct.setOriginRef(map(monitoredVehicleJourney.getOriginRef()));

        for (NaturalLanguagePlaceNameStructure originName : monitoredVehicleJourney.getOriginNameList()) {
            struct.getOriginNames().add(map(originName));
        }

        struct.setDestinationRef(map(monitoredVehicleJourney.getDestinationRef()));

        for (NaturalLanguageStringStructure destinationName : monitoredVehicleJourney.getDestinationNameList()) {
            struct.getDestinationNames().add((map(destinationName)));
        }

        for (NaturalLanguageStringStructure vehicleJourneyName : monitoredVehicleJourney.getVehicleJourneyNameList()) {
            struct.getVehicleJourneyNames().add((map(vehicleJourneyName)));
        }

        struct.setOriginAimedDepartureTime(map(monitoredVehicleJourney.getOriginAimedDepartureTime()));
        struct.setDestinationAimedArrivalTime(map(monitoredVehicleJourney.getDestinationAimedArrivalTime()));
        struct.setMonitored(monitoredVehicleJourney.getMonitored());
        struct.setMonitoredCall(map(monitoredVehicleJourney.getMonitoredCall()));

        return struct;
    }

    private static uk.org.siri.siri20.MonitoredCallStructure map(uk.org.siri.www.siri.MonitoredCallStructure monitoredCall) {
        uk.org.siri.siri20.MonitoredCallStructure struct = new uk.org.siri.siri20.MonitoredCallStructure();
        struct.setStopPointRef(map(monitoredCall.getStopPointRef()));
        struct.setOrder(BigInteger.valueOf(monitoredCall.getOrder()));
        for (NaturalLanguageStringStructure stopPointName : monitoredCall.getStopPointNameList()) {
            struct.getStopPointNames().add(map(stopPointName));
        }

        for (NaturalLanguageStringStructure destinationDisplay : monitoredCall.getDestinationDisplayList()) {
            struct.getDestinationDisplaies().add(map(destinationDisplay));
        }

        struct.setAimedArrivalTime(map(monitoredCall.getAimedArrivalTime()));
        struct.setExpectedArrivalTime(map(monitoredCall.getExpectedArrivalTime()));
        struct.setArrivalStatus(map(monitoredCall.getArrivalStatus()));
        struct.setArrivalStopAssignment(map(monitoredCall.getArrivalStopAssignment()));
        struct.setAimedDepartureTime(map(monitoredCall.getAimedDepartureTime()));
        struct.setExpectedDepartureTime(map(monitoredCall.getExpectedDepartureTime()));
        struct.setDepartureStatus(map(monitoredCall.getDepartureStatus()));
        struct.setDepartureBoardingActivity(map(monitoredCall.getDepartureBoardingActivity()));

        return struct;
    }


    private static uk.org.siri.siri20.StopAssignmentStructure map(uk.org.siri.www.siri.StopAssignmentStructure stopAssignmentStructure) {
        uk.org.siri.siri20.StopAssignmentStructure struct = new uk.org.siri.siri20.StopAssignmentStructure();
        struct.setActualQuayRef(map(stopAssignmentStructure.getActualQuayRef()));
        struct.setAimedQuayRef(map(stopAssignmentStructure.getAimedQuayRef()));
        struct.setExpectedQuayRef(map(stopAssignmentStructure.getExpectedQuayRef()));

        for (NaturalLanguageStringStructure aimedQuayName : stopAssignmentStructure.getAimedQuayNameList()) {
            struct.getAimedQuayNames().add((map(aimedQuayName)));
        }

        return struct;
    }


    private static uk.org.siri.siri20.QuayRefStructure map(uk.org.siri.www.siri.QuayRefStructure quayRef) {
        uk.org.siri.siri20.QuayRefStructure struct = new uk.org.siri.siri20.QuayRefStructure();
        struct.setValue(quayRef.getValue());
        return struct;
    }

    private static uk.org.siri.siri20.MonitoringRefStructure map(uk.org.siri.www.siri.MonitoringRefStructure monitoredStopVisitStructure) {
        uk.org.siri.siri20.MonitoringRefStructure struct = new uk.org.siri.siri20.MonitoringRefStructure();
        struct.setValue(monitoredStopVisitStructure.getValue());
        return struct;
    }




}
