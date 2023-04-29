/*     */ package mzm.gsp.task;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.task.main.PCAfterUseTaskItem;
/*     */ 
/*     */ public class CAfterUseTaskItem extends __CAfterUseTaskItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592142;
/*     */   public int taskid;
/*     */   public int graphid;
/*     */   public int taskitemid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     long roleId = Role.getRoleId(this);
/*  18 */     if (roleId < 0L) {
/*  19 */       return;
/*     */     }
/*  21 */     Role.addRoleProcedure(roleId, new PCAfterUseTaskItem(roleId, this.graphid, this.taskid, this.taskitemid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12592142;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAfterUseTaskItem() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAfterUseTaskItem(int _taskid_, int _graphid_, int _taskitemid_)
/*     */   {
/*  40 */     this.taskid = _taskid_;
/*  41 */     this.graphid = _graphid_;
/*  42 */     this.taskitemid = _taskitemid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.taskid);
/*  51 */     _os_.marshal(this.graphid);
/*  52 */     _os_.marshal(this.taskitemid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.taskid = _os_.unmarshal_int();
/*  58 */     this.graphid = _os_.unmarshal_int();
/*  59 */     this.taskitemid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CAfterUseTaskItem)) {
/*  69 */       CAfterUseTaskItem _o_ = (CAfterUseTaskItem)_o1_;
/*  70 */       if (this.taskid != _o_.taskid) return false;
/*  71 */       if (this.graphid != _o_.graphid) return false;
/*  72 */       if (this.taskitemid != _o_.taskitemid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.taskid;
/*  81 */     _h_ += this.graphid;
/*  82 */     _h_ += this.taskitemid;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.taskid).append(",");
/*  90 */     _sb_.append(this.graphid).append(",");
/*  91 */     _sb_.append(this.taskitemid).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAfterUseTaskItem _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.taskid - _o_.taskid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.graphid - _o_.graphid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.taskitemid - _o_.taskitemid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CAfterUseTaskItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */