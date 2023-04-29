/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SAnswerAttendPreparePregnancyInviteFail extends __SAnswerAttendPreparePregnancyInviteFail__ {
/*     */   public static final int PROTOCOL_TYPE = 12609344;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int SESSION_CONTEXT_NOT_MATCH = -4;
/*     */   public static final int INVITER_IS_NOT_IN_TEAM = 1;
/*     */   public static final int TEAM_MEMBER_NUM_ERROR = 2;
/*     */   public static final int INVITER_IS_NOT_TEAM_LEADER = 3;
/*     */   public static final int INVITEE_IS_NOT_TEAM_MEMBER = 4;
/*     */   public static final int TEAM_NOT_EXIST = 5;
/*     */   public static final int NOT_COUPLE = 6;
/*     */   public static final int CAN_NOT_JOIN_ACTIVITY = 7;
/*     */   public static final int INVITE_TIMEOUT = 8;
/*     */   public static final int OTHER_GAME_NOT_OVER = 9;
/*     */   public static final int CHILD_NUM_TO_UPPER_LIMIT = 10;
/*     */   public static final int BREED_STATE_ERROR = 11;
/*     */   public static final int POINT_TO_UPPER_LIMIT = 12;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12609344; }
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
/*     */   public SAnswerAttendPreparePregnancyInviteFail() {}
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
/*     */   public SAnswerAttendPreparePregnancyInviteFail(int _res_)
/*     */   {
/*  53 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.res);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  66 */     this.res = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SAnswerAttendPreparePregnancyInviteFail)) {
/*  76 */       SAnswerAttendPreparePregnancyInviteFail _o_ = (SAnswerAttendPreparePregnancyInviteFail)_o1_;
/*  77 */       if (this.res != _o_.res) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.res;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.res).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAnswerAttendPreparePregnancyInviteFail _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.res - _o_.res;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SAnswerAttendPreparePregnancyInviteFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */