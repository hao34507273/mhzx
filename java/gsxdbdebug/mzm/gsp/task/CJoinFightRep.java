/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.task.enterFight.PCJoinFightRep;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CJoinFightRep
/*    */   extends __CJoinFightRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592147;
/*    */   public long sessionid;
/*    */   public int represult;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCJoinFightRep(roleId, this.sessionid, this.represult));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12592147;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CJoinFightRep() {}
/*    */   
/*    */ 
/*    */   public CJoinFightRep(long _sessionid_, int _represult_)
/*    */   {
/* 41 */     this.sessionid = _sessionid_;
/* 42 */     this.represult = _represult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.sessionid);
/* 51 */     _os_.marshal(this.represult);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.sessionid = _os_.unmarshal_long();
/* 57 */     this.represult = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CJoinFightRep)) {
/* 67 */       CJoinFightRep _o_ = (CJoinFightRep)_o1_;
/* 68 */       if (this.sessionid != _o_.sessionid) return false;
/* 69 */       if (this.represult != _o_.represult) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.sessionid;
/* 78 */     _h_ += this.represult;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.sessionid).append(",");
/* 86 */     _sb_.append(this.represult).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CJoinFightRep _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.represult - _o_.represult;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CJoinFightRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */