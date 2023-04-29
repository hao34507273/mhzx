/*    */ package mzm.gsp;
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
/*    */ 
/*    */ 
/*    */ public class SNormalResult
/*    */   extends __SNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590097;
/*    */   public static final int DELETE_ERR_BANGZHU = 0;
/*    */   public static final int DELETE_ERR_LEVEL_LIMIT = 1;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590097;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNormalResult() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SNormalResult(int _res_)
/*    */   {
/* 39 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.res);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.res = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SNormalResult)) {
/* 62 */       SNormalResult _o_ = (SNormalResult)_o1_;
/* 63 */       if (this.res != _o_.res) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.res;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.res).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNormalResult _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.res - _o_.res;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\SNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */