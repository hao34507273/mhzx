/*    */ package mzm.gsp.backgameactivity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBuyBackGameGiftFail
/*    */   extends __SBuyBackGameGiftFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620559;
/*    */   public static final int NOT_IN_BACK_GAME_ACTIVITY = -1;
/*    */   public static final int BACK_GAME_GIFT_NOT_EXIST = -2;
/*    */   public static final int BUY_COUNT_NOT_ENOUGH = -3;
/*    */   public static final int CURRENCY_NOT_ENOUGH = -4;
/*    */   public static final int RECHARGE_NOT_ENOUGH = -5;
/*    */   public static final int OFFER_ITEM_FAIL = -6;
/*    */   public int error_code;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620559;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBuyBackGameGiftFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBuyBackGameGiftFail(int _error_code_)
/*    */   {
/* 43 */     this.error_code = _error_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.error_code);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.error_code = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SBuyBackGameGiftFail)) {
/* 66 */       SBuyBackGameGiftFail _o_ = (SBuyBackGameGiftFail)_o1_;
/* 67 */       if (this.error_code != _o_.error_code) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.error_code;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.error_code).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyBackGameGiftFail _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.error_code - _o_.error_code;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\SBuyBackGameGiftFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */