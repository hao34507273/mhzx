/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SFaBaoAutoRankUpErrorRes
/*    */   extends __SFaBaoAutoRankUpErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596042;
/*    */   public static final int ERROR_UNKNOWN = 1;
/*    */   public static final int ERROR_CFG_NON_EXSIT = 2;
/*    */   public static final int ERROR_FABAO_TYPE = 3;
/*    */   public static final int ERROR_MAX_RANK = 4;
/*    */   public static final int ERROR_LV_NOT_ENOUGH = 5;
/*    */   public static final int ERROR_UPRANK_ITEM = 6;
/*    */   public static final int ERROR_MONEY_NOT_ENOUGH = 7;
/*    */   public static final int ERROR_ITEM_PRICE_CHANGED = 8;
/*    */   public static final int ERROR_ITEM_RANK_ALREADY = 9;
/*    */   public static final int ERROR_IN_CROSS = 10;
/*    */   public static final int ERROR_TARGET_RANK_ILLEGAL = 11;
/*    */   public int resultcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596042;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFaBaoAutoRankUpErrorRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFaBaoAutoRankUpErrorRes(int _resultcode_)
/*    */   {
/* 48 */     this.resultcode = _resultcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.resultcode);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.resultcode = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SFaBaoAutoRankUpErrorRes)) {
/* 71 */       SFaBaoAutoRankUpErrorRes _o_ = (SFaBaoAutoRankUpErrorRes)_o1_;
/* 72 */       if (this.resultcode != _o_.resultcode) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.resultcode;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.resultcode).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFaBaoAutoRankUpErrorRes _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.resultcode - _o_.resultcode;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SFaBaoAutoRankUpErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */