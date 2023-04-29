/*    */ package mzm.gsp.couple;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CommonRideRoleInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int level;
/*    */   public int menpai;
/*    */   public int gender;
/*    */   
/*    */   public CommonRideRoleInfo()
/*    */   {
/* 16 */     this.name = "";
/*    */   }
/*    */   
/*    */   public CommonRideRoleInfo(long _roleid_, String _name_, int _level_, int _menpai_, int _gender_) {
/* 20 */     this.roleid = _roleid_;
/* 21 */     this.name = _name_;
/* 22 */     this.level = _level_;
/* 23 */     this.menpai = _menpai_;
/* 24 */     this.gender = _gender_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.roleid);
/* 33 */     _os_.marshal(this.name, "UTF-16LE");
/* 34 */     _os_.marshal(this.level);
/* 35 */     _os_.marshal(this.menpai);
/* 36 */     _os_.marshal(this.gender);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.roleid = _os_.unmarshal_long();
/* 42 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 43 */     this.level = _os_.unmarshal_int();
/* 44 */     this.menpai = _os_.unmarshal_int();
/* 45 */     this.gender = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof CommonRideRoleInfo)) {
/* 52 */       CommonRideRoleInfo _o_ = (CommonRideRoleInfo)_o1_;
/* 53 */       if (this.roleid != _o_.roleid) return false;
/* 54 */       if (!this.name.equals(_o_.name)) return false;
/* 55 */       if (this.level != _o_.level) return false;
/* 56 */       if (this.menpai != _o_.menpai) return false;
/* 57 */       if (this.gender != _o_.gender) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += (int)this.roleid;
/* 66 */     _h_ += this.name.hashCode();
/* 67 */     _h_ += this.level;
/* 68 */     _h_ += this.menpai;
/* 69 */     _h_ += this.gender;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.roleid).append(",");
/* 77 */     _sb_.append("T").append(this.name.length()).append(",");
/* 78 */     _sb_.append(this.level).append(",");
/* 79 */     _sb_.append(this.menpai).append(",");
/* 80 */     _sb_.append(this.gender).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\CommonRideRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */