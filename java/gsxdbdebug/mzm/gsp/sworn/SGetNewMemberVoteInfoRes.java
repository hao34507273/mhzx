/*     */ package mzm.gsp.sworn;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetNewMemberVoteInfoRes
/*     */   extends __SGetNewMemberVoteInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597810;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int rolegender;
/*     */   public int rolemenpai;
/*     */   public String roletitle;
/*     */   public String invitename;
/*     */   public long verifytime;
/*     */   public int curvotecount;
/*     */   public int needvotecount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597810;
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
/*     */   public SGetNewMemberVoteInfoRes()
/*     */   {
/*  41 */     this.rolename = "";
/*  42 */     this.roletitle = "";
/*  43 */     this.invitename = "";
/*     */   }
/*     */   
/*     */   public SGetNewMemberVoteInfoRes(long _roleid_, String _rolename_, int _rolegender_, int _rolemenpai_, String _roletitle_, String _invitename_, long _verifytime_, int _curvotecount_, int _needvotecount_) {
/*  47 */     this.roleid = _roleid_;
/*  48 */     this.rolename = _rolename_;
/*  49 */     this.rolegender = _rolegender_;
/*  50 */     this.rolemenpai = _rolemenpai_;
/*  51 */     this.roletitle = _roletitle_;
/*  52 */     this.invitename = _invitename_;
/*  53 */     this.verifytime = _verifytime_;
/*  54 */     this.curvotecount = _curvotecount_;
/*  55 */     this.needvotecount = _needvotecount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.roleid);
/*  64 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  65 */     _os_.marshal(this.rolegender);
/*  66 */     _os_.marshal(this.rolemenpai);
/*  67 */     _os_.marshal(this.roletitle, "UTF-16LE");
/*  68 */     _os_.marshal(this.invitename, "UTF-16LE");
/*  69 */     _os_.marshal(this.verifytime);
/*  70 */     _os_.marshal(this.curvotecount);
/*  71 */     _os_.marshal(this.needvotecount);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.roleid = _os_.unmarshal_long();
/*  77 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  78 */     this.rolegender = _os_.unmarshal_int();
/*  79 */     this.rolemenpai = _os_.unmarshal_int();
/*  80 */     this.roletitle = _os_.unmarshal_String("UTF-16LE");
/*  81 */     this.invitename = _os_.unmarshal_String("UTF-16LE");
/*  82 */     this.verifytime = _os_.unmarshal_long();
/*  83 */     this.curvotecount = _os_.unmarshal_int();
/*  84 */     this.needvotecount = _os_.unmarshal_int();
/*  85 */     if (!_validator_()) {
/*  86 */       throw new VerifyError("validator failed");
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  92 */     if (_o1_ == this) return true;
/*  93 */     if ((_o1_ instanceof SGetNewMemberVoteInfoRes)) {
/*  94 */       SGetNewMemberVoteInfoRes _o_ = (SGetNewMemberVoteInfoRes)_o1_;
/*  95 */       if (this.roleid != _o_.roleid) return false;
/*  96 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  97 */       if (this.rolegender != _o_.rolegender) return false;
/*  98 */       if (this.rolemenpai != _o_.rolemenpai) return false;
/*  99 */       if (!this.roletitle.equals(_o_.roletitle)) return false;
/* 100 */       if (!this.invitename.equals(_o_.invitename)) return false;
/* 101 */       if (this.verifytime != _o_.verifytime) return false;
/* 102 */       if (this.curvotecount != _o_.curvotecount) return false;
/* 103 */       if (this.needvotecount != _o_.needvotecount) return false;
/* 104 */       return true;
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 110 */     int _h_ = 0;
/* 111 */     _h_ += (int)this.roleid;
/* 112 */     _h_ += this.rolename.hashCode();
/* 113 */     _h_ += this.rolegender;
/* 114 */     _h_ += this.rolemenpai;
/* 115 */     _h_ += this.roletitle.hashCode();
/* 116 */     _h_ += this.invitename.hashCode();
/* 117 */     _h_ += (int)this.verifytime;
/* 118 */     _h_ += this.curvotecount;
/* 119 */     _h_ += this.needvotecount;
/* 120 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuilder _sb_ = new StringBuilder();
/* 125 */     _sb_.append("(");
/* 126 */     _sb_.append(this.roleid).append(",");
/* 127 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 128 */     _sb_.append(this.rolegender).append(",");
/* 129 */     _sb_.append(this.rolemenpai).append(",");
/* 130 */     _sb_.append("T").append(this.roletitle.length()).append(",");
/* 131 */     _sb_.append("T").append(this.invitename.length()).append(",");
/* 132 */     _sb_.append(this.verifytime).append(",");
/* 133 */     _sb_.append(this.curvotecount).append(",");
/* 134 */     _sb_.append(this.needvotecount).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SGetNewMemberVoteInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */