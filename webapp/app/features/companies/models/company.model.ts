import {Address} from "./address";

export interface ICompany {
  id?: number;
  name?: string;
  email?: string;
  image?: string;
  phone?: string;
  address?: Address;
  edited?: boolean;
}

export class Company implements ICompany {
  id?: number;
  name?: string;
  email?: string;
  image?: string;
  phone?: string;
  address?: Address;
  edited?: boolean;
}


