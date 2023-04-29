/*     */ package mzm.gsp.guaji;
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
/*     */ public class SGetPointRes
/*     */   extends __SGetPointRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12591109;
/*     */   public int addfrozenpoolnum;
/*     */   public int getingpoolpointnum;
/*     */   public int frozenpoolpointnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12591109;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetPointRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetPointRes(int _addfrozenpoolnum_, int _getingpoolpointnum_, int _frozenpoolpointnum_)
/*     */   {
/*  38 */     this.addfrozenpoolnum = _addfrozenpoolnum_;
/*  39 */     this.getingpoolpointnum = _getingpoolpointnum_;
/*  40 */     this.frozenpoolpointnum = _frozenpoolpointnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.addfrozenpoolnum);
/*  49 */     _os_.marshal(this.getingpoolpointnum);
/*  50 */     _os_.marshal(this.frozenpoolpointnum);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.addfrozenpoolnum = _os_.unmarshal_int();
/*  56 */     this.getingpoolpointnum = _os_.unmarshal_int();
/*  57 */     this.frozenpoolpointnum = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetPointRes)) {
/*  67 */       SGetPointRes _o_ = (SGetPointRes)_o1_;
/*  68 */       if (this.addfrozenpoolnum != _o_.addfrozenpoolnum) return false;
/*  69 */       if (this.getingpoolpointnum != _o_.getingpoolpointnum) return false;
/*  70 */       if (this.frozenpoolpointnum != _o_.frozenpoolpointnum) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.addfrozenpoolnum;
/*  79 */     _h_ += this.getingpoolpointnum;
/*  80 */     _h_ += this.frozenpoolpointnum;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.addfrozenpoolnum).append(",");
/*  88 */     _sb_.append(this.getingpoolpointnum).append(",");
/*  89 */     _sb_.append(this.frozenpoolpointnum).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetPointRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.addfrozenpoolnum - _o_.addfrozenpoolnum;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.getingpoolpointnum - _o_.getingpoolpointnum;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.frozenpoolpointnum - _o_.frozenpoolpointnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\SGetPointRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */