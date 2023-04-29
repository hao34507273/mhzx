/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SInviteTeamTrs
/*     */   extends __SInviteTeamTrs__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588295;
/*     */   public long inviter;
/*     */   public String name;
/*     */   public int level;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588295;
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
/*     */   public SInviteTeamTrs()
/*     */   {
/*  40 */     this.name = "";
/*     */   }
/*     */   
/*     */   public SInviteTeamTrs(long _inviter_, String _name_, int _level_, int _menpai_, int _gender_, int _avatarid_, int _avatarframeid_, long _sessionid_) {
/*  44 */     this.inviter = _inviter_;
/*  45 */     this.name = _name_;
/*  46 */     this.level = _level_;
/*  47 */     this.menpai = _menpai_;
/*  48 */     this.gender = _gender_;
/*  49 */     this.avatarid = _avatarid_;
/*  50 */     this.avatarframeid = _avatarframeid_;
/*  51 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.inviter);
/*  60 */     _os_.marshal(this.name, "UTF-16LE");
/*  61 */     _os_.marshal(this.level);
/*  62 */     _os_.marshal(this.menpai);
/*  63 */     _os_.marshal(this.gender);
/*  64 */     _os_.marshal(this.avatarid);
/*  65 */     _os_.marshal(this.avatarframeid);
/*  66 */     _os_.marshal(this.sessionid);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.inviter = _os_.unmarshal_long();
/*  72 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  73 */     this.level = _os_.unmarshal_int();
/*  74 */     this.menpai = _os_.unmarshal_int();
/*  75 */     this.gender = _os_.unmarshal_int();
/*  76 */     this.avatarid = _os_.unmarshal_int();
/*  77 */     this.avatarframeid = _os_.unmarshal_int();
/*  78 */     this.sessionid = _os_.unmarshal_long();
/*  79 */     if (!_validator_()) {
/*  80 */       throw new VerifyError("validator failed");
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof SInviteTeamTrs)) {
/*  88 */       SInviteTeamTrs _o_ = (SInviteTeamTrs)_o1_;
/*  89 */       if (this.inviter != _o_.inviter) return false;
/*  90 */       if (!this.name.equals(_o_.name)) return false;
/*  91 */       if (this.level != _o_.level) return false;
/*  92 */       if (this.menpai != _o_.menpai) return false;
/*  93 */       if (this.gender != _o_.gender) return false;
/*  94 */       if (this.avatarid != _o_.avatarid) return false;
/*  95 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  96 */       if (this.sessionid != _o_.sessionid) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += (int)this.inviter;
/* 105 */     _h_ += this.name.hashCode();
/* 106 */     _h_ += this.level;
/* 107 */     _h_ += this.menpai;
/* 108 */     _h_ += this.gender;
/* 109 */     _h_ += this.avatarid;
/* 110 */     _h_ += this.avatarframeid;
/* 111 */     _h_ += (int)this.sessionid;
/* 112 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 116 */     StringBuilder _sb_ = new StringBuilder();
/* 117 */     _sb_.append("(");
/* 118 */     _sb_.append(this.inviter).append(",");
/* 119 */     _sb_.append("T").append(this.name.length()).append(",");
/* 120 */     _sb_.append(this.level).append(",");
/* 121 */     _sb_.append(this.menpai).append(",");
/* 122 */     _sb_.append(this.gender).append(",");
/* 123 */     _sb_.append(this.avatarid).append(",");
/* 124 */     _sb_.append(this.avatarframeid).append(",");
/* 125 */     _sb_.append(this.sessionid).append(",");
/* 126 */     _sb_.append(")");
/* 127 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SInviteTeamTrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */