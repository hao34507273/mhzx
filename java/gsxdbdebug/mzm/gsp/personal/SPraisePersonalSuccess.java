/*     */ package mzm.gsp.personal;
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
/*     */ public class SPraisePersonalSuccess
/*     */   extends __SPraisePersonalSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603650;
/*     */   public long roleid;
/*     */   public int praisenum;
/*     */   public int praise;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603650;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SPraisePersonalSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPraisePersonalSuccess(long _roleid_, int _praisenum_, int _praise_)
/*     */   {
/*  38 */     this.roleid = _roleid_;
/*  39 */     this.praisenum = _praisenum_;
/*  40 */     this.praise = _praise_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.roleid);
/*  49 */     _os_.marshal(this.praisenum);
/*  50 */     _os_.marshal(this.praise);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.roleid = _os_.unmarshal_long();
/*  56 */     this.praisenum = _os_.unmarshal_int();
/*  57 */     this.praise = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SPraisePersonalSuccess)) {
/*  67 */       SPraisePersonalSuccess _o_ = (SPraisePersonalSuccess)_o1_;
/*  68 */       if (this.roleid != _o_.roleid) return false;
/*  69 */       if (this.praisenum != _o_.praisenum) return false;
/*  70 */       if (this.praise != _o_.praise) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.roleid;
/*  79 */     _h_ += this.praisenum;
/*  80 */     _h_ += this.praise;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.roleid).append(",");
/*  88 */     _sb_.append(this.praisenum).append(",");
/*  89 */     _sb_.append(this.praise).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPraisePersonalSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.praisenum - _o_.praisenum;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.praise - _o_.praise;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\SPraisePersonalSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */