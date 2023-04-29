/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCMountsRefreshPassiveSkill;
/*     */ 
/*     */ public class CMountsRefreshPassiveSkill
/*     */   extends __CMountsRefreshPassiveSkill__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606225;
/*     */   public long mounts_id;
/*     */   public int passive_skill_id;
/*     */   public int is_use_yuan_bao;
/*     */   public long client_current_yuan_bao;
/*     */   public int need_yuan_bao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCMountsRefreshPassiveSkill(roleId, this.mounts_id, this.passive_skill_id, this.client_current_yuan_bao, this.need_yuan_bao, this.is_use_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606225;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CMountsRefreshPassiveSkill() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CMountsRefreshPassiveSkill(long _mounts_id_, int _passive_skill_id_, int _is_use_yuan_bao_, long _client_current_yuan_bao_, int _need_yuan_bao_)
/*     */   {
/*  46 */     this.mounts_id = _mounts_id_;
/*  47 */     this.passive_skill_id = _passive_skill_id_;
/*  48 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*  49 */     this.client_current_yuan_bao = _client_current_yuan_bao_;
/*  50 */     this.need_yuan_bao = _need_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.mounts_id);
/*  59 */     _os_.marshal(this.passive_skill_id);
/*  60 */     _os_.marshal(this.is_use_yuan_bao);
/*  61 */     _os_.marshal(this.client_current_yuan_bao);
/*  62 */     _os_.marshal(this.need_yuan_bao);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.mounts_id = _os_.unmarshal_long();
/*  68 */     this.passive_skill_id = _os_.unmarshal_int();
/*  69 */     this.is_use_yuan_bao = _os_.unmarshal_int();
/*  70 */     this.client_current_yuan_bao = _os_.unmarshal_long();
/*  71 */     this.need_yuan_bao = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CMountsRefreshPassiveSkill)) {
/*  81 */       CMountsRefreshPassiveSkill _o_ = (CMountsRefreshPassiveSkill)_o1_;
/*  82 */       if (this.mounts_id != _o_.mounts_id) return false;
/*  83 */       if (this.passive_skill_id != _o_.passive_skill_id) return false;
/*  84 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  85 */       if (this.client_current_yuan_bao != _o_.client_current_yuan_bao) return false;
/*  86 */       if (this.need_yuan_bao != _o_.need_yuan_bao) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.mounts_id;
/*  95 */     _h_ += this.passive_skill_id;
/*  96 */     _h_ += this.is_use_yuan_bao;
/*  97 */     _h_ += (int)this.client_current_yuan_bao;
/*  98 */     _h_ += this.need_yuan_bao;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.mounts_id).append(",");
/* 106 */     _sb_.append(this.passive_skill_id).append(",");
/* 107 */     _sb_.append(this.is_use_yuan_bao).append(",");
/* 108 */     _sb_.append(this.client_current_yuan_bao).append(",");
/* 109 */     _sb_.append(this.need_yuan_bao).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMountsRefreshPassiveSkill _o_) {
/* 115 */     if (_o_ == this) return 0;
/* 116 */     int _c_ = 0;
/* 117 */     _c_ = Long.signum(this.mounts_id - _o_.mounts_id);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.passive_skill_id - _o_.passive_skill_id;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.is_use_yuan_bao - _o_.is_use_yuan_bao;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = Long.signum(this.client_current_yuan_bao - _o_.client_current_yuan_bao);
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.need_yuan_bao - _o_.need_yuan_bao;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CMountsRefreshPassiveSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */