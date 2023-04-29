/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class UpdatePointRaceCorpsReq
/*    */   implements Marshal, Comparable<UpdatePointRaceCorpsReq>
/*    */ {
/*    */   public int activity_cfgid;
/*    */   public int time_point_cfgid;
/*    */   public PointRaceCorpsInfo corps_info;
/*    */   
/*    */   public UpdatePointRaceCorpsReq()
/*    */   {
/* 16 */     this.corps_info = new PointRaceCorpsInfo();
/*    */   }
/*    */   
/*    */   public UpdatePointRaceCorpsReq(int _activity_cfgid_, int _time_point_cfgid_, PointRaceCorpsInfo _corps_info_) {
/* 20 */     this.activity_cfgid = _activity_cfgid_;
/* 21 */     this.time_point_cfgid = _time_point_cfgid_;
/* 22 */     this.corps_info = _corps_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     if (!this.corps_info._validator_()) return false;
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.activity_cfgid);
/* 32 */     _os_.marshal(this.time_point_cfgid);
/* 33 */     _os_.marshal(this.corps_info);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.activity_cfgid = _os_.unmarshal_int();
/* 39 */     this.time_point_cfgid = _os_.unmarshal_int();
/* 40 */     this.corps_info.unmarshal(_os_);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof UpdatePointRaceCorpsReq)) {
/* 47 */       UpdatePointRaceCorpsReq _o_ = (UpdatePointRaceCorpsReq)_o1_;
/* 48 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 49 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 50 */       if (!this.corps_info.equals(_o_.corps_info)) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.activity_cfgid;
/* 59 */     _h_ += this.time_point_cfgid;
/* 60 */     _h_ += this.corps_info.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.activity_cfgid).append(",");
/* 68 */     _sb_.append(this.time_point_cfgid).append(",");
/* 69 */     _sb_.append(this.corps_info).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(UpdatePointRaceCorpsReq _o_) {
/* 75 */     if (_o_ == this) return 0;
/* 76 */     int _c_ = 0;
/* 77 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.time_point_cfgid - _o_.time_point_cfgid;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     _c_ = this.corps_info.compareTo(_o_.corps_info);
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\UpdatePointRaceCorpsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */