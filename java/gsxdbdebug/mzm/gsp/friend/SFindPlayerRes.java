/*     */ package mzm.gsp.friend;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SFindPlayerRes
/*     */   extends __SFindPlayerRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587029;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int rolelevel;
/*     */   public int occupationid;
/*     */   public int sex;
/*     */   public int onlinestatus;
/*     */   public int friendset;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12587029;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFindPlayerRes()
/*     */   {
/*  39 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public SFindPlayerRes(long _roleid_, String _rolename_, int _rolelevel_, int _occupationid_, int _sex_, int _onlinestatus_, int _friendset_, int _avatarid_, int _avatarframeid_) {
/*  43 */     this.roleid = _roleid_;
/*  44 */     this.rolename = _rolename_;
/*  45 */     this.rolelevel = _rolelevel_;
/*  46 */     this.occupationid = _occupationid_;
/*  47 */     this.sex = _sex_;
/*  48 */     this.onlinestatus = _onlinestatus_;
/*  49 */     this.friendset = _friendset_;
/*  50 */     this.avatarid = _avatarid_;
/*  51 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.roleid);
/*  60 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  61 */     _os_.marshal(this.rolelevel);
/*  62 */     _os_.marshal(this.occupationid);
/*  63 */     _os_.marshal(this.sex);
/*  64 */     _os_.marshal(this.onlinestatus);
/*  65 */     _os_.marshal(this.friendset);
/*  66 */     _os_.marshal(this.avatarid);
/*  67 */     _os_.marshal(this.avatarframeid);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.roleid = _os_.unmarshal_long();
/*  73 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  74 */     this.rolelevel = _os_.unmarshal_int();
/*  75 */     this.occupationid = _os_.unmarshal_int();
/*  76 */     this.sex = _os_.unmarshal_int();
/*  77 */     this.onlinestatus = _os_.unmarshal_int();
/*  78 */     this.friendset = _os_.unmarshal_int();
/*  79 */     this.avatarid = _os_.unmarshal_int();
/*  80 */     this.avatarframeid = _os_.unmarshal_int();
/*  81 */     if (!_validator_()) {
/*  82 */       throw new VerifyError("validator failed");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  88 */     if (_o1_ == this) return true;
/*  89 */     if ((_o1_ instanceof SFindPlayerRes)) {
/*  90 */       SFindPlayerRes _o_ = (SFindPlayerRes)_o1_;
/*  91 */       if (this.roleid != _o_.roleid) return false;
/*  92 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  93 */       if (this.rolelevel != _o_.rolelevel) return false;
/*  94 */       if (this.occupationid != _o_.occupationid) return false;
/*  95 */       if (this.sex != _o_.sex) return false;
/*  96 */       if (this.onlinestatus != _o_.onlinestatus) return false;
/*  97 */       if (this.friendset != _o_.friendset) return false;
/*  98 */       if (this.avatarid != _o_.avatarid) return false;
/*  99 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/* 100 */       return true;
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 106 */     int _h_ = 0;
/* 107 */     _h_ += (int)this.roleid;
/* 108 */     _h_ += this.rolename.hashCode();
/* 109 */     _h_ += this.rolelevel;
/* 110 */     _h_ += this.occupationid;
/* 111 */     _h_ += this.sex;
/* 112 */     _h_ += this.onlinestatus;
/* 113 */     _h_ += this.friendset;
/* 114 */     _h_ += this.avatarid;
/* 115 */     _h_ += this.avatarframeid;
/* 116 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder _sb_ = new StringBuilder();
/* 121 */     _sb_.append("(");
/* 122 */     _sb_.append(this.roleid).append(",");
/* 123 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 124 */     _sb_.append(this.rolelevel).append(",");
/* 125 */     _sb_.append(this.occupationid).append(",");
/* 126 */     _sb_.append(this.sex).append(",");
/* 127 */     _sb_.append(this.onlinestatus).append(",");
/* 128 */     _sb_.append(this.friendset).append(",");
/* 129 */     _sb_.append(this.avatarid).append(",");
/* 130 */     _sb_.append(this.avatarframeid).append(",");
/* 131 */     _sb_.append(")");
/* 132 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SFindPlayerRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */