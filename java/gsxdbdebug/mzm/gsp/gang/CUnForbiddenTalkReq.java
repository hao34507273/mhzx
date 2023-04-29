/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PUnForbiddenTalkReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUnForbiddenTalkReq
/*    */   extends __CUnForbiddenTalkReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589887;
/*    */   public long roleid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/*    */     
/* 21 */     Role.addRoleProcedure(roleId, new PUnForbiddenTalkReq(roleId, this.roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12589887;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUnForbiddenTalkReq() {}
/*    */   
/*    */ 
/*    */   public CUnForbiddenTalkReq(long _roleid_)
/*    */   {
/* 39 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.roleid = _os_.unmarshal_long();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CUnForbiddenTalkReq)) {
/* 62 */       CUnForbiddenTalkReq _o_ = (CUnForbiddenTalkReq)_o1_;
/* 63 */       if (this.roleid != _o_.roleid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.roleid;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.roleid).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUnForbiddenTalkReq _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CUnForbiddenTalkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */