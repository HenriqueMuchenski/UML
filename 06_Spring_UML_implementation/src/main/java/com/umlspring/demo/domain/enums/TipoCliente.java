package com.umlspring.demo.domain.enums;

public enum TipoCliente {

	// Valor(<numero que representará o valo no banco>, <descrição>);
	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private int codigo;
	private String descricao;

	// Construtor de tipo Enum é private.
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	// Obtém o valor enum pelo Id, onde este Id é um número que representa
	// o enum no banco de dados.
	public static TipoCliente toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		// Para cada valor do enum no TipoCliente, faça.
		for (TipoCliente x : TipoCliente.values()) {
			if (codigo.equals(x.getCodigo()))
				return x;
		}
		throw new IllegalArgumentException("Id inválido " + codigo);
	}
}
