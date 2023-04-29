/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleTotalInfo implements Marshal
/*    */ {
/*    */   public RoleBaseInfo baseinfo;
/*    */   public FightRecord fightrecord;
/*    */   
/*    */   public RoleTotalInfo()
/*    */   {
/* 13 */     this.baseinfo = new RoleBaseInfo();
/* 14 */     this.fightrecord = new FightRecord();
/*    */   }
/*    */   
/*    */   public RoleTotalInfo(RoleBaseInfo _baseinfo_, FightRecord _fightrecord_) {
/* 18 */     this.baseinfo = _baseinfo_;
/* 19 */     this.fightrecord = _fightrecord_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     if (!this.baseinfo._validator_()) return false;
/* 24 */     if (!this.fightrecord._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.baseinfo);
/* 30 */     _os_.marshal(this.fightrecord);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.baseinfo.unmarshal(_os_);
/* 36 */     this.fightrecord.unmarshal(_os_);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof RoleTotalInfo)) {
/* 43 */       RoleTotalInfo _o_ = (RoleTotalInfo)_o1_;
/* 44 */       if (!this.baseinfo.equals(_o_.baseinfo)) return false;
/* 45 */       if (!this.fightrecord.equals(_o_.fightrecord)) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.baseinfo.hashCode();
/* 54 */     _h_ += this.fightrecord.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.baseinfo).append(",");
/* 62 */     _sb_.append(this.fightrecord).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\RoleTotalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */