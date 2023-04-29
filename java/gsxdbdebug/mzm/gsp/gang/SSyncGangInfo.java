/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SSyncGangInfo extends __SSyncGangInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589852;
/*     */   public long gangid;
/*     */   public String name;
/*     */   public String bangzhu;
/*     */   public int level;
/*     */   public int money;
/*     */   public int vitality;
/*     */   public String purpose;
/*     */   public int designdutynameid;
/*     */   public int createtime;
/*     */   public int xuetumaxlevel;
/*     */   public int buildendtime;
/*     */   public int tanheendtime;
/*     */   public long tanheroleid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589852;
/*     */   }
/*     */   
/*     */ 
/*     */   public ArrayList<MemberInfo> memberlist;
/*     */   
/*     */   public ArrayList<GangAnnouncement> announcementlist;
/*     */   
/*     */   public XiangFangInfo xiangfanginfo;
/*     */   
/*     */   public CangKuInfo cangkuinfo;
/*     */   
/*     */   public JinKuInfo jinkuinfo;
/*     */   
/*     */   public YaoDianInfo yaodianinfo;
/*     */   
/*     */   public int mapinstanceid;
/*     */   
/*     */   public ShuYuanInfo shuyuaninfo;
/*     */   
/*     */   public int issign;
/*     */   
/*     */   public String signstr;
/*     */   
/*     */   public long fuli_timestamp;
/*     */   
/*     */   public long mifang_start_time;
/*     */   
/*     */   public long mifang_end_time;
/*     */   public long displayid;
/*     */   public ArrayList<GangTeam> teams;
/*     */   public SSyncGangInfo()
/*     */   {
/*  60 */     this.name = "";
/*  61 */     this.bangzhu = "";
/*  62 */     this.purpose = "";
/*  63 */     this.memberlist = new ArrayList();
/*  64 */     this.announcementlist = new ArrayList();
/*  65 */     this.xiangfanginfo = new XiangFangInfo();
/*  66 */     this.cangkuinfo = new CangKuInfo();
/*  67 */     this.jinkuinfo = new JinKuInfo();
/*  68 */     this.yaodianinfo = new YaoDianInfo();
/*  69 */     this.shuyuaninfo = new ShuYuanInfo();
/*  70 */     this.signstr = "";
/*  71 */     this.teams = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncGangInfo(long _gangid_, String _name_, String _bangzhu_, int _level_, int _money_, int _vitality_, String _purpose_, int _designdutynameid_, int _createtime_, int _xuetumaxlevel_, int _buildendtime_, int _tanheendtime_, long _tanheroleid_, ArrayList<MemberInfo> _memberlist_, ArrayList<GangAnnouncement> _announcementlist_, XiangFangInfo _xiangfanginfo_, CangKuInfo _cangkuinfo_, JinKuInfo _jinkuinfo_, YaoDianInfo _yaodianinfo_, int _mapinstanceid_, ShuYuanInfo _shuyuaninfo_, int _issign_, String _signstr_, long _fuli_timestamp_, long _mifang_start_time_, long _mifang_end_time_, long _displayid_, ArrayList<GangTeam> _teams_) {
/*  75 */     this.gangid = _gangid_;
/*  76 */     this.name = _name_;
/*  77 */     this.bangzhu = _bangzhu_;
/*  78 */     this.level = _level_;
/*  79 */     this.money = _money_;
/*  80 */     this.vitality = _vitality_;
/*  81 */     this.purpose = _purpose_;
/*  82 */     this.designdutynameid = _designdutynameid_;
/*  83 */     this.createtime = _createtime_;
/*  84 */     this.xuetumaxlevel = _xuetumaxlevel_;
/*  85 */     this.buildendtime = _buildendtime_;
/*  86 */     this.tanheendtime = _tanheendtime_;
/*  87 */     this.tanheroleid = _tanheroleid_;
/*  88 */     this.memberlist = _memberlist_;
/*  89 */     this.announcementlist = _announcementlist_;
/*  90 */     this.xiangfanginfo = _xiangfanginfo_;
/*  91 */     this.cangkuinfo = _cangkuinfo_;
/*  92 */     this.jinkuinfo = _jinkuinfo_;
/*  93 */     this.yaodianinfo = _yaodianinfo_;
/*  94 */     this.mapinstanceid = _mapinstanceid_;
/*  95 */     this.shuyuaninfo = _shuyuaninfo_;
/*  96 */     this.issign = _issign_;
/*  97 */     this.signstr = _signstr_;
/*  98 */     this.fuli_timestamp = _fuli_timestamp_;
/*  99 */     this.mifang_start_time = _mifang_start_time_;
/* 100 */     this.mifang_end_time = _mifang_end_time_;
/* 101 */     this.displayid = _displayid_;
/* 102 */     this.teams = _teams_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 106 */     for (MemberInfo _v_ : this.memberlist)
/* 107 */       if (!_v_._validator_()) return false;
/* 108 */     for (GangAnnouncement _v_ : this.announcementlist)
/* 109 */       if (!_v_._validator_()) return false;
/* 110 */     if (!this.xiangfanginfo._validator_()) return false;
/* 111 */     if (!this.cangkuinfo._validator_()) return false;
/* 112 */     if (!this.jinkuinfo._validator_()) return false;
/* 113 */     if (!this.yaodianinfo._validator_()) return false;
/* 114 */     if (!this.shuyuaninfo._validator_()) return false;
/* 115 */     for (GangTeam _v_ : this.teams)
/* 116 */       if (!_v_._validator_()) return false;
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 121 */     _os_.marshal(this.gangid);
/* 122 */     _os_.marshal(this.name, "UTF-16LE");
/* 123 */     _os_.marshal(this.bangzhu, "UTF-16LE");
/* 124 */     _os_.marshal(this.level);
/* 125 */     _os_.marshal(this.money);
/* 126 */     _os_.marshal(this.vitality);
/* 127 */     _os_.marshal(this.purpose, "UTF-16LE");
/* 128 */     _os_.marshal(this.designdutynameid);
/* 129 */     _os_.marshal(this.createtime);
/* 130 */     _os_.marshal(this.xuetumaxlevel);
/* 131 */     _os_.marshal(this.buildendtime);
/* 132 */     _os_.marshal(this.tanheendtime);
/* 133 */     _os_.marshal(this.tanheroleid);
/* 134 */     _os_.compact_uint32(this.memberlist.size());
/* 135 */     for (MemberInfo _v_ : this.memberlist) {
/* 136 */       _os_.marshal(_v_);
/*     */     }
/* 138 */     _os_.compact_uint32(this.announcementlist.size());
/* 139 */     for (GangAnnouncement _v_ : this.announcementlist) {
/* 140 */       _os_.marshal(_v_);
/*     */     }
/* 142 */     _os_.marshal(this.xiangfanginfo);
/* 143 */     _os_.marshal(this.cangkuinfo);
/* 144 */     _os_.marshal(this.jinkuinfo);
/* 145 */     _os_.marshal(this.yaodianinfo);
/* 146 */     _os_.marshal(this.mapinstanceid);
/* 147 */     _os_.marshal(this.shuyuaninfo);
/* 148 */     _os_.marshal(this.issign);
/* 149 */     _os_.marshal(this.signstr, "UTF-16LE");
/* 150 */     _os_.marshal(this.fuli_timestamp);
/* 151 */     _os_.marshal(this.mifang_start_time);
/* 152 */     _os_.marshal(this.mifang_end_time);
/* 153 */     _os_.marshal(this.displayid);
/* 154 */     _os_.compact_uint32(this.teams.size());
/* 155 */     for (GangTeam _v_ : this.teams) {
/* 156 */       _os_.marshal(_v_);
/*     */     }
/* 158 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 162 */     this.gangid = _os_.unmarshal_long();
/* 163 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 164 */     this.bangzhu = _os_.unmarshal_String("UTF-16LE");
/* 165 */     this.level = _os_.unmarshal_int();
/* 166 */     this.money = _os_.unmarshal_int();
/* 167 */     this.vitality = _os_.unmarshal_int();
/* 168 */     this.purpose = _os_.unmarshal_String("UTF-16LE");
/* 169 */     this.designdutynameid = _os_.unmarshal_int();
/* 170 */     this.createtime = _os_.unmarshal_int();
/* 171 */     this.xuetumaxlevel = _os_.unmarshal_int();
/* 172 */     this.buildendtime = _os_.unmarshal_int();
/* 173 */     this.tanheendtime = _os_.unmarshal_int();
/* 174 */     this.tanheroleid = _os_.unmarshal_long();
/* 175 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 176 */       MemberInfo _v_ = new MemberInfo();
/* 177 */       _v_.unmarshal(_os_);
/* 178 */       this.memberlist.add(_v_);
/*     */     }
/* 180 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 181 */       GangAnnouncement _v_ = new GangAnnouncement();
/* 182 */       _v_.unmarshal(_os_);
/* 183 */       this.announcementlist.add(_v_);
/*     */     }
/* 185 */     this.xiangfanginfo.unmarshal(_os_);
/* 186 */     this.cangkuinfo.unmarshal(_os_);
/* 187 */     this.jinkuinfo.unmarshal(_os_);
/* 188 */     this.yaodianinfo.unmarshal(_os_);
/* 189 */     this.mapinstanceid = _os_.unmarshal_int();
/* 190 */     this.shuyuaninfo.unmarshal(_os_);
/* 191 */     this.issign = _os_.unmarshal_int();
/* 192 */     this.signstr = _os_.unmarshal_String("UTF-16LE");
/* 193 */     this.fuli_timestamp = _os_.unmarshal_long();
/* 194 */     this.mifang_start_time = _os_.unmarshal_long();
/* 195 */     this.mifang_end_time = _os_.unmarshal_long();
/* 196 */     this.displayid = _os_.unmarshal_long();
/* 197 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 198 */       GangTeam _v_ = new GangTeam();
/* 199 */       _v_.unmarshal(_os_);
/* 200 */       this.teams.add(_v_);
/*     */     }
/* 202 */     if (!_validator_()) {
/* 203 */       throw new VerifyError("validator failed");
/*     */     }
/* 205 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 209 */     if (_o1_ == this) return true;
/* 210 */     if ((_o1_ instanceof SSyncGangInfo)) {
/* 211 */       SSyncGangInfo _o_ = (SSyncGangInfo)_o1_;
/* 212 */       if (this.gangid != _o_.gangid) return false;
/* 213 */       if (!this.name.equals(_o_.name)) return false;
/* 214 */       if (!this.bangzhu.equals(_o_.bangzhu)) return false;
/* 215 */       if (this.level != _o_.level) return false;
/* 216 */       if (this.money != _o_.money) return false;
/* 217 */       if (this.vitality != _o_.vitality) return false;
/* 218 */       if (!this.purpose.equals(_o_.purpose)) return false;
/* 219 */       if (this.designdutynameid != _o_.designdutynameid) return false;
/* 220 */       if (this.createtime != _o_.createtime) return false;
/* 221 */       if (this.xuetumaxlevel != _o_.xuetumaxlevel) return false;
/* 222 */       if (this.buildendtime != _o_.buildendtime) return false;
/* 223 */       if (this.tanheendtime != _o_.tanheendtime) return false;
/* 224 */       if (this.tanheroleid != _o_.tanheroleid) return false;
/* 225 */       if (!this.memberlist.equals(_o_.memberlist)) return false;
/* 226 */       if (!this.announcementlist.equals(_o_.announcementlist)) return false;
/* 227 */       if (!this.xiangfanginfo.equals(_o_.xiangfanginfo)) return false;
/* 228 */       if (!this.cangkuinfo.equals(_o_.cangkuinfo)) return false;
/* 229 */       if (!this.jinkuinfo.equals(_o_.jinkuinfo)) return false;
/* 230 */       if (!this.yaodianinfo.equals(_o_.yaodianinfo)) return false;
/* 231 */       if (this.mapinstanceid != _o_.mapinstanceid) return false;
/* 232 */       if (!this.shuyuaninfo.equals(_o_.shuyuaninfo)) return false;
/* 233 */       if (this.issign != _o_.issign) return false;
/* 234 */       if (!this.signstr.equals(_o_.signstr)) return false;
/* 235 */       if (this.fuli_timestamp != _o_.fuli_timestamp) return false;
/* 236 */       if (this.mifang_start_time != _o_.mifang_start_time) return false;
/* 237 */       if (this.mifang_end_time != _o_.mifang_end_time) return false;
/* 238 */       if (this.displayid != _o_.displayid) return false;
/* 239 */       if (!this.teams.equals(_o_.teams)) return false;
/* 240 */       return true;
/*     */     }
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 246 */     int _h_ = 0;
/* 247 */     _h_ += (int)this.gangid;
/* 248 */     _h_ += this.name.hashCode();
/* 249 */     _h_ += this.bangzhu.hashCode();
/* 250 */     _h_ += this.level;
/* 251 */     _h_ += this.money;
/* 252 */     _h_ += this.vitality;
/* 253 */     _h_ += this.purpose.hashCode();
/* 254 */     _h_ += this.designdutynameid;
/* 255 */     _h_ += this.createtime;
/* 256 */     _h_ += this.xuetumaxlevel;
/* 257 */     _h_ += this.buildendtime;
/* 258 */     _h_ += this.tanheendtime;
/* 259 */     _h_ += (int)this.tanheroleid;
/* 260 */     _h_ += this.memberlist.hashCode();
/* 261 */     _h_ += this.announcementlist.hashCode();
/* 262 */     _h_ += this.xiangfanginfo.hashCode();
/* 263 */     _h_ += this.cangkuinfo.hashCode();
/* 264 */     _h_ += this.jinkuinfo.hashCode();
/* 265 */     _h_ += this.yaodianinfo.hashCode();
/* 266 */     _h_ += this.mapinstanceid;
/* 267 */     _h_ += this.shuyuaninfo.hashCode();
/* 268 */     _h_ += this.issign;
/* 269 */     _h_ += this.signstr.hashCode();
/* 270 */     _h_ += (int)this.fuli_timestamp;
/* 271 */     _h_ += (int)this.mifang_start_time;
/* 272 */     _h_ += (int)this.mifang_end_time;
/* 273 */     _h_ += (int)this.displayid;
/* 274 */     _h_ += this.teams.hashCode();
/* 275 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.gangid).append(",");
/* 282 */     _sb_.append("T").append(this.name.length()).append(",");
/* 283 */     _sb_.append("T").append(this.bangzhu.length()).append(",");
/* 284 */     _sb_.append(this.level).append(",");
/* 285 */     _sb_.append(this.money).append(",");
/* 286 */     _sb_.append(this.vitality).append(",");
/* 287 */     _sb_.append("T").append(this.purpose.length()).append(",");
/* 288 */     _sb_.append(this.designdutynameid).append(",");
/* 289 */     _sb_.append(this.createtime).append(",");
/* 290 */     _sb_.append(this.xuetumaxlevel).append(",");
/* 291 */     _sb_.append(this.buildendtime).append(",");
/* 292 */     _sb_.append(this.tanheendtime).append(",");
/* 293 */     _sb_.append(this.tanheroleid).append(",");
/* 294 */     _sb_.append(this.memberlist).append(",");
/* 295 */     _sb_.append(this.announcementlist).append(",");
/* 296 */     _sb_.append(this.xiangfanginfo).append(",");
/* 297 */     _sb_.append(this.cangkuinfo).append(",");
/* 298 */     _sb_.append(this.jinkuinfo).append(",");
/* 299 */     _sb_.append(this.yaodianinfo).append(",");
/* 300 */     _sb_.append(this.mapinstanceid).append(",");
/* 301 */     _sb_.append(this.shuyuaninfo).append(",");
/* 302 */     _sb_.append(this.issign).append(",");
/* 303 */     _sb_.append("T").append(this.signstr.length()).append(",");
/* 304 */     _sb_.append(this.fuli_timestamp).append(",");
/* 305 */     _sb_.append(this.mifang_start_time).append(",");
/* 306 */     _sb_.append(this.mifang_end_time).append(",");
/* 307 */     _sb_.append(this.displayid).append(",");
/* 308 */     _sb_.append(this.teams).append(",");
/* 309 */     _sb_.append(")");
/* 310 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncGangInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */