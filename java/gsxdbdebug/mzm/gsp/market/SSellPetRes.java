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
/*    */ public class SSellPetRes
/*    */   extends __SSellPetRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601374;
/*    */   public long oldmarketid;
/*    */   public MarketPet marketpet;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601374;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSellPetRes()
/*    */   {
/* 32 */     this.marketpet = new MarketPet();
/*    */   }
/*    */   
/*    */   public SSellPetRes(long _oldmarketid_, MarketPet _marketpet_) {
/* 36 */     this.oldmarketid = _oldmarketid_;
/* 37 */     this.marketpet = _marketpet_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.marketpet._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.oldmarketid);
/* 47 */     _os_.marshal(this.marketpet);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.oldmarketid = _os_.unmarshal_long();
/* 53 */     this.marketpet.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSellPetRes)) {
/* 63 */       SSellPetRes _o_ = (SSellPetRes)_o1_;
/* 64 */       if (this.oldmarketid != _o_.oldmarketid) return false;
/* 65 */       if (!this.marketpet.equals(_o_.marketpet)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.oldmarketid;
/* 74 */     _h_ += this.marketpet.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.oldmarketid).append(",");
/* 82 */     _sb_.append(this.marketpet).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSellPetRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.oldmarketid - _o_.oldmarketid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.marketpet.compareTo(_o_.marketpet);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SSellPetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */