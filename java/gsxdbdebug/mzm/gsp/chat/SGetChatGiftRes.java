/*     */ package mzm.gsp.chat;
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
/*     */ 
/*     */ public class SGetChatGiftRes
/*     */   extends __SGetChatGiftRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585258;
/*     */   public int money;
/*     */   public int moneytype;
/*     */   public int channeltype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585258;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetChatGiftRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetChatGiftRes(int _money_, int _moneytype_, int _channeltype_)
/*     */   {
/*  38 */     this.money = _money_;
/*  39 */     this.moneytype = _moneytype_;
/*  40 */     this.channeltype = _channeltype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.money);
/*  49 */     _os_.marshal(this.moneytype);
/*  50 */     _os_.marshal(this.channeltype);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.money = _os_.unmarshal_int();
/*  56 */     this.moneytype = _os_.unmarshal_int();
/*  57 */     this.channeltype = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetChatGiftRes)) {
/*  67 */       SGetChatGiftRes _o_ = (SGetChatGiftRes)_o1_;
/*  68 */       if (this.money != _o_.money) return false;
/*  69 */       if (this.moneytype != _o_.moneytype) return false;
/*  70 */       if (this.channeltype != _o_.channeltype) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.money;
/*  79 */     _h_ += this.moneytype;
/*  80 */     _h_ += this.channeltype;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.money).append(",");
/*  88 */     _sb_.append(this.moneytype).append(",");
/*  89 */     _sb_.append(this.channeltype).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetChatGiftRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.money - _o_.money;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.moneytype - _o_.moneytype;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.channeltype - _o_.channeltype;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SGetChatGiftRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */