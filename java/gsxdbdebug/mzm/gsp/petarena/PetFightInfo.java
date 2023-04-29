/*    */ package mzm.gsp.petarena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class PetFightInfo implements Marshal
/*    */ {
/*    */   public long petid;
/*    */   public int position;
/*    */   public int pet_cfgid;
/*    */   public int monster_cfgid;
/*    */   public int damage;
/*    */   public Octets name;
/*    */   
/*    */   public PetFightInfo()
/*    */   {
/* 19 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public PetFightInfo(long _petid_, int _position_, int _pet_cfgid_, int _monster_cfgid_, int _damage_, Octets _name_) {
/* 23 */     this.petid = _petid_;
/* 24 */     this.position = _position_;
/* 25 */     this.pet_cfgid = _pet_cfgid_;
/* 26 */     this.monster_cfgid = _monster_cfgid_;
/* 27 */     this.damage = _damage_;
/* 28 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.petid);
/* 37 */     _os_.marshal(this.position);
/* 38 */     _os_.marshal(this.pet_cfgid);
/* 39 */     _os_.marshal(this.monster_cfgid);
/* 40 */     _os_.marshal(this.damage);
/* 41 */     _os_.marshal(this.name);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.petid = _os_.unmarshal_long();
/* 47 */     this.position = _os_.unmarshal_int();
/* 48 */     this.pet_cfgid = _os_.unmarshal_int();
/* 49 */     this.monster_cfgid = _os_.unmarshal_int();
/* 50 */     this.damage = _os_.unmarshal_int();
/* 51 */     this.name = _os_.unmarshal_Octets();
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof PetFightInfo)) {
/* 58 */       PetFightInfo _o_ = (PetFightInfo)_o1_;
/* 59 */       if (this.petid != _o_.petid) return false;
/* 60 */       if (this.position != _o_.position) return false;
/* 61 */       if (this.pet_cfgid != _o_.pet_cfgid) return false;
/* 62 */       if (this.monster_cfgid != _o_.monster_cfgid) return false;
/* 63 */       if (this.damage != _o_.damage) return false;
/* 64 */       if (!this.name.equals(_o_.name)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.petid;
/* 73 */     _h_ += this.position;
/* 74 */     _h_ += this.pet_cfgid;
/* 75 */     _h_ += this.monster_cfgid;
/* 76 */     _h_ += this.damage;
/* 77 */     _h_ += this.name.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.petid).append(",");
/* 85 */     _sb_.append(this.position).append(",");
/* 86 */     _sb_.append(this.pet_cfgid).append(",");
/* 87 */     _sb_.append(this.monster_cfgid).append(",");
/* 88 */     _sb_.append(this.damage).append(",");
/* 89 */     _sb_.append("B").append(this.name.size()).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\PetFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */