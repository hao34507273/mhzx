/*     */ package mzm.gsp.auction;
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
/*     */ public class SBidRsp
/*     */   extends __SBidRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627203;
/*     */   public int activityid;
/*     */   public int turnindex;
/*     */   public int itemcfgid;
/*     */   public long moneycount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12627203;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBidRsp() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBidRsp(int _activityid_, int _turnindex_, int _itemcfgid_, long _moneycount_)
/*     */   {
/*  39 */     this.activityid = _activityid_;
/*  40 */     this.turnindex = _turnindex_;
/*  41 */     this.itemcfgid = _itemcfgid_;
/*  42 */     this.moneycount = _moneycount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.activityid);
/*  51 */     _os_.marshal(this.turnindex);
/*  52 */     _os_.marshal(this.itemcfgid);
/*  53 */     _os_.marshal(this.moneycount);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activityid = _os_.unmarshal_int();
/*  59 */     this.turnindex = _os_.unmarshal_int();
/*  60 */     this.itemcfgid = _os_.unmarshal_int();
/*  61 */     this.moneycount = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SBidRsp)) {
/*  71 */       SBidRsp _o_ = (SBidRsp)_o1_;
/*  72 */       if (this.activityid != _o_.activityid) return false;
/*  73 */       if (this.turnindex != _o_.turnindex) return false;
/*  74 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  75 */       if (this.moneycount != _o_.moneycount) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activityid;
/*  84 */     _h_ += this.turnindex;
/*  85 */     _h_ += this.itemcfgid;
/*  86 */     _h_ += (int)this.moneycount;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activityid).append(",");
/*  94 */     _sb_.append(this.turnindex).append(",");
/*  95 */     _sb_.append(this.itemcfgid).append(",");
/*  96 */     _sb_.append(this.moneycount).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBidRsp _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activityid - _o_.activityid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.turnindex - _o_.turnindex;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.itemcfgid - _o_.itemcfgid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.moneycount - _o_.moneycount);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SBidRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */