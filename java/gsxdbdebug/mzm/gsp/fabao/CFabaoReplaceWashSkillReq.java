/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fabao.main.PFabaoReplaceWashSkill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CFabaoReplaceWashSkillReq
/*    */   extends __CFabaoReplaceWashSkillReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596031;
/*    */   public int equiped;
/*    */   public long fabaouuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PFabaoReplaceWashSkill(roleid, this.equiped, this.fabaouuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12596031;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CFabaoReplaceWashSkillReq() {}
/*    */   
/*    */ 
/*    */   public CFabaoReplaceWashSkillReq(int _equiped_, long _fabaouuid_)
/*    */   {
/* 39 */     this.equiped = _equiped_;
/* 40 */     this.fabaouuid = _fabaouuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.equiped);
/* 49 */     _os_.marshal(this.fabaouuid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.equiped = _os_.unmarshal_int();
/* 55 */     this.fabaouuid = _os_.unmarshal_long();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CFabaoReplaceWashSkillReq)) {
/* 65 */       CFabaoReplaceWashSkillReq _o_ = (CFabaoReplaceWashSkillReq)_o1_;
/* 66 */       if (this.equiped != _o_.equiped) return false;
/* 67 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.equiped;
/* 76 */     _h_ += (int)this.fabaouuid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.equiped).append(",");
/* 84 */     _sb_.append(this.fabaouuid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CFabaoReplaceWashSkillReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.equiped - _o_.equiped;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CFabaoReplaceWashSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */