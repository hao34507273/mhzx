/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PGetCombineGangListReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetCombineGangListReq
/*    */   extends __CGetCombineGangListReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589959;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid > 0L) {
/* 21 */       Role.addRoleProcedure(roleid, new PGetCombineGangListReq(roleid));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12589959;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     if (!_validator_()) {
/* 48 */       throw new VerifyError("validator failed");
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof CGetCombineGangListReq)) {
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetCombineGangListReq _o_) {
/* 74 */     if (_o_ == this) return 0;
/* 75 */     int _c_ = 0;
/* 76 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CGetCombineGangListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */