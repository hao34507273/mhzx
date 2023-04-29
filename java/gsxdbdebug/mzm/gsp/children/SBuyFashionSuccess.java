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
/*    */ 
/*    */ public class SBuyFashionSuccess
/*    */   extends __SBuyFashionSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609355;
/*    */   public int fashion_cfgid;
/*    */   public FashionInfo fashion_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609355;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBuyFashionSuccess()
/*    */   {
/* 34 */     this.fashion_info = new FashionInfo();
/*    */   }
/*    */   
/*    */   public SBuyFashionSuccess(int _fashion_cfgid_, FashionInfo _fashion_info_) {
/* 38 */     this.fashion_cfgid = _fashion_cfgid_;
/* 39 */     this.fashion_info = _fashion_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.fashion_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.fashion_cfgid);
/* 49 */     _os_.marshal(this.fashion_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.fashion_cfgid = _os_.unmarshal_int();
/* 55 */     this.fashion_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SBuyFashionSuccess)) {
/* 65 */       SBuyFashionSuccess _o_ = (SBuyFashionSuccess)_o1_;
/* 66 */       if (this.fashion_cfgid != _o_.fashion_cfgid) return false;
/* 67 */       if (!this.fashion_info.equals(_o_.fashion_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.fashion_cfgid;
/* 76 */     _h_ += this.fashion_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.fashion_cfgid).append(",");
/* 84 */     _sb_.append(this.fashion_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyFashionSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.fashion_cfgid - _o_.fashion_cfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.fashion_info.compareTo(_o_.fashion_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SBuyFashionSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */