/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class SingleCrossFieldRoleMatchInfo implements Marshal
/*     */ {
/*     */   public int phys_zoneid;
/*     */   public Octets userid;
/*     */   public long roleid;
/*     */   public int season;
/*     */   public int star_num;
/*     */   public int level;
/*     */   public int fight_value;
/*     */   public long start_timestamp;
/*     */   
/*     */   public SingleCrossFieldRoleMatchInfo()
/*     */   {
/*  21 */     this.userid = new Octets();
/*     */   }
/*     */   
/*     */   public SingleCrossFieldRoleMatchInfo(int _phys_zoneid_, Octets _userid_, long _roleid_, int _season_, int _star_num_, int _level_, int _fight_value_, long _start_timestamp_) {
/*  25 */     this.phys_zoneid = _phys_zoneid_;
/*  26 */     this.userid = _userid_;
/*  27 */     this.roleid = _roleid_;
/*  28 */     this.season = _season_;
/*  29 */     this.star_num = _star_num_;
/*  30 */     this.level = _level_;
/*  31 */     this.fight_value = _fight_value_;
/*  32 */     this.start_timestamp = _start_timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.phys_zoneid);
/*  41 */     _os_.marshal(this.userid);
/*  42 */     _os_.marshal(this.roleid);
/*  43 */     _os_.marshal(this.season);
/*  44 */     _os_.marshal(this.star_num);
/*  45 */     _os_.marshal(this.level);
/*  46 */     _os_.marshal(this.fight_value);
/*  47 */     _os_.marshal(this.start_timestamp);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  52 */     this.phys_zoneid = _os_.unmarshal_int();
/*  53 */     this.userid = _os_.unmarshal_Octets();
/*  54 */     this.roleid = _os_.unmarshal_long();
/*  55 */     this.season = _os_.unmarshal_int();
/*  56 */     this.star_num = _os_.unmarshal_int();
/*  57 */     this.level = _os_.unmarshal_int();
/*  58 */     this.fight_value = _os_.unmarshal_int();
/*  59 */     this.start_timestamp = _os_.unmarshal_long();
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof SingleCrossFieldRoleMatchInfo)) {
/*  66 */       SingleCrossFieldRoleMatchInfo _o_ = (SingleCrossFieldRoleMatchInfo)_o1_;
/*  67 */       if (this.phys_zoneid != _o_.phys_zoneid) return false;
/*  68 */       if (!this.userid.equals(_o_.userid)) return false;
/*  69 */       if (this.roleid != _o_.roleid) return false;
/*  70 */       if (this.season != _o_.season) return false;
/*  71 */       if (this.star_num != _o_.star_num) return false;
/*  72 */       if (this.level != _o_.level) return false;
/*  73 */       if (this.fight_value != _o_.fight_value) return false;
/*  74 */       if (this.start_timestamp != _o_.start_timestamp) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.phys_zoneid;
/*  83 */     _h_ += this.userid.hashCode();
/*  84 */     _h_ += (int)this.roleid;
/*  85 */     _h_ += this.season;
/*  86 */     _h_ += this.star_num;
/*  87 */     _h_ += this.level;
/*  88 */     _h_ += this.fight_value;
/*  89 */     _h_ += (int)this.start_timestamp;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.phys_zoneid).append(",");
/*  97 */     _sb_.append("B").append(this.userid.size()).append(",");
/*  98 */     _sb_.append(this.roleid).append(",");
/*  99 */     _sb_.append(this.season).append(",");
/* 100 */     _sb_.append(this.star_num).append(",");
/* 101 */     _sb_.append(this.level).append(",");
/* 102 */     _sb_.append(this.fight_value).append(",");
/* 103 */     _sb_.append(this.start_timestamp).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SingleCrossFieldRoleMatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */