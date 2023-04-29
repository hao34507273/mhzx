/*     */ package mzm.gsp.memorycompetition;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SAttendRomanticDanceFail extends __SAttendRomanticDanceFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613137;
/*     */   public static final int TEAM_NOT_EXIST = 1;
/*     */   public static final int ONLY_TEAM_LEADER_CAN_OPEN_GAME = 2;
/*     */   public static final int TEAM_SIZE_NOT_TWO = 3;
/*     */   public static final int TEAM_MEMBER_NOT_NORMAL = 4;
/*     */   public static final int TEAM_LEADER_ALEARDY_IN_GAME = 5;
/*     */   public static final int TEAM_MEMBER_ALEARDY_IN_GAME = 6;
/*     */   public static final int ROMANTIC_DANCE_NOT_AWARD = 7;
/*     */   public static final int ROMANTIC_DANCE_MEMORY_CFG_NOT_EXIST = 8;
/*     */   public static final int ROMANTIC_DANCE_NPC_SERVICE_CHECK_FAIL = 9;
/*     */   public static final int MEMORY_CFG_NOT_EXIST = 10;
/*     */   public static final int ROMANTIC_DANCE_ACTIVITY_CAN_NOT_JOIN = 11;
/*     */   public static final int HARD_RANK_CFG_NOT_EXIST = 12;
/*     */   public static final int LEADER_STATUS_WERONG = 13;
/*     */   public static final int MEMBER_STATUS_WRONG = 14;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12613137;
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
/*     */   public SAttendRomanticDanceFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAttendRomanticDanceFail(int _result_)
/*     */   {
/*  51 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.result);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  64 */     this.result = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SAttendRomanticDanceFail)) {
/*  74 */       SAttendRomanticDanceFail _o_ = (SAttendRomanticDanceFail)_o1_;
/*  75 */       if (this.result != _o_.result) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.result;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.result).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAttendRomanticDanceFail _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.result - _o_.result;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\SAttendRomanticDanceFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */