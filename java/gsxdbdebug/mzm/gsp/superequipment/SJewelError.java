/*    */ package mzm.gsp.superequipment;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SJewelError
/*    */   extends __SJewelError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618762;
/*    */   public static final int MATERIAL_NOT_ENOUGH = 1;
/*    */   public static final int LEVEL_NOT_MATCH = 2;
/*    */   public static final int BAG_ERROR = 5;
/*    */   public static final int ITEM_NOT_EXIST = 7;
/*    */   public static final int BAG_FULL = 8;
/*    */   public static final int MONEY_NOT_ENOUGH = 9;
/*    */   public static final int ITEM_NOT_ENOUGH = 10;
/*    */   public static final int MONEY_ENOUGH_NO_NEED_YUAN_BAO_MAKE_UP = 11;
/*    */   public static final int ADD_COMPOSED_JEWEL_FAIL = 12;
/*    */   public int errorcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12618762;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SJewelError() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SJewelError(int _errorcode_)
/*    */   {
/* 44 */     this.errorcode = _errorcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.errorcode);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.errorcode = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SJewelError)) {
/* 67 */       SJewelError _o_ = (SJewelError)_o1_;
/* 68 */       if (this.errorcode != _o_.errorcode) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.errorcode;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.errorcode).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SJewelError _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.errorcode - _o_.errorcode;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SJewelError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */