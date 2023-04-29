/*     */ package mzm.gsp.auction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.auction.main.AuctionOneByOneManager;
/*     */ import mzm.gsp.auction.main.PCBidReq;
/*     */ 
/*     */ public class CBidReq
/*     */   extends __CBidReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627206;
/*     */   public int activityid;
/*     */   public int turnindex;
/*     */   public int itemcfgid;
/*     */   public long moneycount;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId <= 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityid), new PCBidReq(roleId, this.activityid, this.turnindex, this.itemcfgid, this.moneycount));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12627206;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBidReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBidReq(int _activityid_, int _turnindex_, int _itemcfgid_, long _moneycount_)
/*     */   {
/*  46 */     this.activityid = _activityid_;
/*  47 */     this.turnindex = _turnindex_;
/*  48 */     this.itemcfgid = _itemcfgid_;
/*  49 */     this.moneycount = _moneycount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.activityid);
/*  58 */     _os_.marshal(this.turnindex);
/*  59 */     _os_.marshal(this.itemcfgid);
/*  60 */     _os_.marshal(this.moneycount);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.activityid = _os_.unmarshal_int();
/*  66 */     this.turnindex = _os_.unmarshal_int();
/*  67 */     this.itemcfgid = _os_.unmarshal_int();
/*  68 */     this.moneycount = _os_.unmarshal_long();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CBidReq)) {
/*  78 */       CBidReq _o_ = (CBidReq)_o1_;
/*  79 */       if (this.activityid != _o_.activityid) return false;
/*  80 */       if (this.turnindex != _o_.turnindex) return false;
/*  81 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  82 */       if (this.moneycount != _o_.moneycount) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.activityid;
/*  91 */     _h_ += this.turnindex;
/*  92 */     _h_ += this.itemcfgid;
/*  93 */     _h_ += (int)this.moneycount;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.activityid).append(",");
/* 101 */     _sb_.append(this.turnindex).append(",");
/* 102 */     _sb_.append(this.itemcfgid).append(",");
/* 103 */     _sb_.append(this.moneycount).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBidReq _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.activityid - _o_.activityid;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.turnindex - _o_.turnindex;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.itemcfgid - _o_.itemcfgid;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.moneycount - _o_.moneycount);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\CBidReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */