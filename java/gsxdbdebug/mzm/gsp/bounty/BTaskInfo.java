/*    */ package mzm.gsp.bounty;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class BTaskInfo
/*    */   implements Marshal, Comparable<BTaskInfo>
/*    */ {
/*    */   public static final int UN_ACCEPTED = 0;
/*    */   public static final int ALREADY_ACCEPTED = 1;
/*    */   public static final int FINISHED = 2;
/*    */   public static final int GIVE_UP = 3;
/*    */   public int taskid;
/*    */   public int taskstate;
/*    */   
/*    */   public BTaskInfo() {}
/*    */   
/*    */   public BTaskInfo(int _taskid_, int _taskstate_)
/*    */   {
/* 21 */     this.taskid = _taskid_;
/* 22 */     this.taskstate = _taskstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.taskid);
/* 31 */     _os_.marshal(this.taskstate);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.taskid = _os_.unmarshal_int();
/* 37 */     this.taskstate = _os_.unmarshal_int();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof BTaskInfo)) {
/* 44 */       BTaskInfo _o_ = (BTaskInfo)_o1_;
/* 45 */       if (this.taskid != _o_.taskid) return false;
/* 46 */       if (this.taskstate != _o_.taskstate) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.taskid;
/* 55 */     _h_ += this.taskstate;
/* 56 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuilder _sb_ = new StringBuilder();
/* 61 */     _sb_.append("(");
/* 62 */     _sb_.append(this.taskid).append(",");
/* 63 */     _sb_.append(this.taskstate).append(",");
/* 64 */     _sb_.append(")");
/* 65 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(BTaskInfo _o_) {
/* 69 */     if (_o_ == this) return 0;
/* 70 */     int _c_ = 0;
/* 71 */     _c_ = this.taskid - _o_.taskid;
/* 72 */     if (0 != _c_) return _c_;
/* 73 */     _c_ = this.taskstate - _o_.taskstate;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\BTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */