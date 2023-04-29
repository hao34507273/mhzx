/*    */ package mzm.gsp.prison;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SJailDeliveryError
/*    */   extends __SJailDeliveryError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620038;
/*    */   public int errorcode;
/*    */   public Octets savedname;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620038;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SJailDeliveryError()
/*    */   {
/* 34 */     this.savedname = new Octets();
/*    */   }
/*    */   
/*    */   public SJailDeliveryError(int _errorcode_, Octets _savedname_) {
/* 38 */     this.errorcode = _errorcode_;
/* 39 */     this.savedname = _savedname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.errorcode);
/* 48 */     _os_.marshal(this.savedname);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.errorcode = _os_.unmarshal_int();
/* 54 */     this.savedname = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SJailDeliveryError)) {
/* 64 */       SJailDeliveryError _o_ = (SJailDeliveryError)_o1_;
/* 65 */       if (this.errorcode != _o_.errorcode) return false;
/* 66 */       if (!this.savedname.equals(_o_.savedname)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.errorcode;
/* 75 */     _h_ += this.savedname.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.errorcode).append(",");
/* 83 */     _sb_.append("B").append(this.savedname.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\SJailDeliveryError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */