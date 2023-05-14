package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;


//import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description" /*,columnDefinition = "text"*/)
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "seller")
    private String seller;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
//        mappedBy = "product")
//    private List<Image> images = new ArrayList<>();
//    private Long previewImageId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
//    private LocalDateTime dateOfCreated;
//
//    @PrePersist
//    private void init() {
//        dateOfCreated = LocalDateTime.now();
//    }


//    public void addImageToProduct(Image image) {
//        image.setProduct(this);
//        images.add(image);
//    }

//    String getInformation() {
//
//    }
}
