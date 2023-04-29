/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SCommonResultRes
/*     */   extends __SCommonResultRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605453;
/*     */   public static final int PET_ROOM_LEVEL_TO_MAX = 1;
/*     */   public static final int BED_ROOM_LEVEL_TO_MAX = 2;
/*     */   public static final int DRUG_ROOM_LEVEL_TO_MAX = 3;
/*     */   public static final int KITCHEN_LEVEL_TO_MAX = 4;
/*     */   public static final int MAID_ROOM_LEVEL_TO_MAX = 5;
/*     */   public static final int BUY_NUM_TO_MAX = 6;
/*     */   public static final int BUY_ITEM_TIME_OUT = 7;
/*     */   public static final int NOT_HOME_OWNER = 8;
/*     */   public static final int DAY_CLEAN_COUNT_TO_MAX = 9;
/*     */   public static final int CLEANLINESS_TO_MAX = 10;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605453;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int TRAIN_PET_COUNT_TO_MAX = 11;
/*     */   
/*     */   public static final int ADD_VIGOR_COUNT_TO_MAX = 12;
/*     */   
/*     */   public static final int ADD_BAOSHIDU_COUNT_TO_MAX = 13;
/*     */   
/*     */   public static final int ALREADY_HAS_HOME = 14;
/*     */   
/*     */   public static final int HOME_ROLE_NUM_TO_MAX_CAN_NOT_ACCESS = 15;
/*     */   
/*     */   public static final int HOME_ROLE_NUM_TO_MAX_CAN_NOT_GO_BACK_WITH_TEAM = 16;
/*     */   
/*     */   public static final int NO_HOME_CAN_NOT_USE_DURNITURE_ITEM = 17;
/*     */   
/*     */   public static final int VIGOR_TO_MAX = 18;
/*     */   
/*     */   public static final int HOME_ROLE_NUM_TO_MAX_CAN_NOT_RETURN_TEAM = 19;
/*     */   
/*     */   public static final int BAOSHIDU_TO_MAX = 20;
/*     */   
/*     */   public static final int TEAM_IN_HOMELAND_CAN_NOT_TRANSFER = 21;
/*     */   
/*     */   public static final int ROLE_IN_HOMELAND_CAN_NOT_TRANSFER = 22;
/*     */   public static final int NO_HOME = 23;
/*     */   public static final int COURT_LEVEL_UP_NOT_OPEN = 24;
/*     */   public static final int USER_ID_NULL = 25;
/*     */   public static final int NOT_AT_HOME = 26;
/*     */   public static final int HOME_LEVEL_CFG_NOT_FOUND = 27;
/*     */   public static final int COURT_LEVEL_CFG_NOT_FOUND = 28;
/*     */   public static final int COURT_LEVEL_MAX = 29;
/*     */   public static final int COURT_LEVEL_UP_CUT_FAIL = 30;
/*     */   public static final int CLEAN_YARD_CUT_FAIL = 31;
/*     */   public static final int CLEAN_YARD_MONEY_NUM_LESS_THAN_ZERO = 32;
/*     */   public static final int UUID_ITEM_NOT_OWN = 33;
/*     */   public static final int ITEM_CFG_ID_NOT_OWN = 34;
/*     */   public static final int ITEM_CFG_ID_NOT_FIND = 35;
/*     */   public static final int COURT_YARD_FURNITURE_CAN_NOT_REPLACE = 36;
/*     */   public static final int COURT_YARD_FURNITURE_REPLACE_NOT_FIND_OLD = 37;
/*     */   public static final int HOME_FUNCTION_NOT_OPEN = 38;
/*     */   public static final int USER_DATA_IS_NULL = 39;
/*     */   public static final int ROLE_HOME_OPERATOR_IS_NULL = 40;
/*     */   public static final int FURNITURE_CAN_NOT_RECYCLE = 41;
/*     */   public static final int FURNITURE_CFG_CAN_NOT_RECYCLE = 42;
/*     */   public static final int FURNITURE_CFG_PROPRIETARY_CAN_NOT_RECYCLE = 43;
/*     */   public static final int STATUS_CAN_NOT_DO_THIS = 44;
/*     */   public int res;
/*     */   public SCommonResultRes() {}
/*     */   
/*     */   public SCommonResultRes(int _res_)
/*     */   {
/*  81 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  89 */     _os_.marshal(this.res);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  94 */     this.res = _os_.unmarshal_int();
/*  95 */     if (!_validator_()) {
/*  96 */       throw new VerifyError("validator failed");
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 102 */     if (_o1_ == this) return true;
/* 103 */     if ((_o1_ instanceof SCommonResultRes)) {
/* 104 */       SCommonResultRes _o_ = (SCommonResultRes)_o1_;
/* 105 */       if (this.res != _o_.res) return false;
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 112 */     int _h_ = 0;
/* 113 */     _h_ += this.res;
/* 114 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 118 */     StringBuilder _sb_ = new StringBuilder();
/* 119 */     _sb_.append("(");
/* 120 */     _sb_.append(this.res).append(",");
/* 121 */     _sb_.append(")");
/* 122 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCommonResultRes _o_) {
/* 126 */     if (_o_ == this) return 0;
/* 127 */     int _c_ = 0;
/* 128 */     _c_ = this.res - _o_.res;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SCommonResultRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */