/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcUserProfileInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets nickname;
/*    */   public int gender;
/*    */   public Octets figure_url;
/*    */   public Octets province;
/*    */   public Octets city;
/*    */   
/*    */   public GrcUserProfileInfo()
/*    */   {
/* 16 */     this.nickname = new Octets();
/* 17 */     this.figure_url = new Octets();
/* 18 */     this.province = new Octets();
/* 19 */     this.city = new Octets();
/*    */   }
/*    */   
/*    */   public GrcUserProfileInfo(Octets _nickname_, int _gender_, Octets _figure_url_, Octets _province_, Octets _city_) {
/* 23 */     this.nickname = _nickname_;
/* 24 */     this.gender = _gender_;
/* 25 */     this.figure_url = _figure_url_;
/* 26 */     this.province = _province_;
/* 27 */     this.city = _city_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.nickname);
/* 36 */     _os_.marshal(this.gender);
/* 37 */     _os_.marshal(this.figure_url);
/* 38 */     _os_.marshal(this.province);
/* 39 */     _os_.marshal(this.city);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.nickname = _os_.unmarshal_Octets();
/* 45 */     this.gender = _os_.unmarshal_int();
/* 46 */     this.figure_url = _os_.unmarshal_Octets();
/* 47 */     this.province = _os_.unmarshal_Octets();
/* 48 */     this.city = _os_.unmarshal_Octets();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof GrcUserProfileInfo)) {
/* 55 */       GrcUserProfileInfo _o_ = (GrcUserProfileInfo)_o1_;
/* 56 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 57 */       if (this.gender != _o_.gender) return false;
/* 58 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 59 */       if (!this.province.equals(_o_.province)) return false;
/* 60 */       if (!this.city.equals(_o_.city)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.nickname.hashCode();
/* 69 */     _h_ += this.gender;
/* 70 */     _h_ += this.figure_url.hashCode();
/* 71 */     _h_ += this.province.hashCode();
/* 72 */     _h_ += this.city.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 80 */     _sb_.append(this.gender).append(",");
/* 81 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 82 */     _sb_.append("B").append(this.province.size()).append(",");
/* 83 */     _sb_.append("B").append(this.city.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserProfileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */