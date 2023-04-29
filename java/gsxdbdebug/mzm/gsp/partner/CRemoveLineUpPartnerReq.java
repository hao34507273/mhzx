/*    */ package mzm.gsp.partner;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.partner.main.PRemoveLineUpPartnerReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRemoveLineUpPartnerReq
/*    */   extends __CRemoveLineUpPartnerReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588045;
/*    */   public int lineupnum;
/*    */   public int partnerid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PRemoveLineUpPartnerReq(roleId, this.partnerid, this.lineupnum));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588045;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CRemoveLineUpPartnerReq() {}
/*    */   
/*    */ 
/*    */   public CRemoveLineUpPartnerReq(int _lineupnum_, int _partnerid_)
/*    */   {
/* 41 */     this.lineupnum = _lineupnum_;
/* 42 */     this.partnerid = _partnerid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.lineupnum);
/* 51 */     _os_.marshal(this.partnerid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.lineupnum = _os_.unmarshal_int();
/* 57 */     this.partnerid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CRemoveLineUpPartnerReq)) {
/* 67 */       CRemoveLineUpPartnerReq _o_ = (CRemoveLineUpPartnerReq)_o1_;
/* 68 */       if (this.lineupnum != _o_.lineupnum) return false;
/* 69 */       if (this.partnerid != _o_.partnerid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.lineupnum;
/* 78 */     _h_ += this.partnerid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.lineupnum).append(",");
/* 86 */     _sb_.append(this.partnerid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CRemoveLineUpPartnerReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.lineupnum - _o_.lineupnum;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.partnerid - _o_.partnerid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\CRemoveLineUpPartnerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */