/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCMountsActiveStarLife;
/*     */ 
/*     */ 
/*     */ public class CMountsActiveStarLife
/*     */   extends __CMountsActiveStarLife__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606224;
/*     */   public long mounts_id;
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
/*  25 */     Role.addRoleProcedure(roleId, new PCMountsActiveStarLife(roleId, this.mounts_id, this.is_use_yuan_bao, this.client_current_yuan_bao, this.need_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606224;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CMountsActiveStarLife() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CMountsActiveStarLife(long _mounts_id_, int _is_use_yuan_bao_, long _client_current_yuan_bao_, int _need_yuan_bao_)
/*     */   {
/*  45 */     this.mounts_id = _mounts_id_;
/*  46 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*  47 */     this.client_current_yuan_bao = _client_current_yuan_bao_;
/*  48 */     this.need_yuan_bao = _need_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.mounts_id);
/*  57 */     _os_.marshal(this.is_use_yuan_bao);
/*  58 */     _os_.marshal(this.client_current_yuan_bao);
/*  59 */     _os_.marshal(this.need_yuan_bao);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.mounts_id = _os_.unmarshal_long();
/*  65 */     this.is_use_yuan_bao = _os_.unmarshal_int();
/*  66 */     this.client_current_yuan_bao = _os_.unmarshal_long();
/*  67 */     this.need_yuan_bao = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CMountsActiveStarLife)) {
/*  77 */       CMountsActiveStarLife _o_ = (CMountsActiveStarLife)_o1_;
/*  78 */       if (this.mounts_id != _o_.mounts_id) return false;
/*  79 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  80 */       if (this.client_current_yuan_bao != _o_.client_current_yuan_bao) return false;
/*  81 */       if (this.need_yuan_bao != _o_.need_yuan_bao) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.mounts_id;
/*  90 */     _h_ += this.is_use_yuan_bao;
/*  91 */     _h_ += (int)this.client_current_yuan_bao;
/*  92 */     _h_ += this.need_yuan_bao;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.mounts_id).append(",");
/* 100 */     _sb_.append(this.is_use_yuan_bao).append(",");
/* 101 */     _sb_.append(this.client_current_yuan_bao).append(",");
/* 102 */     _sb_.append(this.need_yuan_bao).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMountsActiveStarLife _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.mounts_id - _o_.mounts_id);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.is_use_yuan_bao - _o_.is_use_yuan_bao;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.client_current_yuan_bao - _o_.client_current_yuan_bao);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.need_yuan_bao - _o_.need_yuan_bao;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CMountsActiveStarLife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */