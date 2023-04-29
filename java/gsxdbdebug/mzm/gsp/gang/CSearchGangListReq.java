/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PSearchGangListReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSearchGangListReq
/*    */   extends __CSearchGangListReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589876;
/*    */   public String condition;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PSearchGangListReq(roleId, this.condition));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12589876;
/*    */   }
/*    */   
/*    */ 
/*    */   public CSearchGangListReq()
/*    */   {
/* 37 */     this.condition = "";
/*    */   }
/*    */   
/*    */   public CSearchGangListReq(String _condition_) {
/* 41 */     this.condition = _condition_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.condition, "UTF-16LE");
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.condition = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CSearchGangListReq)) {
/* 64 */       CSearchGangListReq _o_ = (CSearchGangListReq)_o1_;
/* 65 */       if (!this.condition.equals(_o_.condition)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.condition.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append("T").append(this.condition.length()).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CSearchGangListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */