/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SLearnCourseFailed
/*     */   extends __SLearnCourseFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609296;
/*     */   public static final int ERROR_LEARN_LIMIT = -1;
/*     */   public static final int ERROR_VIGOR_NOT_ENOUGH = -2;
/*     */   public static final int ERROR_MONEY_NOT_ENOUGH = -3;
/*     */   public static final int ERROR_INTEREST_LIMIT = -4;
/*     */   public long childid;
/*     */   public int course_type;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609296;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLearnCourseFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLearnCourseFailed(long _childid_, int _course_type_, int _retcode_)
/*     */   {
/*  43 */     this.childid = _childid_;
/*  44 */     this.course_type = _course_type_;
/*  45 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.childid);
/*  54 */     _os_.marshal(this.course_type);
/*  55 */     _os_.marshal(this.retcode);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.childid = _os_.unmarshal_long();
/*  61 */     this.course_type = _os_.unmarshal_int();
/*  62 */     this.retcode = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SLearnCourseFailed)) {
/*  72 */       SLearnCourseFailed _o_ = (SLearnCourseFailed)_o1_;
/*  73 */       if (this.childid != _o_.childid) return false;
/*  74 */       if (this.course_type != _o_.course_type) return false;
/*  75 */       if (this.retcode != _o_.retcode) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.childid;
/*  84 */     _h_ += this.course_type;
/*  85 */     _h_ += this.retcode;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.childid).append(",");
/*  93 */     _sb_.append(this.course_type).append(",");
/*  94 */     _sb_.append(this.retcode).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLearnCourseFailed _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.course_type - _o_.course_type;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.retcode - _o_.retcode;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SLearnCourseFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */