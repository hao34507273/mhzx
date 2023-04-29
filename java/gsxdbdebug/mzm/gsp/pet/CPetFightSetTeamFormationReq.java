/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PPetFightSetTeamFormation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPetFightSetTeamFormationReq
/*    */   extends __CPetFightSetTeamFormationReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590690;
/*    */   public int team;
/*    */   public int formation_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PPetFightSetTeamFormation(roleId, this.team, this.formation_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12590690;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPetFightSetTeamFormationReq() {}
/*    */   
/*    */ 
/*    */   public CPetFightSetTeamFormationReq(int _team_, int _formation_id_)
/*    */   {
/* 38 */     this.team = _team_;
/* 39 */     this.formation_id = _formation_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.team);
/* 48 */     _os_.marshal(this.formation_id);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.team = _os_.unmarshal_int();
/* 54 */     this.formation_id = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CPetFightSetTeamFormationReq)) {
/* 64 */       CPetFightSetTeamFormationReq _o_ = (CPetFightSetTeamFormationReq)_o1_;
/* 65 */       if (this.team != _o_.team) return false;
/* 66 */       if (this.formation_id != _o_.formation_id) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.team;
/* 75 */     _h_ += this.formation_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.team).append(",");
/* 83 */     _sb_.append(this.formation_id).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPetFightSetTeamFormationReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.team - _o_.team;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.formation_id - _o_.formation_id;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetFightSetTeamFormationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */