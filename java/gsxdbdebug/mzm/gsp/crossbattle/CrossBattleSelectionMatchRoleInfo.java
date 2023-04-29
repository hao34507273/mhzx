/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CrossBattleSelectionMatchRoleInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public int process;
/*    */   public int gender;
/*    */   public int occupation;
/*    */   public Octets role_name;
/*    */   public int avatar_id;
/*    */   public int role_level;
/*    */   
/*    */   public CrossBattleSelectionMatchRoleInfo()
/*    */   {
/* 18 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public CrossBattleSelectionMatchRoleInfo(long _roleid_, int _process_, int _gender_, int _occupation_, Octets _role_name_, int _avatar_id_, int _role_level_) {
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.process = _process_;
/* 24 */     this.gender = _gender_;
/* 25 */     this.occupation = _occupation_;
/* 26 */     this.role_name = _role_name_;
/* 27 */     this.avatar_id = _avatar_id_;
/* 28 */     this.role_level = _role_level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.roleid);
/* 37 */     _os_.marshal(this.process);
/* 38 */     _os_.marshal(this.gender);
/* 39 */     _os_.marshal(this.occupation);
/* 40 */     _os_.marshal(this.role_name);
/* 41 */     _os_.marshal(this.avatar_id);
/* 42 */     _os_.marshal(this.role_level);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.roleid = _os_.unmarshal_long();
/* 48 */     this.process = _os_.unmarshal_int();
/* 49 */     this.gender = _os_.unmarshal_int();
/* 50 */     this.occupation = _os_.unmarshal_int();
/* 51 */     this.role_name = _os_.unmarshal_Octets();
/* 52 */     this.avatar_id = _os_.unmarshal_int();
/* 53 */     this.role_level = _os_.unmarshal_int();
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CrossBattleSelectionMatchRoleInfo)) {
/* 60 */       CrossBattleSelectionMatchRoleInfo _o_ = (CrossBattleSelectionMatchRoleInfo)_o1_;
/* 61 */       if (this.roleid != _o_.roleid) return false;
/* 62 */       if (this.process != _o_.process) return false;
/* 63 */       if (this.gender != _o_.gender) return false;
/* 64 */       if (this.occupation != _o_.occupation) return false;
/* 65 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 66 */       if (this.avatar_id != _o_.avatar_id) return false;
/* 67 */       if (this.role_level != _o_.role_level) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     _h_ += this.process;
/* 77 */     _h_ += this.gender;
/* 78 */     _h_ += this.occupation;
/* 79 */     _h_ += this.role_name.hashCode();
/* 80 */     _h_ += this.avatar_id;
/* 81 */     _h_ += this.role_level;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.roleid).append(",");
/* 89 */     _sb_.append(this.process).append(",");
/* 90 */     _sb_.append(this.gender).append(",");
/* 91 */     _sb_.append(this.occupation).append(",");
/* 92 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 93 */     _sb_.append(this.avatar_id).append(",");
/* 94 */     _sb_.append(this.role_level).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleSelectionMatchRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */