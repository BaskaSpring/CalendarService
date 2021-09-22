package com.baska.CalendarService.Grpc;

import com.baska.CalendarService.Service.AccessService;
import com.baska.CalendarService.models.EventsData;
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
        String s  = accessService.getAll(getEventsPayloadRequest);
    }

    @Override
    public void getEvent(CalendarServiceProto.GetEventRequest request, StreamObserver<CalendarServiceProto.GetEventResponse> responseObserver) {

    }

    @Override
    public void updateEvent(CalendarServiceProto.UpdateEventRequest request, StreamObserver<CalendarServiceProto.UpdateEventResponse> responseObserver) {

    }

    @Override
    public void deleteEvent(CalendarServiceProto.DeleteEventRequest request, StreamObserver<CalendarServiceProto.DeleteEventResponse> responseObserver) {

    }

}
