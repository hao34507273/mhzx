/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.market.main.PQueryAllConcernReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CQueryAllConcernReq
/*    */   extends __CQueryAllConcernReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601382;
/*    */   
/*    */   protected void process()
/*    */   {
/* 21 */     long roleId = Role.getRoleId(this);
/* 22 */     if (roleId < 0L) {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PQueryAllConcernReq(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12601382;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof CQueryAllConcernReq)) {
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CQueryAllConcernReq _o_) {
/* 77 */     if (_o_ == this) return 0;
/* 78 */     int _c_ = 0;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CQueryAllConcernReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */