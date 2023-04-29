/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SAttendPreparePregnancyFail extends __SAttendPreparePregnancyFail__ {
/*     */   public static final int PROTOCOL_TYPE = 12609340;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int CHECK_NPC_SERVICE_ERROR = -3;
/*     */   public static final int INVITER_IS_NOT_IN_TEAM = 1;
/*     */   public static final int TEAM_MEMBER_NUM_ERROR = 2;
/*     */   public static final int INVITER_IS_NOT_TEAM_LEADER = 3;
/*     */   public static final int INVITEE_IS_NOT_TEAM_MEMBER = 4;
/*     */   public static final int TEAM_NOT_EXIST = 5;
/*     */   public static final int NOT_COUPLE = 6;
/*     */   public static final int CAN_NOT_JOIN_ACTIVITY = 7;
/*     */   public static final int INVITE_TIMEOUT = 8;
/*     */   public static final int PARTNER_REFUSE = 9;
/*     */   public static final int CHILD_NUM_TO_UPPER_LIMIT = 10;
/*     */   public static final int BREED_STATE_ERROR = 11;
/*     */   public static final int POINT_TO_UPPER_LIMIT = 12;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12609340;
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
/*     */   public SAttendPreparePregnancyFail() {}
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
/*     */   public SAttendPreparePregnancyFail(int _res_)
/*     */   {
/*  52 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.res);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  65 */     this.res = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SAttendPreparePregnancyFail)) {
/*  75 */       SAttendPreparePregnancyFail _o_ = (SAttendPreparePregnancyFail)_o1_;
/*  76 */       if (this.res != _o_.res) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.res;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.res).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAttendPreparePregnancyFail _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.res - _o_.res;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SAttendPreparePregnancyFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */