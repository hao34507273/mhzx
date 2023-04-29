/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SAnswerDrawAndGuessQuestionFailRep extends __SAnswerDrawAndGuessQuestionFailRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617246;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_DRAWER_CANNOT_ANSWER = -4;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -5;
/*     */   public static final int ERROR_NOT_IN_TEAM = -6;
/*     */   public static final int ERROR_TIME_OUT = -7;
/*     */   public static final int ERROR_ANSWER_ILLEGAL = -8;
/*     */   public static final int ERROR_NOT_IN_GAME = -9;
/*     */   public static final int ERROR_HAS_SENSITIVE_WORDS = -10;
/*     */   public static final int ERROR_ANSWER_TOO_QUICK = -11;
/*     */   public int error_code;
/*     */   public ArrayList<String> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617246;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerDrawAndGuessQuestionFailRep()
/*     */   {
/*  46 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAnswerDrawAndGuessQuestionFailRep(int _error_code_, ArrayList<String> _params_) {
/*  50 */     this.error_code = _error_code_;
/*  51 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.error_code);
/*  60 */     _os_.compact_uint32(this.params.size());
/*  61 */     for (String _v_ : this.params) {
/*  62 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  68 */     this.error_code = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  72 */       this.params.add(_v_);
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SAnswerDrawAndGuessQuestionFailRep)) {
/*  83 */       SAnswerDrawAndGuessQuestionFailRep _o_ = (SAnswerDrawAndGuessQuestionFailRep)_o1_;
/*  84 */       if (this.error_code != _o_.error_code) return false;
/*  85 */       if (!this.params.equals(_o_.params)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.error_code;
/*  94 */     _h_ += this.params.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.error_code).append(",");
/* 102 */     _sb_.append(this.params).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SAnswerDrawAndGuessQuestionFailRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */