/*     */ package mzm.gsp.loginaward;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetLoginAwardFailed
/*     */   extends __SGetLoginAwardFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604675;
/*     */   public static final int ERROR_NOT_OPEN = -1;
/*     */   public static final int ERROR_AWARD_HAVE_RECEIVED = -2;
/*     */   public static final int ERROR_NOT_MATCH = -3;
/*     */   public static final int ERROR_AWARD_MISS = -4;
/*     */   public int activityid;
/*     */   public int sortid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604675;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetLoginAwardFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetLoginAwardFailed(int _activityid_, int _sortid_, int _retcode_)
/*     */   {
/*  43 */     this.activityid = _activityid_;
/*  44 */     this.sortid = _sortid_;
/*  45 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activityid);
/*  54 */     _os_.marshal(this.sortid);
/*  55 */     _os_.marshal(this.retcode);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activityid = _os_.unmarshal_int();
/*  61 */     this.sortid = _os_.unmarshal_int();
/*  62 */     this.retcode = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SGetLoginAwardFailed)) {
/*  72 */       SGetLoginAwardFailed _o_ = (SGetLoginAwardFailed)_o1_;
/*  73 */       if (this.activityid != _o_.activityid) return false;
/*  74 */       if (this.sortid != _o_.sortid) return false;
/*  75 */       if (this.retcode != _o_.retcode) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activityid;
/*  84 */     _h_ += this.sortid;
/*  85 */     _h_ += this.retcode;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.activityid).append(",");
/*  93 */     _sb_.append(this.sortid).append(",");
/*  94 */     _sb_.append(this.retcode).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetLoginAwardFailed _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.activityid - _o_.activityid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.sortid - _o_.sortid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.retcode - _o_.retcode;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\SGetLoginAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */