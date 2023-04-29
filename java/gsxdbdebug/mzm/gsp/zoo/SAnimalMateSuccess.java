/*     */ package mzm.gsp.zoo;
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
/*     */ public class SAnimalMateSuccess
/*     */   extends __SAnimalMateSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615434;
/*     */   public long animalid;
/*     */   public long target_animalid;
/*     */   public int last_time;
/*     */   public int award_cfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615434;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnimalMateSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAnimalMateSuccess(long _animalid_, long _target_animalid_, int _last_time_, int _award_cfgid_)
/*     */   {
/*  39 */     this.animalid = _animalid_;
/*  40 */     this.target_animalid = _target_animalid_;
/*  41 */     this.last_time = _last_time_;
/*  42 */     this.award_cfgid = _award_cfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.animalid);
/*  51 */     _os_.marshal(this.target_animalid);
/*  52 */     _os_.marshal(this.last_time);
/*  53 */     _os_.marshal(this.award_cfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.animalid = _os_.unmarshal_long();
/*  59 */     this.target_animalid = _os_.unmarshal_long();
/*  60 */     this.last_time = _os_.unmarshal_int();
/*  61 */     this.award_cfgid = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAnimalMateSuccess)) {
/*  71 */       SAnimalMateSuccess _o_ = (SAnimalMateSuccess)_o1_;
/*  72 */       if (this.animalid != _o_.animalid) return false;
/*  73 */       if (this.target_animalid != _o_.target_animalid) return false;
/*  74 */       if (this.last_time != _o_.last_time) return false;
/*  75 */       if (this.award_cfgid != _o_.award_cfgid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.animalid;
/*  84 */     _h_ += (int)this.target_animalid;
/*  85 */     _h_ += this.last_time;
/*  86 */     _h_ += this.award_cfgid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.animalid).append(",");
/*  94 */     _sb_.append(this.target_animalid).append(",");
/*  95 */     _sb_.append(this.last_time).append(",");
/*  96 */     _sb_.append(this.award_cfgid).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAnimalMateSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.animalid - _o_.animalid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.target_animalid - _o_.target_animalid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.last_time - _o_.last_time;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.award_cfgid - _o_.award_cfgid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SAnimalMateSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */