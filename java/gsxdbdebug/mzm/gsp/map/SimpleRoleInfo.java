/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SimpleRoleInfo implements Marshal
/*    */ {
/*    */   public static final int MAIL = 1;
/*    */   public static final int FEMAIL = 2;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int occupationid;
/*    */   public int level;
/*    */   public int gender;
/*    */   public int avatarid;
/*    */   public int avatarframeid;
/*    */   
/*    */   public SimpleRoleInfo()
/*    */   {
/* 21 */     this.name = "";
/*    */   }
/*    */   
/*    */   public SimpleRoleInfo(long _roleid_, String _name_, int _occupationid_, int _level_, int _gender_, int _avatarid_, int _avatarframeid_) {
/* 25 */     this.roleid = _roleid_;
/* 26 */     this.name = _name_;
/* 27 */     this.occupationid = _occupationid_;
/* 28 */     this.level = _level_;
/* 29 */     this.gender = _gender_;
/* 30 */     this.avatarid = _avatarid_;
/* 31 */     this.avatarframeid = _avatarframeid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.roleid);
/* 40 */     _os_.marshal(this.name, "UTF-16LE");
/* 41 */     _os_.marshal(this.occupationid);
/* 42 */     _os_.marshal(this.level);
/* 43 */     _os_.marshal(this.gender);
/* 44 */     _os_.marshal(this.avatarid);
/* 45 */     _os_.marshal(this.avatarframeid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.roleid = _os_.unmarshal_long();
/* 51 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 52 */     this.occupationid = _os_.unmarshal_int();
/* 53 */     this.level = _os_.unmarshal_int();
/* 54 */     this.gender = _os_.unmarshal_int();
/* 55 */     this.avatarid = _os_.unmarshal_int();
/* 56 */     this.avatarframeid = _os_.unmarshal_int();
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SimpleRoleInfo)) {
/* 63 */       SimpleRoleInfo _o_ = (SimpleRoleInfo)_o1_;
/* 64 */       if (this.roleid != _o_.roleid) return false;
/* 65 */       if (!this.name.equals(_o_.name)) return false;
/* 66 */       if (this.occupationid != _o_.occupationid) return false;
/* 67 */       if (this.level != _o_.level) return false;
/* 68 */       if (this.gender != _o_.gender) return false;
/* 69 */       if (this.avatarid != _o_.avatarid) return false;
/* 70 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.roleid;
/* 79 */     _h_ += this.name.hashCode();
/* 80 */     _h_ += this.occupationid;
/* 81 */     _h_ += this.level;
/* 82 */     _h_ += this.gender;
/* 83 */     _h_ += this.avatarid;
/* 84 */     _h_ += this.avatarframeid;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.roleid).append(",");
/* 92 */     _sb_.append("T").append(this.name.length()).append(",");
/* 93 */     _sb_.append(this.occupationid).append(",");
/* 94 */     _sb_.append(this.level).append(",");
/* 95 */     _sb_.append(this.gender).append(",");
/* 96 */     _sb_.append(this.avatarid).append(",");
/* 97 */     _sb_.append(this.avatarframeid).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SimpleRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */