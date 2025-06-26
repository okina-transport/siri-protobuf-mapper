package org.entur.protobuf.mapper.siri;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import org.w3.www.xml._1998.namespace.LangType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import uk.org.ifopt.siri20.CountryRefStructure;
import uk.org.ifopt.siri20.IanaCountryTldEnumeration;
import uk.org.ifopt.siri20.StopPlaceRef;
import uk.org.ifopt.www.ifopt.StopPlaceRefStructure;
import uk.org.siri.siri21.DataFrameRefStructure;
import uk.org.siri.siri21.DatedVehicleJourneyRef;
import uk.org.siri.siri21.DestinationRef;
import uk.org.siri.siri21.GroupOfLinesRefStructure;
import uk.org.siri.siri21.JourneyPatternRef;
import uk.org.siri.siri21.LineRef;
import uk.org.siri.siri21.LocationStructure;
import uk.org.siri.siri21.RequestorRef;
import uk.org.siri.siri21.RouteRefStructure;
import uk.org.siri.siri21.ServiceFeatureRef;
import uk.org.siri.siri21.SimpleContactStructure;
import uk.org.siri.siri21.SituationRef;
import uk.org.siri.siri21.SituationSimpleRef;
import uk.org.siri.siri21.StopPointRefStructure;
import uk.org.siri.siri21.VehicleJourneyRef;
import uk.org.siri.siri21.VehicleRef;
import uk.org.siri.www.siri.BlockRefStructure;
import uk.org.siri.www.siri.DatedVehicleJourneyRefStructure;
import uk.org.siri.www.siri.DestinationRefStructure;
import uk.org.siri.www.siri.DirectionRefStructure;
import uk.org.siri.www.siri.FramedVehicleJourneyRefStructure;
import uk.org.siri.www.siri.JourneyPatternRefStructure;
import uk.org.siri.www.siri.JourneyPlaceRefStructure;
import uk.org.siri.www.siri.LineRefStructure;
import uk.org.siri.www.siri.NaturalLanguagePlaceNameStructure;
import uk.org.siri.www.siri.NaturalLanguageStringStructure;
import uk.org.siri.www.siri.OperatorRefStructure;
import uk.org.siri.www.siri.ParticipantRefStructure;
import uk.org.siri.www.siri.ServiceFeatureRefStructure;
import uk.org.siri.www.siri.SituationRefStructure;
import uk.org.siri.www.siri.SituationSimpleRefStructure;
import uk.org.siri.www.siri.VehicleJourneyRefStructure;
import uk.org.siri.www.siri.VehicleRefStructure;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CommonMapper extends EnumerationMapper{

    private static DatatypeFactory datatypeFactory;

    static {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Unable to initialize DatatypeFactory", e);
        }
    }

    protected static Duration.Builder map(javax.xml.datatype.Duration value)  {

        final int seconds = value.getSeconds();
        final int minutes = value.getMinutes();
        final int hours = value.getHours();
        final int days = value.getDays();
        final int sign = value.getSign(); // Positive or negative duration

        final int totalSeconds = (seconds + minutes*60 + hours*60*60 + days*60*60*24) * sign;

        return com.google.protobuf.Duration.newBuilder().setSeconds(totalSeconds);
    }

    protected static javax.xml.datatype.Duration map(com.google.protobuf.Duration value) {

        long seconds = value.getSeconds();

        return datatypeFactory.newDuration((seconds < 0 ? "-":"")+"PT"+ Math.abs(seconds) +"S");
    }

    protected static Timestamp.Builder map(ZonedDateTime value) {
        final Timestamp.Builder builder = Timestamp.newBuilder();
        final long epochSecond = value.toEpochSecond();
        if (epochSecond > 0) {
            builder.setSeconds(epochSecond);
            builder.setNanos(value.getNano());
        }
        return builder;
    }

    protected static java.time.ZonedDateTime map(com.google.protobuf.Timestamp value) {
        ZonedDateTime time = ZonedDateTime.ofInstant(Instant.ofEpochSecond(value.getSeconds()), ZoneId.of("UTC"));
        time = time.plusNanos(value.getNanos());
        return time;
    }


    protected static RequestorRef map(ParticipantRefStructure producerRef) {
        final RequestorRef mapped = new RequestorRef();
        mapped.setValue(producerRef.getValue());
        return mapped;
    }

    protected static ParticipantRefStructure.Builder map(RequestorRef producerRef) {
        ParticipantRefStructure.Builder builder = ParticipantRefStructure.newBuilder();
        builder.setValue(producerRef.getValue());
        return builder;
    }

    protected static LineRefStructure.Builder map(LineRef lineRef) {
        return LineRefStructure.newBuilder()
                .setValue(lineRef.getValue());
    }

    protected static LineRef map(LineRefStructure lineRef) {
        LineRef mapped = new LineRef();
        mapped.setValue(lineRef.getValue());
        return mapped;
    }

    protected static uk.org.siri.siri21.NaturalLanguageStringStructure map(NaturalLanguageStringStructure naturalLanguageStringStructure) {
        uk.org.siri.siri21.NaturalLanguageStringStructure mapped = new uk.org.siri.siri21.NaturalLanguageStringStructure();
        mapped.setLang(map(naturalLanguageStringStructure.getLang()));
        mapped.setValue(naturalLanguageStringStructure.getValue());
        return mapped;
    }
    protected static uk.org.siri.siri21.NaturalLanguagePlaceNameStructure map(NaturalLanguagePlaceNameStructure naturalLanguagePlaceNameStructure) {
        uk.org.siri.siri21.NaturalLanguagePlaceNameStructure mapped = new uk.org.siri.siri21.NaturalLanguagePlaceNameStructure();
        if (naturalLanguagePlaceNameStructure != null) {
            mapped.setValue(naturalLanguagePlaceNameStructure.getValue());
            if (naturalLanguagePlaceNameStructure.getLang() != null ) {
                mapped.setLang(map(naturalLanguagePlaceNameStructure.getLang()));
            }
        }
        return mapped;
    }

    private static String map(LangType lang) {
        if (lang != null && lang != LangType.LANG_TYPE_UNSPECIFIED) {
            return lang.name().replace("LANG_TYPE_", "");
        }
        return null;
    }


    protected static uk.org.siri.www.siri.DefaultedTextStructure.Builder map(uk.org.siri.siri21.DefaultedTextStructure defaultedTextStructure) {
        final uk.org.siri.www.siri.DefaultedTextStructure.Builder builder = uk.org.siri.www.siri.DefaultedTextStructure.newBuilder();
        if (defaultedTextStructure != null) {
            builder.setValue(defaultedTextStructure.getValue());
            if (defaultedTextStructure.getLang() != null ) {
                builder.setLang(map(defaultedTextStructure.getLang()));
            }
        }
        return builder;
    }


    protected static uk.org.siri.siri21.DefaultedTextStructure map(uk.org.siri.www.siri.DefaultedTextStructure defaultedTextStructure) {
        uk.org.siri.siri21.DefaultedTextStructure mapped = new uk.org.siri.siri21.DefaultedTextStructure();
        if (defaultedTextStructure != null) {
            mapped.setValue(defaultedTextStructure.getValue());
            if (defaultedTextStructure.getLang() != null ) {
                mapped.setLang(map(defaultedTextStructure.getLang()));
            }
        }
        return mapped;
    }

    protected static NaturalLanguageStringStructure.Builder map(uk.org.siri.siri21.NaturalLanguageStringStructure naturalLanguageStringStructure) {
        final NaturalLanguageStringStructure.Builder builder = NaturalLanguageStringStructure.newBuilder();
        if (naturalLanguageStringStructure != null) {
            builder.setValue(naturalLanguageStringStructure.getValue());
            if (naturalLanguageStringStructure.getLang() != null ) {
                builder.setLang(map(naturalLanguageStringStructure.getLang()));
            }
        }
        return builder;
    }

    protected static NaturalLanguagePlaceNameStructure.Builder map(uk.org.siri.siri21.NaturalLanguagePlaceNameStructure originName) {
        if (originName != null && originName.getValue() != null) {
            final NaturalLanguagePlaceNameStructure.Builder builder = NaturalLanguagePlaceNameStructure.newBuilder();

            builder.setValue(originName.getValue());
            if (originName.getLang() != null ) {
                builder.setLang(map(originName.getLang()));
            }
            return builder;
        }
        return null;
    }

    private static LangType map(String lang) {
        return LangType.valueOf("LANG_TYPE_" + lang.toUpperCase());
    }



    protected static StopPlaceRefStructure.Builder map(StopPlaceRef stopPlaceRef) {
        return StopPlaceRefStructure.newBuilder().setValue(stopPlaceRef.getValue());
    }

    protected static uk.org.siri.www.siri.StopPointRefStructure.Builder map(StopPointRefStructure stopPointRef) {
        uk.org.siri.www.siri.StopPointRefStructure.Builder build = uk.org.siri.www.siri.StopPointRefStructure.newBuilder();
        build.setValue(stopPointRef.getValue());
        return build;
    }


    protected static OperatorRefStructure.Builder map(uk.org.siri.siri21.OperatorRefStructure operatorRef) {
        return OperatorRefStructure.newBuilder().setValue(operatorRef.getValue());
    }

    protected static DirectionRefStructure.Builder map(uk.org.siri.siri21.DirectionRefStructure directionRef) {
        DirectionRefStructure.Builder builder = DirectionRefStructure.newBuilder();
        builder.setValue(directionRef.getValue());
        return builder;
    }

    protected static DestinationRefStructure.Builder map(DestinationRef destinationRef) {
        DestinationRefStructure.Builder builder = DestinationRefStructure.newBuilder();
        builder.setValue(destinationRef.getValue());
        return builder;
    }

    protected static JourneyPlaceRefStructure.Builder map(uk.org.siri.siri21.JourneyPlaceRefStructure originRef) {
        JourneyPlaceRefStructure.Builder builder = JourneyPlaceRefStructure.newBuilder();
        builder.setValue(originRef.getValue());
        return builder;
    }

    protected static VehicleRefStructure.Builder map(VehicleRef vehicleRef) {
        return VehicleRefStructure.newBuilder().setValue(vehicleRef.getValue());
    }

    protected static BlockRefStructure.Builder map(uk.org.siri.siri21.BlockRefStructure blockRef) {
        return BlockRefStructure.newBuilder().setValue(blockRef.getValue());
    }

    protected static FramedVehicleJourneyRefStructure.Builder map(uk.org.siri.siri21.FramedVehicleJourneyRefStructure framedVehicleJourneyRef) {
        return FramedVehicleJourneyRefStructure.newBuilder()
                .setDataFrameRef(map(framedVehicleJourneyRef.getDataFrameRef()))
                .setDatedVehicleJourneyRef(framedVehicleJourneyRef.getDatedVehicleJourneyRef());
    }

    protected static uk.org.siri.siri21.FramedVehicleJourneyRefStructure map(uk.org.siri.www.siri.FramedVehicleJourneyRefStructure framedVehicleJourneyRef) {
        uk.org.siri.siri21.FramedVehicleJourneyRefStructure mapped = new uk.org.siri.siri21.FramedVehicleJourneyRefStructure();
        if (framedVehicleJourneyRef.hasDataFrameRef()) {
            mapped.setDataFrameRef(map(framedVehicleJourneyRef.getDataFrameRef()));
        }

        mapped.setDatedVehicleJourneyRef(framedVehicleJourneyRef.getDatedVehicleJourneyRef());

        return mapped;
    }

    private static DataFrameRefStructure map(uk.org.siri.www.siri.DataFrameRefStructure dataFrameRef) {
        DataFrameRefStructure mapped = new DataFrameRefStructure();
        mapped.setValue(dataFrameRef.getValue());
        return mapped;
    }

    private static uk.org.siri.www.siri.DataFrameRefStructure.Builder map(DataFrameRefStructure dataFrameRef) {
        return uk.org.siri.www.siri.DataFrameRefStructure.newBuilder()
                .setValue(dataFrameRef == null ? "" : dataFrameRef.getValue());
    }


    protected static VehicleRef map(VehicleRefStructure vehicleRef) {
        final VehicleRef mapped = new VehicleRef();
        mapped.setValue(vehicleRef.getValue());
        return mapped;
    }

    protected static uk.org.siri.siri21.BlockRefStructure map(uk.org.siri.www.siri.BlockRefStructure blockRef) {
        final uk.org.siri.siri21.BlockRefStructure mapped = new uk.org.siri.siri21.BlockRefStructure();
        mapped.setValue(blockRef.getValue());
        return mapped;
    }

    protected static uk.org.siri.siri21.OperatorRefStructure map(uk.org.siri.www.siri.OperatorRefStructure operatorRef) {
        final uk.org.siri.siri21.OperatorRefStructure mapped = new uk.org.siri.siri21.OperatorRefStructure();
        mapped.setValue(operatorRef.getValue());
        return mapped;
    }

    protected static uk.org.siri.siri21.DirectionRefStructure map(uk.org.siri.www.siri.DirectionRefStructure directionRef) {
        final uk.org.siri.siri21.DirectionRefStructure mapped = new uk.org.siri.siri21.DirectionRefStructure();
        mapped.setValue(directionRef.getValue());
        return mapped;
    }


    protected static VehicleJourneyRef map(VehicleJourneyRefStructure vehicleJourneyRef) {
        VehicleJourneyRef mapped = new VehicleJourneyRef();
        mapped.setValue(vehicleJourneyRef.getValue());
        return mapped;
    }

    protected static SituationRef map(SituationRefStructure situationRefStructure) {
        SituationRef mapped = new SituationRef();
        mapped.setSituationSimpleRef(map(situationRefStructure.getSituationSimpleRef()));
        return mapped;
    }

    protected static SituationSimpleRef map(SituationSimpleRefStructure situationSimpleRef) {
        SituationSimpleRef mapped = new SituationSimpleRef();
        mapped.setValue(situationSimpleRef.getValue());
        return mapped;
    }

    protected static SimpleContactStructure map(uk.org.siri.www.siri.SimpleContactStructure publicContact) {
        SimpleContactStructure mapped = new SimpleContactStructure();
        mapped.setPhoneNumber(publicContact.getPhoneNumber());
        mapped.setUrl(publicContact.getUrl());
        return mapped;
    }

    protected static GroupOfLinesRefStructure map(uk.org.siri.www.siri.GroupOfLinesRefStructure groupOfLinesRef) {
        GroupOfLinesRefStructure mapped = new GroupOfLinesRefStructure();
        mapped.setValue(groupOfLinesRef.getValue());
        return mapped;
    }

    protected static RouteRefStructure map(uk.org.siri.www.siri.RouteRefStructure routeRef) {
        RouteRefStructure mapped = new RouteRefStructure();
        mapped.setValue(routeRef.getValue());
        return mapped;
    }

    protected static JourneyPatternRef map(JourneyPatternRefStructure journeyPatternRef) {
        JourneyPatternRef mapped = new JourneyPatternRef();
        mapped.setValue(journeyPatternRef.getValue());
        return mapped;
    }

    protected static DestinationRef map(DestinationRefStructure destinationRef) {
        final DestinationRef mapped = new DestinationRef();
        mapped.setValue(destinationRef.getValue());
        return mapped;
    }

    protected static uk.org.siri.siri21.JourneyPlaceRefStructure map(uk.org.siri.www.siri.JourneyPlaceRefStructure originRef) {
        final uk.org.siri.siri21.JourneyPlaceRefStructure mapped = new uk.org.siri.siri21.JourneyPlaceRefStructure();
        mapped.setValue(originRef.getValue());
        return mapped;
    }

    protected static ServiceFeatureRef map(ServiceFeatureRefStructure serviceFeatureRefStructure) {
        final ServiceFeatureRef mapped = new ServiceFeatureRef();
        mapped.setValue(serviceFeatureRefStructure.getValue());
        return mapped;
    }

    protected static DatedVehicleJourneyRef map(DatedVehicleJourneyRefStructure datedVehicleJourneyRef) {
        final DatedVehicleJourneyRef mapped = new DatedVehicleJourneyRef();
        if (datedVehicleJourneyRef.getValue() != null && !datedVehicleJourneyRef.getValue().isEmpty()) {
            mapped.setValue(datedVehicleJourneyRef.getValue());
        }
        return mapped;
    }

    protected static uk.org.ifopt.www.ifopt.CountryRefStructure.Builder map(CountryRefStructure countryRefStructure) {
        uk.org.ifopt.www.ifopt.CountryRefStructure.Builder builder = uk.org.ifopt.www.ifopt.CountryRefStructure.newBuilder();
        if (countryRefStructure.getValue() != null) {
            builder.setValue(countryRefStructure.getValue().value());
        }
        return builder;
    }

    protected static CountryRefStructure map(uk.org.ifopt.www.ifopt.CountryRefStructure countryRefStructure) {
        CountryRefStructure mapped = new CountryRefStructure();
        if (countryRefStructure.getValue() != null) {
            mapped.setValue(IanaCountryTldEnumeration.fromValue(countryRefStructure.getValue()));
        }
        return mapped;
    }

    protected static uk.org.siri.www.siri.LocationStructure.Builder map(LocationStructure locationStructure) {
        uk.org.siri.www.siri.LocationStructure.Builder builder = uk.org.siri.www.siri.LocationStructure.newBuilder();
        if (locationStructure.getLatitude() != null) {
            builder.setLatitude(locationStructure.getLatitude().doubleValue());
        }
        if (locationStructure.getLongitude() != null) {
            builder.setLongitude(locationStructure.getLongitude().doubleValue());
        }
        if (locationStructure.getSrsName() != null && !locationStructure.getSrsName().isEmpty()) {
            builder.setSrsName(locationStructure.getSrsName());
        }
        return builder;
    }

    protected static LocationStructure map(uk.org.siri.www.siri.LocationStructure locationStructure) {
        LocationStructure mapped = new LocationStructure();
        if (locationStructure.getLatitude() != 0 || locationStructure.getLongitude() != 0) {
            mapped.setLatitude(BigDecimal.valueOf(locationStructure.getLatitude()));
            mapped.setLongitude(BigDecimal.valueOf(locationStructure.getLongitude()));
        }
        if (locationStructure.getSrsName() != null && !locationStructure.getSrsName().isEmpty()) {
            mapped.setSrsName(locationStructure.getSrsName());
        }
        return mapped;

    }

    protected static Any.Builder map(Element any) {
        try {
            /*
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.adoptNode(any);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(bos);
            transformer.transform(source, result);
            byte[] array = bos.toByteArray();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docbuilder = factory.newDocumentBuilder();
            Document doc2 = docbuilder.parse(new ByteArrayInputStream(array));


             */
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.adoptNode(any);

            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();

            // create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            factory.setNamespaceAware(true);
            DocumentBuilder builder123 = factory.newDocumentBuilder();

            builder123.parse(new InputSource(new StringReader(xmlString)));


            Any.Builder builder = Any.newBuilder();
            return builder;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static Element map(Any any) {
        try {
            ByteString value = any.getValue();
            byte[] bytes = value.toByteArray();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(bytes));

            return doc.getDocumentElement();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
