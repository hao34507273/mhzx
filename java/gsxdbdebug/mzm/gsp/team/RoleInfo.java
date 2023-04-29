/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleInfo
/*    */   implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int level;
/*    */   public int menpai;
/*    */   public int gender;
/*    */   public int avatarid;
/*    */   public int avatarframeid;
/*    */   
/*    */   public RoleInfo()
/*    */   {
/* 20 */     this.name = "";
/*    */   }
/*    */   
/*    */   public RoleInfo(long _roleid_, String _name_, int _level_, int _menpai_, int _gender_, int _avatarid_, int _avatarframeid_) {
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.name = _name_;
/* 26 */     this.level = _level_;
/* 27 */     this.menpai = _menpai_;
/* 28 */     this.gender = _gender_;
/* 29 */     this.avatarid = _avatarid_;
/* 30 */     this.avatarframeid = _avatarframeid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.roleid);
/* 39 */     _os_.marshal(this.name, "UTF-16LE");
/* 40 */     _os_.marshal(this.level);
/* 41 */     _os_.marshal(this.menpai);
/* 42 */     _os_.marshal(this.gender);
/* 43 */     _os_.marshal(this.avatarid);
/* 44 */     _os_.marshal(this.avatarframeid);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.roleid = _os_.unmarshal_long();
/* 50 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 51 */     this.level = _os_.unmarshal_int();
/* 52 */     this.menpai = _os_.unmarshal_int();
/* 53 */     this.gender = _os_.unmarshal_int();
/* 54 */     this.avatarid = _os_.unmarshal_int();
/* 55 */     this.avatarframeid = _os_.unmarshal_int();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof RoleInfo)) {
/* 62 */       RoleInfo _o_ = (RoleInfo)_o1_;
/* 63 */       if (this.roleid != _o_.roleid) return false;
/* 64 */       if (!this.name.equals(_o_.name)) return false;
/* 65 */       if (this.level != _o_.level) return false;
/* 66 */       if (this.menpai != _o_.menpai) return false;
/* 67 */       if (this.gender != _o_.gender) return false;
/* 68 */       if (this.avatarid != _o_.avatarid) return false;
/* 69 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.roleid;
/* 78 */     _h_ += this.name.hashCode();
/* 79 */     _h_ += this.level;
/* 80 */     _h_ += this.menpai;
/* 81 */     _h_ += this.gender;
/* 82 */     _h_ += this.avatarid;
/* 83 */     _h_ += this.avatarframeid;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.roleid).append(",");
/* 91 */     _sb_.append("T").append(this.name.length()).append(",");
/* 92 */     _sb_.append(this.level).append(",");
/* 93 */     _sb_.append(this.menpai).append(",");
/* 94 */     _sb_.append(this.gender).append(",");
/* 95 */     _sb_.append(this.avatarid).append(",");
/* 96 */     _sb_.append(this.avatarframeid).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */