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
/*    */ public class SGetAuctionPetRes
/*    */   extends __SGetAuctionPetRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601433;
/*    */   public long marketid;
/*    */   public int petcfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601433;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetAuctionPetRes() {}
/*    */   
/*    */ 
/*    */   public SGetAuctionPetRes(long _marketid_, int _petcfgid_)
/*    */   {
/* 35 */     this.marketid = _marketid_;
/* 36 */     this.petcfgid = _petcfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.marketid);
/* 45 */     _os_.marshal(this.petcfgid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.marketid = _os_.unmarshal_long();
/* 51 */     this.petcfgid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SGetAuctionPetRes)) {
/* 61 */       SGetAuctionPetRes _o_ = (SGetAuctionPetRes)_o1_;
/* 62 */       if (this.marketid != _o_.marketid) return false;
/* 63 */       if (this.petcfgid != _o_.petcfgid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.marketid;
/* 72 */     _h_ += this.petcfgid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.marketid).append(",");
/* 80 */     _sb_.append(this.petcfgid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetAuctionPetRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SGetAuctionPetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */