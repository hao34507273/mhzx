/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFinishCourseFailed
/*     */   extends __SFinishCourseFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609309;
/*     */   public static final int ERROR_LEARN_LIMIT = -1;
/*     */   public static final int ERROR_VIGOR_NOT_ENOUGH = -2;
/*     */   public static final int ERROR_MONEY_NOT_ENOUGH = -3;
/*     */   public static final int ERROR_YUANBAO_NOT_ENOUGH = -4;
/*     */   public static final int ERROR_INTEREST_LIMIT = -5;
/*     */   public long childid;
/*     */   public int course_type;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609309;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFinishCourseFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFinishCourseFailed(long _childid_, int _course_type_, int _retcode_)
/*     */   {
/*  44 */     this.childid = _childid_;
/*  45 */     this.course_type = _course_type_;
/*  46 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.childid);
/*  55 */     _os_.marshal(this.course_type);
/*  56 */     _os_.marshal(this.retcode);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.childid = _os_.unmarshal_long();
/*  62 */     this.course_type = _os_.unmarshal_int();
/*  63 */     this.retcode = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SFinishCourseFailed)) {
/*  73 */       SFinishCourseFailed _o_ = (SFinishCourseFailed)_o1_;
/*  74 */       if (this.childid != _o_.childid) return false;
/*  75 */       if (this.course_type != _o_.course_type) return false;
/*  76 */       if (this.retcode != _o_.retcode) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.childid;
/*  85 */     _h_ += this.course_type;
/*  86 */     _h_ += this.retcode;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.childid).append(",");
/*  94 */     _sb_.append(this.course_type).append(",");
/*  95 */     _sb_.append(this.retcode).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFinishCourseFailed _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.course_type - _o_.course_type;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.retcode - _o_.retcode;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SFinishCourseFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */