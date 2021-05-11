package Doanbanhang.DTO;

public class dulieuthongke {
       public String  ID, MaHD,NgayXuat,KhachHang,TongTien,GiamGia,ThanhTien;
        public  dulieuthongke (String ID, String MaHD, String NgayXuat, String KhachHang,String TongTien,  String GiamGia, String ThanhTien )
        {
           this.ID=ID;
           this.MaHD=MaHD;
           this.NgayXuat=NgayXuat;
           this.KhachHang=KhachHang;
           this.TongTien=TongTien;
           this.GiamGia=GiamGia;
           this.ThanhTien=ThanhTien;
        }
        public String getID()
        {
            return ID;
        }
        public String getMaHD()
        {
            return MaHD;
        }
        public String getNgayXuat()
        {
            return NgayXuat;
        }
        public String getKhachHang()
        {
            return KhachHang;
        }
        public String getTongTien()
        {
            return TongTien;
        }
        public String getGiamGia()
        {
            return GiamGia;
        }
        public String getThanhTien()
        {
            return ThanhTien;
        }
}