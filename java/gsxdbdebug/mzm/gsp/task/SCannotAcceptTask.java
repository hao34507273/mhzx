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
/*    */ 
/*    */ public class SCannotAcceptTask
/*    */   extends __SCannotAcceptTask__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592144;
/*    */   public int graphid;
/*    */   public int taskid;
/*    */   public ArrayList<Integer> conids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12592144;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCannotAcceptTask()
/*    */   {
/* 35 */     this.conids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SCannotAcceptTask(int _graphid_, int _taskid_, ArrayList<Integer> _conids_) {
/* 39 */     this.graphid = _graphid_;
/* 40 */     this.taskid = _taskid_;
/* 41 */     this.conids = _conids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.graphid);
/* 50 */     _os_.marshal(this.taskid);
/* 51 */     _os_.compact_uint32(this.conids.size());
/* 52 */     for (Integer _v_ : this.conids) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.graphid = _os_.unmarshal_int();
/* 60 */     this.taskid = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.conids.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SCannotAcceptTask)) {
/* 75 */       SCannotAcceptTask _o_ = (SCannotAcceptTask)_o1_;
/* 76 */       if (this.graphid != _o_.graphid) return false;
/* 77 */       if (this.taskid != _o_.taskid) return false;
/* 78 */       if (!this.conids.equals(_o_.conids)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.graphid;
/* 87 */     _h_ += this.taskid;
/* 88 */     _h_ += this.conids.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.graphid).append(",");
/* 96 */     _sb_.append(this.taskid).append(",");
/* 97 */     _sb_.append(this.conids).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\SCannotAcceptTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */