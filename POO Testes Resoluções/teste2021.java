// GRUPO II

// PERGUNTA 6
public class CasaInteligente(){
	private Collection<SmartDevice> dispositivos;
	private Map<String, Collection<SmartDevice>> dispositivosCasa; 
	//Divisão -> Lista de dispositivos
	
	public CasaInteligente(Collection<SmartDevice> devices){
		this.dispositivos = devices.stream().map(SmartDevice::clone()).toList();
	}
}

// PERGUNTA 8
private static class DeviceDoesNotExists extends Exception{}

public void remove(String id) throws DeviceDoesNotExists{
	SmartDevice dv = null; //para guardar e tirar no Map

	for (SmartDevice d: this.dispositivos){
		if(!d.getId().equals(id)){ 
			throw new DeviceDoesNotExists();
		}	else {
			dv = d;
			dispositivos.remove(d); //remove da lista de dispositivos apenas!
		}
	}

	for(Collection<SmartDevice> sd: this.dispositivosCasa.values()){
		dispositivosCasa.values().remove(dv);
	}
}

// PERGUNTA 9
public Iterator<SmartDevice> devicesPorConsumoCrescente(){
	return this.dispositivos.stream()
													.map(SmartDevices::clone())
													.sorted()
}

// PERGUNTA 10
//determina divisao com menor consumo

//percorrer as divisoes do map
//para cada divisao calcular a soma de consumo total dos devices
//comprar com o maior valor registado
//ordenar(?) -> incompleto

public String divisaoMaisEconomica(){
	double menorC = 0;
	for(String div: this.dispositivosCasa.keySet()){
			double consumoDiv = 0;
			for(Collection<SmartDevice> sd: this.dispositivosCasa.values()){
				consumoDiv += sd.getConsumoPorHora();
			}
			if(consumoDiv < menorC) {menorC = consumoDiv;}
	}
	return menorC;
}


// PERGUNTA 11
public class SmartBulbDimmable extends SmartBulb{
	private double intensidadeLuz;

	public SmartBulbDimmable(){
		super();
		this.intensidadeLuz = 0.5;
	}

	public SmartBulbDimmable(String id, double consumoPorHora double intL){
		super(id, consumoPorHora/2);
		this.intensidadeLuz = intL;
	}

	public void turnOn() {
        super.turnOn();
        if (this.intensidadeLuz == 0.5) {
            this.consumoPorHora /= 2;
        }
    }

    public double totalConsumo() {
        double consumo = super.totalConsumo();
        return consumo * this.intensidadeLuz;
    }
}

