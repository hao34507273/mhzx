/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFabaoAddExpRes
/*    */   extends __SFabaoAddExpRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12595972;
/*    */   public static final int ERROR_UNKNOWN = 0;
/*    */   public static final int ERROR_CFG_NON_EXSIT = 2;
/*    */   public static final int ERROR_FABAO_TYPE = 3;
/*    */   public static final int ERROR_EXP_ITEM_TYPE = 4;
/*    */   public static final int ERROR_EXP_MAX_LV_FA_BAO = 5;
/*    */   public static final int ERROR_EXP_MAX_LV_ROLE = 6;
/*    */   public static final int ERROR_EXP_ITEM_NON_EXIST = 7;
/*    */   public static final int ERROR_EXP_ITEM_COUNT_NOT_ENOUGH = 8;
/*    */   public static final int ERROR_IN_CROSS = 9;
/*    */   public int resultcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12595972;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFabaoAddExpRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFabaoAddExpRes(int _resultcode_)
/*    */   {
/* 46 */     this.resultcode = _resultcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.resultcode);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.resultcode = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SFabaoAddExpRes)) {
/* 69 */       SFabaoAddExpRes _o_ = (SFabaoAddExpRes)_o1_;
/* 70 */       if (this.resultcode != _o_.resultcode) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.resultcode;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.resultcode).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFabaoAddExpRes _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.resultcode - _o_.resultcode;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SFabaoAddExpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */