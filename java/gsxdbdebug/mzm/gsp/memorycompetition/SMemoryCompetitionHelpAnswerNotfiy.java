/*     */ package mzm.gsp.memorycompetition;
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
/*     */ public class SMemoryCompetitionHelpAnswerNotfiy
/*     */   extends __SMemoryCompetitionHelpAnswerNotfiy__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613132;
/*     */   public int activity_cfg_id;
/*     */   public long active_help_role_id;
/*     */   public int answer_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613132;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SMemoryCompetitionHelpAnswerNotfiy() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMemoryCompetitionHelpAnswerNotfiy(int _activity_cfg_id_, long _active_help_role_id_, int _answer_id_)
/*     */   {
/*  38 */     this.activity_cfg_id = _activity_cfg_id_;
/*  39 */     this.active_help_role_id = _active_help_role_id_;
/*  40 */     this.answer_id = _answer_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_cfg_id);
/*  49 */     _os_.marshal(this.active_help_role_id);
/*  50 */     _os_.marshal(this.answer_id);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  56 */     this.active_help_role_id = _os_.unmarshal_long();
/*  57 */     this.answer_id = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SMemoryCompetitionHelpAnswerNotfiy)) {
/*  67 */       SMemoryCompetitionHelpAnswerNotfiy _o_ = (SMemoryCompetitionHelpAnswerNotfiy)_o1_;
/*  68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  69 */       if (this.active_help_role_id != _o_.active_help_role_id) return false;
/*  70 */       if (this.answer_id != _o_.answer_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activity_cfg_id;
/*  79 */     _h_ += (int)this.active_help_role_id;
/*  80 */     _h_ += this.answer_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfg_id).append(",");
/*  88 */     _sb_.append(this.active_help_role_id).append(",");
/*  89 */     _sb_.append(this.answer_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMemoryCompetitionHelpAnswerNotfiy _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.active_help_role_id - _o_.active_help_role_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.answer_id - _o_.answer_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\SMemoryCompetitionHelpAnswerNotfiy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */