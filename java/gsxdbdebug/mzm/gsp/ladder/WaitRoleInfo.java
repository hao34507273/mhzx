/*     */ package mzm.gsp.ladder;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class WaitRoleInfo implements Marshal
/*     */ {
/*     */   public int gender;
/*     */   public int occupation;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   public int level;
/*     */   public String name;
/*     */   public int stage;
/*     */   public int matchscore;
/*     */   public long roleid;
/*     */   public int wincount;
/*     */   public int losecount;
/*     */   public int fightscore;
/*     */   
/*     */   public WaitRoleInfo()
/*     */   {
/*  23 */     this.name = "";
/*     */   }
/*     */   
/*     */   public WaitRoleInfo(int _gender_, int _occupation_, int _avatarid_, int _avatarframeid_, int _level_, String _name_, int _stage_, int _matchscore_, long _roleid_, int _wincount_, int _losecount_, int _fightscore_) {
/*  27 */     this.gender = _gender_;
/*  28 */     this.occupation = _occupation_;
/*  29 */     this.avatarid = _avatarid_;
/*  30 */     this.avatarframeid = _avatarframeid_;
/*  31 */     this.level = _level_;
/*  32 */     this.name = _name_;
/*  33 */     this.stage = _stage_;
/*  34 */     this.matchscore = _matchscore_;
/*  35 */     this.roleid = _roleid_;
/*  36 */     this.wincount = _wincount_;
/*  37 */     this.losecount = _losecount_;
/*  38 */     this.fightscore = _fightscore_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.gender);
/*  47 */     _os_.marshal(this.occupation);
/*  48 */     _os_.marshal(this.avatarid);
/*  49 */     _os_.marshal(this.avatarframeid);
/*  50 */     _os_.marshal(this.level);
/*  51 */     _os_.marshal(this.name, "UTF-16LE");
/*  52 */     _os_.marshal(this.stage);
/*  53 */     _os_.marshal(this.matchscore);
/*  54 */     _os_.marshal(this.roleid);
/*  55 */     _os_.marshal(this.wincount);
/*  56 */     _os_.marshal(this.losecount);
/*  57 */     _os_.marshal(this.fightscore);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  62 */     this.gender = _os_.unmarshal_int();
/*  63 */     this.occupation = _os_.unmarshal_int();
/*  64 */     this.avatarid = _os_.unmarshal_int();
/*  65 */     this.avatarframeid = _os_.unmarshal_int();
/*  66 */     this.level = _os_.unmarshal_int();
/*  67 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  68 */     this.stage = _os_.unmarshal_int();
/*  69 */     this.matchscore = _os_.unmarshal_int();
/*  70 */     this.roleid = _os_.unmarshal_long();
/*  71 */     this.wincount = _os_.unmarshal_int();
/*  72 */     this.losecount = _os_.unmarshal_int();
/*  73 */     this.fightscore = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof WaitRoleInfo)) {
/*  80 */       WaitRoleInfo _o_ = (WaitRoleInfo)_o1_;
/*  81 */       if (this.gender != _o_.gender) return false;
/*  82 */       if (this.occupation != _o_.occupation) return false;
/*  83 */       if (this.avatarid != _o_.avatarid) return false;
/*  84 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  85 */       if (this.level != _o_.level) return false;
/*  86 */       if (!this.name.equals(_o_.name)) return false;
/*  87 */       if (this.stage != _o_.stage) return false;
/*  88 */       if (this.matchscore != _o_.matchscore) return false;
/*  89 */       if (this.roleid != _o_.roleid) return false;
/*  90 */       if (this.wincount != _o_.wincount) return false;
/*  91 */       if (this.losecount != _o_.losecount) return false;
/*  92 */       if (this.fightscore != _o_.fightscore) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.gender;
/* 101 */     _h_ += this.occupation;
/* 102 */     _h_ += this.avatarid;
/* 103 */     _h_ += this.avatarframeid;
/* 104 */     _h_ += this.level;
/* 105 */     _h_ += this.name.hashCode();
/* 106 */     _h_ += this.stage;
/* 107 */     _h_ += this.matchscore;
/* 108 */     _h_ += (int)this.roleid;
/* 109 */     _h_ += this.wincount;
/* 110 */     _h_ += this.losecount;
/* 111 */     _h_ += this.fightscore;
/* 112 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 116 */     StringBuilder _sb_ = new StringBuilder();
/* 117 */     _sb_.append("(");
/* 118 */     _sb_.append(this.gender).append(",");
/* 119 */     _sb_.append(this.occupation).append(",");
/* 120 */     _sb_.append(this.avatarid).append(",");
/* 121 */     _sb_.append(this.avatarframeid).append(",");
/* 122 */     _sb_.append(this.level).append(",");
/* 123 */     _sb_.append("T").append(this.name.length()).append(",");
/* 124 */     _sb_.append(this.stage).append(",");
/* 125 */     _sb_.append(this.matchscore).append(",");
/* 126 */     _sb_.append(this.roleid).append(",");
/* 127 */     _sb_.append(this.wincount).append(",");
/* 128 */     _sb_.append(this.losecount).append(",");
/* 129 */     _sb_.append(this.fightscore).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\WaitRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */