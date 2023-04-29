/*    */ package mzm.gsp.partneryuanshen;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.partneryuanshen.main.PAttachPartner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAttachPartnerReq
/*    */   extends __CAttachPartnerReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621062;
/*    */   public int position;
/*    */   public int partner_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PAttachPartner(roleId, this.position, this.partner_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12621062;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAttachPartnerReq() {}
/*    */   
/*    */ 
/*    */   public CAttachPartnerReq(int _position_, int _partner_id_)
/*    */   {
/* 38 */     this.position = _position_;
/* 39 */     this.partner_id = _partner_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.position);
/* 48 */     _os_.marshal(this.partner_id);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.position = _os_.unmarshal_int();
/* 54 */     this.partner_id = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CAttachPartnerReq)) {
/* 64 */       CAttachPartnerReq _o_ = (CAttachPartnerReq)_o1_;
/* 65 */       if (this.position != _o_.position) return false;
/* 66 */       if (this.partner_id != _o_.partner_id) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.position;
/* 75 */     _h_ += this.partner_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.position).append(",");
/* 83 */     _sb_.append(this.partner_id).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAttachPartnerReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.position - _o_.position;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.partner_id - _o_.partner_id;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\CAttachPartnerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */