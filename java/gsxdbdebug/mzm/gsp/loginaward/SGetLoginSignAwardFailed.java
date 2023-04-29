/*     */ package mzm.gsp.loginaward;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetLoginSignAwardFailed
/*     */   extends __SGetLoginSignAwardFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604686;
/*     */   public static final int ERROR_NOT_OPEN = -1;
/*     */   public static final int ERROR_AWARD_HAVE_RECEIVED = -2;
/*     */   public static final int ERROR_NOT_MATCH = -3;
/*     */   public static final int ERROR_LEVEL_LIMIT = -4;
/*     */   public static final int ERROR_EXPIRE = -5;
/*     */   public int activity_cfgid;
/*     */   public int sortid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604686;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetLoginSignAwardFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetLoginSignAwardFailed(int _activity_cfgid_, int _sortid_, int _retcode_)
/*     */   {
/*  44 */     this.activity_cfgid = _activity_cfgid_;
/*  45 */     this.sortid = _sortid_;
/*  46 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_cfgid);
/*  55 */     _os_.marshal(this.sortid);
/*  56 */     _os_.marshal(this.retcode);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfgid = _os_.unmarshal_int();
/*  62 */     this.sortid = _os_.unmarshal_int();
/*  63 */     this.retcode = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SGetLoginSignAwardFailed)) {
/*  73 */       SGetLoginSignAwardFailed _o_ = (SGetLoginSignAwardFailed)_o1_;
/*  74 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  75 */       if (this.sortid != _o_.sortid) return false;
/*  76 */       if (this.retcode != _o_.retcode) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.activity_cfgid;
/*  85 */     _h_ += this.sortid;
/*  86 */     _h_ += this.retcode;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_cfgid).append(",");
/*  94 */     _sb_.append(this.sortid).append(",");
/*  95 */     _sb_.append(this.retcode).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetLoginSignAwardFailed _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.sortid - _o_.sortid;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.retcode - _o_.retcode;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\SGetLoginSignAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */