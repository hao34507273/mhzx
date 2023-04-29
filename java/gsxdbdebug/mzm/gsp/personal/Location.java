/*    */ package mzm.gsp.personal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class Location
/*    */   implements Marshal, Comparable<Location>
/*    */ {
/*    */   public int province;
/*    */   public int city;
/*    */   
/*    */   public Location() {}
/*    */   
/*    */   public Location(int _province_, int _city_)
/*    */   {
/* 18 */     this.province = _province_;
/* 19 */     this.city = _city_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.province);
/* 28 */     _os_.marshal(this.city);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.province = _os_.unmarshal_int();
/* 34 */     this.city = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof Location)) {
/* 41 */       Location _o_ = (Location)_o1_;
/* 42 */       if (this.province != _o_.province) return false;
/* 43 */       if (this.city != _o_.city) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.province;
/* 52 */     _h_ += this.city;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.province).append(",");
/* 60 */     _sb_.append(this.city).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Location _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.province - _o_.province;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.city - _o_.city;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\Location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */