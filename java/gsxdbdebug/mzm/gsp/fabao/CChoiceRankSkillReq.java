/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fabao.main.PChoiceRankSkill;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CChoiceRankSkillReq
/*     */   extends __CChoiceRankSkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596004;
/*     */   public int equiped;
/*     */   public long fabaouuid;
/*     */   public int skillid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PChoiceRankSkill(roleid, this.equiped, this.fabaouuid, this.skillid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596004;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CChoiceRankSkillReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CChoiceRankSkillReq(int _equiped_, long _fabaouuid_, int _skillid_)
/*     */   {
/*  40 */     this.equiped = _equiped_;
/*  41 */     this.fabaouuid = _fabaouuid_;
/*  42 */     this.skillid = _skillid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.equiped);
/*  51 */     _os_.marshal(this.fabaouuid);
/*  52 */     _os_.marshal(this.skillid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.equiped = _os_.unmarshal_int();
/*  58 */     this.fabaouuid = _os_.unmarshal_long();
/*  59 */     this.skillid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CChoiceRankSkillReq)) {
/*  69 */       CChoiceRankSkillReq _o_ = (CChoiceRankSkillReq)_o1_;
/*  70 */       if (this.equiped != _o_.equiped) return false;
/*  71 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  72 */       if (this.skillid != _o_.skillid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.equiped;
/*  81 */     _h_ += (int)this.fabaouuid;
/*  82 */     _h_ += this.skillid;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.equiped).append(",");
/*  90 */     _sb_.append(this.fabaouuid).append(",");
/*  91 */     _sb_.append(this.skillid).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChoiceRankSkillReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.equiped - _o_.equiped;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.skillid - _o_.skillid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CChoiceRankSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */