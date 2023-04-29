/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class TeamMember implements Marshal
/*     */ {
/*     */   public static final int ST_NORMAL = 0;
/*     */   public static final int ST_TMP_LEAVE = 1;
/*     */   public static final int ST_OFFLINE = 2;
/*     */   public static final int ST_TO_BE_TMP_LEAVE = 4;
/*     */   public static final int ST_TO_BE_LEAVE = 5;
/*     */   public static final int ST_TO_BE_RETURN = 6;
/*     */   public long roleid;
/*     */   public String name;
/*     */   public int level;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int status;
/*     */   public int friendsetting;
/*     */   public ModelInfo model;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public TeamMember()
/*     */   {
/*  28 */     this.name = "";
/*  29 */     this.model = new ModelInfo();
/*     */   }
/*     */   
/*     */   public TeamMember(long _roleid_, String _name_, int _level_, int _menpai_, int _gender_, int _status_, int _friendsetting_, ModelInfo _model_, int _avatarid_, int _avatarframeid_) {
/*  33 */     this.roleid = _roleid_;
/*  34 */     this.name = _name_;
/*  35 */     this.level = _level_;
/*  36 */     this.menpai = _menpai_;
/*  37 */     this.gender = _gender_;
/*  38 */     this.status = _status_;
/*  39 */     this.friendsetting = _friendsetting_;
/*  40 */     this.model = _model_;
/*  41 */     this.avatarid = _avatarid_;
/*  42 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     if (!this.model._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.roleid);
/*  52 */     _os_.marshal(this.name, "UTF-16LE");
/*  53 */     _os_.marshal(this.level);
/*  54 */     _os_.marshal(this.menpai);
/*  55 */     _os_.marshal(this.gender);
/*  56 */     _os_.marshal(this.status);
/*  57 */     _os_.marshal(this.friendsetting);
/*  58 */     _os_.marshal(this.model);
/*  59 */     _os_.marshal(this.avatarid);
/*  60 */     _os_.marshal(this.avatarframeid);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  65 */     this.roleid = _os_.unmarshal_long();
/*  66 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  67 */     this.level = _os_.unmarshal_int();
/*  68 */     this.menpai = _os_.unmarshal_int();
/*  69 */     this.gender = _os_.unmarshal_int();
/*  70 */     this.status = _os_.unmarshal_int();
/*  71 */     this.friendsetting = _os_.unmarshal_int();
/*  72 */     this.model.unmarshal(_os_);
/*  73 */     this.avatarid = _os_.unmarshal_int();
/*  74 */     this.avatarframeid = _os_.unmarshal_int();
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof TeamMember)) {
/*  81 */       TeamMember _o_ = (TeamMember)_o1_;
/*  82 */       if (this.roleid != _o_.roleid) return false;
/*  83 */       if (!this.name.equals(_o_.name)) return false;
/*  84 */       if (this.level != _o_.level) return false;
/*  85 */       if (this.menpai != _o_.menpai) return false;
/*  86 */       if (this.gender != _o_.gender) return false;
/*  87 */       if (this.status != _o_.status) return false;
/*  88 */       if (this.friendsetting != _o_.friendsetting) return false;
/*  89 */       if (!this.model.equals(_o_.model)) return false;
/*  90 */       if (this.avatarid != _o_.avatarid) return false;
/*  91 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += (int)this.roleid;
/* 100 */     _h_ += this.name.hashCode();
/* 101 */     _h_ += this.level;
/* 102 */     _h_ += this.menpai;
/* 103 */     _h_ += this.gender;
/* 104 */     _h_ += this.status;
/* 105 */     _h_ += this.friendsetting;
/* 106 */     _h_ += this.model.hashCode();
/* 107 */     _h_ += this.avatarid;
/* 108 */     _h_ += this.avatarframeid;
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.roleid).append(",");
/* 116 */     _sb_.append("T").append(this.name.length()).append(",");
/* 117 */     _sb_.append(this.level).append(",");
/* 118 */     _sb_.append(this.menpai).append(",");
/* 119 */     _sb_.append(this.gender).append(",");
/* 120 */     _sb_.append(this.status).append(",");
/* 121 */     _sb_.append(this.friendsetting).append(",");
/* 122 */     _sb_.append(this.model).append(",");
/* 123 */     _sb_.append(this.avatarid).append(",");
/* 124 */     _sb_.append(this.avatarframeid).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\TeamMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */