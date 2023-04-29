/*    */ package mzm.gsp.interaction;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RoleListItem implements Marshal
/*    */ {
/*    */   public long role_id;
/*    */   public Octets role_name;
/*    */   public int role_level;
/*    */   public int occupation_id;
/*    */   public int gender;
/*    */   public int avatar_id;
/*    */   public int avatar_frame_id;
/*    */   
/*    */   public RoleListItem()
/*    */   {
/* 20 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public RoleListItem(long _role_id_, Octets _role_name_, int _role_level_, int _occupation_id_, int _gender_, int _avatar_id_, int _avatar_frame_id_) {
/* 24 */     this.role_id = _role_id_;
/* 25 */     this.role_name = _role_name_;
/* 26 */     this.role_level = _role_level_;
/* 27 */     this.occupation_id = _occupation_id_;
/* 28 */     this.gender = _gender_;
/* 29 */     this.avatar_id = _avatar_id_;
/* 30 */     this.avatar_frame_id = _avatar_frame_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.role_id);
/* 39 */     _os_.marshal(this.role_name);
/* 40 */     _os_.marshal(this.role_level);
/* 41 */     _os_.marshal(this.occupation_id);
/* 42 */     _os_.marshal(this.gender);
/* 43 */     _os_.marshal(this.avatar_id);
/* 44 */     _os_.marshal(this.avatar_frame_id);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.role_id = _os_.unmarshal_long();
/* 50 */     this.role_name = _os_.unmarshal_Octets();
/* 51 */     this.role_level = _os_.unmarshal_int();
/* 52 */     this.occupation_id = _os_.unmarshal_int();
/* 53 */     this.gender = _os_.unmarshal_int();
/* 54 */     this.avatar_id = _os_.unmarshal_int();
/* 55 */     this.avatar_frame_id = _os_.unmarshal_int();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof RoleListItem)) {
/* 62 */       RoleListItem _o_ = (RoleListItem)_o1_;
/* 63 */       if (this.role_id != _o_.role_id) return false;
/* 64 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 65 */       if (this.role_level != _o_.role_level) return false;
/* 66 */       if (this.occupation_id != _o_.occupation_id) return false;
/* 67 */       if (this.gender != _o_.gender) return false;
/* 68 */       if (this.avatar_id != _o_.avatar_id) return false;
/* 69 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.role_id;
/* 78 */     _h_ += this.role_name.hashCode();
/* 79 */     _h_ += this.role_level;
/* 80 */     _h_ += this.occupation_id;
/* 81 */     _h_ += this.gender;
/* 82 */     _h_ += this.avatar_id;
/* 83 */     _h_ += this.avatar_frame_id;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.role_id).append(",");
/* 91 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 92 */     _sb_.append(this.role_level).append(",");
/* 93 */     _sb_.append(this.occupation_id).append(",");
/* 94 */     _sb_.append(this.gender).append(",");
/* 95 */     _sb_.append(this.avatar_id).append(",");
/* 96 */     _sb_.append(this.avatar_frame_id).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\RoleListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */