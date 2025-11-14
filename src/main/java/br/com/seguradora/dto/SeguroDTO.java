package br.com.seguradora.dto;
// dto / domain
// Ou usar @Lombok @Getter @Setter
import java.util.List;

public class SeguroDTO {
    private Long bemId;
    private List<Long> coberturaIds;

    public Long getBemId() { return bemId; }
    public void setBemId(Long bemId) { this.bemId = bemId; }
    public List<Long> getCoberturaIds() { return coberturaIds; }
    public void setCoberturaIds(List<Long> coberturaIds) { this.coberturaIds = coberturaIds; }
}
