package testa;

import java.awt.Desktop;
import org.primefaces.component.accordionpanel.*;
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
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ClienteDAOImpl;
import util.HibernateUtil;
@SessionScoped
@ManagedBean
public class ClienteBean {
	private Cliente cliente = new Cliente();
	private Endereco end = new Endereco();
	
	private boolean flag;
	AccordionPanel panel ;
	
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
		cliente.setEndereco(end);
		end.setCliente(cliente);
		
	}
	
	public void nome(){
		panel.setActiveIndex("1");		
	}
	
	public void teste(TabChangeEvent event){
		
		//if(cliente.getProprietario() == null){
			//panel.set
			//System.out.println("test");
	//	}
		
	}
	
	public void teste2(TabCloseEvent event){
		if(!(cliente.getProprietario() == null)){
			flag = true;
			System.out.println(cliente.getProprietario());
		}
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
			PdfWriter.getInstance(document, new FileOutputStream("c:\\users\\mand4\\documento.pdf"));
			document.open();
			Paragraph p1 = new Paragraph("Teste do PDF");
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setFont(new Font(FontFamily.TIMES_ROMAN,20,Font.BOLD));
			document.addAuthor("Adriano Macedo TCC");
			document.addCreationDate();
			document.addTitle("IRRIGACAO POR ASPERSAO");
			document.add(p1);
			document.add(new Paragraph("Nome do produtor: "+cliente.getProprietario()));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		finally{
			document.close();
		}
		try {
			Desktop.getDesktop().open(new File("c:\\users\\mand4\\documento.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
}
