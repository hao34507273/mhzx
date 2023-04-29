/*    */ package mzm.gsp.children;
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
/*    */ public class SBuyFashionFailed
/*    */   extends __SBuyFashionFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609359;
/*    */   public static final int ERROR_ITEM_NOT_ENOUGH = -1;
/*    */   public int fashion_cfgid;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609359;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBuyFashionFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SBuyFashionFailed(int _fashion_cfgid_, int _retcode_)
/*    */   {
/* 39 */     this.fashion_cfgid = _fashion_cfgid_;
/* 40 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.fashion_cfgid);
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.fashion_cfgid = _os_.unmarshal_int();
/* 55 */     this.retcode = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SBuyFashionFailed)) {
/* 65 */       SBuyFashionFailed _o_ = (SBuyFashionFailed)_o1_;
/* 66 */       if (this.fashion_cfgid != _o_.fashion_cfgid) return false;
/* 67 */       if (this.retcode != _o_.retcode) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.fashion_cfgid;
/* 76 */     _h_ += this.retcode;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.fashion_cfgid).append(",");
/* 84 */     _sb_.append(this.retcode).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyFashionFailed _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.fashion_cfgid - _o_.fashion_cfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.retcode - _o_.retcode;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SBuyFashionFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */