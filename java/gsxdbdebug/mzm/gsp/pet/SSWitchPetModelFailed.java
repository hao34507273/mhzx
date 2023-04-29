/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSWitchPetModelFailed
/*     */   extends __SSWitchPetModelFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590707;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_PARAM = -4;
/*     */   public static final int ERROR_PET_ACTION_AFTER_FIGHT = -5;
/*     */   public static final int ERROR_NOT_OWN_PET_MODEL = -6;
/*     */   public static final int ERROR_TARGET_PET_MODEL_ALREADY_USED = -7;
/*     */   public long pet_id;
/*     */   public int item_cfg_id;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590707;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSWitchPetModelFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSWitchPetModelFailed(long _pet_id_, int _item_cfg_id_, int _retcode_)
/*     */   {
/*  46 */     this.pet_id = _pet_id_;
/*  47 */     this.item_cfg_id = _item_cfg_id_;
/*  48 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.pet_id);
/*  57 */     _os_.marshal(this.item_cfg_id);
/*  58 */     _os_.marshal(this.retcode);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.pet_id = _os_.unmarshal_long();
/*  64 */     this.item_cfg_id = _os_.unmarshal_int();
/*  65 */     this.retcode = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSWitchPetModelFailed)) {
/*  75 */       SSWitchPetModelFailed _o_ = (SSWitchPetModelFailed)_o1_;
/*  76 */       if (this.pet_id != _o_.pet_id) return false;
/*  77 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/*  78 */       if (this.retcode != _o_.retcode) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += (int)this.pet_id;
/*  87 */     _h_ += this.item_cfg_id;
/*  88 */     _h_ += this.retcode;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.pet_id).append(",");
/*  96 */     _sb_.append(this.item_cfg_id).append(",");
/*  97 */     _sb_.append(this.retcode).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSWitchPetModelFailed _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.item_cfg_id - _o_.item_cfg_id;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.retcode - _o_.retcode;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSWitchPetModelFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */