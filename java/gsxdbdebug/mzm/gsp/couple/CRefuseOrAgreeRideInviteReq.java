/*    */ package mzm.gsp.couple;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.couple.main.PCRefuseOrAgerrRideInvite;
/*    */ 
/*    */ 
/*    */ public class CRefuseOrAgreeRideInviteReq
/*    */   extends __CRefuseOrAgreeRideInviteReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600584;
/*    */   public static final int AGREE = 0;
/*    */   public static final int REFUSE = 1;
/*    */   public long sessionid;
/*    */   public int operate;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCRefuseOrAgerrRideInvite(this.sessionid, roleid, this.operate));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12600584;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CRefuseOrAgreeRideInviteReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CRefuseOrAgreeRideInviteReq(long _sessionid_, int _operate_)
/*    */   {
/* 42 */     this.sessionid = _sessionid_;
/* 43 */     this.operate = _operate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.sessionid);
/* 52 */     _os_.marshal(this.operate);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.sessionid = _os_.unmarshal_long();
/* 58 */     this.operate = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CRefuseOrAgreeRideInviteReq)) {
/* 68 */       CRefuseOrAgreeRideInviteReq _o_ = (CRefuseOrAgreeRideInviteReq)_o1_;
/* 69 */       if (this.sessionid != _o_.sessionid) return false;
/* 70 */       if (this.operate != _o_.operate) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.sessionid;
/* 79 */     _h_ += this.operate;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.sessionid).append(",");
/* 87 */     _sb_.append(this.operate).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CRefuseOrAgreeRideInviteReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.operate - _o_.operate;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\CRefuseOrAgreeRideInviteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */