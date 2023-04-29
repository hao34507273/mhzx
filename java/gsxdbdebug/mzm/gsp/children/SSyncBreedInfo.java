/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncBreedInfo
/*     */   extends __SSyncBreedInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609314;
/*     */   public static final int COUPLE_BREED = 0;
/*     */   public static final int SINGLE_BREED = 1;
/*     */   public static final int NO_BREED = 2;
/*     */   public int breed_state;
/*     */   public int score;
/*     */   public int step;
/*     */   public long remain_give_birth_seconds;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609314;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBreedInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBreedInfo(int _breed_state_, int _score_, int _step_, long _remain_give_birth_seconds_)
/*     */   {
/*  43 */     this.breed_state = _breed_state_;
/*  44 */     this.score = _score_;
/*  45 */     this.step = _step_;
/*  46 */     this.remain_give_birth_seconds = _remain_give_birth_seconds_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.breed_state);
/*  55 */     _os_.marshal(this.score);
/*  56 */     _os_.marshal(this.step);
/*  57 */     _os_.marshal(this.remain_give_birth_seconds);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.breed_state = _os_.unmarshal_int();
/*  63 */     this.score = _os_.unmarshal_int();
/*  64 */     this.step = _os_.unmarshal_int();
/*  65 */     this.remain_give_birth_seconds = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSyncBreedInfo)) {
/*  75 */       SSyncBreedInfo _o_ = (SSyncBreedInfo)_o1_;
/*  76 */       if (this.breed_state != _o_.breed_state) return false;
/*  77 */       if (this.score != _o_.score) return false;
/*  78 */       if (this.step != _o_.step) return false;
/*  79 */       if (this.remain_give_birth_seconds != _o_.remain_give_birth_seconds) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.breed_state;
/*  88 */     _h_ += this.score;
/*  89 */     _h_ += this.step;
/*  90 */     _h_ += (int)this.remain_give_birth_seconds;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.breed_state).append(",");
/*  98 */     _sb_.append(this.score).append(",");
/*  99 */     _sb_.append(this.step).append(",");
/* 100 */     _sb_.append(this.remain_give_birth_seconds).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncBreedInfo _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.breed_state - _o_.breed_state;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.score - _o_.score;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.step - _o_.step;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.remain_give_birth_seconds - _o_.remain_give_birth_seconds);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SSyncBreedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */