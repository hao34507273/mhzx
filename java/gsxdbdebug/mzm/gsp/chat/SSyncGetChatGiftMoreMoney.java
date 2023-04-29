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
/*     */ public class SSyncGetChatGiftMoreMoney
/*     */   extends __SSyncGetChatGiftMoreMoney__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585270;
/*     */   public long chatgiftid;
/*     */   public int channeltype;
/*     */   public long channelid;
/*     */   public String sendrolename;
/*     */   public String getrolename;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585270;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGetChatGiftMoreMoney()
/*     */   {
/*  37 */     this.sendrolename = "";
/*  38 */     this.getrolename = "";
/*     */   }
/*     */   
/*     */   public SSyncGetChatGiftMoreMoney(long _chatgiftid_, int _channeltype_, long _channelid_, String _sendrolename_, String _getrolename_) {
/*  42 */     this.chatgiftid = _chatgiftid_;
/*  43 */     this.channeltype = _channeltype_;
/*  44 */     this.channelid = _channelid_;
/*  45 */     this.sendrolename = _sendrolename_;
/*  46 */     this.getrolename = _getrolename_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.chatgiftid);
/*  55 */     _os_.marshal(this.channeltype);
/*  56 */     _os_.marshal(this.channelid);
/*  57 */     _os_.marshal(this.sendrolename, "UTF-16LE");
/*  58 */     _os_.marshal(this.getrolename, "UTF-16LE");
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.chatgiftid = _os_.unmarshal_long();
/*  64 */     this.channeltype = _os_.unmarshal_int();
/*  65 */     this.channelid = _os_.unmarshal_long();
/*  66 */     this.sendrolename = _os_.unmarshal_String("UTF-16LE");
/*  67 */     this.getrolename = _os_.unmarshal_String("UTF-16LE");
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSyncGetChatGiftMoreMoney)) {
/*  77 */       SSyncGetChatGiftMoreMoney _o_ = (SSyncGetChatGiftMoreMoney)_o1_;
/*  78 */       if (this.chatgiftid != _o_.chatgiftid) return false;
/*  79 */       if (this.channeltype != _o_.channeltype) return false;
/*  80 */       if (this.channelid != _o_.channelid) return false;
/*  81 */       if (!this.sendrolename.equals(_o_.sendrolename)) return false;
/*  82 */       if (!this.getrolename.equals(_o_.getrolename)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.chatgiftid;
/*  91 */     _h_ += this.channeltype;
/*  92 */     _h_ += (int)this.channelid;
/*  93 */     _h_ += this.sendrolename.hashCode();
/*  94 */     _h_ += this.getrolename.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.chatgiftid).append(",");
/* 102 */     _sb_.append(this.channeltype).append(",");
/* 103 */     _sb_.append(this.channelid).append(",");
/* 104 */     _sb_.append("T").append(this.sendrolename.length()).append(",");
/* 105 */     _sb_.append("T").append(this.getrolename.length()).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SSyncGetChatGiftMoreMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */