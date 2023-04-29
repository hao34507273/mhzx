/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PCombineGangCancelReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCombineGangCancelReq
/*    */   extends __CCombineGangCancelReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589973;
/*    */   public long targetid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid > 0L) {
/* 21 */       Role.addRoleProcedure(roleid, new PCombineGangCancelReq(roleid, this.targetid));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12589973;
/*    */   }
/*    */   
/*    */ 
/*    */   public CCombineGangCancelReq() {}
/*    */   
/*    */ 
/*    */   public CCombineGangCancelReq(long _targetid_)
/*    */   {
/* 40 */     this.targetid = _targetid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.targetid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.targetid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CCombineGangCancelReq)) {
/* 63 */       CCombineGangCancelReq _o_ = (CCombineGangCancelReq)_o1_;
/* 64 */       if (this.targetid != _o_.targetid) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.targetid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.targetid).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCombineGangCancelReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = Long.signum(this.targetid - _o_.targetid);
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CCombineGangCancelReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */