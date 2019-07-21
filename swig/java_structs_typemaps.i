%extend GoSlice {
	int isEqual(GoSlice *slice){
		return (($self->len == slice->len)) && (memcmp($self->data,slice->data, sizeof(GoSlice_))==0 );
	}

	void convertString(_GoString_ data){
		$self->data = data.p;
		$self->len = strlen(data.p);
		$self->cap = $self->len;
	}

	void setAtChar(char p,long long i){
		((char *) $self->data)[i] = p;
	}

void getString(_GoString_ *out){
	out->p = (char *)$self->data;
	out->n = strlen((char *)$self->data);
}

int getAtString(int index, _GoString_ *outs )
{
	int i;
	_GoString_ *iStr;
	char *out;
	for (i = 0, iStr = (_GoString_ *)$self->data; i < $self->len; ++i, ++iStr)
	{
		if (index == i)
		{
			out = _GoString__getString(iStr);
			_GoString__SetString(outs,out);
			return 0;
		}
	}
	return 1;
}

}

%extend _GoString_ {
	int SetString(char * str){
		$self->p = str;
		$self->n = strlen(str);
	}
	char * getString(){
		return (const char *)$self->p;
	}
		int isEqual( _GoString_ *string2)
{
  return ($self->n == string2->n) &&
         (strcmp((char *)$self->p, (char *)string2->p) == 0);
}
}

%extend cipher_SHA256 {
    	_GoString_ getStr(){
		_GoString_ str;
		str.p = (const char*)$self->data;
		str.n = strlen(str.p);
		return str;
    }
}

%extend coin__Transaction {
    int	setInnerHash(cipher_SHA256 h){
		memset($self->InnerHash, 0, sizeof(cipher__SHA256));
			cipher_SHA256_assignFrom($self->InnerHash,&h);
			return 0;
    }

}
