/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SLongjingComposeErrorRes
/*    */   extends __SLongjingComposeErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596027;
/*    */   public static final int ERROR_UNKNOWN = 0;
/*    */   public static final int ERROR_NOT_HAS_COMPOSE_ITEM = 1;
/*    */   public static final int ERROR_NON_EXSIT = 2;
/*    */   public static final int ERROR_ITEM_TYPE = 3;
/*    */   public static final int ERROR_CANNOT_COMPOSE = 4;
/*    */   public static final int ERROR_BAG_FULL = 5;
/*    */   public static final int ERROR_ROLE_LEVEL_NOT_ENOUGH = 6;
/*    */   public static final int ERROR_IN_CROSS = 7;
/*    */   public int resultcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596027;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SLongjingComposeErrorRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SLongjingComposeErrorRes(int _resultcode_)
/*    */   {
/* 45 */     this.resultcode = _resultcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.resultcode);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.resultcode = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SLongjingComposeErrorRes)) {
/* 68 */       SLongjingComposeErrorRes _o_ = (SLongjingComposeErrorRes)_o1_;
/* 69 */       if (this.resultcode != _o_.resultcode) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.resultcode;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.resultcode).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SLongjingComposeErrorRes _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.resultcode - _o_.resultcode;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SLongjingComposeErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */