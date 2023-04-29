/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friend.main.PCDisAgreeApply;
/*    */ 
/*    */ public class CDisAgreeApply
/*    */   extends __CDisAgreeApply__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587027;
/*    */   public long strangerid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 16 */     long roleId = Role.getRoleId(this);
/* 17 */     Role.addRoleProcedure(roleId, new PCDisAgreeApply(roleId, this.strangerid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587027;
/*    */   }
/*    */   
/*    */ 
/*    */   public CDisAgreeApply() {}
/*    */   
/*    */ 
/*    */   public CDisAgreeApply(long _strangerid_)
/*    */   {
/* 34 */     this.strangerid = _strangerid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     _os_.marshal(this.strangerid);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     this.strangerid = _os_.unmarshal_long();
/* 48 */     if (!_validator_()) {
/* 49 */       throw new VerifyError("validator failed");
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof CDisAgreeApply)) {
/* 57 */       CDisAgreeApply _o_ = (CDisAgreeApply)_o1_;
/* 58 */       if (this.strangerid != _o_.strangerid) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.strangerid;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.strangerid).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDisAgreeApply _o_) {
/* 79 */     if (_o_ == this) return 0;
/* 80 */     int _c_ = 0;
/* 81 */     _c_ = Long.signum(this.strangerid - _o_.strangerid);
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\CDisAgreeApply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */