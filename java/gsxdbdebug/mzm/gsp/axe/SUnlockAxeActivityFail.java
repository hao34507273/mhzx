/*    */ package mzm.gsp.axe;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SUnlockAxeActivityFail
/*    */   extends __SUnlockAxeActivityFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614917;
/*    */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*    */   public static final int ROLE_STATUS_ERROR = -2;
/*    */   public static final int PARAM_ERROR = -3;
/*    */   public static final int YUAN_BAO_NUM_ERROR = -4;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = 1;
/*    */   public static final int ACTIVITY_IS_NOT_LOCKED = 2;
/*    */   public static final int YUANBAO_NOT_ENOUGH = 3;
/*    */   public static final int GOLD_NOT_ENOUGH = 4;
/*    */   public static final int SILVER_NOT_ENOUGH = 5;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12614917;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUnlockAxeActivityFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUnlockAxeActivityFail(int _res_)
/*    */   {
/* 46 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.res);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.res = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SUnlockAxeActivityFail)) {
/* 69 */       SUnlockAxeActivityFail _o_ = (SUnlockAxeActivityFail)_o1_;
/* 70 */       if (this.res != _o_.res) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.res;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.res).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUnlockAxeActivityFail _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.res - _o_.res;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\SUnlockAxeActivityFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */