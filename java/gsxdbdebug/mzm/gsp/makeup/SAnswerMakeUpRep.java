/*     */ package mzm.gsp.makeup;
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
/*     */ public class SAnswerMakeUpRep
/*     */   extends __SAnswerMakeUpRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625925;
/*     */   public static final int ANSWER_RIGHT = 1;
/*     */   public static final int ANSWER_WRONG = 2;
/*     */   public int activityid;
/*     */   public int optionid;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625925;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerMakeUpRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerMakeUpRep(int _activityid_, int _optionid_, int _res_)
/*     */   {
/*  41 */     this.activityid = _activityid_;
/*  42 */     this.optionid = _optionid_;
/*  43 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.activityid);
/*  52 */     _os_.marshal(this.optionid);
/*  53 */     _os_.marshal(this.res);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activityid = _os_.unmarshal_int();
/*  59 */     this.optionid = _os_.unmarshal_int();
/*  60 */     this.res = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof SAnswerMakeUpRep)) {
/*  70 */       SAnswerMakeUpRep _o_ = (SAnswerMakeUpRep)_o1_;
/*  71 */       if (this.activityid != _o_.activityid) return false;
/*  72 */       if (this.optionid != _o_.optionid) return false;
/*  73 */       if (this.res != _o_.res) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.activityid;
/*  82 */     _h_ += this.optionid;
/*  83 */     _h_ += this.res;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.activityid).append(",");
/*  91 */     _sb_.append(this.optionid).append(",");
/*  92 */     _sb_.append(this.res).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAnswerMakeUpRep _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.activityid - _o_.activityid;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.optionid - _o_.optionid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.res - _o_.res;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\SAnswerMakeUpRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */