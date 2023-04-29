/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class PointRaceEndReq
/*    */   implements Marshal, Comparable<PointRaceEndReq>
/*    */ {
/*    */   public int activity_cfgid;
/*    */   public int zone;
/*    */   public int time_point_cfgid;
/*    */   
/*    */   public PointRaceEndReq() {}
/*    */   
/*    */   public PointRaceEndReq(int _activity_cfgid_, int _zone_, int _time_point_cfgid_)
/*    */   {
/* 19 */     this.activity_cfgid = _activity_cfgid_;
/* 20 */     this.zone = _zone_;
/* 21 */     this.time_point_cfgid = _time_point_cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.activity_cfgid);
/* 30 */     _os_.marshal(this.zone);
/* 31 */     _os_.marshal(this.time_point_cfgid);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.activity_cfgid = _os_.unmarshal_int();
/* 37 */     this.zone = _os_.unmarshal_int();
/* 38 */     this.time_point_cfgid = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof PointRaceEndReq)) {
/* 45 */       PointRaceEndReq _o_ = (PointRaceEndReq)_o1_;
/* 46 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 47 */       if (this.zone != _o_.zone) return false;
/* 48 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.activity_cfgid;
/* 57 */     _h_ += this.zone;
/* 58 */     _h_ += this.time_point_cfgid;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.activity_cfgid).append(",");
/* 66 */     _sb_.append(this.zone).append(",");
/* 67 */     _sb_.append(this.time_point_cfgid).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PointRaceEndReq _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.zone - _o_.zone;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.time_point_cfgid - _o_.time_point_cfgid;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceEndReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */