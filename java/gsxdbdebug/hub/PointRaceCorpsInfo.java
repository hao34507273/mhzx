/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class PointRaceCorpsInfo
/*    */   implements Marshal, Comparable<PointRaceCorpsInfo>
/*    */ {
/*    */   public long corpsid;
/*    */   public int win;
/*    */   public int lose;
/*    */   public int point;
/*    */   public long update_time;
/*    */   
/*    */   public PointRaceCorpsInfo() {}
/*    */   
/*    */   public PointRaceCorpsInfo(long _corpsid_, int _win_, int _lose_, int _point_, long _update_time_)
/*    */   {
/* 21 */     this.corpsid = _corpsid_;
/* 22 */     this.win = _win_;
/* 23 */     this.lose = _lose_;
/* 24 */     this.point = _point_;
/* 25 */     this.update_time = _update_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.corpsid);
/* 34 */     _os_.marshal(this.win);
/* 35 */     _os_.marshal(this.lose);
/* 36 */     _os_.marshal(this.point);
/* 37 */     _os_.marshal(this.update_time);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.corpsid = _os_.unmarshal_long();
/* 43 */     this.win = _os_.unmarshal_int();
/* 44 */     this.lose = _os_.unmarshal_int();
/* 45 */     this.point = _os_.unmarshal_int();
/* 46 */     this.update_time = _os_.unmarshal_long();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof PointRaceCorpsInfo)) {
/* 53 */       PointRaceCorpsInfo _o_ = (PointRaceCorpsInfo)_o1_;
/* 54 */       if (this.corpsid != _o_.corpsid) return false;
/* 55 */       if (this.win != _o_.win) return false;
/* 56 */       if (this.lose != _o_.lose) return false;
/* 57 */       if (this.point != _o_.point) return false;
/* 58 */       if (this.update_time != _o_.update_time) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.corpsid;
/* 67 */     _h_ += this.win;
/* 68 */     _h_ += this.lose;
/* 69 */     _h_ += this.point;
/* 70 */     _h_ += (int)this.update_time;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.corpsid).append(",");
/* 78 */     _sb_.append(this.win).append(",");
/* 79 */     _sb_.append(this.lose).append(",");
/* 80 */     _sb_.append(this.point).append(",");
/* 81 */     _sb_.append(this.update_time).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PointRaceCorpsInfo _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = Long.signum(this.corpsid - _o_.corpsid);
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.win - _o_.win;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.lose - _o_.lose;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.point - _o_.point;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.update_time - _o_.update_time);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */