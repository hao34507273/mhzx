/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCommonResultRes extends __SCommonResultRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601369;
/*     */   public static final int GET_ITEM_FAILED_BAG_FULL = 0;
/*     */   public static final int GET_ITEM_FAILED_ALREADY_SELLED = 1;
/*     */   public static final int BUY_ITEM_FAILED_BAG_FULL = 2;
/*     */   public static final int GET_PET_FAILED_BAG_FULL = 3;
/*     */   public static final int GET_PET_FAILED_ALREADY_SELLED = 4;
/*     */   public static final int BUY_PET_FAILED_BAG_FULL = 5;
/*     */   public static final int ON_SHELF_MONEY_NOT_ENOUGH = 6;
/*     */   public static final int ITEM_NOT_IN_SELL = 7;
/*     */   public static final int PET_NOT_IN_SELL = 8;
/*     */   public static final int ITEM_ALL_SELLED = 9;
/*     */   public static final int PET_ALL_SELLED = 10;
/*     */   public static final int GOLD_TO_MAX = 11;
/*     */   public static final int CONCERN_TO_MAX = 12;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601369;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int SUBTYPE_TO_MAX = 13;
/*     */   
/*     */   public static final int PUBLIC_ITEM_CAN_NOT_RESELL = 14;
/*     */   
/*     */   public static final int PUBLIC_PET_CAN_NOT_RESELL = 15;
/*     */   
/*     */   public static final int CAN_NOT_BUY_CONCERN_SELF_ITEM = 16;
/*     */   
/*     */   public static final int CAN_NOT_BUY_CONCERN_SELF_PET = 17;
/*     */   
/*     */   public static final int SEARCH_NUM_TOMAX = 18;
/*     */   
/*     */   public static final int ITEM_OR_PET_CAN_NOT_BUY_OR_SELL = 19;
/*     */   
/*     */   public static final int EQUIP_CUSTOMIZED_CONDITION_ERROR = 20;
/*     */   
/*     */   public static final int PET_CUSTOMIZED_CONDITION_ERROR = 21;
/*     */   
/*     */   public static final int PET_EQUIP_CUSTOMIZED_CONDITION_ERROR = 22;
/*     */   
/*     */   public static final int PET_EQUIP_SEARCH_CONDITION_ERROR = 23;
/*     */   
/*     */   public static final int AUCTION_PRICE_ERROR = 24;
/*     */   
/*     */   public static final int OFFSHELF_NEED_GOLD_ERROR = 25;
/*     */   
/*     */   public int res;
/*     */   
/*     */   public SCommonResultRes() {}
/*     */   
/*     */   public SCommonResultRes(int _res_)
/*     */   {
/*  63 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  71 */     _os_.marshal(this.res);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.res = _os_.unmarshal_int();
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SCommonResultRes)) {
/*  86 */       SCommonResultRes _o_ = (SCommonResultRes)_o1_;
/*  87 */       if (this.res != _o_.res) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.res;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.res).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCommonResultRes _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.res - _o_.res;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SCommonResultRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */