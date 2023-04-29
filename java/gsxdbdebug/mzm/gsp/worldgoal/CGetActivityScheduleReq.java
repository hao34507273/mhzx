/*     */ package mzm.gsp.worldgoal;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.worldgoal.main.PGetActivityScheduleReq;
/*     */ 
/*     */ 
/*     */ public class CGetActivityScheduleReq
/*     */   extends __CGetActivityScheduleReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594438;
/*     */   public int position;
/*     */   public int activity_cfg_id;
/*     */   public int npc_id;
/*     */   public long entity_instance_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PGetActivityScheduleReq(roleid, this.position, this.activity_cfg_id, this.npc_id, this.entity_instance_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12594438;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetActivityScheduleReq()
/*     */   {
/*  40 */     this.position = 1;
/*     */   }
/*     */   
/*     */   public CGetActivityScheduleReq(int _position_, int _activity_cfg_id_, int _npc_id_, long _entity_instance_id_) {
/*  44 */     this.position = _position_;
/*  45 */     this.activity_cfg_id = _activity_cfg_id_;
/*  46 */     this.npc_id = _npc_id_;
/*  47 */     this.entity_instance_id = _entity_instance_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.position);
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.npc_id);
/*  58 */     _os_.marshal(this.entity_instance_id);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.position = _os_.unmarshal_int();
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.npc_id = _os_.unmarshal_int();
/*  66 */     this.entity_instance_id = _os_.unmarshal_long();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CGetActivityScheduleReq)) {
/*  76 */       CGetActivityScheduleReq _o_ = (CGetActivityScheduleReq)_o1_;
/*  77 */       if (this.position != _o_.position) return false;
/*  78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  79 */       if (this.npc_id != _o_.npc_id) return false;
/*  80 */       if (this.entity_instance_id != _o_.entity_instance_id) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.position;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.npc_id;
/*  91 */     _h_ += (int)this.entity_instance_id;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.position).append(",");
/*  99 */     _sb_.append(this.activity_cfg_id).append(",");
/* 100 */     _sb_.append(this.npc_id).append(",");
/* 101 */     _sb_.append(this.entity_instance_id).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetActivityScheduleReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.position - _o_.position;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.npc_id - _o_.npc_id;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = Long.signum(this.entity_instance_id - _o_.entity_instance_id);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\CGetActivityScheduleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */