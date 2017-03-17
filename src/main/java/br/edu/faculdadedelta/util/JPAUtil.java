package br.edu.faculdadedelta.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum JPAUtil {
	
	INSTANCE;
	
	private EntityManagerFactory factory;

	private JPAUtil() {
		factory=Persistence.createEntityManagerFactory("JpaJavaeePU");
	}
	
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}

	
	public enum SexoClienteEnum {
		MASCULINO("M"), FEMININO("F");

		private final String value;

		SexoClienteEnum(String value) {
			this.value = value;
		}

		public static SexoClienteEnum fromValue(String value) {
			if (value != null) {
				for (SexoClienteEnum sexo : values()) {
					if (sexo.value.equals(value)) {
						return sexo;
					}
				}
			}
			throw new IllegalArgumentException("Sexo invalido: " + value);
		}

		public String toValue() {
			return value;
	}
	
		}
}
