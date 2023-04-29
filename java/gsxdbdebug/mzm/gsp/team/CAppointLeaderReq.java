/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.team.main.PAppointLeaderReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAppointLeaderReq
/*    */   extends __CAppointLeaderReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588317;
/*    */   public long new_leader;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleid, new PAppointLeaderReq(roleid, this.new_leader));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588317;
/*    */   }
/*    */   
/*    */ 
/*    */   public CAppointLeaderReq() {}
/*    */   
/*    */ 
/*    */   public CAppointLeaderReq(long _new_leader_)
/*    */   {
/* 40 */     this.new_leader = _new_leader_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.new_leader);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.new_leader = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CAppointLeaderReq)) {
/* 63 */       CAppointLeaderReq _o_ = (CAppointLeaderReq)_o1_;
/* 64 */       if (this.new_leader != _o_.new_leader) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.new_leader;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.new_leader).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAppointLeaderReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = Long.signum(this.new_leader - _o_.new_leader);
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\CAppointLeaderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */