/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.baitan.main.PUnlockGridReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUnlockGridReq
/*    */   extends __CUnlockGridReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584978;
/*    */   public long clientyuanbao;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PUnlockGridReq(roleId, this.clientyuanbao));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12584978;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUnlockGridReq() {}
/*    */   
/*    */ 
/*    */   public CUnlockGridReq(long _clientyuanbao_)
/*    */   {
/* 40 */     this.clientyuanbao = _clientyuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.clientyuanbao);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.clientyuanbao = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CUnlockGridReq)) {
/* 63 */       CUnlockGridReq _o_ = (CUnlockGridReq)_o1_;
/* 64 */       if (this.clientyuanbao != _o_.clientyuanbao) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.clientyuanbao;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.clientyuanbao).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUnlockGridReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = Long.signum(this.clientyuanbao - _o_.clientyuanbao);
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CUnlockGridReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */