/*     */ package mzm.gsp.questionvoice;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetQuestionVoiceFailRes
/*     */   extends __SGetQuestionVoiceFailRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620805;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_PARAM = -4;
/*     */   public static final int ERROR_NPC_SERVICE = -5;
/*     */   public static final int ERROR_ACTIVITY_CLOSED = -6;
/*     */   public static final int ERROR_NO_QUESTION_COUNT = -7;
/*     */   public int error_code;
/*     */   public ArrayList<String> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620805;
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
/*     */   public SGetQuestionVoiceFailRes()
/*     */   {
/*  42 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetQuestionVoiceFailRes(int _error_code_, ArrayList<String> _params_) {
/*  46 */     this.error_code = _error_code_;
/*  47 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.error_code);
/*  56 */     _os_.compact_uint32(this.params.size());
/*  57 */     for (String _v_ : this.params) {
/*  58 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.error_code = _os_.unmarshal_int();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  68 */       this.params.add(_v_);
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SGetQuestionVoiceFailRes)) {
/*  79 */       SGetQuestionVoiceFailRes _o_ = (SGetQuestionVoiceFailRes)_o1_;
/*  80 */       if (this.error_code != _o_.error_code) return false;
/*  81 */       if (!this.params.equals(_o_.params)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.error_code;
/*  90 */     _h_ += this.params.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.error_code).append(",");
/*  98 */     _sb_.append(this.params).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\SGetQuestionVoiceFailRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */