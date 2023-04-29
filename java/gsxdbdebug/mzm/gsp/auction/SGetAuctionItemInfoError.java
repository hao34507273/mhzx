/*     */ package mzm.gsp.auction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetAuctionItemInfoError
/*     */   extends __SGetAuctionItemInfoError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627210;
/*     */   public static final int SERVER_LEVEL_LOW = 1;
/*     */   public static final int ACTIVITY_CLOSE = 2;
/*     */   public static final int ITEM_NOT_EXIST = 3;
/*     */   public int activityid;
/*     */   public int turnindex;
/*     */   public int itemcfgid;
/*     */   public int errorcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12627210;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetAuctionItemInfoError() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetAuctionItemInfoError(int _activityid_, int _turnindex_, int _itemcfgid_, int _errorcode_)
/*     */   {
/*  41 */     this.activityid = _activityid_;
/*  42 */     this.turnindex = _turnindex_;
/*  43 */     this.itemcfgid = _itemcfgid_;
/*  44 */     this.errorcode = _errorcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activityid);
/*  53 */     _os_.marshal(this.turnindex);
/*  54 */     _os_.marshal(this.itemcfgid);
/*  55 */     _os_.marshal(this.errorcode);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activityid = _os_.unmarshal_int();
/*  61 */     this.turnindex = _os_.unmarshal_int();
/*  62 */     this.itemcfgid = _os_.unmarshal_int();
/*  63 */     this.errorcode = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SGetAuctionItemInfoError)) {
/*  73 */       SGetAuctionItemInfoError _o_ = (SGetAuctionItemInfoError)_o1_;
/*  74 */       if (this.activityid != _o_.activityid) return false;
/*  75 */       if (this.turnindex != _o_.turnindex) return false;
/*  76 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  77 */       if (this.errorcode != _o_.errorcode) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activityid;
/*  86 */     _h_ += this.turnindex;
/*  87 */     _h_ += this.itemcfgid;
/*  88 */     _h_ += this.errorcode;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.activityid).append(",");
/*  96 */     _sb_.append(this.turnindex).append(",");
/*  97 */     _sb_.append(this.itemcfgid).append(",");
/*  98 */     _sb_.append(this.errorcode).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetAuctionItemInfoError _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.activityid - _o_.activityid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.turnindex - _o_.turnindex;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.itemcfgid - _o_.itemcfgid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.errorcode - _o_.errorcode;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SGetAuctionItemInfoError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */