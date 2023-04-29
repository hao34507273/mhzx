/*    */ package mzm.gsp.baotu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.baotu.main.PJoinBaotuActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CJoinBaoTuReq
/*    */   extends __CJoinBaoTuReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583683;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleId = Role.getRoleId(this);
/* 18 */     Role.addRoleProcedure(roleId, new PJoinBaotuActivity(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 26 */     return 12583683;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     if (!_validator_()) {
/* 43 */       throw new VerifyError("validator failed");
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof CJoinBaoTuReq)) {
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(")");
/* 65 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CJoinBaoTuReq _o_) {
/* 69 */     if (_o_ == this) return 0;
/* 70 */     int _c_ = 0;
/* 71 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\CJoinBaoTuReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */