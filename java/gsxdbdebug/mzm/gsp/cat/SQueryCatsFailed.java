/*     */ package mzm.gsp.cat;
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
/*     */ public class SQueryCatsFailed
/*     */   extends __SQueryCatsFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605712;
/*     */   public static final int ERROR_NOT_EXIST = -1;
/*     */   public long target_roleid;
/*     */   public long catid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605712;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryCatsFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryCatsFailed(long _target_roleid_, long _catid_, int _retcode_)
/*     */   {
/*  40 */     this.target_roleid = _target_roleid_;
/*  41 */     this.catid = _catid_;
/*  42 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.target_roleid);
/*  51 */     _os_.marshal(this.catid);
/*  52 */     _os_.marshal(this.retcode);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.target_roleid = _os_.unmarshal_long();
/*  58 */     this.catid = _os_.unmarshal_long();
/*  59 */     this.retcode = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SQueryCatsFailed)) {
/*  69 */       SQueryCatsFailed _o_ = (SQueryCatsFailed)_o1_;
/*  70 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  71 */       if (this.catid != _o_.catid) return false;
/*  72 */       if (this.retcode != _o_.retcode) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.target_roleid;
/*  81 */     _h_ += (int)this.catid;
/*  82 */     _h_ += this.retcode;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.target_roleid).append(",");
/*  90 */     _sb_.append(this.catid).append(",");
/*  91 */     _sb_.append(this.retcode).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SQueryCatsFailed _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.catid - _o_.catid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.retcode - _o_.retcode;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SQueryCatsFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */