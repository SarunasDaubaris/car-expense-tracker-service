package com.personalgarage.service.common.components;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.personalgarage.service.common.interfaces.constants.CommonDateTimeFormat;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class JacksonJodaDateTimeDeserializer extends StdDeserializer<DateTime> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(CommonDateTimeFormat.DATE_FORMAT);

    public JacksonJodaDateTimeDeserializer() {
        this(null);
    }

    public JacksonJodaDateTimeDeserializer(Class<DateTime> klass) {
        super(klass);
    }

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateTimeText = jsonParser.getText();
        if (StringUtils.isNotBlank(dateTimeText)) {
            DateTime.parse(dateTimeText, DATE_TIME_FORMATTER).toDateTime(DateTimeZone.UTC);
        }
        return null;
    }
}
