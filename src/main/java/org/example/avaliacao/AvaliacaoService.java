@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao salvar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao buscarPorId(int id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    public List<Avaliacao> listarTodas() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao atualizar(int id, Avaliacao novaAvaliacao) {
        Avaliacao existente = buscarPorId(id);
        existente.setNota(novaAvaliacao.getNota());
        existente.setComentario(novaAvaliacao.getComentario());
        return avaliacaoRepository.save(existente);
    }

    public void deletar(int id) {
        avaliacaoRepository.deleteById(id);
    }
}
