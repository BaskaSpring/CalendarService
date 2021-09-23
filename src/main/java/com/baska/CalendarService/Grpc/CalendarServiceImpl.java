package com.baska.CalendarService.Grpc;

import com.baska.CalendarService.Service.AccessService;
import com.google.gson.Gson;
import com.id.grpc.CalendarServiceGrpc;
import com.id.grpc.CalendarServiceProto;
import io.grpc.stub.StreamObserver;
import com.baska.CalendarService.Payloads.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalendarServiceImpl extends CalendarServiceGrpc.CalendarServiceImplBase {

    @Autowired
    AccessService accessService;

    @Override
    public void getEvents(CalendarServiceProto.GetEventsRequest request, StreamObserver<CalendarServiceProto.GetEventsResponse> responseObserver) {
        GetEventsPayloadRequest getEventsPayloadRequest = new Gson().fromJson(request.getJson(), GetEventsPayloadRequest.class);
        String json  = accessService.getAll(getEventsPayloadRequest);
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
        String json = accessService.getEvent(getEventPayloadRequest.getEventId(),getEventPayloadRequest.getUserId());
        CalendarServiceProto.GetEventResponse response = CalendarServiceProto.GetEventResponse
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
