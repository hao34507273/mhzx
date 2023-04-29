/*    */ package mzm.gsp.crosscompete;
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
/*    */ public class SCompeteResultBrd
/*    */   extends __SCompeteResultBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616746;
/*    */   public CompeteResultFaction win_faction;
/*    */   public CompeteResultFaction lose_faction;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616746;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCompeteResultBrd()
/*    */   {
/* 34 */     this.win_faction = new CompeteResultFaction();
/* 35 */     this.lose_faction = new CompeteResultFaction();
/*    */   }
/*    */   
/*    */   public SCompeteResultBrd(CompeteResultFaction _win_faction_, CompeteResultFaction _lose_faction_) {
/* 39 */     this.win_faction = _win_faction_;
/* 40 */     this.lose_faction = _lose_faction_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     if (!this.win_faction._validator_()) return false;
/* 45 */     if (!this.lose_faction._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.win_faction);
/* 51 */     _os_.marshal(this.lose_faction);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.win_faction.unmarshal(_os_);
/* 57 */     this.lose_faction.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SCompeteResultBrd)) {
/* 67 */       SCompeteResultBrd _o_ = (SCompeteResultBrd)_o1_;
/* 68 */       if (!this.win_faction.equals(_o_.win_faction)) return false;
/* 69 */       if (!this.lose_faction.equals(_o_.lose_faction)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.win_faction.hashCode();
/* 78 */     _h_ += this.lose_faction.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.win_faction).append(",");
/* 86 */     _sb_.append(this.lose_faction).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SCompeteResultBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */