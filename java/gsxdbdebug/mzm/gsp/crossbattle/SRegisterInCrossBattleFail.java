/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SRegisterInCrossBattleFail
/*    */   extends __SRegisterInCrossBattleFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616961;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*    */   public static final int ACTIVITY_NOT_OPEN = 1;
/*    */   public static final int ACTIVITY_STAGE_ERROR = 2;
/*    */   public static final int NOT_IN_CORPS = 3;
/*    */   public static final int NOT_CORPS_LEADER = 4;
/*    */   public static final int CORPS_MEMBER_NUM_DISSATISFIED = 5;
/*    */   public static final int CORPS_ALREADY_REGISTER = 6;
/*    */   public static final int MONEY_NOT_ENOUGH = 7;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616961;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRegisterInCrossBattleFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRegisterInCrossBattleFail(int _res_)
/*    */   {
/* 48 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.res);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.res = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SRegisterInCrossBattleFail)) {
/* 71 */       SRegisterInCrossBattleFail _o_ = (SRegisterInCrossBattleFail)_o1_;
/* 72 */       if (this.res != _o_.res) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.res;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.res).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRegisterInCrossBattleFail _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.res - _o_.res;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SRegisterInCrossBattleFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */