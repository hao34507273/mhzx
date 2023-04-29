/*    */ package mzm.gsp.bless;
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
/*    */ public class SGetBlessInfoSuccess
/*    */   extends __SGetBlessInfoSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614658;
/*    */   public int activity_cfgid;
/*    */   public BlessInfo bless_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12614658;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetBlessInfoSuccess()
/*    */   {
/* 34 */     this.bless_info = new BlessInfo();
/*    */   }
/*    */   
/*    */   public SGetBlessInfoSuccess(int _activity_cfgid_, BlessInfo _bless_info_) {
/* 38 */     this.activity_cfgid = _activity_cfgid_;
/* 39 */     this.bless_info = _bless_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.bless_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activity_cfgid);
/* 49 */     _os_.marshal(this.bless_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.activity_cfgid = _os_.unmarshal_int();
/* 55 */     this.bless_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SGetBlessInfoSuccess)) {
/* 65 */       SGetBlessInfoSuccess _o_ = (SGetBlessInfoSuccess)_o1_;
/* 66 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 67 */       if (!this.bless_info.equals(_o_.bless_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activity_cfgid;
/* 76 */     _h_ += this.bless_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.activity_cfgid).append(",");
/* 84 */     _sb_.append(this.bless_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetBlessInfoSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.bless_info.compareTo(_o_.bless_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bless\SGetBlessInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */