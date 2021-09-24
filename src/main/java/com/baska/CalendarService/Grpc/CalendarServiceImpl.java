package com.baska.CalendarService.Grpc;

import com.baska.CalendarService.Service.AccessService;
import com.baska.CalendarService.Service.CRUDService;
import com.google.gson.Gson;
import com.id.grpc.CalendarServiceGrpc;
import com.id.grpc.CalendarServiceProto;
import io.grpc.stub.StreamObserver;
import com.baska.CalendarService.Payloads.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CalendarServiceImpl extends CalendarServiceGrpc.CalendarServiceImplBase {

    @Autowired
    CRUDService CRUDService;

    @Override
    public void getEvents(CalendarServiceProto.GetEventsRequest request, StreamObserver<CalendarServiceProto.GetEventsResponse> responseObserver) {
        GetEventsPayloadRequest getEventsPayloadRequest = new Gson().fromJson(request.getJson(), GetEventsPayloadRequest.class);
        String json  = CRUDService.getAll(getEventsPayloadRequest);
        CalendarServiceProto.GetEventsResponse response = CalendarServiceProto.GetEventsResponse
                .newBuilder()
                .setJson(json)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getEvent(CalendarServiceProto.GetEventRequest request, StreamObserver<CalendarServiceProto.GetEventResponse> responseObserver) {
        GetEventPayloadRequest getEventPayloadRequest = new Gson().fromJson(request.getJson(), GetEventPayloadRequest.class);
        String json = CRUDService.getEvent(getEventPayloadRequest.getEventId(),getEventPayloadRequest.getUserId());
        CalendarServiceProto.GetEventResponse response = CalendarServiceProto.GetEventResponse
                .newBuilder()
                .setJson(json)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addEvent(CalendarServiceProto.AddEventRequest request, StreamObserver<CalendarServiceProto.AddEventResponse> responseObserver) {
        AddEventPayloadRequest addEventPayloadRequest = new Gson().fromJson(request.getJson(), AddEventPayloadRequest.class);
        String json = CRUDService.addEvent(addEventPayloadRequest);
        CalendarServiceProto.AddEventResponse response = CalendarServiceProto.AddEventResponse
                .newBuilder()
                .setJson(json)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateEvent(CalendarServiceProto.UpdateEventRequest request, StreamObserver<CalendarServiceProto.UpdateEventResponse> responseObserver) {

    }

    @Override
    public void deleteEvent(CalendarServiceProto.DeleteEventRequest request, StreamObserver<CalendarServiceProto.DeleteEventResponse> responseObserver) {

    }

}
