/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class PlayChangeFighter
/*    */   implements Marshal
/*    */ {
/*    */   public int fighterid;
/*    */   public int changefighterid;
/*    */   public Fighter fighter;
/*    */   
/*    */   public PlayChangeFighter()
/*    */   {
/* 16 */     this.fighter = new Fighter();
/*    */   }
/*    */   
/*    */   public PlayChangeFighter(int _fighterid_, int _changefighterid_, Fighter _fighter_) {
/* 20 */     this.fighterid = _fighterid_;
/* 21 */     this.changefighterid = _changefighterid_;
/* 22 */     this.fighter = _fighter_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     if (!this.fighter._validator_()) return false;
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.fighterid);
/* 32 */     _os_.marshal(this.changefighterid);
/* 33 */     _os_.marshal(this.fighter);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.fighterid = _os_.unmarshal_int();
/* 39 */     this.changefighterid = _os_.unmarshal_int();
/* 40 */     this.fighter.unmarshal(_os_);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof PlayChangeFighter)) {
/* 47 */       PlayChangeFighter _o_ = (PlayChangeFighter)_o1_;
/* 48 */       if (this.fighterid != _o_.fighterid) return false;
/* 49 */       if (this.changefighterid != _o_.changefighterid) return false;
/* 50 */       if (!this.fighter.equals(_o_.fighter)) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.fighterid;
/* 59 */     _h_ += this.changefighterid;
/* 60 */     _h_ += this.fighter.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.fighterid).append(",");
/* 68 */     _sb_.append(this.changefighterid).append(",");
/* 69 */     _sb_.append(this.fighter).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayChangeFighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */