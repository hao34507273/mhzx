/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class memberinfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public int level;
/*    */   public int gender;
/*    */   public int menpai;
/*    */   public String name;
/*    */   public String title;
/*    */   
/*    */   public memberinfo()
/*    */   {
/* 17 */     this.name = "";
/* 18 */     this.title = "";
/*    */   }
/*    */   
/*    */   public memberinfo(long _roleid_, int _level_, int _gender_, int _menpai_, String _name_, String _title_) {
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.level = _level_;
/* 24 */     this.gender = _gender_;
/* 25 */     this.menpai = _menpai_;
/* 26 */     this.name = _name_;
/* 27 */     this.title = _title_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     _os_.marshal(this.level);
/* 37 */     _os_.marshal(this.gender);
/* 38 */     _os_.marshal(this.menpai);
/* 39 */     _os_.marshal(this.name, "UTF-16LE");
/* 40 */     _os_.marshal(this.title, "UTF-16LE");
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 45 */     this.roleid = _os_.unmarshal_long();
/* 46 */     this.level = _os_.unmarshal_int();
/* 47 */     this.gender = _os_.unmarshal_int();
/* 48 */     this.menpai = _os_.unmarshal_int();
/* 49 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 50 */     this.title = _os_.unmarshal_String("UTF-16LE");
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof memberinfo)) {
/* 57 */       memberinfo _o_ = (memberinfo)_o1_;
/* 58 */       if (this.roleid != _o_.roleid) return false;
/* 59 */       if (this.level != _o_.level) return false;
/* 60 */       if (this.gender != _o_.gender) return false;
/* 61 */       if (this.menpai != _o_.menpai) return false;
/* 62 */       if (!this.name.equals(_o_.name)) return false;
/* 63 */       if (!this.title.equals(_o_.title)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.roleid;
/* 72 */     _h_ += this.level;
/* 73 */     _h_ += this.gender;
/* 74 */     _h_ += this.menpai;
/* 75 */     _h_ += this.name.hashCode();
/* 76 */     _h_ += this.title.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append(this.level).append(",");
/* 85 */     _sb_.append(this.gender).append(",");
/* 86 */     _sb_.append(this.menpai).append(",");
/* 87 */     _sb_.append("T").append(this.name.length()).append(",");
/* 88 */     _sb_.append("T").append(this.title.length()).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\memberinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */