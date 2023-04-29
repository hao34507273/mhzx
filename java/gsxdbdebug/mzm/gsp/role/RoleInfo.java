/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.title.AppellationInfo;
/*     */ 
/*     */ public class RoleInfo
/*     */   implements Marshal
/*     */ {
/*     */   public static final int MAIL = 1;
/*     */   public static final int FEMAIL = 2;
/*     */   public long roleid;
/*     */   public String openid;
/*     */   public int occupationid;
/*     */   public int level;
/*     */   public String name;
/*     */   public long teamid;
/*     */   public int onlinestatus;
/*     */   public int gender;
/*     */   public int teammembernum;
/*     */   public long gangid;
/*     */   public String gangname;
/*     */   public int friendsetting;
/*     */   public int deletestate;
/*     */   public AppellationInfo appellationinfo;
/*     */   public int hashomeland;
/*     */   public int holdbanquest;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public RoleInfo()
/*     */   {
/*  34 */     this.openid = "";
/*  35 */     this.name = "";
/*  36 */     this.gangname = "";
/*  37 */     this.appellationinfo = new AppellationInfo();
/*     */   }
/*     */   
/*     */   public RoleInfo(long _roleid_, String _openid_, int _occupationid_, int _level_, String _name_, long _teamid_, int _onlinestatus_, int _gender_, int _teammembernum_, long _gangid_, String _gangname_, int _friendsetting_, int _deletestate_, AppellationInfo _appellationinfo_, int _hashomeland_, int _holdbanquest_, int _avatarid_, int _avatarframeid_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.openid = _openid_;
/*  43 */     this.occupationid = _occupationid_;
/*  44 */     this.level = _level_;
/*  45 */     this.name = _name_;
/*  46 */     this.teamid = _teamid_;
/*  47 */     this.onlinestatus = _onlinestatus_;
/*  48 */     this.gender = _gender_;
/*  49 */     this.teammembernum = _teammembernum_;
/*  50 */     this.gangid = _gangid_;
/*  51 */     this.gangname = _gangname_;
/*  52 */     this.friendsetting = _friendsetting_;
/*  53 */     this.deletestate = _deletestate_;
/*  54 */     this.appellationinfo = _appellationinfo_;
/*  55 */     this.hashomeland = _hashomeland_;
/*  56 */     this.holdbanquest = _holdbanquest_;
/*  57 */     this.avatarid = _avatarid_;
/*  58 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  62 */     if (!this.appellationinfo._validator_()) return false;
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.roleid);
/*  68 */     _os_.marshal(this.openid, "UTF-16LE");
/*  69 */     _os_.marshal(this.occupationid);
/*  70 */     _os_.marshal(this.level);
/*  71 */     _os_.marshal(this.name, "UTF-16LE");
/*  72 */     _os_.marshal(this.teamid);
/*  73 */     _os_.marshal(this.onlinestatus);
/*  74 */     _os_.marshal(this.gender);
/*  75 */     _os_.marshal(this.teammembernum);
/*  76 */     _os_.marshal(this.gangid);
/*  77 */     _os_.marshal(this.gangname, "UTF-16LE");
/*  78 */     _os_.marshal(this.friendsetting);
/*  79 */     _os_.marshal(this.deletestate);
/*  80 */     _os_.marshal(this.appellationinfo);
/*  81 */     _os_.marshal(this.hashomeland);
/*  82 */     _os_.marshal(this.holdbanquest);
/*  83 */     _os_.marshal(this.avatarid);
/*  84 */     _os_.marshal(this.avatarframeid);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  89 */     this.roleid = _os_.unmarshal_long();
/*  90 */     this.openid = _os_.unmarshal_String("UTF-16LE");
/*  91 */     this.occupationid = _os_.unmarshal_int();
/*  92 */     this.level = _os_.unmarshal_int();
/*  93 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  94 */     this.teamid = _os_.unmarshal_long();
/*  95 */     this.onlinestatus = _os_.unmarshal_int();
/*  96 */     this.gender = _os_.unmarshal_int();
/*  97 */     this.teammembernum = _os_.unmarshal_int();
/*  98 */     this.gangid = _os_.unmarshal_long();
/*  99 */     this.gangname = _os_.unmarshal_String("UTF-16LE");
/* 100 */     this.friendsetting = _os_.unmarshal_int();
/* 101 */     this.deletestate = _os_.unmarshal_int();
/* 102 */     this.appellationinfo.unmarshal(_os_);
/* 103 */     this.hashomeland = _os_.unmarshal_int();
/* 104 */     this.holdbanquest = _os_.unmarshal_int();
/* 105 */     this.avatarid = _os_.unmarshal_int();
/* 106 */     this.avatarframeid = _os_.unmarshal_int();
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 111 */     if (_o1_ == this) return true;
/* 112 */     if ((_o1_ instanceof RoleInfo)) {
/* 113 */       RoleInfo _o_ = (RoleInfo)_o1_;
/* 114 */       if (this.roleid != _o_.roleid) return false;
/* 115 */       if (!this.openid.equals(_o_.openid)) return false;
/* 116 */       if (this.occupationid != _o_.occupationid) return false;
/* 117 */       if (this.level != _o_.level) return false;
/* 118 */       if (!this.name.equals(_o_.name)) return false;
/* 119 */       if (this.teamid != _o_.teamid) return false;
/* 120 */       if (this.onlinestatus != _o_.onlinestatus) return false;
/* 121 */       if (this.gender != _o_.gender) return false;
/* 122 */       if (this.teammembernum != _o_.teammembernum) return false;
/* 123 */       if (this.gangid != _o_.gangid) return false;
/* 124 */       if (!this.gangname.equals(_o_.gangname)) return false;
/* 125 */       if (this.friendsetting != _o_.friendsetting) return false;
/* 126 */       if (this.deletestate != _o_.deletestate) return false;
/* 127 */       if (!this.appellationinfo.equals(_o_.appellationinfo)) return false;
/* 128 */       if (this.hashomeland != _o_.hashomeland) return false;
/* 129 */       if (this.holdbanquest != _o_.holdbanquest) return false;
/* 130 */       if (this.avatarid != _o_.avatarid) return false;
/* 131 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/* 132 */       return true;
/*     */     }
/* 134 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 138 */     int _h_ = 0;
/* 139 */     _h_ += (int)this.roleid;
/* 140 */     _h_ += this.openid.hashCode();
/* 141 */     _h_ += this.occupationid;
/* 142 */     _h_ += this.level;
/* 143 */     _h_ += this.name.hashCode();
/* 144 */     _h_ += (int)this.teamid;
/* 145 */     _h_ += this.onlinestatus;
/* 146 */     _h_ += this.gender;
/* 147 */     _h_ += this.teammembernum;
/* 148 */     _h_ += (int)this.gangid;
/* 149 */     _h_ += this.gangname.hashCode();
/* 150 */     _h_ += this.friendsetting;
/* 151 */     _h_ += this.deletestate;
/* 152 */     _h_ += this.appellationinfo.hashCode();
/* 153 */     _h_ += this.hashomeland;
/* 154 */     _h_ += this.holdbanquest;
/* 155 */     _h_ += this.avatarid;
/* 156 */     _h_ += this.avatarframeid;
/* 157 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 161 */     StringBuilder _sb_ = new StringBuilder();
/* 162 */     _sb_.append("(");
/* 163 */     _sb_.append(this.roleid).append(",");
/* 164 */     _sb_.append("T").append(this.openid.length()).append(",");
/* 165 */     _sb_.append(this.occupationid).append(",");
/* 166 */     _sb_.append(this.level).append(",");
/* 167 */     _sb_.append("T").append(this.name.length()).append(",");
/* 168 */     _sb_.append(this.teamid).append(",");
/* 169 */     _sb_.append(this.onlinestatus).append(",");
/* 170 */     _sb_.append(this.gender).append(",");
/* 171 */     _sb_.append(this.teammembernum).append(",");
/* 172 */     _sb_.append(this.gangid).append(",");
/* 173 */     _sb_.append("T").append(this.gangname.length()).append(",");
/* 174 */     _sb_.append(this.friendsetting).append(",");
/* 175 */     _sb_.append(this.deletestate).append(",");
/* 176 */     _sb_.append(this.appellationinfo).append(",");
/* 177 */     _sb_.append(this.hashomeland).append(",");
/* 178 */     _sb_.append(this.holdbanquest).append(",");
/* 179 */     _sb_.append(this.avatarid).append(",");
/* 180 */     _sb_.append(this.avatarframeid).append(",");
/* 181 */     _sb_.append(")");
/* 182 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */