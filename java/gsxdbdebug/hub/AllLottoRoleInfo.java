/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class AllLottoRoleInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public Octets role_name;
/*    */   public int occupation;
/*    */   public int gender;
/*    */   public int level;
/*    */   public int avatarid;
/*    */   public int avatar_frameid;
/*    */   
/*    */   public AllLottoRoleInfo()
/*    */   {
/* 20 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public AllLottoRoleInfo(long _roleid_, Octets _role_name_, int _occupation_, int _gender_, int _level_, int _avatarid_, int _avatar_frameid_) {
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.role_name = _role_name_;
/* 26 */     this.occupation = _occupation_;
/* 27 */     this.gender = _gender_;
/* 28 */     this.level = _level_;
/* 29 */     this.avatarid = _avatarid_;
/* 30 */     this.avatar_frameid = _avatar_frameid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.roleid);
/* 39 */     _os_.marshal(this.role_name);
/* 40 */     _os_.marshal(this.occupation);
/* 41 */     _os_.marshal(this.gender);
/* 42 */     _os_.marshal(this.level);
/* 43 */     _os_.marshal(this.avatarid);
/* 44 */     _os_.marshal(this.avatar_frameid);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.roleid = _os_.unmarshal_long();
/* 50 */     this.role_name = _os_.unmarshal_Octets();
/* 51 */     this.occupation = _os_.unmarshal_int();
/* 52 */     this.gender = _os_.unmarshal_int();
/* 53 */     this.level = _os_.unmarshal_int();
/* 54 */     this.avatarid = _os_.unmarshal_int();
/* 55 */     this.avatar_frameid = _os_.unmarshal_int();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof AllLottoRoleInfo)) {
/* 62 */       AllLottoRoleInfo _o_ = (AllLottoRoleInfo)_o1_;
/* 63 */       if (this.roleid != _o_.roleid) return false;
/* 64 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 65 */       if (this.occupation != _o_.occupation) return false;
/* 66 */       if (this.gender != _o_.gender) return false;
/* 67 */       if (this.level != _o_.level) return false;
/* 68 */       if (this.avatarid != _o_.avatarid) return false;
/* 69 */       if (this.avatar_frameid != _o_.avatar_frameid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.roleid;
/* 78 */     _h_ += this.role_name.hashCode();
/* 79 */     _h_ += this.occupation;
/* 80 */     _h_ += this.gender;
/* 81 */     _h_ += this.level;
/* 82 */     _h_ += this.avatarid;
/* 83 */     _h_ += this.avatar_frameid;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.roleid).append(",");
/* 91 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 92 */     _sb_.append(this.occupation).append(",");
/* 93 */     _sb_.append(this.gender).append(",");
/* 94 */     _sb_.append(this.level).append(",");
/* 95 */     _sb_.append(this.avatarid).append(",");
/* 96 */     _sb_.append(this.avatar_frameid).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\AllLottoRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */