/*    */ package mzm.gsp.signaward;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.signaward.main.PGetLoginAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetLoginAwardReq
/*    */   extends __CGetLoginAwardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593415;
/*    */   public int daycount;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PGetLoginAward(roleid, this.daycount));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12593415;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetLoginAwardReq() {}
/*    */   
/*    */ 
/*    */   public CGetLoginAwardReq(int _daycount_)
/*    */   {
/* 39 */     this.daycount = _daycount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.daycount);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.daycount = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CGetLoginAwardReq)) {
/* 62 */       CGetLoginAwardReq _o_ = (CGetLoginAwardReq)_o1_;
/* 63 */       if (this.daycount != _o_.daycount) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.daycount;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.daycount).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetLoginAwardReq _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.daycount - _o_.daycount;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\CGetLoginAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */