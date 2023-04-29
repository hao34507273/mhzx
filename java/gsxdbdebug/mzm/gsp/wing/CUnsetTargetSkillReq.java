/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.wing.main2.PCSetTargetSkillReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUnsetTargetSkillReq
/*    */   extends __CUnsetTargetSkillReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596546;
/*    */   public int cfg_id;
/*    */   public int index;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, PCSetTargetSkillReq.newPCUnsetTargetSkillReq(roleId, this.cfg_id, this.index));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12596546;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUnsetTargetSkillReq() {}
/*    */   
/*    */ 
/*    */   public CUnsetTargetSkillReq(int _cfg_id_, int _index_)
/*    */   {
/* 42 */     this.cfg_id = _cfg_id_;
/* 43 */     this.index = _index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.cfg_id);
/* 52 */     _os_.marshal(this.index);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.cfg_id = _os_.unmarshal_int();
/* 58 */     this.index = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CUnsetTargetSkillReq)) {
/* 68 */       CUnsetTargetSkillReq _o_ = (CUnsetTargetSkillReq)_o1_;
/* 69 */       if (this.cfg_id != _o_.cfg_id) return false;
/* 70 */       if (this.index != _o_.index) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.cfg_id;
/* 79 */     _h_ += this.index;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.cfg_id).append(",");
/* 87 */     _sb_.append(this.index).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUnsetTargetSkillReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.cfg_id - _o_.cfg_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.index - _o_.index;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CUnsetTargetSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */