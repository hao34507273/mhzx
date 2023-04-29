/*     */ package mzm.gsp.singlebattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGatherBattleItemFail
/*     */   extends __SGatherBattleItemFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621594;
/*     */   public static final int FAIL_FIGHT = 1;
/*     */   public static final int FAIL_MOVE = 2;
/*     */   public static final int FAIL_BATTLE_END = 3;
/*     */   public static final int FAIL_ITEM_DISAPPEAR = 4;
/*     */   public static final int FAIL_OTHER_GATHERING = 5;
/*     */   public long instanceid;
/*     */   public int reason;
/*     */   public int gatheritemcfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621594;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGatherBattleItemFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGatherBattleItemFail(long _instanceid_, int _reason_, int _gatheritemcfgid_)
/*     */   {
/*  44 */     this.instanceid = _instanceid_;
/*  45 */     this.reason = _reason_;
/*  46 */     this.gatheritemcfgid = _gatheritemcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.instanceid);
/*  55 */     _os_.marshal(this.reason);
/*  56 */     _os_.marshal(this.gatheritemcfgid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.instanceid = _os_.unmarshal_long();
/*  62 */     this.reason = _os_.unmarshal_int();
/*  63 */     this.gatheritemcfgid = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SGatherBattleItemFail)) {
/*  73 */       SGatherBattleItemFail _o_ = (SGatherBattleItemFail)_o1_;
/*  74 */       if (this.instanceid != _o_.instanceid) return false;
/*  75 */       if (this.reason != _o_.reason) return false;
/*  76 */       if (this.gatheritemcfgid != _o_.gatheritemcfgid) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.instanceid;
/*  85 */     _h_ += this.reason;
/*  86 */     _h_ += this.gatheritemcfgid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.instanceid).append(",");
/*  94 */     _sb_.append(this.reason).append(",");
/*  95 */     _sb_.append(this.gatheritemcfgid).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGatherBattleItemFail _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = Long.signum(this.instanceid - _o_.instanceid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.reason - _o_.reason;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.gatheritemcfgid - _o_.gatheritemcfgid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SGatherBattleItemFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */