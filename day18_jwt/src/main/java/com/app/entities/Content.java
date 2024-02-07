package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Content_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Course_ID")
    private Long cid;

    @Column(name = "Title")
    private String name;

    @Column(name = "Description")
    private String desc;

    @Column(name = "Link")
    private String filePath;
}
