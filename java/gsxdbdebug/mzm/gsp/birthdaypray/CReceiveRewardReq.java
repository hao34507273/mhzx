/*     */ package mzm.gsp.birthdaypray;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.birthdaypray.main.PCReceiveRewardReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CReceiveRewardReq
/*     */   extends __CReceiveRewardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623105;
/*     */   public int activity_cfg_id;
/*     */   public int task_activity_id;
/*     */   public int stage_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  21 */     long roleId = Role.getRoleId(this);
/*  22 */     if (roleId < 1L)
/*     */     {
/*  24 */       return;
/*     */     }
/*  26 */     Role.addRoleProcedure(roleId, new PCReceiveRewardReq(roleId, this.activity_cfg_id, this.task_activity_id, this.stage_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  35 */     return 12623105;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReceiveRewardReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReceiveRewardReq(int _activity_cfg_id_, int _task_activity_id_, int _stage_id_)
/*     */   {
/*  46 */     this.activity_cfg_id = _activity_cfg_id_;
/*  47 */     this.task_activity_id = _task_activity_id_;
/*  48 */     this.stage_id = _stage_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.task_activity_id);
/*  58 */     _os_.marshal(this.stage_id);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  64 */     this.task_activity_id = _os_.unmarshal_int();
/*  65 */     this.stage_id = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CReceiveRewardReq)) {
/*  75 */       CReceiveRewardReq _o_ = (CReceiveRewardReq)_o1_;
/*  76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  77 */       if (this.task_activity_id != _o_.task_activity_id) return false;
/*  78 */       if (this.stage_id != _o_.stage_id) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.activity_cfg_id;
/*  87 */     _h_ += this.task_activity_id;
/*  88 */     _h_ += this.stage_id;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.activity_cfg_id).append(",");
/*  96 */     _sb_.append(this.task_activity_id).append(",");
/*  97 */     _sb_.append(this.stage_id).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReceiveRewardReq _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.task_activity_id - _o_.task_activity_id;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.stage_id - _o_.stage_id;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\CReceiveRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */