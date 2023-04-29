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
/*    */ public class SUndressFashionSuccess
/*    */   extends __SUndressFashionSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609357;
/*    */   public long childid;
/*    */   public int fashion_cfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609357;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUndressFashionSuccess() {}
/*    */   
/*    */ 
/*    */   public SUndressFashionSuccess(long _childid_, int _fashion_cfgid_)
/*    */   {
/* 37 */     this.childid = _childid_;
/* 38 */     this.fashion_cfgid = _fashion_cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.childid);
/* 47 */     _os_.marshal(this.fashion_cfgid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.childid = _os_.unmarshal_long();
/* 53 */     this.fashion_cfgid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SUndressFashionSuccess)) {
/* 63 */       SUndressFashionSuccess _o_ = (SUndressFashionSuccess)_o1_;
/* 64 */       if (this.childid != _o_.childid) return false;
/* 65 */       if (this.fashion_cfgid != _o_.fashion_cfgid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.childid;
/* 74 */     _h_ += this.fashion_cfgid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.childid).append(",");
/* 82 */     _sb_.append(this.fashion_cfgid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUndressFashionSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.fashion_cfgid - _o_.fashion_cfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SUndressFashionSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */