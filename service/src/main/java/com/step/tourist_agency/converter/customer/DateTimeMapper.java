package com.step.tourist_agency.converter.customer;

import com.step.tourist_agency.exception.DateTimeMapperException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.step.tourist_agency.constants.Constants.DATE_PATTERN;
import static com.step.tourist_agency.constants.Constants.DATE_TIME_PATTERN;

public class DateTimeMapper {

    public static String date(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_TIME_PATTERN).format(date);
    }

    public static Date date(String date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(date.length() > 10 ? DATE_TIME_PATTERN : DATE_PATTERN).parse(date);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        throw new DateTimeMapperException();
    }
}