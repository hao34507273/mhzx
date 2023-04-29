/*    */ package mzm.gsp.npc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.npc.main.RoleFinishDlgProcedure;
/*    */ 
/*    */ public class CFinishDlgReq extends __CFinishDlgReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586756;
/*    */   public int npcid;
/*    */   public int taskid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 16 */     long roleId = Role.getRoleId(this);
/* 17 */     Role.addRoleProcedure(roleId, new RoleFinishDlgProcedure(roleId, this.npcid, this.taskid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 25 */     return 12586756;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CFinishDlgReq() {}
/*    */   
/*    */ 
/*    */   public CFinishDlgReq(int _npcid_, int _taskid_)
/*    */   {
/* 35 */     this.npcid = _npcid_;
/* 36 */     this.taskid = _taskid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.npcid);
/* 45 */     _os_.marshal(this.taskid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.npcid = _os_.unmarshal_int();
/* 51 */     this.taskid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CFinishDlgReq)) {
/* 61 */       CFinishDlgReq _o_ = (CFinishDlgReq)_o1_;
/* 62 */       if (this.npcid != _o_.npcid) return false;
/* 63 */       if (this.taskid != _o_.taskid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.npcid;
/* 72 */     _h_ += this.taskid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.npcid).append(",");
/* 80 */     _sb_.append(this.taskid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CFinishDlgReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.npcid - _o_.npcid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.taskid - _o_.taskid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\CFinishDlgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */