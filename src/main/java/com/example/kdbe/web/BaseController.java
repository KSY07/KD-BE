package com.example.kdbe.web;

import com.example.kdbe.model.dto.response.ResultData;
import com.example.kdbe.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BaseController<E,D> {

    BaseService<E,D> getService();

    @GetMapping("/{id}")
    default ResponseEntity<ResultData> get(@PathVariable Long id){
        return ResultData.ok(getService().get(id));
    }

    @PostMapping("/{id}")
    default ResponseEntity<ResultData> post(@PathVariable Long id, @RequestBody D dto){ return ResultData.ok(getService().add(id,dto)); }

    @PutMapping("/{id}")
    default ResponseEntity<ResultData> put(@PathVariable Long id, @RequestBody D dto){ return ResultData.ok(getService().update(id,dto)); }

    @DeleteMapping("/{id}")
    default ResponseEntity<ResultData> delete(@PathVariable Long id, @RequestBody D dto){
        getService().delete(id,dto);
        return ResultData.delete();
    }

}
