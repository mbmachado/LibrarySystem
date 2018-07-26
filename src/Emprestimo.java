package src;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Emprestimo {
	private Exemplar exemplar;
	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucaoPrevista;
	private LocalDate dataDevolucaoReal;

	public Emprestimo(Exemplar exemplar, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal) {
		this.exemplar = exemplar;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.dataDevolucaoReal = dataDevolucaoReal;
	}
	
	public boolean jaRealizado(Exemplar exemplar) {
		if((this.exemplar.getLivro()).equals(exemplar.getLivro())) {
			return true;
		}
		return false;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}
	
	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public Date getDataDevolucaoPrevista() {
	    return new Date();
        // TODO remover comentário depois de adaptar o método na classe Usuário
	    //return dataDevolucaoPrevista;
	}
	
	public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	public LocalDate getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}
	
	public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}

	public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String dataDevolucao;

	    if(dataDevolucaoReal == null) {
            dataDevolucao = "Data devolução prevista: " + dataDevolucaoPrevista.format(dateFormat);
        } else {
	        dataDevolucao = "Data de devolução: " + dataDevolucaoReal.format(dateFormat);
        }

        String titulo = "Título: " + exemplar.getLivro().getTitulo();
	    String dataEmprestimo = ", Data do emprestimo: " + this.dataEmprestimo.format(dateFormat);
        String status = ", Status: " + exemplar.getStatus();

        return titulo + dataEmprestimo + status + dataDevolucao;
    }
}
