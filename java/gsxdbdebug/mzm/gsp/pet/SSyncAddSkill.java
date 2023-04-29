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
/*     */ public class SSyncAddSkill
/*     */   extends __SSyncAddSkill__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590604;
/*     */   public static final int FROM_BOOK = 0;
/*     */   public static final int FROM_LEVELUP = 1;
/*     */   public long petid;
/*     */   public int skillid;
/*     */   public int reason;
/*     */   public int removeskillid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590604;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncAddSkill() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncAddSkill(long _petid_, int _skillid_, int _reason_, int _removeskillid_)
/*     */   {
/*  42 */     this.petid = _petid_;
/*  43 */     this.skillid = _skillid_;
/*  44 */     this.reason = _reason_;
/*  45 */     this.removeskillid = _removeskillid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.petid);
/*  54 */     _os_.marshal(this.skillid);
/*  55 */     _os_.marshal(this.reason);
/*  56 */     _os_.marshal(this.removeskillid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.petid = _os_.unmarshal_long();
/*  62 */     this.skillid = _os_.unmarshal_int();
/*  63 */     this.reason = _os_.unmarshal_int();
/*  64 */     this.removeskillid = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SSyncAddSkill)) {
/*  74 */       SSyncAddSkill _o_ = (SSyncAddSkill)_o1_;
/*  75 */       if (this.petid != _o_.petid) return false;
/*  76 */       if (this.skillid != _o_.skillid) return false;
/*  77 */       if (this.reason != _o_.reason) return false;
/*  78 */       if (this.removeskillid != _o_.removeskillid) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += (int)this.petid;
/*  87 */     _h_ += this.skillid;
/*  88 */     _h_ += this.reason;
/*  89 */     _h_ += this.removeskillid;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.petid).append(",");
/*  97 */     _sb_.append(this.skillid).append(",");
/*  98 */     _sb_.append(this.reason).append(",");
/*  99 */     _sb_.append(this.removeskillid).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncAddSkill _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.skillid - _o_.skillid;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.reason - _o_.reason;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.removeskillid - _o_.removeskillid;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncAddSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */