package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class Paises {

    ArrayList<ObservableList<String>> statesItems = new ArrayList<>();

    ObservableList<String> countryItems =
            FXCollections.observableArrayList(
                    "Argentina",
                    "Bolivia",
                    "Brasil",
                    "Chile",
                    "Colombia",
                    "Costa Rica",
                    "Cuba",
                    "Ecuador",
                    "El Salvador",
                    "Guatemala",
                    "Honduras",
                    "México",
                    "Nicaragua",
                    "Panamá",
                    "Paraguay",
                    "Perú",
                    "Uruguay",
                    "Venezuela"
            );
    ObservableList<String> argentinaStates =
            FXCollections.observableArrayList(
                    "Buenos Aires",
                    "Catamarca",
                    "Chaco",
                    "Chubut",
                    "Córdoba",
                    "Corrientes",
                    "Entre Ríos",
                    "Formosa",
                    "Jujuy",
                    "La Pampa",
                    "La Rioja",
                    "Mendoza",
                    "Misiones",
                    "Neuquén",
                    "Río Negro",
                    "Salta",
                    "San Juan",
                    "San Luis",
                    "Santa Cruz",
                    "Santa Fe",
                    "Santiago del Estero",
                    "Tierra del Fuego",
                    "Tucumán"
            );
    ObservableList<String> colombiaStates =
            FXCollections.observableArrayList(
                    "Amazonas",
                    "Antioquia",
                    "Arauca",
                    "Atlántico",
                    "Bogotá",
                    "Bolívar",
                    "BoyacáCaldas",
                    "Caquetá",
                    "Casanare",
                    "Cauca",
                    "Cesar",
                    "Chocó",
                    "Córdoba",
                    "Cundinamarca",
                    "Guainía",
                    "Guaviare",
                    "Huila",
                    "La Guajira",
                    "Magdalena",
                    "Meta",
                    "Nariño",
                    "Norte de Santander",
                    "Putumayo",
                    "Quindío",
                    "Risaralda",
                    "San Andrés y Providencia",
                    "Santander",
                    "Sucre",
                    "Tolima",
                    "Valle del Cauca",
                    "Vaupés",
                    "Vichada"
            );
    ObservableList<String> boliviaStates =
            FXCollections.observableArrayList(
                    "Beni",
                    "Chuquisaca",
                    "Cochabamba",
                    "La Paz",
                    "Oruro",
                    "Pando",
                    "Potosí",
                    "Santa Cruz",
                    "Tarija"
            );
    ObservableList<String> brasilStates =
            FXCollections.observableArrayList(
                    "Acre",
                    "Alagoas",
                    "Amap\u00E1",
                    "Amazonas",
                    "Bahia",
                    "Cear\u00E1",
                    "Esp\u00EDrito Santo",
                    "Goi\u00E1s",
                    "Maranh\u00E3o",
                    "Mato Grosso",
                    "Mato Grosso do Sul",
                    "Minas Gerais",
                    "Par\u00E1",
                    "Para\u00EDba",
                    "Paran\u00E1",
                    "Pernambuco",
                    "Piau\u00ED",
                    "Rio de Janeiro",
                    "Rio Grande do Norte",
                    "Rio Grande do Sul",
                    "Rond\u00F4nia",
                    "Roraima",
                    "Santa Catarina",
                    "S\u00E3o Paulo",
                    "Sergipe",
                    "Tocantins"
            );
    ObservableList<String> chilesStates =
            FXCollections.observableArrayList(
                    "Ant\u00E1rtica Chilena",
                    "Antofagasta",
                    "Arauco",
                    "Arica",
                    "Ays\u00E9n",
                    "Biob\u00EDo",
                    "Cachapoal",
                    "Capit\u00E1n Prat",
                    "Cardenal Caro",
                    "Cauquenes",
                    "Caut\u00EDn",
                    "Chacabuco",
                    "Cha\u00F1aral",
                    "Chilo\u00E9",
                    "Choapa",
                    "Colchagua",
                    "Concepci\u00F3n",
                    "Copiap\u00F3",
                    "Cordillera",
                    "Coyhaique",
                    "Curic\u00F3",
                    "El Loa",
                    "Elqui",
                    "General Carrera",
                    "Huasco",
                    "Iquique",
                    "Isla de Pascua",
                    "Limar\u00ED",
                    "Linares",
                    "Llanquihue",
                    "Los Andes",
                    "Magallanes",
                    "Maipo",
                    "Malleco",
                    "Marga Marga",
                    "Melipilla",
                    "\u00D1uble",
                    "Osorno",
                    "Palena",
                    "Parinacota",
                    "Petorca",
                    "Quillota",
                    "Ranco",
                    "San Antonio",
                    "San Felipe de Aconcagua",
                    "Santiago",
                    "Talagante",
                    "Talca",
                    "Tamarugal",
                    "Tierra del Fuego",
                    "Tocopilla",
                    "\u00DAltima Esperanza",
                    "Valdivia",
                    "Valpara\u00EDso"
            );

    public Paises() {
        statesItems.add(argentinaStates);
        statesItems.add(boliviaStates);
        statesItems.add(brasilStates);
        statesItems.add(chilesStates);
        statesItems.add(colombiaStates);
    }

    public ObservableList<String> getCountries() {
        return countryItems;
    }

    public ObservableList<String> getStates(int index) {
        return statesItems.get(index);
    }

    public String getCountry(int index){
        return countryItems.get(index);
    }

    public int getSize(){
        return countryItems.size();
    }

}
