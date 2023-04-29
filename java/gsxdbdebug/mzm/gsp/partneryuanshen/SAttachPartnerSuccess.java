/*    */ package mzm.gsp.partneryuanshen;
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
/*    */ 
/*    */ 
/*    */ public class SAttachPartnerSuccess
/*    */   extends __SAttachPartnerSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621058;
/*    */   public int position;
/*    */   public int partner_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621058;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAttachPartnerSuccess() {}
/*    */   
/*    */ 
/*    */   public SAttachPartnerSuccess(int _position_, int _partner_id_)
/*    */   {
/* 37 */     this.position = _position_;
/* 38 */     this.partner_id = _partner_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.position);
/* 47 */     _os_.marshal(this.partner_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.position = _os_.unmarshal_int();
/* 53 */     this.partner_id = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SAttachPartnerSuccess)) {
/* 63 */       SAttachPartnerSuccess _o_ = (SAttachPartnerSuccess)_o1_;
/* 64 */       if (this.position != _o_.position) return false;
/* 65 */       if (this.partner_id != _o_.partner_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.position;
/* 74 */     _h_ += this.partner_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.position).append(",");
/* 82 */     _sb_.append(this.partner_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAttachPartnerSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.position - _o_.position;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.partner_id - _o_.partner_id;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\SAttachPartnerSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */