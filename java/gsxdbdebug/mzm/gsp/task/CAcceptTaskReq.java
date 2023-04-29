/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.task.main.PCAcceptTaskReq;
/*    */ 
/*    */ public class CAcceptTaskReq extends __CAcceptTaskReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592134;
/*    */   public int taskid;
/*    */   public int graphid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 16 */     long roleId = Role.getRoleId(this);
/* 17 */     if (roleId < 0L) {
/* 18 */       return;
/*    */     }
/* 20 */     Role.addRoleProcedure(roleId, new PCAcceptTaskReq(roleId, this.graphid, this.taskid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12592134;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAcceptTaskReq() {}
/*    */   
/*    */ 
/*    */   public CAcceptTaskReq(int _taskid_, int _graphid_)
/*    */   {
/* 39 */     this.taskid = _taskid_;
/* 40 */     this.graphid = _graphid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.taskid);
/* 49 */     _os_.marshal(this.graphid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.taskid = _os_.unmarshal_int();
/* 55 */     this.graphid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CAcceptTaskReq)) {
/* 65 */       CAcceptTaskReq _o_ = (CAcceptTaskReq)_o1_;
/* 66 */       if (this.taskid != _o_.taskid) return false;
/* 67 */       if (this.graphid != _o_.graphid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.taskid;
/* 76 */     _h_ += this.graphid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.taskid).append(",");
/* 84 */     _sb_.append(this.graphid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAcceptTaskReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.taskid - _o_.taskid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.graphid - _o_.graphid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CAcceptTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */