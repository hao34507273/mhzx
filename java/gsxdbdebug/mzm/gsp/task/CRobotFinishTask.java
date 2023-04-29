/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.task.main.PGM_FinishTask;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRobotFinishTask
/*    */   extends __CRobotFinishTask__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592145;
/*    */   public int graphid;
/*    */   public int taskid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PGM_FinishTask(roleId, this.graphid, this.taskid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12592145;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CRobotFinishTask() {}
/*    */   
/*    */ 
/*    */   public CRobotFinishTask(int _graphid_, int _taskid_)
/*    */   {
/* 41 */     this.graphid = _graphid_;
/* 42 */     this.taskid = _taskid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.graphid);
/* 51 */     _os_.marshal(this.taskid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.graphid = _os_.unmarshal_int();
/* 57 */     this.taskid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CRobotFinishTask)) {
/* 67 */       CRobotFinishTask _o_ = (CRobotFinishTask)_o1_;
/* 68 */       if (this.graphid != _o_.graphid) return false;
/* 69 */       if (this.taskid != _o_.taskid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.graphid;
/* 78 */     _h_ += this.taskid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.graphid).append(",");
/* 86 */     _sb_.append(this.taskid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CRobotFinishTask _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.graphid - _o_.graphid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.taskid - _o_.taskid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CRobotFinishTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */