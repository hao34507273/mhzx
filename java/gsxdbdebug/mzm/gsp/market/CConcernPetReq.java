/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.market.main.PConcernPetReq;
/*    */ 
/*    */ 
/*    */ public class CConcernPetReq
/*    */   extends __CConcernPetReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601381;
/*    */   public long marketid;
/*    */   public int petcfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     if (roleId < 0L) {
/* 20 */       return;
/*    */     }
/* 22 */     Role.addRoleProcedure(roleId, new PConcernPetReq(roleId, this.marketid, this.petcfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12601381;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CConcernPetReq() {}
/*    */   
/*    */ 
/*    */   public CConcernPetReq(long _marketid_, int _petcfgid_)
/*    */   {
/* 41 */     this.marketid = _marketid_;
/* 42 */     this.petcfgid = _petcfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.marketid);
/* 51 */     _os_.marshal(this.petcfgid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.marketid = _os_.unmarshal_long();
/* 57 */     this.petcfgid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CConcernPetReq)) {
/* 67 */       CConcernPetReq _o_ = (CConcernPetReq)_o1_;
/* 68 */       if (this.marketid != _o_.marketid) return false;
/* 69 */       if (this.petcfgid != _o_.petcfgid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.marketid;
/* 78 */     _h_ += this.petcfgid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.marketid).append(",");
/* 86 */     _sb_.append(this.petcfgid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CConcernPetReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CConcernPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */