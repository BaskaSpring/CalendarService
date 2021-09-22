package com.baska.CalendarService.models;

public enum ERole {
    WRITE{
        @Override
        public String toString(){
            return "WRITE";
        }
    },
    READ{
        @Override
        public String toString(){
            return "READ";
        }
    }
}
