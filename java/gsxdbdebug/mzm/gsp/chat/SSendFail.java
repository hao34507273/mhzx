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
/*     */ public class SSendFail
/*     */   extends __SSendFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585231;
/*     */   public long senderid;
/*     */   public long listenerid;
/*     */   public int contenttype;
/*     */   public int channeltype;
/*     */   public ChatContent chatcontent;
/*     */   public int reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585231;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSendFail()
/*     */   {
/*  38 */     this.chatcontent = new ChatContent();
/*     */   }
/*     */   
/*     */   public SSendFail(long _senderid_, long _listenerid_, int _contenttype_, int _channeltype_, ChatContent _chatcontent_, int _reason_) {
/*  42 */     this.senderid = _senderid_;
/*  43 */     this.listenerid = _listenerid_;
/*  44 */     this.contenttype = _contenttype_;
/*  45 */     this.channeltype = _channeltype_;
/*  46 */     this.chatcontent = _chatcontent_;
/*  47 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     if (!this.chatcontent._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.senderid);
/*  57 */     _os_.marshal(this.listenerid);
/*  58 */     _os_.marshal(this.contenttype);
/*  59 */     _os_.marshal(this.channeltype);
/*  60 */     _os_.marshal(this.chatcontent);
/*  61 */     _os_.marshal(this.reason);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.senderid = _os_.unmarshal_long();
/*  67 */     this.listenerid = _os_.unmarshal_long();
/*  68 */     this.contenttype = _os_.unmarshal_int();
/*  69 */     this.channeltype = _os_.unmarshal_int();
/*  70 */     this.chatcontent.unmarshal(_os_);
/*  71 */     this.reason = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSendFail)) {
/*  81 */       SSendFail _o_ = (SSendFail)_o1_;
/*  82 */       if (this.senderid != _o_.senderid) return false;
/*  83 */       if (this.listenerid != _o_.listenerid) return false;
/*  84 */       if (this.contenttype != _o_.contenttype) return false;
/*  85 */       if (this.channeltype != _o_.channeltype) return false;
/*  86 */       if (!this.chatcontent.equals(_o_.chatcontent)) return false;
/*  87 */       if (this.reason != _o_.reason) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.senderid;
/*  96 */     _h_ += (int)this.listenerid;
/*  97 */     _h_ += this.contenttype;
/*  98 */     _h_ += this.channeltype;
/*  99 */     _h_ += this.chatcontent.hashCode();
/* 100 */     _h_ += this.reason;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.senderid).append(",");
/* 108 */     _sb_.append(this.listenerid).append(",");
/* 109 */     _sb_.append(this.contenttype).append(",");
/* 110 */     _sb_.append(this.channeltype).append(",");
/* 111 */     _sb_.append(this.chatcontent).append(",");
/* 112 */     _sb_.append(this.reason).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SSendFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */