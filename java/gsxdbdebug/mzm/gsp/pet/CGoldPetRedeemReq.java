/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PGodPetRedeemReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGoldPetRedeemReq
/*    */   extends __CGoldPetRedeemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590648;
/*    */   public static final int REDEEM_NPC_SERVICE_ID = 150205300;
/*    */   public int petcfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) return;
/* 21 */     Role.addRoleProcedure(roleId, new PGodPetRedeemReq(roleId, this.petcfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12590648;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGoldPetRedeemReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public CGoldPetRedeemReq(int _petcfgid_)
/*    */   {
/* 40 */     this.petcfgid = _petcfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.petcfgid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.petcfgid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CGoldPetRedeemReq)) {
/* 63 */       CGoldPetRedeemReq _o_ = (CGoldPetRedeemReq)_o1_;
/* 64 */       if (this.petcfgid != _o_.petcfgid) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.petcfgid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.petcfgid).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGoldPetRedeemReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CGoldPetRedeemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */