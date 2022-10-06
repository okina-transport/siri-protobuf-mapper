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

        if (monitoredVehicleJourney.getLineRef() != null){
            builder.setLineRef(map(monitoredVehicleJourney.getLineRef()));
        }

        if (monitoredVehicleJourney.getFramedVehicleJourneyRef() != null){
            builder.setFramedVehicleJourneyRef(map(monitoredVehicleJourney.getFramedVehicleJourneyRef()));
        }

        if (monitoredVehicleJourney.getJourneyPatternRef() != null){
            builder.setJourneyPatternRef(map(monitoredVehicleJourney.getJourneyPatternRef()));
        }

        if (monitoredVehicleJourney.getJourneyPatternName() != null){
            builder.setJourneyPatternName(map(monitoredVehicleJourney.getJourneyPatternName()));
        }

        if (monitoredVehicleJourney.getVehicleModes() != null){
            for (VehicleModesEnumeration vehicleMode : monitoredVehicleJourney.getVehicleModes()) {
                builder.addVehicleMode(EnumerationMapper.map(vehicleMode));
            }
        }

        if (monitoredVehicleJourney.getRouteRef() != null){
            builder.setRouteRef(map(monitoredVehicleJourney.getRouteRef()));
        }

        if (monitoredVehicleJourney.getPublishedLineNames() != null){
            for (NaturalLanguageStringStructure publishedLineName : monitoredVehicleJourney.getPublishedLineNames()) {
                builder.addPublishedLineName(map(publishedLineName));
            }
        }

        if (monitoredVehicleJourney.getDirectionNames() != null){
            for (NaturalLanguageStringStructure directionName : monitoredVehicleJourney.getDirectionNames()) {
                builder.addDirectionName(map(directionName));
            }
        }

        if (monitoredVehicleJourney.getOperatorRef() != null){
            builder.setOperatorRef(map(monitoredVehicleJourney.getOperatorRef()));
        }

        if (monitoredVehicleJourney.getOriginRef() != null){
            builder.setOriginRef(map(monitoredVehicleJourney.getOriginRef()));
        }

        if (monitoredVehicleJourney.getOriginNames() != null){
            for (NaturalLanguagePlaceNameStructure originName : monitoredVehicleJourney.getOriginNames()) {
                builder.addOriginName(map(originName));
            }
        }

        if (monitoredVehicleJourney.getDestinationRef() != null){
            builder.setDestinationRef(map(monitoredVehicleJourney.getDestinationRef()));
        }

        if (monitoredVehicleJourney.getDestinationNames() != null){
            for (NaturalLanguageStringStructure destinationName : monitoredVehicleJourney.getDestinationNames()) {
                builder.addDestinationName(map(destinationName));
            }
        }

        if (monitoredVehicleJourney.getVehicleJourneyNames() != null){
            for (NaturalLanguageStringStructure vehicleJourneyName : monitoredVehicleJourney.getVehicleJourneyNames()) {
                builder.addVehicleJourneyName(map(vehicleJourneyName));
            }
        }

        if (monitoredVehicleJourney.getOriginAimedDepartureTime() != null){
            builder.setOriginAimedDepartureTime(map(monitoredVehicleJourney.getOriginAimedDepartureTime()));
        }

        if (monitoredVehicleJourney.getDestinationAimedArrivalTime() != null){
            builder.setDestinationAimedArrivalTime(map(monitoredVehicleJourney.getDestinationAimedArrivalTime()));
        }

        if (monitoredVehicleJourney.getMonitoredCall() != null){
            builder.setMonitoredCall(map(monitoredVehicleJourney.getMonitoredCall()));
        }
        builder.setMonitored(monitoredVehicleJourney.isMonitored());

        return builder;
    }

    private static uk.org.siri.www.siri.MonitoredCallStructure.Builder map(uk.org.siri.siri20.MonitoredCallStructure monitoredCall) {
        uk.org.siri.www.siri.MonitoredCallStructure.Builder builder =  uk.org.siri.www.siri.MonitoredCallStructure.newBuilder();
        builder.setStopPointRef(map(monitoredCall.getStopPointRef()));

        if (monitoredCall.getOrder() != null){
            builder.setOrder(monitoredCall.getOrder().intValue());
        }

        for (NaturalLanguageStringStructure stopPointName : monitoredCall.getStopPointNames()) {
            builder.addStopPointName(map(stopPointName));
        }
        for (NaturalLanguageStringStructure destinationDisplay : monitoredCall.getDestinationDisplaies()) {
            builder.addDestinationDisplay(map(destinationDisplay));
        }

        if (monitoredCall.getAimedArrivalTime() != null){
            builder.setAimedArrivalTime(map(monitoredCall.getAimedArrivalTime()));
        }

        if (monitoredCall.getExpectedArrivalTime() != null){
            builder.setExpectedArrivalTime(map(monitoredCall.getExpectedArrivalTime()));
        }

        if (monitoredCall.getArrivalStatus() != null){
            builder.setArrivalStatus(map(monitoredCall.getArrivalStatus()));
        }

        if (monitoredCall.getArrivalStopAssignment() != null){
            builder.setArrivalStopAssignment(map(monitoredCall.getArrivalStopAssignment()));
        }

        if (monitoredCall.getAimedDepartureTime() != null){
            builder.setAimedDepartureTime(map(monitoredCall.getAimedDepartureTime()));
        }

        if (monitoredCall.getExpectedDepartureTime() != null){
            builder.setExpectedDepartureTime(map(monitoredCall.getExpectedDepartureTime()));
        }

        if (monitoredCall.getDepartureStatus() != null){
            builder.setDepartureStatus(map(monitoredCall.getDepartureStatus()));
        }
        if (monitoredCall.getDepartureBoardingActivity() != null){
            builder.setDepartureBoardingActivity(map(monitoredCall.getDepartureBoardingActivity()));
        }

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