/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class TaskState implements Marshal, Comparable<TaskState>
/*    */ {
/*    */   public int taskid;
/*    */   public int graphid;
/*    */   public int state;
/*    */   
/*    */   public TaskState() {}
/*    */   
/*    */   public TaskState(int _taskid_, int _graphid_, int _state_)
/*    */   {
/* 17 */     this.taskid = _taskid_;
/* 18 */     this.graphid = _graphid_;
/* 19 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.taskid);
/* 28 */     _os_.marshal(this.graphid);
/* 29 */     _os_.marshal(this.state);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.taskid = _os_.unmarshal_int();
/* 35 */     this.graphid = _os_.unmarshal_int();
/* 36 */     this.state = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof TaskState)) {
/* 43 */       TaskState _o_ = (TaskState)_o1_;
/* 44 */       if (this.taskid != _o_.taskid) return false;
/* 45 */       if (this.graphid != _o_.graphid) return false;
/* 46 */       if (this.state != _o_.state) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.taskid;
/* 55 */     _h_ += this.graphid;
/* 56 */     _h_ += this.state;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.taskid).append(",");
/* 64 */     _sb_.append(this.graphid).append(",");
/* 65 */     _sb_.append(this.state).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(TaskState _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.taskid - _o_.taskid;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.graphid - _o_.graphid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.state - _o_.state;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\TaskState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */