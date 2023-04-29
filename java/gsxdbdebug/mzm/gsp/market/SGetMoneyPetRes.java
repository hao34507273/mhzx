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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetMoneyPetRes
/*     */   extends __SGetMoneyPetRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601398;
/*     */   public long marketid;
/*     */   public int petcfgid;
/*     */   public int money;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601398;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetMoneyPetRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetMoneyPetRes(long _marketid_, int _petcfgid_, int _money_)
/*     */   {
/*  38 */     this.marketid = _marketid_;
/*  39 */     this.petcfgid = _petcfgid_;
/*  40 */     this.money = _money_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.marketid);
/*  49 */     _os_.marshal(this.petcfgid);
/*  50 */     _os_.marshal(this.money);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.marketid = _os_.unmarshal_long();
/*  56 */     this.petcfgid = _os_.unmarshal_int();
/*  57 */     this.money = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetMoneyPetRes)) {
/*  67 */       SGetMoneyPetRes _o_ = (SGetMoneyPetRes)_o1_;
/*  68 */       if (this.marketid != _o_.marketid) return false;
/*  69 */       if (this.petcfgid != _o_.petcfgid) return false;
/*  70 */       if (this.money != _o_.money) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.marketid;
/*  79 */     _h_ += this.petcfgid;
/*  80 */     _h_ += this.money;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.marketid).append(",");
/*  88 */     _sb_.append(this.petcfgid).append(",");
/*  89 */     _sb_.append(this.money).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetMoneyPetRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.marketid - _o_.marketid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.petcfgid - _o_.petcfgid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.money - _o_.money;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SGetMoneyPetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */