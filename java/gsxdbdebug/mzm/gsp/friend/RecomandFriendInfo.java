/*     */ package mzm.gsp.friend;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class RecomandFriendInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int rolelevel;
/*     */   public int isgrcfriend;
/*     */   public int isonline;
/*     */   public int occupationid;
/*     */   public int sex;
/*     */   public int friendset;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public RecomandFriendInfo()
/*     */   {
/*  21 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public RecomandFriendInfo(long _roleid_, String _rolename_, int _rolelevel_, int _isgrcfriend_, int _isonline_, int _occupationid_, int _sex_, int _friendset_, int _avatarid_, int _avatarframeid_) {
/*  25 */     this.roleid = _roleid_;
/*  26 */     this.rolename = _rolename_;
/*  27 */     this.rolelevel = _rolelevel_;
/*  28 */     this.isgrcfriend = _isgrcfriend_;
/*  29 */     this.isonline = _isonline_;
/*  30 */     this.occupationid = _occupationid_;
/*  31 */     this.sex = _sex_;
/*  32 */     this.friendset = _friendset_;
/*  33 */     this.avatarid = _avatarid_;
/*  34 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  42 */     _os_.marshal(this.roleid);
/*  43 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  44 */     _os_.marshal(this.rolelevel);
/*  45 */     _os_.marshal(this.isgrcfriend);
/*  46 */     _os_.marshal(this.isonline);
/*  47 */     _os_.marshal(this.occupationid);
/*  48 */     _os_.marshal(this.sex);
/*  49 */     _os_.marshal(this.friendset);
/*  50 */     _os_.marshal(this.avatarid);
/*  51 */     _os_.marshal(this.avatarframeid);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  56 */     this.roleid = _os_.unmarshal_long();
/*  57 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  58 */     this.rolelevel = _os_.unmarshal_int();
/*  59 */     this.isgrcfriend = _os_.unmarshal_int();
/*  60 */     this.isonline = _os_.unmarshal_int();
/*  61 */     this.occupationid = _os_.unmarshal_int();
/*  62 */     this.sex = _os_.unmarshal_int();
/*  63 */     this.friendset = _os_.unmarshal_int();
/*  64 */     this.avatarid = _os_.unmarshal_int();
/*  65 */     this.avatarframeid = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof RecomandFriendInfo)) {
/*  72 */       RecomandFriendInfo _o_ = (RecomandFriendInfo)_o1_;
/*  73 */       if (this.roleid != _o_.roleid) return false;
/*  74 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  75 */       if (this.rolelevel != _o_.rolelevel) return false;
/*  76 */       if (this.isgrcfriend != _o_.isgrcfriend) return false;
/*  77 */       if (this.isonline != _o_.isonline) return false;
/*  78 */       if (this.occupationid != _o_.occupationid) return false;
/*  79 */       if (this.sex != _o_.sex) return false;
/*  80 */       if (this.friendset != _o_.friendset) return false;
/*  81 */       if (this.avatarid != _o_.avatarid) return false;
/*  82 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.roleid;
/*  91 */     _h_ += this.rolename.hashCode();
/*  92 */     _h_ += this.rolelevel;
/*  93 */     _h_ += this.isgrcfriend;
/*  94 */     _h_ += this.isonline;
/*  95 */     _h_ += this.occupationid;
/*  96 */     _h_ += this.sex;
/*  97 */     _h_ += this.friendset;
/*  98 */     _h_ += this.avatarid;
/*  99 */     _h_ += this.avatarframeid;
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.roleid).append(",");
/* 107 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 108 */     _sb_.append(this.rolelevel).append(",");
/* 109 */     _sb_.append(this.isgrcfriend).append(",");
/* 110 */     _sb_.append(this.isonline).append(",");
/* 111 */     _sb_.append(this.occupationid).append(",");
/* 112 */     _sb_.append(this.sex).append(",");
/* 113 */     _sb_.append(this.friendset).append(",");
/* 114 */     _sb_.append(this.avatarid).append(",");
/* 115 */     _sb_.append(this.avatarframeid).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\RecomandFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */