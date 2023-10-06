package com.example.kdbe.model.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Getter
@NoArgsConstructor
public class ResultData {
    @Schema(title = "응답 데이터",  description = "요청 결과 데이터 값")
    private Object data;

    @Schema(title = "HTTP 상태 코드", description = "요청 결과에 대한 HTTP 상태 코드")
    private Integer status = 200;

    @Schema(title = "응답 데이터의 갯수", description = "요청 결과 데이터 갯수")
    private Integer totalCount;

    @Schema(title = "메세지 코드", description = "정의된 메세지 코드")
    private String code = "Ok";

    @Schema(title = "메세지 내용", description = "정의된 메세지 내용")
    private String message = "Success";

    @Schema(title = "응답 시간", description = "요청 결과 시간")
    private Date timeStamp;

    private ResultData(Object data){
        this(data,0,null);
    }

    private ResultData(Integer totalCount){
        this(null,totalCount,null);
    }

    private ResultData(String code){
        this(null,0,code);
    }

    private ResultData(Object data, Integer totalCount){
        this(data,totalCount,null);
    }

    private ResultData(Object data, Integer totalCount,String code){
        this.data = data;
        this.totalCount = totalCount;
        this.code = code;
        this.timeStamp = new Date();
    }

    public static ResponseEntity<ResultData> ok(Object data){
        ResultData resultData = new ResultData(data);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(Integer totalCount){
        ResultData resultData = new ResultData(totalCount);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(Object data, Integer totalCount){
        ResultData resultData = new ResultData(data, totalCount);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(Object data, Integer totalCount, String code){
        ResultData resultData = new ResultData(data, totalCount, code);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(ResultData resultData){
        return ResponseEntity.ok(resultData);
    }
}
