/*     */ package mzm.gsp.petmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.petmark.main.PCPetMarkUpgradeWithItemReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CPetMarkUpgradeWithItemReq
/*     */   extends __CPetMarkUpgradeWithItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628493;
/*     */   public long main_pet_mark_id;
/*     */   public int cost_item_cfg_id;
/*     */   public byte use_all;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCPetMarkUpgradeWithItemReq(roleId, this.main_pet_mark_id, this.cost_item_cfg_id, this.use_all));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12628493;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CPetMarkUpgradeWithItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CPetMarkUpgradeWithItemReq(long _main_pet_mark_id_, int _cost_item_cfg_id_, byte _use_all_)
/*     */   {
/*  43 */     this.main_pet_mark_id = _main_pet_mark_id_;
/*  44 */     this.cost_item_cfg_id = _cost_item_cfg_id_;
/*  45 */     this.use_all = _use_all_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.main_pet_mark_id);
/*  54 */     _os_.marshal(this.cost_item_cfg_id);
/*  55 */     _os_.marshal(this.use_all);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.main_pet_mark_id = _os_.unmarshal_long();
/*  61 */     this.cost_item_cfg_id = _os_.unmarshal_int();
/*  62 */     this.use_all = _os_.unmarshal_byte();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CPetMarkUpgradeWithItemReq)) {
/*  72 */       CPetMarkUpgradeWithItemReq _o_ = (CPetMarkUpgradeWithItemReq)_o1_;
/*  73 */       if (this.main_pet_mark_id != _o_.main_pet_mark_id) return false;
/*  74 */       if (this.cost_item_cfg_id != _o_.cost_item_cfg_id) return false;
/*  75 */       if (this.use_all != _o_.use_all) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.main_pet_mark_id;
/*  84 */     _h_ += this.cost_item_cfg_id;
/*  85 */     _h_ += this.use_all;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.main_pet_mark_id).append(",");
/*  93 */     _sb_.append(this.cost_item_cfg_id).append(",");
/*  94 */     _sb_.append(this.use_all).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPetMarkUpgradeWithItemReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.main_pet_mark_id - _o_.main_pet_mark_id);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.cost_item_cfg_id - _o_.cost_item_cfg_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.use_all - _o_.use_all;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\CPetMarkUpgradeWithItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */