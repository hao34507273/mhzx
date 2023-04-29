/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class TeamMemberInfo
/*     */   implements Marshal
/*     */ {
/*     */   public long teammember_id;
/*     */   public String name;
/*     */   public int level;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int status;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public TeamMemberInfo()
/*     */   {
/*  21 */     this.name = "";
/*     */   }
/*     */   
/*     */   public TeamMemberInfo(long _teammember_id_, String _name_, int _level_, int _menpai_, int _gender_, int _status_, int _avatarid_, int _avatarframeid_) {
/*  25 */     this.teammember_id = _teammember_id_;
/*  26 */     this.name = _name_;
/*  27 */     this.level = _level_;
/*  28 */     this.menpai = _menpai_;
/*  29 */     this.gender = _gender_;
/*  30 */     this.status = _status_;
/*  31 */     this.avatarid = _avatarid_;
/*  32 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.teammember_id);
/*  41 */     _os_.marshal(this.name, "UTF-16LE");
/*  42 */     _os_.marshal(this.level);
/*  43 */     _os_.marshal(this.menpai);
/*  44 */     _os_.marshal(this.gender);
/*  45 */     _os_.marshal(this.status);
/*  46 */     _os_.marshal(this.avatarid);
/*  47 */     _os_.marshal(this.avatarframeid);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  52 */     this.teammember_id = _os_.unmarshal_long();
/*  53 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  54 */     this.level = _os_.unmarshal_int();
/*  55 */     this.menpai = _os_.unmarshal_int();
/*  56 */     this.gender = _os_.unmarshal_int();
/*  57 */     this.status = _os_.unmarshal_int();
/*  58 */     this.avatarid = _os_.unmarshal_int();
/*  59 */     this.avatarframeid = _os_.unmarshal_int();
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof TeamMemberInfo)) {
/*  66 */       TeamMemberInfo _o_ = (TeamMemberInfo)_o1_;
/*  67 */       if (this.teammember_id != _o_.teammember_id) return false;
/*  68 */       if (!this.name.equals(_o_.name)) return false;
/*  69 */       if (this.level != _o_.level) return false;
/*  70 */       if (this.menpai != _o_.menpai) return false;
/*  71 */       if (this.gender != _o_.gender) return false;
/*  72 */       if (this.status != _o_.status) return false;
/*  73 */       if (this.avatarid != _o_.avatarid) return false;
/*  74 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.teammember_id;
/*  83 */     _h_ += this.name.hashCode();
/*  84 */     _h_ += this.level;
/*  85 */     _h_ += this.menpai;
/*  86 */     _h_ += this.gender;
/*  87 */     _h_ += this.status;
/*  88 */     _h_ += this.avatarid;
/*  89 */     _h_ += this.avatarframeid;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.teammember_id).append(",");
/*  97 */     _sb_.append("T").append(this.name.length()).append(",");
/*  98 */     _sb_.append(this.level).append(",");
/*  99 */     _sb_.append(this.menpai).append(",");
/* 100 */     _sb_.append(this.gender).append(",");
/* 101 */     _sb_.append(this.status).append(",");
/* 102 */     _sb_.append(this.avatarid).append(",");
/* 103 */     _sb_.append(this.avatarframeid).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\TeamMemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */