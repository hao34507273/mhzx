/*     */ package mzm.gsp.activitypointexchange;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SManualRefreshError
/*     */   extends __SManualRefreshError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624910;
/*     */   public static final int MONEY_NOT_ENOUGH = 1;
/*     */   public static final int REFRESH_COUNT_MAX = 2;
/*     */   public static final int NO_NEED_REFRESH = 3;
/*     */   public static final int ACTIVITY_CLOSED = 4;
/*     */   public static final int NOT_SUPPORTED = 5;
/*     */   public static final int REFRESH_COUNT_ERROR = 6;
/*     */   public static final int MALL_CLOSED = 7;
/*     */   public int errorcode;
/*     */   public int activityid;
/*     */   public int refreshcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12624910;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SManualRefreshError() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SManualRefreshError(int _errorcode_, int _activityid_, int _refreshcount_)
/*     */   {
/*  44 */     this.errorcode = _errorcode_;
/*  45 */     this.activityid = _activityid_;
/*  46 */     this.refreshcount = _refreshcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.errorcode);
/*  55 */     _os_.marshal(this.activityid);
/*  56 */     _os_.marshal(this.refreshcount);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.errorcode = _os_.unmarshal_int();
/*  62 */     this.activityid = _os_.unmarshal_int();
/*  63 */     this.refreshcount = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SManualRefreshError)) {
/*  73 */       SManualRefreshError _o_ = (SManualRefreshError)_o1_;
/*  74 */       if (this.errorcode != _o_.errorcode) return false;
/*  75 */       if (this.activityid != _o_.activityid) return false;
/*  76 */       if (this.refreshcount != _o_.refreshcount) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.errorcode;
/*  85 */     _h_ += this.activityid;
/*  86 */     _h_ += this.refreshcount;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.errorcode).append(",");
/*  94 */     _sb_.append(this.activityid).append(",");
/*  95 */     _sb_.append(this.refreshcount).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SManualRefreshError _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.errorcode - _o_.errorcode;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.activityid - _o_.activityid;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.refreshcount - _o_.refreshcount;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SManualRefreshError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */