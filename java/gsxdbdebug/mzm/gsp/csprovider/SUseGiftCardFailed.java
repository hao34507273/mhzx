/*    */ package mzm.gsp.csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SUseGiftCardFailed
/*    */   extends __SUseGiftCardFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589316;
/*    */   public static final int ERROR_CARD_NOT_ACTIVATE = 1;
/*    */   public static final int ERROR_CARD_NOT_IN_EFFECT_TIME = 2;
/*    */   public static final int ERROR_CARD_EXPIRED = 3;
/*    */   public static final int ERROR_CARD_IS_INVALID = 4;
/*    */   public static final int ERROR_CARD_IS_ALREADY_USED_IN_THIS_SERVER = 5;
/*    */   public static final int ERROR_CARD_IS_ALREADY_USED_BY_OHTERS = 6;
/*    */   public static final int ERROR_CARD_NOT_EXIST = 7;
/*    */   public static final int ERROR_UNKOWN = 8;
/*    */   public static final int ERROR_NETWORK = 9;
/*    */   public static final int BAG_FULL = 10;
/*    */   public int reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589316;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseGiftCardFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseGiftCardFailed(int _reason_)
/*    */   {
/* 47 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 55 */     _os_.marshal(this.reason);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.reason = _os_.unmarshal_int();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SUseGiftCardFailed)) {
/* 70 */       SUseGiftCardFailed _o_ = (SUseGiftCardFailed)_o1_;
/* 71 */       if (this.reason != _o_.reason) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.reason;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.reason).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseGiftCardFailed _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.reason - _o_.reason;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\SUseGiftCardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */