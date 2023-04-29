/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPointRaceLeaveFail
/*    */   extends __SPointRaceLeaveFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617019;
/*    */   public static final int ERROR_IN_FIGHT = -1;
/*    */   public static final int ERROR_TEAM = -2;
/*    */   public static final int ERROR_NOT_TEAM_LEADER = -3;
/*    */   public static final int ERROR_TEAM_MEMBER = -4;
/*    */   public static final int ERROR_CORPS_MEMBER = -5;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617019;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPointRaceLeaveFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPointRaceLeaveFail(int _retcode_)
/*    */   {
/* 42 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.retcode);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.retcode = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SPointRaceLeaveFail)) {
/* 65 */       SPointRaceLeaveFail _o_ = (SPointRaceLeaveFail)_o1_;
/* 66 */       if (this.retcode != _o_.retcode) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.retcode;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.retcode).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPointRaceLeaveFail _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.retcode - _o_.retcode;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SPointRaceLeaveFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */