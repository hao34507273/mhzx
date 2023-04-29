/*     */ package mzm.gsp.cat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFeedCatFailed
/*     */   extends __SFeedCatFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605709;
/*     */   public static final int ERROR_VIGOR_MAX = -1;
/*     */   public static final int ERROR_CAT_FEEDED_MAX = -2;
/*     */   public static final int ERROR_FEEDED_TOTAL_MAX = -3;
/*     */   public static final int ERROR_STATE_EXPLORE = -4;
/*     */   public static final int ERROR_CAT_HAVE_AWARD = -5;
/*     */   public long target_roleid;
/*     */   public long catid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605709;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFeedCatFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFeedCatFailed(long _target_roleid_, long _catid_, int _retcode_)
/*     */   {
/*  44 */     this.target_roleid = _target_roleid_;
/*  45 */     this.catid = _catid_;
/*  46 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.target_roleid);
/*  55 */     _os_.marshal(this.catid);
/*  56 */     _os_.marshal(this.retcode);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.target_roleid = _os_.unmarshal_long();
/*  62 */     this.catid = _os_.unmarshal_long();
/*  63 */     this.retcode = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SFeedCatFailed)) {
/*  73 */       SFeedCatFailed _o_ = (SFeedCatFailed)_o1_;
/*  74 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  75 */       if (this.catid != _o_.catid) return false;
/*  76 */       if (this.retcode != _o_.retcode) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.target_roleid;
/*  85 */     _h_ += (int)this.catid;
/*  86 */     _h_ += this.retcode;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.target_roleid).append(",");
/*  94 */     _sb_.append(this.catid).append(",");
/*  95 */     _sb_.append(this.retcode).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFeedCatFailed _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.catid - _o_.catid);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.retcode - _o_.retcode;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SFeedCatFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */