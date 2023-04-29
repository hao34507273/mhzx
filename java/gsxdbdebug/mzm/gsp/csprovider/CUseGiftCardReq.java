/*    */ package mzm.gsp.csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.csprovider.main.PCUseGiftCardReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseGiftCardReq
/*    */   extends __CUseGiftCardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589317;
/*    */   public String cardnumber;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PCUseGiftCardReq(roleId, this.cardnumber));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589317;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUseGiftCardReq()
/*    */   {
/* 34 */     this.cardnumber = "";
/*    */   }
/*    */   
/*    */   public CUseGiftCardReq(String _cardnumber_) {
/* 38 */     this.cardnumber = _cardnumber_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.cardnumber, "UTF-16LE");
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.cardnumber = _os_.unmarshal_String("UTF-16LE");
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CUseGiftCardReq)) {
/* 61 */       CUseGiftCardReq _o_ = (CUseGiftCardReq)_o1_;
/* 62 */       if (!this.cardnumber.equals(_o_.cardnumber)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.cardnumber.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append("T").append(this.cardnumber.length()).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\CUseGiftCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */