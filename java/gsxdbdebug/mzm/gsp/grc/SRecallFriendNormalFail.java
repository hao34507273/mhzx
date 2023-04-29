/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SRecallFriendNormalFail extends __SRecallFriendNormalFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600361;
/*     */   public static final int ERROR_NOT_RECALL_BACK = 1;
/*     */   public static final int ERROR_BIG_GIFT_ALEARDY_AWARDED = 2;
/*     */   public static final int ERROR_BIG_GIFT_AWARDED_FAILED = 3;
/*     */   public static final int ERROR_RECALL_NUM_NOT_ENOUGH = 4;
/*     */   public static final int ERROR_RECALL_NUM_TOO_MANEY_AWARD_NOT_EXIST = 5;
/*     */   public static final int ERROR_RECALL_NUM_NOT_CONTINUATION = 6;
/*     */   public static final int ERROR_RECALL_NUM_AWARD_FAIL = 7;
/*     */   public static final int ERROR_RECALL_SIGN_EXPIRED = 8;
/*     */   public static final int ERROR_RECALL_USER_NOT_EXIST = 9;
/*     */   public static final int ERROR_RECALL_OPEN_ID_NOT_MATCH = 10;
/*     */   public static final int ERROR_RECALL_TIMES_NOT_ENOUGH = 11;
/*     */   public static final int ERROR_BE_RECALL_TOO_MANY = 12;
/*     */   public static final int ERROR_RECALL_SIGN_ALEARDY = 13;
/*     */   public static final int ERROR_RECALL_SIGN_DAY_NOT_EXIST = 14;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600361;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ERROR_RECALL_SIGN_DAY_AWARDED_FAILED = 15;
/*     */   
/*     */   public static final int ERROR_RECALL_SIGN_DAY_NOT_TODAY = 16;
/*     */   
/*     */   public static final int ERROR_RECALL_REPEAT_IN_ONE_PERIOD = 17;
/*     */   
/*     */   public static final int ERROR_RECALL_REPEAT_NOT_IN_SAME_ZONE = 18;
/*     */   
/*     */   public static final int ERROR_RECALL_FRIEND_AWARD_FAIL = 19;
/*     */   
/*     */   public static final int ERROR_RECALL_FRIEND_CAN_NOT = 20;
/*     */   
/*     */   public static final int ERROR_RECALL_FRIEND_SWITCH_NOT_OPEN = 21;
/*     */   
/*     */   public static final int ERROR_RECALL_REDIS_LOCK_FAILED = 22;
/*     */   
/*     */   public static final int ERROR_RECALL_TODAY_FILED = 23;
/*     */   
/*     */   public static final int ERROR_RECALL_FRIEND_FILLED = 24;
/*     */   
/*     */   public static final int ERROR_RECALL_LOGIN_TIME_FIELD = 25;
/*     */   
/*     */   public static final int ERROR_RECALL_LOGIN_TIME = 26;
/*     */   
/*     */   public static final int ERROR_RECALL_MAX_LEVEL_FIELD = 27;
/*     */   
/*     */   public static final int ERROR_RECALL_MAX_LEVEL = 28;
/*     */   
/*     */   public int result;
/*     */   
/*     */   public SRecallFriendNormalFail() {}
/*     */   
/*     */   public SRecallFriendNormalFail(int _result_)
/*     */   {
/*  65 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  73 */     _os_.marshal(this.result);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  78 */     this.result = _os_.unmarshal_int();
/*  79 */     if (!_validator_()) {
/*  80 */       throw new VerifyError("validator failed");
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof SRecallFriendNormalFail)) {
/*  88 */       SRecallFriendNormalFail _o_ = (SRecallFriendNormalFail)_o1_;
/*  89 */       if (this.result != _o_.result) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.result;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.result).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SRecallFriendNormalFail _o_) {
/* 110 */     if (_o_ == this) return 0;
/* 111 */     int _c_ = 0;
/* 112 */     _c_ = this.result - _o_.result;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SRecallFriendNormalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */