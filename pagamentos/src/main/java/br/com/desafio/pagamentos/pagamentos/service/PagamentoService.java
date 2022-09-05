package br.com.desafio.pagamentos.pagamentos.service;

import br.com.desafio.pagamentos.pagamentos.model.Pagamento;
import br.com.desafio.pagamentos.pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }


    public void cadastraPagamento(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }
}
