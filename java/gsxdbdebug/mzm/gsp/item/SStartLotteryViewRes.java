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
/*     */ public class SStartLotteryViewRes
/*     */   extends __SStartLotteryViewRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584841;
/*     */   public int lotteryviewid;
/*     */   public int finalindex;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584841;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartLotteryViewRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SStartLotteryViewRes(int _lotteryviewid_, int _finalindex_, int _itemid_, int _itemnum_)
/*     */   {
/*  39 */     this.lotteryviewid = _lotteryviewid_;
/*  40 */     this.finalindex = _finalindex_;
/*  41 */     this.itemid = _itemid_;
/*  42 */     this.itemnum = _itemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.lotteryviewid);
/*  51 */     _os_.marshal(this.finalindex);
/*  52 */     _os_.marshal(this.itemid);
/*  53 */     _os_.marshal(this.itemnum);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.lotteryviewid = _os_.unmarshal_int();
/*  59 */     this.finalindex = _os_.unmarshal_int();
/*  60 */     this.itemid = _os_.unmarshal_int();
/*  61 */     this.itemnum = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SStartLotteryViewRes)) {
/*  71 */       SStartLotteryViewRes _o_ = (SStartLotteryViewRes)_o1_;
/*  72 */       if (this.lotteryviewid != _o_.lotteryviewid) return false;
/*  73 */       if (this.finalindex != _o_.finalindex) return false;
/*  74 */       if (this.itemid != _o_.itemid) return false;
/*  75 */       if (this.itemnum != _o_.itemnum) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.lotteryviewid;
/*  84 */     _h_ += this.finalindex;
/*  85 */     _h_ += this.itemid;
/*  86 */     _h_ += this.itemnum;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.lotteryviewid).append(",");
/*  94 */     _sb_.append(this.finalindex).append(",");
/*  95 */     _sb_.append(this.itemid).append(",");
/*  96 */     _sb_.append(this.itemnum).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStartLotteryViewRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.lotteryviewid - _o_.lotteryviewid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.finalindex - _o_.finalindex;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.itemid - _o_.itemid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.itemnum - _o_.itemnum;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SStartLotteryViewRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */