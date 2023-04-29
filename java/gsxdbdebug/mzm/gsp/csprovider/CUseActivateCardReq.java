/*    */ package mzm.gsp.csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import gnet.link.Dispatch;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.csprovider.main.PCUseActivateCardReq;
/*    */ 
/*    */ 
/*    */ public class CUseActivateCardReq
/*    */   extends __CUseActivateCardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589319;
/*    */   public String cardnumber;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     Dispatch ctx = (Dispatch)getContext();
/* 20 */     String userid = ctx.userid.getString("UTF-8");
/* 21 */     if (!GameServerInfoManager.canLoginSourceServer(userid)) {
/* 22 */       return;
/*    */     }
/* 24 */     new PCUseActivateCardReq(this).call();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12589319;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUseActivateCardReq()
/*    */   {
/* 38 */     this.cardnumber = "";
/*    */   }
/*    */   
/*    */   public CUseActivateCardReq(String _cardnumber_) {
/* 42 */     this.cardnumber = _cardnumber_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.cardnumber, "UTF-16LE");
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.cardnumber = _os_.unmarshal_String("UTF-16LE");
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CUseActivateCardReq)) {
/* 65 */       CUseActivateCardReq _o_ = (CUseActivateCardReq)_o1_;
/* 66 */       if (!this.cardnumber.equals(_o_.cardnumber)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.cardnumber.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append("T").append(this.cardnumber.length()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\CUseActivateCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */