/*     */ package mzm.gsp.friend;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class FriendInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int rolelevel;
/*     */   public int occupationid;
/*     */   public int sex;
/*     */   public int onlinestatus;
/*     */   public int relationvalue;
/*     */   public int teammemcount;
/*     */   public int delstatus;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   public String remarkname;
/*     */   
/*     */   public FriendInfo()
/*     */   {
/*  23 */     this.rolename = "";
/*  24 */     this.remarkname = "";
/*     */   }
/*     */   
/*     */   public FriendInfo(long _roleid_, String _rolename_, int _rolelevel_, int _occupationid_, int _sex_, int _onlinestatus_, int _relationvalue_, int _teammemcount_, int _delstatus_, int _avatarid_, int _avatarframeid_, String _remarkname_) {
/*  28 */     this.roleid = _roleid_;
/*  29 */     this.rolename = _rolename_;
/*  30 */     this.rolelevel = _rolelevel_;
/*  31 */     this.occupationid = _occupationid_;
/*  32 */     this.sex = _sex_;
/*  33 */     this.onlinestatus = _onlinestatus_;
/*  34 */     this.relationvalue = _relationvalue_;
/*  35 */     this.teammemcount = _teammemcount_;
/*  36 */     this.delstatus = _delstatus_;
/*  37 */     this.avatarid = _avatarid_;
/*  38 */     this.avatarframeid = _avatarframeid_;
/*  39 */     this.remarkname = _remarkname_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  47 */     _os_.marshal(this.roleid);
/*  48 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  49 */     _os_.marshal(this.rolelevel);
/*  50 */     _os_.marshal(this.occupationid);
/*  51 */     _os_.marshal(this.sex);
/*  52 */     _os_.marshal(this.onlinestatus);
/*  53 */     _os_.marshal(this.relationvalue);
/*  54 */     _os_.marshal(this.teammemcount);
/*  55 */     _os_.marshal(this.delstatus);
/*  56 */     _os_.marshal(this.avatarid);
/*  57 */     _os_.marshal(this.avatarframeid);
/*  58 */     _os_.marshal(this.remarkname, "UTF-16LE");
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  63 */     this.roleid = _os_.unmarshal_long();
/*  64 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  65 */     this.rolelevel = _os_.unmarshal_int();
/*  66 */     this.occupationid = _os_.unmarshal_int();
/*  67 */     this.sex = _os_.unmarshal_int();
/*  68 */     this.onlinestatus = _os_.unmarshal_int();
/*  69 */     this.relationvalue = _os_.unmarshal_int();
/*  70 */     this.teammemcount = _os_.unmarshal_int();
/*  71 */     this.delstatus = _os_.unmarshal_int();
/*  72 */     this.avatarid = _os_.unmarshal_int();
/*  73 */     this.avatarframeid = _os_.unmarshal_int();
/*  74 */     this.remarkname = _os_.unmarshal_String("UTF-16LE");
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof FriendInfo)) {
/*  81 */       FriendInfo _o_ = (FriendInfo)_o1_;
/*  82 */       if (this.roleid != _o_.roleid) return false;
/*  83 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  84 */       if (this.rolelevel != _o_.rolelevel) return false;
/*  85 */       if (this.occupationid != _o_.occupationid) return false;
/*  86 */       if (this.sex != _o_.sex) return false;
/*  87 */       if (this.onlinestatus != _o_.onlinestatus) return false;
/*  88 */       if (this.relationvalue != _o_.relationvalue) return false;
/*  89 */       if (this.teammemcount != _o_.teammemcount) return false;
/*  90 */       if (this.delstatus != _o_.delstatus) return false;
/*  91 */       if (this.avatarid != _o_.avatarid) return false;
/*  92 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  93 */       if (!this.remarkname.equals(_o_.remarkname)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += (int)this.roleid;
/* 102 */     _h_ += this.rolename.hashCode();
/* 103 */     _h_ += this.rolelevel;
/* 104 */     _h_ += this.occupationid;
/* 105 */     _h_ += this.sex;
/* 106 */     _h_ += this.onlinestatus;
/* 107 */     _h_ += this.relationvalue;
/* 108 */     _h_ += this.teammemcount;
/* 109 */     _h_ += this.delstatus;
/* 110 */     _h_ += this.avatarid;
/* 111 */     _h_ += this.avatarframeid;
/* 112 */     _h_ += this.remarkname.hashCode();
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.roleid).append(",");
/* 120 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 121 */     _sb_.append(this.rolelevel).append(",");
/* 122 */     _sb_.append(this.occupationid).append(",");
/* 123 */     _sb_.append(this.sex).append(",");
/* 124 */     _sb_.append(this.onlinestatus).append(",");
/* 125 */     _sb_.append(this.relationvalue).append(",");
/* 126 */     _sb_.append(this.teammemcount).append(",");
/* 127 */     _sb_.append(this.delstatus).append(",");
/* 128 */     _sb_.append(this.avatarid).append(",");
/* 129 */     _sb_.append(this.avatarframeid).append(",");
/* 130 */     _sb_.append("T").append(this.remarkname.length()).append(",");
/* 131 */     _sb_.append(")");
/* 132 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\FriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */