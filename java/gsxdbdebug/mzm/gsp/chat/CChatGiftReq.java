/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CChatGiftReq extends __CChatGiftReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585256;
/*     */   public int channeltype;
/*     */   public long channelid;
/*     */   public int chatgifttype;
/*     */   public int chatgiftnum;
/*     */   public String chatgiftstr;
/*     */   public long curyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new mzm.gsp.chatgift.main.PCChatGiftReq(roleId, this.channeltype, this.chatgifttype, this.chatgiftnum, this.chatgiftstr, this.curyuanbao, this.channelid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12585256;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChatGiftReq()
/*     */   {
/*  42 */     this.chatgiftstr = "";
/*     */   }
/*     */   
/*     */   public CChatGiftReq(int _channeltype_, long _channelid_, int _chatgifttype_, int _chatgiftnum_, String _chatgiftstr_, long _curyuanbao_) {
/*  46 */     this.channeltype = _channeltype_;
/*  47 */     this.channelid = _channelid_;
/*  48 */     this.chatgifttype = _chatgifttype_;
/*  49 */     this.chatgiftnum = _chatgiftnum_;
/*  50 */     this.chatgiftstr = _chatgiftstr_;
/*  51 */     this.curyuanbao = _curyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.channeltype);
/*  60 */     _os_.marshal(this.channelid);
/*  61 */     _os_.marshal(this.chatgifttype);
/*  62 */     _os_.marshal(this.chatgiftnum);
/*  63 */     _os_.marshal(this.chatgiftstr, "UTF-16LE");
/*  64 */     _os_.marshal(this.curyuanbao);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.channeltype = _os_.unmarshal_int();
/*  70 */     this.channelid = _os_.unmarshal_long();
/*  71 */     this.chatgifttype = _os_.unmarshal_int();
/*  72 */     this.chatgiftnum = _os_.unmarshal_int();
/*  73 */     this.chatgiftstr = _os_.unmarshal_String("UTF-16LE");
/*  74 */     this.curyuanbao = _os_.unmarshal_long();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof CChatGiftReq)) {
/*  84 */       CChatGiftReq _o_ = (CChatGiftReq)_o1_;
/*  85 */       if (this.channeltype != _o_.channeltype) return false;
/*  86 */       if (this.channelid != _o_.channelid) return false;
/*  87 */       if (this.chatgifttype != _o_.chatgifttype) return false;
/*  88 */       if (this.chatgiftnum != _o_.chatgiftnum) return false;
/*  89 */       if (!this.chatgiftstr.equals(_o_.chatgiftstr)) return false;
/*  90 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.channeltype;
/*  99 */     _h_ += (int)this.channelid;
/* 100 */     _h_ += this.chatgifttype;
/* 101 */     _h_ += this.chatgiftnum;
/* 102 */     _h_ += this.chatgiftstr.hashCode();
/* 103 */     _h_ += (int)this.curyuanbao;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.channeltype).append(",");
/* 111 */     _sb_.append(this.channelid).append(",");
/* 112 */     _sb_.append(this.chatgifttype).append(",");
/* 113 */     _sb_.append(this.chatgiftnum).append(",");
/* 114 */     _sb_.append("T").append(this.chatgiftstr.length()).append(",");
/* 115 */     _sb_.append(this.curyuanbao).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */