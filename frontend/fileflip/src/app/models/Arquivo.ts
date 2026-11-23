import { Usuario } from './usuario'; 

export interface Arquivo {
  arquivo_id: string;
  name: string;
  tamanhoArquivo: number;
  possuiFoto: boolean;
  usuario_id: string;
  usuario?: Usuario;
  url_download: string;
}
