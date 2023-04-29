/*     */ package mzm.gsp.market;
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
/*     */ public class SBuyPetRes
/*     */   extends __SBuyPetRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601350;
/*     */   public long marketid;
/*     */   public int petcfgid;
/*     */   public int price;
/*     */   public int usemoney;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601350;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyPetRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBuyPetRes(long _marketid_, int _petcfgid_, int _price_, int _usemoney_)
/*     */   {
/*  37 */     this.marketid = _marketid_;
/*  38 */     this.petcfgid = _petcfgid_;
/*  39 */     this.price = _price_;
/*  40 */     this.usemoney = _usemoney_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.marketid);
/*  49 */     _os_.marshal(this.petcfgid);
/*  50 */     _os_.marshal(this.price);
/*  51 */     _os_.marshal(this.usemoney);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.marketid = _os_.unmarshal_long();
/*  57 */     this.petcfgid = _os_.unmarshal_int();
/*  58 */     this.price = _os_.unmarshal_int();
/*  59 */     this.usemoney = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SBuyPetRes)) {
/*  69 */       SBuyPetRes _o_ = (SBuyPetRes)_o1_;
/*  70 */       if (this.marketid != _o_.marketid) return false;
/*  71 */       if (this.petcfgid != _o_.petcfgid) return false;
/*  72 */       if (this.price != _o_.price) return false;
/*  73 */       if (this.usemoney != _o_.usemoney) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.marketid;
/*  82 */     _h_ += this.petcfgid;
/*  83 */     _h_ += this.price;
/*  84 */     _h_ += this.usemoney;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.marketid).append(",");
/*  92 */     _sb_.append(this.petcfgid).append(",");
/*  93 */     _sb_.append(this.price).append(",");
/*  94 */     _sb_.append(this.usemoney).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyPetRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.price - _o_.price;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.usemoney - _o_.usemoney;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SBuyPetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */