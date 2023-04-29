/*     */ package mzm.gsp.ladder;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class RoleLadderCrossMatchInfo implements Marshal
/*     */ {
/*     */   public static final int BEGIN = 0;
/*     */   public static final int GEN_TOKEN_SUC = 1;
/*     */   public static final int TRANSFOR_DATA_SUC = 2;
/*     */   public static final int LOGIN = 3;
/*     */   public int process;
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
/*     */   
/*     */   public RoleLadderCrossMatchInfo()
/*     */   {
/*  28 */     this.name = "";
/*     */   }
/*     */   
/*     */   public RoleLadderCrossMatchInfo(int _process_, int _gender_, int _occupation_, int _avatarid_, int _avatarframeid_, int _level_, String _name_, int _stage_, int _matchscore_, long _roleid_, int _wincount_, int _losecount_) {
/*  32 */     this.process = _process_;
/*  33 */     this.gender = _gender_;
/*  34 */     this.occupation = _occupation_;
/*  35 */     this.avatarid = _avatarid_;
/*  36 */     this.avatarframeid = _avatarframeid_;
/*  37 */     this.level = _level_;
/*  38 */     this.name = _name_;
/*  39 */     this.stage = _stage_;
/*  40 */     this.matchscore = _matchscore_;
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.wincount = _wincount_;
/*  43 */     this.losecount = _losecount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.process);
/*  52 */     _os_.marshal(this.gender);
/*  53 */     _os_.marshal(this.occupation);
/*  54 */     _os_.marshal(this.avatarid);
/*  55 */     _os_.marshal(this.avatarframeid);
/*  56 */     _os_.marshal(this.level);
/*  57 */     _os_.marshal(this.name, "UTF-16LE");
/*  58 */     _os_.marshal(this.stage);
/*  59 */     _os_.marshal(this.matchscore);
/*  60 */     _os_.marshal(this.roleid);
/*  61 */     _os_.marshal(this.wincount);
/*  62 */     _os_.marshal(this.losecount);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.process = _os_.unmarshal_int();
/*  68 */     this.gender = _os_.unmarshal_int();
/*  69 */     this.occupation = _os_.unmarshal_int();
/*  70 */     this.avatarid = _os_.unmarshal_int();
/*  71 */     this.avatarframeid = _os_.unmarshal_int();
/*  72 */     this.level = _os_.unmarshal_int();
/*  73 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  74 */     this.stage = _os_.unmarshal_int();
/*  75 */     this.matchscore = _os_.unmarshal_int();
/*  76 */     this.roleid = _os_.unmarshal_long();
/*  77 */     this.wincount = _os_.unmarshal_int();
/*  78 */     this.losecount = _os_.unmarshal_int();
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof RoleLadderCrossMatchInfo)) {
/*  85 */       RoleLadderCrossMatchInfo _o_ = (RoleLadderCrossMatchInfo)_o1_;
/*  86 */       if (this.process != _o_.process) return false;
/*  87 */       if (this.gender != _o_.gender) return false;
/*  88 */       if (this.occupation != _o_.occupation) return false;
/*  89 */       if (this.avatarid != _o_.avatarid) return false;
/*  90 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  91 */       if (this.level != _o_.level) return false;
/*  92 */       if (!this.name.equals(_o_.name)) return false;
/*  93 */       if (this.stage != _o_.stage) return false;
/*  94 */       if (this.matchscore != _o_.matchscore) return false;
/*  95 */       if (this.roleid != _o_.roleid) return false;
/*  96 */       if (this.wincount != _o_.wincount) return false;
/*  97 */       if (this.losecount != _o_.losecount) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.process;
/* 106 */     _h_ += this.gender;
/* 107 */     _h_ += this.occupation;
/* 108 */     _h_ += this.avatarid;
/* 109 */     _h_ += this.avatarframeid;
/* 110 */     _h_ += this.level;
/* 111 */     _h_ += this.name.hashCode();
/* 112 */     _h_ += this.stage;
/* 113 */     _h_ += this.matchscore;
/* 114 */     _h_ += (int)this.roleid;
/* 115 */     _h_ += this.wincount;
/* 116 */     _h_ += this.losecount;
/* 117 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder _sb_ = new StringBuilder();
/* 122 */     _sb_.append("(");
/* 123 */     _sb_.append(this.process).append(",");
/* 124 */     _sb_.append(this.gender).append(",");
/* 125 */     _sb_.append(this.occupation).append(",");
/* 126 */     _sb_.append(this.avatarid).append(",");
/* 127 */     _sb_.append(this.avatarframeid).append(",");
/* 128 */     _sb_.append(this.level).append(",");
/* 129 */     _sb_.append("T").append(this.name.length()).append(",");
/* 130 */     _sb_.append(this.stage).append(",");
/* 131 */     _sb_.append(this.matchscore).append(",");
/* 132 */     _sb_.append(this.roleid).append(",");
/* 133 */     _sb_.append(this.wincount).append(",");
/* 134 */     _sb_.append(this.losecount).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\RoleLadderCrossMatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */