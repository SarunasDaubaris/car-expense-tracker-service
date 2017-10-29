package com.personalgarage.service.common.components;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.personalgarage.service.common.interfaces.DefaultApplicationDateTimeFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class JacksonJodaDateTimeSerializer extends StdSerializer<DateTime> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(DefaultApplicationDateTimeFormat.DATE_FORMAT);

    public JacksonJodaDateTimeSerializer() {
        this(null);
    }

    public JacksonJodaDateTimeSerializer(Class<DateTime> klass) {
        super(klass);
    }

    @Override
    public void serialize(DateTime value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        if (value != null) {
            jsonGenerator.writeString(DATE_TIME_FORMATTER.print(value));
        }
    }
}