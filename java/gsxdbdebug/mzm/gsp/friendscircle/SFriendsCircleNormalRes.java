/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SFriendsCircleNormalRes extends __SFriendsCircleNormalRes__ {
/*     */   public static final int PROTOCOL_TYPE = 12625423;
/*     */   public static final int FRIENDS_CIRCLE_NOT_OPEN = 1;
/*     */   public static final int BUY_TREASURE_NOT_OPEN = 2;
/*     */   public static final int TREAD_NOT_OPEN = 3;
/*     */   public static final int GIVE_PRESENT_NOT_OPEN = 4;
/*     */   public static final int PLACE_TREASURE_BOX_NUM_LIMIT = 5;
/*     */   public static final int USER_ID_NULL = 6;
/*     */   public static final int CURRENCY_NOT_EQUAL_WITH_SERVER = 7;
/*     */   public static final int CURRENCY_NOT_ENOUGH = 8;
/*     */   public static final int CUT_CURRENCY_FAIL = 9;
/*     */   public static final int BUY_COUNT_NOT_VALID = 10;
/*     */   public static final int BUY_TREASURE_TOO_MANY = 11;
/*     */   public static final int ITEM_NOT_EXIST = 12;
/*     */   public static final int ITEM_NOT_FRIENDS_CIRCLE_ITEM = 13;
/*     */   public static final int ALEARDY_HAS_FRIENDS_CIRCLE_ITEM = 14;
/*     */   public static final int CUT_ITEM_ERROR = 15;
/*     */   public static final int REPLACE_ITEM_SAME_ERROR = 16;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12625423;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int NOT_OWN_ITEM_ERROR = 17;
/*     */   
/*     */   public static final int ORNAMENT_ITEM_TYPE_ERROR = 18;
/*     */   
/*     */   public static final int BE_TROD_USER_ID_NOT_FOUND = 19;
/*     */   
/*     */   public static final int TREAD_USER_TIMES_LIMIT = 20;
/*     */   
/*     */   public static final int TREASURE_BOX_AWARD_FAIL = 21;
/*     */   
/*     */   public static final int REMOVE_GIFT_ITEM_FAIL = 22;
/*     */   
/*     */   public static final int ITEM_NOT_ENOUGH_AND_NOT_USE_YUANBAO = 23;
/*     */   
/*     */   public static final int ITEM_ENOUGH_AND_USE_YUANBAO = 24;
/*     */   
/*     */   public static final int ITEM_NOT_GIFT = 25;
/*     */   
/*     */   public static final int GIFT_NOT_GRADE = 26;
/*     */   
/*     */   public static final int ITEM_NOT_GRADE = 27;
/*     */   
/*     */   public static final int GIVE_CFG_NOT_EXIST = 28;
/*     */   
/*     */   public static final int ITEM_NOT_POPULARITY = 29;
/*     */   
/*     */   public static final int GIVE_GIFT_USER_ID_NOT_FOUND = 30;
/*     */   
/*     */   public static final int CROSS_SERVER_TREAD_RESULT_ERROR = 31;
/*     */   
/*     */   public static final int TREAD_SERIAL_NOU_FOUND = 32;
/*     */   
/*     */   public static final int TREAD_CONTEXT_NOT_MATCH = 33;
/*     */   
/*     */   public static final int ALEARDY_DEAL = 34;
/*     */   public static final int PLACE_TREASURE_BOX_RECORD_NOT_FOUND = 35;
/*     */   public static final int PLACE_TREASURE_BOX_CONTEXT_NOT_MATCH = 36;
/*     */   public static final int GIVE_GIFT_MESSAGE_TOO_LONG = 37;
/*     */   public static final int GIVE_GIFT_MESSAGE_SENSITIVE = 38;
/*     */   public static final int GIVE_ITEM_RECORD_NOT_FOUND = 39;
/*     */   public static final int GIVE_ITEM_CONTEXT_NOT_MATCH = 40;
/*     */   public static final int GIVE_ITEM_NUM_NOT_MATCH = 41;
/*     */   public static final int GIVE_ITEM_ERROR = 42;
/*     */   public static final int RANK_NUM_ERROR = 43;
/*     */   public static final int ROLE_LEVEL_FRIENDS_CIRCLE_ERROR = 44;
/*     */   public static final int ROLE_LEVEL_TREAD_ERROR = 45;
/*     */   public static final int ROLE_LEVEL_GIVE_GIFT_ERROR = 46;
/*     */   public static final int STATUS_ERROR = 47;
/*     */   public static final int SERIAL_CROSS_SERVER_STATUE_ERROR = 48;
/*     */   public static final int SSP_NOT_REPLY_ERROR = 49;
/*     */   public static final int ORNAMENT_NOT_OPEN = 50;
/*     */   public static final int WEEK_POPULARITY_HANDLE = 51;
/*     */   public static final int FRIENDS_CIRCLE_CHART_NOT_OPEN = 52;
/*     */   public static final int FRIENDS_CIRCLE_CROSS_SERVER_TREAD_NOT_OPEN = 53;
/*     */   public static final int FRIENDS_CIRCLE_CROSS_SERVER_GIFT_NOT_OPEN = 54;
/*     */   public static final int FRIENDS_CIRCLE_CROSS_SERVER_TREADING = 55;
/*     */   public static final int FRIENDS_CIRCLE_PARAMETER_ERROR = 56;
/*     */   public static final int FRIENDS_CIRCLE_BLACK_USER_ERROR = 57;
/*     */   public static final int FRIENDS_CIRCLE_BLACK_MAX_ERROR = 58;
/*     */   public static final int FRIENDS_CIRCLE_ALEARDY_BLACK_ERROR = 59;
/*     */   public static final int NOT_IN_BLACK_ERROR = 60;
/*     */   public static final int CROSS_SERVER_BLACK_NOT_OPEN_ERROR = 61;
/*     */   public static final int CROSS_SERVER_SERVER_ID_ERROR = 62;
/*     */   public static final int CROSS_SERVER_REPEAT_BLACK_ERROR = 63;
/*     */   public static final int ROLE_IN_BLACK_ERROR = 64;
/*     */   public static final int ROLE_BE_BLACKED_ERROR = 65;
/*     */   public static final int NET_ERROR = 66;
/*     */   public static final int CLIENT_NEED_YUAN_BAO_NOT_SAME = 67;
/*     */   public static final int TARGET_REPAIR_DATA_NOT_DO_TREAD = 68;
/*     */   public static final int TARGET_REPAIR_DATA_NOT_DO_GIFT = 69;
/*     */   public int ret;
/*     */   public SFriendsCircleNormalRes() {}
/*     */   
/*     */   public SFriendsCircleNormalRes(int _ret_)
/*     */   {
/* 106 */     this.ret = _ret_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 110 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 114 */     _os_.marshal(this.ret);
/* 115 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 119 */     this.ret = _os_.unmarshal_int();
/* 120 */     if (!_validator_()) {
/* 121 */       throw new VerifyError("validator failed");
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 127 */     if (_o1_ == this) return true;
/* 128 */     if ((_o1_ instanceof SFriendsCircleNormalRes)) {
/* 129 */       SFriendsCircleNormalRes _o_ = (SFriendsCircleNormalRes)_o1_;
/* 130 */       if (this.ret != _o_.ret) return false;
/* 131 */       return true;
/*     */     }
/* 133 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 137 */     int _h_ = 0;
/* 138 */     _h_ += this.ret;
/* 139 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 143 */     StringBuilder _sb_ = new StringBuilder();
/* 144 */     _sb_.append("(");
/* 145 */     _sb_.append(this.ret).append(",");
/* 146 */     _sb_.append(")");
/* 147 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFriendsCircleNormalRes _o_) {
/* 151 */     if (_o_ == this) return 0;
/* 152 */     int _c_ = 0;
/* 153 */     _c_ = this.ret - _o_.ret;
/* 154 */     if (0 != _c_) return _c_;
/* 155 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SFriendsCircleNormalRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */