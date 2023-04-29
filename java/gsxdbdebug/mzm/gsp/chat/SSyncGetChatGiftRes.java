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
/*     */ public class SSyncGetChatGiftRes
/*     */   extends __SSyncGetChatGiftRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585261;
/*     */   public int channeltype;
/*     */   public long channelid;
/*     */   public long chatgiftid;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public long getroleid;
/*     */   public String getrolename;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585261;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGetChatGiftRes()
/*     */   {
/*  39 */     this.rolename = "";
/*  40 */     this.getrolename = "";
/*     */   }
/*     */   
/*     */   public SSyncGetChatGiftRes(int _channeltype_, long _channelid_, long _chatgiftid_, long _roleid_, String _rolename_, long _getroleid_, String _getrolename_) {
/*  44 */     this.channeltype = _channeltype_;
/*  45 */     this.channelid = _channelid_;
/*  46 */     this.chatgiftid = _chatgiftid_;
/*  47 */     this.roleid = _roleid_;
/*  48 */     this.rolename = _rolename_;
/*  49 */     this.getroleid = _getroleid_;
/*  50 */     this.getrolename = _getrolename_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.channeltype);
/*  59 */     _os_.marshal(this.channelid);
/*  60 */     _os_.marshal(this.chatgiftid);
/*  61 */     _os_.marshal(this.roleid);
/*  62 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  63 */     _os_.marshal(this.getroleid);
/*  64 */     _os_.marshal(this.getrolename, "UTF-16LE");
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.channeltype = _os_.unmarshal_int();
/*  70 */     this.channelid = _os_.unmarshal_long();
/*  71 */     this.chatgiftid = _os_.unmarshal_long();
/*  72 */     this.roleid = _os_.unmarshal_long();
/*  73 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  74 */     this.getroleid = _os_.unmarshal_long();
/*  75 */     this.getrolename = _os_.unmarshal_String("UTF-16LE");
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SSyncGetChatGiftRes)) {
/*  85 */       SSyncGetChatGiftRes _o_ = (SSyncGetChatGiftRes)_o1_;
/*  86 */       if (this.channeltype != _o_.channeltype) return false;
/*  87 */       if (this.channelid != _o_.channelid) return false;
/*  88 */       if (this.chatgiftid != _o_.chatgiftid) return false;
/*  89 */       if (this.roleid != _o_.roleid) return false;
/*  90 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  91 */       if (this.getroleid != _o_.getroleid) return false;
/*  92 */       if (!this.getrolename.equals(_o_.getrolename)) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.channeltype;
/* 101 */     _h_ += (int)this.channelid;
/* 102 */     _h_ += (int)this.chatgiftid;
/* 103 */     _h_ += (int)this.roleid;
/* 104 */     _h_ += this.rolename.hashCode();
/* 105 */     _h_ += (int)this.getroleid;
/* 106 */     _h_ += this.getrolename.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.channeltype).append(",");
/* 114 */     _sb_.append(this.channelid).append(",");
/* 115 */     _sb_.append(this.chatgiftid).append(",");
/* 116 */     _sb_.append(this.roleid).append(",");
/* 117 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 118 */     _sb_.append(this.getroleid).append(",");
/* 119 */     _sb_.append("T").append(this.getrolename.length()).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SSyncGetChatGiftRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */