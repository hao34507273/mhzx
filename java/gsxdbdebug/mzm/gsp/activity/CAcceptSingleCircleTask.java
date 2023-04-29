/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.singletask.main.PAcceptSingleTask;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAcceptSingleCircleTask
/*    */   extends __CAcceptSingleCircleTask__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587604;
/*    */   public int activityid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PAcceptSingleTask(roleId, this.activityid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12587604;
/*    */   }
/*    */   
/*    */ 
/*    */   public CAcceptSingleCircleTask() {}
/*    */   
/*    */ 
/*    */   public CAcceptSingleCircleTask(int _activityid_)
/*    */   {
/* 40 */     this.activityid = _activityid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activityid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.activityid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CAcceptSingleCircleTask)) {
/* 63 */       CAcceptSingleCircleTask _o_ = (CAcceptSingleCircleTask)_o1_;
/* 64 */       if (this.activityid != _o_.activityid) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.activityid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.activityid).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAcceptSingleCircleTask _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.activityid - _o_.activityid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\CAcceptSingleCircleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */