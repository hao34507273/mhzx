/*    */ package mzm.gsp.partner;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.partner.main.POnReplaceLovesReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CReplaceLovesReq
/*    */   extends __CReplaceLovesReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588050;
/*    */   public int partnerid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new POnReplaceLovesReq(roleId, this.partnerid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588050;
/*    */   }
/*    */   
/*    */ 
/*    */   public CReplaceLovesReq() {}
/*    */   
/*    */ 
/*    */   public CReplaceLovesReq(int _partnerid_)
/*    */   {
/* 40 */     this.partnerid = _partnerid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.partnerid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.partnerid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CReplaceLovesReq)) {
/* 63 */       CReplaceLovesReq _o_ = (CReplaceLovesReq)_o1_;
/* 64 */       if (this.partnerid != _o_.partnerid) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.partnerid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.partnerid).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CReplaceLovesReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.partnerid - _o_.partnerid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\CReplaceLovesReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */