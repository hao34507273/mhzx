/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.team.activity.PCFlushInActivityReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CFlushInActivityReq
/*    */   extends __CFlushInActivityReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588343;
/*    */   public static final int FIND_TEAM = 1;
/*    */   public static final int FIND_MEMBER = 2;
/*    */   public int flushtype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCFlushInActivityReq(roleid, this.flushtype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12588343;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CFlushInActivityReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public CFlushInActivityReq(int _flushtype_)
/*    */   {
/* 44 */     this.flushtype = _flushtype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.flushtype);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.flushtype = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CFlushInActivityReq)) {
/* 67 */       CFlushInActivityReq _o_ = (CFlushInActivityReq)_o1_;
/* 68 */       if (this.flushtype != _o_.flushtype) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.flushtype;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.flushtype).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CFlushInActivityReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.flushtype - _o_.flushtype;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\CFlushInActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */