/*    */ package mzm.gsp.bounty;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.bounty.main.PCGiveUpBTaskReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGiveUpBTaskReq
/*    */   extends __CGiveUpBTaskReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584198;
/*    */   public int graphid;
/*    */   public int taskid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGiveUpBTaskReq(roleId, this.graphid, this.taskid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12584198;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGiveUpBTaskReq() {}
/*    */   
/*    */ 
/*    */   public CGiveUpBTaskReq(int _graphid_, int _taskid_)
/*    */   {
/* 42 */     this.graphid = _graphid_;
/* 43 */     this.taskid = _taskid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.graphid);
/* 52 */     _os_.marshal(this.taskid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.graphid = _os_.unmarshal_int();
/* 58 */     this.taskid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGiveUpBTaskReq)) {
/* 68 */       CGiveUpBTaskReq _o_ = (CGiveUpBTaskReq)_o1_;
/* 69 */       if (this.graphid != _o_.graphid) return false;
/* 70 */       if (this.taskid != _o_.taskid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.graphid;
/* 79 */     _h_ += this.taskid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.graphid).append(",");
/* 87 */     _sb_.append(this.taskid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGiveUpBTaskReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.graphid - _o_.graphid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.taskid - _o_.taskid;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\CGiveUpBTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */