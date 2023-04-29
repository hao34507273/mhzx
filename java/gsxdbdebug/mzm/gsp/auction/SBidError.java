/*     */ package mzm.gsp.auction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SBidError
/*     */   extends __SBidError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627207;
/*     */   public static final int MONEY_NOT_ENOUGH = 1;
/*     */   public static final int SERVER_LEVEL_LOW = 2;
/*     */   public static final int ACTIVITY_CLOSE = 3;
/*     */   public static final int TURN_CLOSE = 4;
/*     */   public static final int ITEM_NOT_EXIST = 5;
/*     */   public static final int ITEM_BID_CLOSE = 6;
/*     */   public static final int MONEY_BELOW_MIN_PRICE = 7;
/*     */   public int errorcode;
/*     */   public int activityid;
/*     */   public int turnindex;
/*     */   public long moneycount;
/*     */   public ItemInfo iteminfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12627207;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBidError()
/*     */   {
/*  45 */     this.iteminfo = new ItemInfo();
/*     */   }
/*     */   
/*     */   public SBidError(int _errorcode_, int _activityid_, int _turnindex_, long _moneycount_, ItemInfo _iteminfo_) {
/*  49 */     this.errorcode = _errorcode_;
/*  50 */     this.activityid = _activityid_;
/*  51 */     this.turnindex = _turnindex_;
/*  52 */     this.moneycount = _moneycount_;
/*  53 */     this.iteminfo = _iteminfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  57 */     if (!this.iteminfo._validator_()) return false;
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.errorcode);
/*  63 */     _os_.marshal(this.activityid);
/*  64 */     _os_.marshal(this.turnindex);
/*  65 */     _os_.marshal(this.moneycount);
/*  66 */     _os_.marshal(this.iteminfo);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.errorcode = _os_.unmarshal_int();
/*  72 */     this.activityid = _os_.unmarshal_int();
/*  73 */     this.turnindex = _os_.unmarshal_int();
/*  74 */     this.moneycount = _os_.unmarshal_long();
/*  75 */     this.iteminfo.unmarshal(_os_);
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SBidError)) {
/*  85 */       SBidError _o_ = (SBidError)_o1_;
/*  86 */       if (this.errorcode != _o_.errorcode) return false;
/*  87 */       if (this.activityid != _o_.activityid) return false;
/*  88 */       if (this.turnindex != _o_.turnindex) return false;
/*  89 */       if (this.moneycount != _o_.moneycount) return false;
/*  90 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.errorcode;
/*  99 */     _h_ += this.activityid;
/* 100 */     _h_ += this.turnindex;
/* 101 */     _h_ += (int)this.moneycount;
/* 102 */     _h_ += this.iteminfo.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.errorcode).append(",");
/* 110 */     _sb_.append(this.activityid).append(",");
/* 111 */     _sb_.append(this.turnindex).append(",");
/* 112 */     _sb_.append(this.moneycount).append(",");
/* 113 */     _sb_.append(this.iteminfo).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SBidError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */