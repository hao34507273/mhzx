/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.task.main.GiveupTaskProcedure;
/*    */ 
/*    */ public class CGiveUpTaskReq extends __CGiveUpTaskReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592139;
/*    */   public int taskid;
/*    */   public int graphid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 16 */     long roleId = Role.getRoleId(this);
/* 17 */     if (roleId < 0L) {
/* 18 */       return;
/*    */     }
/* 20 */     Role.addRoleProcedure(roleId, new GiveupTaskProcedure(roleId, this.graphid, this.taskid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12592139;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGiveUpTaskReq() {}
/*    */   
/*    */ 
/*    */   public CGiveUpTaskReq(int _taskid_, int _graphid_)
/*    */   {
/* 38 */     this.taskid = _taskid_;
/* 39 */     this.graphid = _graphid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.taskid);
/* 48 */     _os_.marshal(this.graphid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.taskid = _os_.unmarshal_int();
/* 54 */     this.graphid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CGiveUpTaskReq)) {
/* 64 */       CGiveUpTaskReq _o_ = (CGiveUpTaskReq)_o1_;
/* 65 */       if (this.taskid != _o_.taskid) return false;
/* 66 */       if (this.graphid != _o_.graphid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.taskid;
/* 75 */     _h_ += this.graphid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.taskid).append(",");
/* 83 */     _sb_.append(this.graphid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGiveUpTaskReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.taskid - _o_.taskid;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.graphid - _o_.graphid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CGiveUpTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */