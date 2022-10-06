package strategy;

public enum TipoJuro {

	CDI {
		@Override
		public CalculoJuroRendaFixa obterTipoJuro() {
			return new Cdi();
		}
	},
	
	POUPANCA {
		@Override
		public CalculoJuroRendaFixa obterTipoJuro() {
			return new Poupanca();
		}
	},
	
	SIMULADORJURO {

		@Override
		public CalculoJuroRendaFixa obterTipoJuro() {
			return new SimuladorJuro();
		}
		
	};
	
	public abstract CalculoJuroRendaFixa obterTipoJuro();
}
