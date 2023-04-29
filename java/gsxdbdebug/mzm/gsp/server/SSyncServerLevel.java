/*     */ package mzm.gsp.server;
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
/*     */ public class SSyncServerLevel
/*     */   extends __SSyncServerLevel__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595201;
/*     */   public int level;
/*     */   public long starttime;
/*     */   public long upgradetime;
/*     */   public int ismaxlevel;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595201;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncServerLevel() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncServerLevel(int _level_, long _starttime_, long _upgradetime_, int _ismaxlevel_)
/*     */   {
/*  39 */     this.level = _level_;
/*  40 */     this.starttime = _starttime_;
/*  41 */     this.upgradetime = _upgradetime_;
/*  42 */     this.ismaxlevel = _ismaxlevel_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.level);
/*  51 */     _os_.marshal(this.starttime);
/*  52 */     _os_.marshal(this.upgradetime);
/*  53 */     _os_.marshal(this.ismaxlevel);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.level = _os_.unmarshal_int();
/*  59 */     this.starttime = _os_.unmarshal_long();
/*  60 */     this.upgradetime = _os_.unmarshal_long();
/*  61 */     this.ismaxlevel = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSyncServerLevel)) {
/*  71 */       SSyncServerLevel _o_ = (SSyncServerLevel)_o1_;
/*  72 */       if (this.level != _o_.level) return false;
/*  73 */       if (this.starttime != _o_.starttime) return false;
/*  74 */       if (this.upgradetime != _o_.upgradetime) return false;
/*  75 */       if (this.ismaxlevel != _o_.ismaxlevel) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.level;
/*  84 */     _h_ += (int)this.starttime;
/*  85 */     _h_ += (int)this.upgradetime;
/*  86 */     _h_ += this.ismaxlevel;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.level).append(",");
/*  94 */     _sb_.append(this.starttime).append(",");
/*  95 */     _sb_.append(this.upgradetime).append(",");
/*  96 */     _sb_.append(this.ismaxlevel).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncServerLevel _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.level - _o_.level;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.starttime - _o_.starttime);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.upgradetime - _o_.upgradetime);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.ismaxlevel - _o_.ismaxlevel;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\SSyncServerLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */