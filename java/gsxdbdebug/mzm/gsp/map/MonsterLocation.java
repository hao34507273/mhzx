/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MonsterLocation implements Marshal, Comparable<MonsterLocation>
/*    */ {
/*    */   public int monstercfgid;
/*    */   public int monsterinstanceid;
/*    */   public int mapid;
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   public MonsterLocation() {}
/*    */   
/*    */   public MonsterLocation(int _monstercfgid_, int _monsterinstanceid_, int _mapid_, int _x_, int _y_)
/*    */   {
/* 19 */     this.monstercfgid = _monstercfgid_;
/* 20 */     this.monsterinstanceid = _monsterinstanceid_;
/* 21 */     this.mapid = _mapid_;
/* 22 */     this.x = _x_;
/* 23 */     this.y = _y_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.monstercfgid);
/* 32 */     _os_.marshal(this.monsterinstanceid);
/* 33 */     _os_.marshal(this.mapid);
/* 34 */     _os_.marshal(this.x);
/* 35 */     _os_.marshal(this.y);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.monstercfgid = _os_.unmarshal_int();
/* 41 */     this.monsterinstanceid = _os_.unmarshal_int();
/* 42 */     this.mapid = _os_.unmarshal_int();
/* 43 */     this.x = _os_.unmarshal_int();
/* 44 */     this.y = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof MonsterLocation)) {
/* 51 */       MonsterLocation _o_ = (MonsterLocation)_o1_;
/* 52 */       if (this.monstercfgid != _o_.monstercfgid) return false;
/* 53 */       if (this.monsterinstanceid != _o_.monsterinstanceid) return false;
/* 54 */       if (this.mapid != _o_.mapid) return false;
/* 55 */       if (this.x != _o_.x) return false;
/* 56 */       if (this.y != _o_.y) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.monstercfgid;
/* 65 */     _h_ += this.monsterinstanceid;
/* 66 */     _h_ += this.mapid;
/* 67 */     _h_ += this.x;
/* 68 */     _h_ += this.y;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.monstercfgid).append(",");
/* 76 */     _sb_.append(this.monsterinstanceid).append(",");
/* 77 */     _sb_.append(this.mapid).append(",");
/* 78 */     _sb_.append(this.x).append(",");
/* 79 */     _sb_.append(this.y).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MonsterLocation _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.monstercfgid - _o_.monstercfgid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.monsterinstanceid - _o_.monsterinstanceid;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.mapid - _o_.mapid;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.x - _o_.x;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.y - _o_.y;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\MonsterLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */