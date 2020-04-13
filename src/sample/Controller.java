package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Paises contryManager;

    @FXML private ImageView arrowUser;
    @FXML private ImageView arrowLocation;
    @FXML private ImageView arrowEducation;

    @FXML private AnchorPane userPanel;
    @FXML private AnchorPane locationPanel;
    @FXML private AnchorPane educationPanel;

    @FXML private JFXComboBox<String> comboBoxTipoID;
    @FXML private JFXComboBox<String> comboBoxEstadoCivil;
    @FXML private JFXComboBox<String> comboBoxAcademicLv;

    @FXML private JFXRadioButton radioButtonMale;
    @FXML private JFXRadioButton radioButtonFamale;

    @FXML private JFXTextField name;
    @FXML private JFXTextField lastName;
    @FXML private JFXTextField id;
    @FXML private JFXTextField degreeText;
    @FXML private JFXTextField careerText;

    @FXML private JFXComboBox<String> comboCountry;
    @FXML private JFXComboBox<String> comboState;
    @FXML private JFXComboBox<String> comboCity;



    ObservableList<String> comboBoxIDContent =
            FXCollections.observableArrayList(
                    "C.C","C.E","T.I","R.C"
            );

    ObservableList<String> comboBoxEstadoContent =
            FXCollections.observableArrayList(
                    "Soltero","Casado","Union Libre"
            );

    ObservableList<String> comboBoxLevelAcademic =
            FXCollections.observableArrayList(
                    "Primaria",
                         "Secundaria",
                         "Tecnica",
                         "Tecnologica",
                         "Profesional",
                         "Maestria",
                         "Phylosophal Doctor"
            );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        contryManager =  new Paises();

        comboCountry.setItems(contryManager.getCountries());


        name.addEventFilter(KeyEvent.ANY, handlerLetters);
        lastName.addEventFilter(KeyEvent.ANY, handlerLetters);
        id.addEventFilter(KeyEvent.ANY, handlerNumbers);


        comboBoxTipoID.setItems(comboBoxIDContent);
        comboBoxEstadoCivil.setItems(comboBoxEstadoContent);
        comboBoxAcademicLv.setItems(comboBoxLevelAcademic);

        ToggleGroup group = new ToggleGroup();
        radioButtonMale.setToggleGroup(group);
        radioButtonFamale.setToggleGroup(group);


    }

    public void onExitButtonClicked(MouseEvent mouseEvent){
        Platform.exit();
        System.exit(0);
    }

    public void onUserButtonClicked(MouseEvent mouseEvent){
        if (userPanel.isVisible()){
            userPanel.setVisible(false);
            arrowUser.setVisible(false);
            return;
        }
        userPanel.setVisible(true);
        arrowUser.setVisible(true);

        locationPanel.setVisible(false);
        arrowLocation.setVisible(false);
        educationPanel.setVisible(false);
        arrowEducation.setVisible(false);
    }

    public void onLocationButtonClicked(MouseEvent mouseEvent){
        if (locationPanel.isVisible()){
            userPanel.setVisible(false);
            arrowLocation.setVisible(false);
            return;
        }
        locationPanel.setVisible(true);
        arrowLocation.setVisible(true);

        educationPanel.setVisible(false);
        arrowEducation.setVisible(false);
        userPanel.setVisible(false);
        arrowUser.setVisible(false);
    }

    public void onEducationButtonClicked(MouseEvent mouseEvent){
        if (educationPanel.isVisible()){
            educationPanel.setVisible(false);
            arrowEducation.setVisible(false);
            return;
        }
        educationPanel.setVisible(true);
        arrowEducation.setVisible(true);

        userPanel.setVisible(false);
        arrowUser.setVisible(false);
        locationPanel.setVisible(false);
        arrowLocation.setVisible(false);

        comboBoxAcademicLv.requestFocus();
    }

    EventHandler<KeyEvent> handlerLetters= new EventHandler<KeyEvent>(){

        private boolean willConsume = false;

        @Override
        public void handle(KeyEvent keyEvent) {
            if (willConsume){
                keyEvent.consume();
            }
            if (!keyEvent.getCode().toString().matches("[a-zA-Z]") && keyEvent.getCode() != KeyCode.BACK_SPACE
                    && keyEvent.getCode() != KeyCode.SHIFT){
                if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED){
                willConsume = true;
                } else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                willConsume = false;
                }
            }
        }
    };

    EventHandler<KeyEvent> handlerNumbers= new EventHandler<KeyEvent>(){

        private boolean willConsume = false;
        private int maxLength = 10;

        @Override
        public void handle(KeyEvent keyEvent) {
            JFXTextField temp = (JFXTextField) keyEvent.getSource();

            if (willConsume){
                keyEvent.consume();
            }

            if (!keyEvent.getText().matches("[0-9]") && keyEvent.getCode() != KeyCode.BACK_SPACE){
                if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED){
                    willConsume = true;
                } else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                    willConsume = false;
                }
            }
            if (temp.getText().length() > maxLength - 1){
                if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED){
                    willConsume = true;
                } else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                    willConsume = false;
                }
            }

        }
    };

    public void onComboCountriesChange(ActionEvent event){
        comboState.setDisable(false);
        for (int i = 0; i < contryManager.getSize(); i++){
            if (comboCountry.getValue().equals(contryManager.getCountry(i))){
            comboState.setItems(contryManager.getStates(i));
            }
        }

    }

    public void onComboStatesChange(ActionEvent event){
        comboCity.setDisable(false);

    }

    public void onEducationComboBoxChanged(ActionEvent event){
        for (int i = 2; i < comboBoxLevelAcademic.size(); i++){
            if (comboBoxAcademicLv.getValue().equals(comboBoxLevelAcademic.get(i))){
                degreeText.setDisable(false);
                return;
            }
        }
        degreeText.setDisable(true);
    }

    public void onToggleButtonChange(ActionEvent event){
         if (careerText.isDisable()){
             careerText.setDisable(false);
         }else{
             careerText.setText("");
             careerText.setDisable(true);
         }
    }

    }

