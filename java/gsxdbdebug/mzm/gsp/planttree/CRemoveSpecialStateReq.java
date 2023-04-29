/*     */ package mzm.gsp.planttree;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.planttree.main.PCRemoveSpecialState;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CRemoveSpecialStateReq
/*     */   extends __CRemoveSpecialStateReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611589;
/*     */   public long owner_id;
/*     */   public int activity_cfg_id;
/*     */   public int special_state_index;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PCRemoveSpecialState(roleid, this.owner_id, this.activity_cfg_id, this.special_state_index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12611589;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CRemoveSpecialStateReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CRemoveSpecialStateReq(long _owner_id_, int _activity_cfg_id_, int _special_state_index_)
/*     */   {
/*  44 */     this.owner_id = _owner_id_;
/*  45 */     this.activity_cfg_id = _activity_cfg_id_;
/*  46 */     this.special_state_index = _special_state_index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.owner_id);
/*  55 */     _os_.marshal(this.activity_cfg_id);
/*  56 */     _os_.marshal(this.special_state_index);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.owner_id = _os_.unmarshal_long();
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.special_state_index = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CRemoveSpecialStateReq)) {
/*  73 */       CRemoveSpecialStateReq _o_ = (CRemoveSpecialStateReq)_o1_;
/*  74 */       if (this.owner_id != _o_.owner_id) return false;
/*  75 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  76 */       if (this.special_state_index != _o_.special_state_index) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.owner_id;
/*  85 */     _h_ += this.activity_cfg_id;
/*  86 */     _h_ += this.special_state_index;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.owner_id).append(",");
/*  94 */     _sb_.append(this.activity_cfg_id).append(",");
/*  95 */     _sb_.append(this.special_state_index).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CRemoveSpecialStateReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = Long.signum(this.owner_id - _o_.owner_id);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.special_state_index - _o_.special_state_index;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\CRemoveSpecialStateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */