/*    */ package mzm.gsp.shanghui;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SCommonResultRes
/*    */   extends __SCommonResultRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592647;
/*    */   public static final int ALL_SELLED = 0;
/*    */   public static final int BUY_TOO_MUCH = 1;
/*    */   public static final int NEED_1DOT5_GOLD = 2;
/*    */   public static final int NEED_MORE_GOLD = 3;
/*    */   public static final int BAG_FULL = 4;
/*    */   public static final int SELL_TOO_MUCH = 5;
/*    */   public static final int FALL_TOO_MUCH = 6;
/*    */   public static final int MULTI_BUY_TOO_MUCH = 7;
/*    */   public static final int MULTI_BUY_OWN_TOO_MUCH = 8;
/*    */   public static final int SELL_ERROR_GOLD_MAX = 50;
/*    */   public static final int GET_ITEM_ERROR_INDEX = 60;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12592647;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCommonResultRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCommonResultRes(int _res_)
/*    */   {
/* 48 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.res);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.res = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SCommonResultRes)) {
/* 71 */       SCommonResultRes _o_ = (SCommonResultRes)_o1_;
/* 72 */       if (this.res != _o_.res) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.res;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.res).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCommonResultRes _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.res - _o_.res;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\SCommonResultRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */