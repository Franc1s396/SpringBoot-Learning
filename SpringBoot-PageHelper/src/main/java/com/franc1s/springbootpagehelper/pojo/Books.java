package com.franc1s.springbootpagehelper.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Books {
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
}
