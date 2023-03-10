import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DanhBa implements Initializable {

    public TextField tlPhone;
    public TextField txtName;
    public static TextField stPhone;
    public static TextField stName;
    public Text txtInfo;
    public ObservableList<InDanhBa> listNguoidung = FXCollections.observableArrayList();

    public static InDanhBa editNguoidung;
    public TableView<InDanhBa> tbView;
    public TableColumn<InDanhBa,String> cName;
    public TableColumn<InDanhBa,String> cPhone;
    public TableColumn<InDanhBa, Button> cAction;


    public void submit(ActionEvent actionEvent) {
        String nn = txtName.getText();
        String tp = tlPhone.getText();

        if (editNguoidung == null){
            InDanhBa s = new InDanhBa(nn, tp);
            listNguoidung.add(s);
        }else {
            for (InDanhBa s : listNguoidung){
                if (s.ten.equals(editNguoidung.ten) && s.sdt.equals((editNguoidung).sdt)){
                    s.setTen(nn);
                    s.setSdt(tp);
                }
            }
        }
        tbView.setItems(listNguoidung);
        tbView.refresh();
        editNguoidung = null;
        clearInput();
    }
    void clearInput(){
        txtName.clear();
        tlPhone.clear();
    }
    public void edit(MouseEvent mouseEvent) {
        // editNguoidung = lv.getSelectionModel().getSelectedItem();
        txtName.setText(editNguoidung.getTen());
        tlPhone.setText(editNguoidung.getSdt());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("ten"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stName = txtName;
        stPhone = tlPhone;
    }
}