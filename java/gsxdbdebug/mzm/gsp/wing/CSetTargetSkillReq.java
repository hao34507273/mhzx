/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.wing.main2.PCSetTargetSkillReq;
/*     */ 
/*     */ 
/*     */ public class CSetTargetSkillReq
/*     */   extends __CSetTargetSkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596545;
/*     */   public int cfg_id;
/*     */   public int index;
/*     */   public int skill_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, PCSetTargetSkillReq.newPCSetTargetSkillReq(roleId, this.cfg_id, this.index, this.skill_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12596545;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSetTargetSkillReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSetTargetSkillReq(int _cfg_id_, int _index_, int _skill_id_)
/*     */   {
/*  43 */     this.cfg_id = _cfg_id_;
/*  44 */     this.index = _index_;
/*  45 */     this.skill_id = _skill_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.cfg_id);
/*  54 */     _os_.marshal(this.index);
/*  55 */     _os_.marshal(this.skill_id);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.cfg_id = _os_.unmarshal_int();
/*  61 */     this.index = _os_.unmarshal_int();
/*  62 */     this.skill_id = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CSetTargetSkillReq)) {
/*  72 */       CSetTargetSkillReq _o_ = (CSetTargetSkillReq)_o1_;
/*  73 */       if (this.cfg_id != _o_.cfg_id) return false;
/*  74 */       if (this.index != _o_.index) return false;
/*  75 */       if (this.skill_id != _o_.skill_id) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.cfg_id;
/*  84 */     _h_ += this.index;
/*  85 */     _h_ += this.skill_id;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.cfg_id).append(",");
/*  93 */     _sb_.append(this.index).append(",");
/*  94 */     _sb_.append(this.skill_id).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSetTargetSkillReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.cfg_id - _o_.cfg_id;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.index - _o_.index;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.skill_id - _o_.skill_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CSetTargetSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */