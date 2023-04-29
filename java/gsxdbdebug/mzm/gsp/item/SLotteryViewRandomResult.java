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
/*     */ public class SLotteryViewRandomResult
/*     */   extends __SLotteryViewRandomResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584795;
/*     */   public int lotteryviewid;
/*     */   public int finalindex;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584795;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLotteryViewRandomResult() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SLotteryViewRandomResult(int _lotteryviewid_, int _finalindex_, int _itemid_, int _itemnum_)
/*     */   {
/*  37 */     this.lotteryviewid = _lotteryviewid_;
/*  38 */     this.finalindex = _finalindex_;
/*  39 */     this.itemid = _itemid_;
/*  40 */     this.itemnum = _itemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.lotteryviewid);
/*  49 */     _os_.marshal(this.finalindex);
/*  50 */     _os_.marshal(this.itemid);
/*  51 */     _os_.marshal(this.itemnum);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.lotteryviewid = _os_.unmarshal_int();
/*  57 */     this.finalindex = _os_.unmarshal_int();
/*  58 */     this.itemid = _os_.unmarshal_int();
/*  59 */     this.itemnum = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SLotteryViewRandomResult)) {
/*  69 */       SLotteryViewRandomResult _o_ = (SLotteryViewRandomResult)_o1_;
/*  70 */       if (this.lotteryviewid != _o_.lotteryviewid) return false;
/*  71 */       if (this.finalindex != _o_.finalindex) return false;
/*  72 */       if (this.itemid != _o_.itemid) return false;
/*  73 */       if (this.itemnum != _o_.itemnum) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.lotteryviewid;
/*  82 */     _h_ += this.finalindex;
/*  83 */     _h_ += this.itemid;
/*  84 */     _h_ += this.itemnum;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.lotteryviewid).append(",");
/*  92 */     _sb_.append(this.finalindex).append(",");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(this.itemnum).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLotteryViewRandomResult _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.lotteryviewid - _o_.lotteryviewid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.finalindex - _o_.finalindex;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.itemid - _o_.itemid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.itemnum - _o_.itemnum;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SLotteryViewRandomResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */