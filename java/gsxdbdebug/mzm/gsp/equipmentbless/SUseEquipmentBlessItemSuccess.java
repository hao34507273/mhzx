/*     */ package mzm.gsp.equipmentbless;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SUseEquipmentBlessItemSuccess
/*     */   extends __SUseEquipmentBlessItemSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12626436;
/*     */   public long equipment_uuid;
/*     */   public int used_count;
/*     */   public int success_count;
/*     */   public int added_exp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12626436;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseEquipmentBlessItemSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseEquipmentBlessItemSuccess(long _equipment_uuid_, int _used_count_, int _success_count_, int _added_exp_)
/*     */   {
/*  39 */     this.equipment_uuid = _equipment_uuid_;
/*  40 */     this.used_count = _used_count_;
/*  41 */     this.success_count = _success_count_;
/*  42 */     this.added_exp = _added_exp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.equipment_uuid);
/*  51 */     _os_.marshal(this.used_count);
/*  52 */     _os_.marshal(this.success_count);
/*  53 */     _os_.marshal(this.added_exp);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.equipment_uuid = _os_.unmarshal_long();
/*  59 */     this.used_count = _os_.unmarshal_int();
/*  60 */     this.success_count = _os_.unmarshal_int();
/*  61 */     this.added_exp = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SUseEquipmentBlessItemSuccess)) {
/*  71 */       SUseEquipmentBlessItemSuccess _o_ = (SUseEquipmentBlessItemSuccess)_o1_;
/*  72 */       if (this.equipment_uuid != _o_.equipment_uuid) return false;
/*  73 */       if (this.used_count != _o_.used_count) return false;
/*  74 */       if (this.success_count != _o_.success_count) return false;
/*  75 */       if (this.added_exp != _o_.added_exp) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.equipment_uuid;
/*  84 */     _h_ += this.used_count;
/*  85 */     _h_ += this.success_count;
/*  86 */     _h_ += this.added_exp;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.equipment_uuid).append(",");
/*  94 */     _sb_.append(this.used_count).append(",");
/*  95 */     _sb_.append(this.success_count).append(",");
/*  96 */     _sb_.append(this.added_exp).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseEquipmentBlessItemSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.equipment_uuid - _o_.equipment_uuid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.used_count - _o_.used_count;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.success_count - _o_.success_count;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.added_exp - _o_.added_exp;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\SUseEquipmentBlessItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */