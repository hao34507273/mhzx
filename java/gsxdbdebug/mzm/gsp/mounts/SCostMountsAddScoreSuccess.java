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
/*     */ public class SCostMountsAddScoreSuccess
/*     */   extends __SCostMountsAddScoreSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606245;
/*     */   public long cost_mounts_id;
/*     */   public long add_score_mounts_id;
/*     */   public int now_score;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606245;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SCostMountsAddScoreSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SCostMountsAddScoreSuccess(long _cost_mounts_id_, long _add_score_mounts_id_, int _now_score_)
/*     */   {
/*  38 */     this.cost_mounts_id = _cost_mounts_id_;
/*  39 */     this.add_score_mounts_id = _add_score_mounts_id_;
/*  40 */     this.now_score = _now_score_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.cost_mounts_id);
/*  49 */     _os_.marshal(this.add_score_mounts_id);
/*  50 */     _os_.marshal(this.now_score);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.cost_mounts_id = _os_.unmarshal_long();
/*  56 */     this.add_score_mounts_id = _os_.unmarshal_long();
/*  57 */     this.now_score = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SCostMountsAddScoreSuccess)) {
/*  67 */       SCostMountsAddScoreSuccess _o_ = (SCostMountsAddScoreSuccess)_o1_;
/*  68 */       if (this.cost_mounts_id != _o_.cost_mounts_id) return false;
/*  69 */       if (this.add_score_mounts_id != _o_.add_score_mounts_id) return false;
/*  70 */       if (this.now_score != _o_.now_score) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.cost_mounts_id;
/*  79 */     _h_ += (int)this.add_score_mounts_id;
/*  80 */     _h_ += this.now_score;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.cost_mounts_id).append(",");
/*  88 */     _sb_.append(this.add_score_mounts_id).append(",");
/*  89 */     _sb_.append(this.now_score).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCostMountsAddScoreSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.cost_mounts_id - _o_.cost_mounts_id);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.add_score_mounts_id - _o_.add_score_mounts_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.now_score - _o_.now_score;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SCostMountsAddScoreSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */