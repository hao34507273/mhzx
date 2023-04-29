/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SChatGiftResult
/*     */   extends __SChatGiftResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585263;
/*     */   public static final int CHAT_GIFT_HAVE_LIMIT_WORDS = 0;
/*     */   public static final int CHAT_GIFT_SEND_MAX = 1;
/*     */   public static final int CHAT_GIFT_MONEY_NOT_ENOUGH = 2;
/*     */   public static final int CHAT_GIFT_NOT_FIND_CFG = 3;
/*     */   public static final int CHAT_GIFT_NUM_NOT_MATCH_CFG = 4;
/*     */   public static final int CHAT_GIFT_MONEY_NOT_MATCH = 5;
/*     */   public static final int CHAT_GIFT_ACTIVE_NOT_ENOUGH = 6;
/*     */   public static final int CHAT_GIFT_SERVER_CHANNEL_ERROR = 7;
/*     */   public static final int CHAT_GIFT_CHANNEL_DATA_ERROR = 8;
/*     */   public static final int CHAT_GIFT_NOT_IN_CHANNEL_CAN_NOT_SEND = 9;
/*     */   public static final int CHAT_GIFT_OVER_WORDS_LIMIT = 10;
/*     */   public static final int CHAT_GIFT_OVER_NUM_LIMIT = 11;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585263;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int CHAT_GIFT_MAKE_ERROR = 12;
/*     */   
/*     */   public static final int CHAT_GIFT_CHANNEL_SEND_ERROR = 13;
/*     */   
/*     */   public static final int CHAT_GIFT_NOT_IN_CHANNEL_CAN_NOT_GET = 14;
/*     */   
/*     */   public static final int CHAT_GIFT_NOT_IN_CHANNEL_CAN_NOT_LOOK = 15;
/*     */   
/*     */   public static final int CHAT_GIFT_CHANNEL_TYPE_ERROR = 16;
/*     */   
/*     */   public static final int CHAT_GIFT_DATA_ERROR = 17;
/*     */   
/*     */   public static final int CHAT_GIFT_CHANNEL_NOT_MACTH = 18;
/*     */   
/*     */   public static final int CHAT_GIFT_ALREADY_GET = 19;
/*     */   
/*     */   public static final int CHAT_GIFT_GET_MAX_NUM = 20;
/*     */   
/*     */   public static final int CHAT_GIFT_GET_MONEY_NUM_ERROR = 21;
/*     */   
/*     */   public static final int CHAT_GIFT_GET_MONEY_ERROR = 22;
/*     */   
/*     */   public static final int CHAT_GIFT_ADD_BANGGONG_ERROR = 23;
/*     */   
/*     */   public static final int CHAT_GIFT_GET_NUM_DAY_LIMIT = 24;
/*     */   
/*     */   public int result;
/*     */   public SChatGiftResult() {}
/*     */   
/*     */   public SChatGiftResult(int _result_)
/*     */   {
/*  62 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  70 */     _os_.marshal(this.result);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     this.result = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SChatGiftResult)) {
/*  85 */       SChatGiftResult _o_ = (SChatGiftResult)_o1_;
/*  86 */       if (this.result != _o_.result) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.result;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.result).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChatGiftResult _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.result - _o_.result;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatGiftResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */