/*    */ package mzm.gsp.grc;
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
/*    */ public class SGrcGetSelfPlatVipInfoResp
/*    */   extends __SGrcGetSelfPlatVipInfoResp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600323;
/*    */   public int retcode;
/*    */   public int plat_vip_kind;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600323;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGrcGetSelfPlatVipInfoResp() {}
/*    */   
/*    */ 
/*    */   public SGrcGetSelfPlatVipInfoResp(int _retcode_, int _plat_vip_kind_)
/*    */   {
/* 37 */     this.retcode = _retcode_;
/* 38 */     this.plat_vip_kind = _plat_vip_kind_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.retcode);
/* 47 */     _os_.marshal(this.plat_vip_kind);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.retcode = _os_.unmarshal_int();
/* 53 */     this.plat_vip_kind = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SGrcGetSelfPlatVipInfoResp)) {
/* 63 */       SGrcGetSelfPlatVipInfoResp _o_ = (SGrcGetSelfPlatVipInfoResp)_o1_;
/* 64 */       if (this.retcode != _o_.retcode) return false;
/* 65 */       if (this.plat_vip_kind != _o_.plat_vip_kind) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.retcode;
/* 74 */     _h_ += this.plat_vip_kind;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.retcode).append(",");
/* 82 */     _sb_.append(this.plat_vip_kind).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGrcGetSelfPlatVipInfoResp _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.retcode - _o_.retcode;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.plat_vip_kind - _o_.plat_vip_kind;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGrcGetSelfPlatVipInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */