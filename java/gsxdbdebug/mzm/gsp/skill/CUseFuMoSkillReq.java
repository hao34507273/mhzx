/*    */ package mzm.gsp.skill;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.skill.main.PUseEnchantSkillReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseFuMoSkillReq
/*    */   extends __CUseFuMoSkillReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591623;
/*    */   public int skillid;
/*    */   public int skillbagid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PUseEnchantSkillReq(roleId, this.skillid, this.skillbagid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12591623;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseFuMoSkillReq() {}
/*    */   
/*    */ 
/*    */   public CUseFuMoSkillReq(int _skillid_, int _skillbagid_)
/*    */   {
/* 41 */     this.skillid = _skillid_;
/* 42 */     this.skillbagid = _skillbagid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.skillid);
/* 51 */     _os_.marshal(this.skillbagid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.skillid = _os_.unmarshal_int();
/* 57 */     this.skillbagid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CUseFuMoSkillReq)) {
/* 67 */       CUseFuMoSkillReq _o_ = (CUseFuMoSkillReq)_o1_;
/* 68 */       if (this.skillid != _o_.skillid) return false;
/* 69 */       if (this.skillbagid != _o_.skillbagid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.skillid;
/* 78 */     _h_ += this.skillbagid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.skillid).append(",");
/* 86 */     _sb_.append(this.skillbagid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseFuMoSkillReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.skillid - _o_.skillid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.skillbagid - _o_.skillbagid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\CUseFuMoSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */