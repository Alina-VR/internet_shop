package com.example.models;

import com.vaadin.flow.component.html.Image;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

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
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }


//    public void addImageToProduct(Image image) {
//        image.setProduct(this);
//        images.add(image);
//    }

//    String getInformation() {
//
//    }
}
