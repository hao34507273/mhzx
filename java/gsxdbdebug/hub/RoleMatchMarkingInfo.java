/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class RoleMatchMarkingInfo implements Marshal
/*     */ {
/*     */   public int phys_zoneid;
/*     */   public Octets userid;
/*     */   public long roleid;
/*     */   public int ranking;
/*     */   public int win_num;
/*     */   public int lose_num;
/*     */   public int display_rank;
/*     */   public Octets rolename;
/*     */   public int level;
/*     */   public int gender;
/*     */   public int occupation;
/*     */   public int avatarid;
/*     */   public int avatar_frameid;
/*     */   
/*     */   public RoleMatchMarkingInfo()
/*     */   {
/*  26 */     this.phys_zoneid = 0;
/*  27 */     this.userid = new Octets();
/*  28 */     this.roleid = 0L;
/*  29 */     this.ranking = 0;
/*  30 */     this.win_num = 0;
/*  31 */     this.lose_num = 0;
/*  32 */     this.display_rank = 0;
/*  33 */     this.rolename = new Octets();
/*  34 */     this.level = 0;
/*  35 */     this.gender = 0;
/*  36 */     this.occupation = 0;
/*     */   }
/*     */   
/*     */   public RoleMatchMarkingInfo(int _phys_zoneid_, Octets _userid_, long _roleid_, int _ranking_, int _win_num_, int _lose_num_, int _display_rank_, Octets _rolename_, int _level_, int _gender_, int _occupation_, int _avatarid_, int _avatar_frameid_) {
/*  40 */     this.phys_zoneid = _phys_zoneid_;
/*  41 */     this.userid = _userid_;
/*  42 */     this.roleid = _roleid_;
/*  43 */     this.ranking = _ranking_;
/*  44 */     this.win_num = _win_num_;
/*  45 */     this.lose_num = _lose_num_;
/*  46 */     this.display_rank = _display_rank_;
/*  47 */     this.rolename = _rolename_;
/*  48 */     this.level = _level_;
/*  49 */     this.gender = _gender_;
/*  50 */     this.occupation = _occupation_;
/*  51 */     this.avatarid = _avatarid_;
/*  52 */     this.avatar_frameid = _avatar_frameid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.phys_zoneid);
/*  61 */     _os_.marshal(this.userid);
/*  62 */     _os_.marshal(this.roleid);
/*  63 */     _os_.marshal(this.ranking);
/*  64 */     _os_.marshal(this.win_num);
/*  65 */     _os_.marshal(this.lose_num);
/*  66 */     _os_.marshal(this.display_rank);
/*  67 */     _os_.marshal(this.rolename);
/*  68 */     _os_.marshal(this.level);
/*  69 */     _os_.marshal(this.gender);
/*  70 */     _os_.marshal(this.occupation);
/*  71 */     _os_.marshal(this.avatarid);
/*  72 */     _os_.marshal(this.avatar_frameid);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     this.phys_zoneid = _os_.unmarshal_int();
/*  78 */     this.userid = _os_.unmarshal_Octets();
/*  79 */     this.roleid = _os_.unmarshal_long();
/*  80 */     this.ranking = _os_.unmarshal_int();
/*  81 */     this.win_num = _os_.unmarshal_int();
/*  82 */     this.lose_num = _os_.unmarshal_int();
/*  83 */     this.display_rank = _os_.unmarshal_int();
/*  84 */     this.rolename = _os_.unmarshal_Octets();
/*  85 */     this.level = _os_.unmarshal_int();
/*  86 */     this.gender = _os_.unmarshal_int();
/*  87 */     this.occupation = _os_.unmarshal_int();
/*  88 */     this.avatarid = _os_.unmarshal_int();
/*  89 */     this.avatar_frameid = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof RoleMatchMarkingInfo)) {
/*  96 */       RoleMatchMarkingInfo _o_ = (RoleMatchMarkingInfo)_o1_;
/*  97 */       if (this.phys_zoneid != _o_.phys_zoneid) return false;
/*  98 */       if (!this.userid.equals(_o_.userid)) return false;
/*  99 */       if (this.roleid != _o_.roleid) return false;
/* 100 */       if (this.ranking != _o_.ranking) return false;
/* 101 */       if (this.win_num != _o_.win_num) return false;
/* 102 */       if (this.lose_num != _o_.lose_num) return false;
/* 103 */       if (this.display_rank != _o_.display_rank) return false;
/* 104 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 105 */       if (this.level != _o_.level) return false;
/* 106 */       if (this.gender != _o_.gender) return false;
/* 107 */       if (this.occupation != _o_.occupation) return false;
/* 108 */       if (this.avatarid != _o_.avatarid) return false;
/* 109 */       if (this.avatar_frameid != _o_.avatar_frameid) return false;
/* 110 */       return true;
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 116 */     int _h_ = 0;
/* 117 */     _h_ += this.phys_zoneid;
/* 118 */     _h_ += this.userid.hashCode();
/* 119 */     _h_ += (int)this.roleid;
/* 120 */     _h_ += this.ranking;
/* 121 */     _h_ += this.win_num;
/* 122 */     _h_ += this.lose_num;
/* 123 */     _h_ += this.display_rank;
/* 124 */     _h_ += this.rolename.hashCode();
/* 125 */     _h_ += this.level;
/* 126 */     _h_ += this.gender;
/* 127 */     _h_ += this.occupation;
/* 128 */     _h_ += this.avatarid;
/* 129 */     _h_ += this.avatar_frameid;
/* 130 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder _sb_ = new StringBuilder();
/* 135 */     _sb_.append("(");
/* 136 */     _sb_.append(this.phys_zoneid).append(",");
/* 137 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 138 */     _sb_.append(this.roleid).append(",");
/* 139 */     _sb_.append(this.ranking).append(",");
/* 140 */     _sb_.append(this.win_num).append(",");
/* 141 */     _sb_.append(this.lose_num).append(",");
/* 142 */     _sb_.append(this.display_rank).append(",");
/* 143 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 144 */     _sb_.append(this.level).append(",");
/* 145 */     _sb_.append(this.gender).append(",");
/* 146 */     _sb_.append(this.occupation).append(",");
/* 147 */     _sb_.append(this.avatarid).append(",");
/* 148 */     _sb_.append(this.avatar_frameid).append(",");
/* 149 */     _sb_.append(")");
/* 150 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoleMatchMarkingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */