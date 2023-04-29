/*    */ package mzm.gsp.cat;
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
/*    */ 
/*    */ public class SCatRecoveryToItemFailed
/*    */   extends __SCatRecoveryToItemFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605711;
/*    */   public static final int HOMELAND_CAT_EXPLORE_STATE = -1;
/*    */   public static final int HOMELAND_CAT_RESET_STATE = -2;
/*    */   public static final int HOMELAND_CAT_AWARD_NOT_RECEIVED = -3;
/*    */   public static final int BAG_FULL = -4;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605711;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCatRecoveryToItemFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCatRecoveryToItemFailed(int _retcode_)
/*    */   {
/* 41 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.retcode = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SCatRecoveryToItemFailed)) {
/* 64 */       SCatRecoveryToItemFailed _o_ = (SCatRecoveryToItemFailed)_o1_;
/* 65 */       if (this.retcode != _o_.retcode) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.retcode;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.retcode).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCatRecoveryToItemFailed _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.retcode - _o_.retcode;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SCatRecoveryToItemFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */