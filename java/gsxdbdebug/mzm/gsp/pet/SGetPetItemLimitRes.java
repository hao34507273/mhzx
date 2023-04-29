/*     */ package mzm.gsp.pet;
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
/*     */ public class SGetPetItemLimitRes
/*     */   extends __SGetPetItemLimitRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590654;
/*     */   public int lianguitemleft;
/*     */   public int growitemleft;
/*     */   public long petid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590654;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetPetItemLimitRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetPetItemLimitRes(int _lianguitemleft_, int _growitemleft_, long _petid_)
/*     */   {
/*  38 */     this.lianguitemleft = _lianguitemleft_;
/*  39 */     this.growitemleft = _growitemleft_;
/*  40 */     this.petid = _petid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.lianguitemleft);
/*  49 */     _os_.marshal(this.growitemleft);
/*  50 */     _os_.marshal(this.petid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.lianguitemleft = _os_.unmarshal_int();
/*  56 */     this.growitemleft = _os_.unmarshal_int();
/*  57 */     this.petid = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetPetItemLimitRes)) {
/*  67 */       SGetPetItemLimitRes _o_ = (SGetPetItemLimitRes)_o1_;
/*  68 */       if (this.lianguitemleft != _o_.lianguitemleft) return false;
/*  69 */       if (this.growitemleft != _o_.growitemleft) return false;
/*  70 */       if (this.petid != _o_.petid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.lianguitemleft;
/*  79 */     _h_ += this.growitemleft;
/*  80 */     _h_ += (int)this.petid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.lianguitemleft).append(",");
/*  88 */     _sb_.append(this.growitemleft).append(",");
/*  89 */     _sb_.append(this.petid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetPetItemLimitRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.lianguitemleft - _o_.lianguitemleft;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.growitemleft - _o_.growitemleft;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SGetPetItemLimitRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */