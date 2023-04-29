/*    */ package mzm.gsp.competition;
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
/*    */ 
/*    */ public class SCompetitionStartBrd
/*    */   extends __SCompetitionStartBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598529;
/*    */   public String opponent;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598529;
/*    */   }
/*    */   
/*    */ 
/*    */   public SCompetitionStartBrd()
/*    */   {
/* 33 */     this.opponent = "";
/*    */   }
/*    */   
/*    */   public SCompetitionStartBrd(String _opponent_) {
/* 37 */     this.opponent = _opponent_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.opponent, "UTF-16LE");
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.opponent = _os_.unmarshal_String("UTF-16LE");
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof SCompetitionStartBrd)) {
/* 60 */       SCompetitionStartBrd _o_ = (SCompetitionStartBrd)_o1_;
/* 61 */       if (!this.opponent.equals(_o_.opponent)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.opponent.hashCode();
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append("T").append(this.opponent.length()).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SCompetitionStartBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */