/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRefreshTaskRes
/*    */   extends __SRefreshTaskRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592129;
/*    */   public int npcid;
/*    */   public ArrayList<TaskState> taskstates;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12592129;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRefreshTaskRes()
/*    */   {
/* 32 */     this.taskstates = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRefreshTaskRes(int _npcid_, ArrayList<TaskState> _taskstates_) {
/* 36 */     this.npcid = _npcid_;
/* 37 */     this.taskstates = _taskstates_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (TaskState _v_ : this.taskstates)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.npcid);
/* 48 */     _os_.compact_uint32(this.taskstates.size());
/* 49 */     for (TaskState _v_ : this.taskstates) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.npcid = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 58 */       TaskState _v_ = new TaskState();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.taskstates.add(_v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SRefreshTaskRes)) {
/* 71 */       SRefreshTaskRes _o_ = (SRefreshTaskRes)_o1_;
/* 72 */       if (this.npcid != _o_.npcid) return false;
/* 73 */       if (!this.taskstates.equals(_o_.taskstates)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.npcid;
/* 82 */     _h_ += this.taskstates.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.npcid).append(",");
/* 90 */     _sb_.append(this.taskstates).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\SRefreshTaskRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */