/*    */ package mzm.gsp.fabaolingqi;
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
/*    */ public class SUseExchangeItemFail
/*    */   extends __SUseExchangeItemFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618255;
/*    */   public static final int ITEM_NOT_EXISTS = 1;
/*    */   public static final int INVALID_ITEM = 2;
/*    */   public int retcode;
/*    */   public int item_key;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618255;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseExchangeItemFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseExchangeItemFail(int _retcode_, int _item_key_)
/*    */   {
/* 40 */     this.retcode = _retcode_;
/* 41 */     this.item_key = _item_key_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     _os_.marshal(this.item_key);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.retcode = _os_.unmarshal_int();
/* 56 */     this.item_key = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SUseExchangeItemFail)) {
/* 66 */       SUseExchangeItemFail _o_ = (SUseExchangeItemFail)_o1_;
/* 67 */       if (this.retcode != _o_.retcode) return false;
/* 68 */       if (this.item_key != _o_.item_key) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.retcode;
/* 77 */     _h_ += this.item_key;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.retcode).append(",");
/* 85 */     _sb_.append(this.item_key).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseExchangeItemFail _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.retcode - _o_.retcode;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.item_key - _o_.item_key;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SUseExchangeItemFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */