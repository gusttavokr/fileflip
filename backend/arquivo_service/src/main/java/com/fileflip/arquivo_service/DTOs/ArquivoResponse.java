package com.fileflip.arquivo_service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import com.fileflip.arquivo_service.model.ArquivoType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoResponse {
    private String name;
    private ArquivoType tipoArquivo;
    private Long tamanhoArquivo;
    private boolean possuiFoto;
    private UUID usuarioId;
    private UUID arquivoId;
    private String urlDownload;
}
