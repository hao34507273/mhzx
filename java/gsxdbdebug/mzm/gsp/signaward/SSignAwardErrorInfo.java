/*     */ package mzm.gsp.signaward;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SSignAwardErrorInfo extends __SSignAwardErrorInfo__ {
/*     */   public static final int PROTOCOL_TYPE = 12593411;
/*     */   public static final int SIGN_DAY_FORMAT_ERROR = 1;
/*     */   public static final int SIGN_DAY_ERROR = 2;
/*     */   public static final int LOGIN_DAY_ERROR = 3;
/*     */   public static final int LEVEL_ERROR = 4;
/*     */   public static final int TODAY_SIGNED_ERROR = 5;
/*     */   public static final int ALREADY_GET_LEVEL_BAG = 6;
/*     */   public static final int ALREADY_GET_ONLINE_AWARD = 7;
/*     */   public static final int ONLINE_TIME_NOT_ENOUGH = 8;
/*     */   public static final int AWARD_BEFORE_SIGN_DAY_ERROR = 9;
/*     */   public static final int CELL_NO_ANY_AWARD = 10;
/*     */   public static final int YUAN_BAO_NOT_SAME_WITH_CLIENT = 11;
/*     */   public static final int BOX_BUFF_AWARD_NOT_FOUND = 12;
/*     */   public static final int BOX_BUFF_RANDOM_ERROR = 13;
/*     */   public static final int ROLE_SIGN_INFO_NULL = 14;
/*     */   public static final int CURRENT_CELL_NOT_BOX_AWARD = 15;
/*     */   public static final int NO_RANDOM_LUCKY_BOX = 16;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12593411;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int LUCKY_BOX_NOT_EXIST = 17;
/*     */   
/*     */   public static final int YUAN_BAO_NOT_ENOUGH = 18;
/*     */   
/*     */   public static final int CUT_YUAN_BAO_FAIL = 19;
/*     */   
/*     */   public static final int NO_RANDOM_BUFF = 20;
/*     */   
/*     */   public static final int NEXT_BOX_CELL_TOO_FAR = 21;
/*     */   
/*     */   public static final int NOT_FOUND_NEXT_BOX_CELL = 22;
/*     */   
/*     */   public static final int HAS_BOX_AWARD_NOT_FINISH_DRAW = 23;
/*     */   
/*     */   public static final int HAS_AWARD_NOT_FINISH = 24;
/*     */   
/*     */   public static final int RANDOM_LUCKY_BOX_ERROR = 25;
/*     */   
/*     */   public static final int RANDOM_RESULT_NULL = 26;
/*     */   
/*     */   public static final int RANDOM_RESULT_ITEM_EMPTY = 27;
/*     */   
/*     */   public static final int DELAY_AWARD_ADD_FAIL = 28;
/*     */   
/*     */   public static final int NOW_CAN_NOT_DRAW_LOTTERY = 29;
/*     */   
/*     */   public static final int FIRST_BOX_CAN_NOT_USE_YUAN_BAO = 30;
/*     */   
/*     */   public static final int BUFF_CFG_NOT_EXIST = 31;
/*     */   
/*     */   public static final int LUCKY_BOX_ALEARDY_BUY = 32;
/*     */   
/*     */   public int rescode;
/*     */   
/*     */   public SSignAwardErrorInfo() {}
/*     */   
/*     */   public SSignAwardErrorInfo(int _rescode_)
/*     */   {
/*  69 */     this.rescode = _rescode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  77 */     _os_.marshal(this.rescode);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  82 */     this.rescode = _os_.unmarshal_int();
/*  83 */     if (!_validator_()) {
/*  84 */       throw new VerifyError("validator failed");
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  90 */     if (_o1_ == this) return true;
/*  91 */     if ((_o1_ instanceof SSignAwardErrorInfo)) {
/*  92 */       SSignAwardErrorInfo _o_ = (SSignAwardErrorInfo)_o1_;
/*  93 */       if (this.rescode != _o_.rescode) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.rescode;
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append(this.rescode).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSignAwardErrorInfo _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.rescode - _o_.rescode;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\SSignAwardErrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */