/*    */ package mzm.gsp.grow;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grow.daytarget.PCGetAwardReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetAwardReq
/*    */   extends __CGetAwardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596995;
/*    */   public int targetid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCGetAwardReq(roleid, this.targetid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12596995;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetAwardReq() {}
/*    */   
/*    */ 
/*    */   public CGetAwardReq(int _targetid_)
/*    */   {
/* 41 */     this.targetid = _targetid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.targetid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.targetid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CGetAwardReq)) {
/* 64 */       CGetAwardReq _o_ = (CGetAwardReq)_o1_;
/* 65 */       if (this.targetid != _o_.targetid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.targetid;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.targetid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetAwardReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.targetid - _o_.targetid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\CGetAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */