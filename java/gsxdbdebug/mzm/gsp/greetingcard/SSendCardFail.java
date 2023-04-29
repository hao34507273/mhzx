/*    */ package mzm.gsp.greetingcard;
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
/*    */ public class SSendCardFail
/*    */   extends __SSendCardFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616451;
/*    */   public static final int WRONG_TYPE = 1;
/*    */   public static final int NOT_EXISTS = 2;
/*    */   public static final int WRONG_CHANNEL = 3;
/*    */   public static final int NOT_IN_GANG = 4;
/*    */   public int retcode;
/*    */   public int item_key;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616451;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSendCardFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSendCardFail(int _retcode_, int _item_key_)
/*    */   {
/* 42 */     this.retcode = _retcode_;
/* 43 */     this.item_key = _item_key_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     _os_.marshal(this.item_key);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.retcode = _os_.unmarshal_int();
/* 58 */     this.item_key = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SSendCardFail)) {
/* 68 */       SSendCardFail _o_ = (SSendCardFail)_o1_;
/* 69 */       if (this.retcode != _o_.retcode) return false;
/* 70 */       if (this.item_key != _o_.item_key) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.retcode;
/* 79 */     _h_ += this.item_key;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.retcode).append(",");
/* 87 */     _sb_.append(this.item_key).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSendCardFail _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.retcode - _o_.retcode;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.item_key - _o_.item_key;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\SSendCardFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */