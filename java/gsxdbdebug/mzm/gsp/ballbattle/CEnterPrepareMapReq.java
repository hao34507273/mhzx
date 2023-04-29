/*    */ package mzm.gsp.ballbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.ballbattle.main.PEnterPrepareMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CEnterPrepareMapReq
/*    */   extends __CEnterPrepareMapReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12629264;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     PEnterPrepareMap.schedule(roleId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12629264;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     if (!_validator_()) {
/* 45 */       throw new VerifyError("validator failed");
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof CEnterPrepareMapReq)) {
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CEnterPrepareMapReq _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\CEnterPrepareMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */