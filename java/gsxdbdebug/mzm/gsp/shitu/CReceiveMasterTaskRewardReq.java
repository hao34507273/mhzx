/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.shitu.main.PCReceiveMasterTaskRewardReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CReceiveMasterTaskRewardReq
/*     */   extends __CReceiveMasterTaskRewardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601643;
/*     */   public long role_id;
/*     */   public int graph_id;
/*     */   public int task_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCReceiveMasterTaskRewardReq(roleId, this.role_id, this.graph_id, this.task_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12601643;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReceiveMasterTaskRewardReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReceiveMasterTaskRewardReq(long _role_id_, int _graph_id_, int _task_id_)
/*     */   {
/*  45 */     this.role_id = _role_id_;
/*  46 */     this.graph_id = _graph_id_;
/*  47 */     this.task_id = _task_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.role_id);
/*  56 */     _os_.marshal(this.graph_id);
/*  57 */     _os_.marshal(this.task_id);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.role_id = _os_.unmarshal_long();
/*  63 */     this.graph_id = _os_.unmarshal_int();
/*  64 */     this.task_id = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CReceiveMasterTaskRewardReq)) {
/*  74 */       CReceiveMasterTaskRewardReq _o_ = (CReceiveMasterTaskRewardReq)_o1_;
/*  75 */       if (this.role_id != _o_.role_id) return false;
/*  76 */       if (this.graph_id != _o_.graph_id) return false;
/*  77 */       if (this.task_id != _o_.task_id) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.role_id;
/*  86 */     _h_ += this.graph_id;
/*  87 */     _h_ += this.task_id;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.role_id).append(",");
/*  95 */     _sb_.append(this.graph_id).append(",");
/*  96 */     _sb_.append(this.task_id).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReceiveMasterTaskRewardReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.graph_id - _o_.graph_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.task_id - _o_.task_id;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\CReceiveMasterTaskRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */