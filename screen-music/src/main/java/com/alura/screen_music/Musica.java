package com.alura.screen_music;

import jakarta.persistence.*;

@Entity
@Table(name = "Musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "artista")
    private String titulo;

    @ManyToOne
    private Artista artista;



    public Musica(){}

    public Musica(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Musica(String nomeMusica) {
        this.titulo = nomeMusica;
    }

    public long getId() {
        return id;
    }

    public Musica setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Musica setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Artista getArtista() {
        return artista;
    }

    public Musica setArtista(Artista artista) {
        this.artista = artista;
        return this;
    }

    @Override
    public String toString() {
        return "Música = " + titulo + '\'' +
                ", Artista = " + artista.getNome();
    }
}
