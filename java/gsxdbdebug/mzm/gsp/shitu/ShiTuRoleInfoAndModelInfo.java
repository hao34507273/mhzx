/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class ShiTuRoleInfoAndModelInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int gender;
/*     */   public int occupationid;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   public int rolelevel;
/*     */   public ModelInfo model;
/*     */   
/*     */   public ShiTuRoleInfoAndModelInfo()
/*     */   {
/*  19 */     this.rolename = "";
/*  20 */     this.model = new ModelInfo();
/*     */   }
/*     */   
/*     */   public ShiTuRoleInfoAndModelInfo(long _roleid_, String _rolename_, int _gender_, int _occupationid_, int _avatarid_, int _avatarframeid_, int _rolelevel_, ModelInfo _model_) {
/*  24 */     this.roleid = _roleid_;
/*  25 */     this.rolename = _rolename_;
/*  26 */     this.gender = _gender_;
/*  27 */     this.occupationid = _occupationid_;
/*  28 */     this.avatarid = _avatarid_;
/*  29 */     this.avatarframeid = _avatarframeid_;
/*  30 */     this.rolelevel = _rolelevel_;
/*  31 */     this.model = _model_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     if (!this.model._validator_()) return false;
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.roleid);
/*  41 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  42 */     _os_.marshal(this.gender);
/*  43 */     _os_.marshal(this.occupationid);
/*  44 */     _os_.marshal(this.avatarid);
/*  45 */     _os_.marshal(this.avatarframeid);
/*  46 */     _os_.marshal(this.rolelevel);
/*  47 */     _os_.marshal(this.model);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  52 */     this.roleid = _os_.unmarshal_long();
/*  53 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  54 */     this.gender = _os_.unmarshal_int();
/*  55 */     this.occupationid = _os_.unmarshal_int();
/*  56 */     this.avatarid = _os_.unmarshal_int();
/*  57 */     this.avatarframeid = _os_.unmarshal_int();
/*  58 */     this.rolelevel = _os_.unmarshal_int();
/*  59 */     this.model.unmarshal(_os_);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof ShiTuRoleInfoAndModelInfo)) {
/*  66 */       ShiTuRoleInfoAndModelInfo _o_ = (ShiTuRoleInfoAndModelInfo)_o1_;
/*  67 */       if (this.roleid != _o_.roleid) return false;
/*  68 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  69 */       if (this.gender != _o_.gender) return false;
/*  70 */       if (this.occupationid != _o_.occupationid) return false;
/*  71 */       if (this.avatarid != _o_.avatarid) return false;
/*  72 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  73 */       if (this.rolelevel != _o_.rolelevel) return false;
/*  74 */       if (!this.model.equals(_o_.model)) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.roleid;
/*  83 */     _h_ += this.rolename.hashCode();
/*  84 */     _h_ += this.gender;
/*  85 */     _h_ += this.occupationid;
/*  86 */     _h_ += this.avatarid;
/*  87 */     _h_ += this.avatarframeid;
/*  88 */     _h_ += this.rolelevel;
/*  89 */     _h_ += this.model.hashCode();
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.roleid).append(",");
/*  97 */     _sb_.append("T").append(this.rolename.length()).append(",");
/*  98 */     _sb_.append(this.gender).append(",");
/*  99 */     _sb_.append(this.occupationid).append(",");
/* 100 */     _sb_.append(this.avatarid).append(",");
/* 101 */     _sb_.append(this.avatarframeid).append(",");
/* 102 */     _sb_.append(this.rolelevel).append(",");
/* 103 */     _sb_.append(this.model).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\ShiTuRoleInfoAndModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */