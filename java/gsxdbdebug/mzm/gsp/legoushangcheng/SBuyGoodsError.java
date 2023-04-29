/*    */ package mzm.gsp.legoushangcheng;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBuyGoodsError
/*    */   extends __SBuyGoodsError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621313;
/*    */   public static final int BUY_COUNT_ERROR = 1;
/*    */   public static final int MONEY_NOT_ENOUGH = 2;
/*    */   public static final int BAG_IS_FULL = 3;
/*    */   public int errorcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621313;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBuyGoodsError() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBuyGoodsError(int _errorcode_)
/*    */   {
/* 40 */     this.errorcode = _errorcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.errorcode);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.errorcode = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SBuyGoodsError)) {
/* 63 */       SBuyGoodsError _o_ = (SBuyGoodsError)_o1_;
/* 64 */       if (this.errorcode != _o_.errorcode) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.errorcode;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.errorcode).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyGoodsError _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.errorcode - _o_.errorcode;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\SBuyGoodsError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */