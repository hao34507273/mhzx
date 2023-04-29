/*    */ package mzm.gsp.lonngboatrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class TeamStat implements Marshal
/*    */ {
/*    */   public float location;
/*    */   public float speed;
/*    */   
/*    */   public TeamStat() {}
/*    */   
/*    */   public TeamStat(float _location_, float _speed_)
/*    */   {
/* 16 */     this.location = _location_;
/* 17 */     this.speed = _speed_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.location);
/* 26 */     _os_.marshal(this.speed);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.location = _os_.unmarshal_float();
/* 32 */     this.speed = _os_.unmarshal_float();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof TeamStat)) {
/* 39 */       TeamStat _o_ = (TeamStat)_o1_;
/* 40 */       if (this.location != _o_.location) return false;
/* 41 */       if (this.speed != _o_.speed) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += Float.floatToIntBits(this.location);
/* 50 */     _h_ += Float.floatToIntBits(this.speed);
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.location).append(",");
/* 58 */     _sb_.append(this.speed).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\TeamStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */