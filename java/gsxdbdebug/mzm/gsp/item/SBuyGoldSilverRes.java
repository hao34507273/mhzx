/*     */ package mzm.gsp.item;
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
/*     */ public class SBuyGoldSilverRes
/*     */   extends __SBuyGoldSilverRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584789;
/*     */   public int yuanbaonum;
/*     */   public int moneytype;
/*     */   public int value;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584789;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SBuyGoldSilverRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBuyGoldSilverRes(int _yuanbaonum_, int _moneytype_, int _value_)
/*     */   {
/*  36 */     this.yuanbaonum = _yuanbaonum_;
/*  37 */     this.moneytype = _moneytype_;
/*  38 */     this.value = _value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.yuanbaonum);
/*  47 */     _os_.marshal(this.moneytype);
/*  48 */     _os_.marshal(this.value);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.yuanbaonum = _os_.unmarshal_int();
/*  54 */     this.moneytype = _os_.unmarshal_int();
/*  55 */     this.value = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SBuyGoldSilverRes)) {
/*  65 */       SBuyGoldSilverRes _o_ = (SBuyGoldSilverRes)_o1_;
/*  66 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  67 */       if (this.moneytype != _o_.moneytype) return false;
/*  68 */       if (this.value != _o_.value) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.yuanbaonum;
/*  77 */     _h_ += this.moneytype;
/*  78 */     _h_ += this.value;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.yuanbaonum).append(",");
/*  86 */     _sb_.append(this.moneytype).append(",");
/*  87 */     _sb_.append(this.value).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyGoldSilverRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.yuanbaonum - _o_.yuanbaonum;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.moneytype - _o_.moneytype;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.value - _o_.value;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SBuyGoldSilverRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */