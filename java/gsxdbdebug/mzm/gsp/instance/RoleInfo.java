/*    */ package mzm.gsp.instance;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int occupation;
/*    */   public int gender;
/*    */   public int avatarid;
/*    */   public int avatar_frame_id;
/*    */   
/*    */   public RoleInfo()
/*    */   {
/* 17 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public RoleInfo(long _roleid_, String _rolename_, int _occupation_, int _gender_, int _avatarid_, int _avatar_frame_id_) {
/* 21 */     this.roleid = _roleid_;
/* 22 */     this.rolename = _rolename_;
/* 23 */     this.occupation = _occupation_;
/* 24 */     this.gender = _gender_;
/* 25 */     this.avatarid = _avatarid_;
/* 26 */     this.avatar_frame_id = _avatar_frame_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.roleid);
/* 35 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 36 */     _os_.marshal(this.occupation);
/* 37 */     _os_.marshal(this.gender);
/* 38 */     _os_.marshal(this.avatarid);
/* 39 */     _os_.marshal(this.avatar_frame_id);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.roleid = _os_.unmarshal_long();
/* 45 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 46 */     this.occupation = _os_.unmarshal_int();
/* 47 */     this.gender = _os_.unmarshal_int();
/* 48 */     this.avatarid = _os_.unmarshal_int();
/* 49 */     this.avatar_frame_id = _os_.unmarshal_int();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof RoleInfo)) {
/* 56 */       RoleInfo _o_ = (RoleInfo)_o1_;
/* 57 */       if (this.roleid != _o_.roleid) return false;
/* 58 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 59 */       if (this.occupation != _o_.occupation) return false;
/* 60 */       if (this.gender != _o_.gender) return false;
/* 61 */       if (this.avatarid != _o_.avatarid) return false;
/* 62 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += (int)this.roleid;
/* 71 */     _h_ += this.rolename.hashCode();
/* 72 */     _h_ += this.occupation;
/* 73 */     _h_ += this.gender;
/* 74 */     _h_ += this.avatarid;
/* 75 */     _h_ += this.avatar_frame_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.roleid).append(",");
/* 83 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 84 */     _sb_.append(this.occupation).append(",");
/* 85 */     _sb_.append(this.gender).append(",");
/* 86 */     _sb_.append(this.avatarid).append(",");
/* 87 */     _sb_.append(this.avatar_frame_id).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */