/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.market.auction.PGetAuctionPetReq;
/*    */ 
/*    */ 
/*    */ public class CGetAuctionPetReq
/*    */   extends __CGetAuctionPetReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601434;
/*    */   public long marketid;
/*    */   public int petcfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     if (roleId < 0L) {
/* 20 */       return;
/*    */     }
/* 22 */     Role.addRoleProcedure(roleId, new PGetAuctionPetReq(roleId, this.marketid, this.petcfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12601434;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetAuctionPetReq() {}
/*    */   
/*    */ 
/*    */   public CGetAuctionPetReq(long _marketid_, int _petcfgid_)
/*    */   {
/* 40 */     this.marketid = _marketid_;
/* 41 */     this.petcfgid = _petcfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.marketid);
/* 50 */     _os_.marshal(this.petcfgid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.marketid = _os_.unmarshal_long();
/* 56 */     this.petcfgid = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CGetAuctionPetReq)) {
/* 66 */       CGetAuctionPetReq _o_ = (CGetAuctionPetReq)_o1_;
/* 67 */       if (this.marketid != _o_.marketid) return false;
/* 68 */       if (this.petcfgid != _o_.petcfgid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.marketid;
/* 77 */     _h_ += this.petcfgid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.marketid).append(",");
/* 85 */     _sb_.append(this.petcfgid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetAuctionPetReq _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CGetAuctionPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */