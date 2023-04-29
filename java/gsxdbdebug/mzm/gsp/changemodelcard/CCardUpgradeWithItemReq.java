/*     */ package mzm.gsp.changemodelcard;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.changemodelcard.main.PCCardUpgradeWithItemReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CCardUpgradeWithItemReq
/*     */   extends __CCardUpgradeWithItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624390;
/*     */   public long main_card_id;
/*     */   public int cost_item_cfg_id;
/*     */   public byte use_all;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId <= 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCCardUpgradeWithItemReq(roleId, this.main_card_id, this.cost_item_cfg_id, this.use_all));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  36 */     return 12624390;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CCardUpgradeWithItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CCardUpgradeWithItemReq(long _main_card_id_, int _cost_item_cfg_id_, byte _use_all_)
/*     */   {
/*  47 */     this.main_card_id = _main_card_id_;
/*  48 */     this.cost_item_cfg_id = _cost_item_cfg_id_;
/*  49 */     this.use_all = _use_all_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.main_card_id);
/*  58 */     _os_.marshal(this.cost_item_cfg_id);
/*  59 */     _os_.marshal(this.use_all);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.main_card_id = _os_.unmarshal_long();
/*  65 */     this.cost_item_cfg_id = _os_.unmarshal_int();
/*  66 */     this.use_all = _os_.unmarshal_byte();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CCardUpgradeWithItemReq)) {
/*  76 */       CCardUpgradeWithItemReq _o_ = (CCardUpgradeWithItemReq)_o1_;
/*  77 */       if (this.main_card_id != _o_.main_card_id) return false;
/*  78 */       if (this.cost_item_cfg_id != _o_.cost_item_cfg_id) return false;
/*  79 */       if (this.use_all != _o_.use_all) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.main_card_id;
/*  88 */     _h_ += this.cost_item_cfg_id;
/*  89 */     _h_ += this.use_all;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.main_card_id).append(",");
/*  97 */     _sb_.append(this.cost_item_cfg_id).append(",");
/*  98 */     _sb_.append(this.use_all).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCardUpgradeWithItemReq _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = Long.signum(this.main_card_id - _o_.main_card_id);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.cost_item_cfg_id - _o_.cost_item_cfg_id;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.use_all - _o_.use_all;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\CCardUpgradeWithItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */