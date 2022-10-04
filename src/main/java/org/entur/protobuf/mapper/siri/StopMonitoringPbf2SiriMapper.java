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
        if (monitoredStopVisits != null && !monitoredStopVisits.isEmpty()) {
            for (MonitoredStopVisitStructure monitoredStopVisit : monitoredStopVisits) {
                mapped.getMonitoredStopVisits().add(map(monitoredStopVisit));
            }
        }
        return mapped;
    }

    private static uk.org.siri.siri20.MonitoredStopVisit map(uk.org.siri.www.siri.MonitoredStopVisitStructure monitoredStopVisitStructure) {

        uk.org.siri.siri20.MonitoredStopVisit monitoredStopVisit = new uk.org.siri.siri20.MonitoredStopVisit();
        if (monitoredStopVisitStructure.getRecordedAtTime() != null) {
            monitoredStopVisit.setRecordedAtTime(map(monitoredStopVisitStructure.getRecordedAtTime()));
        }

        if (monitoredStopVisitStructure.getItemIdentifier() != null) {
            monitoredStopVisit.setItemIdentifier(monitoredStopVisitStructure.getItemIdentifier());
        }

        if (monitoredStopVisitStructure.getMonitoringRef() != null) {
            monitoredStopVisit.setMonitoringRef(map(monitoredStopVisitStructure.getMonitoringRef()));
        }

        if (monitoredStopVisitStructure.getMonitoredVehicleJourney() != null) {
            monitoredStopVisit.setMonitoredVehicleJourney(map(monitoredStopVisitStructure.getMonitoredVehicleJourney()));
        }
        return monitoredStopVisit;
    }


    private static uk.org.siri.siri20.MonitoredVehicleJourneyStructure map(uk.org.siri.www.siri.MonitoredVehicleJourneyStructure monitoredVehicleJourney) {

        uk.org.siri.siri20.MonitoredVehicleJourneyStructure struct = new uk.org.siri.siri20.MonitoredVehicleJourneyStructure();
        if (monitoredVehicleJourney.getLineRef() != null) {
            struct.setLineRef(map(monitoredVehicleJourney.getLineRef()));
        }

        if (monitoredVehicleJourney.getFramedVehicleJourneyRef() != null) {
            struct.setFramedVehicleJourneyRef(map(monitoredVehicleJourney.getFramedVehicleJourneyRef()));
        }

        if (monitoredVehicleJourney.getJourneyPatternRef() != null) {
            struct.setJourneyPatternRef(map(monitoredVehicleJourney.getJourneyPatternRef()));
        }

        if (monitoredVehicleJourney.getJourneyPatternName() != null) {
            struct.setJourneyPatternName(map(monitoredVehicleJourney.getJourneyPatternName()));
        }

        if (monitoredVehicleJourney.getVehicleModeList() != null) {
            for (VehicleModesEnumeration vehicleModesEnumeration : monitoredVehicleJourney.getVehicleModeList()) {
                struct.getVehicleModes().add(map(vehicleModesEnumeration));
            }
        }

        if (monitoredVehicleJourney.getRouteRef() != null) {
            struct.setRouteRef(map(monitoredVehicleJourney.getRouteRef()));
        }

        if (monitoredVehicleJourney.getPublishedLineNameList() != null) {
            for (NaturalLanguageStringStructure publishedName : monitoredVehicleJourney.getPublishedLineNameList()) {
                struct.getPublishedLineNames().add(map(publishedName));
            }
        }

        if (monitoredVehicleJourney.getDirectionNameList() != null) {
            for (NaturalLanguageStringStructure directionName : monitoredVehicleJourney.getDirectionNameList()) {
                struct.getDirectionNames().add(map(directionName));
            }
        }

        if (monitoredVehicleJourney.getOperatorRef() != null) {
            struct.setOperatorRef(map(monitoredVehicleJourney.getOperatorRef()));
        }

        if (monitoredVehicleJourney.getOriginRef() != null) {
            struct.setOriginRef(map(monitoredVehicleJourney.getOriginRef()));
        }

        if (monitoredVehicleJourney.getOriginNameList() != null) {
            for (NaturalLanguagePlaceNameStructure originName : monitoredVehicleJourney.getOriginNameList()) {
                struct.getOriginNames().add(map(originName));
            }
        }

        if (monitoredVehicleJourney.getDestinationRef() != null) {
            struct.setDestinationRef(map(monitoredVehicleJourney.getDestinationRef()));
        }

        if (monitoredVehicleJourney.getDestinationNameList() != null) {
            for (NaturalLanguageStringStructure destinationName : monitoredVehicleJourney.getDestinationNameList()) {
                struct.getDestinationNames().add((map(destinationName)));
            }
        }

        if (monitoredVehicleJourney.getVehicleJourneyNameList() != null) {
            for (NaturalLanguageStringStructure vehicleJourneyName : monitoredVehicleJourney.getVehicleJourneyNameList()) {
                struct.getVehicleJourneyNames().add((map(vehicleJourneyName)));
            }
        }

        if (monitoredVehicleJourney.getOriginAimedDepartureTime() != null) {
            struct.setOriginAimedDepartureTime(map(monitoredVehicleJourney.getOriginAimedDepartureTime()));
        }

        if (monitoredVehicleJourney.getDestinationAimedArrivalTime() != null){
            struct.setDestinationAimedArrivalTime(map(monitoredVehicleJourney.getDestinationAimedArrivalTime()));
        }

        struct.setMonitored(monitoredVehicleJourney.getMonitored());

        if (monitoredVehicleJourney.getMonitoredCall() != null){
            struct.setMonitoredCall(map(monitoredVehicleJourney.getMonitoredCall()));
        }

        return struct;
    }

    private static uk.org.siri.siri20.MonitoredCallStructure map(uk.org.siri.www.siri.MonitoredCallStructure monitoredCall) {
        uk.org.siri.siri20.MonitoredCallStructure struct = new uk.org.siri.siri20.MonitoredCallStructure();
        if (monitoredCall.getStopPointRef() != null){
            struct.setStopPointRef(map(monitoredCall.getStopPointRef()));
        }

        struct.setOrder(BigInteger.valueOf(monitoredCall.getOrder()));

        if (monitoredCall.getStopPointNameList() != null ){
            for (NaturalLanguageStringStructure stopPointName : monitoredCall.getStopPointNameList()) {
                struct.getStopPointNames().add(map(stopPointName));
            }
        }

        if (monitoredCall.getDestinationDisplayList() != null){
            for (NaturalLanguageStringStructure destinationDisplay : monitoredCall.getDestinationDisplayList()) {
                struct.getDestinationDisplaies().add(map(destinationDisplay));
            }
        }

if (monitoredCall.getAimedArrivalTime() != null){
    struct.setAimedArrivalTime(map(monitoredCall.getAimedArrivalTime()));
}
        if (monitoredCall.getExpectedArrivalTime() != null){
            struct.setExpectedArrivalTime(map(monitoredCall.getExpectedArrivalTime()));
        }

        if (monitoredCall.getArrivalStatus() != null){
            struct.setArrivalStatus(map(monitoredCall.getArrivalStatus()));
        }

        if (monitoredCall.getArrivalStopAssignment() != null){
            struct.setArrivalStopAssignment(map(monitoredCall.getArrivalStopAssignment()));
        }

        if (monitoredCall.getAimedDepartureTime() != null){
            struct.setAimedDepartureTime(map(monitoredCall.getAimedDepartureTime()));
        }

        if (monitoredCall.getAimedDepartureTime() != null){
            struct.setAimedDepartureTime(map(monitoredCall.getAimedDepartureTime()));
        }

        if (monitoredCall.getExpectedDepartureTime() != null){
            struct.setExpectedDepartureTime(map(monitoredCall.getExpectedDepartureTime()));
        }

        if (monitoredCall.getDepartureStatus() != null){
            struct.setDepartureStatus(map(monitoredCall.getDepartureStatus()));
        }

        if (monitoredCall.getDepartureBoardingActivity() != null){
            struct.setDepartureBoardingActivity(map(monitoredCall.getDepartureBoardingActivity()));
        }


        return struct;
    }


    private static uk.org.siri.siri20.StopAssignmentStructure map(uk.org.siri.www.siri.StopAssignmentStructure stopAssignmentStructure) {
        uk.org.siri.siri20.StopAssignmentStructure struct = new uk.org.siri.siri20.StopAssignmentStructure();

        if (stopAssignmentStructure.getActualQuayRef() != null){
            struct.setActualQuayRef(map(stopAssignmentStructure.getActualQuayRef()));
        }

        if (stopAssignmentStructure.getAimedQuayRef() != null){
            struct.setAimedQuayRef(map(stopAssignmentStructure.getAimedQuayRef()));
        }

        if (stopAssignmentStructure.getExpectedQuayRef() != null){
            struct.setExpectedQuayRef(map(stopAssignmentStructure.getExpectedQuayRef()));
        }

        if (stopAssignmentStructure.getAimedQuayNameList() != null){
            for (NaturalLanguageStringStructure aimedQuayName : stopAssignmentStructure.getAimedQuayNameList()) {
                struct.getAimedQuayNames().add((map(aimedQuayName)));
            }
        }

        return struct;
    }


    private static uk.org.siri.siri20.QuayRefStructure map(uk.org.siri.www.siri.QuayRefStructure quayRef) {
        uk.org.siri.siri20.QuayRefStructure struct = new uk.org.siri.siri20.QuayRefStructure();
        struct.setValue(quayRef != null ? quayRef.getValue() : "");
        return struct;
    }

    private static uk.org.siri.siri20.MonitoringRefStructure map(uk.org.siri.www.siri.MonitoringRefStructure monitoredStopVisitStructure) {
        uk.org.siri.siri20.MonitoringRefStructure struct = new uk.org.siri.siri20.MonitoringRefStructure();
        struct.setValue(monitoredStopVisitStructure != null ? monitoredStopVisitStructure.getValue() : "");
        return struct;
    }


}
