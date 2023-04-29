/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPetMarkUpgradeWithMarkFail
/*    */   extends __SPetMarkUpgradeWithMarkFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628510;
/*    */   public static final int ROLE_LEVEL_NOT_ENOUGH = -1;
/*    */   public static final int MAIN_PET_MARK_NOT_EXIST = -2;
/*    */   public static final int MAIN_PET_MARK_LEVEL_MAX = -3;
/*    */   public static final int COST_PET_MARK_NOT_EXIST = -4;
/*    */   public static final int COST_PET_MARK_QUALITY_DIFFRENT = -5;
/*    */   public static final int COST_PET_MARK_ALREADY_EQUIPED = -6;
/*    */   public static final int NEXT_LEVEL_NEED_HIGHER_ROLE_LEVEL = -7;
/*    */   public static final int MAIN_AND_COST_PET_MARK_IS_THE_SAME = -8;
/*    */   public int error_code;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628510;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetMarkUpgradeWithMarkFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetMarkUpgradeWithMarkFail(int _error_code_)
/*    */   {
/* 45 */     this.error_code = _error_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.error_code);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.error_code = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SPetMarkUpgradeWithMarkFail)) {
/* 68 */       SPetMarkUpgradeWithMarkFail _o_ = (SPetMarkUpgradeWithMarkFail)_o1_;
/* 69 */       if (this.error_code != _o_.error_code) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.error_code;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.error_code).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetMarkUpgradeWithMarkFail _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.error_code - _o_.error_code;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkUpgradeWithMarkFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */