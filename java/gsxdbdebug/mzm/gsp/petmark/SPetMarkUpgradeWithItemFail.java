/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPetMarkUpgradeWithItemFail
/*    */   extends __SPetMarkUpgradeWithItemFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628495;
/*    */   public static final int ROLE_LEVEL_NOT_ENOUGH = -1;
/*    */   public static final int MAIN_PET_MARK_NOT_EXIST = -2;
/*    */   public static final int MAIN_PET_MARK_LEVEL_MAX = -3;
/*    */   public static final int COST_ITEM_NOT_EXIST = -4;
/*    */   public static final int COST_ITEM_TYPE_WRONG = -5;
/*    */   public static final int COST_ITEM_QUALITY_DIFFRENT = -6;
/*    */   public static final int NEXT_LEVEL_NEED_HIGHER_ROLE_LEVEL = -7;
/*    */   public int error_code;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628495;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetMarkUpgradeWithItemFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetMarkUpgradeWithItemFail(int _error_code_)
/*    */   {
/* 44 */     this.error_code = _error_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.error_code);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.error_code = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SPetMarkUpgradeWithItemFail)) {
/* 67 */       SPetMarkUpgradeWithItemFail _o_ = (SPetMarkUpgradeWithItemFail)_o1_;
/* 68 */       if (this.error_code != _o_.error_code) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.error_code;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.error_code).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetMarkUpgradeWithItemFail _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.error_code - _o_.error_code;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkUpgradeWithItemFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */