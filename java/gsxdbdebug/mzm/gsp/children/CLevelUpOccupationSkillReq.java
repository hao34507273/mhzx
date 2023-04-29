/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.main.PCLevelUpOccupationSkillReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CLevelUpOccupationSkillReq
/*    */   extends __CLevelUpOccupationSkillReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609378;
/*    */   public long childrenid;
/*    */   public int skillid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCLevelUpOccupationSkillReq(roleid, this.childrenid, this.skillid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12609378;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CLevelUpOccupationSkillReq() {}
/*    */   
/*    */ 
/*    */   public CLevelUpOccupationSkillReq(long _childrenid_, int _skillid_)
/*    */   {
/* 39 */     this.childrenid = _childrenid_;
/* 40 */     this.skillid = _skillid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.childrenid);
/* 49 */     _os_.marshal(this.skillid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.childrenid = _os_.unmarshal_long();
/* 55 */     this.skillid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CLevelUpOccupationSkillReq)) {
/* 65 */       CLevelUpOccupationSkillReq _o_ = (CLevelUpOccupationSkillReq)_o1_;
/* 66 */       if (this.childrenid != _o_.childrenid) return false;
/* 67 */       if (this.skillid != _o_.skillid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.childrenid;
/* 76 */     _h_ += this.skillid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.childrenid).append(",");
/* 84 */     _sb_.append(this.skillid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CLevelUpOccupationSkillReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.skillid - _o_.skillid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CLevelUpOccupationSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */