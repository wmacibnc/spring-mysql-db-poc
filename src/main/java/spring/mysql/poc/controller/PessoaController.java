package spring.mysql.poc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mysql.poc.model.Pessoa;
import spring.mysql.poc.repository.PessoaRepository;

@Controller
@RequestMapping(path = "/pessoa")

public class PessoaController {

	@Autowired
	private PessoaRepository repository;

	@GetMapping(path = "/teste", produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody String salvar(@RequestParam Integer registros) {
		repository.deleteAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("Início Salvar: " + formatarHora(new Date()) + " <br />");
		for (int i = 1; i <= registros; i++) {
			Pessoa pessoa = new Pessoa("Nome " + i, "E-mail " + i);
			repository.save(pessoa);
		}
		sb.append("Fim Salvar: " + formatarHora(new Date()) + "<br />");

		sb.append("Início Busca Registro Existe: Nome " + registros + " - " + formatarHora(new Date()) + " <br />");
		sb.append("Pessoa: " + repository.findByNome("Nome " + registros) + " <br />");
		sb.append("Fim Busca Registro Existe: Nome " + registros + " - " + formatarHora(new Date()) + " <br />");

		sb.append("Início Busca Registro Não Existe: Nome " + registros + 1 + " - " + formatarHora(new Date()) + " <br />");
		repository.findByNome("Nome " + registros + 1);
		sb.append("Fim Busca Registro Não Existe: Nome " + registros + 1 + " - " + formatarHora(new Date()) + " <br />");
		sb.append("</body>");
		sb.append("</html>");
		repository.deleteAll();
		return sb.toString();
	}

	@GetMapping(path = "/salvar")
	public @ResponseBody String salvar(@RequestParam String nome, @RequestParam String email) {
		// http://localhost:8080/pessoa/salvar?nome=First&email=someemail@someemailprovider.com
		Pessoa pessoa = new Pessoa(nome, email);
		repository.save(pessoa);
		return "Dados Salvo com sucesso! Pessoa: " + pessoa.toString();
	}

	@GetMapping(path = "/listar")
	public @ResponseBody Iterable<Pessoa> listar() {
		return repository.findAll();
	}

	private String formatarHora(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
		return sdf.format(data);
	}
}