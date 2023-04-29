/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class MemberInfo
/*     */   implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String name;
/*     */   public int level;
/*     */   public int gender;
/*     */   public int occupationid;
/*     */   public int avatarid;
/*     */   public int avatar_frame;
/*     */   public int duty;
/*     */   public int curbanggong;
/*     */   public int historybanggong;
/*     */   public long offlinetime;
/*     */   public long forbiddentalk;
/*     */   public long jointime;
/*     */   public long getlihetime;
/*     */   public int gongxun;
/*     */   public int weekbanggong;
/*     */   public long add_banggong_time;
/*     */   public int weekitem_banggong_count;
/*     */   public long item_banggong_time;
/*     */   public int fight_value;
/*     */   
/*     */   public MemberInfo()
/*     */   {
/*  33 */     this.name = "";
/*     */   }
/*     */   
/*     */   public MemberInfo(long _roleid_, String _name_, int _level_, int _gender_, int _occupationid_, int _avatarid_, int _avatar_frame_, int _duty_, int _curbanggong_, int _historybanggong_, long _offlinetime_, long _forbiddentalk_, long _jointime_, long _getlihetime_, int _gongxun_, int _weekbanggong_, long _add_banggong_time_, int _weekitem_banggong_count_, long _item_banggong_time_, int _fight_value_) {
/*  37 */     this.roleid = _roleid_;
/*  38 */     this.name = _name_;
/*  39 */     this.level = _level_;
/*  40 */     this.gender = _gender_;
/*  41 */     this.occupationid = _occupationid_;
/*  42 */     this.avatarid = _avatarid_;
/*  43 */     this.avatar_frame = _avatar_frame_;
/*  44 */     this.duty = _duty_;
/*  45 */     this.curbanggong = _curbanggong_;
/*  46 */     this.historybanggong = _historybanggong_;
/*  47 */     this.offlinetime = _offlinetime_;
/*  48 */     this.forbiddentalk = _forbiddentalk_;
/*  49 */     this.jointime = _jointime_;
/*  50 */     this.getlihetime = _getlihetime_;
/*  51 */     this.gongxun = _gongxun_;
/*  52 */     this.weekbanggong = _weekbanggong_;
/*  53 */     this.add_banggong_time = _add_banggong_time_;
/*  54 */     this.weekitem_banggong_count = _weekitem_banggong_count_;
/*  55 */     this.item_banggong_time = _item_banggong_time_;
/*  56 */     this.fight_value = _fight_value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.roleid);
/*  65 */     _os_.marshal(this.name, "UTF-16LE");
/*  66 */     _os_.marshal(this.level);
/*  67 */     _os_.marshal(this.gender);
/*  68 */     _os_.marshal(this.occupationid);
/*  69 */     _os_.marshal(this.avatarid);
/*  70 */     _os_.marshal(this.avatar_frame);
/*  71 */     _os_.marshal(this.duty);
/*  72 */     _os_.marshal(this.curbanggong);
/*  73 */     _os_.marshal(this.historybanggong);
/*  74 */     _os_.marshal(this.offlinetime);
/*  75 */     _os_.marshal(this.forbiddentalk);
/*  76 */     _os_.marshal(this.jointime);
/*  77 */     _os_.marshal(this.getlihetime);
/*  78 */     _os_.marshal(this.gongxun);
/*  79 */     _os_.marshal(this.weekbanggong);
/*  80 */     _os_.marshal(this.add_banggong_time);
/*  81 */     _os_.marshal(this.weekitem_banggong_count);
/*  82 */     _os_.marshal(this.item_banggong_time);
/*  83 */     _os_.marshal(this.fight_value);
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  88 */     this.roleid = _os_.unmarshal_long();
/*  89 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  90 */     this.level = _os_.unmarshal_int();
/*  91 */     this.gender = _os_.unmarshal_int();
/*  92 */     this.occupationid = _os_.unmarshal_int();
/*  93 */     this.avatarid = _os_.unmarshal_int();
/*  94 */     this.avatar_frame = _os_.unmarshal_int();
/*  95 */     this.duty = _os_.unmarshal_int();
/*  96 */     this.curbanggong = _os_.unmarshal_int();
/*  97 */     this.historybanggong = _os_.unmarshal_int();
/*  98 */     this.offlinetime = _os_.unmarshal_long();
/*  99 */     this.forbiddentalk = _os_.unmarshal_long();
/* 100 */     this.jointime = _os_.unmarshal_long();
/* 101 */     this.getlihetime = _os_.unmarshal_long();
/* 102 */     this.gongxun = _os_.unmarshal_int();
/* 103 */     this.weekbanggong = _os_.unmarshal_int();
/* 104 */     this.add_banggong_time = _os_.unmarshal_long();
/* 105 */     this.weekitem_banggong_count = _os_.unmarshal_int();
/* 106 */     this.item_banggong_time = _os_.unmarshal_long();
/* 107 */     this.fight_value = _os_.unmarshal_int();
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 112 */     if (_o1_ == this) return true;
/* 113 */     if ((_o1_ instanceof MemberInfo)) {
/* 114 */       MemberInfo _o_ = (MemberInfo)_o1_;
/* 115 */       if (this.roleid != _o_.roleid) return false;
/* 116 */       if (!this.name.equals(_o_.name)) return false;
/* 117 */       if (this.level != _o_.level) return false;
/* 118 */       if (this.gender != _o_.gender) return false;
/* 119 */       if (this.occupationid != _o_.occupationid) return false;
/* 120 */       if (this.avatarid != _o_.avatarid) return false;
/* 121 */       if (this.avatar_frame != _o_.avatar_frame) return false;
/* 122 */       if (this.duty != _o_.duty) return false;
/* 123 */       if (this.curbanggong != _o_.curbanggong) return false;
/* 124 */       if (this.historybanggong != _o_.historybanggong) return false;
/* 125 */       if (this.offlinetime != _o_.offlinetime) return false;
/* 126 */       if (this.forbiddentalk != _o_.forbiddentalk) return false;
/* 127 */       if (this.jointime != _o_.jointime) return false;
/* 128 */       if (this.getlihetime != _o_.getlihetime) return false;
/* 129 */       if (this.gongxun != _o_.gongxun) return false;
/* 130 */       if (this.weekbanggong != _o_.weekbanggong) return false;
/* 131 */       if (this.add_banggong_time != _o_.add_banggong_time) return false;
/* 132 */       if (this.weekitem_banggong_count != _o_.weekitem_banggong_count) return false;
/* 133 */       if (this.item_banggong_time != _o_.item_banggong_time) return false;
/* 134 */       if (this.fight_value != _o_.fight_value) return false;
/* 135 */       return true;
/*     */     }
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 141 */     int _h_ = 0;
/* 142 */     _h_ += (int)this.roleid;
/* 143 */     _h_ += this.name.hashCode();
/* 144 */     _h_ += this.level;
/* 145 */     _h_ += this.gender;
/* 146 */     _h_ += this.occupationid;
/* 147 */     _h_ += this.avatarid;
/* 148 */     _h_ += this.avatar_frame;
/* 149 */     _h_ += this.duty;
/* 150 */     _h_ += this.curbanggong;
/* 151 */     _h_ += this.historybanggong;
/* 152 */     _h_ += (int)this.offlinetime;
/* 153 */     _h_ += (int)this.forbiddentalk;
/* 154 */     _h_ += (int)this.jointime;
/* 155 */     _h_ += (int)this.getlihetime;
/* 156 */     _h_ += this.gongxun;
/* 157 */     _h_ += this.weekbanggong;
/* 158 */     _h_ += (int)this.add_banggong_time;
/* 159 */     _h_ += this.weekitem_banggong_count;
/* 160 */     _h_ += (int)this.item_banggong_time;
/* 161 */     _h_ += this.fight_value;
/* 162 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 166 */     StringBuilder _sb_ = new StringBuilder();
/* 167 */     _sb_.append("(");
/* 168 */     _sb_.append(this.roleid).append(",");
/* 169 */     _sb_.append("T").append(this.name.length()).append(",");
/* 170 */     _sb_.append(this.level).append(",");
/* 171 */     _sb_.append(this.gender).append(",");
/* 172 */     _sb_.append(this.occupationid).append(",");
/* 173 */     _sb_.append(this.avatarid).append(",");
/* 174 */     _sb_.append(this.avatar_frame).append(",");
/* 175 */     _sb_.append(this.duty).append(",");
/* 176 */     _sb_.append(this.curbanggong).append(",");
/* 177 */     _sb_.append(this.historybanggong).append(",");
/* 178 */     _sb_.append(this.offlinetime).append(",");
/* 179 */     _sb_.append(this.forbiddentalk).append(",");
/* 180 */     _sb_.append(this.jointime).append(",");
/* 181 */     _sb_.append(this.getlihetime).append(",");
/* 182 */     _sb_.append(this.gongxun).append(",");
/* 183 */     _sb_.append(this.weekbanggong).append(",");
/* 184 */     _sb_.append(this.add_banggong_time).append(",");
/* 185 */     _sb_.append(this.weekitem_banggong_count).append(",");
/* 186 */     _sb_.append(this.item_banggong_time).append(",");
/* 187 */     _sb_.append(this.fight_value).append(",");
/* 188 */     _sb_.append(")");
/* 189 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\MemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */