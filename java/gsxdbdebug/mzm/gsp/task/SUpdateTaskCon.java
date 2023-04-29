/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SUpdateTaskCon
/*    */   extends __SUpdateTaskCon__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592130;
/*    */   public int taskid;
/*    */   public int graphid;
/*    */   public ConData condata;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12592130;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUpdateTaskCon()
/*    */   {
/* 33 */     this.condata = new ConData();
/*    */   }
/*    */   
/*    */   public SUpdateTaskCon(int _taskid_, int _graphid_, ConData _condata_) {
/* 37 */     this.taskid = _taskid_;
/* 38 */     this.graphid = _graphid_;
/* 39 */     this.condata = _condata_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.condata._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.taskid);
/* 49 */     _os_.marshal(this.graphid);
/* 50 */     _os_.marshal(this.condata);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.taskid = _os_.unmarshal_int();
/* 56 */     this.graphid = _os_.unmarshal_int();
/* 57 */     this.condata.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SUpdateTaskCon)) {
/* 67 */       SUpdateTaskCon _o_ = (SUpdateTaskCon)_o1_;
/* 68 */       if (this.taskid != _o_.taskid) return false;
/* 69 */       if (this.graphid != _o_.graphid) return false;
/* 70 */       if (!this.condata.equals(_o_.condata)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.taskid;
/* 79 */     _h_ += this.graphid;
/* 80 */     _h_ += this.condata.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.taskid).append(",");
/* 88 */     _sb_.append(this.graphid).append(",");
/* 89 */     _sb_.append(this.condata).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\SUpdateTaskCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */