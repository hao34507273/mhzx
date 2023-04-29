/*     */ package mzm.gsp.memorycompetition;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SMemoryCompetitionNormalFail extends __SMemoryCompetitionNormalFail__ {
/*     */   public static final int PROTOCOL_TYPE = 12613122;
/*     */   public static final int NOT_IN_GAME = 1;
/*     */   public static final int GAME_UNIQUE_ID_NOT_EXIST = 2;
/*     */   public static final int THE_QUESTION_ALEARDY_OVER = 3;
/*     */   public static final int ALEARDY_SEEK_HELP = 4;
/*     */   public static final int ALEARDY_ANSWER = 5;
/*     */   public static final int SEEK_HELP_TIMES_NOT_ENOUGH = 6;
/*     */   public static final int SEEK_HELP_ROIE_ID_NOT_IN_GAME = 7;
/*     */   public static final int SEEK_HELP_ROIL_NOT_SEEK_HELP = 8;
/*     */   public static final int ALEARDY_BE_HELPED = 9;
/*     */   public static final int QUESTION_ALEARDY_ANSERED = 10;
/*     */   public static final int MEMORY_CFG_NOT_EXIST = 11;
/*     */   public static final int NOT_SEEK_HELP = 12;
/*     */   public static final int NOT_FOUND_QUESTION_INFO = 13;
/*     */   public static final int TIME_OUT = 14;
/*     */   public static final int MAPPING_CFG_NOT_EXIST = 15;
/*     */   public static final int RANDOM_QUESTION_ERROR = 16;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12613122; }
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
/*     */   public SMemoryCompetitionNormalFail() {}
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
/*     */   public SMemoryCompetitionNormalFail(int _result_)
/*     */   {
/*  53 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.result);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  66 */     this.result = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SMemoryCompetitionNormalFail)) {
/*  76 */       SMemoryCompetitionNormalFail _o_ = (SMemoryCompetitionNormalFail)_o1_;
/*  77 */       if (this.result != _o_.result) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.result;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.result).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMemoryCompetitionNormalFail _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.result - _o_.result;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\SMemoryCompetitionNormalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */