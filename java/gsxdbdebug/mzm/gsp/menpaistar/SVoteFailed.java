/*     */ package mzm.gsp.menpaistar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SVoteFailed
/*     */   extends __SVoteFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612377;
/*     */   public static final int ERROR_VOTE_NUM_NOT_ENOUGH = -1;
/*     */   public static final int ERROR_VOTE_NUM_INCONSISTENT = -2;
/*     */   public static final int ERROR_SWITH_OCCUPATION = -3;
/*     */   public static final int ERROR_ACTIVITY_IN_AWARD = -4;
/*     */   public long target_roleid;
/*     */   public int vote_num;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612377;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SVoteFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SVoteFailed(long _target_roleid_, int _vote_num_, int _retcode_)
/*     */   {
/*  43 */     this.target_roleid = _target_roleid_;
/*  44 */     this.vote_num = _vote_num_;
/*  45 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.target_roleid);
/*  54 */     _os_.marshal(this.vote_num);
/*  55 */     _os_.marshal(this.retcode);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.target_roleid = _os_.unmarshal_long();
/*  61 */     this.vote_num = _os_.unmarshal_int();
/*  62 */     this.retcode = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SVoteFailed)) {
/*  72 */       SVoteFailed _o_ = (SVoteFailed)_o1_;
/*  73 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  74 */       if (this.vote_num != _o_.vote_num) return false;
/*  75 */       if (this.retcode != _o_.retcode) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.target_roleid;
/*  84 */     _h_ += this.vote_num;
/*  85 */     _h_ += this.retcode;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.target_roleid).append(",");
/*  93 */     _sb_.append(this.vote_num).append(",");
/*  94 */     _sb_.append(this.retcode).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SVoteFailed _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.vote_num - _o_.vote_num;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.retcode - _o_.retcode;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SVoteFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */