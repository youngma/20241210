package musinsa.bob.main.config.jsonConfig;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneySerializer extends JsonSerializer<BigDecimal> {
    private static final DecimalFormat FORMATTER = new DecimalFormat("#,###");

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeString(FORMATTER.format(value));
    }
}

