/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SResUseTurntableTypeLottery
/*     */   extends __SResUseTurntableTypeLottery__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584782;
/*     */   public int lotteryitemid;
/*     */   public int finalindex;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   public int exptype;
/*     */   public int expnum;
/*     */   public int moneytype;
/*     */   public int moneynum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584782;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SResUseTurntableTypeLottery() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SResUseTurntableTypeLottery(int _lotteryitemid_, int _finalindex_, int _itemid_, int _itemnum_, int _exptype_, int _expnum_, int _moneytype_, int _moneynum_)
/*     */   {
/*  41 */     this.lotteryitemid = _lotteryitemid_;
/*  42 */     this.finalindex = _finalindex_;
/*  43 */     this.itemid = _itemid_;
/*  44 */     this.itemnum = _itemnum_;
/*  45 */     this.exptype = _exptype_;
/*  46 */     this.expnum = _expnum_;
/*  47 */     this.moneytype = _moneytype_;
/*  48 */     this.moneynum = _moneynum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.lotteryitemid);
/*  57 */     _os_.marshal(this.finalindex);
/*  58 */     _os_.marshal(this.itemid);
/*  59 */     _os_.marshal(this.itemnum);
/*  60 */     _os_.marshal(this.exptype);
/*  61 */     _os_.marshal(this.expnum);
/*  62 */     _os_.marshal(this.moneytype);
/*  63 */     _os_.marshal(this.moneynum);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.lotteryitemid = _os_.unmarshal_int();
/*  69 */     this.finalindex = _os_.unmarshal_int();
/*  70 */     this.itemid = _os_.unmarshal_int();
/*  71 */     this.itemnum = _os_.unmarshal_int();
/*  72 */     this.exptype = _os_.unmarshal_int();
/*  73 */     this.expnum = _os_.unmarshal_int();
/*  74 */     this.moneytype = _os_.unmarshal_int();
/*  75 */     this.moneynum = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SResUseTurntableTypeLottery)) {
/*  85 */       SResUseTurntableTypeLottery _o_ = (SResUseTurntableTypeLottery)_o1_;
/*  86 */       if (this.lotteryitemid != _o_.lotteryitemid) return false;
/*  87 */       if (this.finalindex != _o_.finalindex) return false;
/*  88 */       if (this.itemid != _o_.itemid) return false;
/*  89 */       if (this.itemnum != _o_.itemnum) return false;
/*  90 */       if (this.exptype != _o_.exptype) return false;
/*  91 */       if (this.expnum != _o_.expnum) return false;
/*  92 */       if (this.moneytype != _o_.moneytype) return false;
/*  93 */       if (this.moneynum != _o_.moneynum) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.lotteryitemid;
/* 102 */     _h_ += this.finalindex;
/* 103 */     _h_ += this.itemid;
/* 104 */     _h_ += this.itemnum;
/* 105 */     _h_ += this.exptype;
/* 106 */     _h_ += this.expnum;
/* 107 */     _h_ += this.moneytype;
/* 108 */     _h_ += this.moneynum;
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.lotteryitemid).append(",");
/* 116 */     _sb_.append(this.finalindex).append(",");
/* 117 */     _sb_.append(this.itemid).append(",");
/* 118 */     _sb_.append(this.itemnum).append(",");
/* 119 */     _sb_.append(this.exptype).append(",");
/* 120 */     _sb_.append(this.expnum).append(",");
/* 121 */     _sb_.append(this.moneytype).append(",");
/* 122 */     _sb_.append(this.moneynum).append(",");
/* 123 */     _sb_.append(")");
/* 124 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SResUseTurntableTypeLottery _o_) {
/* 128 */     if (_o_ == this) return 0;
/* 129 */     int _c_ = 0;
/* 130 */     _c_ = this.lotteryitemid - _o_.lotteryitemid;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = this.finalindex - _o_.finalindex;
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     _c_ = this.itemid - _o_.itemid;
/* 135 */     if (0 != _c_) return _c_;
/* 136 */     _c_ = this.itemnum - _o_.itemnum;
/* 137 */     if (0 != _c_) return _c_;
/* 138 */     _c_ = this.exptype - _o_.exptype;
/* 139 */     if (0 != _c_) return _c_;
/* 140 */     _c_ = this.expnum - _o_.expnum;
/* 141 */     if (0 != _c_) return _c_;
/* 142 */     _c_ = this.moneytype - _o_.moneytype;
/* 143 */     if (0 != _c_) return _c_;
/* 144 */     _c_ = this.moneynum - _o_.moneynum;
/* 145 */     if (0 != _c_) return _c_;
/* 146 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResUseTurntableTypeLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */