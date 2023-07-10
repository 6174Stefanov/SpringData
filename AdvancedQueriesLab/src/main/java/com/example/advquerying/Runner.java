package com.example.advquerying;

import com.example.advquerying.entities.BaseEntity;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;


@Component
public class Runner implements CommandLineRunner {

    private ShampooService shampooService;

    public Runner(ShampooService shampooService) {
        this.shampooService = shampooService;
    }


    @Override
    public void run(String... args) throws Exception {

        //List<Shampoo> byBrand = shampooService.findByBrand("Swiss Green Apple & Nettle");

        //  List<Shampoo> bySize = shampooService.findBySize(Size.MEDIUM);
        // or bySize.sort(Comparator.comparing(BaseEntity::getId)); if not defined in name

        List<Shampoo> result = shampooService.findBySizeOrLabelId(Size.MEDIUM, 10L);

        result.forEach(System.out::println);
    }
}
