/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPetFightSetSkillFail
/*     */   extends __SPetFightSetSkillFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590698;
/*     */   public static final int PET_NOT_EXISTS = 1;
/*     */   public static final int PET_NOT_BOUND = 2;
/*     */   public static final int SKILL_NOT_AVAILABLE = 3;
/*     */   public int reason;
/*     */   public long pet_id;
/*     */   public int skill_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590698;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetFightSetSkillFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetFightSetSkillFail(int _reason_, long _pet_id_, int _skill_id_)
/*     */   {
/*  42 */     this.reason = _reason_;
/*  43 */     this.pet_id = _pet_id_;
/*  44 */     this.skill_id = _skill_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.reason);
/*  53 */     _os_.marshal(this.pet_id);
/*  54 */     _os_.marshal(this.skill_id);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.reason = _os_.unmarshal_int();
/*  60 */     this.pet_id = _os_.unmarshal_long();
/*  61 */     this.skill_id = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SPetFightSetSkillFail)) {
/*  71 */       SPetFightSetSkillFail _o_ = (SPetFightSetSkillFail)_o1_;
/*  72 */       if (this.reason != _o_.reason) return false;
/*  73 */       if (this.pet_id != _o_.pet_id) return false;
/*  74 */       if (this.skill_id != _o_.skill_id) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.reason;
/*  83 */     _h_ += (int)this.pet_id;
/*  84 */     _h_ += this.skill_id;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.reason).append(",");
/*  92 */     _sb_.append(this.pet_id).append(",");
/*  93 */     _sb_.append(this.skill_id).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetFightSetSkillFail _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.reason - _o_.reason;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.skill_id - _o_.skill_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetFightSetSkillFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */