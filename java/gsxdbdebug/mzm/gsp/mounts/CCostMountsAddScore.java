/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCCostMountsAddScore;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CCostMountsAddScore
/*     */   extends __CCostMountsAddScore__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606241;
/*     */   public long cost_mounts_id;
/*     */   public long add_score_mounts_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCCostMountsAddScore(roleId, this.cost_mounts_id, this.add_score_mounts_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606241;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CCostMountsAddScore() {}
/*     */   
/*     */ 
/*     */   public CCostMountsAddScore(long _cost_mounts_id_, long _add_score_mounts_id_)
/*     */   {
/*  43 */     this.cost_mounts_id = _cost_mounts_id_;
/*  44 */     this.add_score_mounts_id = _add_score_mounts_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.cost_mounts_id);
/*  53 */     _os_.marshal(this.add_score_mounts_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.cost_mounts_id = _os_.unmarshal_long();
/*  59 */     this.add_score_mounts_id = _os_.unmarshal_long();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CCostMountsAddScore)) {
/*  69 */       CCostMountsAddScore _o_ = (CCostMountsAddScore)_o1_;
/*  70 */       if (this.cost_mounts_id != _o_.cost_mounts_id) return false;
/*  71 */       if (this.add_score_mounts_id != _o_.add_score_mounts_id) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.cost_mounts_id;
/*  80 */     _h_ += (int)this.add_score_mounts_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.cost_mounts_id).append(",");
/*  88 */     _sb_.append(this.add_score_mounts_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCostMountsAddScore _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.cost_mounts_id - _o_.cost_mounts_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.add_score_mounts_id - _o_.add_score_mounts_id);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CCostMountsAddScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */