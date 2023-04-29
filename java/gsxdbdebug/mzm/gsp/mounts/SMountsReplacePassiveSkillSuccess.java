/*     */ package mzm.gsp.mounts;
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
/*     */ public class SMountsReplacePassiveSkillSuccess
/*     */   extends __SMountsReplacePassiveSkillSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606213;
/*     */   public long mounts_id;
/*     */   public int old_passive_skill_cfg_id;
/*     */   public PassiveSkillInfo refresh_passive_skill_result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606213;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMountsReplacePassiveSkillSuccess()
/*     */   {
/*  35 */     this.refresh_passive_skill_result = new PassiveSkillInfo();
/*     */   }
/*     */   
/*     */   public SMountsReplacePassiveSkillSuccess(long _mounts_id_, int _old_passive_skill_cfg_id_, PassiveSkillInfo _refresh_passive_skill_result_) {
/*  39 */     this.mounts_id = _mounts_id_;
/*  40 */     this.old_passive_skill_cfg_id = _old_passive_skill_cfg_id_;
/*  41 */     this.refresh_passive_skill_result = _refresh_passive_skill_result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     if (!this.refresh_passive_skill_result._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.mounts_id);
/*  51 */     _os_.marshal(this.old_passive_skill_cfg_id);
/*  52 */     _os_.marshal(this.refresh_passive_skill_result);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.mounts_id = _os_.unmarshal_long();
/*  58 */     this.old_passive_skill_cfg_id = _os_.unmarshal_int();
/*  59 */     this.refresh_passive_skill_result.unmarshal(_os_);
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SMountsReplacePassiveSkillSuccess)) {
/*  69 */       SMountsReplacePassiveSkillSuccess _o_ = (SMountsReplacePassiveSkillSuccess)_o1_;
/*  70 */       if (this.mounts_id != _o_.mounts_id) return false;
/*  71 */       if (this.old_passive_skill_cfg_id != _o_.old_passive_skill_cfg_id) return false;
/*  72 */       if (!this.refresh_passive_skill_result.equals(_o_.refresh_passive_skill_result)) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.mounts_id;
/*  81 */     _h_ += this.old_passive_skill_cfg_id;
/*  82 */     _h_ += this.refresh_passive_skill_result.hashCode();
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.mounts_id).append(",");
/*  90 */     _sb_.append(this.old_passive_skill_cfg_id).append(",");
/*  91 */     _sb_.append(this.refresh_passive_skill_result).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMountsReplacePassiveSkillSuccess _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.mounts_id - _o_.mounts_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.old_passive_skill_cfg_id - _o_.old_passive_skill_cfg_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.refresh_passive_skill_result.compareTo(_o_.refresh_passive_skill_result);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsReplacePassiveSkillSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */