/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SDeletePetModelFailed
/*     */   extends __SDeletePetModelFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590708;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_PARAM = -4;
/*     */   public static final int ERROR_USED_CAN_NOT_DELETE = -5;
/*     */   public static final int ERROR_NOT_OWN_PET_MODEL = -6;
/*     */   public long pet_id;
/*     */   public int item_cfg_id;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590708;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDeletePetModelFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDeletePetModelFailed(long _pet_id_, int _item_cfg_id_, int _retcode_)
/*     */   {
/*  45 */     this.pet_id = _pet_id_;
/*  46 */     this.item_cfg_id = _item_cfg_id_;
/*  47 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.pet_id);
/*  56 */     _os_.marshal(this.item_cfg_id);
/*  57 */     _os_.marshal(this.retcode);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.pet_id = _os_.unmarshal_long();
/*  63 */     this.item_cfg_id = _os_.unmarshal_int();
/*  64 */     this.retcode = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SDeletePetModelFailed)) {
/*  74 */       SDeletePetModelFailed _o_ = (SDeletePetModelFailed)_o1_;
/*  75 */       if (this.pet_id != _o_.pet_id) return false;
/*  76 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/*  77 */       if (this.retcode != _o_.retcode) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.pet_id;
/*  86 */     _h_ += this.item_cfg_id;
/*  87 */     _h_ += this.retcode;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.pet_id).append(",");
/*  95 */     _sb_.append(this.item_cfg_id).append(",");
/*  96 */     _sb_.append(this.retcode).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SDeletePetModelFailed _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.item_cfg_id - _o_.item_cfg_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.retcode - _o_.retcode;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SDeletePetModelFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */