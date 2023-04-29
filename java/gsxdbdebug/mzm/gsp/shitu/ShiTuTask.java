/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShiTuTask
/*    */   implements Marshal, Comparable<ShiTuTask>
/*    */ {
/*    */   public static final int UN_ACCEPTED = 0;
/*    */   public static final int ALREADY_ACCEPTED = 1;
/*    */   public static final int FINISHED = 2;
/*    */   public static final int GIVE_UP = 3;
/*    */   public static final int MASTER_REWARDED = 4;
/*    */   public int task_id;
/*    */   public int task_state;
/*    */   
/*    */   public ShiTuTask() {}
/*    */   
/*    */   public ShiTuTask(int _task_id_, int _task_state_)
/*    */   {
/* 24 */     this.task_id = _task_id_;
/* 25 */     this.task_state = _task_state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.task_id);
/* 34 */     _os_.marshal(this.task_state);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.task_id = _os_.unmarshal_int();
/* 40 */     this.task_state = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof ShiTuTask)) {
/* 47 */       ShiTuTask _o_ = (ShiTuTask)_o1_;
/* 48 */       if (this.task_id != _o_.task_id) return false;
/* 49 */       if (this.task_state != _o_.task_state) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.task_id;
/* 58 */     _h_ += this.task_state;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.task_id).append(",");
/* 66 */     _sb_.append(this.task_state).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ShiTuTask _o_) {
/* 72 */     if (_o_ == this) return 0;
/* 73 */     int _c_ = 0;
/* 74 */     _c_ = this.task_id - _o_.task_id;
/* 75 */     if (0 != _c_) return _c_;
/* 76 */     _c_ = this.task_state - _o_.task_state;
/* 77 */     if (0 != _c_) return _c_;
/* 78 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\ShiTuTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */