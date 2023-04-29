/*    */ package mzm.gsp.firework;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class FireWorkStageInfo
/*    */   implements Marshal, Comparable<FireWorkStageInfo>
/*    */ {
/*    */   public static final int STAGE_FIND = 1;
/*    */   public static final int STAGE_COUNT_DOWN = 2;
/*    */   public static final int STAGE_SHOW = 3;
/*    */   public int stage;
/*    */   public long stagestarttime;
/*    */   
/*    */   public FireWorkStageInfo() {}
/*    */   
/*    */   public FireWorkStageInfo(int _stage_, long _stagestarttime_)
/*    */   {
/* 20 */     this.stage = _stage_;
/* 21 */     this.stagestarttime = _stagestarttime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.stage);
/* 30 */     _os_.marshal(this.stagestarttime);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.stage = _os_.unmarshal_int();
/* 36 */     this.stagestarttime = _os_.unmarshal_long();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof FireWorkStageInfo)) {
/* 43 */       FireWorkStageInfo _o_ = (FireWorkStageInfo)_o1_;
/* 44 */       if (this.stage != _o_.stage) return false;
/* 45 */       if (this.stagestarttime != _o_.stagestarttime) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.stage;
/* 54 */     _h_ += (int)this.stagestarttime;
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.stage).append(",");
/* 62 */     _sb_.append(this.stagestarttime).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FireWorkStageInfo _o_) {
/* 68 */     if (_o_ == this) return 0;
/* 69 */     int _c_ = 0;
/* 70 */     _c_ = this.stage - _o_.stage;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     _c_ = Long.signum(this.stagestarttime - _o_.stagestarttime);
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\FireWorkStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */