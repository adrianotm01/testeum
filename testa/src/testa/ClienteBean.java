package testa;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.accordionpanel.AccordionPanel;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import util.HibernateUtil;
@SessionScoped
@ManagedBean
public class ClienteBean {
	private Cliente cliente = new Cliente();
	Session sessao =  HibernateUtil.getSessionFactory().openSession();
	private boolean flag;
	AccordionPanel panel;
	private Date dataAtual = new Date();
	
	public ClienteBean() {
		dataAtual = GregorianCalendar.getInstance().getTime();
		dataAtual.setDate(dataAtual.getDate()-1);
		
		}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void salvar(){
		
		Transaction trans = sessao.beginTransaction();
		sessao.save(cliente);
		trans.commit();
		sessao.close();
		
	}
	
	public void nome(){

		if(!(cliente.getProprietario().isEmpty())){
			flag = true;
		}
	}
	
	public void teste(TabChangeEvent event){
		System.out.println(cliente.getProprietario()+"qq");
	}
	
	public void teste2(TabCloseEvent event){
		System.out.println("teste");
	}
	
	public AccordionPanel getPanel() {
		return panel;
	}

	public void setPanel(AccordionPanel panel) {
		this.panel = panel;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	public void gerarPdf(){
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
			document.open();
			document.add(new Paragraph("Teste do PDF"));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		finally{
			document.close();
		}
		try {
			Desktop.getDesktop().open(new File("documento.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
