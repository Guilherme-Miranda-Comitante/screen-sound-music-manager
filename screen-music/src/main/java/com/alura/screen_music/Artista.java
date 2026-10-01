package com.alura.screen_music;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nome", nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;

    public Artista(){}

    public Artista(String nome, TipoArtista tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public Artista setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Artista setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public Artista setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
        return this;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public Artista setTipo(TipoArtista tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String toString() {
        return "nome = " + nome + '\'' +
                ", tipo = " + tipo +
                ", musicas = " + musicas +
                '}';
    }
}
