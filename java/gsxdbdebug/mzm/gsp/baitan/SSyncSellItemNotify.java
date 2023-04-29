/*     */ package mzm.gsp.baitan;
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
/*     */ public class SSyncSellItemNotify
/*     */   extends __SSyncSellItemNotify__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584976;
/*     */   public long shoppingid;
/*     */   public int num;
/*     */   public int sellnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584976;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncSellItemNotify() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncSellItemNotify(long _shoppingid_, int _num_, int _sellnum_)
/*     */   {
/*  38 */     this.shoppingid = _shoppingid_;
/*  39 */     this.num = _num_;
/*  40 */     this.sellnum = _sellnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.shoppingid);
/*  49 */     _os_.marshal(this.num);
/*  50 */     _os_.marshal(this.sellnum);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.shoppingid = _os_.unmarshal_long();
/*  56 */     this.num = _os_.unmarshal_int();
/*  57 */     this.sellnum = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSyncSellItemNotify)) {
/*  67 */       SSyncSellItemNotify _o_ = (SSyncSellItemNotify)_o1_;
/*  68 */       if (this.shoppingid != _o_.shoppingid) return false;
/*  69 */       if (this.num != _o_.num) return false;
/*  70 */       if (this.sellnum != _o_.sellnum) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.shoppingid;
/*  79 */     _h_ += this.num;
/*  80 */     _h_ += this.sellnum;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.shoppingid).append(",");
/*  88 */     _sb_.append(this.num).append(",");
/*  89 */     _sb_.append(this.sellnum).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncSellItemNotify _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.shoppingid - _o_.shoppingid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.num - _o_.num;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.sellnum - _o_.sellnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SSyncSellItemNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */