/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.qingfu.main.PCDelFailureOrderReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDelFailureOrderReq
/*    */   extends __CDelFailureOrderReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588802;
/*    */   public Octets gameorderid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCDelFailureOrderReq(roleId, this.gameorderid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588802;
/*    */   }
/*    */   
/*    */ 
/*    */   public CDelFailureOrderReq()
/*    */   {
/* 37 */     this.gameorderid = new Octets();
/*    */   }
/*    */   
/*    */   public CDelFailureOrderReq(Octets _gameorderid_) {
/* 41 */     this.gameorderid = _gameorderid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.gameorderid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.gameorderid = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CDelFailureOrderReq)) {
/* 64 */       CDelFailureOrderReq _o_ = (CDelFailureOrderReq)_o1_;
/* 65 */       if (!this.gameorderid.equals(_o_.gameorderid)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.gameorderid.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append("B").append(this.gameorderid.size()).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\CDelFailureOrderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */