/*    */ package mzm.gsp.qingyuan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class QingYuanRoleInfo implements Marshal
/*    */ {
/*    */   public long role_id;
/*    */   public String role_name;
/*    */   public int gender;
/*    */   public int occupation_id;
/*    */   public long offline_time;
/*    */   public int role_level;
/*    */   
/*    */   public QingYuanRoleInfo()
/*    */   {
/* 17 */     this.role_name = "";
/*    */   }
/*    */   
/*    */   public QingYuanRoleInfo(long _role_id_, String _role_name_, int _gender_, int _occupation_id_, long _offline_time_, int _role_level_) {
/* 21 */     this.role_id = _role_id_;
/* 22 */     this.role_name = _role_name_;
/* 23 */     this.gender = _gender_;
/* 24 */     this.occupation_id = _occupation_id_;
/* 25 */     this.offline_time = _offline_time_;
/* 26 */     this.role_level = _role_level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.role_id);
/* 35 */     _os_.marshal(this.role_name, "UTF-16LE");
/* 36 */     _os_.marshal(this.gender);
/* 37 */     _os_.marshal(this.occupation_id);
/* 38 */     _os_.marshal(this.offline_time);
/* 39 */     _os_.marshal(this.role_level);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.role_id = _os_.unmarshal_long();
/* 45 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/* 46 */     this.gender = _os_.unmarshal_int();
/* 47 */     this.occupation_id = _os_.unmarshal_int();
/* 48 */     this.offline_time = _os_.unmarshal_long();
/* 49 */     this.role_level = _os_.unmarshal_int();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof QingYuanRoleInfo)) {
/* 56 */       QingYuanRoleInfo _o_ = (QingYuanRoleInfo)_o1_;
/* 57 */       if (this.role_id != _o_.role_id) return false;
/* 58 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 59 */       if (this.gender != _o_.gender) return false;
/* 60 */       if (this.occupation_id != _o_.occupation_id) return false;
/* 61 */       if (this.offline_time != _o_.offline_time) return false;
/* 62 */       if (this.role_level != _o_.role_level) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += (int)this.role_id;
/* 71 */     _h_ += this.role_name.hashCode();
/* 72 */     _h_ += this.gender;
/* 73 */     _h_ += this.occupation_id;
/* 74 */     _h_ += (int)this.offline_time;
/* 75 */     _h_ += this.role_level;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.role_id).append(",");
/* 83 */     _sb_.append("T").append(this.role_name.length()).append(",");
/* 84 */     _sb_.append(this.gender).append(",");
/* 85 */     _sb_.append(this.occupation_id).append(",");
/* 86 */     _sb_.append(this.offline_time).append(",");
/* 87 */     _sb_.append(this.role_level).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\QingYuanRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */