/*    */ package mzm.gsp.gangrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class PlayerInfo implements Marshal
/*    */ {
/*    */   public int playeridx;
/*    */   public int gender;
/*    */   public int menpai;
/*    */   public int avatarid;
/*    */   public int avatarframeid;
/*    */   public String name;
/*    */   
/*    */   public PlayerInfo()
/*    */   {
/* 17 */     this.name = "";
/*    */   }
/*    */   
/*    */   public PlayerInfo(int _playeridx_, int _gender_, int _menpai_, int _avatarid_, int _avatarframeid_, String _name_) {
/* 21 */     this.playeridx = _playeridx_;
/* 22 */     this.gender = _gender_;
/* 23 */     this.menpai = _menpai_;
/* 24 */     this.avatarid = _avatarid_;
/* 25 */     this.avatarframeid = _avatarframeid_;
/* 26 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.playeridx);
/* 35 */     _os_.marshal(this.gender);
/* 36 */     _os_.marshal(this.menpai);
/* 37 */     _os_.marshal(this.avatarid);
/* 38 */     _os_.marshal(this.avatarframeid);
/* 39 */     _os_.marshal(this.name, "UTF-16LE");
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.playeridx = _os_.unmarshal_int();
/* 45 */     this.gender = _os_.unmarshal_int();
/* 46 */     this.menpai = _os_.unmarshal_int();
/* 47 */     this.avatarid = _os_.unmarshal_int();
/* 48 */     this.avatarframeid = _os_.unmarshal_int();
/* 49 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof PlayerInfo)) {
/* 56 */       PlayerInfo _o_ = (PlayerInfo)_o1_;
/* 57 */       if (this.playeridx != _o_.playeridx) return false;
/* 58 */       if (this.gender != _o_.gender) return false;
/* 59 */       if (this.menpai != _o_.menpai) return false;
/* 60 */       if (this.avatarid != _o_.avatarid) return false;
/* 61 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/* 62 */       if (!this.name.equals(_o_.name)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.playeridx;
/* 71 */     _h_ += this.gender;
/* 72 */     _h_ += this.menpai;
/* 73 */     _h_ += this.avatarid;
/* 74 */     _h_ += this.avatarframeid;
/* 75 */     _h_ += this.name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.playeridx).append(",");
/* 83 */     _sb_.append(this.gender).append(",");
/* 84 */     _sb_.append(this.menpai).append(",");
/* 85 */     _sb_.append(this.avatarid).append(",");
/* 86 */     _sb_.append(this.avatarframeid).append(",");
/* 87 */     _sb_.append("T").append(this.name.length()).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\PlayerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */