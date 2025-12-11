package org.example.AgenciaAduanera.modelo.auditoria;

public interface Auditable {
    Auditoria getAuditoria();
    void setAuditoria(Auditoria auditoria);
}
