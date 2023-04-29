/*     */ package mzm.gsp.sworn;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetKickoutVoteInfoRes
/*     */   extends __SGetKickoutVoteInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597814;
/*     */   public String rolename;
/*     */   public String kickrolename;
/*     */   public int kickrolegender;
/*     */   public int kickrolemenpai;
/*     */   public String kickroletitle;
/*     */   public long verifytime;
/*     */   public int agreecount;
/*     */   public int notagreecount;
/*     */   public int needvotecount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597814;
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
/*     */   public SGetKickoutVoteInfoRes()
/*     */   {
/*  41 */     this.rolename = "";
/*  42 */     this.kickrolename = "";
/*  43 */     this.kickroletitle = "";
/*     */   }
/*     */   
/*     */   public SGetKickoutVoteInfoRes(String _rolename_, String _kickrolename_, int _kickrolegender_, int _kickrolemenpai_, String _kickroletitle_, long _verifytime_, int _agreecount_, int _notagreecount_, int _needvotecount_) {
/*  47 */     this.rolename = _rolename_;
/*  48 */     this.kickrolename = _kickrolename_;
/*  49 */     this.kickrolegender = _kickrolegender_;
/*  50 */     this.kickrolemenpai = _kickrolemenpai_;
/*  51 */     this.kickroletitle = _kickroletitle_;
/*  52 */     this.verifytime = _verifytime_;
/*  53 */     this.agreecount = _agreecount_;
/*  54 */     this.notagreecount = _notagreecount_;
/*  55 */     this.needvotecount = _needvotecount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  64 */     _os_.marshal(this.kickrolename, "UTF-16LE");
/*  65 */     _os_.marshal(this.kickrolegender);
/*  66 */     _os_.marshal(this.kickrolemenpai);
/*  67 */     _os_.marshal(this.kickroletitle, "UTF-16LE");
/*  68 */     _os_.marshal(this.verifytime);
/*  69 */     _os_.marshal(this.agreecount);
/*  70 */     _os_.marshal(this.notagreecount);
/*  71 */     _os_.marshal(this.needvotecount);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  77 */     this.kickrolename = _os_.unmarshal_String("UTF-16LE");
/*  78 */     this.kickrolegender = _os_.unmarshal_int();
/*  79 */     this.kickrolemenpai = _os_.unmarshal_int();
/*  80 */     this.kickroletitle = _os_.unmarshal_String("UTF-16LE");
/*  81 */     this.verifytime = _os_.unmarshal_long();
/*  82 */     this.agreecount = _os_.unmarshal_int();
/*  83 */     this.notagreecount = _os_.unmarshal_int();
/*  84 */     this.needvotecount = _os_.unmarshal_int();
/*  85 */     if (!_validator_()) {
/*  86 */       throw new VerifyError("validator failed");
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  92 */     if (_o1_ == this) return true;
/*  93 */     if ((_o1_ instanceof SGetKickoutVoteInfoRes)) {
/*  94 */       SGetKickoutVoteInfoRes _o_ = (SGetKickoutVoteInfoRes)_o1_;
/*  95 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  96 */       if (!this.kickrolename.equals(_o_.kickrolename)) return false;
/*  97 */       if (this.kickrolegender != _o_.kickrolegender) return false;
/*  98 */       if (this.kickrolemenpai != _o_.kickrolemenpai) return false;
/*  99 */       if (!this.kickroletitle.equals(_o_.kickroletitle)) return false;
/* 100 */       if (this.verifytime != _o_.verifytime) return false;
/* 101 */       if (this.agreecount != _o_.agreecount) return false;
/* 102 */       if (this.notagreecount != _o_.notagreecount) return false;
/* 103 */       if (this.needvotecount != _o_.needvotecount) return false;
/* 104 */       return true;
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 110 */     int _h_ = 0;
/* 111 */     _h_ += this.rolename.hashCode();
/* 112 */     _h_ += this.kickrolename.hashCode();
/* 113 */     _h_ += this.kickrolegender;
/* 114 */     _h_ += this.kickrolemenpai;
/* 115 */     _h_ += this.kickroletitle.hashCode();
/* 116 */     _h_ += (int)this.verifytime;
/* 117 */     _h_ += this.agreecount;
/* 118 */     _h_ += this.notagreecount;
/* 119 */     _h_ += this.needvotecount;
/* 120 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuilder _sb_ = new StringBuilder();
/* 125 */     _sb_.append("(");
/* 126 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 127 */     _sb_.append("T").append(this.kickrolename.length()).append(",");
/* 128 */     _sb_.append(this.kickrolegender).append(",");
/* 129 */     _sb_.append(this.kickrolemenpai).append(",");
/* 130 */     _sb_.append("T").append(this.kickroletitle.length()).append(",");
/* 131 */     _sb_.append(this.verifytime).append(",");
/* 132 */     _sb_.append(this.agreecount).append(",");
/* 133 */     _sb_.append(this.notagreecount).append(",");
/* 134 */     _sb_.append(this.needvotecount).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SGetKickoutVoteInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */