package pl.coderslab.converter;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Publisher;

public class StringToPublisherConverter implements Converter<String, Publisher> {

    @Override
    public Publisher convert(String source) {

        try {

            long publisherId = Long.parseLong(source);

            Publisher publisher = new Publisher();
            publisher.setId(publisherId);

            return publisher;
        } catch (NumberFormatException e) {

        }
        return null;
    }
}
