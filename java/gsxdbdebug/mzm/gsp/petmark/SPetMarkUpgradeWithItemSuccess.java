/*     */ package mzm.gsp.petmark;
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
/*     */ public class SPetMarkUpgradeWithItemSuccess
/*     */   extends __SPetMarkUpgradeWithItemSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628509;
/*     */   public long main_pet_mark_id;
/*     */   public int now_level;
/*     */   public int now_exp;
/*     */   public int add_exp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628509;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetMarkUpgradeWithItemSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetMarkUpgradeWithItemSuccess(long _main_pet_mark_id_, int _now_level_, int _now_exp_, int _add_exp_)
/*     */   {
/*  39 */     this.main_pet_mark_id = _main_pet_mark_id_;
/*  40 */     this.now_level = _now_level_;
/*  41 */     this.now_exp = _now_exp_;
/*  42 */     this.add_exp = _add_exp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.main_pet_mark_id);
/*  51 */     _os_.marshal(this.now_level);
/*  52 */     _os_.marshal(this.now_exp);
/*  53 */     _os_.marshal(this.add_exp);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.main_pet_mark_id = _os_.unmarshal_long();
/*  59 */     this.now_level = _os_.unmarshal_int();
/*  60 */     this.now_exp = _os_.unmarshal_int();
/*  61 */     this.add_exp = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SPetMarkUpgradeWithItemSuccess)) {
/*  71 */       SPetMarkUpgradeWithItemSuccess _o_ = (SPetMarkUpgradeWithItemSuccess)_o1_;
/*  72 */       if (this.main_pet_mark_id != _o_.main_pet_mark_id) return false;
/*  73 */       if (this.now_level != _o_.now_level) return false;
/*  74 */       if (this.now_exp != _o_.now_exp) return false;
/*  75 */       if (this.add_exp != _o_.add_exp) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.main_pet_mark_id;
/*  84 */     _h_ += this.now_level;
/*  85 */     _h_ += this.now_exp;
/*  86 */     _h_ += this.add_exp;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.main_pet_mark_id).append(",");
/*  94 */     _sb_.append(this.now_level).append(",");
/*  95 */     _sb_.append(this.now_exp).append(",");
/*  96 */     _sb_.append(this.add_exp).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetMarkUpgradeWithItemSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.main_pet_mark_id - _o_.main_pet_mark_id);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.now_level - _o_.now_level;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.now_exp - _o_.now_exp;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.add_exp - _o_.add_exp;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkUpgradeWithItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */