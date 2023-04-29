/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SCommonResultRes
/*    */   extends __SCommonResultRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584981;
/*    */   public static final int GETITEM_FAILED_BAG_FULL = 0;
/*    */   public static final int GETITEM_FAILED_ALREADY_SELLED = 1;
/*    */   public static final int BUYITEM_FAILED_BAG_FULL = 2;
/*    */   public static final int SELLITEM_NEED_MORE_MONEY = 4;
/*    */   public static final int UNLOCK_GRID_NEED_MORE_YUANBAO = 5;
/*    */   public static final int UNLOCK_GRID_SUCCESS = 6;
/*    */   public static final int NOT_ENOUGH_MONEY = 7;
/*    */   public static final int SILVER_TO_MAX = 8;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584981;
/*    */   }
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
/*    */   public SCommonResultRes(int _res_)
/*    */   {
/* 45 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.res);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.res = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SCommonResultRes)) {
/* 68 */       SCommonResultRes _o_ = (SCommonResultRes)_o1_;
/* 69 */       if (this.res != _o_.res) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.res;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.res).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCommonResultRes _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.res - _o_.res;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SCommonResultRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */