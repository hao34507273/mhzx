/*    */ package mzm.gsp.grc;
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
/*    */ public class SGrcSendGiftResp
/*    */   extends __SGrcSendGiftResp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600334;
/*    */   public int retcode;
/*    */   public int gift_type;
/*    */   public Octets to;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600334;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGrcSendGiftResp()
/*    */   {
/* 35 */     this.to = new Octets();
/*    */   }
/*    */   
/*    */   public SGrcSendGiftResp(int _retcode_, int _gift_type_, Octets _to_) {
/* 39 */     this.retcode = _retcode_;
/* 40 */     this.gift_type = _gift_type_;
/* 41 */     this.to = _to_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     _os_.marshal(this.gift_type);
/* 51 */     _os_.marshal(this.to);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.retcode = _os_.unmarshal_int();
/* 57 */     this.gift_type = _os_.unmarshal_int();
/* 58 */     this.to = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SGrcSendGiftResp)) {
/* 68 */       SGrcSendGiftResp _o_ = (SGrcSendGiftResp)_o1_;
/* 69 */       if (this.retcode != _o_.retcode) return false;
/* 70 */       if (this.gift_type != _o_.gift_type) return false;
/* 71 */       if (!this.to.equals(_o_.to)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.retcode;
/* 80 */     _h_ += this.gift_type;
/* 81 */     _h_ += this.to.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.retcode).append(",");
/* 89 */     _sb_.append(this.gift_type).append(",");
/* 90 */     _sb_.append("B").append(this.to.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGrcSendGiftResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */