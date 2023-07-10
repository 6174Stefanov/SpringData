package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShampooService {

    List<Shampoo> findByBrand(String Brand);

    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabelId(Size size, long labelId);
}
