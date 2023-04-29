/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChangeCourtYardFurnitureSuccess
/*     */   extends __SChangeCourtYardFurnitureSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605515;
/*     */   public int furniture_cfg_id;
/*     */   public long furniture_uuid;
/*     */   public long unfurniture_uuid;
/*     */   public int unfurniture_cfg_id;
/*     */   public int change_beautiful_value;
/*     */   public int furniture_pos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605515;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChangeCourtYardFurnitureSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChangeCourtYardFurnitureSuccess(int _furniture_cfg_id_, long _furniture_uuid_, long _unfurniture_uuid_, int _unfurniture_cfg_id_, int _change_beautiful_value_, int _furniture_pos_)
/*     */   {
/*  39 */     this.furniture_cfg_id = _furniture_cfg_id_;
/*  40 */     this.furniture_uuid = _furniture_uuid_;
/*  41 */     this.unfurniture_uuid = _unfurniture_uuid_;
/*  42 */     this.unfurniture_cfg_id = _unfurniture_cfg_id_;
/*  43 */     this.change_beautiful_value = _change_beautiful_value_;
/*  44 */     this.furniture_pos = _furniture_pos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.furniture_cfg_id);
/*  53 */     _os_.marshal(this.furniture_uuid);
/*  54 */     _os_.marshal(this.unfurniture_uuid);
/*  55 */     _os_.marshal(this.unfurniture_cfg_id);
/*  56 */     _os_.marshal(this.change_beautiful_value);
/*  57 */     _os_.marshal(this.furniture_pos);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.furniture_cfg_id = _os_.unmarshal_int();
/*  63 */     this.furniture_uuid = _os_.unmarshal_long();
/*  64 */     this.unfurniture_uuid = _os_.unmarshal_long();
/*  65 */     this.unfurniture_cfg_id = _os_.unmarshal_int();
/*  66 */     this.change_beautiful_value = _os_.unmarshal_int();
/*  67 */     this.furniture_pos = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SChangeCourtYardFurnitureSuccess)) {
/*  77 */       SChangeCourtYardFurnitureSuccess _o_ = (SChangeCourtYardFurnitureSuccess)_o1_;
/*  78 */       if (this.furniture_cfg_id != _o_.furniture_cfg_id) return false;
/*  79 */       if (this.furniture_uuid != _o_.furniture_uuid) return false;
/*  80 */       if (this.unfurniture_uuid != _o_.unfurniture_uuid) return false;
/*  81 */       if (this.unfurniture_cfg_id != _o_.unfurniture_cfg_id) return false;
/*  82 */       if (this.change_beautiful_value != _o_.change_beautiful_value) return false;
/*  83 */       if (this.furniture_pos != _o_.furniture_pos) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.furniture_cfg_id;
/*  92 */     _h_ += (int)this.furniture_uuid;
/*  93 */     _h_ += (int)this.unfurniture_uuid;
/*  94 */     _h_ += this.unfurniture_cfg_id;
/*  95 */     _h_ += this.change_beautiful_value;
/*  96 */     _h_ += this.furniture_pos;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.furniture_cfg_id).append(",");
/* 104 */     _sb_.append(this.furniture_uuid).append(",");
/* 105 */     _sb_.append(this.unfurniture_uuid).append(",");
/* 106 */     _sb_.append(this.unfurniture_cfg_id).append(",");
/* 107 */     _sb_.append(this.change_beautiful_value).append(",");
/* 108 */     _sb_.append(this.furniture_pos).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChangeCourtYardFurnitureSuccess _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.furniture_cfg_id - _o_.furniture_cfg_id;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = Long.signum(this.furniture_uuid - _o_.furniture_uuid);
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = Long.signum(this.unfurniture_uuid - _o_.unfurniture_uuid);
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.unfurniture_cfg_id - _o_.unfurniture_cfg_id;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.change_beautiful_value - _o_.change_beautiful_value;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.furniture_pos - _o_.furniture_pos;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SChangeCourtYardFurnitureSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */