/*    */ package mzm.gsp.aircraft;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AircraftDataInfo implements Marshal, Comparable<AircraftDataInfo>
/*    */ {
/*    */   public int aircraft_cfg_id;
/*    */   public int dye_color_id;
/*    */   
/*    */   public AircraftDataInfo() {}
/*    */   
/*    */   public AircraftDataInfo(int _aircraft_cfg_id_, int _dye_color_id_)
/*    */   {
/* 16 */     this.aircraft_cfg_id = _aircraft_cfg_id_;
/* 17 */     this.dye_color_id = _dye_color_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.aircraft_cfg_id);
/* 26 */     _os_.marshal(this.dye_color_id);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.aircraft_cfg_id = _os_.unmarshal_int();
/* 32 */     this.dye_color_id = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof AircraftDataInfo)) {
/* 39 */       AircraftDataInfo _o_ = (AircraftDataInfo)_o1_;
/* 40 */       if (this.aircraft_cfg_id != _o_.aircraft_cfg_id) return false;
/* 41 */       if (this.dye_color_id != _o_.dye_color_id) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.aircraft_cfg_id;
/* 50 */     _h_ += this.dye_color_id;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.aircraft_cfg_id).append(",");
/* 58 */     _sb_.append(this.dye_color_id).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AircraftDataInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.aircraft_cfg_id - _o_.aircraft_cfg_id;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.dye_color_id - _o_.dye_color_id;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\AircraftDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */