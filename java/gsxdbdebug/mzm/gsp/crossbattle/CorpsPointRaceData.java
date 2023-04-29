/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CorpsPointRaceData implements Marshal, Comparable<CorpsPointRaceData>
/*    */ {
/*    */   public int win;
/*    */   public int lose;
/*    */   public int point;
/*    */   public long update_time;
/*    */   
/*    */   public CorpsPointRaceData() {}
/*    */   
/*    */   public CorpsPointRaceData(int _win_, int _lose_, int _point_, long _update_time_)
/*    */   {
/* 18 */     this.win = _win_;
/* 19 */     this.lose = _lose_;
/* 20 */     this.point = _point_;
/* 21 */     this.update_time = _update_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.win);
/* 30 */     _os_.marshal(this.lose);
/* 31 */     _os_.marshal(this.point);
/* 32 */     _os_.marshal(this.update_time);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.win = _os_.unmarshal_int();
/* 38 */     this.lose = _os_.unmarshal_int();
/* 39 */     this.point = _os_.unmarshal_int();
/* 40 */     this.update_time = _os_.unmarshal_long();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof CorpsPointRaceData)) {
/* 47 */       CorpsPointRaceData _o_ = (CorpsPointRaceData)_o1_;
/* 48 */       if (this.win != _o_.win) return false;
/* 49 */       if (this.lose != _o_.lose) return false;
/* 50 */       if (this.point != _o_.point) return false;
/* 51 */       if (this.update_time != _o_.update_time) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.win;
/* 60 */     _h_ += this.lose;
/* 61 */     _h_ += this.point;
/* 62 */     _h_ += (int)this.update_time;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.win).append(",");
/* 70 */     _sb_.append(this.lose).append(",");
/* 71 */     _sb_.append(this.point).append(",");
/* 72 */     _sb_.append(this.update_time).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CorpsPointRaceData _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.win - _o_.win;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.lose - _o_.lose;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.point - _o_.point;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = Long.signum(this.update_time - _o_.update_time);
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CorpsPointRaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */