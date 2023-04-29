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
/*     */ public class SUseMoneyBagItemRes
/*     */   extends __SUseMoneyBagItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584826;
/*     */   public int moneytype;
/*     */   public int num;
/*     */   public int useditemnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584826;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseMoneyBagItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseMoneyBagItemRes(int _moneytype_, int _num_, int _useditemnum_)
/*     */   {
/*  36 */     this.moneytype = _moneytype_;
/*  37 */     this.num = _num_;
/*  38 */     this.useditemnum = _useditemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.moneytype);
/*  47 */     _os_.marshal(this.num);
/*  48 */     _os_.marshal(this.useditemnum);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.moneytype = _os_.unmarshal_int();
/*  54 */     this.num = _os_.unmarshal_int();
/*  55 */     this.useditemnum = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SUseMoneyBagItemRes)) {
/*  65 */       SUseMoneyBagItemRes _o_ = (SUseMoneyBagItemRes)_o1_;
/*  66 */       if (this.moneytype != _o_.moneytype) return false;
/*  67 */       if (this.num != _o_.num) return false;
/*  68 */       if (this.useditemnum != _o_.useditemnum) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.moneytype;
/*  77 */     _h_ += this.num;
/*  78 */     _h_ += this.useditemnum;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.moneytype).append(",");
/*  86 */     _sb_.append(this.num).append(",");
/*  87 */     _sb_.append(this.useditemnum).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseMoneyBagItemRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.moneytype - _o_.moneytype;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.num - _o_.num;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.useditemnum - _o_.useditemnum;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseMoneyBagItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */