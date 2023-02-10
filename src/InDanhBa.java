import javafx.scene.control.Button;

public class InDanhBa {
    String ten;
    String sdt;
    Button edit;

    public InDanhBa(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) ->{
            DanhBa.editNguoidung = this;
            DanhBa.stPhone.setText(this.sdt);
            DanhBa.stName.setText(this.ten);
        });
    }



    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String toString(){
        return this.ten;
    }
}