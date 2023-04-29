/*     */ package mzm.gsp.wing;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSetTargetSkillRep
/*     */   extends __SSetTargetSkillRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596547;
/*     */   public int cfg_id;
/*     */   public int index;
/*     */   public int skill_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596547;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSetTargetSkillRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSetTargetSkillRep(int _cfg_id_, int _index_, int _skill_id_)
/*     */   {
/*  38 */     this.cfg_id = _cfg_id_;
/*  39 */     this.index = _index_;
/*  40 */     this.skill_id = _skill_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.cfg_id);
/*  49 */     _os_.marshal(this.index);
/*  50 */     _os_.marshal(this.skill_id);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.cfg_id = _os_.unmarshal_int();
/*  56 */     this.index = _os_.unmarshal_int();
/*  57 */     this.skill_id = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSetTargetSkillRep)) {
/*  67 */       SSetTargetSkillRep _o_ = (SSetTargetSkillRep)_o1_;
/*  68 */       if (this.cfg_id != _o_.cfg_id) return false;
/*  69 */       if (this.index != _o_.index) return false;
/*  70 */       if (this.skill_id != _o_.skill_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.cfg_id;
/*  79 */     _h_ += this.index;
/*  80 */     _h_ += this.skill_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.cfg_id).append(",");
/*  88 */     _sb_.append(this.index).append(",");
/*  89 */     _sb_.append(this.skill_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSetTargetSkillRep _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.cfg_id - _o_.cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.index - _o_.index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.skill_id - _o_.skill_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SSetTargetSkillRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */