/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ public class SChangeGangTeamNameBrd
/*    */   extends __SChangeGangTeamNameBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590003;
/*    */   public long teamid;
/*    */   public String name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590003;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeGangTeamNameBrd()
/*    */   {
/* 34 */     this.name = "";
/*    */   }
/*    */   
/*    */   public SChangeGangTeamNameBrd(long _teamid_, String _name_) {
/* 38 */     this.teamid = _teamid_;
/* 39 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.teamid);
/* 48 */     _os_.marshal(this.name, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.teamid = _os_.unmarshal_long();
/* 54 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SChangeGangTeamNameBrd)) {
/* 64 */       SChangeGangTeamNameBrd _o_ = (SChangeGangTeamNameBrd)_o1_;
/* 65 */       if (this.teamid != _o_.teamid) return false;
/* 66 */       if (!this.name.equals(_o_.name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.teamid;
/* 75 */     _h_ += this.name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.teamid).append(",");
/* 83 */     _sb_.append("T").append(this.name.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SChangeGangTeamNameBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */