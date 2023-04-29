/*    */ package mzm.gsp.aircraft;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AircraftInfo implements Marshal, Comparable<AircraftInfo>
/*    */ {
/*    */   public int dye_color_id;
/*    */   
/*    */   public AircraftInfo() {}
/*    */   
/*    */   public AircraftInfo(int _dye_color_id_)
/*    */   {
/* 15 */     this.dye_color_id = _dye_color_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 23 */     _os_.marshal(this.dye_color_id);
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 28 */     this.dye_color_id = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 33 */     if (_o1_ == this) return true;
/* 34 */     if ((_o1_ instanceof AircraftInfo)) {
/* 35 */       AircraftInfo _o_ = (AircraftInfo)_o1_;
/* 36 */       if (this.dye_color_id != _o_.dye_color_id) return false;
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 43 */     int _h_ = 0;
/* 44 */     _h_ += this.dye_color_id;
/* 45 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuilder _sb_ = new StringBuilder();
/* 50 */     _sb_.append("(");
/* 51 */     _sb_.append(this.dye_color_id).append(",");
/* 52 */     _sb_.append(")");
/* 53 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AircraftInfo _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     _c_ = this.dye_color_id - _o_.dye_color_id;
/* 60 */     if (0 != _c_) return _c_;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\AircraftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */