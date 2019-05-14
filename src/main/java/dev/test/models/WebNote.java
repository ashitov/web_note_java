package dev.test.models;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class WebNote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    public void setTitle(String _title){
        this.title = _title;
    }

    public void setText(String _text){
        this.text = _text;
    }

    public void setId(int _id){
        this.id = _id;
    }

    public String getTitle(){
        return title;
    }

    public String getText(){
        return text;
    }

    public int getId(){
        return id;
    }



}
