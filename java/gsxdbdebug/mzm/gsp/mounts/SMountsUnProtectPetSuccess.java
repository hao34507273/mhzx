/*     */ package mzm.gsp.mounts;
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
/*     */ 
/*     */ public class SMountsUnProtectPetSuccess
/*     */   extends __SMountsUnProtectPetSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606229;
/*     */   public int cell_id;
/*     */   public int protect_index;
/*     */   public long pet_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606229;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SMountsUnProtectPetSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMountsUnProtectPetSuccess(int _cell_id_, int _protect_index_, long _pet_id_)
/*     */   {
/*  38 */     this.cell_id = _cell_id_;
/*  39 */     this.protect_index = _protect_index_;
/*  40 */     this.pet_id = _pet_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.cell_id);
/*  49 */     _os_.marshal(this.protect_index);
/*  50 */     _os_.marshal(this.pet_id);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.cell_id = _os_.unmarshal_int();
/*  56 */     this.protect_index = _os_.unmarshal_int();
/*  57 */     this.pet_id = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SMountsUnProtectPetSuccess)) {
/*  67 */       SMountsUnProtectPetSuccess _o_ = (SMountsUnProtectPetSuccess)_o1_;
/*  68 */       if (this.cell_id != _o_.cell_id) return false;
/*  69 */       if (this.protect_index != _o_.protect_index) return false;
/*  70 */       if (this.pet_id != _o_.pet_id) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.cell_id;
/*  79 */     _h_ += this.protect_index;
/*  80 */     _h_ += (int)this.pet_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.cell_id).append(",");
/*  88 */     _sb_.append(this.protect_index).append(",");
/*  89 */     _sb_.append(this.pet_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMountsUnProtectPetSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.cell_id - _o_.cell_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.protect_index - _o_.protect_index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsUnProtectPetSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */