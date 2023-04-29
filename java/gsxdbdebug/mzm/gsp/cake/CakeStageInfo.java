/*    */ package mzm.gsp.cake;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class CakeStageInfo
/*    */   implements Marshal, Comparable<CakeStageInfo>
/*    */ {
/*    */   public int turn;
/*    */   public int stage;
/*    */   public long stagestarttime;
/*    */   
/*    */   public CakeStageInfo() {}
/*    */   
/*    */   public CakeStageInfo(int _turn_, int _stage_, long _stagestarttime_)
/*    */   {
/* 19 */     this.turn = _turn_;
/* 20 */     this.stage = _stage_;
/* 21 */     this.stagestarttime = _stagestarttime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.turn);
/* 30 */     _os_.marshal(this.stage);
/* 31 */     _os_.marshal(this.stagestarttime);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.turn = _os_.unmarshal_int();
/* 37 */     this.stage = _os_.unmarshal_int();
/* 38 */     this.stagestarttime = _os_.unmarshal_long();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof CakeStageInfo)) {
/* 45 */       CakeStageInfo _o_ = (CakeStageInfo)_o1_;
/* 46 */       if (this.turn != _o_.turn) return false;
/* 47 */       if (this.stage != _o_.stage) return false;
/* 48 */       if (this.stagestarttime != _o_.stagestarttime) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.turn;
/* 57 */     _h_ += this.stage;
/* 58 */     _h_ += (int)this.stagestarttime;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.turn).append(",");
/* 66 */     _sb_.append(this.stage).append(",");
/* 67 */     _sb_.append(this.stagestarttime).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CakeStageInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.turn - _o_.turn;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.stage - _o_.stage;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = Long.signum(this.stagestarttime - _o_.stagestarttime);
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\CakeStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */