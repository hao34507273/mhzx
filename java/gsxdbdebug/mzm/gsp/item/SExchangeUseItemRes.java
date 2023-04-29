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
/*     */ public class SExchangeUseItemRes
/*     */   extends __SExchangeUseItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584765;
/*     */   public int exchangecfgid;
/*     */   public int exchangecount;
/*     */   public int itemid;
/*     */   public int num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584765;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SExchangeUseItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SExchangeUseItemRes(int _exchangecfgid_, int _exchangecount_, int _itemid_, int _num_)
/*     */   {
/*  37 */     this.exchangecfgid = _exchangecfgid_;
/*  38 */     this.exchangecount = _exchangecount_;
/*  39 */     this.itemid = _itemid_;
/*  40 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.exchangecfgid);
/*  49 */     _os_.marshal(this.exchangecount);
/*  50 */     _os_.marshal(this.itemid);
/*  51 */     _os_.marshal(this.num);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.exchangecfgid = _os_.unmarshal_int();
/*  57 */     this.exchangecount = _os_.unmarshal_int();
/*  58 */     this.itemid = _os_.unmarshal_int();
/*  59 */     this.num = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SExchangeUseItemRes)) {
/*  69 */       SExchangeUseItemRes _o_ = (SExchangeUseItemRes)_o1_;
/*  70 */       if (this.exchangecfgid != _o_.exchangecfgid) return false;
/*  71 */       if (this.exchangecount != _o_.exchangecount) return false;
/*  72 */       if (this.itemid != _o_.itemid) return false;
/*  73 */       if (this.num != _o_.num) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.exchangecfgid;
/*  82 */     _h_ += this.exchangecount;
/*  83 */     _h_ += this.itemid;
/*  84 */     _h_ += this.num;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.exchangecfgid).append(",");
/*  92 */     _sb_.append(this.exchangecount).append(",");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(this.num).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SExchangeUseItemRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.exchangecfgid - _o_.exchangecfgid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.exchangecount - _o_.exchangecount;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.itemid - _o_.itemid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.num - _o_.num;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SExchangeUseItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */