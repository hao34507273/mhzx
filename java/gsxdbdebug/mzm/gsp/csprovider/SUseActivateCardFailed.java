/*    */ package mzm.gsp.csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SUseActivateCardFailed
/*    */   extends __SUseActivateCardFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589315;
/*    */   public static final int ERROR_NOT_REQUIRE = 0;
/*    */   public static final int ERROR_CARD_NOT_ACTIVATE = 1;
/*    */   public static final int ERROR_CARD_NOT_IN_EFFECT_TIME = 2;
/*    */   public static final int ERROR_CARD_EXPIRED = 3;
/*    */   public static final int ERROR_CARD_IS_ALREADY_USED_IN_THIS_SERVER = 4;
/*    */   public static final int ERROR_CARD_IS_INVALID = 5;
/*    */   public static final int ERROR_CARD_IS_ALREADY_USED_IN_OHTER_SERVER = 6;
/*    */   public static final int ERROR_CARD_IS_ALREADY_USED_BY_OHTERS = 7;
/*    */   public static final int ERROR_CARD_NOT_EXIST = 8;
/*    */   public static final int ERROR_UNKOWN = 9;
/*    */   public static final int ERROR_NETWORK = 10;
/*    */   public int reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589315;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseActivateCardFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseActivateCardFailed(int _reason_)
/*    */   {
/* 48 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.reason);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.reason = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SUseActivateCardFailed)) {
/* 71 */       SUseActivateCardFailed _o_ = (SUseActivateCardFailed)_o1_;
/* 72 */       if (this.reason != _o_.reason) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.reason;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.reason).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseActivateCardFailed _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.reason - _o_.reason;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\SUseActivateCardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */