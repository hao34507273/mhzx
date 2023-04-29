/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PChangeGangTeamLeaderReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeGangTeamLeaderReq
/*    */   extends __CChangeGangTeamLeaderReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590006;
/*    */   public long new_leader;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleid, new PChangeGangTeamLeaderReq(roleid, this.new_leader));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12590006;
/*    */   }
/*    */   
/*    */ 
/*    */   public CChangeGangTeamLeaderReq() {}
/*    */   
/*    */ 
/*    */   public CChangeGangTeamLeaderReq(long _new_leader_)
/*    */   {
/* 38 */     this.new_leader = _new_leader_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.new_leader);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.new_leader = _os_.unmarshal_long();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CChangeGangTeamLeaderReq)) {
/* 61 */       CChangeGangTeamLeaderReq _o_ = (CChangeGangTeamLeaderReq)_o1_;
/* 62 */       if (this.new_leader != _o_.new_leader) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += (int)this.new_leader;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.new_leader).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChangeGangTeamLeaderReq _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = Long.signum(this.new_leader - _o_.new_leader);
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CChangeGangTeamLeaderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */