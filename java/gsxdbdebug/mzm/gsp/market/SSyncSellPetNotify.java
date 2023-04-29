/*    */ package mzm.gsp.market;
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
/*    */ public class SSyncSellPetNotify
/*    */   extends __SSyncSellPetNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601372;
/*    */   public long marketid;
/*    */   public int petcfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601372;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncSellPetNotify() {}
/*    */   
/*    */ 
/*    */   public SSyncSellPetNotify(long _marketid_, int _petcfgid_)
/*    */   {
/* 37 */     this.marketid = _marketid_;
/* 38 */     this.petcfgid = _petcfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.marketid);
/* 47 */     _os_.marshal(this.petcfgid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.marketid = _os_.unmarshal_long();
/* 53 */     this.petcfgid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncSellPetNotify)) {
/* 63 */       SSyncSellPetNotify _o_ = (SSyncSellPetNotify)_o1_;
/* 64 */       if (this.marketid != _o_.marketid) return false;
/* 65 */       if (this.petcfgid != _o_.petcfgid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.marketid;
/* 74 */     _h_ += this.petcfgid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.marketid).append(",");
/* 82 */     _sb_.append(this.petcfgid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncSellPetNotify _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SSyncSellPetNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */