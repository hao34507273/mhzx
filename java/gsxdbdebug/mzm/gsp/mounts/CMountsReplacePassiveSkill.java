/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCMountsReplacePassiveSkill;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CMountsReplacePassiveSkill
/*     */   extends __CMountsReplacePassiveSkill__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606230;
/*     */   public long mounts_id;
/*     */   public int passive_skill_cfg_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCMountsReplacePassiveSkill(roleId, this.mounts_id, this.passive_skill_cfg_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606230;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CMountsReplacePassiveSkill() {}
/*     */   
/*     */ 
/*     */   public CMountsReplacePassiveSkill(long _mounts_id_, int _passive_skill_cfg_id_)
/*     */   {
/*  43 */     this.mounts_id = _mounts_id_;
/*  44 */     this.passive_skill_cfg_id = _passive_skill_cfg_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.mounts_id);
/*  53 */     _os_.marshal(this.passive_skill_cfg_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.mounts_id = _os_.unmarshal_long();
/*  59 */     this.passive_skill_cfg_id = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CMountsReplacePassiveSkill)) {
/*  69 */       CMountsReplacePassiveSkill _o_ = (CMountsReplacePassiveSkill)_o1_;
/*  70 */       if (this.mounts_id != _o_.mounts_id) return false;
/*  71 */       if (this.passive_skill_cfg_id != _o_.passive_skill_cfg_id) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.mounts_id;
/*  80 */     _h_ += this.passive_skill_cfg_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.mounts_id).append(",");
/*  88 */     _sb_.append(this.passive_skill_cfg_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMountsReplacePassiveSkill _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.mounts_id - _o_.mounts_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.passive_skill_cfg_id - _o_.passive_skill_cfg_id;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CMountsReplacePassiveSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */