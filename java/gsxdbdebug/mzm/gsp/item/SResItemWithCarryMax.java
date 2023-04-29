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
/*     */ 
/*     */ 
/*     */ public class SResItemWithCarryMax
/*     */   extends __SResItemWithCarryMax__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584766;
/*     */   public int itemid;
/*     */   public int carrymax;
/*     */   public int addnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584766;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SResItemWithCarryMax() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SResItemWithCarryMax(int _itemid_, int _carrymax_, int _addnum_)
/*     */   {
/*  38 */     this.itemid = _itemid_;
/*  39 */     this.carrymax = _carrymax_;
/*  40 */     this.addnum = _addnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.itemid);
/*  49 */     _os_.marshal(this.carrymax);
/*  50 */     _os_.marshal(this.addnum);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.itemid = _os_.unmarshal_int();
/*  56 */     this.carrymax = _os_.unmarshal_int();
/*  57 */     this.addnum = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SResItemWithCarryMax)) {
/*  67 */       SResItemWithCarryMax _o_ = (SResItemWithCarryMax)_o1_;
/*  68 */       if (this.itemid != _o_.itemid) return false;
/*  69 */       if (this.carrymax != _o_.carrymax) return false;
/*  70 */       if (this.addnum != _o_.addnum) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.itemid;
/*  79 */     _h_ += this.carrymax;
/*  80 */     _h_ += this.addnum;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.itemid).append(",");
/*  88 */     _sb_.append(this.carrymax).append(",");
/*  89 */     _sb_.append(this.addnum).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SResItemWithCarryMax _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.itemid - _o_.itemid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.carrymax - _o_.carrymax;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.addnum - _o_.addnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResItemWithCarryMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */