/*     */ package mzm.gsp.gang;
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
/*     */ public class SCombineGangApplyResultBrd
/*     */   extends __SCombineGangApplyResultBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589971;
/*     */   public static final int RESULT_AGREE = 0;
/*     */   public static final int RESULT_REFUSE = 1;
/*     */   public static final int RESULT_TIMEOUT = 2;
/*     */   public long srcid;
/*     */   public long targetid;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589971;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCombineGangApplyResultBrd() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCombineGangApplyResultBrd(long _srcid_, long _targetid_, int _result_)
/*     */   {
/*  42 */     this.srcid = _srcid_;
/*  43 */     this.targetid = _targetid_;
/*  44 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.srcid);
/*  53 */     _os_.marshal(this.targetid);
/*  54 */     _os_.marshal(this.result);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.srcid = _os_.unmarshal_long();
/*  60 */     this.targetid = _os_.unmarshal_long();
/*  61 */     this.result = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SCombineGangApplyResultBrd)) {
/*  71 */       SCombineGangApplyResultBrd _o_ = (SCombineGangApplyResultBrd)_o1_;
/*  72 */       if (this.srcid != _o_.srcid) return false;
/*  73 */       if (this.targetid != _o_.targetid) return false;
/*  74 */       if (this.result != _o_.result) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.srcid;
/*  83 */     _h_ += (int)this.targetid;
/*  84 */     _h_ += this.result;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.srcid).append(",");
/*  92 */     _sb_.append(this.targetid).append(",");
/*  93 */     _sb_.append(this.result).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCombineGangApplyResultBrd _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = Long.signum(this.srcid - _o_.srcid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = Long.signum(this.targetid - _o_.targetid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.result - _o_.result;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SCombineGangApplyResultBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */