/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ 
/*    */ public class CUnRemeberSkillReq extends __CUnRemeberSkillReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590611;
/*    */   public long petid;
/*    */   public int skillid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 15 */     long roleId = Role.getRoleId(this);
/* 16 */     if (roleId >= 0L) {
/* 17 */       Role.addRoleProcedure(roleId, new mzm.gsp.pet.main.PUnRemeberSkillReq(roleId, this.petid, this.skillid));
/*    */     }
/*    */   }
/*    */   
/*    */   public int getType() {
/* 22 */     return 12590611;
/*    */   }
/*    */   
/*    */   public CUnRemeberSkillReq() {}
/*    */   
/*    */   public CUnRemeberSkillReq(long _petid_, int _skillid_)
/*    */   {
/* 29 */     this.petid = _petid_;
/* 30 */     this.skillid = _skillid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.petid);
/* 39 */     _os_.marshal(this.skillid);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.petid = _os_.unmarshal_long();
/* 45 */     this.skillid = _os_.unmarshal_int();
/* 46 */     if (_validator_()) {
/* 47 */       return _os_;
/*    */     }
/* 49 */     throw new VerifyError("validator failed");
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) {
/* 54 */       return true;
/*    */     }
/* 56 */     if (!(_o1_ instanceof CUnRemeberSkillReq)) {
/* 57 */       return false;
/*    */     }
/* 59 */     CUnRemeberSkillReq _o_ = (CUnRemeberSkillReq)_o1_;
/* 60 */     return (this.petid == _o_.petid) && (this.skillid == _o_.skillid);
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0 + (int)this.petid;
/* 65 */     return _h_ + this.skillid;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.petid).append(",");
/* 72 */     _sb_.append(this.skillid).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUnRemeberSkillReq _o_) {
/* 78 */     if (_o_ == this) {
/* 79 */       return 0;
/*    */     }
/* 81 */     int _c_ = Long.signum(this.petid - _o_.petid);
/* 82 */     if (0 != _c_) {
/* 83 */       return _c_;
/*    */     }
/* 85 */     int _c_2 = this.skillid - _o_.skillid;
/* 86 */     return 0 != _c_2 ? _c_2 : _c_2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CUnRemeberSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */