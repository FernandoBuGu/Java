package randomMutationsSimulator;

class Black extends Human{
	String Black_referenceGenome = "AATCGAT";
	public static class Factory implements typeinfo.factory.Factory<Black>{
		public Black create() {
			return new Black();
		}
	}
}

class Asian extends Human{
	String Asian_referenceGenome = "AGGGTCGT";
	public static class Factory implements typeinfo.factory.Factory<Asian>{
		public Asian create() {
			return new Asian();
		}
	}
}

class TawianFemale extends AsianFemale{
	String TawianFemale_referenceGenome = "ATCAGTCGT";
	public static class Factory implements typeinfo.factory.Factory<TawianFemale>{
		public TawianFemale create() {
			return new TawianFemale();
		}
	}
}

class AsianFemale extends Asian{
	String AsianFemale_referenceGenome = "AGTCGG";
	public static class Factory implements typeinfo.factory.Factory<AsianFemale>{
		public AsianFemale create() {
			return new AsianFemale();
		}
	}
}

class AsianMale extends Asian{
	String AsianMale_referenceGenome = "AAACGG";
	public static class Factory implements typeinfo.factory.Factory<AsianMale>{
		public AsianMale create() {
			return new AsianMale();
		}
	}
}

class Jewish extends White{
	String Jewish_referenceGenome = "AAGGACAG";
	public static class Factory implements typeinfo.factory.Factory<Jewish>{
		public Jewish create() {
			return new Jewish();
		}
	}
}

class White extends Human{
	String White_referenceGenome = "CCACAT";
	public static class Factory implements typeinfo.factory.Factory<White>{
		public White create() {
			return new White();
		}
	}
}

class SouthAmerican extends White{
	String SouthAmerican_referenceGenome = "CTTCAAAT";
	public static class Factory implements typeinfo.factory.Factory<SouthAmerican>{
		public SouthAmerican create() {
			return new SouthAmerican();
		}
	}
}

class BlackMale extends Black{
	String BlackMale_referenceGenome = "CTTTAAACG";
	public static class Factory implements typeinfo.factory.Factory<BlackMale>{
		public BlackMale create() {
			return new BlackMale();
		}
	}
}

class BlackFemale extends Black{
	String BlackFemale_referenceGenome = "CATAACG";
	public static class Factory implements typeinfo.factory.Factory<BlackFemale>{
		public BlackFemale create() {
			return new BlackFemale();
		}
	}
}

class WhiteFemale extends White{
	String WhiteFemale_referenceGenome = "CATAGATC";
	public static class Factory implements typeinfo.factory.Factory<WhiteFemale>{
		public WhiteFemale create() {
			return new WhiteFemale();
		}
	}
}