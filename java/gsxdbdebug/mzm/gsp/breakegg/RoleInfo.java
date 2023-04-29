/*    */ package mzm.gsp.breakegg;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int gender;
/*    */   public int occupationid;
/*    */   public int avatarid;
/*    */   public int avatarframeid;
/*    */   public int rolelevel;
/*    */   
/*    */   public RoleInfo()
/*    */   {
/* 18 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public RoleInfo(long _roleid_, String _rolename_, int _gender_, int _occupationid_, int _avatarid_, int _avatarframeid_, int _rolelevel_) {
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.rolename = _rolename_;
/* 24 */     this.gender = _gender_;
/* 25 */     this.occupationid = _occupationid_;
/* 26 */     this.avatarid = _avatarid_;
/* 27 */     this.avatarframeid = _avatarframeid_;
/* 28 */     this.rolelevel = _rolelevel_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.roleid);
/* 37 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 38 */     _os_.marshal(this.gender);
/* 39 */     _os_.marshal(this.occupationid);
/* 40 */     _os_.marshal(this.avatarid);
/* 41 */     _os_.marshal(this.avatarframeid);
/* 42 */     _os_.marshal(this.rolelevel);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.roleid = _os_.unmarshal_long();
/* 48 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 49 */     this.gender = _os_.unmarshal_int();
/* 50 */     this.occupationid = _os_.unmarshal_int();
/* 51 */     this.avatarid = _os_.unmarshal_int();
/* 52 */     this.avatarframeid = _os_.unmarshal_int();
/* 53 */     this.rolelevel = _os_.unmarshal_int();
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof RoleInfo)) {
/* 60 */       RoleInfo _o_ = (RoleInfo)_o1_;
/* 61 */       if (this.roleid != _o_.roleid) return false;
/* 62 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 63 */       if (this.gender != _o_.gender) return false;
/* 64 */       if (this.occupationid != _o_.occupationid) return false;
/* 65 */       if (this.avatarid != _o_.avatarid) return false;
/* 66 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/* 67 */       if (this.rolelevel != _o_.rolelevel) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     _h_ += this.rolename.hashCode();
/* 77 */     _h_ += this.gender;
/* 78 */     _h_ += this.occupationid;
/* 79 */     _h_ += this.avatarid;
/* 80 */     _h_ += this.avatarframeid;
/* 81 */     _h_ += this.rolelevel;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.roleid).append(",");
/* 89 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 90 */     _sb_.append(this.gender).append(",");
/* 91 */     _sb_.append(this.occupationid).append(",");
/* 92 */     _sb_.append(this.avatarid).append(",");
/* 93 */     _sb_.append(this.avatarframeid).append(",");
/* 94 */     _sb_.append(this.rolelevel).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */