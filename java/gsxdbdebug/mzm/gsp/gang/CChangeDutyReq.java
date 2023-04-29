/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PChangeDutyReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeDutyReq
/*    */   extends __CChangeDutyReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589897;
/*    */   public long targetid;
/*    */   public int duty;
/*    */   
/*    */   protected void process()
/*    */   {
/* 21 */     long roleId = Role.getRoleId(this);
/*    */     
/* 23 */     Role.addRoleProcedure(roleId, new PChangeDutyReq(roleId, this.targetid, this.duty));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12589897;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeDutyReq() {}
/*    */   
/*    */ 
/*    */   public CChangeDutyReq(long _targetid_, int _duty_)
/*    */   {
/* 42 */     this.targetid = _targetid_;
/* 43 */     this.duty = _duty_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.targetid);
/* 52 */     _os_.marshal(this.duty);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.targetid = _os_.unmarshal_long();
/* 58 */     this.duty = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CChangeDutyReq)) {
/* 68 */       CChangeDutyReq _o_ = (CChangeDutyReq)_o1_;
/* 69 */       if (this.targetid != _o_.targetid) return false;
/* 70 */       if (this.duty != _o_.duty) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.targetid;
/* 79 */     _h_ += this.duty;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.targetid).append(",");
/* 87 */     _sb_.append(this.duty).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChangeDutyReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.targetid - _o_.targetid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.duty - _o_.duty;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CChangeDutyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */