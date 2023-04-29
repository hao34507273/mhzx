/*    */ package mzm.gsp.interactivetask;
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
/*    */ 
/*    */ public class SSynInteractiveTaskInfoRes
/*    */   extends __SSynInteractiveTaskInfoRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12610315;
/*    */   public int typeid;
/*    */   public TaskInfo taskinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12610315;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynInteractiveTaskInfoRes()
/*    */   {
/* 32 */     this.taskinfo = new TaskInfo();
/*    */   }
/*    */   
/*    */   public SSynInteractiveTaskInfoRes(int _typeid_, TaskInfo _taskinfo_) {
/* 36 */     this.typeid = _typeid_;
/* 37 */     this.taskinfo = _taskinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.taskinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.typeid);
/* 47 */     _os_.marshal(this.taskinfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.typeid = _os_.unmarshal_int();
/* 53 */     this.taskinfo.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynInteractiveTaskInfoRes)) {
/* 63 */       SSynInteractiveTaskInfoRes _o_ = (SSynInteractiveTaskInfoRes)_o1_;
/* 64 */       if (this.typeid != _o_.typeid) return false;
/* 65 */       if (!this.taskinfo.equals(_o_.taskinfo)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.typeid;
/* 74 */     _h_ += this.taskinfo.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.typeid).append(",");
/* 82 */     _sb_.append(this.taskinfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\SSynInteractiveTaskInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */