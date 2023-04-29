/*     */ package mzm.gsp.superequipment;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.superequipment.main.PImproveSuperEquipmentLevel;
/*     */ 
/*     */ public class CImproveSuperEquipmentLevelReq
/*     */   extends __CImproveSuperEquipmentLevelReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618756;
/*     */   public int bag_id;
/*     */   public int grid;
/*     */   public int use_yuanbao;
/*     */   public long required_yuanbao;
/*     */   public long currency;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleId, new PImproveSuperEquipmentLevel(roleId, this.bag_id, this.grid, this.use_yuanbao != 0, this.required_yuanbao, this.currency));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12618756;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CImproveSuperEquipmentLevelReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CImproveSuperEquipmentLevelReq(int _bag_id_, int _grid_, int _use_yuanbao_, long _required_yuanbao_, long _currency_)
/*     */   {
/*  43 */     this.bag_id = _bag_id_;
/*  44 */     this.grid = _grid_;
/*  45 */     this.use_yuanbao = _use_yuanbao_;
/*  46 */     this.required_yuanbao = _required_yuanbao_;
/*  47 */     this.currency = _currency_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.bag_id);
/*  56 */     _os_.marshal(this.grid);
/*  57 */     _os_.marshal(this.use_yuanbao);
/*  58 */     _os_.marshal(this.required_yuanbao);
/*  59 */     _os_.marshal(this.currency);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.bag_id = _os_.unmarshal_int();
/*  65 */     this.grid = _os_.unmarshal_int();
/*  66 */     this.use_yuanbao = _os_.unmarshal_int();
/*  67 */     this.required_yuanbao = _os_.unmarshal_long();
/*  68 */     this.currency = _os_.unmarshal_long();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CImproveSuperEquipmentLevelReq)) {
/*  78 */       CImproveSuperEquipmentLevelReq _o_ = (CImproveSuperEquipmentLevelReq)_o1_;
/*  79 */       if (this.bag_id != _o_.bag_id) return false;
/*  80 */       if (this.grid != _o_.grid) return false;
/*  81 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/*  82 */       if (this.required_yuanbao != _o_.required_yuanbao) return false;
/*  83 */       if (this.currency != _o_.currency) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.bag_id;
/*  92 */     _h_ += this.grid;
/*  93 */     _h_ += this.use_yuanbao;
/*  94 */     _h_ += (int)this.required_yuanbao;
/*  95 */     _h_ += (int)this.currency;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.bag_id).append(",");
/* 103 */     _sb_.append(this.grid).append(",");
/* 104 */     _sb_.append(this.use_yuanbao).append(",");
/* 105 */     _sb_.append(this.required_yuanbao).append(",");
/* 106 */     _sb_.append(this.currency).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CImproveSuperEquipmentLevelReq _o_) {
/* 112 */     if (_o_ == this) return 0;
/* 113 */     int _c_ = 0;
/* 114 */     _c_ = this.bag_id - _o_.bag_id;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.grid - _o_.grid;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.use_yuanbao - _o_.use_yuanbao;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = Long.signum(this.required_yuanbao - _o_.required_yuanbao);
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = Long.signum(this.currency - _o_.currency);
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CImproveSuperEquipmentLevelReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */