/*     */ package mzm.gsp.aircraft;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.aircraft.main.PCDyeAircraft;
/*     */ 
/*     */ public class CDyeAircraft
/*     */   extends __CDyeAircraft__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624643;
/*     */   public int aircraft_cfg_id;
/*     */   public int dye_color_id;
/*     */   public int is_use_yuan_bao;
/*     */   public int client_need_yuan_bao;
/*     */   public long client_yuan_bao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCDyeAircraft(roleId, this.aircraft_cfg_id, this.dye_color_id, this.is_use_yuan_bao, this.client_need_yuan_bao, this.client_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12624643;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CDyeAircraft() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CDyeAircraft(int _aircraft_cfg_id_, int _dye_color_id_, int _is_use_yuan_bao_, int _client_need_yuan_bao_, long _client_yuan_bao_)
/*     */   {
/*  47 */     this.aircraft_cfg_id = _aircraft_cfg_id_;
/*  48 */     this.dye_color_id = _dye_color_id_;
/*  49 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*  50 */     this.client_need_yuan_bao = _client_need_yuan_bao_;
/*  51 */     this.client_yuan_bao = _client_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.aircraft_cfg_id);
/*  60 */     _os_.marshal(this.dye_color_id);
/*  61 */     _os_.marshal(this.is_use_yuan_bao);
/*  62 */     _os_.marshal(this.client_need_yuan_bao);
/*  63 */     _os_.marshal(this.client_yuan_bao);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.aircraft_cfg_id = _os_.unmarshal_int();
/*  69 */     this.dye_color_id = _os_.unmarshal_int();
/*  70 */     this.is_use_yuan_bao = _os_.unmarshal_int();
/*  71 */     this.client_need_yuan_bao = _os_.unmarshal_int();
/*  72 */     this.client_yuan_bao = _os_.unmarshal_long();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof CDyeAircraft)) {
/*  82 */       CDyeAircraft _o_ = (CDyeAircraft)_o1_;
/*  83 */       if (this.aircraft_cfg_id != _o_.aircraft_cfg_id) return false;
/*  84 */       if (this.dye_color_id != _o_.dye_color_id) return false;
/*  85 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  86 */       if (this.client_need_yuan_bao != _o_.client_need_yuan_bao) return false;
/*  87 */       if (this.client_yuan_bao != _o_.client_yuan_bao) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.aircraft_cfg_id;
/*  96 */     _h_ += this.dye_color_id;
/*  97 */     _h_ += this.is_use_yuan_bao;
/*  98 */     _h_ += this.client_need_yuan_bao;
/*  99 */     _h_ += (int)this.client_yuan_bao;
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.aircraft_cfg_id).append(",");
/* 107 */     _sb_.append(this.dye_color_id).append(",");
/* 108 */     _sb_.append(this.is_use_yuan_bao).append(",");
/* 109 */     _sb_.append(this.client_need_yuan_bao).append(",");
/* 110 */     _sb_.append(this.client_yuan_bao).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CDyeAircraft _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.aircraft_cfg_id - _o_.aircraft_cfg_id;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.dye_color_id - _o_.dye_color_id;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.is_use_yuan_bao - _o_.is_use_yuan_bao;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.client_need_yuan_bao - _o_.client_need_yuan_bao;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = Long.signum(this.client_yuan_bao - _o_.client_yuan_bao);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\CDyeAircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */