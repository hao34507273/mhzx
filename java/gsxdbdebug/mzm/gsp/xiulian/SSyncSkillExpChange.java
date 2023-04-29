/*     */ package mzm.gsp.xiulian;
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
/*     */ public class SSyncSkillExpChange
/*     */   extends __SSyncSkillExpChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589571;
/*     */   public int skillbagid;
/*     */   public int exp;
/*     */   public int usesilver;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589571;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncSkillExpChange() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncSkillExpChange(int _skillbagid_, int _exp_, int _usesilver_)
/*     */   {
/*  38 */     this.skillbagid = _skillbagid_;
/*  39 */     this.exp = _exp_;
/*  40 */     this.usesilver = _usesilver_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.skillbagid);
/*  49 */     _os_.marshal(this.exp);
/*  50 */     _os_.marshal(this.usesilver);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.skillbagid = _os_.unmarshal_int();
/*  56 */     this.exp = _os_.unmarshal_int();
/*  57 */     this.usesilver = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSyncSkillExpChange)) {
/*  67 */       SSyncSkillExpChange _o_ = (SSyncSkillExpChange)_o1_;
/*  68 */       if (this.skillbagid != _o_.skillbagid) return false;
/*  69 */       if (this.exp != _o_.exp) return false;
/*  70 */       if (this.usesilver != _o_.usesilver) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.skillbagid;
/*  79 */     _h_ += this.exp;
/*  80 */     _h_ += this.usesilver;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.skillbagid).append(",");
/*  88 */     _sb_.append(this.exp).append(",");
/*  89 */     _sb_.append(this.usesilver).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncSkillExpChange _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.skillbagid - _o_.skillbagid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.exp - _o_.exp;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.usesilver - _o_.usesilver;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\SSyncSkillExpChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */