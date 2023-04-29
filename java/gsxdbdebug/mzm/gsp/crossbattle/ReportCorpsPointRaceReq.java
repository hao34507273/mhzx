/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ReportCorpsPointRaceReq
/*    */   implements Marshal, Comparable<ReportCorpsPointRaceReq>
/*    */ {
/*    */   public int activity_cfgid;
/*    */   public long corpsid;
/*    */   public int time_point_cfgid;
/*    */   public CorpsPointRaceData data;
/*    */   
/*    */   public ReportCorpsPointRaceReq()
/*    */   {
/* 17 */     this.data = new CorpsPointRaceData();
/*    */   }
/*    */   
/*    */   public ReportCorpsPointRaceReq(int _activity_cfgid_, long _corpsid_, int _time_point_cfgid_, CorpsPointRaceData _data_) {
/* 21 */     this.activity_cfgid = _activity_cfgid_;
/* 22 */     this.corpsid = _corpsid_;
/* 23 */     this.time_point_cfgid = _time_point_cfgid_;
/* 24 */     this.data = _data_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     if (!this.data._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.activity_cfgid);
/* 34 */     _os_.marshal(this.corpsid);
/* 35 */     _os_.marshal(this.time_point_cfgid);
/* 36 */     _os_.marshal(this.data);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.activity_cfgid = _os_.unmarshal_int();
/* 42 */     this.corpsid = _os_.unmarshal_long();
/* 43 */     this.time_point_cfgid = _os_.unmarshal_int();
/* 44 */     this.data.unmarshal(_os_);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof ReportCorpsPointRaceReq)) {
/* 51 */       ReportCorpsPointRaceReq _o_ = (ReportCorpsPointRaceReq)_o1_;
/* 52 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 53 */       if (this.corpsid != _o_.corpsid) return false;
/* 54 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 55 */       if (!this.data.equals(_o_.data)) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.activity_cfgid;
/* 64 */     _h_ += (int)this.corpsid;
/* 65 */     _h_ += this.time_point_cfgid;
/* 66 */     _h_ += this.data.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.activity_cfgid).append(",");
/* 74 */     _sb_.append(this.corpsid).append(",");
/* 75 */     _sb_.append(this.time_point_cfgid).append(",");
/* 76 */     _sb_.append(this.data).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ReportCorpsPointRaceReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = Long.signum(this.corpsid - _o_.corpsid);
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.time_point_cfgid - _o_.time_point_cfgid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.data.compareTo(_o_.data);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\ReportCorpsPointRaceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */