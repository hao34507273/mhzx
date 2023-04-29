/*     */ package mzm.gsp.friend;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class StrangerInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int rolelevel;
/*     */   public int occupationid;
/*     */   public int sex;
/*     */   public int applytime;
/*     */   public String content;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public StrangerInfo()
/*     */   {
/*  20 */     this.rolename = "";
/*  21 */     this.content = "";
/*     */   }
/*     */   
/*     */   public StrangerInfo(long _roleid_, String _rolename_, int _rolelevel_, int _occupationid_, int _sex_, int _applytime_, String _content_, int _avatarid_, int _avatarframeid_) {
/*  25 */     this.roleid = _roleid_;
/*  26 */     this.rolename = _rolename_;
/*  27 */     this.rolelevel = _rolelevel_;
/*  28 */     this.occupationid = _occupationid_;
/*  29 */     this.sex = _sex_;
/*  30 */     this.applytime = _applytime_;
/*  31 */     this.content = _content_;
/*  32 */     this.avatarid = _avatarid_;
/*  33 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.roleid);
/*  42 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  43 */     _os_.marshal(this.rolelevel);
/*  44 */     _os_.marshal(this.occupationid);
/*  45 */     _os_.marshal(this.sex);
/*  46 */     _os_.marshal(this.applytime);
/*  47 */     _os_.marshal(this.content, "UTF-16LE");
/*  48 */     _os_.marshal(this.avatarid);
/*  49 */     _os_.marshal(this.avatarframeid);
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  54 */     this.roleid = _os_.unmarshal_long();
/*  55 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  56 */     this.rolelevel = _os_.unmarshal_int();
/*  57 */     this.occupationid = _os_.unmarshal_int();
/*  58 */     this.sex = _os_.unmarshal_int();
/*  59 */     this.applytime = _os_.unmarshal_int();
/*  60 */     this.content = _os_.unmarshal_String("UTF-16LE");
/*  61 */     this.avatarid = _os_.unmarshal_int();
/*  62 */     this.avatarframeid = _os_.unmarshal_int();
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof StrangerInfo)) {
/*  69 */       StrangerInfo _o_ = (StrangerInfo)_o1_;
/*  70 */       if (this.roleid != _o_.roleid) return false;
/*  71 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  72 */       if (this.rolelevel != _o_.rolelevel) return false;
/*  73 */       if (this.occupationid != _o_.occupationid) return false;
/*  74 */       if (this.sex != _o_.sex) return false;
/*  75 */       if (this.applytime != _o_.applytime) return false;
/*  76 */       if (!this.content.equals(_o_.content)) return false;
/*  77 */       if (this.avatarid != _o_.avatarid) return false;
/*  78 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += (int)this.roleid;
/*  87 */     _h_ += this.rolename.hashCode();
/*  88 */     _h_ += this.rolelevel;
/*  89 */     _h_ += this.occupationid;
/*  90 */     _h_ += this.sex;
/*  91 */     _h_ += this.applytime;
/*  92 */     _h_ += this.content.hashCode();
/*  93 */     _h_ += this.avatarid;
/*  94 */     _h_ += this.avatarframeid;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.roleid).append(",");
/* 102 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 103 */     _sb_.append(this.rolelevel).append(",");
/* 104 */     _sb_.append(this.occupationid).append(",");
/* 105 */     _sb_.append(this.sex).append(",");
/* 106 */     _sb_.append(this.applytime).append(",");
/* 107 */     _sb_.append("T").append(this.content.length()).append(",");
/* 108 */     _sb_.append(this.avatarid).append(",");
/* 109 */     _sb_.append(this.avatarframeid).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\StrangerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */