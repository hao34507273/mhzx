/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SSyncHeroProp extends __SSyncHeroProp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586007;
/*     */   public static final int MAIL = 1;
/*     */   public static final int FEMAIL = 2;
/*     */   public static final int PROP_SYS_1 = 0;
/*     */   public static final int PROP_SYS_2 = 1;
/*     */   public static final int PROP_SYS_3 = 2;
/*     */   public long roleid;
/*     */   public String name;
/*     */   public int occupation;
/*     */   public int gender;
/*     */   public int level;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12586007;
/*     */   }
/*     */   
/*     */ 
/*     */   public int appelation;
/*     */   
/*     */   public long exp;
/*     */   
/*     */   public int hp;
/*     */   
/*     */   public int mp;
/*     */   
/*     */   public int vigor;
/*     */   
/*     */   public int anger;
/*     */   
/*     */   public HashMap<Integer, Integer> propmap;
/*     */   
/*     */   public HashMap<Integer, PropSys> propsysmap;
/*     */   
/*     */   public int activitypropsys;
/*     */   
/*     */   public int todayactivitycount;
/*     */   
/*     */   public int fightvalue;
/*     */   public long createtime;
/*     */   public SSyncHeroProp()
/*     */   {
/*  53 */     this.name = "";
/*  54 */     this.propmap = new HashMap();
/*  55 */     this.propsysmap = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncHeroProp(long _roleid_, String _name_, int _occupation_, int _gender_, int _level_, int _appelation_, long _exp_, int _hp_, int _mp_, int _vigor_, int _anger_, HashMap<Integer, Integer> _propmap_, HashMap<Integer, PropSys> _propsysmap_, int _activitypropsys_, int _todayactivitycount_, int _fightvalue_, long _createtime_) {
/*  59 */     this.roleid = _roleid_;
/*  60 */     this.name = _name_;
/*  61 */     this.occupation = _occupation_;
/*  62 */     this.gender = _gender_;
/*  63 */     this.level = _level_;
/*  64 */     this.appelation = _appelation_;
/*  65 */     this.exp = _exp_;
/*  66 */     this.hp = _hp_;
/*  67 */     this.mp = _mp_;
/*  68 */     this.vigor = _vigor_;
/*  69 */     this.anger = _anger_;
/*  70 */     this.propmap = _propmap_;
/*  71 */     this.propsysmap = _propsysmap_;
/*  72 */     this.activitypropsys = _activitypropsys_;
/*  73 */     this.todayactivitycount = _todayactivitycount_;
/*  74 */     this.fightvalue = _fightvalue_;
/*  75 */     this.createtime = _createtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  79 */     for (Map.Entry<Integer, PropSys> _e_ : this.propsysmap.entrySet()) {
/*  80 */       if (!((PropSys)_e_.getValue())._validator_()) return false;
/*     */     }
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  86 */     _os_.marshal(this.roleid);
/*  87 */     _os_.marshal(this.name, "UTF-16LE");
/*  88 */     _os_.marshal(this.occupation);
/*  89 */     _os_.marshal(this.gender);
/*  90 */     _os_.marshal(this.level);
/*  91 */     _os_.marshal(this.appelation);
/*  92 */     _os_.marshal(this.exp);
/*  93 */     _os_.marshal(this.hp);
/*  94 */     _os_.marshal(this.mp);
/*  95 */     _os_.marshal(this.vigor);
/*  96 */     _os_.marshal(this.anger);
/*  97 */     _os_.compact_uint32(this.propmap.size());
/*  98 */     for (Map.Entry<Integer, Integer> _e_ : this.propmap.entrySet()) {
/*  99 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 100 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 102 */     _os_.compact_uint32(this.propsysmap.size());
/* 103 */     for (Map.Entry<Integer, PropSys> _e_ : this.propsysmap.entrySet()) {
/* 104 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 105 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 107 */     _os_.marshal(this.activitypropsys);
/* 108 */     _os_.marshal(this.todayactivitycount);
/* 109 */     _os_.marshal(this.fightvalue);
/* 110 */     _os_.marshal(this.createtime);
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 115 */     this.roleid = _os_.unmarshal_long();
/* 116 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 117 */     this.occupation = _os_.unmarshal_int();
/* 118 */     this.gender = _os_.unmarshal_int();
/* 119 */     this.level = _os_.unmarshal_int();
/* 120 */     this.appelation = _os_.unmarshal_int();
/* 121 */     this.exp = _os_.unmarshal_long();
/* 122 */     this.hp = _os_.unmarshal_int();
/* 123 */     this.mp = _os_.unmarshal_int();
/* 124 */     this.vigor = _os_.unmarshal_int();
/* 125 */     this.anger = _os_.unmarshal_int();
/* 126 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 128 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 130 */       int _v_ = _os_.unmarshal_int();
/* 131 */       this.propmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 133 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 135 */       int _k_ = _os_.unmarshal_int();
/* 136 */       PropSys _v_ = new PropSys();
/* 137 */       _v_.unmarshal(_os_);
/* 138 */       this.propsysmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 140 */     this.activitypropsys = _os_.unmarshal_int();
/* 141 */     this.todayactivitycount = _os_.unmarshal_int();
/* 142 */     this.fightvalue = _os_.unmarshal_int();
/* 143 */     this.createtime = _os_.unmarshal_long();
/* 144 */     if (!_validator_()) {
/* 145 */       throw new VerifyError("validator failed");
/*     */     }
/* 147 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 151 */     if (_o1_ == this) return true;
/* 152 */     if ((_o1_ instanceof SSyncHeroProp)) {
/* 153 */       SSyncHeroProp _o_ = (SSyncHeroProp)_o1_;
/* 154 */       if (this.roleid != _o_.roleid) return false;
/* 155 */       if (!this.name.equals(_o_.name)) return false;
/* 156 */       if (this.occupation != _o_.occupation) return false;
/* 157 */       if (this.gender != _o_.gender) return false;
/* 158 */       if (this.level != _o_.level) return false;
/* 159 */       if (this.appelation != _o_.appelation) return false;
/* 160 */       if (this.exp != _o_.exp) return false;
/* 161 */       if (this.hp != _o_.hp) return false;
/* 162 */       if (this.mp != _o_.mp) return false;
/* 163 */       if (this.vigor != _o_.vigor) return false;
/* 164 */       if (this.anger != _o_.anger) return false;
/* 165 */       if (!this.propmap.equals(_o_.propmap)) return false;
/* 166 */       if (!this.propsysmap.equals(_o_.propsysmap)) return false;
/* 167 */       if (this.activitypropsys != _o_.activitypropsys) return false;
/* 168 */       if (this.todayactivitycount != _o_.todayactivitycount) return false;
/* 169 */       if (this.fightvalue != _o_.fightvalue) return false;
/* 170 */       if (this.createtime != _o_.createtime) return false;
/* 171 */       return true;
/*     */     }
/* 173 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 177 */     int _h_ = 0;
/* 178 */     _h_ += (int)this.roleid;
/* 179 */     _h_ += this.name.hashCode();
/* 180 */     _h_ += this.occupation;
/* 181 */     _h_ += this.gender;
/* 182 */     _h_ += this.level;
/* 183 */     _h_ += this.appelation;
/* 184 */     _h_ += (int)this.exp;
/* 185 */     _h_ += this.hp;
/* 186 */     _h_ += this.mp;
/* 187 */     _h_ += this.vigor;
/* 188 */     _h_ += this.anger;
/* 189 */     _h_ += this.propmap.hashCode();
/* 190 */     _h_ += this.propsysmap.hashCode();
/* 191 */     _h_ += this.activitypropsys;
/* 192 */     _h_ += this.todayactivitycount;
/* 193 */     _h_ += this.fightvalue;
/* 194 */     _h_ += (int)this.createtime;
/* 195 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 199 */     StringBuilder _sb_ = new StringBuilder();
/* 200 */     _sb_.append("(");
/* 201 */     _sb_.append(this.roleid).append(",");
/* 202 */     _sb_.append("T").append(this.name.length()).append(",");
/* 203 */     _sb_.append(this.occupation).append(",");
/* 204 */     _sb_.append(this.gender).append(",");
/* 205 */     _sb_.append(this.level).append(",");
/* 206 */     _sb_.append(this.appelation).append(",");
/* 207 */     _sb_.append(this.exp).append(",");
/* 208 */     _sb_.append(this.hp).append(",");
/* 209 */     _sb_.append(this.mp).append(",");
/* 210 */     _sb_.append(this.vigor).append(",");
/* 211 */     _sb_.append(this.anger).append(",");
/* 212 */     _sb_.append(this.propmap).append(",");
/* 213 */     _sb_.append(this.propsysmap).append(",");
/* 214 */     _sb_.append(this.activitypropsys).append(",");
/* 215 */     _sb_.append(this.todayactivitycount).append(",");
/* 216 */     _sb_.append(this.fightvalue).append(",");
/* 217 */     _sb_.append(this.createtime).append(",");
/* 218 */     _sb_.append(")");
/* 219 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SSyncHeroProp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */