/*    */ package mzm.gsp.interaction;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.interaction.main.PInviteInteraction;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CInviteInteractionReq
/*    */   extends __CInviteInteractionReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622602;
/*    */   public long passive_role_id;
/*    */   public int interaction_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long activeRoleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(activeRoleId, new PInviteInteraction(this.interaction_id, activeRoleId, this.passive_role_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12622602;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CInviteInteractionReq() {}
/*    */   
/*    */ 
/*    */   public CInviteInteractionReq(long _passive_role_id_, int _interaction_id_)
/*    */   {
/* 39 */     this.passive_role_id = _passive_role_id_;
/* 40 */     this.interaction_id = _interaction_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.passive_role_id);
/* 49 */     _os_.marshal(this.interaction_id);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.passive_role_id = _os_.unmarshal_long();
/* 55 */     this.interaction_id = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CInviteInteractionReq)) {
/* 65 */       CInviteInteractionReq _o_ = (CInviteInteractionReq)_o1_;
/* 66 */       if (this.passive_role_id != _o_.passive_role_id) return false;
/* 67 */       if (this.interaction_id != _o_.interaction_id) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.passive_role_id;
/* 76 */     _h_ += this.interaction_id;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.passive_role_id).append(",");
/* 84 */     _sb_.append(this.interaction_id).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CInviteInteractionReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.passive_role_id - _o_.passive_role_id);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.interaction_id - _o_.interaction_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\CInviteInteractionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */