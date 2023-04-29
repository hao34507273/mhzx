/*    */ package mzm.gsp.backgameactivity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BackGameActivityTaskInfo
/*    */   implements Marshal, Comparable<BackGameActivityTaskInfo>
/*    */ {
/*    */   public static final int NOT_FINISHED = 0;
/*    */   public static final int FINISHED = 1;
/*    */   public int task_state;
/*    */   
/*    */   public BackGameActivityTaskInfo() {}
/*    */   
/*    */   public BackGameActivityTaskInfo(int _task_state_)
/*    */   {
/* 20 */     this.task_state = _task_state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.task_state);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.task_state = _os_.unmarshal_int();
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof BackGameActivityTaskInfo)) {
/* 40 */       BackGameActivityTaskInfo _o_ = (BackGameActivityTaskInfo)_o1_;
/* 41 */       if (this.task_state != _o_.task_state) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.task_state;
/* 50 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 54 */     StringBuilder _sb_ = new StringBuilder();
/* 55 */     _sb_.append("(");
/* 56 */     _sb_.append(this.task_state).append(",");
/* 57 */     _sb_.append(")");
/* 58 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(BackGameActivityTaskInfo _o_) {
/* 62 */     if (_o_ == this) return 0;
/* 63 */     int _c_ = 0;
/* 64 */     _c_ = this.task_state - _o_.task_state;
/* 65 */     if (0 != _c_) return _c_;
/* 66 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\BackGameActivityTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */