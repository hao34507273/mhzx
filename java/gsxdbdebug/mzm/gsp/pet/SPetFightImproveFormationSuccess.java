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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPetFightImproveFormationSuccess
/*     */   extends __SPetFightImproveFormationSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590686;
/*     */   public int formation_id;
/*     */   public int level;
/*     */   public int exp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590686;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetFightImproveFormationSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetFightImproveFormationSuccess(int _formation_id_, int _level_, int _exp_)
/*     */   {
/*  38 */     this.formation_id = _formation_id_;
/*  39 */     this.level = _level_;
/*  40 */     this.exp = _exp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.formation_id);
/*  49 */     _os_.marshal(this.level);
/*  50 */     _os_.marshal(this.exp);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.formation_id = _os_.unmarshal_int();
/*  56 */     this.level = _os_.unmarshal_int();
/*  57 */     this.exp = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SPetFightImproveFormationSuccess)) {
/*  67 */       SPetFightImproveFormationSuccess _o_ = (SPetFightImproveFormationSuccess)_o1_;
/*  68 */       if (this.formation_id != _o_.formation_id) return false;
/*  69 */       if (this.level != _o_.level) return false;
/*  70 */       if (this.exp != _o_.exp) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.formation_id;
/*  79 */     _h_ += this.level;
/*  80 */     _h_ += this.exp;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.formation_id).append(",");
/*  88 */     _sb_.append(this.level).append(",");
/*  89 */     _sb_.append(this.exp).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetFightImproveFormationSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.formation_id - _o_.formation_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.level - _o_.level;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.exp - _o_.exp;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetFightImproveFormationSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */