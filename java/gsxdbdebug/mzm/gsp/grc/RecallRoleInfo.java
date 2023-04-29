/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RecallRoleInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public Octets rolename;
/*    */   public int level;
/*    */   public int gender;
/*    */   public int occupation;
/*    */   public int zoneid;
/*    */   public int fight;
/*    */   
/*    */   public RecallRoleInfo()
/*    */   {
/* 20 */     this.rolename = new Octets();
/*    */   }
/*    */   
/*    */   public RecallRoleInfo(long _roleid_, Octets _rolename_, int _level_, int _gender_, int _occupation_, int _zoneid_, int _fight_) {
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.rolename = _rolename_;
/* 26 */     this.level = _level_;
/* 27 */     this.gender = _gender_;
/* 28 */     this.occupation = _occupation_;
/* 29 */     this.zoneid = _zoneid_;
/* 30 */     this.fight = _fight_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.roleid);
/* 39 */     _os_.marshal(this.rolename);
/* 40 */     _os_.marshal(this.level);
/* 41 */     _os_.marshal(this.gender);
/* 42 */     _os_.marshal(this.occupation);
/* 43 */     _os_.marshal(this.zoneid);
/* 44 */     _os_.marshal(this.fight);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.roleid = _os_.unmarshal_long();
/* 50 */     this.rolename = _os_.unmarshal_Octets();
/* 51 */     this.level = _os_.unmarshal_int();
/* 52 */     this.gender = _os_.unmarshal_int();
/* 53 */     this.occupation = _os_.unmarshal_int();
/* 54 */     this.zoneid = _os_.unmarshal_int();
/* 55 */     this.fight = _os_.unmarshal_int();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof RecallRoleInfo)) {
/* 62 */       RecallRoleInfo _o_ = (RecallRoleInfo)_o1_;
/* 63 */       if (this.roleid != _o_.roleid) return false;
/* 64 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 65 */       if (this.level != _o_.level) return false;
/* 66 */       if (this.gender != _o_.gender) return false;
/* 67 */       if (this.occupation != _o_.occupation) return false;
/* 68 */       if (this.zoneid != _o_.zoneid) return false;
/* 69 */       if (this.fight != _o_.fight) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.roleid;
/* 78 */     _h_ += this.rolename.hashCode();
/* 79 */     _h_ += this.level;
/* 80 */     _h_ += this.gender;
/* 81 */     _h_ += this.occupation;
/* 82 */     _h_ += this.zoneid;
/* 83 */     _h_ += this.fight;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.roleid).append(",");
/* 91 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 92 */     _sb_.append(this.level).append(",");
/* 93 */     _sb_.append(this.gender).append(",");
/* 94 */     _sb_.append(this.occupation).append(",");
/* 95 */     _sb_.append(this.zoneid).append(",");
/* 96 */     _sb_.append(this.fight).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\RecallRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */