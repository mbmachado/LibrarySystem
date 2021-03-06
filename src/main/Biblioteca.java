package main;
import java.util.ArrayList;
import java.util.Optional;

public class Biblioteca {

    private static Biblioteca instancia;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    private Biblioteca(){}

    public static Biblioteca getInstancia() {

        if(instancia == null){
            instancia = new Biblioteca();
        }

        return instancia;
    }

    public void reservar(int codigoUsuario, int codigoLivro) {
        Livro l = this.obterLivro(codigoLivro);
        Usuario u = this.obterUsuario(codigoUsuario);
        u.fazerReserva(l);
    }

    public void devolver(int codigoUsuario, int codigoLivro) {
        Usuario u = obterUsuario(codigoUsuario);
        Livro l = obterLivro(codigoLivro);
        u.fazerDevolucao(l);
    }

    public void observar(int codigoUsuario, int codigoLivro) {
        Usuario u = obterUsuario(codigoUsuario);
        Livro l = obterLivro(codigoLivro);
        l.registerObserver((Professor) u); 
    }

    public void emprestar(int codigoUsuario, int codigoLivro) {
        Livro l = this.obterLivro(codigoLivro);
        Usuario u = this.obterUsuario(codigoUsuario);
        u.fazerEmprestimo(l);
    }
    

    public void infoLivro(int codigoLivro) {
        Livro l = obterLivro(codigoLivro);
        l.printInfoLivro();
    }

    public void infoUsuario(int codigoUsuario) {
        Usuario u = obterUsuario(codigoUsuario);
        u.printInfoUsuario();
    }

    public void notificacao(int codigoUsuario){
        Usuario u = obterUsuario(codigoUsuario);
        ((Professor) u).qtdNotificacoes(); 
    }
    
    public void sair(){
        System.exit(0);
    }
    
    public void addUsuario(Usuario u) {
    	usuarios.add(u);
    }

    public void addLivro(Livro l) {
    	livros.add(l);
    }

    private  Livro obterLivro(int codigoLivro) {
        Optional<Livro> livro =  livros.stream().filter(l -> l.getCodigo() == codigoLivro).findFirst();
        return livro.orElse(null);
    }

    private Usuario obterUsuario(int codigoUsuario){
        Optional<Usuario> usuario = usuarios.stream().filter(u -> u.getCodigo() == codigoUsuario).findFirst();
        return usuario.orElse(null);
    }
}
