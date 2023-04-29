/*     */ package mzm.gsp.shanghui;
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
/*     */ public class SSellItemRes
/*     */   extends __SSellItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592641;
/*     */   public long earngold;
/*     */   public int cansellnum;
/*     */   public ShoppingItem iteminfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12592641;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSellItemRes()
/*     */   {
/*  35 */     this.iteminfo = new ShoppingItem();
/*     */   }
/*     */   
/*     */   public SSellItemRes(long _earngold_, int _cansellnum_, ShoppingItem _iteminfo_) {
/*  39 */     this.earngold = _earngold_;
/*  40 */     this.cansellnum = _cansellnum_;
/*  41 */     this.iteminfo = _iteminfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     if (!this.iteminfo._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.earngold);
/*  51 */     _os_.marshal(this.cansellnum);
/*  52 */     _os_.marshal(this.iteminfo);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.earngold = _os_.unmarshal_long();
/*  58 */     this.cansellnum = _os_.unmarshal_int();
/*  59 */     this.iteminfo.unmarshal(_os_);
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SSellItemRes)) {
/*  69 */       SSellItemRes _o_ = (SSellItemRes)_o1_;
/*  70 */       if (this.earngold != _o_.earngold) return false;
/*  71 */       if (this.cansellnum != _o_.cansellnum) return false;
/*  72 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.earngold;
/*  81 */     _h_ += this.cansellnum;
/*  82 */     _h_ += this.iteminfo.hashCode();
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.earngold).append(",");
/*  90 */     _sb_.append(this.cansellnum).append(",");
/*  91 */     _sb_.append(this.iteminfo).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSellItemRes _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.earngold - _o_.earngold);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.cansellnum - _o_.cansellnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.iteminfo.compareTo(_o_.iteminfo);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\SSellItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */