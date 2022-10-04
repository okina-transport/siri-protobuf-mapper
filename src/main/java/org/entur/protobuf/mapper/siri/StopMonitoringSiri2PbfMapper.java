package org.entur.protobuf.mapper.siri;

import uk.org.siri.siri20.*;
import uk.org.siri.www.siri.JourneyPatternRefStructure;
import uk.org.siri.www.siri.MonitoredStopVisitStructure;



import java.util.List;

public class StopMonitoringSiri2PbfMapper extends CommonMapper {

    public static uk.org.siri.www.siri.StopMonitoringDeliveryStructure.Builder map(StopMonitoringDeliveryStructure stopMonitoringDelivery) {
        final uk.org.siri.www.siri.StopMonitoringDeliveryStructure.Builder builder = uk.org.siri.www.siri.StopMonitoringDeliveryStructure.newBuilder();

        if (stopMonitoringDelivery.getResponseTimestamp() != null) {
            builder.setResponseTimestamp(map(stopMonitoringDelivery.getResponseTimestamp()));
        }

        List<MonitoredStopVisit> monitoredStopVisits = stopMonitoringDelivery.getMonitoredStopVisits();
        if (monitoredStopVisits != null && !monitoredStopVisits.isEmpty()) {
            for (MonitoredStopVisit monitoredStopVisit : monitoredStopVisits) {
                builder.addMonitoredStopVisit(map(monitoredStopVisit));
            }
        }

        builder.setVersion(stopMonitoringDelivery.getVersion());
        return builder;
    }



    private static MonitoredStopVisitStructure map(uk.org.siri.siri20.MonitoredStopVisit monitoredVisit) {

        uk.org.siri.www.siri.MonitoredStopVisitStructure.Builder builder = MonitoredStopVisitStructure.newBuilder();
        if (monitoredVisit.getRecordedAtTime() != null) {
            builder.setRecordedAtTime(map(monitoredVisit.getRecordedAtTime()));
        }

        if (monitoredVisit.getItemIdentifier() != null) {
            builder.setItemIdentifier(monitoredVisit.getItemIdentifier());
        }

        if (monitoredVisit.getMonitoringRef() != null) {
            builder.setMonitoringRef(map(monitoredVisit.getMonitoringRef()));
        }

        if (monitoredVisit.getMonitoredVehicleJourney() != null) {
            builder.setMonitoredVehicleJourney(map(monitoredVisit.getMonitoredVehicleJourney()));
        }

        return builder.build();
    }

    private static uk.org.siri.www.siri.MonitoredVehicleJourneyStructure.Builder map(MonitoredVehicleJourneyStructure monitoredVehicleJourney) {

        uk.org.siri.www.siri.MonitoredVehicleJourneyStructure.Builder builder =  uk.org.siri.www.siri.MonitoredVehicleJourneyStructure.newBuilder();
        builder.setLineRef(map(monitoredVehicleJourney.getLineRef()));
        builder.setFramedVehicleJourneyRef(map(monitoredVehicleJourney.getFramedVehicleJourneyRef()));
        builder.setJourneyPatternRef(map(monitoredVehicleJourney.getJourneyPatternRef()));
        builder.setJourneyPatternName(map(monitoredVehicleJourney.getJourneyPatternName()));

        for (VehicleModesEnumeration vehicleMode : monitoredVehicleJourney.getVehicleModes()) {
            builder.addVehicleMode(EnumerationMapper.map(vehicleMode));
        }

        builder.setRouteRef(map(monitoredVehicleJourney.getRouteRef()));

        for (NaturalLanguageStringStructure publishedLineName : monitoredVehicleJourney.getPublishedLineNames()) {
            builder.addPublishedLineName(map(publishedLineName));
        }

        for (NaturalLanguageStringStructure directionName : monitoredVehicleJourney.getDirectionNames()) {
            builder.addDirectionName(map(directionName));
        }

        builder.setOperatorRef(map(monitoredVehicleJourney.getOperatorRef()));
        builder.setOriginRef(map(monitoredVehicleJourney.getOriginRef()));
        for (NaturalLanguagePlaceNameStructure originName : monitoredVehicleJourney.getOriginNames()) {
            builder.addOriginName(map(originName));
        }

        builder.setDestinationRef(map(monitoredVehicleJourney.getDestinationRef()));

        for (NaturalLanguageStringStructure destinationName : monitoredVehicleJourney.getDestinationNames()) {
            builder.addDestinationName(map(destinationName));
        }

        for (NaturalLanguageStringStructure vehicleJourneyName : monitoredVehicleJourney.getVehicleJourneyNames()) {
            builder.addVehicleJourneyName(map(vehicleJourneyName));
        }

        builder.setOriginAimedDepartureTime(map(monitoredVehicleJourney.getOriginAimedDepartureTime()));
        builder.setDestinationAimedArrivalTime(map(monitoredVehicleJourney.getDestinationAimedArrivalTime()));
        builder.setMonitored(monitoredVehicleJourney.isMonitored());
        builder.setMonitoredCall(map(monitoredVehicleJourney.getMonitoredCall()));
        return builder;
    }

    private static uk.org.siri.www.siri.MonitoredCallStructure.Builder map(uk.org.siri.siri20.MonitoredCallStructure monitoredCall) {
        uk.org.siri.www.siri.MonitoredCallStructure.Builder builder =  uk.org.siri.www.siri.MonitoredCallStructure.newBuilder();
        builder.setStopPointRef(map(monitoredCall.getStopPointRef()));
        builder.setOrder(monitoredCall.getOrder().intValue());
        for (NaturalLanguageStringStructure stopPointName : monitoredCall.getStopPointNames()) {
            builder.addStopPointName(map(stopPointName));
        }
        for (NaturalLanguageStringStructure destinationDisplay : monitoredCall.getDestinationDisplaies()) {
            builder.addDestinationDisplay(map(destinationDisplay));
        }
        builder.setAimedArrivalTime(map(monitoredCall.getAimedArrivalTime()));
        builder.setExpectedArrivalTime(map(monitoredCall.getExpectedArrivalTime()));
        builder.setArrivalStatus(map(monitoredCall.getArrivalStatus()));
        builder.setArrivalStopAssignment(map(monitoredCall.getArrivalStopAssignment()));
        builder.setAimedDepartureTime(map(monitoredCall.getAimedDepartureTime()));
        builder.setExpectedDepartureTime(map(monitoredCall.getExpectedDepartureTime()));
        builder.setDepartureStatus(map(monitoredCall.getDepartureStatus()));
        builder.setDepartureBoardingActivity(map(monitoredCall.getDepartureBoardingActivity()));
        return builder;
    }


    private static uk.org.siri.www.siri.StopAssignmentStructure map(uk.org.siri.siri20.StopAssignmentStructure stopAssignmentStructure) {
        uk.org.siri.www.siri.StopAssignmentStructure.Builder struct = uk.org.siri.www.siri.StopAssignmentStructure.newBuilder();

        if (stopAssignmentStructure.getActualQuayRef() != null){
            struct.setActualQuayRef(map(stopAssignmentStructure.getActualQuayRef()));
        }

        if (stopAssignmentStructure.getAimedQuayRef() != null){
            struct.setAimedQuayRef(map(stopAssignmentStructure.getAimedQuayRef()));
        }

        if (stopAssignmentStructure.getAimedQuayNames() != null){
            for (NaturalLanguageStringStructure aimedQuayName : stopAssignmentStructure.getAimedQuayNames()) {
                struct.addAimedQuayName(map(aimedQuayName));
            }
        }

        if (stopAssignmentStructure.getExpectedQuayRef() != null){
            struct.setExpectedQuayRef(map(stopAssignmentStructure.getExpectedQuayRef()));
        }
        return struct.build();

    }

    private static uk.org.siri.www.siri.QuayRefStructure.Builder map(uk.org.siri.siri20.QuayRefStructure quayRef) {
        uk.org.siri.www.siri.QuayRefStructure.Builder builder =  uk.org.siri.www.siri.QuayRefStructure.newBuilder();
        builder.setValue(quayRef.getValue());
        return builder;
    }

    private static uk.org.siri.www.siri.RouteRefStructure map(uk.org.siri.siri20.RouteRefStructure routeRef) {
        uk.org.siri.www.siri.RouteRefStructure.Builder struct = uk.org.siri.www.siri.RouteRefStructure.newBuilder();
        struct.setValue(routeRef.getValue());
        return struct.build();
    }

    private static uk.org.siri.www.siri.JourneyPatternRefStructure map(uk.org.siri.siri20.JourneyPatternRef monitoringRef) {
        JourneyPatternRefStructure.Builder struct = JourneyPatternRefStructure.newBuilder();
        struct.setValue(monitoringRef.getValue());
        return struct.build();
    }

    private static uk.org.siri.www.siri.MonitoringRefStructure.Builder map(uk.org.siri.siri20.MonitoringRefStructure monitoringRef) {
        uk.org.siri.www.siri.MonitoringRefStructure.Builder builder =  uk.org.siri.www.siri.MonitoringRefStructure.newBuilder();
        builder.setValue(monitoringRef.getValue());
        return builder;
    }







}