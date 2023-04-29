/*    */ package mzm.gsp.pet;
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
/*    */ public class SPetFightSetTeamFormationSuccess
/*    */   extends __SPetFightSetTeamFormationSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590687;
/*    */   public int team;
/*    */   public int formation_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590687;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPetFightSetTeamFormationSuccess() {}
/*    */   
/*    */ 
/*    */   public SPetFightSetTeamFormationSuccess(int _team_, int _formation_id_)
/*    */   {
/* 37 */     this.team = _team_;
/* 38 */     this.formation_id = _formation_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.team);
/* 47 */     _os_.marshal(this.formation_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.team = _os_.unmarshal_int();
/* 53 */     this.formation_id = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SPetFightSetTeamFormationSuccess)) {
/* 63 */       SPetFightSetTeamFormationSuccess _o_ = (SPetFightSetTeamFormationSuccess)_o1_;
/* 64 */       if (this.team != _o_.team) return false;
/* 65 */       if (this.formation_id != _o_.formation_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.team;
/* 74 */     _h_ += this.formation_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.team).append(",");
/* 82 */     _sb_.append(this.formation_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetFightSetTeamFormationSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.team - _o_.team;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.formation_id - _o_.formation_id;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetFightSetTeamFormationSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */