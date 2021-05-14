package Doanbanhang.DTO;

public class dulieuthongke {
       public String  ID, MaHD,NgayXuat,KhachHang,MaSoMatHang,TongTien,GiamGia,ThanhTien;
        public  dulieuthongke (String ID, String MaHD, String NgayXuat, String KhachHang, String MaSoMatHang ,String TongTien,  String GiamGia, String ThanhTien )
        {
           this.ID=ID;
           this.MaHD=MaHD;
           this.NgayXuat=NgayXuat;
           this.KhachHang=KhachHang;
           this.MaSoMatHang=MaSoMatHang;
           this.TongTien=TongTien;
           this.GiamGia=GiamGia;
           this.ThanhTien=ThanhTien;
        }
        public dulieuthongke ()
            {
    
            }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    public String getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(String KhachHang) {
        this.KhachHang = KhachHang;
    }

    public String getMaSoMatHang() {
        return MaSoMatHang;
    }

    public void setMaSoMatHang(String MaSoMatHang) {
        this.MaSoMatHang = MaSoMatHang;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public String getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(String GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
 
    public String toString(){
        return ID+ MaHD+NgayXuat+KhachHang + TongTien+GiamGia+ThanhTien;
    }
}