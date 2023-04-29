/*    */ package mzm.gsp.roledye;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SRoleDyeResult
/*    */   extends __SRoleDyeResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597256;
/*    */   public static final int ERROR_UNKNOWN = 0;
/*    */   public static final int ERROR_DEL_CLOTH_ID = 1;
/*    */   public static final int ERROR_DEL_DEFAULT_ID = 2;
/*    */   public static final int ERROR_DEL_CUR_ID = 3;
/*    */   public static final int ERROR_USE_CLOTH_ID = 4;
/*    */   public static final int ERROR_ADD_OVER_MAX = 5;
/*    */   public static final int ERROR_ADD_COLOR_ID = 6;
/*    */   public static final int ERROR_ADD_NO_ENOUTH = 7;
/*    */   public static final int ERROR_ADD_OVERLAP = 8;
/*    */   public static final int ERROR_YUANBAO_NOT_ENOUGH = 9;
/*    */   public int resultcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12597256;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRoleDyeResult() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRoleDyeResult(int _resultcode_)
/*    */   {
/* 47 */     this.resultcode = _resultcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 55 */     _os_.marshal(this.resultcode);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.resultcode = _os_.unmarshal_int();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SRoleDyeResult)) {
/* 70 */       SRoleDyeResult _o_ = (SRoleDyeResult)_o1_;
/* 71 */       if (this.resultcode != _o_.resultcode) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.resultcode;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.resultcode).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRoleDyeResult _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.resultcode - _o_.resultcode;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\SRoleDyeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */