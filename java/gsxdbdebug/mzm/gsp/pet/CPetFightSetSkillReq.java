/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PPetFightSetSkill;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPetFightSetSkillReq
/*    */   extends __CPetFightSetSkillReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590700;
/*    */   public long pet_id;
/*    */   public int skill_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PPetFightSetSkill(roleId, this.pet_id, this.skill_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12590700;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPetFightSetSkillReq() {}
/*    */   
/*    */ 
/*    */   public CPetFightSetSkillReq(long _pet_id_, int _skill_id_)
/*    */   {
/* 38 */     this.pet_id = _pet_id_;
/* 39 */     this.skill_id = _skill_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.pet_id);
/* 48 */     _os_.marshal(this.skill_id);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.pet_id = _os_.unmarshal_long();
/* 54 */     this.skill_id = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CPetFightSetSkillReq)) {
/* 64 */       CPetFightSetSkillReq _o_ = (CPetFightSetSkillReq)_o1_;
/* 65 */       if (this.pet_id != _o_.pet_id) return false;
/* 66 */       if (this.skill_id != _o_.skill_id) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.pet_id;
/* 75 */     _h_ += this.skill_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.pet_id).append(",");
/* 83 */     _sb_.append(this.skill_id).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPetFightSetSkillReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.skill_id - _o_.skill_id;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetFightSetSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */