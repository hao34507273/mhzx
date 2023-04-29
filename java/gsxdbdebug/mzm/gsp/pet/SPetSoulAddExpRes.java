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
/*     */ public class SPetSoulAddExpRes
/*     */   extends __SPetSoulAddExpRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590668;
/*     */   public long petid;
/*     */   public int pos;
/*     */   public int level;
/*     */   public int exp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12590668;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetSoulAddExpRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetSoulAddExpRes(long _petid_, int _pos_, int _level_, int _exp_)
/*     */   {
/*  37 */     this.petid = _petid_;
/*  38 */     this.pos = _pos_;
/*  39 */     this.level = _level_;
/*  40 */     this.exp = _exp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.petid);
/*  49 */     _os_.marshal(this.pos);
/*  50 */     _os_.marshal(this.level);
/*  51 */     _os_.marshal(this.exp);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.petid = _os_.unmarshal_long();
/*  57 */     this.pos = _os_.unmarshal_int();
/*  58 */     this.level = _os_.unmarshal_int();
/*  59 */     this.exp = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SPetSoulAddExpRes)) {
/*  69 */       SPetSoulAddExpRes _o_ = (SPetSoulAddExpRes)_o1_;
/*  70 */       if (this.petid != _o_.petid) return false;
/*  71 */       if (this.pos != _o_.pos) return false;
/*  72 */       if (this.level != _o_.level) return false;
/*  73 */       if (this.exp != _o_.exp) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.petid;
/*  82 */     _h_ += this.pos;
/*  83 */     _h_ += this.level;
/*  84 */     _h_ += this.exp;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.petid).append(",");
/*  92 */     _sb_.append(this.pos).append(",");
/*  93 */     _sb_.append(this.level).append(",");
/*  94 */     _sb_.append(this.exp).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetSoulAddExpRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.pos - _o_.pos;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.level - _o_.level;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.exp - _o_.exp;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetSoulAddExpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */