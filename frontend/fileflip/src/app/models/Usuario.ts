import { Arquivo } from './arquivo';

export interface Usuario {
  id: string;
  username: string;
  email: string;
  googleVinculado: boolean;
  googleName: string;
  googlePictureUrl: string;
  arquivos?: Arquivo[];
}
