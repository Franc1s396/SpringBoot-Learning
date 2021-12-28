package org.francis.springbootspringbatch.config.input.overview;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;
import java.util.List;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
public class InputOverviewItemReader implements ItemReader<String> {
    Iterator<String> iterator;

    public InputOverviewItemReader(List<String> data) {
        this.iterator = data.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (this.iterator.hasNext()){
            return this.iterator.next();
        }else {
            return null;
        }
    }
}
