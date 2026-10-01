package com.alura.screen_music;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final ArtistaRepository repositorio;

    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }


    public void exibirMenu(){
        System.out.println("--- SCREEN MUSIC ---");
        var opcao = - 1;
        while(opcao != 9) {
           var menu = """
                   1 - Cadastrar artista
                   2 - Cadastrar música
                   3 - Listas músicas
                   4 - Buscar músicas pelo artista
                   
                   9 - Sair
                   """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 9:
                    System.out.println("Encerrando aplicação...");
                    break;
                default:
                    System.out.println("Não há nenhuma opção com este número no Menu. Coloque um número válido.");
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Digite o nome do artista para cadastro: ");
            var nome = leitura.nextLine();
            System.out.println("Digite o tipo deste artista: (solo, dupla ou banda)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artistaCadastrado = new Artista(nome, tipoArtista);
            repositorio.save(artistaCadastrado);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }

    }

    private void cadastrarMusica() {
        System.out.println("Digite música de que artista: ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.println("Informe o título da música: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado! ");
        }


    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Nome para busca: ");
        var nomeArtista = leitura.nextLine();
        List<Musica> musicas = repositorio.buscarMusicasPorArtista(nomeArtista);
        System.out.println("Músicas do autor -> " + nomeArtista);
        musicas.forEach(System.out::println);

    }
}
