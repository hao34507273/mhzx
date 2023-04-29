/*    */ package mzm.gsp.floor;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFastKillBro
/*    */   extends __SFastKillBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617749;
/*    */   public int activityid;
/*    */   public int floor;
/*    */   public FloorFightRes fightinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617749;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFastKillBro()
/*    */   {
/* 35 */     this.fightinfo = new FloorFightRes();
/*    */   }
/*    */   
/*    */   public SFastKillBro(int _activityid_, int _floor_, FloorFightRes _fightinfo_) {
/* 39 */     this.activityid = _activityid_;
/* 40 */     this.floor = _floor_;
/* 41 */     this.fightinfo = _fightinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.fightinfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activityid);
/* 51 */     _os_.marshal(this.floor);
/* 52 */     _os_.marshal(this.fightinfo);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activityid = _os_.unmarshal_int();
/* 58 */     this.floor = _os_.unmarshal_int();
/* 59 */     this.fightinfo.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SFastKillBro)) {
/* 69 */       SFastKillBro _o_ = (SFastKillBro)_o1_;
/* 70 */       if (this.activityid != _o_.activityid) return false;
/* 71 */       if (this.floor != _o_.floor) return false;
/* 72 */       if (!this.fightinfo.equals(_o_.fightinfo)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.activityid;
/* 81 */     _h_ += this.floor;
/* 82 */     _h_ += this.fightinfo.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.activityid).append(",");
/* 90 */     _sb_.append(this.floor).append(",");
/* 91 */     _sb_.append(this.fightinfo).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\SFastKillBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */